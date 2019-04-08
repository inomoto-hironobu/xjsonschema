package site.saishin.xschema.json.typeb.struct;

import site.saishin.xschema.json.typeb.SchemaElementType;

class NumberType extends PrimitiveType {
	float min;
	float max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
