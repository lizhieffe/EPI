package Chap05;

public class Q13 {
	public Rect getIntersect(Rect r1, Rect r2) {
		int tmpx, tmpy;
		int tmpx1, tmpy1;
		
		if (r2.rx >= r1.rx + r1.rw)
			return null;
		tmpx = r2.rx > r1.rx ? r2.rx : r1.rx;
		
		if (r2.rx + r2.rw <= r1.rx)
			return null;
		tmpx1 = r2.rx + r2.rw > r1.rx + r1.rw ? r1.rx + r1.rw : r2.rx + r2.rw;
		
		if (r2.ry >= r1.ry + r1.rh)
			return null;
		tmpy = r2.ry > r1.ry ? r2.ry : r1.ry;
		
		if (r2.ry + r2.rh <= r1.ry)
			return null;
		tmpy1 = r2.ry + r2.rh > r1.ry + r1.rh ? r1.ry + r1.rh : r2.ry + r2.rh;
		
		return new Rect(tmpx, tmpy, tmpx1 - tmpx, tmpy1 - tmpy);
	}
	
	public static void main(String[] args) {
		Rect r1 = new Rect(10, 10, 20, 20);
		Rect r2 = new Rect(5, 5, 10, 10);
		System.out.println(new Q13().getIntersect(r1, r2).toString());
	}
}

class Rect {
	int rx;
	int ry;
	int rw;
	int rh;
	Rect (int rx, int ry, int rw, int rh) {
		this.rx = rx;
		this.ry = ry;
		this.rw = rw;
		this.rh = rh;
	}
	public String toString() {
		return rx + " " + ry + " " + rw + " " + rh;
	}
}
