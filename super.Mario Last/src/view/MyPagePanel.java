package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPagePanel extends JPanel {

   ImageIcon icon;
   private JFrame mf;
   private JTextField idField;
   private JTextField passwordField;
   private JTextField namewordField;
   private JTextField hpField;
   private JPanel panel;
   public MyPagePanel(JFrame mf, String array2, String array3) {
      this.mf = mf;
      panel = this;
      this.setVisible(true);
      this.setLayout(null);


      JLabel label = new JLabel(
            new ImageIcon(new ImageIcon("images/mypage_background.PNG").getImage().getScaledInstance(1000, 800, 0)));
      label.setBounds(0, 0, 1000, 800);

      JLabel lblUser = new JLabel(array2+"��");
      lblUser.setBounds(530, 170, 250, 200);
      lblUser.setForeground(Color.WHITE);
      lblUser.setFont(lblUser.getFont().deriveFont(30.0f));
      this.add(lblUser);
      
      JLabel lblid = new JLabel(array3);
      lblid.setBounds(530, 230, 250, 200);
      lblid.setForeground(Color.WHITE);
      lblid.setFont(lblid.getFont().deriveFont(30.0f));
      this.add(lblid);

      passwordField = new JTextField();
      passwordField.setBounds(530, 370, 320, 40);
      this.add(passwordField);
      
    
        
      hpField = new JTextField();
      hpField.setBounds(530, 430, 320, 40);
      this.add(hpField);



      JButton lblSave = new JButton();
      Image save = new ImageIcon("images/save.png").getImage().getScaledInstance(150, 100, 0);
      lblSave.setIcon(new ImageIcon(save));
      lblSave.setBounds(500, 600, 150, 100);
      lblSave.setOpaque(false);
      lblSave.setContentAreaFilled(false);
      lblSave.setBorderPainted(false);


      lblSave.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel cp = new ChangePanel(mf, panel);
            todayCoin back = new todayCoin(mf,array2,array3);
            cp.replacePanel(back);

            try {
               String msg;

               //�ҽ� �����б�;
               BufferedReader br=new BufferedReader(new FileReader(new File("ȸ�����.txt")));

               //��� �������
               File file = new File("ȸ�����2.txt");

               //���ϻ���
               file.createNewFile();
               FileWriter fw = new FileWriter(file);
               BufferedWriter bw = new BufferedWriter(fw);

               //���پ� �д´�
               while((msg=br.readLine())!=null) {
                  //Ư�� ���ڰ� ���Ե� ���� �ǳ� �ٰ�, ���� ���� �� ���Ͽ� ����
                  if(msg.indexOf(array2)<0) {
                     bw.write(msg);
                     bw.write("\n");
                  }
                  //���ٳ�������
                  bw.flush();
               } 
               bw.close();
               fw.close();

               File temp = new File("ȸ�����2.txt"); 
               BufferedWriter bw1 = new BufferedWriter(new FileWriter(temp,true)); 

               PrintWriter pw = new PrintWriter(bw1,true);
               pw.write(array3+ "/");
               pw.write(array2+ "/");
               pw.write(passwordField.getText() + "/");
               pw.write(hpField.getText() + "/");
               pw.write(1000 + "\r\n");

               br.close(); 
               bw1.close();

               FileInputStream fis = new FileInputStream("ȸ�����2.txt");
               FileOutputStream fos = new FileOutputStream("ȸ�����.txt");
               
               int data = 0;
               while((data=fis.read())!=-1) {
                  fos.write(data);
                  
               }
               fis.close();
               fos.close();
               JOptionPane.showMessageDialog(null, "����.");

            } catch (HeadlessException | IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
               JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�.");
            }

         }
      });

   

      
      



      JButton lblback = new JButton();
      Image back = new ImageIcon("images/backButtonWhite.png").getImage().getScaledInstance(50, 50, 0);
      lblback.setIcon(new ImageIcon(back));
      lblback.setBounds(0, 0, 170, 80);
      lblback.setOpaque(false);
      lblback.setContentAreaFilled(false);
      lblback.setBorderPainted(false);
      
      lblback.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel cp = new ChangePanel(mf, panel);
            todayCoin tc = new todayCoin(mf, array2, array3);
         cp.replacePanel(tc);
         }
      });
      this.add(lblback);
      this.add(lblSave);
      this.add(label);
      this.setSize(1000, 800);
   }
}