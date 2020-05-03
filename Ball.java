package Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Ball extends JPanel{

	private int ballX;
	private int ballY;
	private int ballH;
	private int ballW;
	private int radius;
	public int diameter;
	final public int MAX_Y = 410;
	final public int MIN_Y = 0;
	final public int MAX_X = 740;
	final public int MIN_X = 0;	
	private float vx, vy;
	boolean ballInPlay = true;

	public Ball(int x, int y) {
		resetBall(x, y);
	}
	
	public void resetBall(int x, int y) {
		this.ballX = x;
		this.ballY = y;
		this.radius = 5;
		this.diameter = this.radius * 2;
		this.vx = 4;
		this.vy = 4;
		System.out.println("BALL");
		
		
	}
	
	@Override
	public void paint(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
    	super.paintComponent(g2); 
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
       
        //g.fillOval(this.ballX -radius, this.ballY -radius, this.diameter, this.diameter);
        //g.setColor(Color.RED);
        //g2.drawOval(this.ballX -radius, this.ballY -radius, this.diameter, this.diameter);
        g2.fillOval(0, 0, this.getDiameter(), this.getDiameter());
        g2.dispose();
        //System.out.println("WHY DOSENT THIS FUCKING WORK");
        

    }
	
	public Dimension getPreferredSize() {
	    return new Dimension (this.diameter, this.diameter); // appropriate constants
	}
	
	public void update() {
		
		this.ballX += this.vx;
		this.ballY += this.vy;
		//System.out.println("Y:" + this.getY());
		//System.out.println("X:" + this.getX());
		if(this.getX() <= MIN_X) {
			System.out.println("HIT MIN!");
			resetBall(MIN_X + 10, MIN_X);
			
		}
		if(this.getX()+this.diameter >= MAX_X) {
			System.out.println("HIT MAX!");
			resetBall(MAX_X - 10, MIN_Y);
			this.setVelocityX(-Math.abs(this.getVelocityX()));
			this.setVelocityX(-Math.abs(this.getVelocityX()));
		}

	}
	
	public int getY() {
		return this.ballY;
	}

	
	public int getX() {
		return this.ballX;
	}
	
	public float getVelocityX(){
		return this.vx;
	}
	
	public float getVelocityY(){
		return this.vy;
	}
	
	public void setVelocityX(float vx){
		this.vx = vx; 
	}
	
	public void setVelocityY(float vy){
		this.vy = vy; 
	}
	public void setY(int posY){
		this.ballY = posY;
	}
	
	public void setX(int posX){
		this.ballX = posX;
	}	
	
	public int getDiameter() {
		return this.diameter;
	}

	
	public void setBallSpeed(int NewSpeed) {
		this.vx = NewSpeed;
		this.vy = NewSpeed;
	}
	
}
