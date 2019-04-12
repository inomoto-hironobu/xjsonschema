package site.saishin.xschema.kv.typec.struct;

import java.math.BigDecimal;

import site.saishin.xschema.kv.typec.DataType;

class DecimalType extends BaseKvType<BigDecimal> {
	BigDecimal defaultValue;
	BigDecimal min;
	BigDecimal max;
	@Override
	public DataType type() {
		return DataType.DECIMAL;
	}
}
