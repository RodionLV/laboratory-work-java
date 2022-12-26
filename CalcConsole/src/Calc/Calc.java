package Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static double resolve(String expr) throws Exception {
        Matcher m = Pattern.compile("^(?<num1>\\d+(\\.\\d+)?)(?<operator>[-+*/])(?<num2>\\d+(\\.\\d+)?)$" ).matcher(expr);

        if(m.find()){

            switch(m.group("operator")){
                case "*":
                    return Double.parseDouble(m.group("num1")) * Double.parseDouble(m.group("num2"));
                case "-":
                    return Double.parseDouble(m.group("num1")) - Double.parseDouble(m.group("num2"));
                case "/":
                    return Double.parseDouble(m.group("num1")) / Double.parseDouble(m.group("num2"));
                case "+":
                    return Double.parseDouble(m.group("num1")) + Double.parseDouble(m.group("num2"));
            }

        }else{
            throw new Exception("Неверно задано выражение "+expr);
        }

        return 0;
    }


}
