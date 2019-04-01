package site.saishin.xjsonschema.typeb.struct;

import site.saishin.xjsonschema.typea.SchemaElementType;

class NumberType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
