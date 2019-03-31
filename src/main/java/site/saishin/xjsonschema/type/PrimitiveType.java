package site.saishin.xjsonschema.type;

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
}
