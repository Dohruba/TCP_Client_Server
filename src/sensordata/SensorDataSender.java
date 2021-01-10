package sensordata;

import java.io.IOException;
import java.io.OutputStream;

public interface SensorDataSender {
    /**
     * send sensor data
     * @param data
     * @param os stream to receiver
     */
    void sendSensorData(SensorData data, OutputStream os) throws IOException;
}
