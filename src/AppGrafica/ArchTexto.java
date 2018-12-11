/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGrafica;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author josea
 */
public class ArchTexto {

    public static void Crear(String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {

        } catch (IOException e) {

        }
    }
    
    public static void Escribir(String nombreArchivo, String data){
        try (FileWriter fw = new FileWriter(nombreArchivo)){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
                
        }catch(IOException e){
            System.out.println("ERROR ESCRIBIR: " + e.getMessage());
        }catch(NullPointerException e){
            System.out.println("ERROR ESCRIBIR: " + e.getMessage());
        }
            
    }

    
    public static String Leer(String nombreArchivo) {
        String resultado = "";
        try (InputStream mInputStream = OrdenacionBusquedaApp.class.getResourceAsStream(nombreArchivo)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(mInputStream));
            String linea;
            while ( (linea = br.readLine()) != null){
                resultado += linea + "\n";
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return "";
        }
        return resultado;
    }
    
    public static ArrayList<String> LeerToArrayList(String nombreArchivo){
        ArrayList<String> arr = new ArrayList<>();
        for( String s : ArchTexto.Leer(nombreArchivo).split("\n"))
            arr.add(s);
        return arr;
    }
    
}
