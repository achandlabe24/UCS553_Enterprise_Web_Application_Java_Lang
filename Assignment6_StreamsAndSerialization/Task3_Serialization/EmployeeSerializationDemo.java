import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 1. Employee Model Class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String name;
    private String department;
    private double salary;

    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + 
               ", Department=" + department + ", Salary=$" + salary + "]";
    }
}

// 2. Main Driver Class
public class EmployeeSerializationDemo {

    // Serialize List of Employees to File
    public static void serializeEmployees(String fileName, List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employee objects successfully serialized to " + fileName);
        } catch (IOException e) {
            System.err.println("Serialization Error: " + e.getMessage());
        }
    }

    // Deserialize List of Employees from File
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employee objects successfully deserialized from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization Error: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        String dataFile = "employees.ser";

        // Create sample Employee records
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1001, "Alice Vance", "Engineering", 95000.00));
        employeeList.add(new Employee(1002, "Bob Martin", "Analytics", 82000.00));
        employeeList.add(new Employee(1003, "Charlie Day", "Operations", 71000.00));

        // Serialize
        System.out.println("--- Starting Serialization ---");
        serializeEmployees(dataFile, employeeList);

        // Deserialize
        System.out.println("\n--- Starting Deserialization ---");
        List<Employee> retrievedEmployees = deserializeEmployees(dataFile);

        // Display results
        if (retrievedEmployees != null) {
            System.out.println("\n--- Retreived Employee Records ---");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        }
    }
}