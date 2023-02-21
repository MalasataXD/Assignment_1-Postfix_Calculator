package Code.Implementation;

import Code.Interfaces.Token;

public class Operator implements Token
{
    // # Fields
    private final String operator;

    // ¤ Constructor
    public Operator(String operator)
    {
        this.operator = operator;
    }

    // NOTE: Return the operator
    @Override
    public Object getValue()
    {
        return operator;
    }
}
