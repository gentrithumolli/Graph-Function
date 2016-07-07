import javax.swing.*;
import java.awt.*;
/**Draws the graph of a function*/
public class GraphWriter extends JPanel
{  
   private double[] x;
   private double[] y;
   private JFrame frame;
   private int total_width = 810;
   private int total_height = 810;
   private int margin = 20;
   private int frame_width = total_width - margin;
   private int frame_height = total_height - margin;
   private int start = 0;
   /**Creates the frame and inserts the panel to the created frame*/
   public GraphWriter()
   {
      frame = new JFrame();
      frame.getContentPane().add(this);
      frame.setSize(total_width+5, total_height+20);
      frame.setVisible(true);
   }
   /**Draws the graph of the function*/
   public void paintComponent(Graphics g)
   {  if(start > 0)
      {
         g.setColor(Color.white);
         g.fillRect(0,0,frame_width + 10,frame_height + 10);
         g.setColor(Color.black);
         g.drawLine(0, frame_height/2, frame_width, frame_height/2);
         g.drawLine(frame_width/2, 0, frame_width/2, frame_height);
         int d = ((frame_width-10)/2)/10;
         for(int k = 1; k<=10; k++)
            {
               g.fillOval(frame_width/2 + k*d, (frame_height)/2, 3, 3);
               g.drawString(k + "",frame_width/2 + k*d - 2, frame_height/2 + 15);
               g.fillOval(frame_width/2 - k*d, (frame_height)/2, 3, 3);
               g.drawString(-k + "",frame_width/2 - k*d - 2, frame_height/2 + 15);
               g.fillOval(frame_width/2, frame_height/2-k*d,3,3);
               g.drawString(k + "",frame_width/2 - 17, frame_height/2 - k*d - 10 + 15);
               g.fillOval(frame_width/2, frame_height/2+k*d,3,3);
               g.drawString(k + "",frame_width/2 - 17, frame_height/2 + k*d - 10 + 15);
            }
         g.setColor(Color.green);
         for(int i = 0; i<399; i++)
         {
            int x1 = (int)( ((x[i] + 10) / 20) * frame_width);
            int y1 = (int)( ((10 - y[i]) / 20) * frame_height);
            int x2 = (int)( ((x[i+1] + 10) / 20) * frame_width);
            int y2 = (int)( ((10 - y[i+1]) / 20) * frame_height);
            if(y1 < frame_height && y2 < frame_height)
            g.drawLine(x1,y1,x2,y2);
         }    
      }
   }
   /**Fills the arrays with the values of the arrays as local parameters*/
   public void setPoints(double[] domain, double[] codomain)
   {
      x = domain;
      y = codomain;
      start = 1;
      repaint();
   }
}