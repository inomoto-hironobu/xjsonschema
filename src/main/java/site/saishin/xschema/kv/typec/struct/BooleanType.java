package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.DataType;

class BooleanType extends BaseKvType<Boolean> {
	boolean defaultValue;
	@Override
	public DataType type() {
		return DataType.BOOLEAN;
	}
}
