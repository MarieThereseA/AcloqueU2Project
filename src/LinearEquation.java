public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double slope(){
        double numerator = y2 - y1;
        double denominator = x2 - x1;
        double slope = numerator / denominator ;
        if (numerator == 0){
            slope = 0;
        }
        slope = roundToHundred(slope);
        return slope;
    }

    public double distance(){
        double dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return roundToHundred(dist);
    }

    public double yIntercept(){
        double m = slope();
        double intercept = ((m * x1) - y1);
        if (intercept == 0){ // Making sure -0 isn't printed

        }else {
            intercept /= -1;
        }
        intercept = roundToHundred(intercept);
        return intercept;
    }

    public String equation(){
        double b = yIntercept();
        int m = 0;
        int nume = y2 - y1;
        int deno = x2 - x1;
        String equation = "";
        if (slope() == 0){ // Checking for horizontal line
            equation = "y = " + y1;
        }else {
            if (deno < 0 && nume > 0) { // Moving negative sign
                deno = Math.abs(deno);
                nume = nume * -1;
            }
            if (nume % deno == 0) { // Checking for decimal slope
                m = nume / deno;
                if (m == 1) {
                    equation = "y = x ";
                } else if (m == -1) {
                    equation = "y = -x ";
                } else {
                    equation = "y = " + m + "x ";
                }
                if (b < 0) {
                    equation += "- " + -1 * b;
                } else if (b > 0) {
                    equation += "+ " + b;
                } else {
                }
            } else { // Printing slope as a fraction
                equation = "y = " + nume + "/" + deno + "x ";
                if (b < 0) {
                    equation += "- " + -1 * b;
                } else if (b == 0) {

                } else {
                    equation += "+ " + b;
                }
            }
        }
        return equation;
    }

    public String coordinateForX(double xVal){
        double y = slope() * xVal + yIntercept();
        y = roundToHundred(y);
        String coord = "(" + xVal + ", " + y + ")";
        return coord;
    }

    // rounding tool
    public double roundToHundred(double num){
        boolean numNeg = false;
        double roundedNum = 0;
        String number = num + "";
        int decimal = number.indexOf(".");
        if (decimal == -1){ // Checking if number is a whole number
            return num;
        }else if (decimal + 4 < number.length()) { // Checking if number exceeds hundredth's place
            int wholeNum = Integer.parseInt(number.substring(0, decimal));
            if (wholeNum < 0){ // Temporarily removing negative sign to prevent calculation errors
                wholeNum *= -1;
                numNeg = true; // Tracker variable
            }else if (wholeNum == 0 && number.indexOf("-") != -1){
                numNeg = true;
            }
            int tenth = Integer.parseInt(number.substring(decimal + 1, decimal + 2)); //Finding values for various decimal places
            int hundredth = Integer.parseInt(number.substring(decimal + 2, decimal + 3));
            int thousandth = Integer.parseInt(number.substring(decimal + 3, decimal + 4));
            double decimalPlace = (tenth * 10.0) + hundredth + (thousandth / 10.0); //Making decimal place values a whole number
            decimalPlace = Math.round(decimalPlace); // rounding decimal place
            if (decimalPlace == 100) { // Checking if decimal place rounds to 100
                wholeNum++;
                roundedNum = wholeNum;
            } else if (decimalPlace < 100) {
                roundedNum = wholeNum + (decimalPlace / 100); // Adding rounded decimal place to whole number
                if (numNeg){
                    roundedNum *= -1; // Putting negative sign back
                }
            }
        }else {
            return num;
        }
        return roundedNum;
    }

    public String lineInfo(){
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" ;
        info += "The equation of the line between these points is : " + equation() + "\n";
        info += "The slope of the line is: " + slope() + "\n";
        info += "The y-intercept of the line is: " + yIntercept() + "\n";
        info += "The distance between the two points is: " + distance() + "\n";
        return info;
    }
}
