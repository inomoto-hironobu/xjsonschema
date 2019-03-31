package site.saishin.xjsonschema;

import java.util.Optional;

public interface JsonType {
	JsonData type();
	Optional<String> getName();
	Optional<String> defaultValue();
	Optional<JsonType> ifObjetGet(String key);
}
