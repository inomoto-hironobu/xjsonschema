package site.saishin.xjsonschema.typeb.struct;

import site.saishin.xjsonschema.typea.SchemaElementType;

class IntegerType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
