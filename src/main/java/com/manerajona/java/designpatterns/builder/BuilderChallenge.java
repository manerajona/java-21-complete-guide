package com.manerajona.java.designpatterns.builder;

class BuilderExercise {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}

class CodeBuilder
{
    private StringBuilder sb = new StringBuilder();;
    private String className;

    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        sb
                .append("  ")
                .append("public")
                .append(" ")
                .append(type)
                .append(" ")
                .append(name)
                .append(";")
                .append("\n");
        return this;
    }

    @Override
    public String toString()
    {
        return String.format("public class %s\n{\n%s}", className, sb.toString());
    }
}