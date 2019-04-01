package site.saishin.xjsonschema.typeb.struct;

import site.saishin.xjsonschema.DataType;
import site.saishin.xjsonschema.typea.SchemaElementType;

class TypedObjectType extends BaseJsonType {
	DataType type;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.TYPED_OBJECT;
	}
}
