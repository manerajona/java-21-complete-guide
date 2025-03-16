package com.manerajona.java.designpatterns.behavioral.command.example1;

public class Client {
    public static void main(String[] args) {

        // creating the receiver
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        // create the command with the associating receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);

        // creating invoker and associate it with the command
        FileInvoker file = FileInvoker.of(openFileCommand);
        // perform action on invoker object
        file.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        FileInvoker.of(writeFileCommand).execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        FileInvoker.of(closeFileCommand).execute();
    }
}
