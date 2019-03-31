package site.saishin.xjsonschema.type;

import java.util.Map;
import java.util.Optional;

import site.saishin.xjsonschema.JsonData;
import site.saishin.xjsonschema.JsonType;

class ObjectType extends BaseJsonType {
	Map<String, BaseJsonType> objects;
	@Override
	public JsonData type() {
		return JsonData.OBJECT;
	}
	@Override
	public Optional<JsonType> ifObjetGet(String key) {
		return Optional.of(objects.get(key));
	}
}
