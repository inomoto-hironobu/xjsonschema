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

import site.saishin.xjsonschema.Main;
import site.saishin.xjsonschema.SchemaElement;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea;
import site.saishin.xjsonschema.typea.struct.XJsonSchemaTypea.Visitor;

public class TypebTest {

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
		return this.getClass().getResourceAsStream("/xjsonschema/typeb" + name);
	}
	
	@Test
	public void complex() {
		try {
			assertTrue(Main.validate(get("/complex/valid.json"), get("/complex/json.xml")));
			assertTrue(Main.validate(get("/complex/valid2.json"), get("/complex/json.xml")));
			assertFalse(Main.validate(get("/complex/error.json"), get("/complex/json.xml")));
			assertFalse(Main.validate(get("/complex/error2.json"), get("/complex/json.xml")));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			fail();
		}	
	}
	@Test
	public void npm() {
		try {
			InputStream schema = get("/npm/json.xml");
			assertTrue(Main.validate(get("/npm/package.json"), schema));
		} catch (SAXException | IOException e) {
			fail();
		}
	}
	@Test
	public void simple() {
		try {
			InputStream schema = get("/simple/json.xml");
			assertTrue(Main.validate(get("/simple/valid.json"), schema));
			schema = get("/simple/json.xml");
			assertFalse(Main.validate(get("/simple/error.json"), schema));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			fail();
		}		
	}
	@Test
	public void test() {
		Document d;
		try {
			d = Main.getInstance().documentBuilder().parse(get("/simple/json.xml"));
			XJsonSchemaTypea j = XJsonSchemaTypea.create(d);
			j.dump();
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testVisitor() {
		Document d;
		try {
			d = Main.getInstance().documentBuilder().parse(get("/simple/json.xml"));
			XJsonSchemaTypea j = XJsonSchemaTypea.create(d);
			Visitor visitor = j.newVisitor();
			visitor.ifObject((v)->{
				v.next();
			});
			SchemaElement root = j.root();
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
