import java.util.Scanner;

public class Tokenbucket {
    public static void main(String[] args) {
        int tokens = 0; 
        int rate = 10; 
        int capacity;

        int[] request = new int[100];

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE BUCKET SIZE");
        capacity = scanner.nextInt();

        System.out.print("Enter number of requests: ");
        int n = scanner.nextInt();

        System.out.print("Enter no. of packets per request: ");
        for (int i = 0; i < n; i++) {
            request[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // add tokens to the bucket at a fixed rate
            tokens = Math.min(tokens + rate, capacity);
           System.out.println("Number of packets" + request[i]);
            if (tokens >= request[i]) {
                // remove the requested tokens from the bucket
                tokens -= request[i];
                System.out.println("Request granted, tokens remaining: " + tokens);
            } else {
                System.out.println("Request denied, not enough tokens: " + tokens);
            }
        }

        scanner.close();
    }
}
//output displayed while having enough tokens
ENTER THE BUCKET SIZE
5
Enter number of requests: 5
Enter no. of packets per request: 
1
2
3
4
5
Number of packets1
Request granted, tokens remaining: 4
Number of packets2
Request granted, tokens remaining: 3
Number of packets3
Request granted, tokens remaining: 2
Number of packets4
Request granted, tokens remaining: 1
Number of packets5
Request granted, tokens remaining: 0

  //output displayed while not having enough tokens
  ENTER THE BUCKET SIZE
5
Enter number of requests: 6
Enter no. of packets per request: 1
2
3
4
5
6
Number of packets1
Request granted, tokens remaining: 4
Number of packets2
Request granted, tokens remaining: 3
Number of packets3
Request granted, tokens remaining: 2
Number of packets4
Request granted, tokens remaining: 1
Number of packets5
Request granted, tokens remaining: 0
Number of packets6
Request denied, not enough tokens: 5

