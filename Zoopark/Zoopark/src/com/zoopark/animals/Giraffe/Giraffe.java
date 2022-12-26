package com.zoopark.animals.Giraffe;

import com.zoopark.Animal.Animal;
import com.zoopark.InterfaceForAnimal.InterfaceForAnimal;

public class Giraffe extends Animal implements InterfaceForAnimal{

    public String getNameAnimal() {
        return "Giraffe";
    }

    @Override
    public void eating() {
        System.out.println("eat leaves");
    }

    @Override
    public String getColors() {
        return "yellow and brown";
    }
}
