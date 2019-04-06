package xschema.xkvschema;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import site.saishin.xschema.Main;
import xschema.Util;

public class TypecTest {

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
	public void complex() {
		try {
			assertFalse(Main.validateByTypea(Util.kv("/complex/error2.json"), Util.kv("/complex/json.xml")));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			fail();
		}	
	}
	@Test
	public void npm() {
		try {
			InputStream schema = Util.kv("/npm/json.xml");
			assertTrue(Main.validateByTypea(Util.kv("/npm/package.json"), schema));
		} catch (SAXException | IOException e) {
			fail();
		}
	}
	@Test
	public void simple() {
		try {
			InputStream schema = Util.kv("/simple/json.xml");
			assertTrue(Main.validateByTypea(Util.kv("/simple/valid.json"), schema));
			schema = Util.kv("/simple/json.xml");
			assertFalse(Main.validateByTypea(Util.kv("/simple/error.json"), schema));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			fail();
		}		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testVisitor() {
		fail("Not yet implemented");
	}
}
