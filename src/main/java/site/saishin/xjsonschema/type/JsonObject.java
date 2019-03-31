package site.saishin.xjsonschema.type;

import java.util.Map;

import site.saishin.xjsonschema.JsonDataType;

class JsonObject extends BaseJsonType {
	Map<String, BaseJsonType> objects;
	@Override
	public JsonDataType type() {
		return JsonDataType.OBJECT;
	}
}
