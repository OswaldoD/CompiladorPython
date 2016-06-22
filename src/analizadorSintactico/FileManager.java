/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico;

import java.io.FileWriter;
import java.io.PrintWriter;
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
    private int contador_etiqueta;
    private String rutaArchivo;

    public FileManager() {
        this.rutaArchivo = System.getProperty("user.home");
        this.rutaArchivo += "\\file.asm";
        this.contador_etiqueta = 0;
        this.segPila.add("; *********************************************** ;");
        this.segPila.add("; * Instituto Tecnológico de Costa Rica ;");
        this.segPila.add("; * Compiladores e Intérpretes ;");
        this.segPila.add("; * Proyecto: Análisis Semántico ;");
        this.segPila.add("; * Código .asm 8086 ;");
        this.segPila.add("; * Compilable en TASM ;");
        this.segPila.add("; *********************************************** ;");    
        
        startSegPila();
        startSegDatos();
        startSegProcedures();
        startSegCodigo();
    }
    public String getEtiqueta(){
        return "label_"+this.contador_etiqueta;
    }
    public void incCont(){
        this.contador_etiqueta++;
    }
/*-------------------------------------------------------------------------------*/
/*--------------------------------- Segmento de Pila ---------------------------*/
    public void startSegPila() {
        this.segPila.add("Pila Segment para Stack 'Stack'");
        this.segPila.add(" db 64 Dup ('SegStack ')");
        this.segPila.add("Pila EndS");
    }
 /*-------------------------------------------------------------------------------*/
 /*-------------------------------- Segmento de Datos ----------------------------*/
    public void startSegDatos() {
        this.segDatos.add("Datos Segment para 'Data'");
    }

    public void endSegDatos() {
        this.segDatos.add("Datos EndS");
    }

    public void agregaVariable(String identificador, String tipo_dato) {
        if (tipo_dato.equals("")) {
            this.segDatos.add(identificador + " db 7");
        }
    }
/*-------------------------------------------------------------------------------*/
/*------------------------------- Segmento de Codigo ----------------------------*/
    public void startSegProcedures() {
        this.segProcedures.add("Codigo Segment para public 'Code'");
    }
    public void generaEncabezadoFuncion(String identificador) {
        this.segProcedures.add(identificador + " Proc");
    }

    public void terminaEncabezadoFuncion(int parametros) {
        this.segProcedures.add("ret " + "2 x " + parametros);
        this.segProcedures.add("endp");
    }

    public void startSegCodigo() {
        this.segCodigo.add("Begin:");
        this.segCodigo.add("Assume CS:Codigo, DS:Datos, SS:Pila ;Asignación de los segmentos a los registro de segmentos del CPU.");
        this.segCodigo.add("xor    ax,ax       ;Pone en cero al reg ax.");
        this.segCodigo.add("mov    ax,Datos    ;Mueve la posición de SData al reg ax.");
        this.segCodigo.add("mov    DS,ax       ;Mueve la posición de ax (SData) al reg DS.");
        this.segCodigo.add("mov    ES,ax       ;Mueve la posición de ax (SData) al reg ES.	");
    }

    public void terminaSegCodigo() {
        this.segCodigo.add("MiCodigo EndS 	;Fin del segmento de código.");
        this.segCodigo.add("End Begin		;Fin del programa la etiqueta al final dice en que punto debe comenzar el programa.");
    }

    /**
     * this.segCodigo.add("; aqui va el codigo");
     *
     */
    public void almacenaIF(String datos) {
        /**
         * etiqueta: el codigo de comparacion no es escrito por esta parte jnz
         * etiqueta_else jmp etiqueta_salida etiqueta_salida:
         *
         * Tambien puede almacenar cualquier objeto
         */
        //System.out.println("ALMACENAR --> " + datos);
        this.segCodigo.add(datos);
    }

 /*------------------------------------------------------------------------------------*/
 /*------------------------------- Escritura de datos ---------------------------------*/
    public void printer(){
        
            for (int i = 0; i < this.segPila.size(); i++) {
                System.out.println(this.segPila.get(i));
            }

            for (int i = 0; i < this.segDatos.size(); i++) {
                System.out.println(this.segDatos.get(i));
            }

            for (int i = 0; i < this.segProcedures.size(); i++) {
                System.out.println(this.segProcedures.get(i));
            }

            for (int i = 0; i < this.segCodigo.size(); i++) {
                System.out.println(this.segCodigo.get(i));
            }
        
    }
    public boolean fileWritter() {
        try {
            FileWriter archivo = new FileWriter(this.rutaArchivo, true);
            PrintWriter archivo_escribir = new PrintWriter(archivo);

            for (int i = 0; i < this.segPila.size(); i++) {
                archivo_escribir.println(this.segPila.get(i));
            }

            for (int i = 0; i < this.segDatos.size(); i++) {
                archivo_escribir.println(this.segDatos.get(i));
            }

            for (int i = 0; i < this.segProcedures.size(); i++) {
                archivo_escribir.println(this.segProcedures.get(i));
            }

            for (int i = 0; i < this.segCodigo.size(); i++) {
                archivo_escribir.println(this.segCodigo.get(i));
            }

            archivo_escribir.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
