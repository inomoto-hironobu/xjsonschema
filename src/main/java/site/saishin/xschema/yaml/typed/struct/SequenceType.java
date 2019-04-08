package site.saishin.xschema.yaml.typed.struct;

import java.util.List;

import site.saishin.xschema.yaml.DataType;
import site.saishin.xschema.yaml.SchemaElementType;

class SequenceType extends BaseYamlType {
	DataType type;
	List<BaseYamlType> contents;
	@Override
	public SchemaElementType type() {
		return SchemaElementType.SEQUENCE;
	}
}