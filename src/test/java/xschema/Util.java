package xschema;

import java.io.InputStream;

public class Util {
	public static InputStream schema(String name) {
		return Util.class.getResourceAsStream("/xchema" + name);
	}
	public static InputStream json(String name) {
		return Util.class.getResourceAsStream("/xschema/xjsonschema" + name);
	}
	public static InputStream typea(String name) {
		return Util.class.getResourceAsStream("/xschema/xjsonschema/typea" + name);
	}
	public static InputStream typeb(String name) {
		return Util.class.getResourceAsStream("/xschema/xjsonschema/typeb" + name);
	}
	public static InputStream kv(String name) {
		return Util.class.getResourceAsStream("/xschema/xkvschema" + name);
	}
}
