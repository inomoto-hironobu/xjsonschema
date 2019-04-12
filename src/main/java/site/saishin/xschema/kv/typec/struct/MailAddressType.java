package site.saishin.xschema.kv.typec.struct;

import java.net.URI;

import site.saishin.xschema.kv.typec.DataType;

class MailAddressType extends BaseKvType<URI> {
	URI defaultValue;
	int min;
	int max;
	@Override
	public DataType type() {
		return DataType.MAIL_ADDRESS;
	}
}
