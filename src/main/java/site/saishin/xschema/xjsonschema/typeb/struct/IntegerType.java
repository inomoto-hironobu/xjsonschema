package site.saishin.xschema.xjsonschema.typeb.struct;

import site.saishin.xschema.xjsonschema.typeb.SchemaElementType;

class IntegerType extends PrimitiveType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
