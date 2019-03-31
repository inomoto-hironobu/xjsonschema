package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonDataType;

class JsonBoolean extends PrimitiveType {
	@Override
	public JsonDataType type() {
		return JsonDataType.BOOLEAN;
	}
}
