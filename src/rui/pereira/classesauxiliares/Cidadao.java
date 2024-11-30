package rui.pereira.classesauxiliares;

import org.jetbrains.annotations.NotNull;

/**
 * @author Ruin Mantel Die Oliver Prier
 */
public interface Cidadao {
    /**
     * @param cc    Cartão de Cidadão
     * @return boolean
     */


    @org.jetbrains.annotations.NotNull
    static Boolean validarCC(@NotNull String cc) throws ExceptionArgumento {
        if ( cc.length() != 12 )
            throw new ExceptionArgumento("Tamanho inválido para número de documento.");
        int sum = 0;
        boolean secondDigit = false;
        for (int i = cc.length() - 1; i >= 0; --i) {
            int valor = GetNumberFromChar( cc.charAt( i ) );
            if ( secondDigit ) {
                valor *= 2;
                if (valor > 9)
                    valor -= 9;
            }
            sum += valor;
            secondDigit = !secondDigit;
        }
        return (sum % 10) == 0;
    }

    /**
     *
     * @param letter letra
     * @return numero   int
     */
    private static int GetNumberFromChar(char letter) {
        int r = -1;
        try {
            switch ( letter ) {
                case '0': r = 0;
                case '1': r = 1;
                case '2': r = 2;
                case '3': r = 3;
                case '4': r = 4;
                case '5': r = 5;
                case '6': r = 6;
                case '7': r = 7;
                case '8': r = 8;
                case '9': r = 9;
                case 'A': r = 10;
                case 'B': r = 11;
                case 'C': r = 12;
                case 'D': r = 13;
                case 'E': r = 14;
                case 'F': r = 15;
                case 'G': r = 16;
                case 'H': r = 17;
                case 'I': r = 18;
                case 'J': r = 19;
                case 'K': r = 20;
                case 'L': r = 21;
                case 'M': r = 22;
                case 'N': r = 23;
                case 'O': r = 24;
                case 'P': r = 25;
                case 'Q': r = 26;
                case 'R': r = 27;
                case 'S': r = 28;
                case 'T': r = 29;
                case 'U': r = 30;
                case 'V': r = 31;
                case 'W': r = 32;
                case 'X': r = 33;
                case 'Y': r = 34;
                case 'Z': r = 35;
            }
        } catch ( ExceptionArgumento erro ) {
            erro.printStackTrace("Valor inválido no número de documento.");
            r = 99;
        } finally { return r; }
    }
}
