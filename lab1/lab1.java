public class lab1
{
    public static void main(String[] args)
        {
        double R = 1.7;
        double r = 1.2;
        double h = 1.3;
        double x,y;

        for(double t = 1.4; t < 29.65; t += 0.005)
        {
            x = x_value(R,r,h,t);
            y = y_value(R,r,h,t);
            System.out.println(x + " " + y);
        }
    }

    public static double x_value(double R, double r, double h, double t) {
                return (R-r) * Math.cos(t) + h * Math.cos(((R-r)/r) * t);
    }

    public static double y_value(double R, double r, double h, double t) {
                return (R-r) * Math.sin(t) - h * Math.sin(((R-r)/r) * t);
    }
}

