package com.manerajona.java.programming.oop.interfaces;

import com.manerajona.java.programming.oop.interfaces.impl.DeskPhone;
import com.manerajona.java.programming.oop.interfaces.impl.MobilePhone;

public class InterfaceMain {
    public static void main(String[] args) {

        ITelephone telephone1 = new DeskPhone(123456);
        telephone1.powerOn();
        telephone1.callPhone(35734596);
        telephone1.answer();

        ITelephone telephone2 = new MobilePhone(35734596);
        telephone2.powerOn();
        if(telephone2.isRinging()){
            telephone2.answer();
        }

    }



}
