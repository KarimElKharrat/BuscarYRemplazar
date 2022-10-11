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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYRemplazar extends Application {

	//view
	
	private GridPane root;
	private TextField buscarText, reemplazarText;
	private CheckBox mayusYMinusCheck, haciaAtrasCheck, regularExpCheck, resaltarCheck;
	private Button buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton;
	private VBox buttonsPanel;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//textfields
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		//botones
		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazarTodoButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");

		buscarButton.setMaxWidth(Double.MAX_VALUE);
		reemplazarButton.setMaxWidth(Double.MAX_VALUE);
		cerrarButton.setMaxWidth(Double.MAX_VALUE);
		ayudaButton.setMaxWidth(Double.MAX_VALUE);
		
		//check boxes
		mayusYMinusCheck = new CheckBox("Mayúsculas y Minúsculas");
		haciaAtrasCheck = new CheckBox("Buscar hacia atrás");
		regularExpCheck = new CheckBox("Expresión regular");
		resaltarCheck = new CheckBox("Resaltar resultados");
		
		//vbox con los botones
		buttonsPanel = new VBox(buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton);
		buttonsPanel.setAlignment(Pos.CENTER);
		buttonsPanel.setPadding(new Insets(0,5,0,5));
		buttonsPanel.setSpacing(5);
		
		//grid pane con los check boxes
		GridPane checkPanel = new GridPane();
		checkPanel.setHgap(5);
		checkPanel.setVgap(5);
		checkPanel.addRow(0, mayusYMinusCheck, haciaAtrasCheck);
		checkPanel.addRow(1, regularExpCheck, resaltarCheck);
		
		//root con todo
		root = new GridPane();
		root.setPadding(new Insets(5,5,5,5));
		root.setHgap(5);
		root.setVgap(5);
		root.addRow(0, new Label("Buscar:"), buscarText, buttonsPanel);
		root.addRow(1, new Label("Reemplazar con:"), reemplazarText);
		root.addRow(2, new Label(""), checkPanel);
		
		ColumnConstraints [] cols = {
			new ColumnConstraints(), 
			new ColumnConstraints(), 
			new ColumnConstraints()	
		};
		
		root.getColumnConstraints().setAll(cols);
		cols[2].setMinWidth(Control.USE_PREF_SIZE);
		
		GridPane.setRowSpan(buttonsPanel, 3);
		
		primaryStage.setTitle("BuscarYRemplazar");
		primaryStage.setScene(new Scene(root, 500, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
