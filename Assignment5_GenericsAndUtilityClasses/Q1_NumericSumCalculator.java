public class NumericSumCalculator {

    // Generic method with a bounded type parameter T extends Number
    public static <T extends Number> double calculateSum(T[] array) {
        double sum = 0.0;
        for (T element : array) {
            if (element != null) {
                sum += element.doubleValue(); // Using doubleValue() for numeric conversion
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30, 40, 50};
        Float[] floatArray = {1.5f, 2.5f, 3.0f, 4.0f};
        Double[] doubleArray = {10.5, 20.25, 30.75};

        System.out.println("Sum of Integers: " + calculateSum(intArray));
        System.out.println("Sum of Floats: " + calculateSum(floatArray));
        System.out.println("Sum of Doubles: " + calculateSum(doubleArray));
    }
}