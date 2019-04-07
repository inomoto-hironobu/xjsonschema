package site.saishin.xschema.xyamlschema.typed.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class IntegerType extends BaseKvType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
