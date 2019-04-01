package site.saishin.xjsonschema;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import site.saishin.xjsonschema.typea.SchemaElementType;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea.Visitor;

public class JacksonValidator {
	private static final Logger logger = LoggerFactory.getLogger(JacksonValidator.class); 
	final XJsonSchemaTypea xJsonSchema;
	JsonParser parser;
	public JacksonValidator(XJsonSchemaTypea jsonSchema) {
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

	boolean test(JsonToken token, SchemaElementType type) throws IOException {
		logger.debug("test:{}:{}", token.name(), type);
		if (token.isBoolean() && type == SchemaElementType.BOOLEAN) {
			return true;
		} else if (token == JsonToken.VALUE_STRING && type == SchemaElementType.STRING) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_INT && type == SchemaElementType.NUMBER) {
			return true;
		} else if (token == JsonToken.VALUE_NUMBER_FLOAT && type == SchemaElementType.NUMBER) {
			return true;
		} else if (token == JsonToken.START_OBJECT && type == SchemaElementType.OBJECT) {
			return true;
		} else if (token == JsonToken.START_ARRAY && type == SchemaElementType.ARRAY) {
			return true;
		}
		return false;
	}

}