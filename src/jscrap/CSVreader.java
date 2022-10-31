/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jscrap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
/**
 *
 * @author Metatron
 */
public class CSVreader {
    public static final String SEPARATOR=",";
    public static final String MARCA ="Total";
    
    
    public static List<String> obtenerCSV(String ubicacion){
     List<String> todosProductos = new ArrayList<>();
     BufferedReader br = null;
     String[] fields;
     
      try{
            br = new BufferedReader(new FileReader(ubicacion));
            String line = br.readLine();

            while(null!=line){
                fields = line.split(SEPARATOR);
                //System.out.println(Arrays.toString(fields));
                todosProductos.add(line); //añade los campos a una lista.
                line = br.readLine();
            }       
        }catch(Exception e){
            System.err.println("Error "+e.getMessage());
        }
        finally{
            if (null!=br){
                try{
                    br.close();
                }catch(IOException e){
                    System.err.println("Error al cerrar archivo "+e.getMessage());
                }
            }

     return todosProductos;
    
      }
    }
    
    
    public static void main(String[] args){
        List<String> todosProd = obtenerCSV("C:/Users/Metatron/Desktop/Aceitera Mundial _ Productos/verificacion_productos/_Subidos.csv");
        List<String> prodVisibles = obtenerCSV("C:/Users/Metatron/Desktop/Aceitera Mundial _ Productos/verificacion_productos/BosqueJardin_subidos.csv");
        //List<String> prodFiltrados = new ArrayList<>();
        int sizeVisibles = prodVisibles.size(); //447
        int sizeTodos = todosProd.size(); //893
        
        for(String Visible: prodVisibles){
            if(todosProd.contains(Visible)){
                todosProd.remove(Visible);
            }
        }
        
        
        
        for(String invisible: todosProd){ //Se borran los elementos 
            System.out.println(invisible);
        }
        }
    }
