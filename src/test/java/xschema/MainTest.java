package xschema;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import site.saishin.xschema.Main;

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
		assertNotNull(Main.createSchema(Main.class.getResourceAsStream("/xschema/xjsonschema-typea.xsd")));
		assertNull(Main.createSchema(Main.class.getResourceAsStream("/xschema/null.xsd")));
		assertNotNull(Main.typeaSchema());
		assertNotNull(Main.typeaSchema());
		assertNotNull(Main.typeaSchema());
	}
}
