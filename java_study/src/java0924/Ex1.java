package java0924;

class Go {
	
	void go() {
		while (true) {
			System.out.println("go");
		}
	}
}

class Come {
	
	void come() {
		while (true) {
			System.out.println("come");
		}
	}
}

public class Ex1 {

	public static void main(String[] args) {
		// �½�ũ : �۾�
		// ��Ƽ�½�ŷ : �ѹ��� �������� �۾��� �����ϴ°�.
		
		// ���μ��� : �������� ���α׷� �Ѱ�
		// ������ : ���α׷� �Ѱ� �ȿ��� ����Ǵ� �帧 ���� �Ѱ�.
		
		Go g = new Go();
		Come c = new Come();
		
		g.go();
		c.come();
	}

}
