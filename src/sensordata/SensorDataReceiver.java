package sensordata;

import java.io.IOException;
import java.io.InputStream;

public interface SensorDataReceiver {
    /**
     * Recive data from stream and create file
     * @param
     */
    SensorData receiveSensorData(InputStream is) throws IOException;
}
