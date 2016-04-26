package tom.yang.javalab.reflections;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import tom.yang.tlog.Tlog;

public class GetAllInterfacesChild implements ISomeInterface{
	public static void main(final String[] args) {
		Tlog.printSection("interfacechild");
		final Reflections reflections = new Reflections("tom.yang");
		final Set<Class<? extends ISomeInterface>> subTypes = reflections.getSubTypesOf(ISomeInterface.class);
		subTypes.forEach(clazz->System.out.println(clazz.getName()));

		Tlog.printSection("getclasschild");
		final Set<Class<? extends ParentClass>> childs = reflections.getSubTypesOf(ParentClass.class);
		childs.forEach(clazz->System.out.println(clazz.getName()));

		Tlog.printSection("serializable");
		final Set<Class<? extends Serializable>> c = reflections.getSubTypesOf(Serializable.class);
		c.forEach(clazz->System.out.println(clazz.getName()));

		Tlog.printSection("list");
		final Reflections utilReflectoins = new Reflections("java.util");
		final Set<Class<? extends List>> cs = utilReflectoins.getSubTypesOf(List.class);
		cs.forEach(clazz->System.out.println(clazz.getName()));
	}
}
