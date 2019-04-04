package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xkvschema.typec.SchemaElementType;

class StringType extends BaseKvType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
