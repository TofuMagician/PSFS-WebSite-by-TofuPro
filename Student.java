public class Student {
    private int number;
    private String name;
    private String classForStudent;
    private int age;

    Student(int number, String name, String classForStudent, int age){
        this.number = number;
        this.name = name;
        this.classForStudent = classForStudent;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setClassForStudent(String classForStudent){
        this.classForStudent= classForStudent;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setAll(String name, String classForStudent, int age){
        this.name = name;
        this.classForStudent = classForStudent;
        this.age = age;
        System.out.println("Name : " + this.name);
        System.out.println("Class : " + this.classForStudent);
        System.out.println("Age : " + this.age);
    }

    public void getAll(){
        System.out.println("Name : " + this.name);
        System.out.println("Class : " + this.classForStudent);
        System.out.println("Age : " + this.age);
    }
}
