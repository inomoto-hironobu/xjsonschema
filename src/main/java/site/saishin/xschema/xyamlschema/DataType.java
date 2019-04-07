package site.saishin.xschema.xyamlschema;

public enum DataType {
	BOOLEAN,INTEGER,NUMBER,STRING,ARRAY,OBJECT,DATE,TIMESTAMP;
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
		case "date":
			type = DATE;
			break;
		default:
			throw new IllegalArgumentException(name);
		}
		return type;
	}

}
