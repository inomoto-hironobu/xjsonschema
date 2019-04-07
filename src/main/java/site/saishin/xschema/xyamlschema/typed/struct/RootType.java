package site.saishin.xschema.xyamlschema.typed.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.xkvschema.typec.SchemaElement;
import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class RootType implements SchemaElement {
	String name;
	Map<String, BaseKvType> objects;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ROOT;
	}
	@Override
	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}
}