//Nader K
//Project 8
//December, 2004
//Project8.java



import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Project8 extends JApplet implements ActionListener
{

private JPanel nPanel, sPanel, cPanel;
private JLabel titleLabel, pointsLabel, messageLabel,pingJLabel;
private JButton startJButton, ping1JButton, ping2JButton, ping3JButton, reportJButton;
private BorderLayout layout;
private Container c = getContentPane();
private PinballWindow pw;
private Ball ball;
private boolean keepdrawing;
//private Sweeper s1;
private AudioClip sound1,sound2,sound3,sound4,sound5;
private Sweeper[] sweeper=new Sweeper[3];
private int [] click = {0,0,0};

public void init()


{
	layout = new BorderLayout();
	c.setLayout(layout);

	nPanel = new JPanel();
	sPanel = new JPanel();
	cPanel = new JPanel();

	sound1 = getAudioClip(getDocumentBase(),"spacemusic.au");
	sound2 = getAudioClip(getDocumentBase(),"COMPUTER.au");
	sound3 = getAudioClip(getDocumentBase(),"RETURN.au");
	sound4 = getAudioClip(getDocumentBase(),"DANGER.au");
	sound5 = getAudioClip(getDocumentBase(),"GONG.au");

	titleLabel = new JLabel("PLAY PILOT PINBALL\n");
	titleLabel.setFont(new Font("Serif", Font.BOLD, 35));
	pointsLabel = new JLabel();
	messageLabel = new JLabel("   Press START to Play!");
	messageLabel.setFont(new Font("Monospaced", Font.ITALIC, 18));
	nPanel.add(titleLabel);
	pointsLabel = new JLabel("Total Points");
	pointsLabel.setFont(new Font("Monospaced", Font.ITALIC, 18));
	nPanel.add(pointsLabel);
	pointsLabel.setVisible(false);
	nPanel.add(messageLabel);
	sPanel.add(pointsLabel);

	Icon radioSelected = new ImageIcon("radioSelected.gif");
	Icon radioPressed = new ImageIcon("radioPressed.gif");
	startJButton = new JButton("Start");
	sPanel.add(startJButton);
	startJButton.addActionListener(this);

	ping1JButton = new JButton(radioSelected);
	ping1JButton.setRolloverIcon(radioPressed);
	ping1JButton.setBorderPainted(false);
	sPanel.add(ping1JButton);
	pingJLabel = new JLabel("PING!");
	sPanel.add(pingJLabel);
	ping2JButton = new JButton(radioSelected);
	ping2JButton.setRolloverIcon(radioPressed);
	ping2JButton.setBorderPainted(false);
	sPanel.add(ping2JButton);
	pingJLabel = new JLabel("PING!");
	sPanel.add(pingJLabel);
	ping3JButton = new JButton(radioSelected);
	ping3JButton.setRolloverIcon(radioPressed);
	ping3JButton.setBorderPainted(false);
	sPanel.add(ping3JButton);
	pingJLabel = new JLabel("PING!");
	sPanel.add(pingJLabel);

	reportJButton = new JButton("Report Points");
	sPanel.add(reportJButton);
	reportJButton.addActionListener(this);

	ping1JButton.addActionListener(this);
	ping2JButton.addActionListener(this);
	ping3JButton.addActionListener(this);


	c.add(nPanel, BorderLayout.NORTH);
	c.add(sPanel, BorderLayout.SOUTH);
	c.add(cPanel, BorderLayout.CENTER);

	setSize(640,480);
	setVisible(true);


	}//end init

public void actionPerformed(ActionEvent e)
{
		if(e.getSource()==startJButton)
		{
			pointsLabel.setVisible(false);

			Graphics g = getGraphics();
			pw = new PinballWindow(g);
			pw.start();


			ball = new Ball(g,pw);
			ball.start();
			sound1.play();

			//s1= new Sweeper(g,pw,ball);
			//s1.start();
			for(int i = 0; i< sweeper.length; i++)
			{

			sweeper[i]=new Sweeper(g,pw,ball,i+1);
			sweeper[i].start();

			}
		}

		if(e.getSource()==ping1JButton)
			{
			sound2.play();
			click[0]++;
				if (click[0]%2==0)
				{
					sweeper[0].changeArc(20);
				}
				else
					sweeper[0].changeArc(-15);
			}//end if ping1

			if(e.getSource()==ping2JButton)
						{
						sound3.play();
						click[1]++;
							if (click[1]%2==0)
							{
								sweeper[1].changeArc(20);
							}
			}//end if ping2

			if(e.getSource()==ping3JButton)
						{
						sound4.play();
						click[2]++;
							if (click[2]%2==0)
							{
								sweeper[2].changeArc(20);
							}
			}//end if ping3


	if(e.getSource()==reportJButton)
	{
		int tot=0;
		for(int i = 0; i< sweeper.length; i++)
		{
			tot = tot + sweeper[i].getScore();
		}
		pointsLabel.setText("Score "+tot);
		pointsLabel.setVisible(true);
		sound5.play();

	}
	//repaint();
}


}//end class