package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class StringType extends PrimitiveType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
