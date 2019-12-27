/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_monopoli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Utente
 */
public class Gioco_Monopoli extends Application {
    public static ArrayList<Property> list = new ArrayList();
    public static GridPane gridpane = new GridPane();
    public static ArrayList<Player> player = new ArrayList();
    public static Stage stage;
    public static Pane root;
    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        int numero_giocatori = 0;
        int soldi_giocatore = 0;
        root = new Pane();
        gridpane.setPrefSize(1500, 100);
        root.getChildren().add(gridpane);
        Scene scene = new Scene(root, 1400, 700);
        
        do
        {
            String Numero_giocatori = JOptionPane.showInputDialog("Inserire numero giocatori (min 2 e max 6)"); 
            numero_giocatori = Integer.parseInt(Numero_giocatori);
        }
        while(numero_giocatori <= 1 || numero_giocatori > 6);
        do
        {
            String Soldi_giocatori = JOptionPane.showInputDialog("Inserire i soldi iniziali dei giocatori"); 
            soldi_giocatore = Integer.parseInt(Soldi_giocatori);
        }
        while(soldi_giocatore <= 0);
        stage.setTitle("Monopoli");
        stage.setScene(scene);
        stage.show();    
    
        for(int i = 0; i < numero_giocatori; i++){
            player.add(new Player(soldi_giocatore));
            player.get(i).set_Name("Giocatore " + (i+1));
        }
        Create_property();
        Assigns_property(numero_giocatori);
        Iterator iter=list.iterator();
        while(iter.hasNext()){
            Property next=(Property)iter.next();
            gridpane.add(next.getButton(),next.get_Posx(),next.get_Posy());
        }
        for(int i = 0; i < player.size(); i++)
            gridpane.add(player.get(i).Gen_Button(), 11, (player.size()-(player.size()-3))+i);
    }
        
    private void Create_property() {
        Property a = new Property("Posteggio\ngratuito", 0 , 0 , 0,false); a.setLayout(130,130,"null");
        list.add(a);
        a = new Property("Via Marco\nPolo\n\n", 550 , 1 , 0,true); a.setLayout(100,130,"red");
        list.add(a);
        a = new Property("Imprevisti", 0 , 2 , 0,false); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Corso \nMagellano \n\n", 550 , 3 , 0,true); a.setLayout(100,130,"red");
        list.add(a);
        a = new Property("Largo \nColombo \n\n", 600 , 4 , 0,true); a.setLayout(100,130,"red");
        list.add(a);
        a = new Property("Stazione \nNord \n\n", 480 , 5 , 0,true); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Viale \nCostantino \n\n", 650 , 6 , 0,true); a.setLayout(100,130,"yellow");
        list.add(a);
        a = new Property("Viale \nTraiano \n\n", 650 , 7 , 0,true); a.setLayout(100,130,"yellow");
        list.add(a);
        a = new Property("Società\nAcqua\nPotabile \n", 350 , 8 , 0,true); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Piazza\nGiulio \nCesare \n\n", 700 , 9 , 0,true); a.setLayout(100,130,"yellow");
        list.add(a);
        a = new Property("In prigione!", 0 , 10 , 0,false); a.setLayout(130,130,"null");
        list.add(a);
        a = new Property("Via Roma\n", 750 , 10 , 1,true); a.setLayout(130,50,"green");
        list.add(a); 
        a = new Property("Corso Impero\n", 750 , 10 , 2,true); a.setLayout(130,50,"green");
        list.add(a); 
        a = new Property("Probabilità\n", 0 , 10 , 3,false); a.setLayout(130,50,"null");
        list.add(a); 
        a = new Property("Largo Augusto\n", 800 , 10 , 4,true); a.setLayout(130,50,"green");
        list.add(a); 
        a = new Property("Stazione Est\n", 480 , 10 , 5,true); a.setLayout(130,50,"null");
        list.add(a); 
        a = new Property("Imprevisti", 0 , 10 , 6,false); a.setLayout(130,50,"null");
        list.add(a); 
        a = new Property("Viale dei\nGiardini\n", 900 , 10 , 7,true); a.setLayout(130,60,"violet");
        list.add(a); 
        a = new Property("Tassa di lusso\n", 250 , 10 , 8,false); a.setLayout(130,50,"null");
        list.add(a);
        a = new Property("Parco della\nVittoria\n", 1000 , 10 , 9,true); a.setLayout(130,60,"violet");
        list.add(a);
        a = new Property("VIA\nRitira  ", 500 , 10 , 10,false); a.setLayout(130,130,"null");
        list.add(a);
        a = new Property("Vicolo \nCorto \n\n", 150 , 9 , 10,true); a.setLayout(100,130,"pink");
        list.add(a);
        a = new Property("Probabilità ", 0 , 8 , 10,false); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Vicolo\nStretto \n\n", 150 , 7 , 10,true); a.setLayout(100,130,"pink");
        list.add(a);
        a = new Property("Tassa\nPatrimoniale \n\n", 500 ,6 , 10,false); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Stazione \nSud\n\n", 480 , 5 , 10,true); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Bastioni\nGran Sasso \n\n", 250 , 4 , 10,true); a.setLayout(100,130,"blue");
        list.add(a);
        a = new Property("Imprevisti ", 0 , 3 , 10,false); a.setLayout(100,130,"null");
        list.add(a);
        a = new Property("Viale \nMonterosa \n\n", 250 , 2 , 10,true); a.setLayout(100,130,"blue");
        list.add(a);
        a = new Property("Viale \nVesuvio \n\n", 300 , 1 , 10,true); a.setLayout(100,130,"blue");
        list.add(a);
        a = new Property("Prigione \nTransito", 0 , 0 , 10,false); a.setLayout(130,130,"null");
        list.add(a);
        a = new Property("Via Accademia\n", 350 , 0 , 9,true); a.setLayout(130,60,"orange");
        list.add(a);
        a = new Property("Società Elettrica\n", 375 , 0 , 8,true); a.setLayout(130,50,"null");
        list.add(a);
        a = new Property("Corso Ateneo\n", 350 , 0 , 7,true); a.setLayout(130,60,"orange");
        list.add(a);
        a = new Property("Piazza Università\n", 400 , 0 , 6,true); a.setLayout(130,50,"orange");
        list.add(a);
        a = new Property("Stazione Ovest\n", 480 , 0 , 5,true); a.setLayout(130,50,"null");
        list.add(a);
        a = new Property("Via Verdi\n", 450 , 0 , 4,true); a.setLayout(130,50,"brown");
        list.add(a);
        a = new Property("Probabilità", 0 , 0 , 3,false); a.setLayout(130,50,"null");
        list.add(a);
        a = new Property("Corso Raffaello\n", 450 , 0 , 2,true); a.setLayout(130,50,"brown");
        list.add(a);
        a = new Property("Piazza Dante\n", 500 , 0 , 1,true); a.setLayout(130,50,"brown");
        list.add(a);
        
   }
    
    private void Assigns_property(int numero_giocatori)
    {
        Collections.shuffle(list);
        int k = 0;
        int cont = 0;
        for(int j = 0; j < numero_giocatori; j++)
        {
            while(cont < 9-numero_giocatori)
            {
                if(list.get(k).preso)
                {
                    player.get(j).set_Property(list.get(k));
                    list.get(k).Set_Player(player.get(j));
                    cont++;
                }
            k++;
            }
        cont = 0;
        }
    }
    
    
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
