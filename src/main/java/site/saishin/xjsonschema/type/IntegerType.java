package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class IntegerType extends PrimitiveType {

	@Override
	public JsonData type() {
		return JsonData.INTEGER;
	}
}
