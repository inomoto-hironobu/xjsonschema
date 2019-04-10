package site.saishin.xschema.kv.typec.struct;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import site.saishin.xschema.kv.typec.DataType;
import site.saishin.xschema.kv.typec.SchemaElement;
import site.saishin.xschema.kv.typec.SchemaElementType;

public class XKvSchemaTypec {

	static final Logger logger = LoggerFactory.getLogger(XKvSchemaTypec.class);
	final RootType kvSchema;
	final static String MIN = "min";
	final static String MAX = "max";
	final static String DEFAULT = "default";
	
	private XKvSchemaTypec(Builder builder) {
		this.kvSchema = builder.root;
	}

	private XKvSchemaTypec(XKvSchemaTypec base) {
		this.kvSchema = base.kvSchema;
	}

	public void dump() {
		kvSchema.map.forEach((s, t) -> {
			System.out.println(s);
			
		});
	}

	public SchemaElement root() {
		return kvSchema;
	}

	public static XKvSchemaTypec from(XKvSchemaTypec value) {
		return new XKvSchemaTypec(value);
	}
	public static XKvSchemaTypec create(Document d) {
		return new Builder().document(d).build();
	}

	static class Builder {
		RootType root;
		Document document;
		NamedNodeMap attrs;
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XKvSchemaTypec build() {
			root = new RootType();
			root.map = new HashMap<String, BaseKvType<?>>();
			Element rootElement = document.getDocumentElement();
			root.name = rootElement.getAttribute("name");
			NodeList children = rootElement.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				children.item(i).getNodeType();
				if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					element((Element) children.item(i));
				}
			}
			return new XKvSchemaTypec(this);
		}

		private void set(BaseKvType<?> type) {
			pre("name").ifPresent(s -> type.name = s);
			pre("nullable").ifPresent(s -> type.nullable = Boolean.parseBoolean(s));
			pre("required").ifPresent(s -> type.required = Boolean.parseBoolean(s));
			root.map.put(type.name, type);
		}
		private Optional<String> pre(String name) {
			if(attrs.getNamedItem(name) != null) {
				return Optional.of(attrs.getNamedItem(name).getNodeValue());
			}
			return Optional.empty();
		}
		
		private void element(Element elem) {
			attrs = elem.getAttributes();
			switch (DataType.from(elem.getNodeName())) {
			case STRING:
				StringType jstring = new StringType();
				pre("default").ifPresent(s -> jstring.defaultValue = s);
				set(jstring);
				break;
			case DECIMAL:
				DecimalType jnumber = new DecimalType();
				pre("default").ifPresent(s -> jnumber.defaultValue = new BigDecimal(s));
				pre(MIN).ifPresent(s -> jnumber.min = new BigDecimal(s));
				pre(MAX).ifPresent(s -> jnumber.max = new BigDecimal(s));
				set(jnumber);
				break;
			case INTEGER:
				IntegerType jinteger = new IntegerType();
				pre(DEFAULT).ifPresent(s -> jinteger.defaultValue = Long.parseLong(s));
				pre(MIN).ifPresent(s -> jinteger.min = Long.parseLong(s));
				pre(MAX).ifPresent(s -> jinteger.max = Long.parseLong(s));
				set(jinteger);
				break;
			case BOOLEAN:
				BooleanType jboolean = new BooleanType();
				pre(DEFAULT).ifPresent(s -> jboolean.defaultValue = Boolean.parseBoolean(s));
				set(jboolean);
				break;
			case MAIL_ADDRESS:
				break;
			default:
				System.err.println(elem);
				break;
			}
		}
	}
}
