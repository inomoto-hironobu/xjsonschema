package site.saishin.xjsonschema.typeb.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import site.saishin.xjsonschema.DataType;
import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.typea.SchemaElementType;

public class XJsonSchemaTypeb {

	static final Logger logger = LoggerFactory.getLogger(XJsonSchemaTypeb.class);
	final RootType jsonSchema;

	private XJsonSchemaTypeb(Builder builder) {
		this.jsonSchema = builder.root;
	}

	private XJsonSchemaTypeb(XJsonSchemaTypeb base) {
		this.jsonSchema = base.jsonSchema;
	}

	public void dump() {
		jsonSchema.objects.forEach((s, t) -> {
			System.out.println(s);
			if (t.type() == SchemaElementType.OBJECT) {

			}
		});
	}

	public SchemaElement root() {
		return jsonSchema;
	}

	public static XJsonSchemaTypeb from(XJsonSchemaTypeb value) {
		return new XJsonSchemaTypeb(value);
	}
	public static XJsonSchemaTypeb create(Document d) {
		return new Builder().document(d).build();
	}

	public Visitor newVisitor() {
		return new Visitor(jsonSchema);
	}

	public static class Visitor {
		ObjectType current;
		RootType jsonSchema;

		private Visitor(RootType jsonSchema) {
			this.jsonSchema = jsonSchema;
		}

		SchemaElementType current() {
			return current.type();
		}

		public void next() {

		}

		void root() {

		}

		public void ifObject(Consumer<Visitor> consumer) {
			consumer.andThen((t) -> {
				t.ifObject(consumer);
			}).accept(this);
		}
	}

	static class Builder {
		RootType root;
		Map<String, BaseJsonType> current;
		Document document;
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XJsonSchemaTypeb build() {
			root = new RootType();
			root.objects = new HashMap<String, BaseJsonType>();
			element(document.getDocumentElement());
			return new XJsonSchemaTypeb(this);
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
			case ARRAY:
				ArrayType jarray = new ArrayType();
				jarray.set(attrs);
				if(attrs.getNamedItem("type") != null) {
					jarray.type = DataType.from(elem.getAttribute("type"));
				}
				current.put(jarray.name, jarray);
				break;
			case TYPED_OBJECT:
				TypedObjectType typedjobject = new TypedObjectType();
				typedjobject.set(attrs);
				if(attrs.getNamedItem("type") != null) {
					typedjobject.type = DataType.from(elem.getAttribute("type"));
				}
				current.put(typedjobject.name, typedjobject);
				break;
			case OBJECT:
				ObjectType jsonObject = new ObjectType();
				jsonObject.set(attrs);
				jsonObject.objects = new HashMap<String, BaseJsonType>();
				Map<String, BaseJsonType> tmp = current;
				current = jsonObject.objects;
				NodeList children = elem.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
						element((Element) children.item(i));
					}
				}
				current = tmp;
				current.put(jsonObject.name, jsonObject);
				break;
			default:
				System.err.println(elem);
				break;
			}
		}
	}
}
