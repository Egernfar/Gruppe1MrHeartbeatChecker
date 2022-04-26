package data;

import java.util.Date;

public interface EKGData {
    void setVoltage(double voltage);
    double getVoltage();
    void setTime(double time);
    double getTime();
}
