package Code.Implementation;

import Code.Interfaces.Token;

public class Operand implements Token
{
    // # Fields
    private final int operand;

    // ¤ Constructor
    public Operand(int operand)
    {
        this.operand = operand;
    }

    // NOTE: Return the operand
    @Override
    public Object getValue()
    {
        return operand;
    }
}
