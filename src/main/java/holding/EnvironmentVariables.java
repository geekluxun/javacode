package holding;
//: holding/EnvironmentVariables.java

import java.util.Map;

public class EnvironmentVariables {
    public static void main(String[] args) {

        //系统的环境变量
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
} /* (Execute to see output) *///:~
