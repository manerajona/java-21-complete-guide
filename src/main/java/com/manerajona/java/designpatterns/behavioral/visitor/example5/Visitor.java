package com.manerajona.java.designpatterns.behavioral.visitor.example5;

interface Visitor {
}

/**
 * A visitor for generic ExpressionAcyclic types.
 */
interface ExpressionAcyclicVisitor extends Visitor {
    /**
     * Default visit method for an ExpressionAcyclic.
     * Implementations can override this for common behavior.
     */
    default void visit(ExpressionAcyclic expression) {
        // Default implementation: do nothing or throw an exception if desired.
    }
}

/**
 * A visitor for DoubleExpressionAcyclic.
 */
interface DoubleExpressionAcyclicVisitor extends Visitor {
    void visit(DoubleExpressionAcyclic doubleExpression);
}

/**
 * A visitor for AdditionExpressionAcyclic.
 */
interface AdditionExpressionAcyclicVisitor extends Visitor {
    void visit(AdditionExpressionAcyclic additionExpression);
}

/**
 * Base class for acyclic expressions.
 */
abstract class ExpressionAcyclic {
    /**
     * Accept a visitor. If the visitor is an ExpressionAcyclicVisitor,
     * delegate the call to its visit method.
     *
     * @param visitor the visitor
     */
    public void accept(Visitor visitor) {
        if (visitor instanceof ExpressionAcyclicVisitor acyclicVisitor) {
            acyclicVisitor.visit(this);
        }
    }
}

/**
 * Represents a numeric value in the expression.
 */
class DoubleExpressionAcyclic extends ExpressionAcyclic {
    private final double value;

    public DoubleExpressionAcyclic(double value) {
        this.value = value;
    }

    /**
     * Accept a visitor. If the visitor is a DoubleExpressionAcyclicVisitor, use it;
     * otherwise, fall back to the generic visitor.
     *
     * @param visitor the visitor
     */
    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof DoubleExpressionAcyclicVisitor doubleVisitor) {
            doubleVisitor.visit(this);
        } else {
            super.accept(visitor);
        }
    }

    public double getValue() {
        return value;
    }
}

/**
 * Represents an addition expression with left and right sub-expressions.
 */
class AdditionExpressionAcyclic extends ExpressionAcyclic {
    private final ExpressionAcyclic left;
    private final ExpressionAcyclic right;

    public AdditionExpressionAcyclic(ExpressionAcyclic left, ExpressionAcyclic right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Accept a visitor. If the visitor is an AdditionExpressionAcyclicVisitor, use it;
     * otherwise, fall back to the generic visitor.
     *
     * @param visitor the visitor
     */
    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof AdditionExpressionAcyclicVisitor additionVisitor) {
            additionVisitor.visit(this);
        } else {
            super.accept(visitor);
        }
    }

    public ExpressionAcyclic getLeft() {
        return left;
    }

    public ExpressionAcyclic getRight() {
        return right;
    }
}

/**
 * A visitor implementation that prints the expression.
 */
class ExpressionAcyclicPrinter implements DoubleExpressionAcyclicVisitor, AdditionExpressionAcyclicVisitor {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpressionAcyclic doubleExpression) {
        sb.append(doubleExpression.getValue());
    }

    @Override
    public void visit(AdditionExpressionAcyclic additionExpression) {
        sb.append('(');
        additionExpression.getLeft().accept(this);
        sb.append('+');
        additionExpression.getRight().accept(this);
        sb.append(')');
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}