package site.saishin.xschema.kv.typec.struct;

import java.util.Optional;

import site.saishin.xschema.kv.typec.SchemaElement;

abstract class BaseKvType<T> implements SchemaElement {
	String name;
	boolean nullable;
	boolean required;

	@Override
	public Optional<Boolean> nullable() {
		return Optional.of(nullable);
	}
	@Override
	public Optional<String> getName() {
		return Optional.of(name);
	}
}
