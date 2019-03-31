package site.saishin.xjsonschema;

public enum JsonDataType {
	BOOLEAN,INTEGER,NUMBER,STRING,ARRAY,OBJECT,TYPED_OBJECT,NONE;
	
	private JsonDataType() {

	}
	public static JsonDataType from(String name) {
		JsonDataType type;
		switch (name) {
		case "object":
			type = OBJECT;
			break;
		case "typed-object":
			type = TYPED_OBJECT;
			break;
		case "array":
			type = ARRAY;
			break;
		case "integer":
			type = INTEGER;
			break;
		case "number":
			type = NUMBER;
			break;
		case "boolean":
			type = BOOLEAN;
			break;
		case "string":
			type = STRING;
			break;
		default:
			type = NONE;
			break;
		}
		return type;
	}

}
