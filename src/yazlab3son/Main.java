package yazlab3son;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
  static   int  enBuyukVerim = 0;
  static int masaSayisi;
   static int garsonSayisi;
    static int asciSayisi;
    static int ayrilanMusteriSayisi = 0;

    public static void main(String[] args) {


        JFrame anaFrame = new JFrame();



        int gecenSure = 0;
        ArrayList <Musteri> musteri = new ArrayList<>();
        ArrayList <Musteri> oncelikliMusteri = new ArrayList<>();
        ArrayList <Musteri> toplamMusteriler = new ArrayList<>();
        ArrayList <Musteri> oturanMusteriler = new ArrayList<>();
        ArrayList<Masa> masalar = new ArrayList<>();

        ArrayList<Garson> garsonlar = new ArrayList<>();
        ArrayList<Asci> ascilar = new ArrayList<>();

        JButton sabitAkisModeliButon = new JButton("Sabit Akış Modeli");

        JLabel sonucLabel = new JLabel();
        JLabel toplamSureLabel = new JLabel("Toplam süre (sn) : ");
        JTextField toplamSureTextFiedl = new JTextField();

        JLabel zamanLabel = new JLabel("Müşteri gelme periyodu (sn) : ");
        JTextField zamanTextField = new JTextField();

        JLabel musteriLabel = new JLabel("Müşteri sayısı : ");
        JTextField musteriField = new JTextField();
        JLabel oncelikliMusteriLabel = new JLabel("Öncelikli Müşteri sayısı : ");
        JTextField oncelikliMusteriField = new JTextField();



        sabitAkisModeliButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int verim;

                int ayrilanMusteriTut = 0;

                int toplamGecenSure = 0;
                int sure = Integer.parseInt(toplamSureTextFiedl.getText());
                int periyot = Integer.parseInt(zamanTextField.getText());
                int musteriSayisi = Integer.parseInt(musteriField.getText());
                int oncelikliMusteriSayisi = Integer.parseInt(oncelikliMusteriField.getText());
                int toplamGelecekMusteriSayisi = musteriSayisi + oncelikliMusteriSayisi;
                if(periyot!=0)
                toplamGelecekMusteriSayisi = toplamGelecekMusteriSayisi + (sure/periyot)*(musteriSayisi + oncelikliMusteriSayisi);
                int tutToplamGelecekMusteriSayisi = toplamGelecekMusteriSayisi;

                verim = toplamGelecekMusteriSayisi;


                for (int i = 1; i <5; i++) {
                    for (int j = 1; j < 5; j++) {

                        for (int k = 1; k < 15; k++) {



                          //  System.out.println("başladıı");
                            ayrilanMusteriTut = 0;
                          //  System.out.println(k);

                            masalar.clear();
                            garsonlar.clear();
                            ascilar.clear();

                            for (int l = 0; l < k; l++) {
                                Masa m = new Masa();
                                masalar.add(m);

                            }

                            for (int l = 0; l < j; l++) {
                                Garson g = new Garson();
                                garsonlar.add(g);

                            }

                            for (int l = 0; l < i; l++) {
                                Asci a = new Asci();
                                ascilar.add(a);

                            }

                            toplamGecenSure = 0;


                            if(toplamGecenSure==0)
                            {



                                for (int l = 0; l < oncelikliMusteriSayisi; l++) {
                                    Musteri m = new Musteri();
                                    m.oncelikliMi = true;
                                    oncelikliMusteri.add(m);
                                    toplamMusteriler.add(m);
                                }
                                for (int l = 0; l < musteriSayisi; l++) {
                                    Musteri m = new Musteri();
                                    musteri.add(m);
                                    toplamMusteriler.add(m);
                                }

                                /*
                                for (int l = 0; l < oncelikliMusteri.size(); l++) {
                                 System.out.println("öncelikli " + oncelikliMusteri.get(l));
                                }

                                for (int l = 0; l < musteri.size(); l++) {

                                  System.out.println("müşteri " +musteri.get(l));
                                }
*/
                            }

                            verim = verim - masalar.size() - garsonlar.size() - ascilar.size();

                          //  System.out.println(masalar.size() + " " + garsonlar.size() + " " + ascilar.size());
                            toplamGelecekMusteriSayisi = tutToplamGelecekMusteriSayisi;

                            while(toplamGelecekMusteriSayisi>0)
                            {



                            //    System.out.println("geçen süre: " + toplamGecenSure + " Müşteri sayısı: " + toplamGelecekMusteriSayisi);




                                for (int l = 0; l < masalar.size(); l++) {

                                    if (masalar.get(l).bosMu == true)
                                    {

                                        if(oncelikliMusteri.size() > 0)
                                        {

                                            masalar.get(l).bosMu = false;
                                            oncelikliMusteri.get(0).masaNo = l;
                                            oncelikliMusteri.get(0).bekliyorMu = false;
                                            oturanMusteriler.add(oncelikliMusteri.get(0));
                                       //     System.out.println(masalar.get(l) +  " masası doldu  "  + " oturan müşteri öncelikli: " + oncelikliMusteri.get(0));
                                            oncelikliMusteri.remove(0);



                                        }
                                       else if(musteri.size() > 0)
                                        {

                                            masalar.get(l).bosMu = false;
                                            musteri.get(0).masaNo = l;
                                            musteri.get(0).bekliyorMu = false;
                                            oturanMusteriler.add(musteri.get(0));
                                      //     System.out.println(masalar.get(l) +  " masası doldu  "  + " oturan müşteri : " + musteri.get(0));
                                            musteri.remove(0);


                                        }

                                    }

                                }

                                for (int l = 0; l < garsonlar.size(); l++) {

                                    if(garsonlar.get(l).bosMu == true)
                                    {


                                        for (int m = 0; m < oturanMusteriler.size(); m++) {


                                            if(oturanMusteriler.get(m).siparisSureciBasladiMi == false)
                                            {
                                              //  System.out.println(oturanMusteriler.get(m) + "  siparis süreci başladı  bakan garson: " + garsonlar.get(l) );
                                                garsonlar.get(l).bosMu = false;
                                                oturanMusteriler.get(m).siparisSureciBasladiMi = true;
                                                garsonlar.get(l).musteriNo =  m;
                                                oturanMusteriler.get(m).garsonNo = l;
                                                break;

                                            }

                                        }

                                    }


                                }


                                for (int l = 0; l < oturanMusteriler.size(); l++) {

                                    if(oturanMusteriler.get(l).siparisVerdimi == true)
                                    {
                                        for (int m = 0; m < ascilar.size(); m++) {

                                            if(ascilar.get(m).bosMu1 == true && oturanMusteriler.get(l).yemegiHazirlaniyorMu==false)
                                            {

                                                ascilar.get(m).bosMu1 = false;
                                                ascilar.get(m).musteriNo1 = l;
                                                oturanMusteriler.get(l).yemegiHazirlaniyorMu = true;
                                                //    System.out.println("1 " + ascilar.get(m) + "  yemeği hazırlanmaya başlanan  müşteri " + oturanMusteriler.get(l));
                                            }
                                            else if(ascilar.get(m).bosMu2 == true && oturanMusteriler.get(l).yemegiHazirlaniyorMu==false)

                                            {
                                                ascilar.get(m).bosMu2 = false;
                                                ascilar.get(m).musteriNo2 = l;
                                                oturanMusteriler.get(l).yemegiHazirlaniyorMu = true;
                                                //    System.out.println("2 " + ascilar.get(m) + "  yemeği hazırlanmaya başlanan  müşteri " + oturanMusteriler.get(l));
                                            }

                                        }

                                    }

                                }


                                toplamGecenSure++;

                                //   System.out.println("geçen süre: " + toplamGecenSure );


                                for (int l = 0; l < oturanMusteriler.size(); l++) {

                                    if(oturanMusteriler.get(l).yemekYendiMi == true && oturanMusteriler.get(l).bittiMi == false)
                                    {

                                        masalar.get(oturanMusteriler.get(l).masaNo).bosMu = true;

                                        toplamGelecekMusteriSayisi--;
                                        //    System.out.println(oturanMusteriler.get(l) + " yemeğini yedi ve ödemeyi yaptı gitti " + masalar.get(oturanMusteriler.get(l).masaNo) + " masası boşaldı.  Kalan müşteri : " + toplamGelecekMusteriSayisi);
                                        oturanMusteriler.get(l).bittiMi = true;

                                        break;
                                    }

                                }


                                for (int l = 0; l < oturanMusteriler.size(); l++) {

                                    if(oturanMusteriler.get(l).yemegiHazirMi == true && oturanMusteriler.get(l).yemekYendiMi==false) // ikinci şart eklendi
                                    {
                                        oturanMusteriler.get(l).yemekYemeSuresi++;

                                        if(oturanMusteriler.get(l).yemekYemeSuresi == 3)
                                        {
                                            oturanMusteriler.get(l).yemekYendiMi = true;
                                            //     System.out.println(oturanMusteriler.get(l) + " yemeğini yedi yemek yeme süresi doldu");
                                        }

                                    }

                                }


                                for (int l = 0; l < ascilar.size(); l++) {

                                    if (ascilar.get(l).bosMu1 == false)
                                    {

                                        ascilar.get(l).yemekHazirlamaSuresi1++;

                                        if(ascilar.get(l).yemekHazirlamaSuresi1 == 3)
                                        {

                                            ascilar.get(l).yemekHazirlamaSuresi1 = 0;
                                            ascilar.get(l).bosMu1 = true;
                                            oturanMusteriler.get(ascilar.get(l).musteriNo1).yemegiHazirMi = true;
                                            //   System.out.println(ascilar.get(l) + " 1 " +  oturanMusteriler.get(ascilar.get(l).musteriNo1) + "'in yemeğini hazırladı");
                                            ascilar.get(l).musteriNo1 = -1;
                                        }

                                    }

                                    if (ascilar.get(l).bosMu2 == false)
                                    {
                                        ascilar.get(l).yemekHazirlamaSuresi2++;

                                        if(ascilar.get(l).yemekHazirlamaSuresi2 == 3)
                                        {
                                            ascilar.get(l).yemekHazirlamaSuresi2 = 0;
                                            ascilar.get(l).bosMu2 = true;


                                            oturanMusteriler.get(ascilar.get(l).musteriNo2).yemegiHazirMi = true;
                                            //    System.out.println(ascilar.get(l) + " 2 " +  oturanMusteriler.get(ascilar.get(l).musteriNo2) + "'in yemeğini hazırladı");
                                            ascilar.get(l).musteriNo2 = -1;

                                        }
                                    }



                                }

                                for (int l = 0; l < garsonlar.size(); l++) {

                                    if(garsonlar.get(l).bosMu == false)
                                    {

                                        garsonlar.get(l).siparisAlmaSuresi++;

                                        if(garsonlar.get(l).siparisAlmaSuresi == 2)
                                        {
                                            garsonlar.get(l).bosMu = true;
                                            oturanMusteriler.get(garsonlar.get(l).musteriNo).siparisVerdimi = true;
                                            //     System.out.println(garsonlar.get(l) + " siparisi aldı  " +  oturanMusteriler.get(garsonlar.get(l).musteriNo) + " siparşini verdi");

                                            garsonlar.get(l).siparisAlmaSuresi = 0;
                                            garsonlar.get(l).musteriNo = -1;

                                        }

                                    }

                                }

                                if(toplamGecenSure%periyot == 0 && sure>=toplamGecenSure)
                                {

                                //    System.out.println(toplamGecenSure);
                                    for (int l = 0; l < oncelikliMusteriSayisi; l++) {
                                        Musteri m = new Musteri();
                                        m.oncelikliMi = true;
                                        oncelikliMusteri.add(m);
                                        toplamMusteriler.add(m);
                                    }
                                    for (int l = 0; l < musteriSayisi; l++) {
                                        Musteri m = new Musteri();
                                        musteri.add(m);
                                        toplamMusteriler.add(m);
                                    }

                                    for (int l = 0; l < oncelikliMusteri.size(); l++) {
                                        //        System.out.println("öncelikli müşteri geldi " + oncelikliMusteri.get(l));
                                    }

                                    for (int l = 0; l < musteri.size(); l++) {

                                        //      System.out.println( "normal muşteri " +musteri.get(l));
                                    }


                                }

                                for (int l = 0; l < musteri.size(); l++) {

                                    musteri.get(l).beklemeSuresi++;

                                    //   System.out.println(musteri.get(l) + " " + musteri.get(l).beklemeSuresi);

                                    if(musteri.get(l).beklemeSuresi>20)
                                    {
                                        verim = verim -1;
                                        ayrilanMusteriTut++;



                                        toplamGelecekMusteriSayisi--;
                                        //       System.out.println(musteri.get(l)  + " ayrıldı kalan müşteri sayısı: " + toplamGelecekMusteriSayisi);

                                        musteri.remove(l);
                                    }

                                }
                                for (int l = 0; l < oncelikliMusteri.size(); l++) {
                                    oncelikliMusteri.get(l).beklemeSuresi++;
                                  //  System.out.println(oncelikliMusteri.get(l) + " " + oncelikliMusteri.get(l).beklemeSuresi);
                                //    System.out.println(oncelikliMusteri.get(l).beklemeSuresi + " " + oncelikliMusteri.get(l));

                                    if(oncelikliMusteri.get(l).beklemeSuresi>20)
                                    {
                                        verim = verim-1;
                                        ayrilanMusteriTut++;

                                        toplamGelecekMusteriSayisi--;
                                        //       System.out.println(oncelikliMusteri.get(l)  + " ayrıldı kalan müşteri sayısı: " + toplamGelecekMusteriSayisi);

                                        oncelikliMusteri.remove(l);

                                    }

                                }


                            }
                          //  System.out.println(verim);
                            if(verim > enBuyukVerim)
                            {
                                ayrilanMusteriSayisi = ayrilanMusteriTut;
                                enBuyukVerim = verim;
                                masaSayisi = k;
                                garsonSayisi = j;
                                asciSayisi = i;
                            }
                            verim = tutToplamGelecekMusteriSayisi;
                            oncelikliMusteri.clear();
                            musteri.clear();
                            toplamMusteriler.clear();
                            oturanMusteriler.clear();


                        }


                    }

                }
  // System.out.println("En büyük verim aaaaaaaaaaaaaa" + enBuyukVerim);
    //System.out.println("en son " +  masaSayisi + " " + garsonSayisi + " " + asciSayisi);


                anaFrame.getContentPane().removeAll();
                anaFrame.revalidate();
                anaFrame.repaint();
                String labelText = "<html>"
                        + "Toplam gelen müşteri sayısı: " + tutToplamGelecekMusteriSayisi + "<br>"
                        + "Ayrılan müşteri sayısı: " + ayrilanMusteriSayisi + "<br>"
                        + "Masa sayısı: " + masaSayisi + "<br>"
                        + "Garson sayısı: " + garsonSayisi + "<br>"
                        + "Aşçı sayısı: " + asciSayisi + "<br>"
                        + "Verim: " + tutToplamGelecekMusteriSayisi + "-" + ayrilanMusteriSayisi + "-"
                        + masaSayisi + "-" + garsonSayisi + "-" + asciSayisi + "= " + enBuyukVerim
                        + "</html>";                sonucLabel.setForeground(Color.black);

                Font currentFont = sonucLabel.getFont();
                Font newFont = currentFont.deriveFont(Font.PLAIN, 20);

                sonucLabel.setFont(newFont);
                sonucLabel.setText(labelText);
                anaFrame.add(sonucLabel);

            }
        });





        sabitAkisModeliButon.setBounds(50,300,150,30);
        toplamSureLabel.setBounds(10,10,110,30);
        toplamSureTextFiedl.setBounds(200,10,100,30);
        zamanLabel.setBounds(10,50,180,30);
        zamanTextField.setBounds(200,50,100,30);
        musteriLabel.setBounds(10,90,100,30);
        musteriField.setBounds(200,90,100,30);
        oncelikliMusteriLabel.setBounds(10,130,150,30);
        oncelikliMusteriField.setBounds(200,130,100,30);
        sonucLabel.setBounds(300,200,300,300);


        anaFrame.add(sabitAkisModeliButon);

        anaFrame.add(toplamSureLabel);
        anaFrame.add(toplamSureTextFiedl);
        anaFrame.add(zamanLabel);
        anaFrame.add(zamanTextField);
        anaFrame.add(musteriLabel);
        anaFrame.add(musteriField);
        anaFrame.add(oncelikliMusteriField);
        anaFrame.add(oncelikliMusteriLabel);
        anaFrame.getContentPane().setBackground(Color.GRAY);  // R:240 G:240 B:240


        anaFrame.setSize(1000, 700);









        anaFrame.setLayout(null);
        anaFrame.setVisible(true);




    }
}