package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class IntegerType extends PrimitiveType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
