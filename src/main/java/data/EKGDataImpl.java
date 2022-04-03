package data;

import java.util.Date;

public class EKGDataImpl implements EKGData {
    private double voltage;
    private Date time;

    public EKGDataImpl(double voltage, Date time) {
        this.time=time;
        this.voltage=voltage;

    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }
}
