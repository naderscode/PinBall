//Nader K
//Project 8
//December, 2004
//PinBallWindow.java



import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.lang.Object.*;

public class PinballWindow extends Thread
{
	int topy, leftx, width, height,sx,sy;
	Graphics g;
	boolean keepdrawing;
	private Container c ;//= getContentPane();

	public PinballWindow(Graphics g)
	{
		this.g=g;
		keepdrawing=true;
		leftx = 50;
		topy = 50;
		width = 400;
		height = 350;
		sx=100;
		sy=100;
		//c = getContentPane();
		//c.setLayout(new FlowLayout());
	}//end constructor

public int getLeftX()
{
	return leftx;
}

public int getTopY()
{
	return topy;
}

public int getHeight()
{
		return height;
}
public int getWidth()
{
	return width;
}
public void run()
{

		while(keepdrawing==true)
		{
			drawPinballWindow(g);

			try
			{
				Thread.sleep(100);
			}

			catch(InterruptedException ioe)
			{}
		}
}

public void drawPinballWindow(Graphics g)
{
	    g.setColor(new Color(100,100,100));
	    g.fillRect(leftx,topy,width,height);	//draw a rectanglular background

	        // cast g to Graphics2D
		Graphics2D g2d = ( Graphics2D ) g;

		Rectangle2D.Double r2D2 = new Rectangle2D.Double( leftx,topy,width,height );
				Color colE = new Color(6,234,66);
				Color colF = new Color(143,145,53);
				g2d.setPaint( new GradientPaint( sx+80, sy+10, colF, sx+60, sy+40,colE, true) );
				Arc2D.Double a2D2 = new  Arc2D.Double( r2D2, 90,45,Arc2D.Double.PIE);
				g2d.fill(a2D2);


	       // draw 2D ellipse filled with a color gradient
		Color colA = new Color(158,111,251);	//find colors on MS WORD chart
		Color colB = new Color(246,118,164);
		g2d.setPaint( new GradientPaint( sx+40, sy+20, colA, sx+80, sy+80,colB, true ) );
		Ellipse2D.Double e2D = new  Ellipse2D.Double( sx+40, sy+20, sx+80, sy+80 );
	        //fill another ellipse
		g2d.fill(e2D);


		Color colAA = new Color(254,114,91);	//find colors on MS WORD chart
		Color colBB = new Color(238,242,64);
		g2d.setPaint( new GradientPaint( sx+40, sy+20, colAA, sx+80, sy+60,colBB, true ) );
		Ellipse2D.Double e2Dd = new  Ellipse2D.Double( sx+140, sy+120, sx+80, sy+80 );
	        //fill another ellipse
		g2d.fill(e2Dd);

		g.setColor(Color.black);
		g.fillRect(leftx,topy,50,50);

}

public void stopnow()
	{
		keepdrawing = false;
	}

}//end class