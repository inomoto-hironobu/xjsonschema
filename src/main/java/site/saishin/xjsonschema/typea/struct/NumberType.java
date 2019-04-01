package site.saishin.xjsonschema.typea.struct;

import site.saishin.xjsonschema.typea.SchemaElementType;

class NumberType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
