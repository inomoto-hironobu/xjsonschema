package site.saishin.xschema.json.typeb.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.json.typeb.SchemaElement;
import site.saishin.xschema.json.typeb.SchemaElementType;

class RootType implements SchemaElement {
	String name;
	Map<String, BaseJsonType> objects;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ROOT;
	}
	@Override
	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}
}