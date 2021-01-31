package homework7;

public class Tests {

    @BeforeSuite
    public static void beforeTest() {
        System.out.println("BeforeSuite");
    }

    @Test(priority = 4)
    public static void test1() {
        System.out.println("Test 1");
    }


    @Test(priority = 1)
    public static void test2() {
        System.out.println("Test 2");
    }


    @Test(priority = 3)
    public static void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 2)
    public static void test4() {
        System.out.println("Test 4");
    }

    @AfterSuite
    public static void afterTest() {
        System.out.println("AfterSuite");
    }

}