package tom.yang.javalab.reflections;

import java.util.Set;

import org.reflections.Reflections;

import tom.yang.tlog.Tlog;

public class GetAllInterfacesChild implements ISomeInterface{
	public static void main(final String[] args) {
		final Reflections reflections = new Reflections("tom.yang.javalab.reflections");
		final Set<Class<? extends ISomeInterface>> subTypes = reflections.getSubTypesOf(ISomeInterface.class);
		subTypes.forEach(clazz->System.out.println(clazz.getName()));

		Tlog.printSection("getclasschild");
		final Set<Class<? extends ParentClass>> childs = reflections.getSubTypesOf(ParentClass.class);
		childs.forEach(clazz->System.out.println(clazz.getName()));

		Tlog.printSection("interfaces");
		final Set<String> subTypesOf = reflections.getStore().getSubTypesOf("tom.yang.javalab.reflections.ISomeInterface");
		subTypesOf.forEach(clazz->System.out.println(clazz));
	}
}
