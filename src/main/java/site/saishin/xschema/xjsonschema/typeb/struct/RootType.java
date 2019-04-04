package site.saishin.xschema.xjsonschema.typeb.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.xjsonschema.typeb.SchemaElementType;
import site.saishin.xschema.xjsonschema.typeb.SchemaElement;

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