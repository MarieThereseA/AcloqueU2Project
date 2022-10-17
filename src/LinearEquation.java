import java.text.DecimalFormat;
public class LinearEquation {
    DecimalFormat formatter = new DecimalFormat("#.##");

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

    public String Slope(){
        double numerator = y2 - y1;
        double denominator = x2 - x1;
        String slope = numerator / denominator + "";
        slope = formatter.format(slope);
        return slope;
    }

    public String Distance(){
        double Distance = Math.Math.sqrt(x2-x1) + Math.sqrt(y2-y1)
        return dist;
    }
}
