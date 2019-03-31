package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class TypedObjectType extends BaseJsonType {
	JsonData type;
	@Override
	public JsonData type() {
		return JsonData.TYPED_OBJECT;
	}
}
