package practice03;

import java.util.Scanner;

public class ex16 {

	public static void main(String[] args) {
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		Scanner sc = new Scanner(System.in);
		String str [] = { "����", "����", "��" };
		int n = (int)(Math.random()*3);
		do {
			System.out.print("���� ���� ��! >> ");
			String attack = sc.next();
			n = (int)(Math.random()*3);
			if(attack.equals(str[n])) {
				System.out.println("�����ϴ�..");
			} else if(attack.equals("����") && str[n].equals("��")) {
				System.out.println("����� = ����, ��ǻ�� = ��, ��ǻ�Ͱ� �����ϴ�..");
			} else if(attack.equals("����") && str[n].equals("����")) {
				System.out.println("����� = ����, ��ǻ�� = ����, �ٽ��ϼ���.");
			} else if(attack.equals("��") && str[n].equals("����")) {
				System.out.println("����� = ��, ��ǻ�� = ����, ��ǻ�Ͱ� �̰���ϴ�.");
			} else if(attack.equals("��") && str[n].equals("����")) {
				System.out.println("����� = ��, ��ǻ�� = ����, ��ǻ�Ͱ� �̰���ϴ�.");
			} else if(attack.equals("����") && str[n].equals("����")) {
				System.out.println("����� = ����, ��ǻ�� = ����, ��ǻ�Ͱ� �̰���ϴ�.");
			} else if(attack.equals("����") && str[n].equals("��")) {
				System.out.println("����� = ����, ��ǻ�� = ��, ��ǻ�Ͱ� �̰���ϴ�.");
			} else if(attack.equals("�׸�")) {
				System.out.println("������ �����մϴ�...");
				sc.close();
				return;
			}
		} while(str[n].equals("����") || str[n].equals("��") || str[n].equals("����"));
		
	}
}
