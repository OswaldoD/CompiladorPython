
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Jun 07 01:10:27 CST 2016
//----------------------------------------------------

package analizadorSintactico;

import java.io.*;
import java_cup.runtime.*;
import java_cup.runtime.*;
import java.io.FileReader;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Jun 07 01:10:27 CST 2016
  */
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\004\000\002\002" +
    "\006\000\002\003\014\000\002\003\002\000\002\011\004" +
    "\000\002\012\004\000\002\012\002\000\002\004\006\000" +
    "\002\004\006\000\002\004\006\000\002\004\006\000\002" +
    "\004\006\000\002\004\006\000\002\004\002\000\002\005" +
    "\005\000\002\005\002\000\002\014\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\024\002\ufffd\004\004\017\005\032\ufffd\037" +
    "\ufffd\040\ufffd\041\ufffd\042\ufffd\043\ufffd\001\002\000\004" +
    "\061\050\001\002\000\004\061\045\001\002\000\020\002" +
    "\ufff3\032\013\037\016\040\011\041\014\042\012\043\017" +
    "\001\002\000\004\002\010\001\002\000\004\002\000\001" +
    "\002\000\004\061\042\001\002\000\004\061\037\001\002" +
    "\000\004\061\034\001\002\000\004\061\031\001\002\000" +
    "\004\002\001\001\002\000\004\061\026\001\002\000\004" +
    "\061\020\001\002\000\024\002\ufff1\032\ufff1\037\ufff1\040" +
    "\ufff1\041\ufff1\042\ufff1\043\ufff1\056\022\060\ufff1\001\002" +
    "\000\022\002\ufff3\032\013\037\016\040\011\041\014\042" +
    "\012\043\017\060\ufff3\001\002\000\004\061\023\001\002" +
    "\000\024\002\ufff1\032\ufff1\037\ufff1\040\ufff1\041\ufff1\042" +
    "\ufff1\043\ufff1\056\022\060\ufff1\001\002\000\022\002\ufff2" +
    "\032\ufff2\037\ufff2\040\ufff2\041\ufff2\042\ufff2\043\ufff2\060" +
    "\ufff2\001\002\000\006\002\ufff4\060\ufff4\001\002\000\024" +
    "\002\ufff1\032\ufff1\037\ufff1\040\ufff1\041\ufff1\042\ufff1\043" +
    "\ufff1\056\022\060\ufff1\001\002\000\022\002\ufff3\032\013" +
    "\037\016\040\011\041\014\042\012\043\017\060\ufff3\001" +
    "\002\000\006\002\ufff8\060\ufff8\001\002\000\024\002\ufff1" +
    "\032\ufff1\037\ufff1\040\ufff1\041\ufff1\042\ufff1\043\ufff1\056" +
    "\022\060\ufff1\001\002\000\022\002\ufff3\032\013\037\016" +
    "\040\011\041\014\042\012\043\017\060\ufff3\001\002\000" +
    "\006\002\ufff6\060\ufff6\001\002\000\024\002\ufff1\032\ufff1" +
    "\037\ufff1\040\ufff1\041\ufff1\042\ufff1\043\ufff1\056\022\060" +
    "\ufff1\001\002\000\022\002\ufff3\032\013\037\016\040\011" +
    "\041\014\042\012\043\017\060\ufff3\001\002\000\006\002" +
    "\ufff9\060\ufff9\001\002\000\024\002\ufff1\032\ufff1\037\ufff1" +
    "\040\ufff1\041\ufff1\042\ufff1\043\ufff1\056\022\060\ufff1\001" +
    "\002\000\022\002\ufff3\032\013\037\016\040\011\041\014" +
    "\042\012\043\017\060\ufff3\001\002\000\006\002\ufff5\060" +
    "\ufff5\001\002\000\024\002\ufff1\032\ufff1\037\ufff1\040\ufff1" +
    "\041\ufff1\042\ufff1\043\ufff1\056\022\060\ufff1\001\002\000" +
    "\022\002\ufff3\032\013\037\016\040\011\041\014\042\012" +
    "\043\017\060\ufff3\001\002\000\006\002\ufff7\060\ufff7\001" +
    "\002\000\004\057\046\001\002\000\020\002\ufff3\032\013" +
    "\037\016\040\011\041\014\042\012\043\017\001\002\000" +
    "\004\002\uffff\001\002\000\004\050\051\001\002\000\004" +
    "\061\052\001\002\000\006\051\ufffa\056\063\001\002\000" +
    "\004\051\054\001\002\000\004\057\055\001\002\000\020" +
    "\032\013\037\016\040\011\041\014\042\012\043\017\060" +
    "\ufff3\001\002\000\004\060\ufff0\001\002\000\004\060\060" +
    "\001\002\000\022\002\ufffd\004\004\032\ufffd\037\ufffd\040" +
    "\ufffd\041\ufffd\042\ufffd\043\ufffd\001\002\000\020\002\ufffe" +
    "\032\ufffe\037\ufffe\040\ufffe\041\ufffe\042\ufffe\043\ufffe\001" +
    "\002\000\004\051\ufffc\001\002\000\004\061\052\001\002" +
    "\000\004\051\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\006\002\006\003\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\014\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\005\020\001" +
    "\001\000\004\004\024\001\001\000\002\001\001\000\004" +
    "\005\023\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\005\026\001\001\000\004\004\027\001\001\000\002" +
    "\001\001\000\004\005\031\001\001\000\004\004\032\001" +
    "\001\000\002\001\001\000\004\005\034\001\001\000\004" +
    "\004\035\001\001\000\002\001\001\000\004\005\037\001" +
    "\001\000\004\004\040\001\001\000\002\001\001\000\004" +
    "\005\042\001\001\000\004\004\043\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\046\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\011\052\001\001\000" +
    "\004\012\061\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\004\055\001\001\000\004\014\056\001\001\000" +
    "\002\001\001\000\004\003\060\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\011\063\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static void main(String[] args){
        try {
            Symbol asin = new AnalizadorSintactico(
                    new AnalizadorLexico( new FileReader(args[0]))).parse();
            //Object result = asin.parse().value;
            System.out.println("\n*** Resultados finales ***");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  

    public void syntax_error(Symbol s){
	report_error("Error de sintaxis. Linea: " + (s.right + 1) +
	" Columna: " + s.left + ". Texto: \"" + s.value + "\"", null);
    }  

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintactico$actions {
  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // BLOQUE_FUNCION ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("BLOQUE_FUNCION",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // MAS_VARIABLES ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("MAS_VARIABLES",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // MAS_VARIABLES ::= SEPARADOR_COMA IDENTIFICADOR MAS_VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("MAS_VARIABLES",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // VARIABLES ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // VARIABLES ::= PR_CHAR IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // VARIABLES ::= PR_BOOLEAN IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // VARIABLES ::= PR_STRING IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // VARIABLES ::= PR_LIST IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // VARIABLES ::= PR_FLOAT IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // VARIABLES ::= PR_INT IDENTIFICADOR MAS_VARIABLES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("VARIABLES",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // MAS_PARAMETROS ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("MAS_PARAMETROS",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // MAS_PARAMETROS ::= SEPARADOR_COMA PARAMETROS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("MAS_PARAMETROS",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // PARAMETROS ::= IDENTIFICADOR MAS_PARAMETROS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("PARAMETROS",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // FUNCIONES ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("FUNCIONES",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // FUNCIONES ::= PR_DEF IDENTIFICADOR CONT_PARENTESIS_ABRE PARAMETROS CONT_PARENTESIS_CIERRA SEPARADOR_DOS_PUNTOS VARIABLES BLOQUE_FUNCION PUNTO_COMA FUNCIONES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("FUNCIONES",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-9)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // START ::= PR_CLASS IDENTIFICADOR SEPARADOR_DOS_PUNTOS VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= START EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // START ::= FUNCIONES VARIABLES 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

