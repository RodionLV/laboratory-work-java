import ReaderXml.ReaderXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {


        ReaderXML tags = new ReaderXML("./src", "product");




       FileWriter fw = new FileWriter("./src/out.txt");


        HashMap<String, Integer> map = tags.groupBy("type", "quantity");

        fw.write("Товаров на складе:\n");
        for( String key: map.keySet() ){
            fw.write( key+": " + map.get(key) + "\n" );
        }

        fw.write("\nНаименований товаров:\n");
        map = tags.groupBy("type", "CountQuantity");
        for( String key: map.keySet() ){
            fw.write( key+": " + map.get(key) + "\n" );
        }

        fw.write("\nСуммарная стоимость:\n");

        int sumPrice = 0;
        for(int i = 0; i < tags.getQuantity(); i++){
            sumPrice += tags.getValueByTag("price",  i)*tags.getValueByTag("quantity", i);
        }

        fw.write( sumPrice+"" );

        fw.close();


    }
}