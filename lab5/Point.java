public  class Point extends Shape{

    Point(double x, double y){
        m_x = x;
        m_y = y;
    }

    public String getName(){
        return "Point";
    }

    public String toString(){
        return "[" + m_x + ", " + m_y + "]";
    } 

    protected double m_x, m_y;
}