package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class BooleanType extends BaseKvType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
