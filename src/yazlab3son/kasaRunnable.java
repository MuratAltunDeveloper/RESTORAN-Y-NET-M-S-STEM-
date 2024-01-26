package yazlab3son;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class kasaRunnable implements Runnable{

	public static int index=1;
	
	
    static int kasaToplamMüşteriSayısı;//oturan toplam müşteri sayısını yapman gerek ekranda göstermen gerek
    static int ödemeYapanMüşteriSayısı;

    public static void kontrol()
    {
    	int sayac=0;
    	for(int x=0;x<Garsongui.masadurumArrayList.size();x++)
    	{
    		if(Garsongui.masadurumArrayList.get(x).equalsIgnoreCase("bos"))
    		{ 
    			sayac++;
    		}
    		
    	}
    	if(sayac==Garsongui.masadurumArrayList.size())
    	{   //musteri yemek yeme zamanı
           
    			
    	}
    	
    	
    	
    }
    
    
    @Override
    public void run() {
        while (true) {
            synchronized (Ascigui.kasalistesi) {


                for (Thread ödemeListesi : new ArrayList<>(Ascigui.kasalistesi)) {
                
                	
                	
                	
         /*           //musteri yemek yeme zamanı
                    try {
                     Thread.sleep(3000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
*/
              
                    
                   Anagui.adimsayac++;
                    Garsongui.kasasira++;  
                    
                    //hangi musterinin yemeğini bitirdiğini yaz
                    try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString, true);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                          bufferedWriter2.append("Adım "+Anagui.adimsayac+": musteri"+Garsongui.kasasira+ " yemeğini yedi.");
                           bufferedWriter2.newLine();
                           bufferedWriter2.close();

                       } catch (IOException e2) {
                           e2.printStackTrace();
                       }
                  
                	    Anagui.adimsayac++;
              
                	
                    
                    
                    
                    
                    
                    
                    kasaGui.kasaTextArea1.append(Garsongui.kasasira + ". müşterinin ödeme işlemi gerçekleşiyor.\n");
                   
                    try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString, true);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                          bufferedWriter2.append("Adım "+Anagui.adimsayac+": musteri"+Garsongui.kasasira+ "   adlı müşterinin ödeme işlemi gerçekleşiyor.");
                           bufferedWriter2.newLine();
                           bufferedWriter2.close();

                       } catch (IOException e2) {
                           e2.printStackTrace();
                       }
                      //kasa zamanı
                       try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(Garsongui.oturanmusterilerArrayList.size()>0)
                    {  if(index%(Garsongui.masasayisi+1)!=0)
                    	{
                    	Garsongui.masadurumArrayList.set((index%(Garsongui.masasayisi+1))-1,"bos");
                    	}else {
                    	//	Garsongui.masadurumArrayList.set(index%(Garsongui.masasayisi+1),"bos");
						
                    	index++;
                    	
                    	Garsongui.masadurumArrayList.set(index%(Garsongui.masasayisi+1)-1,"bos");
						
                    	
                    	}
                    
                    
                    	Garsongui.oturanmusterilerArrayList.remove(0);
                    	
                    	
                    	index++;
                    }
                    
                    
                    
                    
                    if(!Garsongui.oturanmusterileRunnables.isEmpty())
                    {
                    	Garsongui.oturanmusterileRunnables.remove(0);
                    
                    
                    }
                    Garsongui.gorsellestir();
                         
                 Garsongui.beklemeisibitti=false;
               
                
  Anagui.adimsayac++;
                    kasaGui.kasaTextArea1.append(Garsongui.kasasira+ " Nolu müşteri ödeme yaptı ve ayrıldı.\n");
                   //burada gorselleştirmeyi yap
                    
                    System.out.println("Kod devam ediyor");
                   
                    
                    kontrol();
                    
                    //gorsellik için ufak bir bekleme
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                      
               
                    Garsongui.beklemedeneme();
                Garsongui.beklemeisibitti=true;
                     Garsongui.gorsellestir();
                   
                    try (FileWriter fileWriter2 = new FileWriter(Anagui.problem1yoluString, true);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2)) {

                          bufferedWriter2.append("Adım "+Anagui.adimsayac+": musteri"+Garsongui.kasasira+ "  adlı müşteri ödeme yaptı ve ayrıldı.");
                           bufferedWriter2.newLine();
                           bufferedWriter2.close();

                       } catch (IOException e2) {
                           e2.printStackTrace();
                       }
                     
                    
                    
                    
                    

                    ödemeYapanMüşteriSayısı++;
                    kasaGui.kasaTextArea1.append(" Ödeme yapan müşteri sayısı: " + ödemeYapanMüşteriSayısı + "\n");
                    Ascigui.kasalistesi.remove(ödemeListesi);


                    kasaGui.kasaTextArea.setText("");
                    int say=1;
                    for (Thread list : Ascigui.kasalistesi) {
                      kasaGui.kasaTextArea.append("müşteri: " + say + "\n");
                
                    say++;
                    }


                    ödemeListesi.interrupt();

                }

            }
        }
    }
}
