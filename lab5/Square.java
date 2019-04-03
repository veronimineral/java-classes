public class Square extends Point{

        Square(double side, double x, double y){
            super(x,y);
            m_side = side;
        }

        public String getName(){
            return "Square";
        }

        public double area(){
            return m_side * m_side;
        }

        public String toString(){
            return "Corner = " + super.toString() + "; side = " + m_side;
        }

        protected double m_side;
}