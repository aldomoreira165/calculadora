
package org.aldomoreira.calculadora;

public class CalculadoraModel {
    private double numeroUno;  
    private double numeroDos;
    private double resultado;
    //PASO 1 SINGLETON
    private static CalculadoraModel calculadora;
    
    //PASO 2 SINGLETON 
    private CalculadoraModel() {
    }
    
    //PASO 3 SINGLETON
    public static CalculadoraModel getInstance(){
        if(calculadora == null){
            calculadora = new CalculadoraModel();
        }
                return calculadora;
    }
    
    //Programando la funcion suma
    public double fnSuma(){
        return numeroUno + numeroDos;
    }
    //Programando la funcion resta
    public double fnResta(){
        return numeroUno - numeroDos;
    }
    //Programando la funcion multiplicación
    public double fnMultiplicacion(){
        return numeroUno * numeroDos;
    }
    //Programando la funcion division
    public double fnDivision(){
        return numeroUno / numeroDos;
    }
    //Programando la funcion Potencia
    public double fnPotencia(){
        return Math.pow(numeroUno, numeroDos);
    }
    //GETTERS Y SETTERS
    public double getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(double numeroUno) {
        this.numeroUno = numeroUno;
    }

    public double getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(double numeroDos) {
        this.numeroDos = numeroDos;
    }    

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    
}
 