package com.sea.provider.api.request;

import java.io.Serializable;

public class WorldRequest implements Serializable {

    private String person;
    private String animal;


    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
