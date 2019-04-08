package site.saishin.xschema.json.typeb.struct;

import site.saishin.xschema.json.typeb.SchemaElementType;

class BooleanType extends PrimitiveType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
