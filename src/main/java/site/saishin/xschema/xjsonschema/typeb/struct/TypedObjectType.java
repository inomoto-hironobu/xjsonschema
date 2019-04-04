package site.saishin.xschema.xjsonschema.typeb.struct;

import site.saishin.xschema.xjsonschema.DataType;
import site.saishin.xschema.xjsonschema.typeb.SchemaElementType;

class TypedObjectType extends BaseJsonType {
	DataType type;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.TYPED_OBJECT;
	}
}
