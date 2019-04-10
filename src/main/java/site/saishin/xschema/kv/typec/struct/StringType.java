package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.SchemaElementType;

class StringType extends BaseKvType<String> {
	int min;
	int max;
	String defaultValue;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
