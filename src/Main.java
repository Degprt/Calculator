import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input:");
            String input = scan.nextLine();
            if (input.equals(""))
                break;
            try {
                Calculator calc = new Calculator();
                System.out.println("Output:\n"  + calc.calculate(input));
            } catch (IllegalArgumentException e) {
                System.out.println("throws Exception " + e.getMessage());
            }
        }
    }
}
