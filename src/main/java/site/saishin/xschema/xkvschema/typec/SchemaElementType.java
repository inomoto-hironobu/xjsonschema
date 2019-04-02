package site.saishin.xschema.xkvschema.typec;

public enum SchemaElementType {
	BOOLEAN,INTEGER,NUMBER,STRING,ROOT,NONE;
	
	private SchemaElementType() {

	}
	public static SchemaElementType from(String name) {
		SchemaElementType type;
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
		case "key-value-schema":
			type = ROOT;
			break;
		default:
			type = NONE;
			break;
		}
		return type;
	}

}
