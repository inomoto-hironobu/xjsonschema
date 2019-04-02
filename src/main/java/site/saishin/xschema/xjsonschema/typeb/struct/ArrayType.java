package site.saishin.xschema.xjsonschema.typeb.struct;

import site.saishin.xschema.xjsonschema.DataType;
import site.saishin.xschema.xjsonschema.typea.SchemaElementType;

class ArrayType extends BaseJsonType {
	DataType type;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ARRAY;
	}
}