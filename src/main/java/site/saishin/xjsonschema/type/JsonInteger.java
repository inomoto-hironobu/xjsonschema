package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class JsonInteger extends PrimitiveType {

	@Override
	public JsonDataType type() {
		return JsonDataType.INTEGER;
	}
}
