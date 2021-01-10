package tcp;

import java.io.IOException;

public interface Client {
    Connection connect(String hostname, int port) throws IOException;
}
