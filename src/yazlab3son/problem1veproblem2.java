package yazlab3son;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class problem1veproblem2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Restoran Yönetim Sistemi");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            // Arka plan resmini yükle
            ImageIcon backgroundImageIcon = new ImageIcon("C:\\Users\\murat\\OneDrive\\Masaüstü\\restoran.jpeg");
            Image backgroundImage = backgroundImageIcon.getImage();

            // JLabel oluştur ve resmi içine yerleştir
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            frame.add(backgroundLabel, BorderLayout.CENTER);

            // Butonları oluştur ve frame'e ekle
            JButton problem1Button = new JButton("Problem 1");
            JButton problem2Button = new JButton("Problem 2");
            problem1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Problem 1'e tıklanınca yapılacak işlemler
                    try {
                        Anagui.main(args);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            problem2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Problem 2'ye tıklanınca yapılacak işlemler
                    try {
                        Main.main(args);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(problem1Button);
            buttonPanel.add(problem2Button);

            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}





