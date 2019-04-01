package site.saishin.xjsonschema.typeb.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.typea.SchemaElementType;

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