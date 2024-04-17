package com.manerajona.java.designprinciples.solid.dependencyinversion.example1;

interface DBConnectionInterface {
    int connect();
}

class MySqlConnection implements DBConnectionInterface {
    public int connect() {
        return 1;
    }
}

class PasswordReminder {
    private final DBConnectionInterface dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection) {
        this.dbConnection = dbConnection;
    }
}