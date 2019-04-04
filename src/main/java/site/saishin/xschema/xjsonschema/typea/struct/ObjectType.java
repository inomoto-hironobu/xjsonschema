package site.saishin.xschema.xjsonschema.typea.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.xjsonschema.typea.SchemaElement;
import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class ObjectType extends BaseJsonType {
	Map<String, BaseJsonType> objects;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.OBJECT;
	}
	@Override
	public Optional<SchemaElement> ifObjetGet(String key) {
		return Optional.of(objects.get(key));
	}
}
