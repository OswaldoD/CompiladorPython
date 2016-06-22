/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico;

import java.util.ArrayList;

/**
 *
 * @author Phoenix
 */
public class FileManager {
    
    private ArrayList<String> segPila = new ArrayList<String>();
    private ArrayList<String> segDatos = new ArrayList<String>();
    private ArrayList<String> segProcedures = new ArrayList<String>();
    private ArrayList<String> segCodigo = new ArrayList<String>();

    
    public FileManager(){
        		this.segDatos.add("Datos Segment para 'Data'");
		this.segDatos.add("var1 db 7");
		this.segDatos.add("Datos EndS");
    }
    
    public void fileWritter(){
        
    }
    /*--------------------------- Segmento de Pila */
    private void startSegPila(){
        this.segPila.add("Pila Segment para Stack 'Stack'");
        this.segPila.add(" db 64 Dup ('SegStack ')");
        this.segPila.add("Pila EndS");
    }
    /* Segmento de Datos */
    public void agregaVariable(String identificador, String tipo_dato){
        if(tipo_dato.equals("") ){
            this.segDatos.add(identificador+ " db 7");
        } 
    }
    /* Segmento de Codigo */
    
    /*
    this.segmentoCodigo.add("Codigo Segment para public 'Code'");
		this.segmentoCodigo.add("Begin:");
		this.segmentoCodigo.add("Assume CS:Codigo, DS:Datos, SS:Pila ;Asignación de los segmentos a los registro de segmentos del CPU.");
		this.segmentoCodigo.add("xor    ax,ax       ;Pone en cero al reg ax.");
		this.segmentoCodigo.add("mov    ax,Datos    ;Mueve la posición de SData al reg ax.");
		this.segmentoCodigo.add("mov    DS,ax       ;Mueve la posición de ax (SData) al reg DS.");
		this.segmentoCodigo.add("mov    ES,ax       ;Mueve la posición de ax (SData) al reg ES.	");
		this.segmentoCodigo.add("; aqui va el codigo");
		this.segmentoCodigo.add("MiCodigo EndS 			;Fin del segmento de código.");
		this.segmentoCodigo.add("End Begin			;Fin del programa la etiqueta al final dice en que punto debe comenzar el programa.");
		
    */
    
}
