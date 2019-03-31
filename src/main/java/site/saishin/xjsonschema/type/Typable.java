package site.saishin.xjsonschema.type;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

interface Typable {
	default void setType(Element e, Map<Typable, String> refs) {
		NodeList children = e.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) children.item(i);
				if(child.getNodeName().equals("ref")) {
					refs.put(this, child.getTextContent());
				} else if(child.getNodeName().equals("base")) {
					typeGroup().type = DataType.from(child.getTextContent());
				}
			}
		}
	}
	TypeGroup typeGroup();
	default void setDef(Def def) {
		typeGroup().def = def;
	}
}
