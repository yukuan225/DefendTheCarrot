
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerhandle implements ActionListener {
    Register register;
    PreparedStatement ps;

    public registerhandle(Register register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "注册") {
            if (register.username.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "账号不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else if (register.password.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "密码不能为空！", "警告", JOptionPane.WARNING_MESSAGE);

            }
            else {//添加账号密码到数据库
//                String name = register.getText_user0().getText();
//                String account = register.getText_user().getText();
//                String password = String.valueOf(register.getText_pass().getPassword());

                try {
                    Connection con = new mysql().getCon();
                    String sql = "insert into user values (?,?)";
                    ps = con.prepareStatement(sql);//获取prepareStatement
                    ps.setString(1, register.username.getText());
                    ps.setString(2, register.password.getText());

                    int res = ps.executeUpdate();
                    if(res!=0){
                        JOptionPane.showMessageDialog(null, "注册成功！", "注册消息", JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "注册失败！", "注册消息", JOptionPane.PLAIN_MESSAGE);
                    con.close();
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}

