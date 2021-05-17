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
		setTitle("用户登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
    	setLayout(null);
		//定义组件
		label = new JLabel("用户名:");
		label2 = new JLabel("密    码:");
		btn_login = new JButton("登录");
		btn_exit = new JButton("退出");
		jTextField = new JTextField();//文本框
		jTextField2 = new JTextField();//密码框
		
		add(label);
		add(jTextField);
		add(label2);
		add(jTextField2);
		add(btn_login);
		add(btn_exit);
		
    	//设置组件位置宽高
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
				if(userName.length()<6||userName.length()>10)//用户名是否6-10位
				{
					JOptionPane.showMessageDialog(null,"不合法");
				}
				else{
					if((userName.charAt(0)>='a'&&userName.charAt(0)<='z')
							||(userName.charAt(0)>='A'&&userName.charAt(0)<='Z'))//用户名首字符为字母
					{
						if(password.length()==6)//密码是否为六位
						{
							if(isNumeric(password))//都是数字合法
							{
								JOptionPane.showMessageDialog(null,"合法");
							}
							else{
								JOptionPane.showMessageDialog(null,"不合法");
							}
						}
						else{

							JOptionPane.showMessageDialog(null,"不合法");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"不合法");
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
		this.setVisible(true);//设置可见

	}
	//判断字符是否为数字
	public static boolean isNumeric(String str){
		for(int i=str.length();--i>=0;){
		      int chr=str.charAt(i);
		      if(chr<48 || chr>57)
		         return false;
		   }
		return true;
	}

		

}
