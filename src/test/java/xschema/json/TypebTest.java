package xschema.json;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import site.saishin.xschema.Main;
import site.saishin.xschema.XSchemaUtil;
import xschema.Util;

public class TypebTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void complex() {
		try {
			assertTrue(XSchemaUtil.validateByTypeb(Util.typea("/complex/valid.json"), Util.typea("/complex/json.xml")));
			assertTrue(XSchemaUtil.validateByTypeb(Util.typea("/complex/valid2.json"), Util.typea("/complex/json.xml")));
			assertFalse(XSchemaUtil.validateByTypeb(Util.typea("/complex/error.json"), Util.typea("/complex/json.xml")));
			assertFalse(XSchemaUtil.validateByTypeb(Util.typea("/complex/error2.json"), Util.typea("/complex/json.xml")));
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		}	
	}
	@Test
	public void npm() {
		try {
			InputStream schema = Util.typea("/npm/json.xml");
			assertTrue(XSchemaUtil.validateByTypea(Util.typea("/npm/package.json"), schema));
		} catch (SAXException e) {
			fail();
		}
	}
	@Test
	public void simple() {
		try {
			InputStream schema = Util.typea("/simple/json.xml");
			assertTrue(XSchemaUtil.validateByTypea(Util.typea("/simple/valid.json"), schema));
			schema = Util.typea("/simple/json.xml");
			assertFalse(XSchemaUtil.validateByTypea(Util.typea("/simple/error.json"), schema));
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void test() {
		
	}
	@Test
	public void testVisitor() {
		
	}
}
