package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class JsonString extends PrimitiveType {

	@Override
	public JsonDataType type() {
		return JsonDataType.STRING;
	}
}
