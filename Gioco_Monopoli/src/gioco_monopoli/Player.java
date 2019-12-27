/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_monopoli;

import static java.lang.Math.random;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author Michele Bortolotti
 */
class Player {
    int id;
    String nome;
    ArrayList<Property> propietà = new ArrayList();
    int soldi;
    Button btn;
    Popup popup = new Popup();
    Stage stage;
    TilePane tilepane = new TilePane();
    Label label = new Label(nome); //il colore dei giocatori sono: 1-rosso, 2-giallo, 3-verde, 4-blu, 5-viola, 6-arancio
    
    Player(int s){
        soldi = s;
        id = (int) ((random()%10000)+(random()%10000)+(random()%10000));
    }
    
    public void set_Name(String n){
        nome = n;
    }
    
    public void set_Property(Property p){
        propietà.add(p);
    }
    
    public int get_Money(){
        return soldi;
    }
    public ArrayList get_Property(){
        return propietà;
    }
    public void set_Money(int denaro){
        soldi += denaro;
    }
    public boolean Uguale(Player p){
        return id == p.id;
    }
    
    public Button Gen_Button(){
        String colore;
        label.setStyle(" -fx-background-color: white;"); 
        label.setMinWidth(100); 
        label.setMinHeight(150); 
        btn = new Button();
        btn.setText(nome + "\nsoldi: " + soldi + "€");
        EventHandler<ActionEvent> event;
        event = (ActionEvent e) -> {
            if (!popup.isShowing())
                popup.show(stage);
            else
                popup.hide();
        }; 
        btn.addEventHandler(ActionEvent.ACTION, event);
        btn.setPrefSize(150, 100);
        colore = " -fx-background-color: white;-fx-border-color: black;";
        btn.setStyle(colore);
        return btn;
    }
}
