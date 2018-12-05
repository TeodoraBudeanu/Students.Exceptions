public class Student {

    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, int dateOfBirth, String gender) {
        try {
            validateName(firstName, lastName);
            validateDateOfBirth(dateOfBirth);
            validateGender(gender);
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
        } catch (IncorrectNameException | IncorrectBirthYearException | InvalidGenderException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName +
                ", DateOfBirth=" + dateOfBirth +
                ", Gender='" + gender + '\'' +
                ", ID='" + id + '\'' ;
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


}

