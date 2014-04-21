//Nader K
//Project 8
//December, 2004
//Ball.java

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.lang.Object.*;

public class Ball extends Thread
{
	private Graphics g;
	private int bx;
	private int by;
	private int pwTopy,pwLeftx,pwWidth,pwHeight;
	private int speedYvar,changeXvar;
	private int startX, startY;
	private PinballWindow pw;
	private int diameter=15;
	private boolean ballrunning;



	public Ball(Graphics g, PinballWindow pw)
	{
		this.g=g;
		this.pw=pw;

		speedYvar =15;
		changeXvar = 2;

		ballrunning = true;

		//get boundaries
		pwTopy=pw.getTopY();
		pwLeftx=pw.getLeftX();
		pwWidth=pw.getWidth();
		pwHeight=pw.getHeight();


		startX= pw.leftx+pwWidth-diameter;
		startY= pw.topy + pwHeight-diameter;
		bx=startX;
		by=startY;


}// end constructor

	public void drawBall(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillOval(bx,by,diameter,diameter);

	}//end draw

	public void run()
	{
		//g.drawRect(pwTopy,pwLeftx,pwWidth,pwHeight);
		while(ballrunning)
				{

					drawBall(g);

					if(bx+changeXvar<=pwLeftx)
						changeXvar= - changeXvar;

					if(bx+changeXvar>=pwLeftx+pwWidth-diameter)
						changeXvar= - changeXvar;

					if(by+speedYvar <= pwTopy)
						speedYvar = - speedYvar;

					if(by+speedYvar >= pwTopy+pwHeight-diameter)
						speedYvar = - speedYvar;

					bx =bx + changeXvar;
					by =by + speedYvar;

				//g.setColor(Color.green);
				//g.fillOval(bx,by,diameter,diameter);

					if(bx > pwLeftx && bx < pwLeftx+35 && by > pwTopy && by < pwTopy +35)
					{


							stopnow();
							pw.stopnow();
					}
				try
					{
						Thread.sleep(100);
					}

					catch(InterruptedException ioe)
					{}
					// set color to background color
					// increment decrement x y to move ball

				}//while
	}//end run

	public void stopnow()
	{
		ballrunning = false;

	}
	public boolean isRunning()
	{

		return ballrunning;
	}

	public int getBallx()
	{
		return bx;
	}

public int getBally()
	{
		return by;
	}
public void changeY()
{
	 speedYvar = - speedYvar;
}


}// end class