// Download from http://docs.oracle.com/javase/tutorial/security/tour2/examples/GetProps.java

import java.lang.*;
import java.security.*;
 
class GetProps {
 
    public static void main(String[] args) {
 
        /* Test reading properties w & w/out security manager */
         
        String s;
 
        try {
 
            System.out.println("About to get os.name property value");
 
            s = System.getProperty("os.name", "not specified");
            System.out.println("  The name of your operating system is: " + s);
 
            System.out.println("About to get java.version property value");
 
            s = System.getProperty("java.version", "not specified");
            System.out.println("  The version of the JVM you are running is: " + s);
 
            System.out.println("About to get user.home property value");
 
            s = System.getProperty("user.home", "not specified");
            System.out.println("  Your user home directory is: " + s);
 
            System.out.println("About to get java.home property value");
 
            s = System.getProperty("java.home", "not specified");
            System.out.println("  Your JRE installation directory is: " + s);
 
 
        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
 
    }
 
}