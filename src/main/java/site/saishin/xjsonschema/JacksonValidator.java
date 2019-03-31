package site.saishin.xjsonschema;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import site.saishin.xjsonschema.type.XJsonSchema;
import site.saishin.xjsonschema.type.XJsonSchema.Visitor;

public class JacksonValidator {
	final XJsonSchema xJsonSchema;
	JsonParser parser;
	private static final Logger logger = LoggerFactory.getLogger(JacksonValidator.class); 
	public JacksonValidator(XJsonSchema jsonSchema) {
		xJsonSchema = jsonSchema;
	}

	public boolean validate(InputStream json) throws JsonParseException, IOException {
		JsonFactory f = new JsonFactory();
		f.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
		JsonParser parser = f.createParser(json);
		JsonToken token;
		boolean notNull = true;
		
		Visitor v = xJsonSchema.newVisitor();
		while (notNull) {
			token = parser.nextToken();
			System.out.println(token);
			System.out.println(parser.getCurrentName());
			System.out.println(parser.getCurrentLocation());
			notNull = token != null;
		}
		return false;
	}

	boolean test(JsonToken token, JsonData type) throws IOException {
		logger.debug("test:{}:{}", token.name(), type);
		if (token.isBoolean() && type == JsonData.BOOLEAN) {
			return true;
		} else if (token == JsonToken.VALUE_STRING && type == JsonData.STRING) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_INT && type == JsonData.NUMBER) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_FLOAT && type == JsonData.NUMBER) {
			return true;
		} else if (token == JsonToken.START_OBJECT && type == JsonData.OBJECT) {
			return true;
		} else if (token == JsonToken.START_ARRAY && type == JsonData.ARRAY) {
			return true;
		}
		return false;
	}

}