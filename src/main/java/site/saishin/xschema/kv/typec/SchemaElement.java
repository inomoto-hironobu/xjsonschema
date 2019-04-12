package site.saishin.xschema.kv.typec;

import java.util.Optional;

public interface SchemaElement {
	DataType type();
	default Optional<String> getName() {
		return Optional.empty();
	}
	default Optional<String> defaultValue() {
		return Optional.empty();
	}
	default Optional<Boolean> nullable() {
		return Optional.empty();
	}
}