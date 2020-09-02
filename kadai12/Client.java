import java.util.ArrayList; //ArrayListのAPI

//Clientクラス

public class Client{
    public static void main(String[] args){
        Suuchi s = new Suuchi();
        Observer o1 = new NishinHyouji();
        Observer o2 = new JyuurokushinHyouji();

        s.attach(o1);
        s.attach(o2);
        int i = 0;
        while(i<100){
            s.putValue(i);
            i += (int)(Math.random() * 30) - 10;
        }
    }
}

//Subjectクラス

abstract class Subject{
    public ArrayList<Observer> observers;

    Subject(){
        observers = new ArrayList<Observer>();
    }

    public void attach(Observer o){
        observers.add(o);
    }

    public void detach(Observer o){
        observers.remove(o);
    }

    public void tsuuchi(){
        for(Observer observer: observers){
            observer.update(this);
        }
    }
}

//ConcreteSubject
class Suuchi extends Subject{
    int suuchiState;
    int atai;

    public int getState(){
        return suuchiState;
    }

    public void putValue(int atai){
        if(atai > this.atai){
            this.atai = atai;
            this.tsuuchi();
        }
        else{
            System.out.println("確認用メッセージ:更新してません");
        }
    }

    public int getValue(){
        return atai;
    }

}


//Observerインターフェースに相当するクラス
interface Observer{
    public void update(Subject s);
}

//ConcreateObserverクラスに相当するクラス群
class NishinHyouji implements Observer{
    public void update(Subject s){
        print(((Suuchi)s).getValue());
    }

    private void print(int n){
        System.out.println(n + "を2進数で表示します");
        //
        //
        //
    }
}


class JyuurokushinHyouji implements Observer{
    public void update(Subject s){
        print(((Suuchi)s).getValue());
    }

    private void print(int n){
        System.out.println(n + "を16進数で表示します");
        //
        //
        //
    }
}



