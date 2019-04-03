public class lab2
{
 public static void main(String args[])
 {
  Rnd x=new Rnd(10,100);
  x.Print();
  System.out.println("minimum = "+x.Min());
  System.out.println("maksimum = "+x.Max());
  System.out.println("avg = "+x.Average());
  x.Draw();
 }
}