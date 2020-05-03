package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Panel extends JPanel implements  KeyListener, ActionListener{
	
	private int panelW;
	private int panelH;
	Timer time = new Timer(5, this);
	Paddle paddle;
	Paddle paddleR;
	Ball ball;
	int speed = 30;
	
	public Panel(Paddle paddle,Paddle paddleR, Ball ball) {
		//this.panelW = w;
		//this.panelH = h;
		this.addKeyListener(this);
		this.setFocusable(true);
        this.requestFocusInWindow();
        
        this.paddle = paddle;
        this.paddleR = paddleR;
        this.ball = ball;
		
	}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
        
        //********WALL HITBOX*************
		if(ball.getX() < ball.MIN_X) {
			ball.setVelocityX(Math.abs(ball.getVelocityX()));
		}else if (ball.getX() + ball.diameter >= ball.MAX_X) {
			ball.setVelocityX(-Math.abs(ball.getVelocityX()));

		}
	
		if(ball.getY()< ball.MIN_Y) {
			ball.setVelocityY(Math.abs(ball.getVelocityY()));

		}else if (ball.getY() + ball.diameter >= ball.MAX_Y) {
			ball.setVelocityY(-Math.abs(ball.getVelocityY()));
		}	
		
		//********************
		
		if (ball.getX() < this.paddle.getX()+this.paddle.getW() && 
				this.ball.getX() + this.ball.getDiameter()>this.paddle.getX()&&
				this.ball.getY() < this.paddle.getY() + this.paddle.getH() && 
				this.ball.getY() + this.ball.getDiameter() > this.paddle.getY()){
			ball.setVelocityX(Math.abs(ball.getVelocityX()));
			//System.out.println("HERE");
		}
		
		if (ball.getX()  + this.ball.getDiameter() > this.paddleR.getX()&&//+this.paddleR.getW() &&
				this.ball.getX() + this.ball.getDiameter() > this.paddleR.getX()&&
				this.ball.getY() < this.paddleR.getY() + this.paddleR.getH() && 
				this.ball.getY() + this.ball.getDiameter() > this.paddleR.getY()){
			ball.setVelocityX(-Math.abs(ball.getVelocityX()));
			//System.out.println("HERE");
		}
		
		//RIGHT PADDLE
		

		
		time.start();
		this.ball.update();
		//check()
        //System.out.println("HERE");
        
    }

    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	};
   

	@Override
	public void keyPressed(KeyEvent e) {
		
		
        if (e.getKeyCode() == KeyEvent.VK_DOWN && this.paddle.getY() > 0) {
        	//System.out.println("UP");
        	this.paddle.movesUP = true;
        	//this.paddle.setY(this.paddle.getY()-speed);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP && this.paddle.getY() < 350) {
        	//System.out.println("Down");
        	this.paddle.movesDOWN = true;
            //this.paddle.setY(this.paddle.getY()+speed);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP && this.paddleR.getY() > 0) {
        	//System.out.println("UP");
        	this.paddleR.movesUP = true;
        	//this.paddle.setY(this.paddle.getY()-speed);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && this.paddleR.getY() < 350) {
        	//System.out.println("Down");
        	this.paddleR.movesDOWN = true;
            //this.paddle.setY(this.paddle.getY()+speed);
        }
        
        
        
        
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		this.paddle.movesUP = false;
		this.paddle.movesDOWN = false;
		this.paddleR.movesUP = false;
		this.paddleR.movesDOWN = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


    }



