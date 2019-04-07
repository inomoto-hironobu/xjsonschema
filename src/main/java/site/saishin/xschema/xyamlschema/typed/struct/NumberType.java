package site.saishin.xschema.xyamlschema.typed.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class NumberType extends BaseKvType {
	float min;
	float max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
