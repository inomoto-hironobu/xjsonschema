package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class JsonNumber extends PrimitiveType {

	@Override
	public JsonDataType type() {
		return JsonDataType.NUMBER;
	}
}
