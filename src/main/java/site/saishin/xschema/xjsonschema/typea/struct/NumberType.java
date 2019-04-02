package site.saishin.xschema.xjsonschema.typea.struct;

import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class NumberType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.NUMBER;
	}
}
