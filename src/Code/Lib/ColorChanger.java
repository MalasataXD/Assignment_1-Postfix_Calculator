package Code.Lib;

public class ColorChanger
{
    // NOTE: Used to change the color of the Terminal

    public static String RESET()
    {
        return "\u001b[0m";
    }

    public static String RED()
    {
        return "\u001b[31;1m";
    }

    public static String GREEN()
    {
        return "\u001b[32;1m";
    }

    public static String YELLOW()
    {
        return "\u001b[33;1m";
    }

    public static String BLUE()
    {
        return "\u001b[34;1m";
    }

    public static String PURPLE()
    {
        return "\u001b[35;1m";
    }
    public static String WHITE() {return "\u001b[37;1m";}


}
