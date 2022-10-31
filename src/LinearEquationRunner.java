import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Welcome + Coordinate input
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String one = scan.nextLine();

        System.out.print("Enter coordinate 2: ");
        String two = scan.nextLine();

        // Parsing x and y values
        String firstX = one.substring(one.indexOf("(") + 1, one.indexOf(","));
        String secondX = two.substring(two.indexOf("(") + 1, two.indexOf(","));
        String firstY = one.substring(one.indexOf(" ") + 1, one.indexOf(")"));
        String secondY = two.substring(two.indexOf(" ") + 1 , two.indexOf(")"));

        int x1 = Integer.parseInt(firstX);
        int x2 = Integer.parseInt(secondX);
        int y1 = Integer.parseInt(firstY);
        int y2 = Integer.parseInt(secondY);

        // Checking for vertical line
        if (x1==x2){
            System.out.println("These points are on a vertical line: x = " + x1);
        }else {
            LinearEquation eq = new LinearEquation(x1, y1, x2, y2);
            System.out.println(eq.lineInfo());

            //X value input
            System.out.print("Enter a value for x: ");
            String x = scan.nextLine();
            double xCoord = Double.parseDouble(x);

            System.out.println(eq.coordinateForX(xCoord));
        }
    }
}
