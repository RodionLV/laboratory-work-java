package com.zoopark.animals.Elephant;

import com.zoopark.Animal.Animal;
import com.zoopark.InterfaceForAnimal.InterfaceForAnimal;

public class Elephant extends Animal implements InterfaceForAnimal {

    @Override
    public String getNameAnimal(){
        return "Elephant";
    }


    @Override
    public void eating() {
        System.out.println("eat grass");
    }

    @Override
    public String getColors() {
        return "gray";
    }
}
