package yazlab3son;


import java.util.concurrent.TimeUnit;

public class Garson_Runnable implements Runnable {
    public boolean siparisaldimi = false; // İlk başta oluşturulan garson sipariş alamaz
    public volatile boolean isRunning = true; // Runnable'ın çalışıp çalışmadığını kontrol etme
    Yemekclass musteriYemek; // Müşterinin yediği yemek

    public Garson_Runnable(Yemekclass data) {
        this.musteriYemek = data;
    }

    public void siparisAlFunction(boolean siparis) {
        siparisaldimi = siparis;
    }

    @Override
    public void run() {
        while (isRunning) {
            // İşlerinizi burada gerçekleştirin
            synchronized (musteriYemek) {
                int ara = musteriYemek.yemeksayisi;
               // System.out.println("Müşterinin tükettiği yemek sayısı: " + musteriYemek.yemeksayisi);
            }

            // İşler bittiğinde thread'i uyutabilirsiniz
        /*    try {
                TimeUnit.MILLISECONDS.sleep(50); // Örnek olarak 500 milisaniye uyutuyoruz
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public  void stopRunning() {
        isRunning = false;
    }
   public void startRunning()
   {
	   isRunning=true;
   }

}

