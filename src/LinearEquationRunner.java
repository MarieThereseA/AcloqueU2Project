import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        /*System.out.println("Welcome!");
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

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(y1);
        System.out.println(y2); */

        LinearEquation l = new LinearEquation(2,4,5,7);
        System.out.println(l.roundToHundred(7.875));
        System.out.println(l.slope());
        System.out.println(l.distance());
        System.out.println(l.yIntercept());
        System.out.println(l.equation());
        System.out.println(l.coordinateForX(9));

    }
}
