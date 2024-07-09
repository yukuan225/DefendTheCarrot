import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetAPIAnswer {
    public static void start() {
        JFrame frame = new JFrame("星火大模型案例");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("请输入问题：");
        JTextArea textArea1 = new JTextArea(10, 70);
        //textArea1可以滚动
        JScrollPane scrollPane1 = new JScrollPane(textArea1);

        JLabel label2 = new JLabel("答案：");
        JTextArea textArea2 = new JTextArea(10, 60);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        JButton button = new JButton("提问");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = textArea1.getText();

                //创建大模型对象
                BigModelNew bigModelNew = new BigModelNew("1",false);
                String answer = null;
                try {
                    //调用方法、调用答案的方法获取答案
                    answer = bigModelNew.getAnswer(data);
                    textArea2.setText(answer);//填充到文本框中
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        frame.add(label);
        frame.add(scrollPane1);
      //  frame.add(textArea1);
        //添加换行
        frame.add(new JLabel("\n"));
        frame.add(label2);
        frame.add(scrollPane2);
      //  frame.add(textArea2);
        frame.add(button);

        frame.setVisible(true);
    }
}