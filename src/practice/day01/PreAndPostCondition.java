package practice.day01;

import org.testng.annotations.*;

public class PreAndPostCondition {
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class annotation.");
    }

    @Test
    public void testMethod(){
        System.out.println("I am test Method.");
    }
    @Test
    public void testMethod2(){
        System.out.println("I am test Second Method.");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method.");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("i am after method.");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation.");
    }

}
