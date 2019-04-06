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

import site.saishin.xschema.xjsonschema.typea.JacksonTypeaValidator;
import site.saishin.xschema.xjsonschema.typea.struct.XJsonSchemaTypea;
import site.saishin.xschema.xkvschema.typec.struct.XKvSchemaTypec;

/**
 * 全てのメソッドはスレッドセーフではありません
 */
public final class Main {

	private final DocumentBuilderFactory factory;
	private final DocumentBuilder typeaBuilder;
	private final DocumentBuilder typebBuilder;
	private final DocumentBuilder typecBuilder;
	private static final Main INSTANCE = new Main();
	private static String error;
	private final SchemaFactory SCHEMA_FACTORY = SchemaFactory.newDefaultInstance();
	private Main() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		factory.setValidating(false);
		// これがないとDOCTYPE宣言がないとなる
		factory.setNamespaceAware(true);
		typeaBuilder = builder(factory, typeaSchema());
		typebBuilder = builder(factory, typebSchema());
		typecBuilder = builder(factory, typecSchema());
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
		SchemaFactory factory = SchemaFactory.newDefaultInstance();
		
		return factory; 
	}
	public static Schema createSchema(InputStream schemaLocation) {
		Schema tmp = null;
		try {
			tmp = schemaFactroy()
					.newSchema(new StreamSource(schemaLocation));
			
		} catch (SAXException e) {
			e.printStackTrace();
			error = e.getMessage();
		}
		return tmp;
	}
	public static Schema typeaSchema() {
		return createSchema(Main.class.getResourceAsStream("/xschema/xjsonschema-typea.xsd"));
	}
	public static Schema typebSchema() {
		return createSchema(Main.class.getResourceAsStream("/xschema/xjsonschema-typeb.xsd"));
	}
	public static Schema typecSchema() {
		return createSchema(Main.class.getResourceAsStream("/xschema/xkvschema-typec.xsd"));
	}
	public static XJsonSchemaTypea jsonSchemaTypea(InputStream jsonSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		builder = main.typeaBuilder;
		Document d = builder.parse(new InputSource(jsonSchema));
		return XJsonSchemaTypea.create(d);
	}
	public static XJsonSchemaTypea jsonSchemaTypeb(InputStream jsonSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		builder = main.typebBuilder;
		Document d = builder.parse(new InputSource(jsonSchema));
		return XJsonSchemaTypea.create(d);
	}
	public static XKvSchemaTypec ksSchemaTypec(InputStream kvSchema) throws SAXException, IOException {
		return XKvSchemaTypec.create(new Main().typecBuilder.parse(new InputSource(kvSchema)));
	}
	public static XKvSchemaTypec ksKvTypec(InputStream kvSchema) throws SAXException, IOException {
		Main main = new Main();
		DocumentBuilder builder;
		builder = main.typebBuilder;
		return XKvSchemaTypec.create(builder.parse(new InputSource(kvSchema)));
	}

	public static boolean validateByTypea(InputStream json, InputStream jsonSchema) throws SAXException, IOException {
		JacksonTypeaValidator validator = new JacksonTypeaValidator(jsonSchemaTypea(jsonSchema));
		return validator.validate(json);
	}
}
