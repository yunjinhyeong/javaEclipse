package java0923;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MemberManager extends JFrame {

	private JPanel p1, p2, p3, p4, panelWest, contentPane; // p1:���̵��ǳ� p2:�н������ǳ� p3:�̸��ǳ� p4:��ư�����ǳ� panelWest: p1, p2, p3, p4 �ǳ�
	private JTextField tfId, tfPasswd, tfName; // tfId: ���̵��ؽ�Ʈ�ʵ� tfPasswd: �н������ؽ�Ʈ�ʵ� tfName: �̸��ؽ�Ʈ�ʵ�
	private JButton btnTotal, btnAdd, btnDel; // ���� ��ü��ȸ �߰� ���� ��ư
	private JTable table; // ��ü��ȸ�� ��Ÿ���� ���̺�

	private MemberDao memberDao = new MemberDao(); // MemberDaoŬ������ ����

	public MemberManager() {
		setTitle("������ ȸ������ ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��ġ GridLayout(3,1)
		panelWest = new JPanel(new GridLayout(3, 1)); // JPanel�� Ȱ��ȭ ��Ŵ�� ���ÿ� GridLayout���� ���� 3�� 1��
		// �г� p1 ���̵� tfId
		p1 = new JPanel();
		p1.add(new JLabel("���̵�"));
		p1.add(tfId = new JTextField(10));
		panelWest.add(p1);
		// �г� p2 �н����� tfPasswd
		p2 = new JPanel();
		p2.add(new JLabel("�н�����"));
		p2.add(tfPasswd = new JTextField(10));
		panelWest.add(p2);
		// �г� p3 �н����� tfPasswd
		p3 = new JPanel();
		p3.add(new JLabel("�̸�"));
		p3.add(tfName = new JTextField(10));
		panelWest.add(p3);

		// �г� p4 ��ư���� - ��ü���� �߰� ����
		p4 = new JPanel();
		p4.add(btnTotal = new JButton("��ü����"));
		p4.add(btnAdd = new JButton("�߰�"));
		p4.add(btnDel = new JButton("����"));

		contentPane = (JPanel) getContentPane();
		contentPane.add(panelWest, BorderLayout.WEST);
		contentPane.add(p4, BorderLayout.SOUTH);

		// ��ư �̺�Ʈ �����ϱ�
//		btnTotal.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				showAllMembers(contentPane);
//			}
//		});

		btnTotal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAllMembers();
			}
		});

		// ȸ��id�޾ƿ� �����ϱ�
		btnDel.addActionListener((e) -> {
			// ����� �Է� id�� ��������
			String id = tfId.getText().trim();
			// �Է� ���̵� ������ �����ϱ�
			if (id.length() == 0) {
				// ���̵� ������ "������ ���̵� �Է��ϼ���" ���̾�α�
				JOptionPane.showMessageDialog(MemberManager.this, "������ ���̵� �Է��ϼ���.");
				tfId.requestFocus();
				return;
			}
			
			// �������� �ʴ� ���̵�� "������ ���̵� �����ϴ�."
			MemberVo memberVo = memberDao.getMemberById(id);
			if(memberVo==null) {
				JOptionPane.showMessageDialog(MemberManager.this, "������ ���̵� �����ϴ�.");
				return;
			}
			
			int result = JOptionPane.showConfirmDialog(MemberManager.this,
					"���̵�"+id+"������ �����Ͻðڽ��ϱ�?", "ȸ������", JOptionPane.OK_CANCEL_OPTION);
			if (id.length() == JOptionPane.CANCEL_OPTION) {
				// ���� ����! ���̾�α�
				return;				
			}
			memberDao.deleteById(id);
			JOptionPane.showMessageDialog(MemberManager.this, "���� ����!");
			
			tfId.setText("");
			showAllMembers();
		});
		// �������̽��� ������ �߻�޼ҵ尡 1���� ���
		// ���ٽ����� ����ؼ� ǥ���� ������.
		btnAdd.addActionListener((event) -> {
			// �Է»����� �Է°��� ������ null�� �ƴϰ� ���ڿ�("")�̴�.
			String id = tfId.getText().trim(); // trim �� ���鹮�� ��������
			String passwd = tfPasswd.getText().trim();
			String name = tfName.getText().trim();

			if (id.length() == 0 || passwd.length() == 0 || name.length() == 0) {
				JOptionPane.showMessageDialog(MemberManager.this, "�ʼ������� �Է��ϼ���.");
				return;
			}

			MemberVo memberVo = new MemberVo(id, passwd, name);
			memberDao.addMember(memberVo);

			JOptionPane.showMessageDialog(MemberManager.this, "ȸ������ ����");
			showAllMembers();

			tfId.setText("");
			tfPasswd.setText("");
			tfName.setText("");
		});

		setLocationByPlatform(true); // â �ߴ� ��ġ�� ������ �ü�� ��������
		setSize(700, 300);
		setVisible(true);
	} // MemberManager()

	void showAllMembers() {
		// List ����ü ���� : ArrayList, Vector

		// DB�κ��� �����͸� List�� ��ȸ
		List<MemberVo> list = memberDao.getAllMembers();

		Vector<Vector<Object>> datas = getVectorFromList(list);

		// ������� Vector��ü �غ�
		Vector columnNames = new Vector();
		columnNames.add("���̵�");
		columnNames.add("�н�����");
		columnNames.add("�̸�");
		columnNames.add("���Գ�¥");

		table = new JTable(datas, columnNames);

		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

		setVisible(true); // ȭ�鰻���ؼ� ���̱�
	}

	// Vector<Vector<Object>> datas = getVectorFromList(list);
	public Vector<Vector<Object>> getVectorFromList(List<MemberVo> list) {

		Vector<Vector<Object>> vector = new Vector<>();
		for (MemberVo memberVo : list) {
			Vector<Object> row = new Vector<>();
			row.add(memberVo.getId());
			row.add(memberVo.getPasswd());
			row.add(memberVo.getName());
			row.add(memberVo.getRegDate());

			vector.add(row);
		}
		return vector;
	} // getVectorFromList()

	public static void main(String[] args) {
		new MemberManager();
	} // main

}
