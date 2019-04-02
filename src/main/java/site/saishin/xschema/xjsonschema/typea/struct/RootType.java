package site.saishin.xschema.xjsonschema.typea.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.xjsonschema.SchemaElement;
import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

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