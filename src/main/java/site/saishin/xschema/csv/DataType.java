package site.saishin.xschema.csv;

public enum DataType {
	BOOLEAN,INTEGER,DECIMAL,STRING;
	public static DataType from(String name) {
		DataType type;
		switch (name) {
		case "integer":
			type = INTEGER;
			break;
		case "decimal":
			type = DECIMAL;
			break;
		case "boolean":
			type = BOOLEAN;
			break;
		case "string":
			type = STRING;
			break;
		default:
			throw new IllegalArgumentException(name);
		}
		return type;
	}

}
