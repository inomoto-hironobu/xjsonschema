package site.saishin.xschema.kv.typec.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.kv.typec.SchemaElement;
import site.saishin.xschema.kv.typec.SchemaElementType;

class RootType implements SchemaElement {
	String name;
	Map<String, BaseKvType> map;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ROOT;
	}
	@Override
	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}
}