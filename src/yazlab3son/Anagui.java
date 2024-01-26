package yazlab3son;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Anagui {

	public static int musterisay=1;
	
    public static Yemekclass genelyemek_sayisi = new Yemekclass();//genel yemek sayisi
    public static ArrayList<Thread> beklemeListesiArrayList = new ArrayList<>();//bekleyen musteriler

    //problem1 txt yolu
    public static String problem1yoluString = "problem1.txt";
    public static int adimsayac = 1;
    public static int kontroloturan = 0;

    public static void main(String[] args) {
        genelyemek_sayisi.yemeksayisi = 1;
        //garsonu burada threadledik
        Garson_THREADLA.main(args);
        //kasayı oluştur
      /*thread öldürme:
	   * void extracted()

	  {
	  
	  stop();
	  }
	  */

       
        
        JFrame anaguiFrame = new JFrame("ana frame");

        JButton gonderbtn = new JButton();
        gonderbtn.setText("gönder");
        gonderbtn.setBounds(370, 100, 90, 40);


        JTextArea yaziArea = new JTextArea();
        yaziArea.setBounds(0, 100, 350, 60);

        gonderbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                kontroloturan = 0;
                adimsayac = 1;

                // Gönder butonuna tıklandığında textarea içindeki veriyi al
                System.out.println("veriyi yazarken su şekilde yaz:19musteri-7öncelikli");
                String yazi = yaziArea.getText();
                System.out.println("Butona tıklandı! Alınan veri: " + yazi);


                String ilkonceliksizString = yazi.substring(0, yazi.indexOf("m"));

                System.out.println(ilkonceliksizString);

                String ilkoncelikliString = yazi.substring(yazi.indexOf("i") + 2, yazi.indexOf("ö"));
                System.out.println(ilkoncelikliString);


                try (FileWriter fileWriter = new FileWriter(problem1yoluString, false);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                    // Dosyaya yazılacak metin
                    String metin = "Adım" + adimsayac + ":" + ilkonceliksizString + " musteri geldi ." + ilkoncelikliString + " öncelikli musteri var";

                    // Metni dosyaya yaz
                    bufferedWriter.write(metin);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }


                // Burada alınan veriyi istediğiniz şekilde kullanabilirsiniz.
                Musteri_THREADLA.oncelikli_musteri_sayi = Integer.parseInt(ilkoncelikliString);
                Musteri_THREADLA.onceliksiz_musteri_sayi = Integer.parseInt(ilkonceliksizString);
                Musteri_THREADLA.main(args);
           
                //bayrak=true;
                
                
                    Garsongui.main(args);
                 
                    kasa_THREADLA.main(args);
            	
                    kasaGui.main(args);
            
                Garsongui.Garson_Siparis_vermeisi_bittimi = false;
            }
        });

        //asci,garson ve kasa guisi

        JButton kasabuton = new JButton();
        kasabuton.setText("KASA Arayüzü");
        kasabuton.setBounds(250, 300, 170, 40);

        kasabuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        //  anaguiFrame.add(kasabuton);
        anaguiFrame.getContentPane().setBackground(Color.BLUE);
        anaguiFrame.add(yaziArea);
        anaguiFrame.add(gonderbtn);
        anaguiFrame.setLocation(0, 0);
        anaguiFrame.setSize(500, 500);
        anaguiFrame.setLayout(null);
        anaguiFrame.setVisible(true);
    }
}