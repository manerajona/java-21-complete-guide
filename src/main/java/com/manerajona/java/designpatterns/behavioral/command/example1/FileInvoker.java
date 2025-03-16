package com.manerajona.java.designpatterns.behavioral.command.example1;

class FileInvoker implements Command {

    private final Command command;

    private FileInvoker(Command command) {
        this.command = command;
    }

    static FileInvoker of(Command command) {
        return new FileInvoker(command);
    }

    @Override
    public void execute() {
        this.command.execute();
    }
}
