package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class BooleanType extends PrimitiveType {
	@Override
	public JsonData type() {
		return JsonData.BOOLEAN;
	}
}
