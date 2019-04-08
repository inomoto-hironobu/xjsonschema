package site.saishin.xschema.kv.typec.struct;

import java.util.Optional;

import org.w3c.dom.NamedNodeMap;

import site.saishin.xschema.kv.typec.SchemaElement;

abstract class BaseKvType implements SchemaElement {
	String name;
	String defaultValue;
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
		if(attrs.getNamedItem("default") != null) {
			defaultValue = attrs.getNamedItem("default").getNodeValue();
		}
	}
	@Override
	public Optional<Boolean> nullable() {
		return Optional.of(nullable);
	}
	@Override
	public Optional<String> getName() {
		return Optional.of(name);
	}
	@Override
	public Optional<String> defaultValue() {
		return Optional.of(defaultValue);
	}

}
