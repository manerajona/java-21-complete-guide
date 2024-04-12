package com.manerajona.java.designpatterns.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class SerializationPrototypeDemo
{
  public static void main(String[] args)
  {
    SerializationPrototype foo = new SerializationPrototype(42, "life");
    // use apache commons!
    SerializationPrototype foo2 = SerializationUtils.roundtrip(foo); // brand-new foo

    foo2.whatever = "xyz";

    System.out.println(foo);
    System.out.println(foo2);
  }
}


// some libraries use reflection (no need for Serializable)
class SerializationPrototype implements Serializable
{
  public int stuff;
  public String whatever;

  public SerializationPrototype(int stuff, String whatever)
  {
    this.stuff = stuff;
    this.whatever = whatever;
  }

  @Override
  public String toString()
  {
    return "Foo{" +
      "stuff=" + stuff +
      ", whatever='" + whatever + '\'' +
      '}';
  }
}
