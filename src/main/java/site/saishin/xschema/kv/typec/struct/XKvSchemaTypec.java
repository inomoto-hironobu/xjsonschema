package site.saishin.xschema.kv.typec.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import site.saishin.xschema.kv.typec.SchemaElement;
import site.saishin.xschema.kv.typec.SchemaElementType;

public class XKvSchemaTypec {

	static final Logger logger = LoggerFactory.getLogger(XKvSchemaTypec.class);
	final RootType kvSchema;

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
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XKvSchemaTypec build() {
			root = new RootType();
			root.map = new HashMap<String, BaseKvType>();
			Element rootElement = document.getDocumentElement();
			NodeList children = rootElement.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				children.item(i).getNodeType();
				if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					element((Element) children.item(i));
				}
			}
			return new XKvSchemaTypec(this);
		}

		private void element(Element elem) {
			NamedNodeMap attrs = elem.getAttributes();
			switch (SchemaElementType.from(elem.getNodeName())) {
			case STRING:
				StringType jstring = new StringType();
				jstring.set(attrs);
				root.map.put(jstring.name, jstring);
				break;
			case NUMBER:
				DecimalType jnumber = new DecimalType();
				jnumber.set(attrs);
				root.map.put(jnumber.name, jnumber);
				break;
			case INTEGER:
				IntegerType jinteger = new IntegerType();
				jinteger.set(attrs);
				root.map.put(jinteger.name, jinteger);
				break;
			case BOOLEAN:
				BooleanType jboolean = new BooleanType();
				jboolean.set(attrs);
				root.map.put(jboolean.name, jboolean);
				break;
			default:
				System.err.println(elem);
				break;
			}
		}
	}
}
