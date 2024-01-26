package yazlab3son;


import java.util.ArrayList;



public class Garson_THREADLA {
   
	public static int garsonsayisi=3;//uretilecek garson sayısı
	public static ArrayList<Thread>garson_Threads=new ArrayList<>();
	public static ArrayList<Garson_Runnable>garsonRunnables=new ArrayList<>();
	
	public static int siparisalmazamanı=2000;//burası mili saniye cinsinden//garsonun bir şipariş alma zamanı
	
	
	
	
	public static void garson_threaduret()
	{
		
		for(int i=0;i<garsonsayisi;i++)
		{
			
		
		Garson_Runnable ara=new Garson_Runnable(Anagui.genelyemek_sayisi);
	 	garsonRunnables.add(ara);
		
		
		Thread t2=new Thread(ara);
		garson_Threads.add(t2);
		
		
		//garson threadini burada başlattım ve garsongui stopRunning() açıp kapat
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
	
		
		System.out.println("GARSON THREADLA main");
		System.out.println("garson sayisi:"+garsonsayisi);
		garson_threaduret();
        System.out.println(garson_Threads);
		System.out.println();
		
		
	}
	
	
}