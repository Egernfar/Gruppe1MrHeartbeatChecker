package data;

import java.util.Date;

public interface EKGData {
    void setVoltage(double voltage);
    double getVoltage();
    void setTime(Date time);
    Date getTime();
}
