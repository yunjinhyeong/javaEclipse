package ex04;

public class song {
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public song(int year, String country, String artist, String title ) {
		this.title=title;
		this.artist=artist;
		this.year=year;
		this.country=country;
	}
	
	public void show() {
		System.out.println(year+"�� "+country+"������ "+artist+"�� �θ� "+title);
	}
}
