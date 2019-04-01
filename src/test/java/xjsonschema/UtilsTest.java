package xjsonschema;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea.Visitor;
import site.saishin.xjsonschema.Main;

public class UtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	private InputStream get(String name) {
		return this.getClass().getResourceAsStream("/xjsonschema" + name);
	}
}
