package Utils;

import org.testng.asserts.SoftAssert;

public class Assertions {

    static SoftAssert ast = new SoftAssert();

    public static void comparisonCheck(String actual,String expected){
        ast.assertEquals(actual,expected);


    }

    public static void booleanCheck(Boolean actual,String message){
        ast.assertTrue(actual,message);
    }

    public static void assertAll(){
        ast.assertAll();
    }
}
