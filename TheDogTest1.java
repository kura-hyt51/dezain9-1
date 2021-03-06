public class TheDogTest1 {
    public static void main(String[] args) {
    Dog pochi = new Dog();
    pochi.print();
    pochi.roudou();
    pochi.print();
    pochi.neru();
    pochi.print();
    pochi.roudou();
    pochi.print();
    pochi.shokuji();
    pochi.print();
    pochi.roudou();
    pochi.print();
    pochi.roudou();
    pochi.print();
    }
}

class Dog {
    private DogState myState;
    public Dog() {
    myState = TanoshiiState.getInstance();
    }
    public void roudou() {
    myState.tukareta(this);
    }
    public void shokuji() {
    myState.tabeta(this);
    }
    public void neru() {
    myState.nemuru(this);
    }
    public void changeState(DogState d) {
    myState = d;
    }
    public void print() {
        System.out.println( myState.toString() );
        }
}

abstract class DogState {
    public abstract void tukareta(Dog yobidashimoto); //疲れた!
    public abstract void tabeta(Dog yobidashimoto); //食べた!
    public abstract void nemuru(Dog yobidashimoto); //眠る!

}

class TanoshiiState extends DogState {
    private static TanoshiiState s = new TanoshiiState();
    private TanoshiiState() {}
    public static DogState getInstance() {
    return s;
    }
    public void tukareta(Dog moto) { // なにもしない
    }
    public void tabeta(Dog moto) { 
    moto.changeState(FutsuuState.getInstance());
    }
    public void nemuru(Dog moto) { 
    moto.changeState(nemuruState.getInstance());
    }
    public String toString() {
    return "楽しい状態";
    }
}

class FutsuuState extends DogState {
    private static FutsuuState s = new FutsuuState();
    private FutsuuState() {}
    public static DogState getInstance() {
    return s;
    }
    public void tukareta(Dog moto) {
    moto.changeState(TanoshiiState.getInstance());
    }
    public void tabeta(Dog moto) { // なにもしない
    }
    public void nemuru(Dog moto) { // なにもしない
    }
    public String toString() {
    return "普通状態";
    }
}

    class IrairaState extends DogState {
        private static IrairaState s = new IrairaState();
        private IrairaState() {}
        public static DogState getInstance() {
        return s;
        }
        public void tukareta(Dog moto) {
        moto.changeState(TanoshiiState.getInstance());
        }
        public void tabeta(Dog moto) {
        moto.changeState(FutsuuState.getInstance());
        }
        public void nemuru(Dog moto) { // なにもしない
        }
        public String toString() {
        return "いらいら状態";
        }
    }

    class nemuruState extends DogState {
        private static nemuruState s = new nemuruState();
        private nemuruState() {}
        public static DogState getInstance() {
        return s;
        }
        public void tukareta(Dog moto) {
        moto.changeState(IrairaState.getInstance());
        }
        public void tabeta(Dog moto) {
        moto.changeState(FutsuuState.getInstance());
        }
        public void nemuru(Dog moto) { // なにもしない
        }
        public String toString() {
        return "睡眠中";
        }
    }