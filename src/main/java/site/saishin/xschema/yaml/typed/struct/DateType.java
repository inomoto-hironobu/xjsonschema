package site.saishin.xschema.yaml.typed.struct;

import java.time.LocalDate;

import site.saishin.xschema.yaml.SchemaElementType;

class DateType extends ScalaType {
	LocalDate min;
	LocalDate max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
