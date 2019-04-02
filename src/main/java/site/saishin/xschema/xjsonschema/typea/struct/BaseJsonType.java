package site.saishin.xschema.xjsonschema.typea.struct;

import java.util.Optional;

import org.w3c.dom.NamedNodeMap;

import site.saishin.xschema.xjsonschema.SchemaElement;

abstract class BaseJsonType implements SchemaElement {
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
}
