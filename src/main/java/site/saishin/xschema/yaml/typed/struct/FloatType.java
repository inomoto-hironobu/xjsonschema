package site.saishin.xschema.yaml.typed.struct;

import site.saishin.xschema.yaml.SchemaElementType;

class FloatType extends ScalaType {
	float min;
	float max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
