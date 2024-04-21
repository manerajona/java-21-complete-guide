package com.manerajona.java.designpatterns.creationals.builder.example4;

class Persona {
    private String name;
    // address
    private String streetAddress;
    private String postcode;
    private String city;
    // employment
    private String companyName;
    private String position;
    private int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }
}

// builder facade
class PersonaBuilder {
    // the object we're going to build
    protected Persona person = new Persona(); // reference!

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonaBuilder name(String name) {
        person.setName(name);
        return this;
    }

    public Persona build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonaBuilder {
    public PersonAddressBuilder(Persona person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.setStreetAddress(streetAddress);
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.setPostcode(postcode);
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.setCity(city);
        return this;
    }
}

class PersonJobBuilder extends PersonaBuilder {
    public PersonJobBuilder(Persona person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.setCompanyName(companyName);
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.setPosition(position);
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.setAnnualIncome(annualIncome);
        return this;
    }
}