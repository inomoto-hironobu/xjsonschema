package site.saishin.xjsonschema.typea.struct;

import site.saishin.xjsonschema.DataType;
import site.saishin.xjsonschema.typea.SchemaElementType;

class ArrayType extends BaseJsonType implements Typable {
	DataType type;
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
