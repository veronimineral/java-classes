public class Cube extends Square{

        Cube(double side, double x, double y){
            super(side, x, y);
            m_side = side;
        }

        public String getName(){
            return "Cube";
        }

        public double area(){
            return 6 * super.area();
        }

        public double volume(){
            return super.area() * m_side;
        }

        public String toString(){
            return super.toString() + "; depth = " + m_side;
        }

        protected double m_side;
}