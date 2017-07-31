package snake;


public class Locus { //////////////////////////////////////////////////////////////// Locus

	private int x;
	private int y;

	public Locus(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) return false;
		if (this.getClass() != object.getClass()) return false;
		
		Locus point = (Locus) object;
		if(point.getX() == this.getX() && point.getY() == this.getY()) return true;
		
		return false;
	}
}
