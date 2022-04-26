package data;

import business.EKGObserver;

import java.text.DateFormat;
import java.util.Date;

//Subject
public class DummyEKGRecorder implements EkgDataRecorder {
    private EKGObserver observer;

    @Override
    public void record() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    double time = 0;
                    //Dummy data generation
                    while(true) {
                        Thread.sleep(50);
                        if (observer != null) {
                            observer.handle(new EKGDataImpl(70*Math.random(), time));
                            time+=0.5;
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
