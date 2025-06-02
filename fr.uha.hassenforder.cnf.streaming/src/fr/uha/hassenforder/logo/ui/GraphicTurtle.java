package fr.uha.hassenforder.logo.ui;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicTurtle {

	private Graphics g;
	private Turtle turtle;
	private Color color;
	private int oldx, oldy;
	
	public GraphicTurtle (Graphics g) {
		this.g = g;
		this.turtle = new Turtle ();
	}

	public void frame (int w, int h) {
		turtle.frame (w, h);
		g.drawRect(1, 1, w-2, h-2);
		turtle.home ();
	}

	public void home () {
		turtle.home ();
		color = new Color (0x00000000);
		oldx = turtle.getX();
		oldy = turtle.getY();
	}

	private void drawLine () {
		if (turtle.isPenDown()) {
			g.drawLine(oldx, oldy, turtle.getX(), turtle.getY());
		}
	}

	private void drawText (String text) {
		if (turtle.isPenDown()) {
			g.drawString(text, turtle.getX(), turtle.getY());
		}
	}

	private void shift (int x, int y) {
		oldx = turtle.getX();
		oldy = turtle.getY();
		turtle.shift (x, y);
		drawLine ();
	}

	public void up (int d) {
		shift (0, d);
	}

	public void down (int d) {
		shift (0, -d);
	}

	public void right (int d) {
		shift (d, 0);
	}

	public void left (int d) {
		shift (-d, 0);
	}

	public void go (int x, int y) {
		oldx = turtle.getX();
		oldy = turtle.getY();
		turtle.go (x, y);
		drawLine ();
	}

	public void move (int d) {
		oldx = turtle.getX();
		oldy = turtle.getY();
		turtle.move (d);
		drawLine ();
	}
	
	public void turn (int a) {
		turtle.turn (a);
	}

	public void penDown () {
		turtle.penDown();
	}
	
	public void penUp () {
		turtle.penUp();
	}
	
	public void ink (int ink) {
		color = new Color(ink);
		g.setColor(color);
	}

	public void plot (String text) {
		drawText(text);
	}
}
