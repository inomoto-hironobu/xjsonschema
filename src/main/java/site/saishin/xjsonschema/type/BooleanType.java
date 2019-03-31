package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

class BooleanType extends PrimitiveType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
