package site.saishin.xschema.kv.typec.struct;

import java.util.Collections;
import java.util.Map;

import site.saishin.xschema.kv.typec.Root;
import site.saishin.xschema.kv.typec.SchemaElement;

class RootType implements Root {
	String name;
	Map<String, BaseKvType<?>> map;
	@Override
	public Map<String, SchemaElement> getMap() {
		return Collections.unmodifiableMap(map);
	}

}