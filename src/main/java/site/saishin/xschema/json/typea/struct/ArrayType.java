package site.saishin.xschema.json.typea.struct;

import site.saishin.xschema.json.DataType;
import site.saishin.xschema.json.typea.SchemaElementType;

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
