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

    /**
     *
     * @param color
     * @return
     */
    public static int statusAsInt(StatusColor color) {
        return switch (color) {
            case GREEN -> 0;
            case YELLOW -> 1;
            case AMBER -> 2;
            case RED -> 3;
            default -> throw new IllegalArgumentException(color + " is not a valid status color");
        };
    }

}
