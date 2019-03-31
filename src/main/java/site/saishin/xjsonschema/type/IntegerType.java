package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

class IntegerType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
