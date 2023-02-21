import Code.Implementation.Operand;
import Code.Implementation.Operator;
import Code.Implementation.PostfixCalculator;
import Code.Interfaces.Token;
import Code.Lib.ColorChanger;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Token> tokenlist = new ArrayList<>();
        PostfixCalculator calculator = new PostfixCalculator();

        // # (2 3 +) -> 2 + 3 = 5
        tokenlist.add(new Operand(3));
        tokenlist.add(new Operand(2));
        tokenlist.add(new Operator("+"));
        tokenlist.add(new Operand(5));
        tokenlist.add(new Operator("-"));
        try
        {
            System.out.println( ColorChanger.PURPLE() + "[RESULT]: " + calculator.evaluateExpression(tokenlist));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}