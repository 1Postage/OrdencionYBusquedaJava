/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGrafica;

import sun.security.util.Length;

/**
 *
 * @author friosa
 */
public class BusqHash {
    public TipoElem Buscar(Lista[] tabla, TipoElem key)
        {
            int len = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length();
            int indice = key.Edad()/len >= len? len : key.Edad()/len;
            Nodo p = tabla[indice].Cab();
            while (p != null)
                if (p.Info().Nombre().equals(key.Nombre()))
                    return p.Info();
                else
                    p = p.Sig();
            return new TipoElem("NO SE ENCONTRO");
        }
}
