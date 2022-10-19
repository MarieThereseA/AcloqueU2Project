public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

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
        slope = roundToHundred(slope);
        return slope;
    }

    public double distance(){
        double dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return dist;
    }

    public double yIntercept(){
        double m = slope();
        double intercept = -1 * (m * x1) + y1;
        intercept = roundToHundred(intercept);
        return intercept;
    }

    public String equation(){
        double b = yIntercept();
        double m = 0;
        double nume = y2 - y1;
        double deno = x2 - x1;
        String equation = "";
        if (deno < 0){
            deno = Math.abs(deno);
            nume = nume * -1;
            equation = "y = " + nume + "/" + deno + "x + " + b;
        }
        if (nume % deno == 0 ){
            m = nume / deno;
            equation = "y = " + m + "x + " + b;
        }
        return equation;
    }

    public String coordinateForX(double xVal){
        double y = slope() * xVal + yIntercept();
        y = roundToHundred(y);
        String coord = "(" + xVal + ", " + y + ")";
        return coord;
    }

    public double roundToHundred(double num){
        double roundedNum = 0;
        String number = num + "";
        int decimal = number.indexOf(".");
        if (decimal == -1){
            return num;
        }
        if (decimal + 2 < number.length()) {
            int wholeNum = Integer.parseInt(number.substring(0, decimal));
            int tenth = Integer.parseInt(number.substring(decimal + 1, decimal + 2));
            int hundredth = Integer.parseInt(number.substring(decimal + 2, decimal + 3));
            int thousandth = Integer.parseInt(number.substring(decimal + 3, decimal + 4));
            double decimalPlace = (tenth * 10.0) + hundredth + (thousandth / 10.0);
            decimalPlace = Math.round(decimalPlace);
            if (decimalPlace == 100) {
                wholeNum++;
                roundedNum = wholeNum;
            } else if (decimalPlace < 100) {
                roundedNum = wholeNum + (decimalPlace / 100);
            }
        }else {
            return num;
        }
        return roundedNum;
    }
}
