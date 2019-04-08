package site.saishin.xschema.json.typeb.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.json.typeb.SchemaElement;
import site.saishin.xschema.json.typeb.SchemaElementType;

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
