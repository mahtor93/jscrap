/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jscrap;

/**
 *
 * @author Metatron
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jscrap {
    
    
    
	public static Document getHTML(String url){ //método para obtener el HTML de una página
            Document html = null; //Retorna un document. Instanciación del document
            try{
                html = Jsoup.connect(url).get(); //obtención de la estructura HTML
                
            }catch(Exception ex){
                System.out.println(ex + "Error al obtener el código HTML");
            }
            return html;
        }
        

        
        public List<String> scrapingList(String marca, int rango){
            List<String> arrayProductos = new ArrayList<>(); //Se crea la lista donde se almacenarán los productos
            
            int i = 1;
            do{
                String url = "https://www.aceiteraregional.cl/collection/bosque-y-jardin?order=price&way=ASC&limit=12&page="+i; //La url irá modificandose según el rango
                Elements secciones = Jscrap.getHTML(url).select("section.grid__item");
                for(Element articulo: secciones){
                    try{
                        arrayProductos.add(articulo.select("a").attr("title"));
                    }catch(Exception ex){
                        System.out.println("ERROR AL OBTENER TITULO");
                    }
                }
                i++;
            }while(i<=rango);
            return arrayProductos;
        }
        
        public static void main(String[] args){
            String marca="total";
            int rango = 7;
            List<String> result = new Jscrap().scrapingList(marca,38);
            //System.out.println(Jscrap.getHTML(urel));
            for(int i = 0; i<result.size();i++){
                System.out.println(result.get(i));
            }
            

        }
}