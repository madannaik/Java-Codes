//Q1
import java.util.*;
public class CyclicRC {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //CRC Divisor
        int[] g= {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
        int N = g.length;

        //Input
        System.out.println("Enter Length Of Dataword Bits: ");
        int BitLength = s.nextInt();
        System.out.println("Enter The Dataword: ");
        int[] data= new int[70];
        for(int i=0;i<BitLength;i++){
            data[i]=s.nextInt();
        }

        //Dataword Augmentation with 16 0's
        for(int i = BitLength; i<N+BitLength-1; i++){
            data[i]=0;
        }

        //Initiate Checksum
        int temp = N;
        int[] cs=  data.clone();

        //XOR
        int j;
        while(temp <= N+BitLength-1){
            if(cs[0]==1){
                for (j = 0; j < N; j++) {
                    cs[j] = cs[j] ^ g[j] ;
                }
            }

            //Leftshift By 1
            for (j = 0; j < N - 1; j++) {
                cs[j] = cs[j + 1];
            }
            cs[j] = data[temp++];
        }

        //Display
        System.out.println("The Final Checksum is: ");
        for(j=0;j<N-1;j++){
            System.out.print(cs[j]);
        }
        System.out.println(" ");
        System.out.println(" ");

        //Concatenating Dataword and Checksum
        System.arraycopy(cs, 0, data, BitLength, N - 1);

        System.out.println("The Codeword is: ");
        for(int i=0;i<N+BitLength-1;i++){
            System.out.print(data[i]);
        }
    }
}
