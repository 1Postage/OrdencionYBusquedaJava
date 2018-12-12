/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGrafica;

/**
 *
 * @author friosa
 */
public class TipoElem {
    private char _sexo;
    private String _nombre;
    private int _edad;
    
    public TipoElem(String result){
        _nombre = result;
    }
    
    public TipoElem(String nom, int edad, char sexo) {
        _nombre = nom;
        _edad = edad;
        _sexo = sexo;
    }
    public char Sexo() {
        return _sexo;
    }
    public String Nombre() {
        return _nombre;
    }
    public int Edad() {
        return _edad;
    }
    
    public String toString(){
        return _nombre +", " + _edad + ", "+ _sexo;
    }
}
