package gui;

import business.EKGObserver;
import data.DummyEKGRecorder;
import data.EKGData;
import data.EkgDataAccess;
import database.EkgDTO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

import java.text.DateFormat;
import java.util.Date;

public class EkgguiController implements EKGObserver {

    DummyEKGRecorder recorder = new DummyEKGRecorder();

    @FXML
    public Polyline poly;

    @Override
    public void handle(EKGData ekgData) {
        // update UI on UI Thread
        Runnable task = new Runnable() {
            @Override
            public void run() {
                poly.getPoints().addAll(ekgData.getTime(),ekgData.getVoltage());

            }
        };
        Platform.runLater(task); // Alt kører på gui tråden - tasks til Gui sættes i kø

    }

    public void startEkg(MouseEvent mouseEvent) {
EkgDataAccess ekgDataAccess = new EkgDataAccess();
EkgDTO ekg = ekgDataAccess.createEKG(1, new Date());


        // start recorder and tell it to notify this class
        recorder.setObserver(this);
        recorder.record();
    }

};
