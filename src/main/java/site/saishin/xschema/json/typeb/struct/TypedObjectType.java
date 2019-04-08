package site.saishin.xschema.json.typeb.struct;

import site.saishin.xschema.json.DataType;
import site.saishin.xschema.json.typeb.SchemaElementType;

class TypedObjectType extends BaseJsonType {
	DataType type;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.TYPED_OBJECT;
	}
}
