package xschema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;

import site.saishin.xschema.XSchemaUtil;

public class MainTest {

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
	public void testSchemaLoading() {
		try {
			assertNotNull(XSchemaUtil.createSchema(XSchemaUtil.schema("/xjsonschema-typea.xsd")));
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(XSchemaUtil.typeaSchema());
		assertNotNull(XSchemaUtil.typeaSchema());
		assertNotNull(XSchemaUtil.typeaSchema());
	}
}
