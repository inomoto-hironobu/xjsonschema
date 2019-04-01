package site.saishin.xjsonschema.typea;

public enum SchemaElementType {
	BOOLEAN,INTEGER,NUMBER,STRING,ARRAY,OBJECT,TYPED_OBJECT,DEF,ROOT,NONE;
	
	private SchemaElementType() {

	}
	public static SchemaElementType from(String name) {
		SchemaElementType type;
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
		case "def":
			type = DEF;
			break;
		case "json-schema":
			type = ROOT;
			break;
		default:
			type = NONE;
			break;
		}
		return type;
	}

}
