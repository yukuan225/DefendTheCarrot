import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import static javafx.application.Application.launch;

/*
本模块主要处理登录和注册的监听事件
 */
public class loginhandle extends KeyAdapter implements ActionListener{
    private Login login;
    public static String user;
    public static String pass;

    public loginhandle(Login login){
        this.login=login;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if("登录".equals(e.getActionCommand())){
            try {
                login();
            } catch (SQLException | ClassNotFoundException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else if("注册".equals(e.getActionCommand())){
            new Register();
        }
    }

    public void login() throws SQLException, ClassNotFoundException, InterruptedException {
        boolean flag=false;//登录成功的标志
        Connection con=new mysql().getCon();
        String sql="select username,password from user";
        Statement sta=con.createStatement();
        ResultSet set =sta.executeQuery(sql);
        ArrayList<String> username=new ArrayList<>();
        ArrayList<String> password=new ArrayList<>();
        while(set.next()) {
            username.add(set.getString(1));
            password.add(set.getString(2));
        }
        for(int j=0;j<username.size();j++){
            if (username.get(j).equals(login.getText_user().getText())&&password.get(j).equals(String.valueOf(login.getText_psd().getPassword()))) {
                login.dispose();
                launch(Main.class);
                flag = true;
            }
        }

        sta.close();
        con.close();
        if(flag==false){
            JOptionPane.showMessageDialog(login,"账号或者密码错误");

        }
        user =login.getText_user().getText();
        char[] ch=login.getText_psd().getPassword();
        pass=String.valueOf(ch);

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyEvent.VK_ENTER==e.getKeyCode()){
            try {
                login();
            } catch (SQLException | ClassNotFoundException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}


