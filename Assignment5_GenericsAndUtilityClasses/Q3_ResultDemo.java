import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private final T[] marks;
    private final double passingThreshold;

    public Result(T[] marks, double passingThreshold) {
        // 5. Use Objects.requireNonNull() to validate inputs
        this.marks = Objects.requireNonNull(marks, "Marks array cannot be null");
        this.passingThreshold = passingThreshold;
    }

    // 2. Calculate percentage or average using numeric conversion methods
    public Optional<Double> calculateAverage() {
        if (marks.length == 0) {
            return Optional.empty();
        }
        double sum = 0.0;
        for (T mark : marks) {
            Objects.requireNonNull(mark, "Individual mark entry cannot be null");
            sum += mark.doubleValue();
        }
        return Optional.of(sum / marks.length);
    }

    // 3. Determine whether the student has passed based on the threshold
    public boolean hasPassed() {
        Optional<Double> average = calculateAverage();
        return average.map(avg -> avg >= passingThreshold).orElse(false);
    }

    // 4. Display result using Optional
    public void displayResult() {
        Optional<Double> average = calculateAverage();
        if (average.isPresent()) {
            System.out.println("Average Marks: " + average.get());
            System.out.println("Passed Status: " + (hasPassed() ? "PASSED" : "FAILED"));
        } else {
            System.out.println("Result unavailable: No marks provided.");
        }
    }
}

public class Q3_ResultDemo {
    public static void main(String[] args) {
        Integer[] studentMarks = {78, 85, 90, 82};
        Result<Integer> result = new Result<>(studentMarks, 75.0);
        result.displayResult();
    }
}