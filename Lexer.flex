package analizadorSintactico;

/* --------------------------Codigo de Usuario----------------------- */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java_cup.runtime.*;
import java.io.Reader;
      
%% //inicio de opciones
   
/* ------ Seccion de opciones y declaraciones de JFlex -------------- */  
   
/* 
    Cambiamos el nombre de la clase del analizador a Lexer
*/
%class AnalizadorLexico

/*
    Activar el contador de lineas, variable yyline
    Activar el contador de columna, variable yycolumn
*/
%line
%column




    
/* 
   Activamos la compatibilidad con Java CUP para analizadores
   sintacticos(parser)
*/
%cup
%eofval{
	return new Symbol(sym.EOF,new String("Fin del archivo"));
%eofval}

/*
    Declaraciones

    El codigo entre %{  y %} sera copiado integramente en el 
    analizador generado.
*/
%{
    /*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private void error()
    //throws IOException
    {
        //throw new IOException("Error léxico = "+yyline+", text = '"+yytext()+"'");                
        System.out.println((char)27 + "[31mError léxico. Linea: "+yyline+", text = '"+yytext()+"'");
    }


%}
   
/*
    ***Macro declaraciones***
    Declaramos expresiones regulares que despues usaremos en las reglas lexicas.
*/
   
espacio = \t | \f | " " | \r | \n


/*Definicion de los numeros*/
numerosEnteros = \d+ | [-]\d+ | [-]\d+[x]\d+ | \d+[x]\d+
numerosLong = \d+[L] | [-]\d+[L] | [-]\d+[x]\d+[L] | \d+\x2a\d+[L] | \d+[x]([aA-fF]*)[L] | \d+([aA-fF]*)[L]

numerosFlotantes = \d+[.] | [-]\d+[.] | \d+[.]\d+ | \d+[.]\d+[eE] | \d+[.]\d+[eE]\d+ | \d+[.]\d+[+-][eE] | \d+[.]\d+[+-][eE]\d+ |
                   [-]\d+[.]\d+ | [-]\d+[.]\d+[eE] | [-]\d+[.]\d+[eE]\d+ | [-]\d+[.]\d+[+-][eE] | [-]\d+[.]\d+[+-][eE]\d+
numerosComplejos = \d+[.][jJ] | [-]\d+[.][jJ] | \d+[.]\d+[jJ] | \d+[.]\d+[eE][jJ] | \d+[.]\d+[eE]\d+[jJ] | \d+[.]\d+[eE][+-]\d+[jJ] |                     
                   [-]\d+[.]\d+[jJ] | [-]\d+[.]\d+[eE][jJ] | \d+[.]\d+[eE][+-]\d+[jJ] | [-]\d+[.]\d+[+-][eE][jJ] |
                   [-]\d+[.]\d+[+-][eE]\d+[jJ] | [-][.]\d+[jJ] | [.]\d+[jJ] |[-][.]\d+[+-]\d+[jJ] | [.]\d+[+-]\d+[jJ] | 
                   [-][.]\d+[eE][jJ] | [.]\d+[eE][jJ] |[-][.]\d+[eE][+-]\d+[jJ] | [.]\d+[eE][+-]\d+[jJ] |
                   [-][.]\d+[+-][eE]\d+[jJ] | [.]\d+[+-][eE]\d+[jJ] | \d+[eE][+-]\d+[jJ]


white=[ \n]

/*Definición de errores en los identificadores*/
errorIdentificadores= \d+([aA-zZ]+|[_] )([aA-zZ]*|[0-9]|[_])*

/* Definicion de literales */
string = "'"[^']*"'" 

/* Definicion de los identificadores */
identificadores = ([aA-zZ]+|[_] )([aA-zZ]*|[0-9]|[_])*

/* Comentario de bloque */
comentarioBloque=("'''")[^']*("'''")


%% //fin de opciones

/* -------------------- Seccion de reglas lexicas ------------------ */ 

/*
   Esta seccion contiene expresiones regulares y acciones. 
   Las acciones son código en Java que se ejecutara cuando se
   encuentre una entrada valida para la expresion regular correspondiente */
   
   /* YYINITIAL es el estado inicial del analizador lexico al escanear.
      Las expresiones regulares solo serán comparadas si se encuentra
      en ese estado inicial. Es decir, cada vez que se encuentra una 
      coincidencia el scanner vuelve al estado inicial. Por lo cual se ignoran
      estados intermedios.*/
   
<YYINITIAL> {

/* Numeros */
{numerosEnteros}   {return new Symbol(sym.NUMERO_ENTERO, yychar, yyline, yytext());}
{numerosLong}      {return new Symbol(sym.NUMERO_LONG, yychar, yyline, yytext());}
{numerosFlotantes} {return new Symbol(sym.NUMERO_FLOTANTE, yychar, yyline, yytext());}
{numerosComplejos} {return new Symbol(sym.NUMERO_COMPLEJO, yychar, yyline, yytext());}

/*Error identificadores*/
{errorIdentificadores} {return new Symbol(sym.Error_Identificador, yychar, yyline, yytext());}

/* Palabras Reservadas */

"assert"	{return new Symbol(sym.PR_ASSERT, yychar, yyline, yytext());}
"break"		{return new Symbol(sym.PR_BREAK, yychar, yyline, yytext());}
"class"		{return new Symbol(sym.PR_CLASS, yychar, yyline, yytext());}
"continue"	{return new Symbol(sym.PR_CONTINUE, yychar, yyline, yytext());}
"def"		{return new Symbol(sym.PR_DEF, yychar, yyline, yytext());}
"del" 		{return new Symbol(sym.PR_DEL, yychar, yyline, yytext());}
"elif"		{return new Symbol(sym.PR_ELIF, yychar, yyline, yytext());}
"else"		{return new Symbol(sym.PR_ELSE, yychar, yyline, yytext());}
"except"	{return new Symbol(sym.PR_EXCEPT, yychar, yyline, yytext());}
"exec"		{return new Symbol(sym.PR_EXEC, yychar, yyline, yytext());}
"finally"	{return new Symbol(sym.PR_FINALLY, yychar, yyline, yytext());}
"for"		{return new Symbol(sym.PR_FOR, yychar, yyline, yytext());}
"from"		{return new Symbol(sym.PR_FROM, yychar, yyline, yytext());}
"global" 	{return new Symbol(sym.PR_GLOBAL, yychar, yyline, yytext());}
"if"		{return new Symbol(sym.PR_IF, yychar, yyline, yytext());}
"int"		{return new Symbol(sym.PR_INT, yychar, yyline, yytext());}
"input"		{return new Symbol(sym.PR_INPUT, yychar, yyline, yytext());}
"import"	{return new Symbol(sym.PR_IMPORT, yychar, yyline, yytext());}
"lambda"	{return new Symbol(sym.PR_LAMBDA, yychar, yyline, yytext());}
"pass"		{return new Symbol(sym.PR_PASS, yychar, yyline, yytext());}
"print"		{return new Symbol(sym.PR_PRINT, yychar, yyline, yytext());}
"raise" 	{return new Symbol(sym.PR_RAISE, yychar, yyline, yytext());}
"return"	{return new Symbol(sym.PR_RETURN, yychar, yyline, yytext());}
"try"		{return new Symbol(sym.PR_TRY, yychar, yyline, yytext());}
"while"		{return new Symbol(sym.PR_WHILE, yychar, yyline, yytext());}
"with"		{return new Symbol(sym.PR_WITH, yychar, yyline, yytext());}
"yield"		{return new Symbol(sym.PR_YIELD, yychar, yyline, yytext());}
"float"		{return new Symbol(sym.PR_FLOAT, yychar, yyline, yytext());}
"list"		{return new Symbol(sym.PR_LIST, yychar, yyline, yytext());}
"string"        {return new Symbol(sym.PR_STRING, yychar, yyline, yytext());}
"long"          {return new Symbol(sym.PR_LONG, yychar, yyline, yytext());}
"complex"       {return new Symbol(sym.PR_COMPLEX, yychar, yyline, yytext());}
"boolean"       {return new Symbol(sym.PR_BOOLEAN, yychar, yyline, yytext());}
"char"          {return new Symbol(sym.PR_CHAR, yychar, yyline, yytext());}
"range"         {return new Symbol(sym.PR_RANGE, yychar, yyline, yytext());}

/* Definicion de literal booleano */
"True" 		{return new Symbol(sym.BOOL_TRUE, yychar, yyline, yytext());}
"False"		{return new Symbol(sym.BOOL_FALSE, yychar, yyline, yytext());}

/* Operadores Aritmeticos */
"+"		{return new Symbol(sym.OP_SUMA, yychar, yyline, yytext());}
"-"		{return new Symbol(sym.OP_RESTA, yychar, yyline, yytext());}
"*"		{return new Symbol(sym.OP_MUL, yychar, yyline, yytext());}
"/"		{return new Symbol(sym.OP_DIV, yychar, yyline, yytext());}
"%"		{return new Symbol(sym.OP_MOD, yychar, yyline, yytext());}
"**"		{return new Symbol(sym.OP_POT, yychar, yyline, yytext());}
"//"		{return new Symbol(sym.OP_DIVENT, yychar, yyline, yytext());}

/* Operadores Comparativos */
"=="		{return new Symbol(sym.OP_CMPIGUAL, yychar, yyline, yytext());}
"!=" 		{return new Symbol(sym.OP_DIST, yychar, yyline, yytext());}
">"		{return new Symbol(sym.OP_MAYOR, yychar, yyline, yytext());}
"<"		{return new Symbol(sym.OP_MENOR, yychar, yyline, yytext());}
"<>"		{return new Symbol(sym.OP_DIF, yychar, yyline, yytext());}
">="		{return new Symbol(sym.OP_MAYORIG, yychar, yyline, yytext());}
"<="		{return new Symbol(sym.OP_MENORIG, yychar, yyline, yytext());}

/* OperadorAsignativo */
"="		{return new Symbol(sym.OP_IGUAL, yychar, yyline, yytext());}
"-="		{return new Symbol(sym.OP_ASG_RESTA, yychar, yyline, yytext());}
"+="		{return new Symbol(sym.OP_ASG_SUMA, yychar, yyline, yytext());}
"*="		{return new Symbol(sym.OP_ASG_MUL, yychar, yyline, yytext());} 
"/="		{return new Symbol(sym.OP_ASG_DIV, yychar, yyline, yytext());}
"%="		{return new Symbol(sym.OP_ASG_MOD, yychar, yyline, yytext());}
"**="		{return new Symbol(sym.OP_ASG_POT, yychar, yyline, yytext());}
"//="		{return new Symbol(sym.OP_ASG_DIVENT, yychar, yyline, yytext());}

/* Operadores de Bits */
"&"		{return new Symbol(sym.OPBITS_AND, yychar, yyline, yytext());}
"|"		{return new Symbol(sym.OPBITS_OR, yychar, yyline, yytext());}
"^"		{return new Symbol(sym.OPBITS_XOR, yychar, yyline, yytext());}
"~"		{return new Symbol(sym.OPBITS_NOT, yychar, yyline, yytext());}
"<<"		{return new Symbol(sym.OPBITS_DESPLAZ_IZQ, yychar, yyline, yytext());}
">>"		{return new Symbol(sym.OPBITS_DESPLAZ_DERECHA, yychar, yyline, yytext());}

/* Operadores Logicos */
"and"		{return new Symbol(sym.OP_AND, yychar, yyline, yytext());}
"or"		{return new Symbol(sym.OP_OR, yychar, yyline, yytext());}
"not"		{return new Symbol(sym.OP_NOT, yychar, yyline, yytext());}

/* Comparadores Identidad */
"is"		{return new Symbol(sym.COMP_IS, yychar, yyline, yytext());}
"in" 		{return new Symbol(sym.COMP_IN, yychar, yyline, yytext());}

/* Definicion de separadores */
","		{return new Symbol(sym.COMA, yychar, yyline, yytext());}
":"		{return new Symbol(sym.DOS_PUNTOS, yychar, yyline, yytext());}
";"		{return new Symbol(sym.PUNTO_COMA, yychar, yyline, yytext());}
"."		{return new Symbol(sym.PUNTO, yychar, yyline, yytext());}


//separadorTab="  " /* revisar */

/* Definicion de contenedores */
"{"		{return new Symbol(sym.CONT_LLAVE_ABRE, yychar, yyline, yytext());}
"}"		{return new Symbol(sym.CONT_LLAVE_CIERRA, yychar, yyline, yytext());}
"["		{return new Symbol(sym.CONT_CORCHETE_ABRE, yychar, yyline, yytext());}
"]"		{return new Symbol(sym.CONT_CORCHETE_CIERRA, yychar, yyline, yytext());}
"("		{return new Symbol(sym.CONT_PARENTESIS_ABRE, yychar, yyline, yytext());}
")"		{return new Symbol(sym.CONT_PARENTESIS_CIERRA, yychar, yyline, yytext());}

/* Definicion String */
{string} 	{return new Symbol(sym.STRING, yychar, yyline, yytext());}


/* Definicion de los identificadores */
{identificadores}	{return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}


/* Comentario de bloque */
{comentarioBloque} 	{return new Symbol(sym.COMENTARIO_BLOQUE, yychar, yyline, yytext());}



{espacio}	{}

"#".* {/*Ignore*/}

.  { error();}
//{ System.out.println("Caracter ilegal: "+yytext()+"Linea: "+yyline);}
}