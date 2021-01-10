package fileexchange;

import java.io.IOException;
import java.io.OutputStream;

public interface FileSender {
    /**
     * Send file from a local program over an output stream to maybe another process
     * @param fileName local filename
     * @param os connection / stream to remote entity
     */
    void sendFile(String fileName, OutputStream os) throws IOException;
}
//Dies kann eine Sache und nur eine Sache
//Es hat nichts mit tcp zu tun. Es schreibt nach ausen eine Datei im Rechner
