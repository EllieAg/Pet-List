package com.example.petapplication;

public class Pet {
    private int id;
    private String petName;
    private String petBreed;
    private int petWeight;
    private String petDesc;

    // constructor
    public Pet(int id, String petName, String petBreed, int petWeight, String petDesc) {
        this.id = id;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petWeight = petWeight;
        this.petDesc = petDesc;
    }

    public Pet() {
    }

    // toString
    @Override
    public String toString() {
        return "Pet Name: " + petName + "\tPet Breed: " + petBreed +
                "\nPet Weight: " + petWeight + "\tDescription: " + petDesc;
    }

    // setter and getter of ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // setter and getter of name
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    // setter and getter of breed
    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    // setter and getter of weight
    public int getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(int petWeight) {
        this.petWeight = petWeight;
    }

    // setter and getter of description
    public String getPetDesc() {
        return petDesc;
    }

    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
    }
}
