package site.saishin.xschema;

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

import site.saishin.xschema.xjsonschema.JacksonValidator;
import site.saishin.xschema.xjsonschema.typea.struct.XJsonSchemaTypea;
import site.saishin.xschema.xjsonschema.typeb.struct.XJsonSchemaTypeb;

public final class Main {

	private final DocumentBuilderFactory factory;
	private final DocumentBuilder typeaBuilder;
	private final DocumentBuilder typebBuilder;
	private static final Main INSTANCE = new Main();
	private static String error;

	private Main() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		factory.setValidating(false);
		// これがないとDOCTYPE宣言がないとなる
		factory.setNamespaceAware(true);
		typeaBuilder = builder(factory, typeaSchema());
		factory.setSchema(typebSchema());
		typebBuilder = builder(factory, typebSchema());
		this.factory = factory;
	}
	public static Main getInstance() throws IllegalStateException {
		if(error != null)
			return INSTANCE;
		else
			throw new IllegalStateException(error);
	}
	private static DocumentBuilder builder(DocumentBuilderFactory factory, Schema schema) {
		factory.setSchema(schema);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			error = e.getMessage();
		}
		return null;
	}
	private static SchemaFactory schemaFactroy() {
		return SchemaFactory.newDefaultInstance();
	}
	private static Schema typeaSchema() {
		Schema tmp = null;
		try {
			tmp = schemaFactroy()
					.newSchema(new StreamSource(Main.class.getResourceAsStream("/xjsonschema/xjsonschema-typea.xsd")));
			
		} catch (SAXException e) {
			e.printStackTrace();
			error = e.getMessage();
		}
		return tmp;
	}
	private static Schema typebSchema() {
		Schema tmp = null;
		try {
			tmp = schemaFactroy()
					.newSchema(new StreamSource(Main.class.getResourceAsStream("/xjsonschema/xjsonschema-typeb.xsd")));
		} catch (SAXException e) {
			e.printStackTrace();
			error = e.getMessage();
		}
		return tmp;
	}
	public DocumentBuilder documentBuilder() throws ParserConfigurationException {
		return factory.newDocumentBuilder();
	}

	public static XJsonSchemaTypea jsonSchemaTypea(InputStream jsonSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		builder = main.typeaBuilder;
		Document d = builder.parse(new InputSource(jsonSchema));
		return XJsonSchemaTypea.create(d);
	}
	public static XJsonSchemaTypeb jsonSchemaTypeb(InputStream jsonSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		builder = main.typebBuilder;
		Document d = builder.parse(new InputSource(jsonSchema));
		return XJsonSchemaTypeb.create(d);
	}

	public static boolean validate(InputStream json, InputStream jsonSchema) throws SAXException, IOException {
		JacksonValidator validator = new JacksonValidator(jsonSchemaTypea(jsonSchema));
		return validator.validate(json);
	}
}
