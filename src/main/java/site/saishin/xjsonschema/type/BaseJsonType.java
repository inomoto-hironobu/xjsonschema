package site.saishin.xjsonschema.type;

import org.w3c.dom.NamedNodeMap;

import site.saishin.xjsonschema.JsonDataType;

abstract class BaseJsonType {
	String name;
	boolean nullable;
	boolean required;
	void set(NamedNodeMap attrs) {
		name = attrs.getNamedItem("name").getNodeValue();
		if(attrs.getNamedItem("nullable") != null) {
			nullable = attrs.getNamedItem("nullable").getNodeValue().equals("true");
		}
		if(attrs.getNamedItem("required") != null) {
			required = attrs.getNamedItem("required").getNodeValue().equals("true");
		}
	}
	abstract JsonDataType type();
}
