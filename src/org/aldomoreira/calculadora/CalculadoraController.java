
package org.aldomoreira.calculadora;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class CalculadoraController implements Initializable {
    
    private enum Operacion{NINGUNO, SUMA, RESTA, DIVISION, MULTIPLICACION, POTENCIA};
    private Operacion tipoOperacion = Operacion.NINGUNO;
    private CalculadoraModel calculadora = CalculadoraModel.getInstance();
    //Referenciando los controles desde Java
    
    //Referencia a los objetos gráficos
    private Label label;
    @FXML
    private TextField txtPantalla;
    @FXML
    private Button btnSiete;
    @FXML
    private Button btnOcho;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnSeis;
    @FXML
    private Button btnCuatro;
    @FXML
    private Button btnNueve;
    @FXML
    private Button btnCero;
    @FXML
    private Button btnMasMenos;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnPunto;
    @FXML
    private Button btnIgual;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnPotencia;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnMulti;

    
    
 
    //Eventos de OnAction clic de cada coontrol o nodoc
    @FXML
    private void eventoBotonSiete(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("7"));
    }

    @FXML   
    private void eventoBotonOcho(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("8"));
    }

    @FXML
    private void eventoBotonCinco(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("5"));
    }

    @FXML
    private void eventoBotonSeis(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("6"));
    }

    @FXML
    private void eventoBotonCuatro(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("4"));
    }

    @FXML
    private void eventoBotonNueve(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("9"));
    }

    @FXML
    private void eventoBotonCero(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("0"));
    }

    @FXML
    private void eventoBotonMasMenos(ActionEvent event) {
        double n = Double.parseDouble(txtPantalla.getText());
        Double cambiarSigno = n*(-1);
        txtPantalla.setText(cambiarSigno.toString());
    }

    @FXML
    private void eventoBotonTres(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("3"));
    }

    @FXML
    private void eventoBotonDos(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("2"));
    }

    @FXML
    private void eventoBotonUno(ActionEvent event) {
       txtPantalla.setText(txtPantalla.getText() + ("1"));
    }

    @FXML
    private void eventoBotonPunto(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText() + ("."));
        btnPunto.setDisable(true);
    }

    @FXML
    private void eventoBotonIgual(ActionEvent event) {
        btnPunto.setDisable(false);
        //Capturamos el segundo valor de la pantalla
        calculadora.setNumeroDos(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Switch para evaluar la operación seleccionada
        switch(tipoOperacion){
        
        case SUMA:
            //Establecemos la operacion
            calculadora.setResultado(calculadora.fnSuma());
            JOptionPane.showMessageDialog(null, calculadora.fnSuma());
        break;
        case RESTA:
             //Establecemos la operacion
            calculadora.setResultado(calculadora.fnResta());
            JOptionPane.showMessageDialog(null, calculadora.fnResta());
                break;
        case MULTIPLICACION: 
            calculadora.setResultado(calculadora.fnMultiplicacion());
            JOptionPane.showMessageDialog(null, calculadora.fnMultiplicacion());
            break;
        case DIVISION:
                calculadora.setResultado(calculadora.fnDivision());
            JOptionPane.showMessageDialog(null, calculadora.fnDivision());
            
            break;
        case POTENCIA:
                calculadora.setResultado(calculadora.fnPotencia());
            JOptionPane.showMessageDialog(null, calculadora.fnPotencia());
            break;
        }
        //Obtenemos el resultado y lo almacenamos en r
        Double r = calculadora.getResultado();  
        //Asignamos el resultado de r a la pantalla 
        txtPantalla.setText(r.toString());
        //Devolvemos la enumeracion a su valor por defecto
        tipoOperacion = Operacion.NINGUNO;
    }

    @FXML
    private void eventoBotonSuma(ActionEvent event) {
        //Habilitamos el botón del punto
        btnPunto.setDisable(false);
        //Capturamos el valor de la pantalla
        calculadora.setNumeroUno(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Colocamos nuestra operación en SUMA
        tipoOperacion = Operacion.SUMA;
        
    }

    @FXML
    private void eventoBotonMenos(ActionEvent event) {
       //Habilitamos el botón del punto
        btnPunto.setDisable(false);
        //Capturamos el valor de la pantalla
        calculadora.setNumeroUno(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Colocamos nuestra operación en SUMA
        tipoOperacion = Operacion.RESTA;
    }

    @FXML
    private void eventoBotonLimpiar(ActionEvent event) {
        txtPantalla.setText("");
        btnPunto.setDisable(false);
    }
     @FXML
    private void eventoBotonDelete(ActionEvent event) {
        txtPantalla.setText(txtPantalla.getText().length() + (""));
    }

    @FXML
    private void eventoBotonPotencia(ActionEvent event) {
         //Habilitamos el botón del punto
        btnPunto.setDisable(false);
        //Capturamos el valor de la pantalla
        calculadora.setNumeroUno(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Colocamos nuestra operación en SUMA
        tipoOperacion = Operacion.POTENCIA;
    }

    @FXML
    private void eventoBotonDividir(ActionEvent event) {
        //Habilitamos el botón del punto
        btnPunto.setDisable(false);
        //Capturamos el valor de la pantalla
        calculadora.setNumeroUno(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Colocamos nuestra operación en SUMA
        tipoOperacion = Operacion.DIVISION;
    }

    @FXML
    private void eventoBotonMulti(ActionEvent event) {
         //Habilitamos el botón del punto
        btnPunto.setDisable(false);
        //Capturamos el valor de la pantalla
        calculadora.setNumeroUno(Double.parseDouble(txtPantalla.getText()));
        //limpiamos pantalla
        txtPantalla.setText("");
        //Colocamos nuestra operación en SUMA
        tipoOperacion = Operacion.MULTIPLICACION;
    }
    //Sobreescribiendo el método inicial de la vista
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtPantalla.setText("");
        
    }    
    
    
}
