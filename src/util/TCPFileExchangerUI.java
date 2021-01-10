package util;

import app.TCPFileExchange;
import app.TCPFileExchangeImpl;

import java.io.IOException;

public class TCPFileExchangerUI {


    /**
     * UI for file transfer
     * expected parameters:
     * 1)send: filename, hostname (recipient), port
     * Client Sends
     * 2)receive: file name, port
     * Server receives
     */
    public static void main(String[] args) throws IOException {

        if (args.length < 2){
            System.err.println("At least two arguments required");
            return;
        }
        String filename = args[0];
        String hostname = null;
        int port = -1;
        String portString = null;
        if (args.length == 3){ // Variant 1: send
            hostname = args[1];
            portString = args[2];
        } else if (args.length == 2){
            portString = args[1];
        }
        port = Integer.parseInt(portString);




        TCPFileExchange tcpFileExchanger = new TCPFileExchangeImpl();
        if (hostname == null){
            //receive
            tcpFileExchanger.receiveFile(filename, port);
        } else {
            //send
            tcpFileExchanger.sendFile2Host(filename, hostname, port);
        }
    }
}
