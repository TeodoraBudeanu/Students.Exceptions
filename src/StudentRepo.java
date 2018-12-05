import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepo {

    List<Student> students = new ArrayList<>();

    public void add(Student s) {
        try {
            validateName(s.getFirstName(), s.getLastName()); // TODO: Mai sunt necesare aici??
            validateDateOfBirth(s.getDateOfBirth());
            validateGender(s.getGender());
            students.add(s);
        } catch (IncorrectNameException | IncorrectBirthYearException | InvalidGenderException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) { // TODO: "ID is empty" = ?
        try {
            validateId(id);
            for (Student s : students) {
                if (s.getId() == id) {
                    students.remove(s);
                    break;
                }
            }
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listByAge(int age) {// TODO: age is not a number, age is negative - is it possible??
                                    // TODO: Also, should we use Date class or is it ok with birthYear?
        for (Student s : students) {
            int studentAge = 2018 - s.getDateOfBirth();
            try {
                validateAge(studentAge);
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
            if (studentAge == age) {
                System.out.println(s);
            }
        }
    }

    public void listSortedByLastName() { //TODO: Exceptions - Any input but ID cannot be empty as it is asked for
                                        //TODO: in Constructor of Student. Should we only use validateID??
        Collections.sort(students, new NameComparator());
        System.out.println("Students listed by last name:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=================================================");
    }

    public void listSortedByAge() {
        Collections.sort(students, new AgeComparator());
        System.out.println("Students listed by age:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=================================================");
    }

    public void listAll() {
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=================================================");
    }

    public void validateAge(int age) throws InvalidAgeException {
//TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    public void validateDateOfBirth(int dateOfBirth) throws IncorrectBirthYearException {
        if (dateOfBirth < 1900) {
            throw new IncorrectBirthYearException("Birth year cannot be less than 1900.");
        } else if (dateOfBirth > 2018) {
            throw new IncorrectBirthYearException("Birth year cannot be higher than current year.");
        }
    }

    public void validateName(String firstName, String lastName) throws IncorrectNameException {
        if (firstName == null) {
            throw new IncorrectNameException("Please enter first name.");
        }
        if (lastName == null) {
            throw new IncorrectNameException("Please enter last name.");
        }
    }

    public void validateGender(String gender) throws InvalidGenderException {
        if (!gender.equals("M") && !gender.equals("m") && !gender.equals("F") && !gender.equals("f")) {
            throw new InvalidGenderException("The gender you entered might not have the proper format. Please select " +
                    "one of the following: M or F (available in upper or lowercase).");
        }
    }

    public void validateId(String id) throws InvalidIdException {
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
