package site.saishin.xschema.json.typeb.struct;

import site.saishin.xschema.json.typeb.SchemaElementType;

class IntegerType extends PrimitiveType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
