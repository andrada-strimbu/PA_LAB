package org.example;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.app().name() + i))
                .toArray(Project[]::new);
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student(faker.name().fullName() + i))
                .toArray(Student[]::new);
        students[0].addProject(projects[0]);
        students[0].addProject(projects[1]);
        students[1].addProject(projects[2]);
        students[1].addProject(projects[0]);
        students[1].addProject(projects[1]);
        students[2].addProject(projects[0]);
        var studentList = Arrays.stream(students).collect(Collectors.toCollection(ArrayList::new));
        var projectList = Arrays.stream(projects).collect(Collectors.toCollection(ArrayList::new));
        MaximCardinalityProblem problem = new MaximCardinalityProblem(studentList, projectList);
        problem.solveCardinalityProblem();

    }
}