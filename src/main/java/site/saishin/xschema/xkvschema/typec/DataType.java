package site.saishin.xschema.xkvschema.typec;

public enum DataType {
	BOOLEAN,INTEGER,NUMBER,STRING;
	public static DataType from(String name) {
		DataType type;
		switch (name) {
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
