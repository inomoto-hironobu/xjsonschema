package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.SchemaElementType;

class IntegerType extends BaseKvType<Long> {
	long defaultValue;
	long min;
	long max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
