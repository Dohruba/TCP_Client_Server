package app;

import com.sun.jdi.connect.Connector;
import fileexchange.FileExchanger;
import fileexchange.FileReceiver;
import fileexchange.FileSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class TCPFileExchangeImpl implements TCPFileExchange{
    @Override
    public void sendFile2Host(String filename, String hostname, int port) throws IOException {
        //need connection
        Client client = new TCPConnector();
        /*Se crea un objeto de tipo cliente que utiliza los override de TCPConnector*/
        Connection connection = client.connect(hostname,port);
        /*En los override de TCPConnector para la interfaz client, connect usa Socket para crear una conneccion con el
         host a través del puerto port*/

        //Send File
        FileSender fileSender= new FileExchanger();
        /*Se crea un objeto de tipo FileSender, con los override de FileExchanger para sender (osea, no puede usar los de recibir)*/

        fileSender.sendFile(filename, connection.getOutputStream());
        /*fileSender usando el override de FileExchanger sendFile, crea un inputsream para recoger la informacion que se va a mandar*/
                                    /*connection de tipo Connection usando los override que tiene client sobre TCPConnector para tomar lo que se va a mandar*/
        /*sendfile lee los datos en u fis y los manda como un os*/
    }

    @Override
    public void receiveFile(String filename, int port) throws IOException {
        //need conection
        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);

        //Receive file
        FileReceiver fileReceiver = new FileExchanger();
        fileReceiver.reciveFile(filename,connection.getInputStream());
    }
}
