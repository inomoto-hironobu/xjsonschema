package site.saishin.xschema;

import java.io.InputStream;

public class Util {
	public static InputStream schema(String name) {
		return Util.class.getResourceAsStream("/xschema" + name);
	}
}
