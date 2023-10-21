package lesson.noar.l1;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Lesson1Test {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }

    @RepeatedTest(100)
    void getCryTimeTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        int actual = (int) this.doStaticPrivateMethod("getCryTime", null, null);
        assertTrue(actual >= 1 && actual <= 8);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1,2,3,4,5,6,7,8 })
    void getCicadaCryTest(int i) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
            String actual = (String) this.doStaticPrivateMethod("getCicadaCry", new Class[] { int.class },
                    new Object[] { i });
            assertEquals("みーんみーん" + "みん".repeat(i) + "みーん", actual);
    }

    @Test
    void mainTest() {
        Lesson1.main(new String[] {});
        System.out.flush();
        final String actual = byteArrayOutputStream.toString();
        assertTrue(actual.matches("(みーん){2}(みん){1,8}みーん\\n".repeat(5)));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(defaultPrintStream);
    }

    private Object doStaticPrivateMethod(String name, Class<?>[] types, Object[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Lesson1.class.getDeclaredMethod(name, types);
        method.setAccessible(true);
        return method.invoke(null, args);
    }

}
