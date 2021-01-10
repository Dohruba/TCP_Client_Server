package sensordata;

class SensorDataImpl implements  SensorData{

    private final long timeStamp;
    private final float value;
    private final String sensorName;

    SensorDataImpl(long timeStamp, float value, String sensorName){
         this.timeStamp = timeStamp;
         this.value = value;
         this.sensorName = sensorName;

    }
    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public String getSensorName() {
        return this.sensorName;
    }
}
