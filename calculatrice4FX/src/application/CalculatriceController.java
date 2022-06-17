package application;


import fr.mj.metier.Calculatrice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;



public class CalculatriceController {
	
	@FXML
	Label visuelle;
	
	@FXML
	Label erreurMessage;
	
	Calculatrice calculatrice = new Calculatrice();
	
	@FXML
	public void initialize() {
		erreurMessage.setText("");
	}
	
	@FXML
	public void onClick(Event event) {
		Button button = (Button) event.getSource();
		calculatrice.touche(button.getText());
		visuelle.setText(calculatrice.toString());
	}
	
	
}
