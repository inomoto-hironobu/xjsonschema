package site.saishin.xschema.kv.typec.struct;

import java.net.URI;

import site.saishin.xschema.kv.typec.SchemaElementType;

class MailAddressType extends BaseKvType<URI> {
	URI defaultValue;
	int min;
	int max;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.STRING;
	}
}
