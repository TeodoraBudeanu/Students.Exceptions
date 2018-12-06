public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Ana", "Pop", 1993, "f");
        s1.setId("2930516374523");
        Student s2 = new Student("Maria", "Ionescu", 1994, "F");
        s2.setId("2930516374525");
        Student s3  =new Student("Alex", "Manole", 1993, "M");
        s3.setId("1930101232323");
        Student s4 = new Student("Andrei", "Moldovan", 1992, "m");

        StudentRepo students = new StudentRepo();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.delete("2930516374523");

        students.listAll();
        students.listByAge(25);
        students.listSortedByLastName();
        students.listSortedByAge();

    }
}
