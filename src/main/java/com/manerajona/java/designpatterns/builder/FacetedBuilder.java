package com.manerajona.java.designpatterns.builder;

class FacetedBuilder
{
  public static void main(String[] args)
  {
    PersonaBuilder pb = new PersonaBuilder();
    Persona person = pb
            .named("Jonathan")

            .lives()
            .at("123 London Road")
            .in("London")
            .withPostcode("SW12BC")

            .works()
            .at("Fabrikam")
            .asA("Engineer")
            .earning(123000)

            .build();
    System.out.println(person);
  }
}

class Persona
{
  public String name;
  // address
  public String streetAddress, postcode, city;

  // employment
  public String companyName, position;
  public int annualIncome;

  @Override
  public String toString()
  {
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
}

// builder facade
class PersonaBuilder
{
  // the object we're going to build
  protected Persona person = new Persona(); // reference!
  private String name;

  public PersonJobBuilder works()
  {
    return new PersonJobBuilder(person);
  }

  public PersonAddressBuilder lives()
  {
    return new PersonAddressBuilder(person);
  }

  public PersonaBuilder named(String name) {
    person.name = name;
    return this;
  }

  public Persona build()
  {
    return person;
  }
}

class PersonAddressBuilder extends PersonaBuilder
{
  public PersonAddressBuilder(Persona person)
  {
    this.person = person;
  }

  public PersonAddressBuilder at(String streetAddress)
  {
    person.streetAddress = streetAddress;
    return this;
  }

  public PersonAddressBuilder withPostcode(String postcode)
  {
    person.postcode = postcode;
    return this;
  }

  public PersonAddressBuilder in(String city)
  {
    person.city = city;
    return this;
  }
}

class PersonJobBuilder extends PersonaBuilder
{
  public PersonJobBuilder(Persona person)
  {
    this.person = person;
  }

  public PersonJobBuilder at(String companyName)
  {
    person.companyName = companyName;
    return this;
  }

  public PersonJobBuilder asA(String position)
  {
    person.position = position;
    return this;
  }

  public PersonJobBuilder earning(int annualIncome)
  {
    person.annualIncome = annualIncome;
    return this;
  }
}