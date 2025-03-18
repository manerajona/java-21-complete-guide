package com.manerajona.java.designpatterns.behavioral.state.example2;

class AlertStateContext {
    private MobileAlertState currentState;

    public AlertStateContext(MobileAlertState initialState) {
        currentState = initialState;
    }

    public void setState(MobileAlertState state) {
        currentState = state;
    }

    public void alert() {
        currentState.alert();
    }
}



