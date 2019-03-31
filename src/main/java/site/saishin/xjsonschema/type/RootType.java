package site.saishin.xjsonschema.type;

import java.util.Map;
import java.util.Optional;

import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.SchemaElementType;

class RootType implements SchemaElement {
	String name;
	Map<String, BaseJsonType> objects;
	Map<String, Def> defs;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ROOT;
	}
	@Override
	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}
}