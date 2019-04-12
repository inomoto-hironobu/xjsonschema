package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.DataType;

class StringType extends BaseKvType<String> {
	int min;
	int max;
	String defaultValue;
	@Override
	public DataType type() {
		return DataType.STRING;
	}
}
