package site.saishin.xschema.xyamlschema.typed.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import site.saishin.xschema.xkvschema.typec.SchemaElement;
import site.saishin.xschema.xkvschema.typec.SchemaElementType;

public class XKvSchemaTypec {

	static final Logger logger = LoggerFactory.getLogger(XKvSchemaTypec.class);
	final RootType jsonSchema;

	private XKvSchemaTypec(Builder builder) {
		this.jsonSchema = builder.root;
	}

	private XKvSchemaTypec(XKvSchemaTypec base) {
		this.jsonSchema = base.jsonSchema;
	}

	public void dump() {
		jsonSchema.objects.forEach((s, t) -> {
			System.out.println(s);
			
		});
	}

	public SchemaElement root() {
		return jsonSchema;
	}

	public static XKvSchemaTypec from(XKvSchemaTypec value) {
		return new XKvSchemaTypec(value);
	}
	public static XKvSchemaTypec create(Document d) {
		return new Builder().document(d).build();
	}

	static class Builder {
		RootType root;
		Map<String, BaseKvType> current;
		Document document;
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XKvSchemaTypec build() {
			root = new RootType();
			root.objects = new HashMap<String, BaseKvType>();
			element(document.getDocumentElement());
			return new XKvSchemaTypec(this);
		}

		private void element(Element elem) {
			NamedNodeMap attrs = elem.getAttributes();
			switch (SchemaElementType.from(elem.getNodeName())) {
			case STRING:
				StringType jstring = new StringType();
				jstring.set(attrs);
				current.put(jstring.name, jstring);
				break;
			case NUMBER:
				NumberType jnumber = new NumberType();
				jnumber.set(attrs);
				current.put(jnumber.name, jnumber);
				break;
			case INTEGER:
				IntegerType jinteger = new IntegerType();
				jinteger.set(attrs);
				current.put(jinteger.name, jinteger);
				break;
			case BOOLEAN:
				BooleanType jboolean = new BooleanType();
				jboolean.set(attrs);
				current.put(jboolean.name, jboolean);
				break;
			default:
				System.err.println(elem);
				break;
			}
		}
	}
}
