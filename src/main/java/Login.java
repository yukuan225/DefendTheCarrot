import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public static void main(String[] args) {
        new Login();
    }

    JLabel label;
    JLabel label2;
    public static JTextField text_user;
    JPasswordField text_psd;
    JButton button1;
    JButton button2;
    JLabel label3;
    Container container;

    public Login() {

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("登录");
        container = this.getContentPane();

        ImageIcon icon = new ImageIcon("C:/Users/24648/Desktop/DefendTheCarrot/src/main/resources/assets/imgs/menu/mainmenu-title.png");
        Image img1 = icon.getImage();
        Image scaledImg = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // 设置图片的大小
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        imageLabel.setBounds(50, -20, 300, 200); // 设置图片的位置
        container.add(imageLabel);

        label = new JLabel("用户名");
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setBounds(60, 220, 100, 36);
        text_user = new JTextField();
        text_user.setBounds(180, 222, 155, 29);
        container.add(label);
        container.add(text_user);

        label2 = new JLabel("密  码");
        label2.setFont(new Font("宋体", Font.BOLD, 20));
        label2.setBounds(60, 300, 75, 36);
        text_psd = new JPasswordField(10);
        text_psd.setBounds(180, 302, 155, 29);
        container.add(label2);
        container.add(text_psd);

        button1 = new JButton("登录");
        button2 = new JButton("注册");
        button1.setBounds(70, 380, 80, 30);
        button2.setBounds(250, 380, 80, 30);
        button1.addActionListener(new loginhandle(this));
        text_psd.addKeyListener(new loginhandle(this));
        button2.addActionListener(new loginhandle(this));
        container.add(button1);
        container.add(button2);

        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("C:/Users/24648/Desktop/DefendTheCarrot/src/main/resources/assets/imgs/stage1/BG1-hd.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0, 400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getText_user() {
        return text_user;
    }

    public JPasswordField getText_psd() {
        return text_psd;
    }
}
