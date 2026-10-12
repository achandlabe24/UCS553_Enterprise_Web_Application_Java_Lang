import java.util.*;

class Course {
    String courseCode;
    String courseName;
    int capacity;
    HashSet<String> enrolledStudentIDs;
    ArrayList<String> prerequisiteCodes;
    LinkedList<String> waitlistQueue;

    public Course(String courseCode, String courseName, int capacity, List<String> prerequisites) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudentIDs = new HashSet<>();
        this.prerequisiteCodes = new ArrayList<>(prerequisites);
        this.waitlistQueue = new LinkedList<>();
    }
}

public class Q1_CourseRegistrationPortal {
    // HashMap for fast O(1) course lookups by course code
    private HashMap<String, Course> courseMap = new HashMap<>();
    
    // Tracking student completed courses for prerequisite validation: StudentID -> Set of Completed Course Codes
    private HashMap<String, HashSet<String>> studentCompletedCourses = new HashMap<>();

    public void addCourse(String code, String name, int capacity, List<String> preReqs) {
        courseMap.put(code, new Course(code, name, capacity, preReqs));
    }

    public void recordCompletedCourse(String studentId, String courseCode) {
        studentCompletedCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(courseCode);
    }

    public boolean registerStudent(String studentId, String courseCode) {
        Course course = courseMap.get(courseCode);
        if (course == null) {
            System.out.println("Error: Course " + courseCode + " does not exist.");
            return false;
        }

        // Check if student is already enrolled or waitlisted
        if (course.enrolledStudentIDs.contains(studentId) || course.waitlistQueue.contains(studentId)) {
            System.out.println("Notice: Student " + studentId + " is already enrolled or waitlisted in " + courseCode);
            return false;
        }

        // Verify Prerequisites
        HashSet<String> completed = studentCompletedCourses.getOrDefault(studentId, new HashSet<>());
        for (String preReq : course.prerequisiteCodes) {
            if (!completed.contains(preReq)) {
                System.out.println("Registration Denied: Student " + studentId + " missing prerequisite -> " + preReq);
                return false;
            }
        }

        // Capacity Check & Enrollment / Waitlist Routing
        if (course.enrolledStudentIDs.size() < course.capacity) {
            course.enrolledStudentIDs.add(studentId);
            System.out.println("Success: Student " + studentId + " enrolled in " + courseCode);
            return true;
        } else {
            course.waitlistQueue.add(studentId);
            System.out.println("Waitlisted: Course " + courseCode + " is full. Student " + studentId + " added to queue position " + course.waitlistQueue.size());
            return false;
        }
    }

    public void dropCourse(String studentId, String courseCode) {
        Course course = courseMap.get(courseCode);
        if (course == null) return;

        if (course.enrolledStudentIDs.remove(studentId)) {
            System.out.println("Dropped: Student " + studentId + " dropped " + courseCode);
            
            // Automated Waitlist Promotion (First-Come, First-Served)
            if (!course.waitlistQueue.isEmpty()) {
                String promotedStudent = course.waitlistQueue.poll();
                course.enrolledStudentIDs.add(promotedStudent);
                System.out.println("Automated Promotion: Student " + promotedStudent + " promoted from waitlist into " + courseCode);
            }
        } else if (course.waitlistQueue.remove(studentId)) {
            System.out.println("Removed: Student " + studentId + " removed from waitlist for " + courseCode);
        }
    }

    // Example Test Main
    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();
        portal.addCourse("CS101", "Introduction to Programming", 2, Collections.emptyList());
        portal.addCourse("CS102", "Data Structures", 1, List.of("CS101"));

        portal.recordCompletedCourse("S1", "CS101");
        
        portal.registerStudent("S1", "CS102"); // Should succeed
        portal.registerStudent("S2", "CS102"); // Should go to waitlist (Capacity 1)
        portal.drop("S1", "CS102");            // S1 drops, S2 promoted automatically
    }
    
    private void drop(String sId, String cCode) { dropCourse(sId, cCode); }
}
