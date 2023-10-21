package lesson.noar.l1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Lesson1Test {
    @Test
    void getCryTimeTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        for (int i = 0; i < 100000; i++) {
            int act = (int) this.doStaticPrivateMethod("getCryTime", null, null);
            assertTrue(act >= 1 && act <= 8);
        }
    }

    private Object doStaticPrivateMethod(String name, Class<?>[] types, Object[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Lesson1.class.getDeclaredMethod(name, types);
        method.setAccessible(true);
        return method.invoke(null, args);
    }

}
