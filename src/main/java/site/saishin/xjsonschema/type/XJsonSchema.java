package site.saishin.xjsonschema.type;

import java.io.IOException;
import java.io.InputStream;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import site.saishin.xjsonschema.JsonDataType;

public class XJsonSchema {

	private static final Logger logger = LoggerFactory.getLogger(XJsonSchema.class);
	final JsonSchema jsonSchema;
	JsonObject currentObject;
	JsonDataType currentDataType = JsonDataType.OBJECT;
	String currentname;
	Deque<JsonObject> stack;
	boolean valid;
	JsonToken currentToken;
	JsonParser parser;

	private XJsonSchema(Builder builder) {
		this.jsonSchema = builder.jsonschema;
	}

	private XJsonSchema(XJsonSchema base) {
		this.jsonSchema = base.jsonSchema;
	}

	public void dump() {
		jsonSchema.objects.forEach((s, t) -> {
			System.out.println(s);
			if (t.type() == JsonDataType.OBJECT) {

			}
		});
	}

	public static XJsonSchema create(Document d) {
		return builder().document(d).build();
	}

	void execArray() throws IOException {
		boolean notNull = true;
		int depth = 1;
		currentToken = parser.nextToken();
		while (notNull) {
			logger.debug("depth:{}", depth);
			if (currentToken == JsonToken.START_ARRAY) {
				depth++;
			} else if (currentToken == JsonToken.END_ARRAY) {
				depth--;
				if (depth < 1) {
					return;
				}
			} else {
				logger.debug("execArray:{}", currentToken);
			}
			currentToken = parser.nextToken();
			notNull = currentToken != null;
		}
	}

	void execTypedObject(JsonDataType tjson) throws IOException {
		logger.debug("execTypedObject:{}:{}", tjson, currentToken.name());
		currentname = parser.getCurrentName();
		valid = true;
		boolean notNull = currentToken != null;
		while (notNull) {
			if (currentToken != JsonToken.FIELD_NAME) {
				logger.debug("exec while:{}", currentToken.name());
				valid = test(currentToken, tjson);
			}
			if (!valid)
				return;
			currentToken = parser.nextToken();
			notNull = currentToken != null;
		}
	}

	boolean test(JsonToken token, JsonDataType type) throws IOException {
		logger.debug("test:{}:{}", token.name(), type);
		if (token.isBoolean() && type == JsonDataType.BOOLEAN) {
			return true;
		} else if (token == JsonToken.VALUE_STRING && type == JsonDataType.STRING) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_INT && type == JsonDataType.NUMBER) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_FLOAT && type == JsonDataType.NUMBER) {
			return true;
		} else if (token == JsonToken.START_OBJECT && type == JsonDataType.OBJECT) {
			execOjbectWithoutValidation();
			return true;
		} else if (token == JsonToken.START_ARRAY && type == JsonDataType.ARRAY) {
			execArray();
			return true;
		}
		return false;
	}

	void execOjbectWithoutValidation() throws IOException {
		boolean notNull = currentToken != null;
		while (notNull) {
			if (currentToken == JsonToken.END_OBJECT) {
				return;
			} else if (currentToken == JsonToken.START_OBJECT) {
				execOjbectWithoutValidation();
			} else {
				logger.debug("execOjbectWithoutValidation:{}", currentToken);
			}
			currentToken = parser.nextToken();
			notNull = currentToken != null;
		}
	}

	void execObject() throws IOException {
		boolean notNull = true;
		logger.debug("execObject:{}:{}", currentToken, currentObject.name);
		while (notNull) {
			currentToken = parser.nextToken();
			currentname = parser.getCurrentName();

			logger.debug("begin:{}:{}:{}:{}", currentToken, currentname, currentObject.name,
					parser.getCurrentLocation().getLineNr());
			if (currentToken == JsonToken.FIELD_NAME) {
				valid = currentObject.objects.containsKey(currentname);
				if (valid) {
					currentDataType = currentObject.objects.get(currentname).type();
				} else {
					logger.error(currentname);
					currentObject.objects.forEach((s, t) -> {
						System.err.println("a :" + s);
					});
					break;
				}
			} else if (currentToken == JsonToken.START_OBJECT) {
				valid = currentDataType == JsonDataType.OBJECT;
				if (currentDataType == JsonDataType.TYPED_OBJECT) {
					currentToken = parser.nextToken();
					execTypedObject(((TypedJsonObject) currentObject.objects.get(currentname)).type);
				} else {
					currentObject = (JsonObject) currentObject.objects.get(currentname);
					execObject();
					stack.addFirst(currentObject);
				}
			} else if (currentToken == JsonToken.END_OBJECT) {
				currentObject = stack.removeFirst();
				currentname = parser.getCurrentName();
				return;
			} else if (currentToken == JsonToken.START_ARRAY) {
				valid = currentDataType == JsonDataType.ARRAY;
				execArray();
			} else if (currentToken == JsonToken.END_ARRAY) {
				logger.error("");
			} else {
				switch (currentToken) {
				case VALUE_FALSE:
					valid = currentDataType == JsonDataType.BOOLEAN;
					break;
				case VALUE_TRUE:
					valid = currentDataType == JsonDataType.BOOLEAN;
					break;
				case VALUE_NUMBER_INT:
					valid = currentDataType == JsonDataType.INTEGER;
					break;
				case VALUE_NUMBER_FLOAT:
					valid = currentDataType == JsonDataType.NUMBER;
					break;
				case VALUE_STRING:
					valid = currentDataType == JsonDataType.STRING;
					break;
				case VALUE_NULL:
					valid = currentObject.nullable;
					break;
				default:
					System.err.println("処理ミス");
					break;
				}
			}
			logger.debug("end:{}:{}:{}:{}:{}", currentToken, currentname, currentObject.name, currentDataType,
					parser.getCurrentLocation().getLineNr());
			notNull = currentToken != null;
		}
	}

	void execStruct() {

	}

	public boolean validate(InputStream json) {
		JsonFactory f = new JsonFactory();
		f.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
		try {
			parser = f.createParser(json);
			System.out.println("始まり" + currentToken);
			currentObject = jsonSchema;
			stack = new LinkedList<>();
			stack.addFirst(jsonSchema);
			currentToken = parser.nextToken();
			execObject();
		} catch (IOException e) {
			logger.error("error", e);
		}
		return valid;
	}

	private static Builder builder() {
		return new Builder();
	}

	static class Builder {
		JsonSchema jsonschema;
		Map<String, BaseJsonType> current;
		Document document;

		Builder document(Document value) {
			Objects.requireNonNull(value);
			document = value;
			return this;
		}

		XJsonSchema build() {
			Element root = document.getDocumentElement();
			jsonschema = new JsonSchema();
			jsonschema.objects = new HashMap<String, BaseJsonType>();
			jsonschema.set(root.getAttributes());
			current = jsonschema.objects;
			NodeList children = root.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					element((Element) children.item(i));
				}
			}
			return new XJsonSchema(this);
		}

		private void element(Element elem) {
			NamedNodeMap attrs = elem.getAttributes();
			switch (JsonDataType.from(elem.getNodeName())) {
			case STRING:
				JsonString jstring = new JsonString();
				jstring.set(attrs);
				current.put(jstring.name, jstring);
				break;
			case NUMBER:
				JsonNumber jnumber = new JsonNumber();
				jnumber.set(attrs);
				current.put(jnumber.name, jnumber);
				break;
			case INTEGER:
				JsonInteger jinteger = new JsonInteger();
				jinteger.set(attrs);
				current.put(jinteger.name, jinteger);
				break;
			case BOOLEAN:
				JsonBoolean jboolean = new JsonBoolean();
				jboolean.set(attrs);
				current.put(jboolean.name, jboolean);
				break;
			case ARRAY:
				JsonArray jarray = new JsonArray();
				jarray.set(attrs);
				if (attrs.getNamedItem("type") != null) {
					jarray.type = JsonDataType.from(attrs.getNamedItem("type").getNodeValue());
				}
				current.put(jarray.name, jarray);
				break;
			case TYPED_OBJECT:
				TypedJsonObject typedjobject = new TypedJsonObject();
				typedjobject.set(attrs);
				if (attrs.getNamedItem("type") != null) {
					typedjobject.type = JsonDataType.from(attrs.getNamedItem("type").getNodeValue());
				}
				current.put(typedjobject.name, typedjobject);
				break;
			case OBJECT:
				JsonObject jsonObject = new JsonObject();
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
