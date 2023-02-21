package Code.Implementation;

import Code.Interfaces.IPostfixCalculator;
import Code.Interfaces.Token;
import Code.Lib.LinkedListStack;

import java.util.ArrayList;

public class PostfixCalculator implements IPostfixCalculator
{
    // # Fields
    private LinkedListStack<Token> tokenStack;
    private int expressionTotal;

    // NOTE: Evaluate a list of Tokens...
    @Override public int evaluateExpression(ArrayList<Token> tokenList)
    {
        return 0;
    }


    //NOTE: Operator cases
    private int doOperation(Operand num1, Operand num2, Operator operator)
    {
        // NOTE: Extract number from Operand
        int valueOne = (int) num1.getValue();
        int valueTwo = (int) num2.getValue();


        switch(operator.getValue())
        {
            case "+":
                return valueOne + valueTwo;
        }
    }



}
