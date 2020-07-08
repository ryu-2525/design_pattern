// Clientクラス
public class TheDogTest1{
    public static void main(String[] args){
        Dog pochi = new Dog();
        
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.roudou();
        pochi.print();

        pochi.shokuji();
        pochi.print();

        pochi.suimin();
        pochi.print();

        pochi.roudou();
        pochi.print();
    }

}

// Contextクラス
class Dog{
    private DogState myState;

    public Dog(){
        myState = TanoshiiState.getInstance();
    }
    public void roudou(){
        myState.tukareta(this);
    }

    public void shokuji(){
        myState.tabeta(this);
    }
    public void suimin(){
        myState.nemui(this);
    }

    public void changeState(DogState d){
        myState = d;
    }

    public void print(){
        System.out.print("現在、私は");
        System.out.print(myState.toString());
        System.out.println("です。");
    }
}

// Stateクラス
abstract class DogState{
    public abstract void tukareta(Dog yobidashimoto); //疲れた
    public abstract void tabeta(Dog yobidashimoto); //食べた
    public abstract void nemui(Dog nemui); //寝た
}

// ConcreteStateクラス 楽しい状態
class TanoshiiState extends DogState{
    private static TanoshiiState s = new TanoshiiState();
    private TanoshiiState() {}

    public static DogState getInstance(){
        return s;
    }

    public void tukareta(Dog moto){
        moto.changeState(FutsuuState.getInstance());
    }
    
    public void tabeta(Dog moto){ //何もしない
    }
    public void nemui(Dog moto){
        moto.changeState(NeteiruState.getInstance());
    }
    public String toString() {
        return "楽しい状態";
    }
}

// ConcreateStateクラス 普通状態
class FutsuuState extends DogState{
    private static FutsuuState s = new FutsuuState();
    private FutsuuState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){
        moto.changeState(IrairaState.getInstance());
    }
    public void tabeta(Dog moto){
        moto.changeState(TanoshiiState.getInstance());
    }
    public void nemui(Dog moto){
        moto.changeState(NeteiruState.getInstance());
    }
    public String toString(){
        return "普通状態";
    }
}

// ConcreateStateクラス イライラ状態
class IrairaState extends DogState{
    private static IrairaState s = new IrairaState();
    private IrairaState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){
        //何もしない
    }
    public void tabeta(Dog moto){
        moto.changeState(TanoshiiState.getInstance());
    }
    public void nemui(Dog moto){
    }
    public String toString(){
        return "いらいら状態";
    }
}

// ConcreateStateクラス 寝てる状態
class NeteiruState extends DogState{
    private static NeteiruState s = new NeteiruState();
    private NeteiruState(){}

    public static DogState getInstance(){
        return s;
    }
    public void tukareta(Dog moto){
        moto.changeState(FutsuuState.getInstance());
    }
    public void tabeta(Dog moto){
        moto.changeState(TanoshiiState.getInstance());
    }
    public void nemui(Dog moto){
    }
    public String toString(){
        return "寝てる状態";
    }
}
