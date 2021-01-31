package homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TestManager {

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {

        ArrayList<Method> methods = new ArrayList<>(Arrays.asList(c.getDeclaredMethods()));
        Method before = null;
        Method after = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before == null) {
                    before = method;
                } else throw new RuntimeException("@BeforeSuite more than one in test class");
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (after == null) {
                    after = method;
                } else throw new RuntimeException("@AfterSuite more than one in test class");
            }
        }

        methods.remove(before);
        methods.remove(after);

        if (before != null) {
            before.invoke(null);
        }

        methods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
        for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    m.invoke(null);
                }
            }

        if (after != null) {
            after.invoke(null);
        }
    }
}
