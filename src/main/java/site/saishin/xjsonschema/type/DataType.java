package site.saishin.xjsonschema.type;

enum DataType {
	BOOLEAN,INTEGER,NUMBER,STRING,ARRAY,OBJECT;
	public static DataType from(String name) {
		DataType type;
		switch (name) {
		case "object":
			type = OBJECT;
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
			type = null;
			break;
		}
		return type;
	}

}
