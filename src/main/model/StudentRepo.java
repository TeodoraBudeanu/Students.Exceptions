package main.model;

import exceptions.*;
import main.comparators.AgeComparator;
import main.comparators.NameComparator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepo {

    List<Student> students = new ArrayList<>();

    public void add(Student s) {
        try {
            validateName(s.getFirstName());
            validateName(s.getLastName());
            validateDateOfBirth(s.getDateOfBirth());
            validateGender(s.getGender());
            students.add(s);
        } catch (IncorrectNameException | IncorrectBirthYearException | InvalidGenderException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            validateId(id);
            for (Student s : students) {
                if (s.getId().equals(id)) {
                    students.remove(s);
                    break;
                }
            }
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listByAge(int age) {
        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Students with the age of: " + age);
        for (Student s : students) {
            int studentAge = LocalDateTime.now().getYear() - s.getDateOfBirth();
            if (studentAge == age) {
                System.out.println(s);
            }
        }
        System.out.println("=================================================");
    }

    public void listSortedByLastName() {
        Collections.sort(students, new NameComparator());
        System.out.println("Students listed by last name:");
        for (Student s : students) {
            try {
                if (s.getId() == null) {
                    throw new InvalidIdException("Please enter the ID for " + s.getFirstName() + " " + s.getLastName());
                }
                validateId(s.getId());
                System.out.println(s);
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("=================================================");
    }

    public void listSortedByAge() {
        Collections.sort(students, new AgeComparator());
        System.out.println("Students listed by age:");
        for (Student s : students) {
            try {
                if (s.getId() == null) {
                    throw new InvalidIdException("Please enter the ID for " + s.getFirstName() + " " + s.getLastName());
                }
                validateId(s.getId());
                System.out.println(s);
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("=================================================");
    }

    public void listAll() {
        System.out.println("All students:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=================================================");
    }

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be a negative number.");
        }
    }

    public void validateDateOfBirth(int dateOfBirth) throws IncorrectBirthYearException {
        if (dateOfBirth < 1900) {
            throw new IncorrectBirthYearException("Birth year cannot be less than 1900.");
        } else if (dateOfBirth > 2018) {
            throw new IncorrectBirthYearException("Birth year cannot be higher than current year.");
        }
    }

    public void validateName(String name) throws IncorrectNameException {
        if (name.length() == 0) {
            throw new IncorrectNameException("Name field cannot be empty..");
        }
    }

    public void validateGender(String gender) throws InvalidGenderException {
        if (!gender.equals("M") && !gender.equals("m") && !gender.equals("F") && !gender.equals("f")) {
            throw new InvalidGenderException("The gender you entered might not have the proper format. Please select " +
                    "one of the following: M or F (available in upper or lowercase).");
        }
    }

    public void validateId(String id) throws InvalidIdException {
        if (id.length() == 0 || id.length() < 10) {
            throw new InvalidIdException("The ID you have entered does not have the proper length.");
        }
        boolean idFound = false;
        for (Student s : students) {
            if (s.getId() == id) {
                idFound = true;
                break;
            }
        }
        if (!idFound) {
            throw new InvalidIdException("This ID was not found. Either the student does not exist," +
                    " either you have entered a wrong ID.");
        }
    }
}
