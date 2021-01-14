import java.util.*;

public class LB {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int no_of_clocks;
        int bucket_size;
        int output_rate;
        int input_pkt_size,drop_pkts;
        int storage = 0, i;
        int size_left;

       System.out.println("Enter The No. Of Clocks: ");
        no_of_clocks = s.nextInt();
        System.out.println("Enter The Bucket Size: ");
        bucket_size = s.nextInt();
        System.out.println("Enter The Output Rate: ");
        output_rate = s.nextInt();

        for(i = 0; i < no_of_clocks ; i++){

            System.out.println("--------------------------");
            System.out.println("At ClockTick " + (i+1));
            System.out.println("--------------------------");

            size_left = bucket_size - storage;
            input_pkt_size = r.nextInt(15);

            System.out.println("Input Burst Size : "+input_pkt_size);
            if(input_pkt_size == 0)
                System.out.println("No Incoming Flow");
            else if(input_pkt_size <= size_left)
                storage += input_pkt_size;
            else{
                System.out.println("Bucket Overflow!");
                drop_pkts = input_pkt_size - size_left;
                System.out.println("No. Of Packets Dropped: "+drop_pkts);
                storage = bucket_size;
            }

            if(storage == 0)
                System.out.println("Bucket Underflow");
            else if(storage <= output_rate){
                System.out.println("No. Of Packets Sent Out Of the Bucket: "+storage);
                storage = 0;
            }
            else{
                System.out.println("No. Of Packets Sent Out Of the Bucket: "+output_rate);
                storage -= output_rate;
                System.out.println("Buffer size "+storage+" used out of bucket size "+bucket_size);
                System.out.println("Number of packets left in the bucket: "+storage);
            }
        }

    }
}
