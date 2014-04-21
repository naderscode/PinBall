//Nader K
//Project 8
//December, 2004
//Sweeper.java


import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.lang.Object.*;

public class Sweeper extends Thread
{
	private Graphics g;
	private int x1,x2,x3, y1, y2, y3;
	private int sx,sy,sw,sh;
	private PinballWindow pw;
	private Ball ball;


	private int value;
	private boolean keepsweeping;
	private int speed1, speed2, speed3;
	private int startAngle,arcAngle;
	private int x, y;
	static int score;
	private int index;

	public Sweeper(Graphics g, PinballWindow pw, Ball ball,int index)
	{
		this.g=g;
		this.pw=pw;
		this.ball=ball;
		this.index=index;

		keepsweeping = true;
		score = 20000;

		startAngle=0;
		arcAngle=30;

			x= 100;
		 	y= 80;


		//get boundaries
			int	pwTopy=pw.getTopY();
			int	pwLeftx=pw.getLeftX();
			int	pwWidth=pw.getWidth();
			int	pwHeight=pw.getHeight();

			sx=	pwLeftx+x *index;
			sy = pwTopy+y*index;
			sw = 50;
			sh = 50;

	}//end constructor


	public void drawSweeper(Graphics g)
		{
			if(index==1)
			g.setColor(Color.red);
			if(index==2)
			g.setColor(Color.green);
			if(index==3)
			g.setColor(Color.blue);

			g.fillArc(sx,sy,sw,sh,startAngle,arcAngle);

			if(startAngle >= 360)
			{
				startAngle = 0;
			}
				startAngle +=arcAngle;

		}//end draw


	public void run()
		{
			//g.drawRect(pwTopy,pwLeftx,pwWidth,pwHeight);
			while(keepsweeping)
			{

				drawSweeper(g);



				if(ball.isRunning()==false)
				{
				stopSweeper();
				}
				if(ball.getBallx()>sx && ball.getBallx() < sx+sw &&ball.getBally()> sy && ball.getBally() < sy+sh)
				{
						ball.changeY();
						score -= 250;
				}

				try
				{

						Thread.sleep(100);
				}
				catch(InterruptedException ioe)
						{}
			}

		}//end run

public void stopSweeper()
{
	keepsweeping = false;
}
public void changeArc(int val)
{
	 arcAngle=arcAngle+val;

}
public int getScore()
{
	return score;

}
}//end class