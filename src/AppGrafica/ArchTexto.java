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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static void Escribir(String nombreArchivo, ArrayList<TipoElem> x) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            PrintWriter pw = new PrintWriter(fw);

            for (TipoElem e : x) {
                pw.println(e.toString());
            }
            pw.close();

        } catch (IOException e) {
            System.out.println("ERROR ESCRIBIR: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("ERROR ESCRIBIR: " + e.getMessage());
        }

    }

    public static void EscribirBin(String nombreArchivo, ArrayList<TipoElem> x) {
        try (FileOutputStream fout = new FileOutputStream(nombreArchivo);
                DataOutputStream dout = new DataOutputStream(fout)) {

            for (TipoElem e : x) {
                dout.writeUTF(e.Nombre());
                dout.writeInt(e.Edad());
                dout.writeChar((int) e.Sexo());
            }
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    public static String LeerBin(String nombreArchiv) {
        String lines = null;
        try (FileInputStream fin = new FileInputStream(nombreArchiv)) {
            DataInputStream din;
            din = new DataInputStream(fin);

            for (int i = 0; i < 500000; i++) {
                lines += din.readUTF() + din.readInt() + din.readChar() + "\n";
            }
        } catch (Exception e) {

        }
        return lines;
    }

    public static String LeerS(String nombreArchivo) {
        String resultado = "";
        try (FileReader fr = new FileReader(nombreArchivo)) {
            String linea = "";
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                sb.append(linea + "\n");
            }
            
            resultado = sb.toString();
            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return "";
        }
        return resultado;
    }

    public static ArrayList<String> LeerToArrayList(String nombreArchivo) {
        ArrayList<String> arr = new ArrayList<>();
        try (InputStream mInputStream = OrdenacionBusquedaApp.class.getResourceAsStream(nombreArchivo)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(mInputStream));
            String linea;
            while ((linea = br.readLine()) != null) {
                arr.add(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return arr;
        }
        return arr;
    }

}
