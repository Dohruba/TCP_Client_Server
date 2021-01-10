package tcp;

import java.io.IOException;

public interface Server {
    Connection acceptConnection(int port) throws IOException;
}
