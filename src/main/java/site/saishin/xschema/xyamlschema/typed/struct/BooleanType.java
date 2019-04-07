package site.saishin.xschema.xyamlschema.typed.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class BooleanType extends BaseKvType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
