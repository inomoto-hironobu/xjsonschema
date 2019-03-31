package site.saishin.xjsonschema.type;

import java.util.Optional;

import org.w3c.dom.NamedNodeMap;

import site.saishin.xjsonschema.JsonType;

abstract class BaseJsonType implements JsonType {
	String name;
	boolean nullable;
	boolean required;
	void set(NamedNodeMap attrs) {
		if(attrs.getNamedItem("name") != null) {
			name = attrs.getNamedItem("name").getNodeValue();
		}
		if(attrs.getNamedItem("nullable") != null) {
			nullable = attrs.getNamedItem("nullable").getNodeValue().equals("true");
		}
		if(attrs.getNamedItem("required") != null) {
			required = attrs.getNamedItem("required").getNodeValue().equals("true");
		}
	}
	public Optional<Boolean> nullable() {
		return Optional.of(nullable);
	}
	@Override
	public Optional<String> getName() {
		return Optional.of(name);
	}
	@Override
	public Optional<String> defaultValue() {
		return Optional.empty();
	}
	@Override
	public Optional<JsonType> ifObjetGet(String key) {
		return Optional.empty();
	}
}
