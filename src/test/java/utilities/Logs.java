package utilities;

import java.util.logging.Logger;

public class Logs {

    private static Logger Log = Logger.getLogger(Logs.class.getName());

    public static void startTestCase(String sTestCaseName) {


    }


    public static void info(String message) {

        Log.info("!!!!!"+message+"!!!!");

    }
}