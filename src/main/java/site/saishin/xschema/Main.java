package site.saishin.xschema;

import javax.xml.validation.SchemaFactory;

/**
 * 全てのメソッドはスレッドセーフではありません
 */
public final class Main {

	private static final Main INSTANCE = new Main();
	private static String error;
	private final SchemaFactory SCHEMA_FACTORY = SchemaFactory.newDefaultInstance();
	public Main() {

	}
	public static Main getInstance() throws IllegalStateException {
		if(error != null)
			return INSTANCE;
		else
			throw new IllegalStateException(error);
	}
}
