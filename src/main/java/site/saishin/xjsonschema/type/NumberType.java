package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

class NumberType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
