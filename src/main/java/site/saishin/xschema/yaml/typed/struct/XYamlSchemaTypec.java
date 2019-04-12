package site.saishin.xschema.yaml.typed.struct;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import site.saishin.xschema.yaml.DataType;
import site.saishin.xschema.yaml.Root;

public class XYamlSchemaTypec {

	static final Logger logger = LoggerFactory.getLogger(XYamlSchemaTypec.class);
	final Root root;

	private XYamlSchemaTypec(Builder builder) {
		this.root = builder.root;
	}

	private XYamlSchemaTypec(XYamlSchemaTypec base) {
		this.root = base.root;
	}

	public Root root() {
		return root;
	}

	public static XYamlSchemaTypec from(XYamlSchemaTypec value) {
		return new XYamlSchemaTypec(value);
	}
	public static XYamlSchemaTypec create(Document d) {
		return new Builder().document(d).build();
	}

	static class Builder {
		RootType root;
		Map<String, BaseYamlType> current;
		Document document;
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XYamlSchemaTypec build() {
			root = new RootType();
			//root.objects = new HashMap<String, BaseYamlType>();
			element(document.getDocumentElement());
			return new XYamlSchemaTypec(this);
		}

		private void element(Element elem) {
			NamedNodeMap attrs = elem.getAttributes();
			switch (DataType.from(elem.getNodeName())) {
			case STRING:
				StringType jstring = new StringType();
				jstring.set(attrs);
				current.put(jstring.name, jstring);
				break;
			case FLOAT:
				FloatType jnumber = new FloatType();
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
