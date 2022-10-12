package dad.buscaryremplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYRemplazar extends Application {

	//view
	private HBox root;
	private TextField buscarText, reemplazarText;
	private CheckBox mayusYMinusCheck, haciaAtrasCheck, regularExpCheck, resaltarCheck;
	private VBox buttonsPanel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//textfields
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		//botones
		buttonsPanel = new VBox();
		String[] botonesTexto = {"Buscar", "Reemplazar", "Reemplazar todo", "Cerrar", "Ayuda"};
		for(String s:botonesTexto) {
			Button b = new Button(s);
			b.setMaxWidth(Double.MAX_VALUE);//todos los botones con el maxwidth = width del más largo
			buttonsPanel.getChildren().add(b);
		}
		
		//check boxes
		mayusYMinusCheck = new CheckBox("Mayúsculas y Minúsculas");
		haciaAtrasCheck = new CheckBox("Buscar hacia atrás");
		regularExpCheck = new CheckBox("Expresión regular");
		resaltarCheck = new CheckBox("Resaltar resultados");
		
		//vbox con los botones
//		buttonsPanel.setStyle("-fx-background-color: red");
		buttonsPanel.setAlignment(Pos.TOP_CENTER);
		buttonsPanel.setPadding(new Insets(5,5,5,5));
		buttonsPanel.setSpacing(5);
		buttonsPanel.setMinWidth(Control.USE_PREF_SIZE);
		
		//grid pane con los check boxes
		GridPane checkPanel = new GridPane();
//		checkPanel.setStyle("-fx-background-color: yellow");
		checkPanel.setHgap(5);
		checkPanel.setVgap(5);
		checkPanel.setMaxWidth(Control.USE_PREF_SIZE);
		checkPanel.addRow(0, mayusYMinusCheck, haciaAtrasCheck);
		checkPanel.addRow(1, regularExpCheck, resaltarCheck);
		
		// gridpane con los elementos del formulario
		GridPane formularioPanel = new GridPane();
//		gridpane.setStyle("-fx-background-color: aqua");
		formularioPanel.setPadding(new Insets(5,5,5,5));
		formularioPanel.setHgap(5);
		formularioPanel.setVgap(5);
		formularioPanel.addRow(0, new Label("Buscar:"), buscarText, buttonsPanel);
		formularioPanel.addRow(1, new Label("Reemplazar con:"), reemplazarText);
		formularioPanel.addRow(2, new Label(""), checkPanel);

		//root con todo
		root = new HBox(formularioPanel, buttonsPanel);
		HBox.setHgrow(formularioPanel, Priority.ALWAYS);
		
		ColumnConstraints [] cols = {
			new ColumnConstraints(), 
			new ColumnConstraints(), 
			new ColumnConstraints()	
		};
		formularioPanel.getColumnConstraints().setAll(cols);

		cols[1].setHgrow(Priority.ALWAYS);
		cols[2].setMinWidth(Control.USE_PREF_SIZE);
		
		
		primaryStage.setTitle("BuscarYRemplazar");
		primaryStage.setScene(new Scene(root, 550, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
