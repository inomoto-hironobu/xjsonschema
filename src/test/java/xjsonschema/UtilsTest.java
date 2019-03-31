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

import site.saishin.xjsonschema.JsonType;
import site.saishin.xjsonschema.Main;
import site.saishin.xjsonschema.type.XJsonSchema;
import site.saishin.xjsonschema.type.XJsonSchema.Visitor;

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

	@Test
	public void test() {
		Document d;
		try {
			d = Main.getInstance().documentBuilder().parse(get("/simple/json.xml"));
			XJsonSchema j = XJsonSchema.create(d);
			Visitor visitor = j.newVisitor();
			visitor.ifObject((v)->{
				v.next();
			});
			JsonType root = j.root();
			root.ifObjetGet("").ifPresentOrElse((t)->{
				System.out.println(t);
			}, ()->{
				System.out.println("test");
			});
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

}
