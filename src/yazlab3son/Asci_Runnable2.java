package yazlab3son;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Asci_Runnable2 implements Runnable {
    private final int hangiasci;
    private int kacyemekyapicak;
    private final Yemekclass asciYemek;
    private volatile boolean isRunning = true;

    
    
    
    public Asci_Runnable2(int data, Yemekclass veri) {
        
		this.asciYemek = veri;
        this.hangiasci = data;
    }

    @Override
    public void run() {
    	Asci_THREADLE2.ascisay++;
        Asci_THREADLE2.getLock().lock();
        try {
            yemekYap();
        } finally {
            Asci_THREADLE2.getLock().unlock();
        }
    }

    public synchronized void stopRunning() {
        isRunning = false;
    }

    public synchronized void startRunning() {
        isRunning = true;
    }

    public synchronized void yemekYap() {
    	
      
    	
    	
        System.out.println("TOPLAM YEMEK SAYISI" + Asci_THREADLE2.topyemeksayisi);

        if (Asci_THREADLE2.topyemeksayisi > 0) {
            if ((Asci_THREADLE2.topyemeksayisi >= 2) && (!Ascigui.oturansiparis.isEmpty()) && (Ascigui.oturansiparis.size() > 1)) {
                kacyemekyapicak = 2;
                for (int i = 0; i < 2; i++) {
                    System.err.println("asci" + hangiasci + "  " + Ascigui.oturansiparis.get(Ascigui.oturansiparis.size() - Asci_THREADLE2.topyemeksayisi) + " yemek yapıyor.");
                   
                    
                    Asci_THREADLE2.HangiMusteriYemek++;
                    
                    Ascigui.hazirlananYemeklerTextArea.append("asci" + hangiasci + "  musteri " + (Asci_THREADLE2.HangiMusteriYemek) + " yemek yapıyor.\n");
                    Asci_THREADLE2.topyemeksayisi--;

                    
                    
                    
                    Anagui.adimsayac++;
                    try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString,true);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                         int ata1=hangiasci+1;
                      String    Asciiş2="Adım "+Anagui.adimsayac+":"+"asci" + ata1 + "  musteri " + (Asci_THREADLE2.HangiMusteriYemek) + " yemek yapıyor.";
                           // Metni dosyaya yaz
                         bufferedWriter2.append(Asciiş2);
                           bufferedWriter2.newLine();
                           bufferedWriter2.close();
                           
                       } catch (IOException e2) {
                           e2.printStackTrace();
                       }
                    
                    
                    
                    
                    
                    
                    System.out.println(Garsongui.ANSI_PURPLE +"ascigui oturansiparis:"+ Ascigui.oturansiparis + Garsongui.ANSI_RESET);

                    if (!Ascigui.oturansiparis.isEmpty()) {
                        Ascigui.oturansiparis.remove(0);
                    }

                   //burada yap
                    if(!Garsongui.oturanmusterileRunnables.isEmpty())
                    {
                //    	Garsongui.oturanmusterileRunnables.remove(0);
                    }
                    if(!Garsongui.oturanmusterilerArrayList.isEmpty())
                    {
                 //   	Garsongui.oturanmusterilerArrayList.remove(0);
                    }	
                    	
                    
                }
            } else {
               
            	System.out.println(Garsongui.ANSI_YELLOW+"GİRDİİİİ"+Garsongui.ANSI_RESET);
            	
            	kacyemekyapicak = 1;
                System.err.println("asci" + hangiasci + "  " + (Ascigui.oturansiparis.size() - Asci_THREADLE2.topyemeksayisi) + " yemek yapıyor.");

                
                Asci_THREADLE2.HangiMusteriYemek++;
                Ascigui.hazirlananYemeklerTextArea.append("asci" + hangiasci + "  musteri " + (Asci_THREADLE2.HangiMusteriYemek) + " yemek yapıyor.\n");

                Anagui.adimsayac++;
                try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString,true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                    int ata2=hangiasci+1 ;
                   String   Asciiş="Adım "+Anagui.adimsayac+":"+"asci" +ata2 + "  musteri " + (Asci_THREADLE2.HangiMusteriYemek) + " yemek yapıyor";
                       // Metni dosyaya yaz
                     bufferedWriter2.append(Asciiş);
                       bufferedWriter2.newLine();
                       bufferedWriter2.close();
                       
                   } catch (IOException e2) {
                       e2.printStackTrace();
                   }
         	     
                
                
                
                
                
                
                System.out.println(Garsongui.ANSI_PURPLE +"ascigui oturansiparis:"+ Ascigui.oturansiparis + Garsongui.ANSI_RESET);

                Asci_THREADLE2.topyemeksayisi--;

                if (!Ascigui.oturansiparis.isEmpty()) {
                    Ascigui.oturansiparis.remove(0);
                }

                //burada yap
                if(!Garsongui.oturanmusterileRunnables.isEmpty())
                {
            //    	Garsongui.oturanmusterileRunnables.remove(0);
                }
                if(!Garsongui.oturanmusterilerArrayList.isEmpty())
                {
              //  	Garsongui.oturanmusterilerArrayList.remove(0);
                }	
                	
                
                
                
                
                
                
                
                
                
                
            }
        } else {
            kacyemekyapicak = 0;
            //yapıcak yemek kalmadıysa
           //VE BU KALMADAI SAYISI GARSON SAYISI İLE AYNI İSE KOD BİTTİ DEMEKTİR
            
System.out.println("000000000000000000000000000000000yapacak yemek kalmadı");
            
            
            
        }
        System.out.println("asci" + hangiasci + "  " + kacyemekyapicak + " yemek yapıyor.");
        Ascigui.siparisAlinanlarTextArea.append("asci" + hangiasci + "  " + kacyemekyapicak + " yemek yapıyor.\n");
   
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}