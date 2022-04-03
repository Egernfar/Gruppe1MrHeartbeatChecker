package gui;

import business.EKGObserver;
import business.EkgController;
import business.EkgControllerImpl;
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
    EkgController ekgController = new EkgControllerImpl();
    DummyEKGRecorder recorder = new DummyEKGRecorder();

    @FXML
    public TextArea ekgView;
    public LineChart ekgLineChart;

    @Override
    public void handle(EKGData ekgData) {
        // update UI on UI Thread
        /*Runnable task = new Runnable() {
            @Override
            public void run() {
                date.setTime(date.getTime()+1000);
                DateFormat df = DateFormat.getTimeInstance();
                addEkgReading(df.format(date), Math.random()*500);
            }
        };
        Platform.runLater(task);
*/
        date.setTime(date.getTime()+1000);
        DateFormat df = DateFormat.getTimeInstance();
        addEkgReading(df.format(date), Math.random()*500);
    }

    public void startEkg(MouseEvent mouseEvent) {
        //ekgController.startrecording();
        //ekgController.registerObserver(this);
        visualizaGrafico();

        // start recorder and tell it to notify this class
        recorder.setObserver(this);
        recorder.record();
    }
    Date date = new Date();
    public void readEkg(MouseEvent mouseEvent) {
        //ekgController.startrecording();
        //ekgController.registerObserver(this);

        date.setTime(date.getTime()+1000);
        DateFormat df = DateFormat.getTimeInstance();
        addEkgReading(df.format(date), Math.random()*500);

    }

    private void addEkgReading(String time, Double value){
        series.getData().add(new XYChart.Data(time, value));
    }

    private XYChart.Series series;

    private void visualizaGrafico(){
        ekgLineChart.setTitle("EKG Data");
        //yAxis.setLabel("Valores");
        //xAxis.setLabel("Meses");

        series = new XYChart.Series();
        series.setName("Patient EKG Data");
        //series.getData().add(new XYChart.Data("1", 23));
        //series.getData().add(new XYChart.Data("2", 14));
        //series.getData().add(new XYChart.Data("3", 15));
        //series.getData().add(new XYChart.Data("4", -15));


        ekgLineChart.getData().addAll(series);
    }
};
