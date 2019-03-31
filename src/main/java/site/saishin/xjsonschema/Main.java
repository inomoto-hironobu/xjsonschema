package site.saishin.xjsonschema;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import site.saishin.xjsonschema.type.XJsonSchema;

public final class Main {

	private final Schema jsonSchemaSchema;
	private final DocumentBuilderFactory factory;
	private static final Main instance = new Main();

	private Main() {
		this.jsonSchemaSchema = schema();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		factory.setSchema(jsonSchemaSchema);
		factory.setValidating(false);
		// これがないとDOCTYPE宣言がないとなる
		factory.setNamespaceAware(true);
		this.factory = factory;
	}
	public static Main getInstance() {
		return instance;
	}
	private static Schema schema() {
		Schema tmp = null;
		try {
			SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
			tmp = schemaFactory
					.newSchema(new StreamSource(Main.class.getResourceAsStream("/xjsonschema/xjsonschema.xsd")));
			
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	public DocumentBuilder documentBuilder() throws ParserConfigurationException {
		return factory.newDocumentBuilder();
	}

	public static XJsonSchema jsonSchema(InputStream jsonSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		try {
			builder = main.factory.newDocumentBuilder();
			Document d = builder.parse(new InputSource(jsonSchema));
			return XJsonSchema.create(d);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean validate(InputStream json, InputStream jsonSchema) throws SAXException, IOException {
		JacksonValidator validator = new JacksonValidator(jsonSchema(jsonSchema));
		return validator.validate(json);
	}
}
