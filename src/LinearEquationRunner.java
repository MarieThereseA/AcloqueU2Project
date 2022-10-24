import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String one = scan.nextLine();

        System.out.print("Enter coordinate 2: ");
        String two = scan.nextLine();

        one = one.substring(1,2) + " " + one.substring(one.length() - 2, one.length() - 1);
        two = two.substring(1,2) + " " + two.substring(two.length() - 2, two.length() - 1);

        System.out.println(one);
        System.out.println(two);

        String firstX = one.substring(0,1);
        String secondX = two.substring(0,1);
        String firstY = two.substring(2);
        String secondY = one.substring(2);


        int x1 = Integer.parseInt(firstX);
        int x2 = Integer.parseInt(secondX);
        int y1 = Integer.parseInt(firstY);
        int y2 = Integer.parseInt(secondY);

        if (x1==x2){
            System.out.println();
        }else {
            LinearEquation eq = new LinearEquation(x1, x2, y1, y2);
            System.out.println(eq.lineInfo());

            System.out.print("Enter a value for x: ");
            String x = scan.nextLine();
            int xCoord = Integer.parseInt(x);

            System.out.println(eq.coordinateForX(xCoord));
        }



        // Testing
        int x1 = -1;
        int y1 = 5;
        int x2 = 3;
        int y2 = 10;
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println("Equation: " + equation.equation());
        System.out.println("Slope: " + equation.slope());
        System.out.println("y-intercept: " + equation.yIntercept());
        System.out.println("Distance: " + equation.distance());
        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();
        double testX = 4;
        System.out.println("Coordinate for x: " + equation.coordinateForX(testX));


    }
}
