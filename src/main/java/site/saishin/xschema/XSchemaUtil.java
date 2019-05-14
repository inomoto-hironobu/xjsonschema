package site.saishin.xschema;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import site.saishin.domhelper.DomUtil;
import site.saishin.domhelper.HelperErrorHandler;
import site.saishin.domhelper.HelperResolver;
import site.saishin.xschema.json.typea.struct.XJsonSchemaTypea;
import site.saishin.xschema.kv.typec.struct.XKvSchemaTypec;

public final class XSchemaUtil {
	private static final DocumentBuilderFactory factory;
	private static final DocumentBuilder typeaBuilder;
	private static final DocumentBuilder typebBuilder;
	private static final DocumentBuilder typecBuilder;

	static {
		factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		// これがないとDOCTYPE宣言がないとなる
		factory.setNamespaceAware(true);
		typeaBuilder = builder(factory, typeaSchema());
		typebBuilder = builder(factory, typebSchema());
		typecBuilder = builder(factory, typecSchema());
	}
	private XSchemaUtil() {}
	
	public static StreamSource schema(String name) throws IOException {
		URL loc = XSchemaUtil.class.getResource("/xschema" + name);
		StreamSource source = new StreamSource(loc.openStream(), loc.toString());
		return source;
	}
	private static SchemaFactory schemaFactroy() {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setResourceResolver(new HelperResolver(Paths.get(System.getProperty("java.io.tmpdir"))));
		factory.setErrorHandler(new HelperErrorHandler());
		return factory; 
	}
	public static Schema createSchema(StreamSource schemaLocation) {
		Schema tmp = null;
		try {
			
			tmp = schemaFactroy()
					.newSchema(schemaLocation);
			
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	public static Schema typeaSchema() {
		try {
			return createSchema(schema("/xjsonschema-typea.xsd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Schema typebSchema() {
		try {
			return createSchema(schema("/xjsonschema-typeb.xsd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Schema typecSchema() {
		try {
			return createSchema(XSchemaUtil.schema("/xkvschema-typec.xsd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
