/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco_monopoli;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 *
 * @author Utente
 */
class Property {
    int id;
    String name;
    int prezzo;
    int numero_case;
    Player player;
    int posx;
    int posy;
    Button btn;
    boolean preso;
    Color colore;
    private String css;
    double altezza;
    double larghezza;
    
    Property( String n, int p, int x, int y, boolean t){
        name = n;
        prezzo = p;       
        posx = x;
        posy = y;
        id = name.hashCode()+posx+posy;
        preso = t;
    }
    
    private void GenButton(){
        btn = new Button();
        if(prezzo !=0){
            btn.setText(name + String.valueOf(prezzo) + "€");
        }
        else{
            btn.setText(name);
        }
        
        btn.setStyle(css);
        btn.setMaxSize(altezza,larghezza);
        btn.setMinSize(altezza,larghezza);
        btn.setPrefSize(altezza, larghezza);
    }
    
    public void setLayout(int y, int x, String color){
        larghezza = x;
        altezza = y;
        if(color.equals("null"))
            color="white";
        if(color.equals("blue"))
            color="cyan";
        if(color.equals("brown"))
            color="chocolate";
        css="-fx-background-color: "+color+"; -fx-border-color: black;";
        GenButton();  
    }
    
    public void Set_Player(Player p){
        player = p;
    }
    public String get_Name(){
        return this.name;
    }
    public int get_Prezzo(){
        return this.prezzo;
    }
    public int get_Numero_Case(){
        return this.numero_case;
    }
    public Player get_Player(){
        return this.player;
    }
    public int get_Posx(){
        return this.posx;
    }
    public int get_Posy(){
        return this.posy;
    }
    public String toString(){
        return this.name;
    }
    public boolean is_Equeal(Property p){
        return this.id == p.id;
    }
    public Button getButton(){
        return btn;
    }
    
}
