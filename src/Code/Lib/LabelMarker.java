package Code.Lib;

public class LabelMarker
{
    // NOTE: This is used to make Labels
    public static String makeLabel(String label,String labelColor,String message)
    {

        String finalProduct = "";
         finalProduct += ColorChanger.WHITE() + "[";
         finalProduct += SetColor(labelColor) + label;
         finalProduct += ColorChanger.WHITE() + "] " + ColorChanger.RESET();
         if(message != null)
         {
             finalProduct += message;
         }
        return finalProduct;
    }

    private static String SetColor(String color)
    {
        switch(color.toUpperCase()) {
            case "RED" -> {
                return ColorChanger.RED();
            }
            case "BLUE" -> {
                return ColorChanger.BLUE();
            }
            case "YELLOW" -> {
                return ColorChanger.YELLOW();
            }
            case "GREEN" -> {
                return ColorChanger.GREEN();
            }
            case "PURPLE" -> {
                return ColorChanger.PURPLE();
            }
            default -> {return "";}
        }
    }


}
