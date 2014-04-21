//Nader K
//Project 8
//December, 2004
//BallApplet.java

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.lang.Object.*;

public class BallApplet extends JApplet
{
	private Graphics g;
	private int bx,by,bw,bh;
	private int pwTopy,pwLeftx,pwWidth,pwHeight;
	private int speedYvar,changeXvar;
	private int startX, startY;
	private int diameter=10;
	private PinballWindow p;
	private boolean ballrunning;
	public void init(Graphics g, PinballWindow p)
	{
		this.g=g;
				this.p=p;
				//c= getContentPane();
				speedYvar = 2;
				changeXvar = 2;
				startX= p.leftx + p.height - 10;
				startY= p.topy + p.height - 10;
				bx=startX;
				by=startY;
				bw=diameter;
				bh=diameter;
				ballrunning = true;

				//get boundaries
				pwTopy=p.getTopY();
				pwLeftx=p.getLeftX();
				pwWidth=p.getWidth();
				pwHeight=p.getHeight();

}// end constructor

	public void drawBall(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillOval(bx,by,diameter,diameter);

	}//end draw

	public void run()
	{
		while(ballrunning)
				{

					g.drawRect(pwTopy,pwLeftx,pwWidth,pwHeight);
					drawBall(g);
					try
					{
						Thread.sleep(100);
					}

					catch(InterruptedException ioe)
					{}
		}
	}


}// end class