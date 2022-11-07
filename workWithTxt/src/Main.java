
import NumberExpression.NumberExpression;
import ParseExpression.ParseExpression;
import Token.Token;
import UtilytiForTxt.UtilityForTxt;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {


        File file1 = new File( "src/txt/file1.txt" );
        File file2 = new File("src/txt/file2.txt");
        File file3 = new File("src/txt/file3.txt");
        File expression = new File("src/txt/expression.txt");


        // Задача 1.1

//        FileReader fr = new FileReader( file1.getAbsolutePath() );
//        FileWriter fw = new FileWriter( file3.getAbsolutePath() );
//        Scanner scan = new Scanner( fr );
//
//        while( scan.hasNext() ){
//            String str = scan.nextLine();
//            if( UtilityForTxt.findStr( str, file2 ) != 0){
//                System.out.println(str);
//                fw.write(str+"\n");
//            }
//        }
//
//        fr.close();
//        fw.close();

        // Задача 1.2

//        FileReader fr = new FileReader( file1.getAbsolutePath() );
//        FileWriter fw = new FileWriter( file3.getAbsolutePath() );
//        Scanner scan = new Scanner( fr );
//
//        for(int i = 0; scan.hasNext(); i++){
//            String str = scan.nextLine();
//
//            if( UtilityForTxt.findStr( str, file2 ) == i){
//                System.out.println(str);
//                fw.write(str+"\n");
//            }
//        }
//
//        fr.close();
//        fw.close();

        // Задача 1.3

//        FileReader fr = new FileReader( expression.getAbsolutePath() );
//        FileWriter fw = new FileWriter( file3.getAbsolutePath() );
//        Scanner scan = new Scanner( fr );
//
//       while( scan.hasNext() ){
//           String str = scan.nextLine();
//           ParseExpression pExp = new ParseExpression( str );
//           fw.write( pExp.resolveExpression( pExp.getTree() )+"\n" );
//       }
//
//
//        fr.close();
//        fw.close();



    }


}