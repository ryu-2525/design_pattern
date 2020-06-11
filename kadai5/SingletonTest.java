// SingleTonTestクラス
public class SingletonTest{
    public static void main(String[] args){
        Renban renban_a = Renban.getInstance();
        //Renban renban_test = Renban.getInstance();
        //System.out.println(reanban_test.getNumber());

        
    }
}
// Renbanクラス
class Renban{
    private static Renban renban = new Renban();

    private Renban(){
        System.out.println("world");
        
    }
    private getNumber(){
        System.out.println("testing");
         
        
    }

    public static Renban getInstance(){
        return renban;
    }

    
}
