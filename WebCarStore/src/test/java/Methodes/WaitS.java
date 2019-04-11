/*
 * Creation : 19 mars 2019
 */
package Methodes;

public class WaitS {
    public static void Wait(int Dur) {
        try {
            Thread.sleep(Dur);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
