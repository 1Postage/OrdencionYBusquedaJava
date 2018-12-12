package AppGrafica;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author friosa
 */
public class Hashing implements IOrdenacion {
    Lista[] tablaHash;
    
     public Lista[] Tabla() {
        return tablaHash;
    }

    public void Ordenar(ArrayList<TipoElem> x, int lb, int ub) {
        int len = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length();
        tablaHash = new Lista[len];
        
        
        for (int i = 0; i < tablaHash.length; i++)
            tablaHash[i] = new Lista();
        for (int i = 0; i < ub + 1; i++) {
            
            char primLetra = (char) ((int) x.get(i).Nombre().toUpperCase().charAt(0) - 65);
            
            
            int indice = primLetra/len >= len? len : primLetra/len;
            tablaHash[indice].InsOrden(x.get(i));
        }
        int j=0;
        for (int i = 0; i < tablaHash.length; i++) {
            Nodo p = tablaHash[i].Cab();
            while (p != null) {
                x.set(j++,p.Info());
                p = p.Sig();
            }
        }
    }
}
