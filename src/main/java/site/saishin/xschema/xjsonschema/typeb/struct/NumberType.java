package site.saishin.xschema.xjsonschema.typeb.struct;

import site.saishin.xschema.xjsonschema.typeb.SchemaElementType;

class NumberType extends PrimitiveType {
	float min;
	float max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
