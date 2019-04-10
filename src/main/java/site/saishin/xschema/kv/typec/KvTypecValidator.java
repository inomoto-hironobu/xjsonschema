package site.saishin.xschema.kv.typec;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;

import site.saishin.xschema.kv.typec.struct.XKvSchemaTypec;

public class KvTypecValidator {
	private static final Logger logger = LoggerFactory.getLogger(KvTypecValidator.class); 
	final XKvSchemaTypec schema;
	public KvTypecValidator(XKvSchemaTypec schema) {
		this.schema = schema;
	}

	public boolean validate(Map<String, String> params) {
		
		return false;
	}
}