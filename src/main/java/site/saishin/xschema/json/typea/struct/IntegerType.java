package site.saishin.xschema.json.typea.struct;

import site.saishin.xschema.json.typea.SchemaElementType;

class IntegerType extends PrimitiveType {

	@Override
	public SchemaElementType type() {
		return SchemaElementType.INTEGER;
	}
}
