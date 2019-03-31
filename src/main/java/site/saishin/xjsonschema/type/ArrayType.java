package site.saishin.xjsonschema.type;

import site.saishin.xjsonschema.SchemaElementType;

class ArrayType extends BaseJsonType implements Typable {
	SchemaElementType type;
	ObjectType otype;
	TypeGroup typeGroup = new TypeGroup();
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ARRAY;
	}
	@Override
	public TypeGroup typeGroup() {
		return typeGroup;
	}
	
}
