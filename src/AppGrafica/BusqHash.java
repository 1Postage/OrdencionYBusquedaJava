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
public class BusqHash {
    public TipoElem Buscar(Lista[] tabla, TipoElem key)
        {
            int indice = key.Edad()/10 >= 10? 9 : key.Edad()/10;
            Nodo p = tabla[indice].Cab();
            while (p != null)
                if (p.Info().Edad() == key.Edad())
                    return p.Info();
                else
                    p = p.Sig();
            return new TipoElem("NO SE ENCONTRO");
        }
}
