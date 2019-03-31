package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

class StringType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
