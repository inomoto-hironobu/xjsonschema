package site.saishin.xschema.yaml.typed.struct;

import java.time.OffsetDateTime;

import site.saishin.xschema.yaml.SchemaElementType;

class TimestampType extends ScalaType {
	OffsetDateTime min;
	OffsetDateTime max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
