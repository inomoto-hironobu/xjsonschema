package xschema.kv;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import site.saishin.xschema.Main;
import site.saishin.xschema.XSchemaUtil;
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
	public void simple() {
		try {
			InputStream schema = Util.schema("/valid-kv.json");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Map<String, String>> map = mapper.readValue(schema, new TypeReference<Map<String,Map<String,String>>>() {});
			System.out.println(map);
			map.forEach((s,m)->{
				try {
					XSchemaUtil.kvSchemaTypec(Util.kv(s + "/comment.xml"));
				} catch (IOException | SAXException e) {
					e.printStackTrace();
					fail(e.getMessage());
				}
			});
		} catch (IOException e) {
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
