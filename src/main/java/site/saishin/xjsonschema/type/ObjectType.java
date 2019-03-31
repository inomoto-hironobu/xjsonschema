package site.saishin.xjsonschema.type;

import java.util.Map;
import java.util.Optional;

import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.SchemaElementType;

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
