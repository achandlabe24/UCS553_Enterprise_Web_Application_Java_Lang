import java.util.Objects;
import java.util.Optional;

class GenericUtils {

    // 1. Checks whether two objects are equal using Objects.equals
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    // 2. Returns the contained value or a default value
    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    // 3. Returns the larger of two comparable objects
    public static <T extends Comparable<T>> T max(T a, T b) {
        Objects.requireNonNull(a, "First object cannot be null");
        Objects.requireNonNull(b, "Second object cannot be null");
        return a.compareTo(b) >= 0 ? a : b;
    }

    // 4. Checks whether an object is null using the Objects class
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Q5_GenericUtilsDemo {
    public static void main(String[] args) {
        // Test isEqual
        System.out.println("isEqual('Java', 'Java'): " + GenericUtils.isEqual("Java", "Java"));
        System.out.println("isEqual(100, 200): " + GenericUtils.isEqual(100, 200));

        // Test getDefault
        Optional<String> presentOpt = Optional.of("Advanced Java");
        Optional<String> emptyOpt = Optional.empty();
        System.out.println("getDefault with present: " + GenericUtils.getDefault(presentOpt, "Default Course"));
        System.out.println("getDefault with empty: " + GenericUtils.getDefault(emptyOpt, "Default Course"));

        // Test max
        System.out.println("max(45, 88): " + GenericUtils.max(45, 88));
        System.out.println("max('Apple', 'Banana'): " + GenericUtils.max("Apple", "Banana"));

        // Test isNull
        String testStr = null;
        System.out.println("isNull(null string): " + GenericUtils.isNull(testStr));
        System.out.println("isNull('Hello'): " + GenericUtils.isNull("Hello"));
    }
}