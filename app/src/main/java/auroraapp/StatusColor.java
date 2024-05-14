package auroraapp;

public enum StatusColor {

    GREEN,
    YELLOW,
    AMBER,
    RED;


    public static boolean matchesString(String value) {

        for ( StatusColor color : StatusColor.values() ) {

            if (  color.name().equals(value)  ) {
                return true;
            }
        }

        return false;

    }

}
