package xschema;

import java.io.InputStream;

public class Util {
	public static InputStream schema(String name) {
		return Util.class.getResourceAsStream("/xchema" + name);
	}
	public static InputStream jsoncommon(String name) {
		return Util.class.getResourceAsStream("/xschema/xjsonschema/common" + name);
	}
}
