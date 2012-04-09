package interfascia;

import java.lang.reflect.*;

public class IFDelegation {
	public static Object callDelegate(Object delegate, String method, Object[] parameters) {
		Method m;
		Object o = null;
		Class[] parameterTypes = new Class[parameters.length];
		
		for (int i = 0; i < parameters.length; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		
		try {
			m = delegate.getClass().getDeclaredMethod(method, parameterTypes);
			o = m.invoke(delegate, parameters);
		} catch (NoSuchMethodException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
		
		return o;
	}
}
