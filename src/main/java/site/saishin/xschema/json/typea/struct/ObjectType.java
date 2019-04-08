package site.saishin.xschema.json.typea.struct;

import java.util.Map;
import java.util.Optional;

import site.saishin.xschema.json.typea.SchemaElement;
import site.saishin.xschema.json.typea.SchemaElementType;

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
