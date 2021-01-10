package app;

import sensordata.SensorData;
import sensordata.SensorDataExchanger;
import sensordata.SensorDataReceiver;
import sensordata.SensorDataSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class TCPSensorDataExchangerImpl implements TCPSensorDataExchanger {
    @Override
    public void sendSensorData(SensorData data, String hostname, int port) throws IOException {
        //need connection
        Client client = new TCPConnector();
        Connection connection = client.connect(hostname, port);

        //Send Sensor Data
        SensorDataSender sensorDataSender = new SensorDataExchanger();
        sensorDataSender.sendSensorData(data, connection.getOutputStream());/*El get output stream viene del outputstream del socket en connection*/
    }

    @Override
    public void receiveSensorData(int port) throws IOException {

        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);

        //Receive Sensor Data
        SensorDataReceiver sensorDataReceiver = new SensorDataExchanger();
        sensorDataReceiver.receiveSensorData(connection.getInputStream());
    }
}
