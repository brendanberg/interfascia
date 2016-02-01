// Interfascia ALPHA 004 -- http://interfascia.plusminusfive.com/
// GUI Library for Processing -- http://www.processing.org/
//
// Copyright (C) 2006-2016 Brendan Berg
// interfascia (at) plusminusfive (dot) com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
// USA
// --------------------------------------------------------------------



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
