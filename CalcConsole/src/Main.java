
import Calc.Calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        while(true) {

            System.out.println("Введите выражение формата a+b, используя операторы -+/* :");
            String expr = scan.nextLine();

            try {

                System.out.println("результат: " + Calc.resolve(expr));
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}