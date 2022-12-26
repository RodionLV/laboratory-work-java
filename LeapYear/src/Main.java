import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        while(true) {
            Scanner scan = new Scanner(System.in);

            try {
                System.out.println("Введите год: ");
                int year = Integer.parseInt(scan.nextLine());

                if (isLeapYear(year)) {
                    System.out.println("Год " + year + " является високосным");
                } else {
                    System.out.println("Год " + year + " не високосный");
                }

                break;
            } catch (Exception e) {
                System.out.println("Вы ввели некоректное значение: " + scan.nextLine() );
            }
        }


    }

    public static boolean isLeapYear(int year){
        return year % 4 == 0 ? true : false;
    }
}