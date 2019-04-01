package site.saishin.xjsonschema.typeb.struct;

import site.saishin.xjsonschema.DataType;
import site.saishin.xjsonschema.typea.SchemaElementType;

class ArrayType extends BaseJsonType {
	DataType type;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ARRAY;
	}
}