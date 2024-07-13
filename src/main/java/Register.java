import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {


    public static JTextField username;
    public static JTextField password;


    public Register() {
        initialize();//初始化
        this.setBounds(515, 195, 410, 510);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("用户注册");
//        validate();
        this.setVisible(true);
    }
    private void initialize(){
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("C:/Users/24648/Desktop/DefendTheCarrot/src/main/resources/assets/imgs/stage1/BG1-hd.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0, 400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("用户注册");
        label.setBounds(170,100, 120, 25);
        label.setFont(new Font(null, Font.BOLD, 18));// 字体设置
        this.add(label);

        JLabel User = new JLabel("账号");
        User.setBounds(60, 220, 100, 36);
        User.setFont(new Font(null, Font.BOLD, 20));// 字体设置
        this.add(User);

        JLabel Password = new JLabel("密码");
        Password.setBounds(60, 300, 100, 36);
        Password.setFont(new Font(null, Font.BOLD, 20));// 字体设置
        this.add(Password);



        // 文本框和按钮
        username = new JTextField();
        username.setBounds(180, 222, 155, 29);
        this.add(username);
        password = new JPasswordField();
        password.setBounds(180, 302, 155, 29);
        this.add(password);



//        JPanel panel = new JPanel(null);
//        panel.setBounds(250, 60, 300, 300);
//        panel.setBackground(Color.WHITE);
//        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
//        this.add(panel);


        JButton btn = new JButton("注册");
        btn.setBounds(70, 380, 80, 30);
        this.add(btn);
        btn.addActionListener(new registerhandle(this));
        JButton return1=new JButton("返回");
        return1.setBounds(250, 380, 80, 30);
        this.add(return1);
        JLabel Mention=new JLabel("");
        Mention.setBounds(350, 100, 120, 25);
        Mention.setForeground(Color.RED);
        Mention.setFont(new Font(null,Font.BOLD,17));
        this.add(Mention);
        return1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}





