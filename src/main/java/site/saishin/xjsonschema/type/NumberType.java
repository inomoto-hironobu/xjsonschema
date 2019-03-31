package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class NumberType extends PrimitiveType {

	@Override
	public JsonData type() {
		return JsonData.NUMBER;
	}
}
