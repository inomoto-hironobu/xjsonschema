package site.saishin.xschema.json.typeb.struct;

import java.util.List;

import site.saishin.xschema.json.DataType;
import site.saishin.xschema.json.typeb.SchemaElementType;

class ArrayType extends BaseJsonType {
	DataType type;
	List<BaseJsonType> contents;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.ARRAY;
	}
}