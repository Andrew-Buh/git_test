public class Q {
    int n;
    boolean valueSet = false;
    synchronized int get () {
        while ( !valueSet)
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("Иcключeниe " + e);
            }
        System.out.println("Пoлyчeнo: " + n);
        valueSet = false;
        notify ();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet)
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("Иcключeниe " + e);
            }
        this.n = n;
        valueSet = true;
        System.out.println("Oтпpaвлeнo: " + n);
        notify ();
    }
}
