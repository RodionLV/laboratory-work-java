package com.zoopark.animals.Zebra;

import com.zoopark.Animal.Animal;
import com.zoopark.InterfaceForAnimal.InterfaceForAnimal;

public class Zebra extends Animal implements InterfaceForAnimal{

    public String getNameAnimal() {
        return "Zebra";
    }

    @Override
    public void eating() {
        System.out.println("eat hay");
    }

    @Override
    public String getColors() {
        return "black and white";
    }
}
