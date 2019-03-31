package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class TypedJsonObject extends BaseJsonType {
	JsonDataType type;
	@Override
	JsonDataType type() {
		return JsonDataType.TYPED_OBJECT;
	}

}
