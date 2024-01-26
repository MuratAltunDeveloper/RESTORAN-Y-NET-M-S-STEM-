package yazlab3son;



import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ascigui {
    private static final int asci_yemekhazırlamazaman = 3000;//asci yemek hazırlama zaman ms cinsinden
    //zamanlama bayrak
    public static int musteri_yemekyemesüresi = 2000;
    public static boolean zamanlamabayrak = true;
    public static JTextArea siparisAlinanlarTextArea = new JTextArea();
    public static JTextArea hazirlananYemeklerTextArea = new JTextArea();


    public static ArrayList<Thread> oturansiparis = new ArrayList<>();
    public static ArrayList<Thread> kasalistesiaktarma = new ArrayList<>();
    public static ArrayList<Thread> kasalistesi = new ArrayList<>();

    //hangi thread yemeğini yapıyor onu sayma
    public static int sayac = 0;

    public static int kacyemekyapacak_bul() {

        int yemeksayi = 0;
        if ((oturansiparis.size()) >= 2) {// iki yemek alsın

            yemeksayi = 2;
            oturansiparis.remove(0);
            oturansiparis.remove(0);
        } else {
            // tek yemek alsın
            System.out.println("girdi");
            yemeksayi = 1;

            oturansiparis.remove(0);
        }

        return yemeksayi;
    }

    public static void main(String[] args) {


        JFrame asciFrame = new JFrame("Aşçı Frame");
        asciFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asciFrame.setSize(500, 500);
        asciFrame.setLayout(new GridLayout(1, 2)); // Dikine ikiye bölen GridLayout

        // Sipariş Alınanlar Paneli
        JPanel siparisAlinanlarPanel = new JPanel();
        siparisAlinanlarPanel.setLayout(new BorderLayout());

        siparisAlinanlarTextArea.setEditable(false);
        JScrollPane siparisAlinanlarScrollPane = new JScrollPane(siparisAlinanlarTextArea);
        siparisAlinanlarPanel.add(siparisAlinanlarScrollPane, BorderLayout.CENTER);

        JButton siparisAlButton = new JButton("Sipariş Al");
        siparisAlinanlarPanel.add(siparisAlButton, BorderLayout.SOUTH);
        //bu kısım aşçının şiparişalıp şiparişi hazırlama kısmı


        if (zamanlamabayrak == true) {

            if (Anagui.kontroloturan < 1) {
                System.out.println("?????******????????" + oturansiparis);
            }

            //kasalistesi.clear();
            kasalistesiaktarma.addAll(oturansiparis);

            Anagui.kontroloturan++;

            System.err.println("ŞİPARİŞ ALDI");
            //aşçıların yemek şeçim işi
            System.out.println("ASCİ GUİ");
            System.out.println("oturansiparis" + oturansiparis);
            System.out.println("oturansiparis length:" + oturansiparis.size());

            Asci_THREADLE2.topyemeksayisi = oturansiparis.size();
            Asci_THREADLE2.main(args);
            System.out.println(" Asci_THREADLE2.main(args) DONDU7777777777");

            //oturan bayragı silmeden once bunları Grasongui bul ve öyle sil

            zamanlamabayrak = false;

        }

        // Hazırlanan Yemekler Paneli
        JPanel hazirlananYemeklerPanel = new JPanel();
        hazirlananYemeklerPanel.setLayout(new BorderLayout());


        hazirlananYemeklerTextArea.setEditable(false);
        JScrollPane hazirlananYemeklerScrollPane = new JScrollPane(hazirlananYemeklerTextArea);
        hazirlananYemeklerPanel.add(hazirlananYemeklerScrollPane, BorderLayout.CENTER);

        JButton yemekHazirButton = new JButton("Yemek Hazır");
        hazirlananYemeklerPanel.add(yemekHazirButton, BorderLayout.SOUTH);


//bu kısımda kodu 3sn bekletmek(uyutmak)istiyorum
        System.out.println("Yemek hazırlanması için. belirli saniye bekleniyor...");


        Timer timer = new Timer(asci_yemekhazırlamazaman, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Yemek servise hazır!");
                //text hazır olduğunu yazdırma

                try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString, true);
                     BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {


                    bufferedWriter2.append("şipariler hazırlandı,yeni şiparişler için beklemede");
                    bufferedWriter2.newLine();
                    bufferedWriter2.close();

                } catch (IOException e2) {
                    e2.printStackTrace();
                }


                //aşçının yemek hazırlama zamanı
                zamanlamabayrak = true;


                ((Timer) evt.getSource()).stop(); // Timer'ı durdur
                hazirlananYemeklerTextArea.append("yemekler hazırlandı\n");


                //direkt yemekler hazırlandıktan sonra yiyorlar gibi düsün


                System.out.println("müşteri yemek yiyiyor");
                Timer timer = new Timer(musteri_yemekyemesüresi, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        System.out.println("müşteri yemeğini bitirdi");
                        //aşçının yemek hazırlama zamanı
                        zamanlamabayrak = true;

                        kasalistesi.addAll(kasalistesiaktarma);
                        kasaGui.kasaTextArea.setText("");
                        int say2=1;
                        for(Thread list : kasalistesi){
                            kasaGui.kasaTextArea.append("müşteri: "+ say2 +"\n");
                      say2++;
                        
                      
                        
                        }

                        kasalistesiaktarma.clear();
                        System.out.println("müşteri kasa aktarmadan silindi. " + kasalistesiaktarma);

                        ((Timer) evt.getSource()).stop(); // Timer'ı durdur

                    }
                });
                timer.start();

//**gorselleştirme ve kasalistesi sıra  kısmına bak


                System.out.println("??????----------??????????" + oturansiparis);

                ////burdakaldımmmdımdımdımmmmm
              //  Garsongui.gorsellestir();

            }
        });
        timer.start();


        JButton garsonyemeklerial = new JButton("Garson yemekleri alabilir");
        garsonyemeklerial.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //yemeklerini yiyen müsterileri kaldırma;


                Garsongui.musteriyemekye = true;
                zamanlamabayrak = true;
                //Garson_siparisalma.main(args);


            }
        });


        hazirlananYemeklerPanel.add(garsonyemeklerial, BorderLayout.NORTH);


        // Panelleri JFrame'e ekleme
        asciFrame.add(siparisAlinanlarPanel);
        asciFrame.add(hazirlananYemeklerPanel);
        asciFrame.setLocation(1001, 0);
        asciFrame.setVisible(true);
    }
}
