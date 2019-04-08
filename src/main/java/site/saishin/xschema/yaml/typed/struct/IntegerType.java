package site.saishin.xschema.yaml.typed.struct;

import site.saishin.xschema.yaml.SchemaElementType;

class IntegerType extends ScalaType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
