package site.saishin.xschema.xkvschema.typec.struct;

import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class BooleanType extends PrimitiveType {
	@Override
	public SchemaElementType type() {
		return SchemaElementType.BOOLEAN;
	}
}
