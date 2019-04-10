package xschema.json;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import site.saishin.xschema.Main;
import site.saishin.xschema.XSchemaUtil;
import xschema.Util;

public class TypeaTest {

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
			assertTrue(XSchemaUtil.validateByTypea(Util.typea("/complex/valid.json"), Util.typea("/complex/json.xml")));
			assertTrue(XSchemaUtil.validateByTypea(Util.typea("/complex/valid2.json"), Util.typea("/complex/json.xml")));
			assertFalse(XSchemaUtil.validateByTypea(Util.typea("/complex/error.json"), Util.typea("/complex/json.xml")));
			assertFalse(XSchemaUtil.validateByTypea(Util.typea("/complex/error2.json"), Util.typea("/complex/json.xml")));
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		}	
	}
	@Test
	public void npm() {
		try {
			assertTrue(XSchemaUtil.validateByTypea(Util.typea("/npm/package.json"), Util.typea("/npm/json.xml")));
		} catch (SAXException e) {
			fail();
		}
	}
	@Test
	public void simple() {
		try {
			assertTrue(XSchemaUtil.validateByTypea(Util.json("/valid.json"), Util.typea("/simple/json.xml")));
			assertFalse(XSchemaUtil.validateByTypea(Util.json("/error.json"), Util.typea("/simple/json.xml")));
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
