import Cards.Cards;



public class Main {
    public static void main(String[] args) throws Exception {

        Cards cards = new Cards();


        String[] giveCards = cards.giveCards(10);


        for( int i = 0; i < giveCards.length; i++ ){
            System.out.println( giveCards[i] );
        }

        System.out.println( cards.addCard("7 Clubs") );

    }
}