package data;

import business.EKGObserver;

import java.text.DateFormat;
import java.util.Date;

//Subject
public class DummyEKGRecorder implements EkgDataRecorder {
    private EKGObserver observer;
    Date date = new Date();

    @Override
    public void record() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Dummy data generation
                    while(true) {
                        Thread.sleep(500);
                        if (observer != null) {
                            date.setTime(date.getTime()+1000);
                            observer.handle(new EKGDataImpl(Math.random(), date));
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    public void setObserver(EKGObserver observer) {
        this.observer=observer;
    }
}
