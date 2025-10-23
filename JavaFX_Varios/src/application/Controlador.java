package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Controlador implements Initializable {
	@FXML
	private ChoiceBox<String> choiceBox;
	
	String[] lista = {"Sushi", "Ramen", "Pizza"};
	
	@FXML
	private Slider slider;
	
	@FXML
	private Label lbl, lblProgressBar, lblSlider;
	
	@FXML
	private ProgressBar progressBar;
	
	@FXML
	private Button btnProgressBar;
	
	private int progreso = 0;
	
	@FXML
	private ColorPicker colorPicker;
	
	@FXML
	private AnchorPane anchorPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// choiceBox
		choiceBox.getItems().addAll(lista);
		choiceBox.setValue(lista[0]);
		choiceBox.setOnAction(e ->{
			lbl.setText(choiceBox.getValue());
		});
		
		// progressBar
		progressBar.setStyle("-fx-accent: red");
		btnProgressBar.setOnAction(e -> {
		    if (progreso < 100) {
		        progreso += 10;
		        if (progreso > 100) progreso = 100;
		        progressBar.setProgress(progreso / 100.0);
		        lblProgressBar.setText(progreso + "%");
		    } else {
		        lblProgressBar.setText("Completado");
		        btnProgressBar.setDisable(true);
		    }
		});
		
		// slider
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(50);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(10);
		
		
		slider.valueProperty().addListener((obs, oldVal, newVal) -> {
			lblSlider.setText(String.valueOf(newVal.intValue()));
		});
		
		// colorpicker
		colorPicker.setOnAction(e -> {
			Color miColor = colorPicker.getValue();
			anchorPane.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), null, null)));
		});
	}
	
}
