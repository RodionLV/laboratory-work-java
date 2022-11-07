package ReaderXml;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderXML {

    private ArrayList<Object> contents = new ArrayList<>();

    private String conteiner = "";


     public ReaderXML(String path, String conteiner) throws Exception {
        this.conteiner = conteiner;
        this.findXMLFiles( path );

     }
    public void createXMLTokens(String path) throws Exception{



        String xmlFile = XmlToString(path);

        Pattern regExpCont = Pattern.compile("<"+this.conteiner+">(.*)</"+this.conteiner+">");

        Matcher matcher = regExpCont.matcher(xmlFile);

        if( matcher.find() ){
            ArrayList<Object> tokens = new ArrayList<>();

            String content = matcher.group(1);

            Pattern pTagXml = Pattern.compile("<([A-Za-z]+)>");
            Pattern varTag = Pattern.compile("<([A-Za-z]+)\svar=\"(.*?)\"/>");

            Matcher mTagXml = pTagXml.matcher(content);
            Matcher mVarTag = varTag.matcher(content);


            while( mTagXml.find() ){

                Pattern pTags = Pattern.compile("<"+mTagXml.group(1)+">(.*)</"+mTagXml.group(1)+">");
                Matcher mTags = pTags.matcher(xmlFile);

                if( mTags.find() ){

                    if( pTagXml.matcher( mTags.group(1) ).find() ){
                        continue;
                    }

                    tokens.add( new StrTag(mTagXml.group(1), mTags.group(1)) );
                }
            }


            while( mVarTag.find() ){
                tokens.add( new VarTag( mVarTag.group(1), mVarTag.group(2) ));
            }


            contents.add( tokens );

        }





    }


    public HashMap<String, Integer> groupBy(String groupTag, String valueTag) throws Exception {

         HashMap<String, Integer> groups = new HashMap<>();

         for( int i = 0; i < getQuantity(); i++ ){

             String nameGroup = this.getInnerTextByTag( groupTag, i);

             if( valueTag == "CountQuantity" ){

                 if( groups.containsKey( nameGroup ) ){
                     groups.put( nameGroup, groups.get( nameGroup )+1 );
                 }else{
                     groups.put( nameGroup, 1 );
                 }

             }else{

                 if( groups.containsKey( nameGroup ) ){
                     groups.put( nameGroup, groups.get( nameGroup ) + this.getValueByTag(valueTag, i) );
                 }else{
                     groups.put( nameGroup, this.getValueByTag(valueTag, i) );
                 }

             }


         }


         return groups;
    }

    public int getQuantity(){
        return contents.size();
    }


    public String getInnerTextByTag(String tagName, int index) throws Exception{
        if(index < 0 || index >= contents.size()){
            throw new Exception("not found element by index: "+index);
        }

        ArrayList<Object> tokens = (ArrayList<Object>) contents.get( index );

        for(Object token: tokens){
            if(((Tag)token).nameTag.equals( tagName )){

                if( token instanceof StrTag ){
                    return ((StrTag)token).innerText;
                }

            }
        }

        return "";
    }
    public Integer getValueByTag(String tagName, int index) throws Exception {

         if(index < 0 || index >= contents.size()){
             throw new Exception("not found element by index: "+index);
         }

         ArrayList<Object> tokens = (ArrayList<Object>) contents.get( index );


        for(Object token: tokens){
            if(((Tag)token).nameTag.equals( tagName )){

                if( token instanceof VarTag ){
                    return Integer.parseInt( ((VarTag)token).value );
                }

            }
        }

        return 0;
    }


    private void findXMLFiles(String path) throws Exception {

         File file = new File( path );

         this.findXMLFiles( file );
    }
    private void findXMLFiles(File file) throws Exception{

        String isXml = "\\d+\\.xml$";

        if( file.isFile() ){
            if( Pattern.matches(isXml, file.getName()) ){
                this.createXMLTokens( file.getAbsolutePath() );
            }
        }else{
            for( File f: file.listFiles() ){
                this.findXMLFiles( f );
            }
        }

    }

   public String XmlToString(String path) throws IOException {

        FileReader fr = new FileReader(path);
        Scanner scan = new Scanner(fr);

        String xmlFile = "";

        while( scan.hasNext() ){
            xmlFile += scan.nextLine();
        }

        fr.close();

        return xmlFile;

    }

     private class Tag{
         String nameTag = "";

         public Tag(String nameTag){
             this.nameTag = nameTag;
         }
     }

     private class StrTag extends Tag{
        public String innerText = "";

        public StrTag(String nameTag,String innerText){
            super(nameTag);
            this.innerText = innerText;
        }

    }
    private class VarTag extends Tag{
        String value = "";
        public VarTag(String nameTag, String value){
            super(nameTag);
            this.value = value;
        }


    }


}
