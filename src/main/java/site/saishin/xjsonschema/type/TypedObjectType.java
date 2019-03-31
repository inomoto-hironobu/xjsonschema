package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

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
