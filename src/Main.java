public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Ana", "Pop", 1993, "f");
        s1.setId("2930516374523");
        Student s2 = new Student("Maria", "Ionescu", 1994, "F");

        StudentRepo students = new StudentRepo();

        students.add(s1);
        students.add(s2);
        students.delete("2930516374523");

        students.listAll();
        students.listSortedByLastName();
        students.listSortedByAge();
    }
}
