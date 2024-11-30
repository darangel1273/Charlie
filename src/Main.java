import rui.pereira.classesauxiliares.Contacto;
import rui.pereira.classesauxiliares.ExceptionArgumento;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Contacto> contactoS = new LinkedList<>() ;
        if ( args.length != 9 )
            throw new ExceptionArgumento("Argumentos errados na linha de comando" + args.length );
        contactoS.add( new Contacto( args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8] ) ) ;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        for( Contacto c :contactoS ) {
            System.out.printf( Locale.getDefault(), "\n %s ", c.toString() ) ;
        }

    }
}