package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.JsonData;

class StringType extends PrimitiveType {

	@Override
	public JsonData type() {
		return JsonData.STRING;
	}
}
