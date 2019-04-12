package site.saishin.xschema.kv.typec.struct;

import static site.saishin.domhelper.DomUtil.pullAttrValue;
import static site.saishin.xschema.XSchemaConstants.DEFAULT;
import static site.saishin.xschema.XSchemaConstants.MAX;
import static site.saishin.xschema.XSchemaConstants.MIN;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import site.saishin.domhelper.DomUtil;
import site.saishin.xschema.kv.typec.DataType;
import site.saishin.xschema.kv.typec.Root;

public class XKvSchemaTypec {

	static final Logger logger = LoggerFactory.getLogger(XKvSchemaTypec.class);
	final RootType root;
	
	private XKvSchemaTypec(Builder builder) {
		this.root = builder.root;
	}

	private XKvSchemaTypec(XKvSchemaTypec base) {
		this.root = base.root;
	}

	public Root root() {
		return root;
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
		Element target;
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XKvSchemaTypec build() {
			root = new RootType();
			root.map = new HashMap<String, BaseKvType<?>>();
			Element rootElement = document.getDocumentElement();
			DomUtil.execElemChildren(rootElement, e -> {
				element(e);
			});
			root.name = rootElement.getAttribute("name");
			return new XKvSchemaTypec(this);
		}

		private void set(BaseKvType<?> type) {
			pullAttrValue(target, "name").ifPresent(v -> type.name = v);
			pullAttrValue(target, "nullable").ifPresent(v -> type.nullable = Boolean.parseBoolean(v));
			pullAttrValue(target, "required").ifPresent(v -> type.required = Boolean.parseBoolean(v));
			root.map.put(type.name, type);
		}
		
		private void element(Element elem) {
			target = elem;
			switch (DataType.from(elem.getNodeName())) {
			case BOOLEAN:
				BooleanType jboolean = new BooleanType();
				pullAttrValue(elem, DEFAULT).ifPresent(s -> jboolean.defaultValue = Boolean.parseBoolean(s));
				set(jboolean);
				break;
			case INTEGER:
				IntegerType jinteger = new IntegerType();
				pullAttrValue(elem, DEFAULT).ifPresent(s -> jinteger.defaultValue = Long.parseLong(s));
				pullAttrValue(elem, MIN).ifPresent(s -> jinteger.min = Long.parseLong(s));
				pullAttrValue(elem, MAX).ifPresent(s -> jinteger.max = Long.parseLong(s));
				set(jinteger);
				break;
			case DECIMAL:
				DecimalType jnumber = new DecimalType();
				pullAttrValue(elem, DEFAULT).ifPresent(s -> jnumber.defaultValue = new BigDecimal(s));
				pullAttrValue(elem, MIN).ifPresent(s -> jnumber.min = new BigDecimal(s));
				pullAttrValue(elem, MAX).ifPresent(s -> jnumber.max = new BigDecimal(s));
				set(jnumber);
				break;
			case STRING:
				StringType jstring = new StringType();
				pullAttrValue(elem, DEFAULT).ifPresent(s -> jstring.defaultValue = s);
				pullAttrValue(elem, MIN).ifPresent(s -> jstring.min = Integer.parseInt(s));
				pullAttrValue(elem, MAX).ifPresent(s -> jstring.max = Integer.parseInt(s));
				set(jstring);
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
