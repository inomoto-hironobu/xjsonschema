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

import site.saishin.xschema.json.typea.JacksonTypeaValidator;
import site.saishin.xschema.json.typea.struct.XJsonSchemaTypea;
import site.saishin.xschema.kv.typec.struct.XKvSchemaTypec;

/**
 * 全てのメソッドはスレッドセーフではありません
 */
public final class Main {

	private static final Main INSTANCE = new Main();
	private static String error;
	private final SchemaFactory SCHEMA_FACTORY = SchemaFactory.newDefaultInstance();
	public Main() {

	}
	public static Main getInstance() throws IllegalStateException {
		if(error != null)
			return INSTANCE;
		else
			throw new IllegalStateException(error);
	}
}
