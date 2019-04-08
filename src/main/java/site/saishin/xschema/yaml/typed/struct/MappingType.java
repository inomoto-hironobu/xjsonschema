package site.saishin.xschema.yaml.typed.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.yaml.SchemaElement;
import site.saishin.xschema.yaml.SchemaElementType;

class MappingType extends BaseYamlType {
	Map<String, BaseYamlType> contents;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.MAPPING;
	}
	@Override
	public Optional<SchemaElement> ifObjetGet(String key) {
		return Optional.of(contents.get(key));
	}
}
