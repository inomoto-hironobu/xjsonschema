package site.saishin.xschema.yaml;

public enum SchemaElementType {
	BOOLEAN,INTEGER,NUMBER,STRING,SEQUENCE,MAPPING,TYPED_OBJECT,ROOT,NONE;
	
	private SchemaElementType() {

	}
	public static SchemaElementType from(String name) {
		SchemaElementType type;
		switch (name) {
		case "object":
			type = MAPPING;
			break;
		case "typed-object":
			type = TYPED_OBJECT;
			break;
		case "array":
			type = SEQUENCE;
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
		case "yaml-schema":
			type = ROOT;
			break;
		default:
			type = NONE;
			break;
		}
		return type;
	}

}
