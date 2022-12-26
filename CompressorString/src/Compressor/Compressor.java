package Compressor;

import java.io.*;
import java.util.Scanner;

public class Compressor {

    public static void compress( String path, String pathOut ) throws IOException {

        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter( pathOut );

        Scanner scan = new Scanner(fr);

        String code = "";
        String lastStr = null;
        int count = 0, index = 1;

        while( scan.hasNext() ){
            String str = scan.nextLine();

            if( lastStr != null && lastStr.equals( str ) ){

                if( count == 0 ){
                    code+=index-1;
                }

                count++;
                continue;
            }

            if( count != 0 ){
                code+=" "+count+" ";
                count = 0;
            }

            lastStr = str;
            index++;

            fw.write(str+"\n");

        }

        if( count != 0 ){
            code+=" "+count;
        }

        fw.write(code);


        fr.close();
        fw.close();
    }

    public static void decompress( String path, String pathOut ) throws IOException{

        int[] code = getCodeFromComp( path );

        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(pathOut);

        Scanner scan = new Scanner(fr);

        for( int i = 1, k = 0; scan.hasNext(); i++ ){

            String str = scan.nextLine();

            if( scan.hasNext() )
                fw.write( str + "\n" );

            if( k < code.length && i == code[k] ){
                for( int s = 0; s < code[k+1]; s++ ){
                    fw.write( str + "\n" );
                }
                k+=2;
            }

        }

        fr.close();
        fw.close();

    }

    private static int[] getCodeFromComp( String path ) throws IOException{

        FileReader fr = new FileReader(path);
        Scanner scan = new Scanner(fr);

        int[] code = new int[0];

        while( scan.hasNext() ){
            String str = scan.nextLine();
            if( !scan.hasNext() ){
                String[] nums = str.split(" ");
                code = new int[ nums.length ];
                for( int i = 0; i < nums.length; i++ ){
                    code[i] = Integer.parseInt( nums[i] );
                }
            }
        }

        fr.close();

        return code;
    }


}
