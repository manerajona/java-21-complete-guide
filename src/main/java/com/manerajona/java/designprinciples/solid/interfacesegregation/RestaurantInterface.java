package com.manerajona.java.designprinciples.solid.interfacesegregation;

public interface RestaurantInterface {
    void acceptOnlineOrder();

    void takeTelephoneOrder();

    void payOnline();

    void walkInCustomerOrder();

    void payInPerson();
}

class OnlineClientImpl implements RestaurantInterface {
    @Override
    public void acceptOnlineOrder() {
        //logic for placing online order
    }

    @Override
    public void takeTelephoneOrder() {
        //FIXME Not Applicable for Online Order, refactor fat interface
        throw new UnsupportedOperationException();
    }

    @Override
    public void payOnline() {
        //logic for paying online
    }

    @Override
    public void walkInCustomerOrder() {
        //FIXME Not Applicable for Online Order, refactor fat interface
        throw new UnsupportedOperationException();
    }

    @Override
    public void payInPerson() {
        //FIXME Not Applicable for Online Order, refactor fat interface
        throw new UnsupportedOperationException();
    }
}
