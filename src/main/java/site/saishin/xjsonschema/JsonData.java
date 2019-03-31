package site.saishin.xjsonschema;

public enum JsonData {
	BOOLEAN,INTEGER,NUMBER,STRING,ARRAY,OBJECT,TYPED_OBJECT,NONE;
	
	private JsonData() {

	}
	public static JsonData from(String name) {
		JsonData type;
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
