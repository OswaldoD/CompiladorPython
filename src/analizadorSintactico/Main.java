/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//estefanny
package analizadorSintactico;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java_cup.emit.parser;
import java_cup.parser;

/**
 * @author arturo
 */
public class Main {

    public final static int GENERAR = 1;
    public final static int EJECUTAR = 2;
    public final static int SALIR = 3;

    /**
     * Es un menu para elegir entre generar el analizador lexico y sintactico, o
     * ejecutarlos sobre un archivo de pruebas.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        java.util.Scanner in = new Scanner(System.in);
        int valor = 0;
        do {
            System.out.println("Elija una opcion: ");
            System.out.println("1) Generar Analizadores");
            System.out.println("2) Ejecutar Archivo");
            System.out.println("3) Salir");
            System.out.print("Opcion: ");
            valor = in.nextInt();
            switch (valor) {
                /*  Generamos el analizador lexico y sintactico.
                 lcalc.flex contiene la definicion del analizador lexico
                 ycalc.cup contiene la definicion del analizador sintactico
                 */
                case GENERAR: {
                    System.out.println("\n*** Generando los analizadores ***\n");
                    String archLexico = "";
                    String archSintactico = "";
                    if (args.length > 0) {
                        System.out.println("\n*** Procesando archivos custom ***\n");
                        archLexico = args[0];
                        archSintactico = args[1];
                    } else {
                        System.out.println("\n*** Procesando archivo default ***\n");
                        archLexico = "Lexer.flex";
                        archSintactico = "parser.cup";
                    }
                    String[] alexico = {archLexico};
                    String[] asintactico = {"-parser", "AnalizadorSintactico", archSintactico};
                    jflex.Main.main(alexico);                    
                    try {
                        java_cup.Main.main(asintactico);
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }                                            
                    //movemos los archivos generados
                    boolean mvAL = moverArch("AnalizadorLexico.java");
                    boolean mvAS = moverArch("AnalizadorSintactico.java");
                    boolean mvSym= moverArch("sym.java");
                    System.out.println("entré");
                    System.out.println("Generado!");
                    break;
                }
                case EJECUTAR: {
                    /*  Ejecutamos el analizador lexico y sintactico
                     sobre un archivo de pruebas. 
                     */
                    String[] archivoPrueba = {"entrada.txt"}; //archivo de funciones
                 //   String[] archivoPrueba = {"entradaclase.txt"}; //archivo de clases

                    AnalizadorSintactico.main(archivoPrueba);
                    //AnalizadorSintactico p;
                    //p = new AnalizadorSintactico((java_cup.runtime.Scanner) new AnalizadorSintactico((java_cup.runtime.Scanner) new java.io.FileInputStream("C://Users/esporras/Documents/NetBeansProjects/ProyectoCompi/src/archivosPrueba/for.txt")));
                    //p.parse();
                    System.out.println("Ejecutado!");
                    break;
                }
                case SALIR: {
                    System.out.println("Cerrando Programa!");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida!");
                    break;
                }
            }
        } while (valor != 3);

    }

    public static boolean moverArch(String archNombre) {
        boolean efectuado = false;
        File arch = new File(archNombre);
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "analizadorSintactico" + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + archNombre + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + archNombre + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo no existente ***\n");
        }
        return efectuado;
    }
}