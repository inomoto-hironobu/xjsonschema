package site.saishin.xschema.kv.typec.struct;

import java.net.URI;

import site.saishin.xschema.kv.typec.DataType;

class UrlType extends BaseKvType<URI> {
	URI defaultValue;
	int min;
	int max;
	@Override
	public DataType type() {
		return DataType.URL;
	}
}
