package Cards;

import java.util.ArrayList;
import java.util.Random;

public class Cards {

    private String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs"};

    private String[] values = { "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private ArrayList<Card> cards = new ArrayList<>();

    public Cards(){
        createCards();

        shuffleCards();
    }

    private void createCards(){

        for( int i = 0; i < suits.length; i++ ){
            for( int j = 0; j < values.length; j++ ){
                cards.add( new Card( values[j], suits[i] ) );
            }
        }

    }

    public void shuffleCards(){
        ArrayList<Card> copyCards = this.cards;
        this.cards = new ArrayList<>();

        Random random = new Random();

        while( copyCards.size() != 0 ){
            int index = random.nextInt(copyCards.size() );

            this.cards.add( copyCards.get( index ) );
            copyCards.remove( index );
        }

    }

    public String[] giveCards( int count ) throws Exception {

       if( this.cards.size() < count || count < 1 ){
           throw new Exception("invalid count");
       }

        String[] cards = new String[ count ];

        for( int i = 0; i < count; i++ ){
            cards[i] = this.cards.get( 0 ).toString();
            this.cards.remove( 0 );
        }

        return cards;
    }


    public int getCountCards(){
        return this.cards.size();
    }

    public boolean addCard(String sCard) throws Exception{

        if( !checkNameCard( sCard ) ) throw new Exception("invalid name of card");

        String[] cardValues = sCard.split(" ");

        Card nCard = new Card( cardValues[0], cardValues[1] );

        for( Card card: this.cards ){
            if( card.toString().equals(nCard.toString()) ) return false;
        }

        this.cards.add( nCard );

        return true;
    }


    private boolean checkNameCard( String nameCard ){

        for( int i = 0; i < this.suits.length; i++ ){
            for( int j = 0; j < this.values.length; j++ ){
                if( nameCard.equals( this.values[j]+" "+this.suits[i] ) ) return true;
            }
        }

        return false;

    }



    private class Card{

        public String value;
        public String suit;

        public Card(String value, String suit){
            this.value = value;
            this.suit = suit;
        }


        public String toString(){
            return this.value + " " + this.suit;
        }
    }



}
