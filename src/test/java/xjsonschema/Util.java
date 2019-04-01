package xjsonschema;

import java.io.InputStream;

public class Util {
	public static InputStream common(String name) {
		return Util.class.getResourceAsStream("/xjsonschema/common" + name);
	}
}
