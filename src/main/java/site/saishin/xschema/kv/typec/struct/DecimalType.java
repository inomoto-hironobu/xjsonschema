package site.saishin.xschema.kv.typec.struct;

import java.math.BigDecimal;

import site.saishin.xschema.kv.typec.SchemaElementType;

class DecimalType extends BaseKvType<BigDecimal> {
	BigDecimal defaultValue;
	BigDecimal min;
	BigDecimal max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.DECIMAL;
	}
}
