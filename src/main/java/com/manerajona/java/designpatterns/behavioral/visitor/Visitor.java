package com.manerajona.java.designpatterns.behavioral.visitor;


class AcyclicVisitorDemo {
  public static void main(String[] args) {
    AdditionExpressionAcyclic e = new AdditionExpressionAcyclic(
            new DoubleExpressionAcyclic(1),
            new AdditionExpressionAcyclic(
                    new DoubleExpressionAcyclic(2),
                    new DoubleExpressionAcyclic(3)
            )
    );
    ExpressionAcyclicPrinter ep = new ExpressionAcyclicPrinter();
    ep.visit(e);
    System.out.println(ep.toString());
  }
}

// really creepy implementation of acyclic visitor

interface Visitor {
}

interface ExpressionAcyclicVisitor extends Visitor {
    void visit(ExpressionAcyclic obj);
}

interface DoubleExpressionAcyclicVisitor extends Visitor {
    void visit(DoubleExpressionAcyclic obj);
}

interface AdditionExpressionAcyclicVisitor extends Visitor {
    void visit(AdditionExpressionAcyclic obj);
}

abstract class ExpressionAcyclic {
    // optional
    public void accept(Visitor visitor) {
        if (visitor instanceof ExpressionAcyclicVisitor) {
            ((ExpressionAcyclicVisitor) visitor).visit(this);
        }
    }
}

class DoubleExpressionAcyclic extends ExpressionAcyclic {
    public double value;

    public DoubleExpressionAcyclic(double value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof DoubleExpressionAcyclicVisitor) {
            ((DoubleExpressionAcyclicVisitor) visitor).visit(this);
        }
    }
}

class AdditionExpressionAcyclic extends ExpressionAcyclic {
    public ExpressionAcyclic left, right;

    public AdditionExpressionAcyclic(ExpressionAcyclic left, ExpressionAcyclic right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof AdditionExpressionAcyclicVisitor) {
            ((AdditionExpressionAcyclicVisitor) visitor).visit(this);
        }
    }
}

class ExpressionAcyclicPrinter implements DoubleExpressionAcyclicVisitor, AdditionExpressionAcyclicVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpressionAcyclic obj) {
        sb.append(obj.value);
    }

    @Override
    public void visit(AdditionExpressionAcyclic obj) {
        sb.append('(');
        obj.left.accept(this);
        sb.append('+');
        obj.right.accept(this);
        sb.append(')');
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

