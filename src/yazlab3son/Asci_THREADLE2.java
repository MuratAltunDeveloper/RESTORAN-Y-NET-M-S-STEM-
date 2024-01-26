package yazlab3son;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Asci_THREADLE2 {
    public static int ascisayisi = 2;
    public static int topyemeksayisi = Ascigui.oturansiparis.size();
    public static ArrayList<Asci_Runnable2> asciRunnables = new ArrayList<>();
    public static ArrayList<Thread> asciThreads = new ArrayList<>();
    private static final ReentrantLock lock = new ReentrantLock(); // Ortak kilit

    public static int ascisay=0;
    
    public static int HangiMusteriYemek=0;
    
    public static void main(String[] args) {
    	ascisay=0;
    	
    	
        for (int x = 0; x < ascisayisi; x++) {
            Asci_Runnable2 ara = new Asci_Runnable2(x, Anagui.genelyemek_sayisi);
            asciRunnables.add(ara);

            Thread t2 = new Thread(ara);
            asciThreads.add(t2);
            t2.start();
        }

        Ascigui.siparisAlinanlarTextArea.append("**********************\n");
    }

    public static ReentrantLock getLock() {
        return lock;
    }
}
 




