import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> str = Class.forName("java.lang.String");
        Method[] methods = str.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}