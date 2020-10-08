package customMember;

public class CustomManager {
	void run() {
		CustomList cl = new CustomList();
		cl.connect();
		cl.selectManagerList();
		for( int i =0 ; i<cl.custom.length ; i++ ) {
			cl.custom[i].printCustomer();
		}
		cl.closeDB();
	}
}
