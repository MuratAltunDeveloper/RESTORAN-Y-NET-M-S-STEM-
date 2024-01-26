package yazlab3son;

import java.awt.Color;

import javax.swing.*;

public class kasaGui {


    public static JTextArea kasaTextArea = new JTextArea();
    public static JTextArea kasaTextArea1 = new JTextArea();

    public static void main(String[] args) {

        JFrame kasaFrame = new JFrame("Kasa Arayüzü");
        JPanel kasaPanel = new JPanel();
        kasaFrame.setBounds(0,500,1535,310);

        // JTextArea oluştur
      
        JLabel baslik1 = new JLabel("Kasa İşlemleri");
        JScrollPane scrollPane = new JScrollPane(kasaTextArea1);
        scrollPane.setBounds(0, 30, 500, 650); 
        
        baslik1.setBounds(0,0,200,30);
        kasaTextArea1.setBounds(0,30,500,650);
        kasaTextArea1.setEnabled(false);
       // kasaFrame.getContentPane().add(scrollPane);
        kasaTextArea1.setText("");
        
        JLabel baslik = new JLabel("Kasa Sırası");
        baslik.setBounds(550,0,200,30);
        kasaTextArea.setBounds(550,30,200,650);
        kasaTextArea.setEnabled(false);
        kasaPanel.add(baslik1);
      //  kasaPanel.add(scrollPane);
        kasaPanel.add(kasaTextArea1);
        kasaPanel.add(baslik);
        
        kasaPanel.add(kasaTextArea);
        kasaPanel.setLayout(null);

        kasaFrame.add(kasaPanel);
        kasaFrame.getContentPane().setBackground(Color.PINK);
        
        kasaFrame.setVisible(true);
    }


}
