/*
 * Creation : 15 mai 2019
 */
package Peugeot;

import org.testng.annotations.Test;

public class Subclass extends superclass {

    @Test(priority = 2)
    public void TestSubClass() {
        System.out.println("This is the subclass test");

    }
}
