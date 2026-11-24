public class Task3 {

    // NumberFormatException — unchecked, тому throws у заголовку не обов'язковий
    public static int parseID(String input) {
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        String[] ids = {"123", "456", "abc", "789"};

        for (String id : ids) {
            try {
                int value = parseID(id);
                System.out.println("Parsed ID: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + id + "\" is not a valid ID (" + e.getMessage() + ")");
            }
        }
        System.out.println("Done — програма не впала.");
    }
}
