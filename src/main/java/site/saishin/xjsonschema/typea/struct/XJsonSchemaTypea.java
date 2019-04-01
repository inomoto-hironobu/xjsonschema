package site.saishin.xjsonschema.typea.struct;

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

import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.typea.SchemaElementType;

public class XJsonSchemaTypea {

	static final Logger logger = LoggerFactory.getLogger(XJsonSchemaTypea.class);
	final RootType jsonSchema;

	private XJsonSchemaTypea(Builder builder) {
		this.jsonSchema = builder.root;
	}

	private XJsonSchemaTypea(XJsonSchemaTypea base) {
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

	public static XJsonSchemaTypea from(XJsonSchemaTypea value) {
		return new XJsonSchemaTypea(value);
	}
	public static XJsonSchemaTypea create(Document d) {
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
		Map<Typable, String> refs;
		
		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XJsonSchemaTypea build() {
			Objects.requireNonNull(document);
			refs = new HashMap<>();
			root = new RootType();
			root.objects = new HashMap<String, BaseJsonType>();
			NodeList children = document.getDocumentElement().getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element child = (Element) children.item(i);
					if (child.getNodeName().equals("def")) {
						Def def = new Def();
						def.objects = new HashMap<String, BaseJsonType>();
						current = def.objects;
						Map<String, BaseJsonType> tmp = current;
						NodeList defchildren = child.getChildNodes();
						for (int j = 0; j < defchildren.getLength(); j++) {
							if (defchildren.item(j).getNodeType() == Node.ELEMENT_NODE) {
								element((Element) defchildren.item(j));
							}
						}
						current = tmp;
						root.defs.put(child.getAttribute("id"), def);
					} else {
						current = root.objects;
						element(child);
					}
				}
			}
			refs.forEach((Typable t, String s) -> {
				t.setDef(root.defs.get(s));
			});
			return new XJsonSchemaTypea(this);
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
				jarray.setType(elem, refs);
				current.put(jarray.name, jarray);
				break;
			case TYPED_OBJECT:
				TypedObjectType typedjobject = new TypedObjectType();
				typedjobject.set(attrs);
				typedjobject.setType(elem, refs);
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
