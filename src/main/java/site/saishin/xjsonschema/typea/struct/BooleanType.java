package site.saishin.xjsonschema.typea.struct;

import site.saishin.xjsonschema.typea.SchemaElementType;

class BooleanType extends PrimitiveType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
