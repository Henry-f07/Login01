import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class login extends JFrame {

	private JPanel contentPane;
	JLabel label,label2;
	JButton btn_login, btn_exit;
	JTextField jTextField,jTextField2;
	JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//
	public login() {
		setTitle("�û���¼����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
    	setLayout(null);
		//�������
		label = new JLabel("�û���:");
		label2 = new JLabel("��    ��:");
		btn_login = new JButton("��¼");
		btn_exit = new JButton("�˳�");
		jTextField = new JTextField();//�ı���
		jTextField2 = new JTextField();//�����
		
		add(label);
		add(jTextField);
		add(label2);
		add(jTextField2);
		add(btn_login);
		add(btn_exit);
		
    	//�������λ�ÿ��
		label.setBounds(130, 50, 80, 30);
		label2.setBounds(130, 90, 80, 20);
		jTextField.setBounds(200, 50, 150, 20);
    	jTextField2.setBounds(200, 90, 150, 20);
    	btn_login.setBounds(100, 150, 100, 30);
    	btn_exit.setBounds(250, 150, 100, 30);
    	
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = jTextField.getText().toString();
				String password = jTextField2.getText().toString();
				if(userName.length()<6||userName.length()>10)//�û����Ƿ�6-10λ
				{
					JOptionPane.showMessageDialog(null,"���Ϸ�");
				}
				else{
					if((userName.charAt(0)>='a'&&userName.charAt(0)<='z')
							||(userName.charAt(0)>='A'&&userName.charAt(0)<='Z'))//�û������ַ�Ϊ��ĸ
					{
						if(password.length()==6)//�����Ƿ�Ϊ��λ
						{
							if(isNumeric(password))//�������ֺϷ�
							{
								JOptionPane.showMessageDialog(null,"�Ϸ�");
							}
							else{
								JOptionPane.showMessageDialog(null,"���Ϸ�");
							}
						}
						else{

							JOptionPane.showMessageDialog(null,"���Ϸ�");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"���Ϸ�");
					}
				}
				
			}
		});
		
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField.setText(" ");
				jTextField2.setText(" ");
				
			}
		});
		this.setVisible(true);//���ÿɼ�

	}
	//�ж��ַ��Ƿ�Ϊ����
	public static boolean isNumeric(String str){
		for(int i=str.length();--i>=0;){
		      int chr=str.charAt(i);
		      if(chr<48 || chr>57)
		         return false;
		   }
		return true;
	}

		

}
