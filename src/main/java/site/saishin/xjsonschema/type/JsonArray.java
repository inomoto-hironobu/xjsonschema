package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class JsonArray extends BaseJsonType {
	JsonDataType type;

	@Override
	public JsonDataType type() {
		return JsonDataType.ARRAY;
	}
}
