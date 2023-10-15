import java.util.*;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static StringBuffer sbTwo = new StringBuffer();
    private static Scanner sc = new Scanner(System.in);
    private static StringBuffer strForChoose = new StringBuffer();
    private static Map<String, String> mapTeacher = new HashMap<>();
    private static Map<String, Integer> mapStudent = new HashMap<>();
    private static Teacher teacher;
    private static Student student;
    private static List<Teacher> arrayForTeacher = new ArrayList<>();
    private static List<Student> arrayForStudent = new ArrayList<>();
    private static int numberStudent = 0;

    public static void chooseOneOption(){
        System.out.print("Choose one option : ");
    }
    public static void SpaceBar(){
        System.out.println();
        System.out.println("-------------------------");
    }

    public static void showMenu(){
        System.out.println("1. student");
        System.out.println("2. Class");
        System.out.println("3. Exit");
        chooseOneOption();
    }

    public static String Menu(String str){
        if("student".equals(str.toLowerCase()) || "1".equals(str)) return "student";
        if("class".equals(str.toLowerCase()) || "2".equals(str)) return "class";
        if("exit".equals(str.toLowerCase()) || "3".equals(str)) return "exit";
        return "-1";
    }

    public static String studentPage(){
        SpaceBar();
        System.out.println("This is Page for Student");
        System.out.println("1. save Student");
        System.out.println("2. edit Student");
        System.out.println("3. watch Student");
        System.out.println("4. back");
        chooseOneOption();
        return studentPageChoose(sc.next());
    }

    public static String studentPageChoose(String str){
        if("save".equals(str.toLowerCase()) || "save student".equals(str.toLowerCase()) || "1".equals(str)) return "save";
        if("edit".equals(str.toLowerCase()) || "eidt student".equals(str.toLowerCase()) || "2".equals(str)) return "edit";
        if("watch".equals(str.toLowerCase()) || "watch student".equals(str.toLowerCase()) || "3".equals(str)) return "watch";
        if("back".equals(str.toLowerCase()) || "4".equals(str)) return "back";
        return "-1";
    }
    public static void saveStudent(){
        SpaceBar();
        String[] text = new String[2];
        int age;
        System.out.println("Save the information of the Student");

        System.out.print("Name : ");
        text[0] = sc.next();
        System.out.print("Class : ");
        text[1] = sc.next();
        System.out.print("Age : ");
        age = sc.nextInt();

        if(mapStudent.containsKey(text[0])) text[0] = text[0] + "(" + numberStudent + ")";
        arrayForStudent.add(new Student(numberStudent, text[0], text[1], age)); // 학생 객체 생성
        mapStudent.put(text[0], numberStudent);
        numberStudent++;
        System.out.println("New Data is saved now");
    }

    public static void editStudent(){
        String text = findStudent(); // 원래 이름
        System.out.print("new Name : ");
        String name = sc.next(); // 새로운 이름
        if(checkForAvailableStudent(text)) return;
        arrayForStudent.get(mapStudent.get(text)).setName(name);
        System.out.print("new Class : ");
        String classStudent = sc.next();
        arrayForStudent.get(mapStudent.get(text)).setClassForStudent(classStudent);
        System.out.print("new Age : ");
        int age = sc.nextInt();
        arrayForStudent.get(mapStudent.get(text)).setAge(age);
        mapStudent.put(name, mapStudent.get(text)); // 새로운 이름 맵 삽입 + 고유번호
        if(!text.equals(name)) mapStudent.remove(text); // 기존 이름 맵 제거

    }

    public static boolean checkForAvailableStudent(String str){
        if(!mapStudent.containsKey(str)){
            SpaceBar();
            System.out.println("This ID is not available");
            return true;
        }
        return false;
    }

    public static void watchStudent(){
        String text = findStudent();
        if(!checkForAvailableStudent(text)) arrayForStudent.get(mapStudent.get(text)).getAll();
    }

    public static String findStudent(){
        SpaceBar();
        String text;
        System.out.print("Enter the student name : ");
        text = sc.next();
        return text;
    }

    public static void classPage(){

    }

    public static String loginForWebSite(){
        SpaceBar();
        String[] textAccount = new String[2];
        System.out.print("ID : ");
        textAccount[0] = sc.next();
        System.out.print("PW : ");
        textAccount[1] = sc.next();
        return accountCheck(textAccount[0], textAccount[1]);
    }

    public static String accountCheck(String text1, String text2){
        if(!mapTeacher.containsKey(text1)) return "notAllowed";
        if(!mapTeacher.get(text1).equals(text2)) return "notAllowed";
        return "Allowed";
    }

    public static void joinForWebsite(){
        String[] textAccount = new String[2];
        SpaceBar();
        System.out.println("Create your Account");
        System.out.print("ID : ");
        textAccount[0] = sc.next();
        System.out.print("PW : ");
        textAccount[1] = sc.next();
        if(mapTeacher.containsKey(textAccount[0])){
            SpaceBar();
            System.out.println("This ID is not available");
            return;
        }
        arrayForTeacher.add(new Teacher(textAccount[0], textAccount[1]));
        mapTeacher.put(textAccount[0], textAccount[1]);
        System.out.println("New account is created now");
    }

    public static void errorShowing(){
        System.out.println(" - Error - ");
    }
    public static void main(String[] args) {


        while(true){
            sb.setLength(0);
            SpaceBar();

            System.out.println("Privated School WebSite for Students");
            SpaceBar();

            System.out.println("Are you a new Member? Please create a new Acoount");
            System.out.print("Yes or No : ");
            sb.append(sc.next()); // sb는 로그인 구현 저장 변수로만 쓰임

            if(sb.toString().toLowerCase().equals("yes")){
                joinForWebsite();
                continue;
            }
            if(!sb.toString().toLowerCase().equals("no")){
                errorShowing();
                continue;
            }

            sb.setLength(0);
            SpaceBar();
            System.out.println("Welcome to PSFS");
            System.out.println("Please login to enter this program");

            if(!"Allowed".equals(loginForWebSite())){
                System.out.println("Login data is wrong");
                continue;
            }

            while(true) {
                sb.setLength(0);
                SpaceBar();
                System.out.println("Login is Completed");
                showMenu();
                sb.append(sc.next());

                if ("exit".equals(Menu(sb.toString()))) break; // exit일경우 break;
                if ("student".equals(Menu(sb.toString()).toLowerCase())){
                    while(true) {
                        sbTwo.setLength(0);
                        sbTwo.append(studentPage());
                        if("back".equals(sbTwo.toString())) break;
                        if("-1".equals(sbTwo.toString())) continue;
                        if("save".equals(sbTwo.toString())) saveStudent();
                        if("edit".equals(sbTwo.toString())) editStudent();
                        if("watch".equals(sbTwo.toString())) watchStudent();
                    }
                }
                if ("class".equals(Menu(sb.toString().toLowerCase()))){
                    classPage(); // 개발 미완료
                }

            }

            break;
        }
        SpaceBar();
        System.out.println("Program ends");
    }
}