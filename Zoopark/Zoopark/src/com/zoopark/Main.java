package com.zoopark;

import com.zoopark.animals.Elephant.Elephant;
import com.zoopark.animals.Giraffe.Giraffe;
import com.zoopark.animals.Zebra.Zebra;

public class Main {
    public static void main(String[] args) {

        Giraffe giraffe = new Giraffe();
        Zebra zebra = new Zebra();
        Elephant elephant = new Elephant();

        System.out.print( giraffe.getNameAnimal() + " " );
        giraffe.eating();
        System.out.print( zebra.getNameAnimal() + " " );
        zebra.eating();

        System.out.println( elephant.getNameAnimal() + " contain color " + elephant.getColors() );

    }
}