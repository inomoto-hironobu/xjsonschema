package xschema.kv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import site.saishin.xschema.Main;
import site.saishin.xschema.XSchemaUtil;
import xschema.Util;

public class TypecTest {

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
	public void simple() {
		try {
			InputStream schema = Util.schema("/valid-kv.json");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Map<String, String>> map = mapper.readValue(schema, new TypeReference<Map<String,Map<String,String>>>() {});
			System.out.println(map);
			map.forEach((s,m)->{
				try {
					XSchemaUtil.kvSchemaTypec(Util.typec("/" + s + ".xml"));
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
}
