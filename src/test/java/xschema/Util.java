package xschema;

import java.io.InputStream;

public class Util {
	public static InputStream json(String name) {
		return Util.class.getResourceAsStream("/xschema/json" + name);
	}
	public static InputStream typea(String name) {
		return Util.class.getResourceAsStream("/xschema/json/typea" + name);
	}
	public static InputStream typeb(String name) {
		return Util.class.getResourceAsStream("/xschema/json/typeb" + name);
	}
	public static InputStream typec(String name) {
		return Util.class.getResourceAsStream("/xschema/kv" + name);
	}
	public static InputStream typed(String name) {
		return Util.class.getResourceAsStream("/xschema/yaml" + name);
	}
	public static InputStream kv(String name) {
		return Util.class.getResourceAsStream("/xschema/kv" + name);
	}
	public static InputStream yaml(String name) {
		return Util.class.getResourceAsStream("/xchema/yaml" + name);
	}
	public static InputStream csv(String name) {
		return Util.class.getResourceAsStream("/xchema/csv" + name);
	}
	public static InputStream schema(String name) {
		return Util.class.getResourceAsStream("/xschema" + name);
	}
}
