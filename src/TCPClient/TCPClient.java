package TCPClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

    public static String hostname;
    public static int port;
    public static final String Irgendwas = "LOL";

    public static void main (String[] args) throws IOException, InterruptedException {

        String hostname = args[0];
        String portString = args[1];
        int port = Integer.parseInt(portString);

        TCPClient tcpC = new TCPClient(hostname, port);
        SendFile();
    }

    TCPClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    private static void ServerConnection() throws IOException, InterruptedException {
        byte[] readBuffer = new byte[100];
        String readString;
        Socket socket = new Socket(hostname, port);
        System.out.println("Socket created, connected");

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        os.write("Sending from Client".getBytes());
        System.out.println("\nWrote something");

        is.read(readBuffer);
        readString = new String(readBuffer);
        System.out.println("Read something " + readString);
        is.close();
        Thread.sleep(3000);
        System.out.println("\nWoke");
        socket.close();
    }

    private static void SendFile() throws IOException {
        Socket socket = new Socket(hostname, port);
        socket.getOutputStream().write(Irgendwas.getBytes());

        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\Users\\richa\\Documents\\Universidad\\AngewandteInformatik\\2.Semester\\Programmieren2\\Test\\Haiku.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[10000];
        int i = 0;
        int read = 0;

        do{
            read = is.read();
            if (read != -1){
                byte readByte = (byte) read;
                buffer[i++] = readByte;
            }
        }while (read != -1);

        // i = länge der Text

        byte[] recievedBytes = new byte[i];
        for (int j =0 ; j < i ; j++){
            recievedBytes[j] = buffer[j];
        }
        String receivedString = new String(buffer);
        bos.write(receivedString.getBytes());
        bos.close();
        System.out.println("Received: \n" + receivedString);


    }
}
