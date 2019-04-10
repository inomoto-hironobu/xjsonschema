package site.saishin.xschema;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import site.saishin.xschema.json.typea.struct.XJsonSchemaTypea;
import site.saishin.xschema.kv.typec.struct.XKvSchemaTypec;

public final class XSchemaUtil {
	private static final DocumentBuilderFactory factory;
	private static final DocumentBuilder typeaBuilder;
	private static final DocumentBuilder typebBuilder;
	private static final DocumentBuilder typecBuilder;

	static {
		factory = DocumentBuilderFactory.newDefaultInstance();
		factory.setValidating(false);
		// これがないとDOCTYPE宣言がないとなる
		factory.setNamespaceAware(true);
		typeaBuilder = builder(factory, typeaSchema());
		typebBuilder = builder(factory, typebSchema());
		typecBuilder = builder(factory, typecSchema());
	}
	private XSchemaUtil() {}
	public static InputStream schema(String name) {
		return XSchemaUtil.class.getResourceAsStream("/xschema" + name);
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
		}
		return tmp;
	}
	public static Schema typeaSchema() {
		return createSchema(schema("/xjsonschema-typea.xsd"));
	}
	public static Schema typebSchema() {
		return createSchema(schema("/xjsonschema-typeb.xsd"));
	}
	public static Schema typecSchema() {
		return createSchema(XSchemaUtil.schema("/xkvschema-typec.xsd"));
	}
	private static DocumentBuilder builder(DocumentBuilderFactory factory, Schema schema) {
		factory.setSchema(schema);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static XJsonSchemaTypea jsonSchemaTypea(InputStream jsonSchema) throws SAXException, IOException {
		return XJsonSchemaTypea.create(typeaBuilder.parse(new InputSource(jsonSchema)));
	}
	public static XJsonSchemaTypea jsonSchemaTypeb(InputStream jsonSchema) throws SAXException, IOException {
		return XJsonSchemaTypea.create(typebBuilder.parse(new InputSource(jsonSchema)));
	}
	public static XKvSchemaTypec kvSchemaTypec(InputStream kvSchema) throws SAXException, IOException {
		return XKvSchemaTypec.create(typecBuilder.parse(new InputSource(kvSchema)));
	}
	public static boolean validateByTypea(InputStream typea, InputStream typea2) throws SAXException {
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean validateByTypeb(InputStream typea, InputStream typea2) throws SAXException {
		// TODO Auto-generated method stub
		return false;
	}
}
