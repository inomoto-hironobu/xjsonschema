package site.saishin.xschema.yaml.typed.struct;

import site.saishin.xschema.yaml.SchemaElementType;

class BooleanType extends BaseYamlType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
