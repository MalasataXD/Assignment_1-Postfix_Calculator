package Test;

import Code.Implementation.Operand;
import Code.Implementation.Operator;
import Code.Implementation.PostfixCalculator;
import Code.Interfaces.Token;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CalculatorTest
{
    private PostfixCalculator calculator;
    private ArrayList<Token> tokens;

    @Before public void setup()
    {
        calculator = new PostfixCalculator();
        tokens = new ArrayList<>();
    }

    // NOTE: Evaluate without Expression
    @Test(expected = RuntimeException.class) public void EvaluateWithoutExpression()
    {
        try
        {
            calculator.evaluateExpression(tokens);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: ONE OPERAND
    @Test(expected = RuntimeException.class) public void EvaluateWithOneOPERAND()
    {
        tokens.add(new Operand(3));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: MANY OPERANDS
    @Test(expected = RuntimeException.class) public void EvaluateWithManyOPERANDS()
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operand(5));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: ONE OPERATOR
    @Test(expected = RuntimeException.class) public void EvaluateWithOneOPERATOR()
    {
        tokens.add(new Operator("+"));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: MANY OPERATORS
    @Test(expected = RuntimeException.class) public void EvaluateWithManyOPERATORS()
    {
        tokens.add(new Operator("+"));
        tokens.add(new Operator("+"));
        tokens.add(new Operator("+"));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: WRONG TYPE OPERATOR
    @Test(expected = RuntimeException.class) public void WrongTypeOperator()
    {
        tokens.add(new Operator("a"));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: WRONG SYNTAX
    @Test(expected = RuntimeException.class) public void WrongSyntax()
    {
        tokens.add(new Operator("+"));
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test(expected = RuntimeException.class) public void WrongSyntaxTwo()
    {
        tokens.add(new Operand(3));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(4));
        try
        {
            calculator.evaluateExpression(new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: DIFFERENT EXPRESSION
    @Test public void Example1() throws Exception
    {
        tokens.add(new Operand(5));
        tokens.add(new Operand(4));
        tokens.add(new Operand(5));
        tokens.add(new Operand(10));
        tokens.add(new Operand(10));
        tokens.add(new Operator("+"));
        tokens.add(new Operator("*"));
        tokens.add(new Operator("/"));
        tokens.add(new Operator("-"));
        Assert.assertEquals(20,calculator.evaluateExpression(tokens));
    }
    @Test public void Example2() throws Exception
    {
        tokens.add(new Operand(10));
        tokens.add(new Operand(10));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(4));
        tokens.add(new Operand(5));
        tokens.add(new Operator("*"));
        tokens.add(new Operator("/"));
        tokens.add(new Operand(5));
        tokens.add(new Operator("-"));
        Assert.assertEquals(4,calculator.evaluateExpression(tokens));
    }
    @Test public void Example3() throws Exception
    {
        tokens.add(new Operand(1));
        tokens.add(new Operand(10));
        tokens.add(new Operand(10));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(4));
        tokens.add(new Operand(10));
        tokens.add(new Operator("*"));
        tokens.add(new Operator("/"));
        tokens.add(new Operator("-"));
        Assert.assertEquals(1,calculator.evaluateExpression(tokens));
    }

    // NOTE: ADD TESTS
    @Test public void AddOnce() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operator("+"));
        Assert.assertEquals(7,calculator.evaluateExpression(tokens));
    }
    @Test public void AddMultiple() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(3));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(5));
        tokens.add(new Operator("+"));
        Assert.assertEquals(15,calculator.evaluateExpression(tokens));
    }
    // NOTE: MINUS TESTS
    @Test public void MinusOnce() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operator("-"));
        Assert.assertEquals(1,calculator.evaluateExpression(tokens));
    }
    @Test public void MinusMultiple() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(10));
        tokens.add(new Operator("-"));
        tokens.add(new Operand(10));
        tokens.add(new Operator("-"));
        tokens.add(new Operand(10));
        tokens.add(new Operator("-"));
        Assert.assertEquals(7,calculator.evaluateExpression(tokens));
    }

    // NOTE:MULTIPLY TESTS
    @Test public void MultiplyOnce() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operator("*"));
        Assert.assertEquals(12,calculator.evaluateExpression(tokens));
    }
    @Test public void MultiplyMultiple() throws Exception
    {
        tokens.add(new Operand(3));
        tokens.add(new Operand(4));
        tokens.add(new Operator("*"));
        tokens.add(new Operand(2));
        tokens.add(new Operator("*"));
        tokens.add(new Operand(4));
        tokens.add(new Operator("*"));
        Assert.assertEquals(96,calculator.evaluateExpression(tokens));
    }

    // NOTE: DIVIDE TESTS
    @Test(expected = ArithmeticException.class) public void DivideByZero() throws Exception
    {
        tokens.add(new Operand(0));
        tokens.add(new Operand(4));
        tokens.add(new Operator("/"));
        calculator.evaluateExpression(tokens);
    }
    @Test public void DivideOnce() throws Exception
    {
        tokens.add(new Operand(2));
        tokens.add(new Operand(4));
        tokens.add(new Operator("/"));
        Assert.assertEquals(2,calculator.evaluateExpression(tokens));
    }
    @Test public void DivideMultiple() throws Exception
    {
        tokens.add(new Operand(2));
        tokens.add(new Operand(2));
        tokens.add(new Operand(2));
        tokens.add(new Operand(40));
        tokens.add(new Operator("/"));
        tokens.add(new Operator("/"));
        tokens.add(new Operator("/"));
        Assert.assertEquals(5,calculator.evaluateExpression(tokens));
    }

}