public class Menu {
    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printMenu() {
        String borderTop = "╔══════════════════════╗";
        String borderBottom = "╚══════════════════════╝";
        String header = "║          Candidate Management      ║";
        String option1 = "║  1. Find                           ║";
        String option2 = "║  2. Insert                         ║";
        String option3 = "║  3. Update                         ║";
        String option4 = "║  4. Delete                         ║";
        String option5 = "║  5. Print List                     ║";
        String option6 = "║  6. Save to file                   ║";
        String option7 = "║  7. Exit                           ║";

        System.out.println(ANSI_CYAN + borderTop);
        System.out.println(ANSI_GREEN + header);
        System.out.println(ANSI_CYAN + borderTop);
        System.out.println(ANSI_YELLOW + option1);
        System.out.println(ANSI_YELLOW + option2);
        System.out.println(ANSI_YELLOW + option3);
        System.out.println(ANSI_YELLOW + option4);
        System.out.println(ANSI_YELLOW + option5);
        System.out.println(ANSI_YELLOW + option6);
        System.out.println(ANSI_YELLOW + option7);
        System.out.println(ANSI_CYAN + borderBottom + ANSI_RESET);
    }

    public static void main(String[] args) {
        printMenu();
    }
}
