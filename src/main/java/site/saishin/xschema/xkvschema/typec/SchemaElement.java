package site.saishin.xschema.xkvschema.typec;

import java.util.Optional;

public interface SchemaElement {
	SchemaElementType type();
	default Optional<String> getName() {
		return Optional.empty();
	}
	default Optional<String> defaultValue() {
		return Optional.empty();
	}
	default Optional<SchemaElement> ifObjetGet(String key) {
		return Optional.empty();
	}
	default Optional<Boolean> nullable() {
		return Optional.empty();
	}
}
