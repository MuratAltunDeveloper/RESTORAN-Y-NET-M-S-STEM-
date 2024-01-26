package yazlab3son;


import java.util.ArrayList;

public class Musteri_THREADLA {
	public static int onceliksiz_musteri_sayi=0;//kullanıcıdan alınan onceliksiz musterisayisi
	public static int oncelikli_musteri_sayi=0;//kullanıcıdan alınan oncelikli musteri sayısı
	 
	//musteri runnable ile uretebileceğim oncelikli ve onceliksiz threadler
	public static ArrayList<Thread>onceliklimusteriThreads=new ArrayList<>();
	public static ArrayList<Thread>onceliksizmusteriThreads=new ArrayList<>();
			
	
	public static ArrayList<Musteri_Runnable>onceliklimusteriRunnables=new ArrayList<>();
	public static ArrayList<Musteri_Runnable>onceliksizMusteriRunnables=new ArrayList<>();
	
	
	
	public static void thread_uretoncelikli()
	{ 
		
	for(int i=0;i<oncelikli_musteri_sayi;i++)
	{
		
		Musteri_Runnable ara=new Musteri_Runnable(Anagui.genelyemek_sayisi);
		onceliklimusteriRunnables.add(ara); 
		
		
		Thread t1=new Thread(ara);
	        onceliklimusteriThreads.add(t1);
	}
		
		
	}
	public static void thread_uretonceliksiz()
	{
		
		for(int i=0;i<onceliksiz_musteri_sayi;i++)
		{
			
		
		Musteri_Runnable ara2=new Musteri_Runnable(Anagui.genelyemek_sayisi);
		onceliksizMusteriRunnables.add(ara2);
		
		
		Thread t2=new Thread(ara2);
		onceliksizmusteriThreads.add(t2);
		}
		
	}
	
	
	public static void olustumukontrol()
	{
		System.out.println("\nburası Musteri_THREADLA olustumukontrol");
		
		for (Thread thread : onceliklimusteriThreads) {
			System.out.println(thread);
		}
		System.out.println("*********");
		for (Thread thread : onceliksizmusteriThreads) {
			System.out.println(thread);
		}
		
		
		
	}
	
	
	
	
public static void main(String[] args) {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	System.out.println("Musteri_THREADLA main");
	System.out.println(oncelikli_musteri_sayi);
   System.out.println(onceliksiz_musteri_sayi);
   
   //threadleri temizleme
   onceliklimusteriThreads.clear();
   onceliksizmusteriThreads.clear();
   
   
   
   thread_uretoncelikli();
   thread_uretonceliksiz();
   
   olustumukontrol();
   
}

	
	
}
