package com.manerajona.java.designpatterns.visitor;

abstract class ExpVisitor {
    abstract void visit(Value value);

    abstract void visit(AdditionExp ae);

    abstract void visit(MultiplicationExp me);
}

abstract class Exp {
    abstract void accept(ExpVisitor ev);
}

class Value extends Exp {
    public int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    void accept(ExpVisitor ev) {
        ev.visit(this);
    }
}

class AdditionExp extends Exp {
    public Exp lhs, rhs;

    public AdditionExp(Exp lhs, Exp rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    void accept(ExpVisitor ev) {
        ev.visit(this);
    }
}

class MultiplicationExp extends Exp {
    public Exp lhs, rhs;

    public MultiplicationExp(Exp lhs, Exp rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    void accept(ExpVisitor ev) {
        ev.visit(this);
    }
}

class ExpPrinter extends ExpVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    void visit(Value value) {
        sb.append(value.value);
    }

    @Override
    void visit(AdditionExp ae) {
        sb.append("(");
        ae.lhs.accept(this);
        sb.append("+");
        ae.rhs.accept(this);
        sb.append(")");
    }

    @Override
    void visit(MultiplicationExp me) {
        me.lhs.accept(this);
        sb.append("*");
        me.rhs.accept(this);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}