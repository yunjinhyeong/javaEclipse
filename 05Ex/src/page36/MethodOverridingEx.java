package page36;

public class MethodOverridingEx {
	static void paint(shape p) {
		p.draw();
	}
	public static void main(String[] args) {
		Line line = new Line();
		paint(line);
		paint(new shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
