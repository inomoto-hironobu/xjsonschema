package site.saishin.xschema.xjsonschema;

import java.util.Optional;

import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

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
