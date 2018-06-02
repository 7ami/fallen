package pingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameThings extends JPanel implements ActionListener,KeyListener

{    private boolean play=false;
	private int ballposX=560;
	private int ScoreOfChong=0;
	private int ScoreOfHong=0;
       private int ballposY=225;
       private Timer timer;
       private int delay=5;
       private int balldirX=-4;
       private int balldirY=-6;
       private int playerY1=250;
    		  private int playerY2=50;
       
       
       public GameThings() {
    	   addKeyListener(this);
    	   setFocusable(true);
    	  setFocusTraversalKeysEnabled(false);
    	   timer=new Timer(delay,this);
    	   timer.start();
       }
	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, 800, 450);
		
		
		g.setColor(Color.black);
		g.fillRect(0,0, 8,440);
		g.fillRect(0,0, 800,8);
		g.fillRect(775,5,12,440);
		g.fillRect(5,405,775,10);
		g.setColor(Color.green);
		g.fillRect(400,5,3,400);
		
		g.setColor(Color.white);
		g.fillRect(345,5,3,400);
		g.fillRect(0,200,345,3);
		g.fillRect(465,200,345,3);
		
		g.setColor(Color.white);
		g.fillRect(465,5,3,400);
		
		
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.setColor(Color.red);
		g.fillRect(0, playerY1, 8,100 );
		g.setColor(Color.blue);
		g.fillRect(775,playerY2, 8,100 );
		if(ballposX<-40|| ballposX>820) {
			
			play=false;
			
			balldirX=0;
			balldirY=0;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,15));
			g.drawString("ScoreOfHong="+ScoreOfHong, 550, 20);
			g.drawString("ScoreOfChong="+ScoreOfChong, 30, 20);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("Press enter to continue",300,200);
			
			
			
		}
		if(ScoreOfChong>5) {
			play=false;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("Chong Won",300,200);
			g.drawString("Press Space to Restart",200,300);
		}
		if(ScoreOfHong>5) {
			play=false;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("Hong Won",300,200);
			g.drawString("Press Space to Restart",200,300);
		}

		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(play) {
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(0, playerY1, 8,100))) {
				balldirX=-balldirX;
			}
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(775, playerY2, 8,100))) {
				balldirX=-balldirX;
			}
			
			if(ballposX==0) {
				ScoreOfHong=ScoreOfHong+1;
				
				
			
			}
			if(ballposX==800) {
				ScoreOfChong=ScoreOfChong+1;
				
			
				
			}
	
		ballposX=ballposX+balldirX;
		ballposY=ballposY+balldirY;
		if(ballposY<0) {
			balldirY=-balldirY;
		}
		if(ballposY>405) {
			balldirY=-balldirY;
		}}
		repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W) {
			if(playerY1<=2) {
				playerY1=2;
			}else {
				moveUp();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_S) {
			if(playerY1>=325) {
				playerY1=325;
			}else {
				moveDown();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(playerY2<=2) {
				playerY2=2;
			}else {
				moveUp2();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(playerY2>=325) {
				playerY2=325;
			}else {
				moveDown2();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!play) {
				play=true;
			ballposX=400;
			ballposY=200;
			balldirX=-4;
			balldirY=-6;
			
			repaint();
			}}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				if(!play) {
					play=true;
				ballposX=400;
				ballposY=200;
				balldirX=-4;
				balldirY=-6;
				playerY1=250;
				playerY2=50;
				ScoreOfChong=0;
				ScoreOfHong=0;
				repaint();
				}
		}
		
		
	}
	private void moveDown2() {
		// TODO Auto-generated method stub
		play=true;
		playerY2+=25;
		
	}
	private void moveUp2() {
		// TODO Auto-generated method stub
		play=true;
		playerY2-=25;
		
	}
	private void moveDown() {
		// TODO Auto-generated method stub
		play=true;
		playerY1+=25;
		
	}
	private void moveUp() {
		// TODO Auto-generated method stub
		play=true;
		playerY1-=25;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
