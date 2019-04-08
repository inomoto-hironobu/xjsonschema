package site.saishin.xschema.yaml;

public enum DataType {
	BOOLEAN,INTEGER,FLOAT,STRING,SEQUENCE,MAPPING,DATE,TIMESTAMP;
	public static DataType from(String name) {
		DataType type;
		switch (name) {
		case "mapping":
			type = MAPPING;
			break;
		case "sequence":
			type = SEQUENCE;
			break;
		case "integer":
			type = INTEGER;
			break;
		case "float":
			type = FLOAT;
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
		case "timestamp":
			type = TIMESTAMP;
			break;
		default:
			throw new IllegalArgumentException(name);
		}
		return type;
	}

}
