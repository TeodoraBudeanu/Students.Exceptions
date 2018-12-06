public class Student {

    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, int dateOfBirth, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
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

}

