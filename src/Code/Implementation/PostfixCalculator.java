package Code.Implementation;

import Code.Interfaces.IPostfixCalculator;
import Code.Interfaces.Token;
import Code.Lib.ColorChanger;
import Code.Lib.LabelMarker;
import Code.Lib.LinkedListStack;

import java.util.ArrayList;

public class PostfixCalculator implements IPostfixCalculator
{
    // # Fields
    private final LinkedListStack<Token> tokenStack;

    public PostfixCalculator()
    {
        tokenStack = new LinkedListStack<>();
    }

    // NOTE: Evaluate a list of Tokens...
    @Override public int evaluateExpression(ArrayList<Token> tokenList) throws Exception
    {
        if(tokenList.isEmpty())
        {
            throw new Exception(LabelMarker.makeLabel("ERROR","red","Expression missing!"));
        }
        boolean isFirst = true;
        for (Token token: tokenList)
        {
            // # Check if the first token is an operator
            if(isOperator(token) && isFirst)
            {
                throw new Exception(ColorChanger.RED()+"Invalid expression - FIRST TOKEN OPERATOR"+ColorChanger.RESET());
            }
            isFirst = false;

            if(isOperator(token))
            {
              tokenStack.push(new Operand(doOperation(tokenStack.pop(),tokenStack.pop(),token)));
            }
            else
            {
                tokenStack.push(token);
            }
        }

        // # If it went through the entire list without an operator -> Throw exception!
        int expressionTotal = (int) tokenStack.pop().getValue();

        if(!tokenStack.isEmpty())
        {
            throw new Exception(ColorChanger.RED()+"Invalid expression - STACK NOT EMPTY"+ColorChanger.RESET());
        }

        return expressionTotal;
    }

    // # IsOperator?
    private boolean isOperator(Token token) throws Exception
    {
        // # CHECK IF TOKEN IS STRING?
        if(!(token.getValue() instanceof String tokenAsString))
        {
            return false;
        }

        switch (tokenAsString)
        {
            case "+", "*", "-", "/" -> {return true;}
            default -> throw new Exception(ColorChanger.RED() + "Invalid Operator" + ColorChanger.RESET());
        }
    }

    // # Operations
    private int doOperation(Token num1, Token num2, Token operator) throws Exception {
        // ! CHECK FOR NULL
        if(num1 == null | num2 == null | operator == null)
        {
            throw new Exception(ColorChanger.RED()+"Invalid Operation"+ColorChanger.RESET());
        }

        // NOTE: Extract number from Operand
        int valueOne = (int) num1.getValue();
        int valueTwo = (int) num2.getValue();
        String operatorAsString = (String) operator.getValue();

        // ¤ CHECK OPERATOR
        switch (operatorAsString)
        {
            case "+" ->
            {

                System.out.println(LabelMarker.makeLabel("ADD","Green",valueOne + " + " + valueTwo + " = " + (valueOne + valueTwo)));
                return valueOne + valueTwo;
            }
            case "-" ->
            {
                System.out.println(LabelMarker.makeLabel("MINUS","RED",valueOne + " - " + valueTwo + " = " + (valueOne - valueTwo)));
                return valueOne - valueTwo;
            }
            case "*" ->
            {
                System.out.println(LabelMarker.makeLabel("MULTIPLY","blue",valueOne + " * " + valueTwo + " = " + (valueOne * valueTwo)));
                return valueOne * valueTwo;
            }
            case "/" ->
            {
                System.out.println(LabelMarker.makeLabel("DIVIDE","yellow",valueOne + " / " + valueTwo + " = " + (valueOne / valueTwo)));
                return valueOne / valueTwo;
            }
        }

        // ! RETURN 0 IF SOMETHING WENT WRONG!
        return 0;
    }



}
