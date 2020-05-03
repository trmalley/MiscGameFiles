package Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Paddle extends JPanel{

	private int posX;
	private int posY;
	private int paddleSize;
	private int paddleW;
	private int paddleH;
	//Timer time = new Timer(5, this);
	int speed = 10;
	boolean movesUP = false;
	boolean movesDOWN = false;
	
	public Paddle(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.paddleW = 15;
		this.paddleH = 60;

		
	}
	
	@Override
	public void paint(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
    	super.paintComponent(g2); 
        g2.setColor(Color.WHITE);
        //g2.fillRect(getX(),getY(),getW(),getH());
        g2.drawRect(getX(),getY(),getW(),getH());
        
        if(this.movesUP &&this.getY() > 0) {
        	this.setY(this.getY()-speed);
        }
        if(this.movesDOWN && this.getY() < 350) {
        	this.setY(this.getY()+speed);
        }
        //System.out.println("Paint" + " Y"+ getY() );
        //time.start();
    }
	
	  public Dimension getPreferredSize() {
		    return new Dimension(this.getW(), this.getH()); // appropriate constants
		  }
		
    public int getW() {
    	return this.paddleW;
    }
    
    public int getH() {
    	return this.paddleH;
    }
    
	public int getY(){
		return this.posY;
	}
	
	public int getX(){
		return this.posX;
	}
	
	public void setY(int posY){
		this.posY = posY;
	}
	
	public void setX(int posX){
		this.posX = posX;
	}	
	
}
