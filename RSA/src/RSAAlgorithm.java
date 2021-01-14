//Q5
import java.util.*;
public class RSAAlgorithm {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static int pow(int x, int y, int n) {
        int k = 1;
        for (int j = 1; j <= y; j++)
            k = (k * x) % n;
        return k;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, phi;

        System.out.println("Enter 2 Large Prime Numbers: ");
        int p = s.nextInt();
        int q = s.nextInt();

        //Calculating n and z
        phi = (p - 1) * (q - 1);
        n = p * q;

        //e and gcd validation
        // e such that 1<e<phi and coprime
        System.out.println("Enter Relatively Prime No. : ");
        int e = s.nextInt();

        if (gcd(e, phi) != 1) {
            System.out.println("Selected Value of e Incorrect");
        }


        //Finding d
        int d;
        for(d = 1;d<phi;d++){
            if(((e*d)%phi)==1)
                break;
        }

        //Print Keys
        System.out.println("Public Key: (" + e + "," + n + ") ");
        System.out.println("Private Key: (" + d + "," + n + ") ");

        System.out.println("Enter Message: ");
        s.useDelimiter("\n");
        String mess = s.next();

        //Encryption
        System.out.println("Encrypting Plain Text: ");
        char[] msg = mess.toCharArray();
        int[] CT = new int[100];
        for (int i = 0; i < msg.length; i++) {
            CT[i] = pow(msg[i], e, n);
        }

        //Printing Cipher Text
        for (int i = 0; i < msg.length; i++) {
            System.out.print(CT[i]);
        }

        //Decryption
        System.out.println();
        System.out.println("Decrypting Cipher Text: ");
        int[] PT = new int[100];
        for (int i = 0; i < msg.length; i++) {
            PT[i] = pow(CT[i], d, n);
        }

        //Printing Plain Text
        for (int i = 0; i < msg.length; i++) {
            System.out.print((char) PT[i]);
        }

    }
}
