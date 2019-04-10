package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.SchemaElementType;

class BooleanType extends BaseKvType<Boolean> {
	boolean defaultValue;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
