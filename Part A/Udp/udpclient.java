import java.net.*;
import java.io.*;

class UdpClient
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket datagramSocket = new DatagramSocket(3000);
		byte[] buffer;
		DatagramPacket datagramPacket;
		System.out.println("Received Messages: ");
		while(true)
		{
			buffer = new byte[65555];
			datagramPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagramPacket);
			String received = new String(buffer).trim();
			System.out.println(received);
			if (received.equalsIgnoreCase("exit")) {
				datagramSocket.close();
				break;
			}
		}
	}
}
     
/*output;-
  first run the server program in one terminal in another terminal run the client program
Server side
javac UDPServer.java
java UDPServer
Server is Ready for the client
RECEIVED: abcdef

Client Side
javac UDPClient.java
java UDPClient
Enter the string in lowercase so that you receive the message in Uppercase from the server
abcdef
FROM SERVER: ABCDEF
*/
