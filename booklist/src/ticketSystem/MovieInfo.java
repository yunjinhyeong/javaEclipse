package ticketSystem;

public class MovieInfo {
	private String ticketNum;
	private String moiveName;
	private int ticketPrice;
	private int seatNum;
	private int startTime;
	
	
	public MovieInfo(String ticketNum, String moiveName, int ticketPrice, int seatNum, int startTime) {
		this.ticketNum=ticketNum;
		this.moiveName=moiveName;
		this.ticketPrice=ticketPrice;
		this.seatNum=seatNum;
		this.startTime=startTime;
	}
	public void info() {
		System.out.println("Ƽ�Ϲ�ȣ = "+ticketNum+"\n"
							+"��ȭ�� ="+moiveName+"\n"
							+"Ƽ�ϰ��� ="+ticketPrice+"\n"
							+"�¼���ȣ ="+seatNum+"\n"
							+"�󿵽ð�= "+startTime+"\n\n");
	}

	
}
