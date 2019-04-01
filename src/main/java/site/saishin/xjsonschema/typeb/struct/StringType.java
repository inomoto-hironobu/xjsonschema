package site.saishin.xjsonschema.typeb.struct;

import site.saishin.xjsonschema.typea.SchemaElementType;

class StringType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
