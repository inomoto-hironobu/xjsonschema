package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.DataType;

class IntegerType extends BaseKvType<Long> {
	long defaultValue;
	long min;
	long max;
	@Override
	public DataType type() {
		return DataType.INTEGER;
	}
}
