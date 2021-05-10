package it.euris.test.exercise.developerTestEuris.entities;

import it.euris.test.exercise.developerTestEuris.utils.IMappablePro;

public class Articles implements IMappablePro {

    private int identificationcode;
    private String name;
    private String price;

    public Articles(int identificationcode, String name, String price) {
        this.identificationcode = identificationcode;
        this.name = name;
        this.price = price;
    }

    public Articles() {
    }

    public int getIdentificationcode() {
        return identificationcode;
    }

    public void setIdentificationcode(int identificationcode) {
        this.identificationcode = identificationcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "identificationcode=" + identificationcode +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
