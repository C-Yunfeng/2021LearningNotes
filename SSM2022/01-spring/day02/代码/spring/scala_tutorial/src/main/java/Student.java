public class Student {
    private String name;
    private Integer age;
    private static String school = "DWJM";

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public void printInfo(){
        System.out.println(this.name + " " + this.age + " " + Student.school);
    }

    public static void main(String[] args) {
        Student alex = new Student("alex", 24);
        alex.printInfo();
    }

}
