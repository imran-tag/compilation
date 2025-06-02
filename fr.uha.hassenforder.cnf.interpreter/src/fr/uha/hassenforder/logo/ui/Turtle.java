package fr.uha.hassenforder.logo.ui;

public class Turtle {
	
	static final double deg2rad = 2.0 * Math.PI / 360.0;

	public Turtle () {
		frame (640, 480);
		home();
	}

	public void frame (int _w, int _h) {
		w = _w;
		h = _h;
	}

	public void home () {
		x = w/2;
		y = h/2;
		a = 0;
		p = true;
	}

	public void shift (int _x, int _y) {
		x += _x;
		y -= _y;
		check ();
	}

	public void go (int _x, int _y) {
		x = _x;
		y = _y;
		check ();
	}

	public void move (int d) {
		x += (int) (d * Math.cos(deg2rad*a));
		y += (int) (d * Math.sin(deg2rad*a));
		check ();
	}

	public void turn (int _a) {
		a += _a;
	}

	public void penDown () {
		p=true;
	}

	public void penUp () {
		p=false;
	}

	public boolean isPenDown () {
		return p;
	}

	public int getX () {
		return x;
	}

	public int getY () {
		return y;
	}

	public void check() {
		if (x<0) x=0;
		if (x>w) x=w-1;
		if (y<0) y=0;
		if (y>h) y=h-1;
	}

	private int w, h;
	private int x, y;
	private int a;
	private boolean p;
}
