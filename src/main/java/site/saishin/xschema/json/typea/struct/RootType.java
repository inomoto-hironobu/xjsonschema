package site.saishin.xschema.json.typea.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.json.typea.SchemaElement;
import site.saishin.xschema.json.typea.SchemaElementType;

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