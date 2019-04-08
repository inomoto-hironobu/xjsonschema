package site.saishin.xschema.json.typea.struct;

import java.util.Optional;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

abstract class PrimitiveType extends BaseJsonType {
	String defaultValue;
	@Override
	void set(NamedNodeMap attrs) {
		super.set(attrs);
		Node defaultAttr = attrs.getNamedItem("default");
		if(defaultAttr != null)
			defaultValue = defaultAttr.getNodeValue();
	}
	@Override
	public Optional<String> defaultValue() {
		return Optional.of(defaultValue);
	}
}
