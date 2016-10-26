/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oczko;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Justyna
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Label sumaGracz,sumaKrupier, result;
    @FXML public ListView gracz, krupier;
    @FXML public Button next, pass;
    public int gsuma,ksuma;
    public Card c=new Card();
    
    @FXML
    private void handleButtonPass(ActionEvent event) {
        while(ksuma<16){
            krupier();
        }
        if(ksuma>21){
            result.setText("WYGRAŁEŚ");
        }
        else
        {       if(gsuma>ksuma){
                    result.setText("WYGRAŁEŚ");
                     next.setDisable(true);
                        pass.setDisable(true);
                }
                if(gsuma<ksuma){
                    result.setText("PRZEGRAŁEŚ");
                     next.setDisable(true);
            pass.setDisable(true);
                }
                if(gsuma==ksuma){
                    result.setText("REMIS");
                     next.setDisable(true);
            pass.setDisable(true);
                }
    }
    }
    @FXML
    public void krupier(){
        c=c.drowCard();
        ObservableList<String> kcards = krupier.getItems();
        ksuma=ksuma+c.getValue();
        sumaKrupier.setText(String.valueOf(ksuma));
        kcards.add(c.getFigure()+"");
        krupier.setItems(kcards); 
    }
    @FXML
    private void handleButtonNext(ActionEvent event){
        c=c.drowCard();
        ObservableList<String> gcards = gracz.getItems();
        gsuma=gsuma+c.getValue();
        sumaGracz.setText(String.valueOf(gsuma));
        gcards.add(c.getFigure()+"");
        gracz.setItems(gcards);
        result();
    }
    @FXML
    private void result(){
        if(gsuma==21){
            result.setText("WYGRAŁEŚ");
            next.setDisable(true);
            pass.setDisable(true);
        }
        if(gsuma>21){
            result.setText("PRZEGRAŁEŚ");
             next.setDisable(true);
            pass.setDisable(true);
        }
    }
    @FXML
    private void handleButtonStart(ActionEvent event){
     init();   
    }
    private void init(){
         next.setDisable(false);
            pass.setDisable(false);
        result.setText("");
        gsuma=ksuma=0;
        sumaGracz.setText("");
        sumaKrupier.setText("");
        c=c.drowCard();
        ObservableList<String> gcards = FXCollections.observableArrayList();
        ObservableList<String> kcards = FXCollections.observableArrayList();
        gsuma=c.getValue();
        sumaGracz.setText(String.valueOf(gsuma));
        gcards.add(c.getFigure()+"");
        c=c.drowCard();
        ksuma=c.getValue();
        sumaKrupier.setText(String.valueOf(ksuma));
        kcards.add(c.getFigure()+"");
        gracz.setItems(gcards);
        krupier.setItems(kcards);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
// TODO
    }    
    
}
