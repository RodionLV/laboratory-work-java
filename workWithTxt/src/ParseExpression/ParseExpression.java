package ParseExpression;

import Token.Token;
import NumberExpression.NumberExpression;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class ParseExpression {
    private ArrayList<Object> tokens = new ArrayList<Object>();
    private String expression = "";

    private int position = 0;

    private Object tree = null;

    public ParseExpression(String expression){
        this.expression = expression;

        try{
            this.createTokens();
            this.tree = this.createTree();
        }catch(Exception e){
            System.out.println( e.getMessage() );
        }
    }

    public Object getTree(){
        return this.tree;
    }

    public Object resolveExpression( Object tree ){


        if( tree instanceof NumberExpression){



            NumberExpression nTree = (NumberExpression) tree;
            double a = (double) resolveExpression( nTree.leftNumber );
            double b = (double) resolveExpression( nTree.rightNumber );

            switch( nTree.operator ){
                case "*":
                    return a*b;
                case "/":
                    return a/b;
                case "%":
                    return a%b;
                case "-":
                    return a-b;
                case "+":
                    return a+b;
            }


        }



        Token nTree = (Token)tree;
        return Double.parseDouble( nTree.value );




    }

    private Object createTree() {




         for( String nameToken: Token.nameTokens){

             if( nameToken != "number") {
                 for (int i = this.tokens.size() - 1; i >= 0; i--) {

                     if (this.tokens.get(i) instanceof Token) {

                         Token token = (Token) this.tokens.get(i);

                         if (token.name == nameToken) {

                             ArrayList<Object> newTokens = new ArrayList<Object>();

                             for (int k = 0; k < i - 1; k++) {
                                 newTokens.add(this.tokens.get(k));
                             }

                             newTokens.add(new NumberExpression(token.value, this.tokens.get(i - 1), this.tokens.get(i + 1)));

                             for (int k = i + 2; k < this.tokens.size(); k++) {
                                 newTokens.add(this.tokens.get(k));
                             }

                             this.tokens = newTokens;
                             i = this.tokens.size();

                         }
                     }
                 }
             }

         }

        return this.tokens.get(0);
    }

    private void createTokens() throws Exception {

        while( this.expression != ""){
            Token token = this.createToken();
            tokens.add( token );
        }
    }


    private Token createToken() throws Exception {


        for( String nameToken: Token.nameTokens ){

            Matcher matcher = Token.tokens.get( nameToken ).matcher(this.expression);

            if( matcher.find() ){

                String valueToken = this.expression.substring(0, matcher.end());

                if( !valueToken.equals("") ){

                    if( valueToken.equals("-") && ( this.tokens.size() == 0 || ((Token)this.tokens.get( this.tokens.size()-1 )).name != "number" ) ){
                        continue;
                    }

                    position += matcher.end();
                    this.expression = this.expression.substring( matcher.end() );
                    return new Token(nameToken, valueToken);
                }

            }


        }

        if( this.expression.length() > 10){
            throw new Exception("invalid expression on position "+position+" : " + this.expression.substring(0, 10)+"..." );
        }else{
            throw new Exception("invalid expression on position "+position+" : " + this.expression.substring(0, 1) );
        }

    }

    public String toString(){
        return "toString: "+toString(this.tree, " ");
    }

    private String toString(Object tree, String space){

        if( tree instanceof NumberExpression){
            return " NumberExpression{\n" + space + "  operator: " + ((NumberExpression)tree).operator+"\n"+space+"  left: "
                    + toString( ((NumberExpression) tree).leftNumber, space+"  " ) + "\n" + space + "  right: " +
                    toString( ((NumberExpression) tree).rightNumber, space+"  " ) + "\n"+space+"}";
        }

        if( tree instanceof Token)
            return ((Token)tree).value;
        return "";

    }





}
