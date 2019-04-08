package site.saishin.xschema.kv.typec.struct;

import site.saishin.xschema.kv.typec.SchemaElementType;

class StringType extends BaseKvType {
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
