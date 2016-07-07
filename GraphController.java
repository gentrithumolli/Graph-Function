public class GraphController
{
   public static void main(String[] args)
   {
      double[] x = new double[400];
      double[] y = new double[400];
      double distance = 20.0/400;
      double p = -10;
      for(int i = 0; i<400; i++)
         {
            x[i] = p;
            //The function that is going to be drawn
            y[i] = p*p+6*p;
            p = p + distance;
         }
      new GraphWriter().setPoints(x, y);
   }
}