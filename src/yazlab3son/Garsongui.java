package yazlab3son;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.util.concurrent.atomic.AtomicBoolean;



public class Garsongui {
    public static int beklemezaman=200000;
    public static ArrayList<String> masadurumArrayList=new ArrayList<>();//bos dolu
    
    
    public static int masasayisi =4;
    
    public static int kasasira=0;
    
    public static boolean beklemeisibitti=true;
    
    public static boolean asciilet=false;//asciya siparis iletme kısmı
   
    public static int garsonThreadstart=0;
	
	public static int garson_gelme_sayisi=0;
	
    public static long musteriyemekyemezamani=3000;
	
	public static boolean musteriyemekye=false;
	
	public static boolean Garson_Siparis_vermeisi_bittimi=false;

	public static String Stringgarsonileti="";
    // renkli yazı kısmı
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


   
    public static Thread siparisal(int al)
    {	
    	Thread ara = null;
    	for(int i=0;i<oturanmusterileRunnables.size();i++)
    	{
    		
    		if(oturanmusterileRunnables.get(i).siparis_verdimi==false)
    		{
    			oturanmusterileRunnables.get(i).siparis_verdimi=true;
    			
    			ara=oturanmusterilerArrayList.get(i);
    			
    			break;
    		}
    		
    	}
    	
    	
    	return ara;
    	
    	
    }  
 
    public static void  beklemedeneme()
    {
//OTURAN MUSTERİLERE BEKLEME LİSTESİNDEN BİR eleman ekle

if(Anagui.beklemeListesiArrayList.size()>0)
{
oturanmusterileRunnables.add(new Musteri_Runnable(Anagui.genelyemek_sayisi));
oturanmusterilerArrayList.add(Anagui.beklemeListesiArrayList.get(0));
oturanmusterileRunnables.get(oturanmusterilerArrayList.size()-1).siparis_verdimi=false;
for(int i=0;i<masadurumArrayList.size();i++)
{
if(masadurumArrayList.get(i).equalsIgnoreCase("bos"))
		{
	masadurumArrayList.set(i,"dolu");	
		}

}


Anagui.beklemeListesiArrayList.remove(0);
}
      }

    
    
    


   
    
   //oturan musterilerin arraylisti
    public static ArrayList<Musteri_Runnable> oturanmusterileRunnables=new ArrayList<>();
    public static ArrayList<Thread> oturanmusterilerArrayList = new ArrayList<>();// masaya oturan musteriler


    public static ArrayList<JFrame> musterilerin_masaFrame=new ArrayList<>();//musterilerin oturdugu masa frame
 
	public static JFrame garsonFrame= new JFrame();
	   
    public static int masamesafe=2;
    public static void gorsellestir()
    {    JPanel[] masaPanelleri = new JPanel[masasayisi];
   
    	  //musteriler oturanmusterilerArraylist sırasına göre masaya oturur
         for (int i = 0; i < masasayisi; i++) {
             masaPanelleri[i] = new JPanel();
             masaPanelleri[i].setBounds(2 + (i * (30 + masamesafe)), 50, 30, 50);
             
      
             // Paneli ana frame'e ekle
             garsonFrame.add(masaPanelleri[i]);

         }

         for (int i = 0; i < masadurumArrayList.size(); i++) {

        	 
        	 if(masadurumArrayList.get(i).equalsIgnoreCase("dolu"))
        	 {
             masaPanelleri[i].setBackground(Color.GREEN);
        	 }
        	 else {
        		  masaPanelleri[i].setBackground(Color.RED);
              	
			}
        	 
        	 
         }

       
     
    	
    	
    }
 	
    public static void main(String[] args) {
    	//her girdiğimde masadurumArrayListini sıfırlama
    	masadurumArrayList.clear();
    	oturanmusterilerArrayList.clear();
    	oturanmusterileRunnables.clear();
    	kasaRunnable.index=1;
    	
    	
    	
    	
    	
    	
        JOptionPane.showMessageDialog(
                null,
                "beklemelistesindeki eleman sayısı:"+Anagui.beklemeListesiArrayList.size(),
                "Uyarı",
                JOptionPane.WARNING_MESSAGE
        );
    	
    	
    	
    	//garson gelme sayısını sıfırla
    	if(garson_gelme_sayisi>0)
    	{
    	garson_gelme_sayisi=-1;
    	}
   	
        // eğer bekleyen musteriler,oncelikli musteriler,onceliksiz musteriler toplamı
        // masasayisindan fazla ise

        if (Musteri_THREADLA.onceliklimusteriThreads.size() + Musteri_THREADLA.onceliksizmusteriThreads.size()
                + Anagui.beklemeListesiArrayList.size() > masasayisi) {

            System.out.println("dahaönceden bekleyenler" + Anagui.beklemeListesiArrayList);

            oturanmusterilerArrayList.clear();

            // guide masalar daire ile göster musteri oturmuyorsa yeşil oturuyorsa kırmızı
            // yap
            // onceliklilerden olmak uzere masa sayısı kadar musteri çek
            // kalanları bekleme listesine at

            if (Anagui.beklemeListesiArrayList.size() == 0) {// kimse beklemeiyor

                if (Musteri_THREADLA.onceliklimusteriThreads.size()<= masasayisi) {

                    for (int i = 0; i < Musteri_THREADLA.onceliklimusteriThreads.size(); i++) {

                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                    }
                    int kalanmusteriler = oturanmusterilerArrayList.size();
                    int ata = 0;
                    for (int j = kalanmusteriler; j < masasayisi; j++) {
                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(ata));
                        ata++;
                    }
                    for (int x = ata; x < Musteri_THREADLA.onceliksizmusteriThreads.size(); x++) {
                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(x));
                    }

                } else {

                    int artir = 0;
                    for (int i = 0; i < masasayisi; i++) {
                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                        artir++;
                    }

                    if (Musteri_THREADLA.onceliklimusteriThreads.size() > masasayisi) {

                        for (int j = artir; j < Musteri_THREADLA.onceliklimusteriThreads.size(); j++) {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(j));

                        }
                        for (int y = 0; y < Musteri_THREADLA.onceliksizmusteriThreads.size(); y++) {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(y));
                        }

                    }

                }

            } else {
                // ilk bekleme listesinden eleman çek
                // artarsa bekleme listesinde kalsın

                // bekleme listesindeki eleman sayısı yeterli veya fazla ise
                if (Anagui.beklemeListesiArrayList.size() >= masasayisi) {
                    for (int i = 0; i < masasayisi; i++) {

                        oturanmusterilerArrayList.add(Anagui.beklemeListesiArrayList.get(i));

                    }

                    System.out.println("/BAK" + Anagui.beklemeListesiArrayList);
                    for (int sil = 0; sil < masasayisi; sil++) {
                        Anagui.beklemeListesiArrayList.remove(0);

                    }

                    for (int ekle = 0; ekle < Musteri_THREADLA.onceliklimusteriThreads.size(); ekle++) {

                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(ekle));
                    }
                    for (int ekle2 = 0; ekle2 < Musteri_THREADLA.onceliksizmusteriThreads.size(); ekle2++) {
                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(ekle2));
                    }

                }
                // bekleme listesindeki eleman sayısı azsa
                else {

                    for (int i = 0; i < Anagui.beklemeListesiArrayList.size(); i++) {
                        oturanmusterilerArrayList.add(Anagui.beklemeListesiArrayList.get(i));

                    }
                    for (int sil2 = 0; sil2 < Anagui.beklemeListesiArrayList.size(); sil2++) {
                        Anagui.beklemeListesiArrayList.remove(0);
                    }
                    Anagui.beklemeListesiArrayList.clear();
                    System.out.println(ANSI_BLUE + Anagui.beklemeListesiArrayList + ANSI_RESET);

                    // yeni gelenlerden veri al
                    int masa_copy = masasayisi - oturanmusterilerArrayList.size();

                    System.out.println("masa copy" + masa_copy);

                    // burası
                    System.out.println("--" + Musteri_THREADLA.onceliklimusteriThreads);
                    if (Musteri_THREADLA.onceliklimusteriThreads.size() < masa_copy) {

                        for (int i = 0; i < Musteri_THREADLA.onceliklimusteriThreads.size(); i++) {

                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));

                        }
                        int kalanmasa = masa_copy - Musteri_THREADLA.onceliklimusteriThreads.size();
                        // önceliksizlerden oturt
                        int kontrol = 0;
                        for (int j = 0; j < kalanmasa; j++) {
                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(j));
                            kontrol++;
                        }
                        for (int dn = kontrol; dn < Musteri_THREADLA.onceliksizmusteriThreads.size(); dn++) {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(dn));
                        }

                    } else {

                        int artir = 0;
                        for (int i = 0; i < masa_copy; i++) {
                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                            artir++;
                        }
                        // System.out.println(ANSI_BLUE+Musteri_THREADLA.onceliklimusteriThreads.size()+ANSI_RESET);
                        if (Musteri_THREADLA.onceliklimusteriThreads.size() >= masa_copy) {

                            for (int j = artir; j < Musteri_THREADLA.onceliklimusteriThreads.size(); j++) {
                                Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(j));
                            }
                            System.out
                                    .println(ANSI_RED + "->" + Musteri_THREADLA.onceliksizmusteriThreads + ANSI_RESET);
                            for (int y = 0; y < Musteri_THREADLA.onceliksizmusteriThreads.size(); y++) {// burası hatalı

                                Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(y));
                                System.out.println(ANSI_BLUE + Anagui.beklemeListesiArrayList + ANSI_RESET);
                            }

                        }

                    }

                }

            }

        } else {


            //masalar tam dolmuyor
            int aradeger=masasayisi-(Musteri_THREADLA.onceliksizmusteriThreads.size()+Musteri_THREADLA.onceliklimusteriThreads.size()+Anagui.beklemeListesiArrayList.size());
            System.out.println("*"+aradeger);
            int yenimasasayisi=masasayisi-aradeger;








            System.out.println("dahaönceden bekleyenler"+Anagui.beklemeListesiArrayList);

            oturanmusterilerArrayList.clear();

            //guide masalar daire ile göster musteri oturyorsa yeşil oturmuyorsa kırmızı yap
            //onceliklilerden olmak uzere masa sayısı kadar musteri çek
            //kalanları bekleme listesine at

            if(Anagui.beklemeListesiArrayList.size()==0)
            {//kimse beklemeiyor


                if(Musteri_THREADLA.onceliklimusteriThreads.size()<=yenimasasayisi)
                {

                    for(int i=0;i<Musteri_THREADLA.onceliklimusteriThreads.size();i++)
                    {

                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                    }
                    int kalanmusteriler=oturanmusterilerArrayList.size();
                    int ata=0;
                    for(int  j=kalanmusteriler;j<yenimasasayisi;j++)
                    {
                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(ata));
                        ata++;
                    }
                    for(int x=ata;x<Musteri_THREADLA.onceliksizmusteriThreads.size();x++)
                    {
                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(x));
                    }




                }else {

                    int artir=0;
                    for(int i=0;i<yenimasasayisi;i++)
                    {
                        oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                        artir++;
                    }

                    if(Musteri_THREADLA.onceliklimusteriThreads.size()>yenimasasayisi)
                    {

                        for(int j=artir;j<Musteri_THREADLA.onceliklimusteriThreads.size();j++)
                        {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(j));

                        }
                        for(int y=0;y<Musteri_THREADLA.onceliksizmusteriThreads.size();y++)
                        {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(y));
                        }

                    }






                }


            }else {
                //ilk bekleme listesinden eleman çek
                //artarsa bekleme listesinde kalsın

                //bekleme listesindeki eleman sayısı yeterli veya fazla ise
                if(Anagui.beklemeListesiArrayList.size()>=yenimasasayisi)
                {
                    for(int i=0;i<yenimasasayisi;i++)
                    {

                        oturanmusterilerArrayList.add(Anagui.beklemeListesiArrayList.get(i));

                    }

                    System.out.println("/BAK"+Anagui.beklemeListesiArrayList);
                    for(int sil=0;sil<yenimasasayisi;sil++)
                    {
                        Anagui.beklemeListesiArrayList.remove(0);

                    }

                    for(int ekle=0;ekle<Musteri_THREADLA.onceliklimusteriThreads.size();ekle++)
                    {

                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(ekle));
                    }
                    for(int ekle2=0;ekle2<Musteri_THREADLA.onceliksizmusteriThreads.size();ekle2++)
                    {
                        Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(ekle2));
                    }


                }
                //bekleme listesindeki eleman sayısı azsa
                else {

                    for(int i=0;i<Anagui.beklemeListesiArrayList.size();i++)
                    {
                        oturanmusterilerArrayList.add(Anagui.beklemeListesiArrayList.get(i));


                    }
                    for(int sil2=0;sil2<Anagui.beklemeListesiArrayList.size();sil2++)
                    {
                        Anagui.beklemeListesiArrayList.remove(0);
                    }Anagui.beklemeListesiArrayList.clear();
                    System.out.println(ANSI_BLUE+Anagui.beklemeListesiArrayList+ANSI_RESET);


                    //yeni gelenlerden  veri al
                    int masa_copy=yenimasasayisi-oturanmusterilerArrayList.size();

                    System.out.println("masa copy"+masa_copy);

                    //burası
                    System.out.println("--"+Musteri_THREADLA.onceliklimusteriThreads);
                    if(Musteri_THREADLA.onceliklimusteriThreads.size()<masa_copy)
                    {

                        for(int i=0;i<Musteri_THREADLA.onceliklimusteriThreads.size();i++)
                        {

                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));

                        }
                        int  kalanmasa=masa_copy-Musteri_THREADLA.onceliklimusteriThreads.size();
                        //önceliksizlerden oturt
                        int kontrol=0;
                        for(int j=0;j<kalanmasa;j++)
                        {
                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(j));
                            kontrol++;
                        }
                        for(int dn=kontrol;dn<Musteri_THREADLA.onceliksizmusteriThreads.size();dn++)
                        {
                            Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(dn));
                        }



                    }else {

                        int artir=0;
                        for(int i=0;i<masa_copy;i++)
                        {
                            oturanmusterilerArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(i));
                            artir++;
                        }
                        //	System.out.println(ANSI_BLUE+Musteri_THREADLA.onceliklimusteriThreads.size()+ANSI_RESET);
                        if(Musteri_THREADLA.onceliklimusteriThreads.size()>=masa_copy)
                        {

                            for(int j=artir;j<Musteri_THREADLA.onceliklimusteriThreads.size();j++)
                            {
                                Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliklimusteriThreads.get(j));
                            }
                            System.out.println(ANSI_RED+"->"+Musteri_THREADLA.onceliksizmusteriThreads+ANSI_RESET);
                            for(int y=0;y<Musteri_THREADLA.onceliksizmusteriThreads.size();y++)
                            {//burası hatalı

                                Anagui.beklemeListesiArrayList.add(Musteri_THREADLA.onceliksizmusteriThreads.get(y));
                                System.out.println(ANSI_BLUE+Anagui.beklemeListesiArrayList+ANSI_RESET);
                            }

                        }






                    }












                }



            }






        }


        String joptinpaneString="";
        for(int xa=0;xa<oturanmusterilerArrayList.size();xa++)
        {
        	joptinpaneString+=oturanmusterilerArrayList.get(xa);
        }
      



        System.out.println("GARSON GUİ");
        System.out.println("oturanmusterilerArrayList:" + oturanmusterilerArrayList);
        System.out.println("beklemeListesiArrayList:" + Anagui.beklemeListesiArrayList);
        System.out.println("bekleme listetsi bosmu:(eleman sayısı)" + Anagui.beklemeListesiArrayList.size());
        System.out.println("-----------");
        Anagui.adimsayac++;
        try (FileWriter fileWriter = new FileWriter(Anagui.problem1yoluString,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

               // Dosyaya yazılacak metin
               String metin = "Adım"+Anagui.adimsayac+":"+oturanmusterilerArrayList.size() +" musteri  masaya yerlestirildi."+Anagui.beklemeListesiArrayList.size()+" müşteri  beklemede";
               
                 
               // Metni dosyaya yaz
               bufferedWriter.append(metin);
               bufferedWriter.newLine();
               bufferedWriter.close();
               
           } catch (IOException e2) {
               e2.printStackTrace();
           }
       
        
        System.err.println("oturan musteri test========"+oturanmusterilerArrayList); 
        System.err.println("masadurum"+masadurumArrayList);
        //musterileri bir oturt
        
        
       
            
            	 
                
                
                
                
    
                
                JPanel[] masaPanelleri = new JPanel[masasayisi];
                //musteriler oturanmusterilerArraylist sırasına göre masaya oturur
                for (int i = 0; i < masasayisi; i++) {
                    masaPanelleri[i] = new JPanel();
                    masaPanelleri[i].setBounds(2 + (i * (30 + masamesafe)), 50, 30, 50);
                       garsonFrame.add(masaPanelleri[i]);
 // Paneli ana frame'e ekle
                  
                }

              
                for (int i = 0; i < oturanmusterilerArrayList.size(); i++) {
                     System.err.println("---");
                
                    masaPanelleri[i].setBackground(Color.GREEN);
                    masadurumArrayList.add("dolu");
                }

                for (int i = oturanmusterilerArrayList.size(); i < masasayisi; i++) {

                	  System.err.println("+++");
                      
                	
                    masaPanelleri[i].setBackground(Color.RED);
                    masadurumArrayList.add("bos");

                }
gorsellestir();
               
                
            
garsonFrame.getContentPane().setBackground(Color.BLUE);

garsonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
garsonFrame.setSize(500,500);
garsonFrame.setLocation(501,0);
garsonFrame.setLayout(null);
garsonFrame.setVisible(true);
        
        
        
        
        
       
        
        
        
        
        
     
        
        
        
        
        
        
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("bekleyen müşteriler silindi***********");

                Anagui.beklemeListesiArrayList.clear();

                
                JOptionPane.showMessageDialog(
                        null,
                        "BEKLEYEN MUSTERİLER SİLİNDİ!",
                        "Uyarı",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        };


        timer.schedule(task,beklemezaman);
		
		
      //oturan musterilerin thread başlaması
      
		
		//oturan musterilerden şipariş alma
		
        
        
        int sayac=0;
		
		 for(int i=0;i<oturanmusterilerArrayList.size();i++)
	        {
		for(int j=0;j<Musteri_THREADLA.onceliklimusteriThreads.size();j++)
   	{
   		if((oturanmusterilerArrayList.get(i)+"").equals((Musteri_THREADLA.onceliklimusteriThreads.get(j)+"")))
   	     	{
   			oturanmusterileRunnables.add(Musteri_THREADLA.onceliklimusteriRunnables.get(j));
   			sayac++;
   	     	}
   		
   	}
   	for(int j2=0;j2<Musteri_THREADLA.onceliksizmusteriThreads.size();j2++)
   	{
             if((oturanmusterilerArrayList.get(i)+"").equals((Musteri_THREADLA.onceliksizmusteriThreads.get(j2))+""))
           		  {
           	  oturanmusterileRunnables.add(Musteri_THREADLA.onceliksizMusteriRunnables.get(j2));
           		 sayac++;
           		  
           		  }
   		
   		
   		
   	}
	        }
   
		 
		 
	System.out.println("sayac:"+sayac);	 
		 
		 
		 
		 //bu işlemlerden sonra oturanmusterilerimin sayısından küçük bir sayac varsa oturan musterirunnables ekleme yap şağladıysam
		 
		while(sayac<oturanmusterilerArrayList.size())
		{

			oturanmusterileRunnables.add(new Musteri_Runnable(Anagui.genelyemek_sayisi));
		sayac++;
			
			
		}
        	
  
        	
        	
        	
        	
        	
        
        
        //oturan musteriler daha yemek şiparişi vermedi
        for(int k=0;k<oturanmusterileRunnables.size();k++)
        {
        	
        	oturanmusterileRunnables.get(k).siparis_verdimi=false;
        	System.out.println(oturanmusterileRunnables.get(k).siparis_verdimi);
        	
        }
        System.out.println("oturan musterilerin sayısı"+oturanmusterileRunnables.size());
        System.out.println(ANSI_GREEN+oturanmusterileRunnables+ANSI_RESET);
      
        
        for(int q=0;q<oturanmusterilerArrayList.size();q++)
        {
        	
      //   oturanmusterileRunnables.get(q).oturmabayrak=true;
         
        oturanmusterilerArrayList.get(q).start();
        
        
        try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        
        
       
        	
      

        oturanmusterilerArrayList.get(q).interrupt(); // Thread'i interrupt et

        try {
            oturanmusterilerArrayList.get(q).join(); // Main thread, myThread'in tamamlanmasını bekler
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ((oturanmusterilerArrayList.get(q).isAlive())) {
            System.out.println("Thread hala yaşıyor.");
        } else {
            System.out.println("Thread sona erdi.");
        }
        
        
        
        
        
        
        }
        
        
        
      
        
      
        //garsonların şipariş alması zamanlama
     // JTextArea oluştur
        JTextArea durumTextArea = new JTextArea();
        durumTextArea.setBounds(100, 215, 300, 300);
        garsonFrame.add(durumTextArea);
       
        
        Timer timer2 = new Timer();
        int baslangicGecikmesi =0; // Başlangıç gecikmesi, milisaniye cinsinden (örneğin 1000 ms = 1 saniye)
        int tekrarPeriyodu =Garson_THREADLA.siparisalmazamanı; // Tekrar periyodu, milisaniye cinsinden (örneğin 5000 ms = 5 saniye)

        // TimerTask sınıfını kullanarak tekrarlanacak işlemi tanımlayın
      //siparis verme işi bittiyse timer durdur
       
        TimerTask task2 = new TimerTask() {
         
        
        	@SuppressWarnings("static-access")
			@Override
            public void run() {
        		
       	
        	 if(Garson_Siparis_vermeisi_bittimi==false&&beklemeisibitti==true)
     { 		
        		
        		
        		
            	System.err.println(Garson_THREADLA.garsonRunnables);
            	//başa ğeçtimi garsonların tekrardan şipariş almasını açma
            	for(int q=0;q<Garson_THREADLA.garsonsayisi;q++)
            	{
            		
                      garsonThreadstart++;
                      if(garsonThreadstart<=Garson_THREADLA.garsonsayisi)
                      {Garson_THREADLA.garson_Threads.get(q).start(); 
                      }
                      
            		Garson_THREADLA.garsonRunnables.get(q).isRunning=true;
            		try {
							Garson_THREADLA.garson_Threads.get(q).interrupt(); 
                   
					} catch (Exception e) {
						// TODO: handle exception
					}
            	 
            	
					
            	}
           
            	
            	
            	
            	
            	
            	
                // Burada tekrarlanacak işlemi gerçekleştirin
                System.out.println("ZAMAN ĞEÇTİ VE GARSON TEKRARDAN ŞİPARİŞ ALABİLİR!");
      int garson_uyumasayisi=0;
                for(int w=0;w<Garson_THREADLA.garsonsayisi;w++)
{
	


	 Thread garsonthread=(siparisal(w));
	 if(garsonthread==null)
	 {
		 
		try {
			 System.out.println(Garson_THREADLA.garson_Threads.get(w)+"uyuyor");
			garson_uyumasayisi++;
			System.out.println(ANSI_CYAN+"         ---->garsonuyumasayisi"+garson_uyumasayisi+ANSI_RESET);
			if(garson_uyumasayisi==Garson_THREADLA.garsonsayisi)
			{
			
				
				System.err.println("*-*----*-*-*--**-**-*-***--**-*-*-*-*");
			//bunu attığı an garsonunyemek yapmasından biraz daha fazla bekle ve Anagui maine git
			
				   int sonuc = JOptionPane.showConfirmDialog(null, "garsonlar durdu?", "Onay Kutusu", JOptionPane.YES_NO_OPTION);

			        if (sonuc == JOptionPane.YES_OPTION) {
			            System.out.println("Evet'e tıklandı. Devam ediliyor...");
			         
			        				
				
				
		   for(int ol=0;ol<Garson_THREADLA.garson_Threads.size();ol++)
		   {
			   
			     synchronized (Garson_THREADLA.garson_Threads.get(ol)) {
		            System.out.println("Ana thread, UyananThread'i uyandırıyor.");
		            Garson_THREADLA.garson_Threads.get(ol).notify();
		        }	
			     
			     
			
		   }
			  
			        
			        } else {
			            System.out.println("Hayır veya kapat'a tıklandı. İşlem iptal edildi.");
			            // Burada hayır veya kapat'a tıklanınca yapılması gereken işlemleri ekleyebilirsiniz.
			     	timer2.cancel(); 
			     	}

				
			//Garson_Siparis_vermeisi_bittimi=true;
		
			
			}
			
			
			
		
			
			
			Garson_THREADLA.garson_Threads.get(w).sleep(Garson_THREADLA.siparisalmazamanı);
		    
		 
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		 System.err.println("problem varmi");
		 }
	 }
	 else {
	//garson threadinin çalıştığı bu yerde 
		 System.out.println("sipariş alan garson thread:"+Garson_THREADLA.garson_Threads.get(w)+"çalısıyor");

		
		 
	//	threadi aç
		 Garson_THREADLA.garsonRunnables.get(w).startRunning();
	
		 
		 
		 //oturan siparis ekleme işlemeleri
		 //bunu gui yansıt GUİ YE YANSITMA KISMI
		 System.out.println("********sipariş veren oturan müşteri thread:"+garsonthread);
	 
		 Ascigui.oturansiparis.add(garsonthread);
		 JPanel baslikJPanel = new JPanel();
	     JLabel baslik = new JLabel("Müşteri Sipariş Durumu");
	     baslikJPanel.add(baslik);
	     baslikJPanel.setBounds(100,170, 200,30);
	     garsonFrame.add(baslikJPanel);
		 
	     int hangigarson = 0;
	     int hangimusteri = -1;
	     
	     for(int don=0;don<Garson_THREADLA.garson_Threads.size();don++)
	     {
	    	if((Garson_THREADLA.garson_Threads.get(w)+"").equals((Garson_THREADLA.garson_Threads.get(don)+"")) )
	    			{
	    		
	    	hangigarson=don+1;
	    		
	    			}	    	 
	    
	     
	     }
	     for(int don2=0;don2<Garsongui.oturanmusterilerArrayList.size();don2++)
	     {
	    	 
	    	if((garsonthread+"").equals(oturanmusterilerArrayList.get(don2)+"")) 
	    	{
	    	hangimusteri=Anagui.musterisay;
	    	Anagui.musterisay++;
	    		
	    	}
	    	 
	    	 
	     }
	     
	     //text area yazmak
	     
	     durumTextArea.append("garson"+hangigarson+" musteri"+hangimusteri+" siparisini aldı\n");
	     //buraya şiparişleri  problem1text yaz
	     Anagui.adimsayac++;
	     try (FileWriter fileWriter = new FileWriter(Anagui.problem1yoluString,true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Dosyaya yazılacak metin
                String metin = "Adım"+Anagui.adimsayac+":"+"garson"+hangigarson+" musteri"+hangimusteri+" siparisini aldı\n";
                Stringgarsonileti+="garson"+hangigarson+" musteri"+hangimusteri+",";
                
                
                String metin2="";
               
               if((hangimusteri)%(Garson_THREADLA.garsonsayisi)==0)
               {
            	      for(int say=hangimusteri+1;say<=oturanmusterilerArrayList.size();say++)
                {
                	metin2+="musteri "+say+",";
                }
                if(metin2.length()!=0)
                {    metin2+=" beklemede"; 
            	
                
                	
                	//metin2="0 musteri";
                }
            
   
                
                
               }
            	   
            
                
               String bileskeString=metin+metin2;
                
                // Metni dosyaya yaz
                bufferedWriter.append(bileskeString);
                bufferedWriter.newLine();
                bufferedWriter.close();
                
                
                
                //garsonların siparisini aşçıya ilet
                if((hangimusteri)%(Garson_THREADLA.garsonsayisi)==0)
                {
                	asciilet=true;
                	
                Anagui.adimsayac++;
                try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString,true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                     Stringgarsonileti+=" şiparişini aşçıya iletti"; 
                       // Metni dosyaya yaz
                 String tempString="Adım "+Anagui.adimsayac+":"+Stringgarsonileti;
                       bufferedWriter2.append(tempString);
                       bufferedWriter2.newLine();
                       bufferedWriter2.close();
                       
                   } catch (IOException e2) {
                       e2.printStackTrace();
                   }
                }
                
                
                
                
                
                
                
                
                
                
                
            } catch (IOException e2) {
                e2.printStackTrace();
            }
         
         //garsonların şipariş iletme kısmı
	     
	     
	     
	     
	     
	     durumTextArea.setCaretPosition(durumTextArea.getDocument().getLength());

	
		 //isrunning false yaparsak thread durur
		 try {
	            TimeUnit.MILLISECONDS.sleep(Garson_THREADLA.siparisalmazamanı);; //milisaniyelerle threadi durdur
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Thread'i güvenli bir şekilde durdur
	    Garson_THREADLA.garsonRunnables.get(w).stopRunning();
	    System.out.println("DURDU THREAD");
	
	 
	 
	
	 }



}
            
         	
            //garsonların sipasrisini ascıya ilet
           
            if(Ascigui.zamanlamabayrak==true)
            {
            	
            	if(Ascigui.oturansiparis.size()>=1)
            	{
                          if(asciilet==false)
                          {
                        	   Anagui.adimsayac++;
                               try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString,true);
                                       BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                                    Stringgarsonileti+=" şiparişini aşçıya iletti"; 
                                      // Metni dosyaya yaz
                                String tempString="Adım "+Anagui.adimsayac+":"+Stringgarsonileti;
                                      bufferedWriter2.append(tempString);
                                      bufferedWriter2.newLine();
                                      bufferedWriter2.close();
                                      
                                  } catch (IOException e2) {
                                      e2.printStackTrace();
                                  }
                        	  
                          } 		
  
            		
            	asciilet=false;
            		
             	Stringgarsonileti="";
  
            	
            	Ascigui.main(args);
            	}
            	
            	
          	}
            	
            	
            	  
            
            
            }//garson siparis verme isi parantezi 
            
        	 garson_gelme_sayisi++;
        	 
                 }
            
            
            
            
         
        };

        // Timer'ı başlatın ve schedule metodunu kullanarak görevi planlayın
        timer2.scheduleAtFixedRate(task2, baslangicGecikmesi, tekrarPeriyodu);
   
        
        
        
		


		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
	}
	
	
}