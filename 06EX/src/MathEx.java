
public class MathEx {

	public static void main(String[] args) {
		double a = 3.5454;
		System.out.println(Math.PI); // ������ ������
		System.out.println(Math.ceil(a)); // ceil(�ø�)
		System.out.println(Math.floor(a)); // floor(����)
		System.out.println(Math.sqrt(9)); // ������
		// e�� ������ ���ѽ����� ǥ���Ǵ� ���̸� ���� �Ϲ������� ���ǵǰ� �ִ� ������ ���������� ����̴�
		// ��� e�� 2.71828182845904...
		System.out.println(Math.exp(2)); // e�� 2��
		System.out.println(Math.round(3.14)); // �ݿø�
		
		// [1, 45] ������ ������ ���� 5�� �߻�
		System.out.println("�̹��� ����� ��ȣ�� ");
		for(int i=0 ; i<5 ; i++)
			System.out.println((int)(Math.random()*45+1)+"");
		

	}

}
