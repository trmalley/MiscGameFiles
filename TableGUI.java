package Pong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TableGUI{
	
	private JFrame frame;
	private Panel panel;
	final private int frameW = 750;
	final private int frameH = 450;
	
	
	private Paddle paddleL;
	private Paddle paddleR;
	private Ball ball;

	
	private int paddleL_X = 10;
	private int paddleR_X = 710;
	private int paddleL_Y = 150;
	private int paddleR_Y = 150;
	private int ball_X = 0;
	private int ball_Y = 0;
	
	
	//private JButton button;
	
	public TableGUI() {
		frame = new JFrame("PONG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameW, frameH);
		
		
		paddleL = new Paddle(paddleL_X, paddleL_Y);
		paddleL.setBackground(Color.WHITE);
		
		paddleR = new Paddle(paddleR_X, paddleR_Y);
		paddleR.setBackground(Color.WHITE);


		ball = new Ball(ball_X, ball_Y);
		ball.setBackground(Color.BLACK);
		ball.setOpaque(false);

		panel = new Panel(paddleL,paddleR, ball);
		panel.setBackground(Color.BLACK);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		//paddleR = new Paddle(paddleR_X, paddleR_Y);
		//paddleL.setBorder(BorderFactory.createLineBorder(Color.RED));	
		setFrame();
	}
	
	private void setFrame() {
		
		panel.add(paddleL);//, BorderLayout.LINE_START);
		panel.add(paddleR);//, BorderLayout.LINE_START);
		panel.add(ball);

		
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	



	
	//public void updatePaddleR(int y) {
	//	paddleR.update(y);
	//	paddleR.repaint(y);
	//}
		
}
