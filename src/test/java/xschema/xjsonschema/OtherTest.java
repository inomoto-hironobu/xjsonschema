package xschema.xjsonschema;

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

import site.saishin.xschema.Main;
import site.saishin.xschema.xjsonschema.typea.struct.XJsonSchemaTypea;
import xschema.Util;

public class OtherTest {

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
	@Test
	public void testJackson() {
		InputStream json = Util.jsoncommon("/npm/package.json");
		JsonFactory f = new JsonFactory();
		f.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
		try {
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
