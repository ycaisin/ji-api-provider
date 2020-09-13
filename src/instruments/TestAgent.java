package instruments;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class TestAgent {
	public static void premain(String args, Instrumentation instrumentation ) {
		System.out.println("Test Agent RUNNING!");
		
		instrumentation.addTransformer(new ClassFileTransformer() {

			@Override
			public byte[] transform(ClassLoader loader, String name, Class<?> arg2, ProtectionDomain arg3, byte[] classfileBuffer)
					throws IllegalClassFormatException {
				System.out.println("Class was loaded: " + name);
				System.out.println("Loader used: " + loader);
				return null;
			}
			
		});
		
		}
}
