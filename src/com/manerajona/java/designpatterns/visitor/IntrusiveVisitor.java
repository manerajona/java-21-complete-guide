package com.manerajona.java.designpatterns.visitor;

class IntrusiveVisitor {
  public static void main(String[] args) {
    // 1+(2+3)
    AdditionExpressionI e = new AdditionExpressionI(
            new DoubleExpressionI(1),
            new AdditionExpressionI(
                    new DoubleExpressionI(2),
                    new DoubleExpressionI(3)
            ));
    StringBuilder sb = new StringBuilder();
    e.print(sb);
    System.out.println(sb);
  }
}


abstract class ExpressionI {
    public abstract void print(StringBuilder sb);
}

class DoubleExpressionI extends ExpressionI {
    private double value;

    public DoubleExpressionI(double value) {
        this.value = value;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append(value);
    }
}

class AdditionExpressionI extends ExpressionI {
    private ExpressionI left, right;

    public AdditionExpressionI(ExpressionI left, ExpressionI right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append("(");
        left.print(sb);
        sb.append("+");
        right.print(sb);
        sb.append(")");
    }
}
