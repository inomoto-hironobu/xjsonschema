package site.saishin.xschema.xkvschema.typec;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import site.saishin.xschema.xjsonschema.typeb.struct.XJsonSchemaTypeb;

public class KvTypecValidator {
	private static final Logger logger = LoggerFactory.getLogger(KvTypecValidator.class); 
	final XJsonSchemaTypeb xJsonSchema;
	JsonParser parser;
	public KvTypecValidator(XJsonSchemaTypeb jsonSchema) {
		xJsonSchema = jsonSchema;
	}

	public boolean validate(InputStream json) throws JsonParseException, IOException {
		JsonFactory f = new JsonFactory();
		f.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
		JsonParser parser = f.createParser(json);
		JsonToken token;
		boolean notNull = true;
		while (notNull) {
			token = parser.nextToken();
			System.out.println(token);
			System.out.println(parser.getCurrentName());
			System.out.println(parser.getCurrentLocation());
			notNull = token != null;
		}
		return false;
	}
}