package site.saishin.xschema.csv;

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
}
