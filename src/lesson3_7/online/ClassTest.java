package lesson3_7.online;

public class ClassTest {

    @BeforeSuite
    public  static void start() {
        System.out.println("start");
    }

    @Test(priority = 9)
    public static void test1() {
        System.out.println("test1");
    }

    @Test(priority = 5)
    public static void test2(){
        System.out.println("test2");
    }

    @Test(priority = 3)
    public static void test3(){
        System.out.println("test3");
    }

    @Test(priority = 8)
    public static void test4(){
        System.out.println("test4");
    }

    @AfterSuite
    public static void stop(){
        System.out.println("stop");
    }
}
