package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class ArrayType extends BaseJsonType {
	JsonData type;

	@Override
	public JsonData type() {
		return JsonData.ARRAY;
	}
}
