package site.saishin.xschema.xjsonschema.typea.struct;

import site.saishin.xschema.xjsonschema.DataType;
import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class TypedObjectType extends BaseJsonType implements Typable {
	DataType type;
	ObjectType otype;
	TypeGroup typeGroup = new TypeGroup();
	@Override
	public SchemaElementType type() {
		return SchemaElementType.TYPED_OBJECT;
	}
	@Override
	public TypeGroup typeGroup() {
		return typeGroup;
	}

}
