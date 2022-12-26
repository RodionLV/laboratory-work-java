

public class Main {
    public static void main(String[] args) {


        for(int i = 1; i < 11; i++){
            double res = calcCompoundInterest( 100, 7, i);
            System.out.println("res: " + res +"  N: "+ i);
        }


        System.out.println( calcReverseCompoundInterest( 100, 171.81861798319204d, 8) );

    }

    public static double calcCompoundInterest(double num, double per, int N){
            return N == 0? num : calcCompoundInterest(num+per/100*num, per, N-1);
    }

    public static double calcReverseCompoundInterest(double num1, double num2, double N){
        System.out.println( 1/N );
        return Math.round( (Math.pow( num2/num1, 1.0/N)-1)*100);
    }
}