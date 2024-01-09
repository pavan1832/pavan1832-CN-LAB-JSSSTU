import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        int noOfQueries;
        int bucketSize;
        int inputPacketSize;
        int outputPacketSize;
        int storedBufferSize = 0;
        int sizeLeft;

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE BUCKET SIZE");
        bucketSize = scanner.nextInt();
        System.out.println("ENTER THE NUMBER OF PACKETS");
        noOfQueries = scanner.nextInt();
        System.out.println("ENTER THE OUTPUT RATE");
        outputPacketSize = scanner.nextInt();

        for (int i = 0; i < noOfQueries; i++) {
            System.out.print("ENTER THE SIZE OF THE PACKET :");
            inputPacketSize = scanner.nextInt();

            sizeLeft = bucketSize - storedBufferSize;

            if (inputPacketSize <= sizeLeft) {
                storedBufferSize += inputPacketSize;
                System.out.println("Number of Packets added into Bucket" + inputPacketSize);
            } else {
                System.out.println("Number of Packets Dropped " + (storedBufferSize + inputPacketSize - bucketSize));
                storedBufferSize = bucketSize;
            }
            /* System.out.println("Stored Buffer Size: " + storedBufferSize); */
            storedBufferSize -= outputPacketSize;
        }

        scanner.close();
    }
}

//output without packet drop
ENTER THE BUCKET SIZE
10
ENTER THE NUMBER OF PACKETS
5
ENTER THE OUTPUT RATE
1 10
ENTER THE SIZE OF THE PACKET :1
Number of Packets added into Bucket1
ENTER THE SIZE OF THE PACKET :2
Number of Packets added into Bucket2
ENTER THE SIZE OF THE PACKET :3
Number of Packets added into Bucket3
ENTER THE SIZE OF THE PACKET :4
Number of Packets added into Bucket4
ENTER THE SIZE OF THE PACKET :5
Number of Packets added into Bucket5

//output with packet drop
  ENTER THE BUCKET SIZE
10
ENTER THE NUMBER OF PACKETS
2
ENTER THE OUTPUT RATE
10
ENTER THE SIZE OF THE PACKET :11
Number of Packets Dropped 1
ENTER THE SIZE OF THE PACKET :12
Number of Packets Dropped 2
