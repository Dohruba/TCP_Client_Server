package TCPServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    final int port;
    public static final int portNumber = 5123;
    //To try on your computer, change the username to yours
    File myFile = new File("C:\\Users\\richa\\Documents\\TheText.txt");

    public static void main(String[] args) throws IOException, InterruptedException {
        TCPServer tcpServer = new TCPServer(portNumber);

        tcpServer.SendFile();
    }

    TCPServer(int port){
        this.port = port;
    }

    private void SocketAndConnection() throws IOException, InterruptedException {
        //Creating the socket
        ServerSocket sSocket = new ServerSocket(this.port);
        System.out.println("Server Socket creates");

        byte[] byteArray = new byte[1024];
        FileInputStream fis = new FileInputStream(myFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(byteArray);


        //Creating the connection
        Socket socket = sSocket.accept();
        System.out.println("Client Connection accepted");

        socket.getInputStream().read();
        System.out.println("\nRead something");


        OutputStream os = socket.getOutputStream();
        os.write((":)").getBytes());
        System.out.println("Write Sometjing");

        Thread.sleep(5000);
        System.out.println("Woke");
        os.close();
    }

    private void SendFile() throws IOException, InterruptedException {
        //Creating the socket
        ServerSocket sSocket = new ServerSocket(this.port);
        System.out.println("Server Socket creates");

        //Creating the connection
        Socket socket = sSocket.accept();
        System.out.println("Client Connection accepted");
        //Buffered File
        byte[] byteArray = new byte[1024];
        FileInputStream fis = new FileInputStream(myFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(byteArray);

        System.out.println("\nRead something");


        OutputStream os = socket.getOutputStream();
        os.write(byteArray, 0, byteArray.length);
        System.out.println("Write Sometjing");

        Thread.sleep(5000);
        System.out.println("Woke");
        os.close();
    }
}
