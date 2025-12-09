/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedio = new byte[1000]; /*De buffer a intermedio*/
    private static String nombreArchivo = "fichero.dat"; /*De fileName a nombreArchivo*/
    private static FileInputStream flujoEntreda = null; /*De inputStream a flujoEntrada*/
    private static BufferedInputStream flujoIntermedio = null; /*De inputBuffered a flujoIntermedio*/

    public static void inicializateFiles() throws FileNotFoundException
    {
        flujoEntreda = new FileInputStream(nombreArchivo);
        flujoIntermedio = new BufferedInputStream(flujoEntreda); /*Esta funcion recoje el documento para almacenarlo en el programa*/
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = flujoEntreda.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio)); /*Aqui se cuentan los bytes del documento*/
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles(); /*Muestra el archivo*/ 
            
            int total = showFileText(); /*Llama a la funcion de contar bytes*/         

            System.out.println("\nLeídos " + total + " bytes"); /*Imprime los bytes*/
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( flujoIntermedio != null && flujoEntreda != null )
                {
                    flujoEntreda.close();
                    flujoIntermedio.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString()); /*Esto nos da el error de que no se a encontrado el archivo*/
            }
        }
    }
    
}
