package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class NumberType extends BaseKvType {
	float min;
	float max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
