package java0922;

import java.util.HashSet;
import java.util.Set;

public class Ex2 {

	public static void main(String[] args) {
		// �÷��� : �ڷᱸ�� ������ ������� ��ü�� ���尡��(�⺻�ڷ��� �����ʹ� ���� �Ұ���)
		
		// Set(����) : ������ ���� �ڷᱸ��. �ߺ��� ��� ����.
		// List(���) : ������ �ִ� �ڷᱸ��. ����ũ�� �迭. �ߺ������
		// Map(Ű �� ���� �ڷᱸ��) ��������(Ű,��) ���� �ڷᱸ��.
		// 					Ű�� �ߺ� �Ұ��� -> Ű�� Set���� ������
		
		//Set
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(10);
		set.add(20);
		System.out.println(set.size());
		System.out.println(set.toString());
		System.out.println("____________________________");
		Set<String> strSet = new HashSet<>();
		strSet.add("adsf");
		strSet.add("adsf");
		strSet.add("adsfdf");
		for(String name : strSet) {
			System.out.println(name);
		}
		System.out.println("____________________________");
		Set set2 = new HashSet();
		set2.add(10); // int�� -> Integer�� ��ü�� ��ȯ�Ǽ� �����.
		set2.add("���ڿ�");
		set2.add(new Puppy());
		for(Object name : set2) {
			System.out.println(name);
		}
	}

}
