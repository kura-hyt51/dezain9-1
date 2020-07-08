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
    public abstract void tukareta(Dog yobidashimoto); //îÊÇÍÇΩ!
    public abstract void tabeta(Dog yobidashimoto); //êHÇ◊ÇΩ!
    public abstract void nemuru(Dog yobidashimoto); //ñ∞ÇÈ!

}

class TanoshiiState extends DogState {
    private static TanoshiiState s = new TanoshiiState();
    private TanoshiiState() {}
    public static DogState getInstance() {
    return s;
    }
    public void tukareta(Dog moto) { // Ç»Ç…Ç‡ÇµÇ»Ç¢
    }
    public void tabeta(Dog moto) { 
    moto.changeState(FutsuuState.getInstance());
    }
    public void nemuru(Dog moto) { 
    moto.changeState(nemuruState.getInstance());
    }
    public String toString() {
    return "äyÇµÇ¢èÛë‘";
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
    public void tabeta(Dog moto) { // Ç»Ç…Ç‡ÇµÇ»Ç¢
    }
    public void nemuru(Dog moto) { // Ç»Ç…Ç‡ÇµÇ»Ç¢
    }
    public String toString() {
    return "ïÅí èÛë‘";
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
        public void nemuru(Dog moto) { // Ç»Ç…Ç‡ÇµÇ»Ç¢
        }
        public String toString() {
        return "Ç¢ÇÁÇ¢ÇÁèÛë‘";
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
        public void nemuru(Dog moto) { // Ç»Ç…Ç‡ÇµÇ»Ç¢
        }
        public String toString() {
        return "êáñ∞íÜ";
        }
    }