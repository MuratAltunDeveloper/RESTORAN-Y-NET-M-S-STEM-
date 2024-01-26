package yazlab3son;


public class Musteri_Runnable implements Runnable{
	public   boolean oturmabayrak;//oturuyormu kalktımı
	public   boolean siparis_verdimi=false;
	
	
	
	
Yemekclass musteriYemek;//musterinin yediği yemek
	public Musteri_Runnable(Yemekclass data)
	{
		
		this.musteriYemek=data;
	}
	
	public void siparisverfunction(boolean siparisverme)
	{
		
			siparis_verdimi=siparisverme;
		
	}
	
	
	@Override
	public void run() {
		synchronized (musteriYemek) {
			int ara=musteriYemek.yemeksayisi;
			musteriYemek.yemeksayisi=ara-1;	
		
			System.out.println("Musterinin tükettiği yemek sayisi:"+musteriYemek.yemeksayisi);
			
			
		 
		
			
		}
		
		
		
	}

}
