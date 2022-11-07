package UtilytiForTxt;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class UtilityForTxt {


    static public int findStr(String str, File file) throws Exception{

        FileReader fr = new FileReader( file.getAbsolutePath() );
        Scanner scan = new Scanner(fr);


        for(int i = 1; scan.hasNext(); i++ ){

           // String str1 = scan.nextLine();

            if( str.equals(scan.nextLine()) ){
                fr.close();
                return i;
            }
        }

        fr.close();
        return 0;
    }





}
