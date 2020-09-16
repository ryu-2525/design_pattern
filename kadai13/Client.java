// 委譲version
// Clientクラス

public class Client{
    public static void main(String[] args){
        Dengen d =  new AcAdapter();
        int denatsu = d.kyuuden();
        System.out.println(denatsu + "Vで給電されています");
    }
}

// Targetクラス

public abstract class Dengen{   
    public abstract int kyuuden();   //request()メソッド
}


// Adapteeクラス

class JapaneseConsent{
    public int power(){
        return 100;
    }

}

// Adapterクラス

class AcAdapter extends Dengen{
    private JapaneseConsent JC;

    public AcAdapter(){
        this.JC = new JapaneseConsent();
    }
    public int kyuuden(){
       
        return (int)(JC.power() * 0.16);
    }
}




