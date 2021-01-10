package fileexchange;

import java.io.IOException;
import java.io.InputStream;

public interface FileReceiver {
    /**
     * Received content from input stream and writes it to local file
     * @param filename local file name
     * @param is content provider
     */
    void reciveFile(String filename, InputStream is) throws IOException;
}
//Dies kann eine Sache und nur eine Sache
//Es hat nichts mit tcp zu tun. Es bekommt eine Inputstream und schreibt es in eine Datei im Rechner