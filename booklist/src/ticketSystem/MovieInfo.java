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
		System.out.println("티켓번호 = "+ticketNum+"\n"
							+"영화명 ="+moiveName+"\n"
							+"티켓가격 ="+ticketPrice+"\n"
							+"좌석번호 ="+seatNum+"\n"
							+"상영시간= "+startTime+"\n\n");
	}

	
}
