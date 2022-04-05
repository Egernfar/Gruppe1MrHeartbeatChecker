package gui;

import business.EKGObserver;
import data.DummyEKGRecorder;
import data.EKGData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.text.DateFormat;
import java.util.Date;

public class EkgguiController implements EKGObserver {
    DummyEKGRecorder recorder = new DummyEKGRecorder();

    @FXML
    public TextArea ekgView;
    //LineChart kilde: https://stackoverflow.com/questions/61716487/multiple-linechart-series-with-javax-and-fxml
    public LineChart ekgLineChart;

    @Override
    public void handle(EKGData ekgData) {
        // update UI on UI Thread
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // DateFormat kilde: https://docs.oracle.com/javase/7/docs/api/java/text/DateFormat.html
                DateFormat df = DateFormat.getTimeInstance();
                var formatted = df.format(ekgData.getTime());
                addEkgReading(formatted, ekgData.getVoltage());
            }
        };
        // Kilder: https://stackoverflow.com/questions/47183795/how-does-platform-runlater-function
        //         https://stackoverflow.com/questions/29449297/java-lang-illegalstateexception-not-on-fx-application-thread-currentthread-t
        Platform.runLater(task);
    }

    public void startEkg(MouseEvent mouseEvent) {
        //ekgController.startrecording();
        //ekgController.registerObserver(this);
        visualizeGraph();

        // start recorder and tell it to notify this class
        recorder.setObserver(this);
        recorder.record();
    }

    private void addEkgReading(String time, Double value){
        series.getData().add(new XYChart.Data(time, value));
    }

    private XYChart.Series series;

    private void visualizeGraph(){
        ekgLineChart.setTitle("EKG Data");
        //yAxis.setLabel("Valores");
        //xAxis.setLabel("Meses");

        //Kilde: https://stackoverflow.com/questions/13064406/javafx-real-time-linechart-with-time-axis
        series = new XYChart.Series();
        series.setName("Patient EKG Data");
        //series.getData().add(new XYChart.Data("1", 23));
        //series.getData().add(new XYChart.Data("2", 14));
        //series.getData().add(new XYChart.Data("3", 15));
        //series.getData().add(new XYChart.Data("4", -15));


        ekgLineChart.getData().addAll(series);
    }
};
