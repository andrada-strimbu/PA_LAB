package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximCardinalityProblem {
    private Map<Student, List<Project>> prefMap = new HashMap<>();
    private List<Student> studentList = new ArrayList<>();
    private List<Project> projectList = new ArrayList<>();

    public MaximCardinalityProblem(List<Student> studentList, List<Project> projectList) {
        this.studentList = studentList;
        this.projectList = projectList;
        for (Student student : studentList) {
            prefMap.put(student, student.getAdmissibleProjects());
        }
    }

    public int getAveregeOfPreferences() {
        int numOfAdmisibleProjectsPerStudent = 0;
        for (Student student : studentList) {
            numOfAdmisibleProjectsPerStudent = numOfAdmisibleProjectsPerStudent + student.getAdmissibleProjects().size();
        }
        return numOfAdmisibleProjectsPerStudent / studentList.size();

    }

    public boolean isStudentLowerThanAverege(Student s) {

        return s.getAdmissibleProjects().size() < getAveregeOfPreferences();
    }

    public void printStudentsWithLowerThanAvg() {
        studentList.stream()
                .filter(s -> isStudentLowerThanAverege(s))
                .forEach(System.out::println);
    }

    public void solveCardinalityProblem() {
        studentList.sort(Student::compareTo);
        for (Student student : studentList) {
            for (Project project : student.getAdmissibleProjects()) {
                if (!project.taken) {
                    System.out.println(student + "-" + project);
                    project.taken = true;
                    break;
                }
            }

        }

    }
}
