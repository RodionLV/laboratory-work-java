package Token;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Token {

    public String name;
    public String value;

    public Token(String name, String value){
        this.name = name;
        this.value = value;
    }

    static public String nameTokens[] = { "devNulMod", "sumMin", "number" };
    static public HashMap<String, Pattern> tokens = new Tokens().tokens;

    static private class Tokens {
        static public HashMap<String, Pattern> tokens = new HashMap<>();
        public Tokens(){
            tokens.put("number", Pattern.compile("^-?\\d+\\.?\\d*"));
            tokens.put( "devNulMod", Pattern.compile("^[*/%]") );
            tokens.put( "sumMin", Pattern.compile("^[\\-+-]") );
        }

    };

}
