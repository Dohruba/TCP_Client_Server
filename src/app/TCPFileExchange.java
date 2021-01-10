package app;

import java.io.IOException;

public interface TCPFileExchange {
    /**
     * Send a file from a local entity to remote host via TCP
     * @param filename
     * @param hostname
     * @param port
     */
    void sendFile2Host(String filename, String hostname, int port) throws IOException;

    /**
     *  Receive content from a TCP Client and write it to local file
     * @param filename
     * @param port
     */
    void receiveFile(String filename, int port) throws IOException;
}
