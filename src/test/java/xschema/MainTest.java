package xschema;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import site.saishin.xschema.Main;
import site.saishin.xschema.XSchemaUtil;

public class MainTest {

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
	public void testSchemaLoading() {
		assertNotNull(XSchemaUtil.createSchema(XSchemaUtil.schema("/xjsonschema-typea.xsd")));
		assertNull(XSchemaUtil.createSchema(XSchemaUtil.schema("/null.xsd")));
		assertNotNull(XSchemaUtil.typeaSchema());
		assertNotNull(XSchemaUtil.typeaSchema());
		assertNotNull(XSchemaUtil.typeaSchema());
	}
}
