
public class ColorCode {
    public enum Color {
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF"),
        YELLOW("#FFFF00"),
        BLACK("#000000");

        public final String colorCode;

        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }
    }

    public static void main(String[] args) {
        Color redColor = Color.RED;
        Color greenColor = Color.GREEN;
        Color blueColor = Color.BLUE;
        Color yellowColor = Color.YELLOW;
        Color blackColor = Color.BLACK;

        System.out.println(
                "This is color " + redColor + " and its colorCode is " + redColor.getColorCode() + "\n" +
                        "This is color " + greenColor + " and its colorCode is " + greenColor.getColorCode() + "\n" +
                        "This is color " + blueColor + " and its colorCode is " + blueColor.getColorCode() + "\n" +
                        "This is color " + yellowColor + " and its colorCode is " + yellowColor.getColorCode() + "\n" +
                        "This is color " + blackColor + " and its colorCode is " + blackColor.getColorCode()
        );
    }
}
