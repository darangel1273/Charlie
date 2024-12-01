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
                case '0': r = 0;break;
                case '1': r = 1;break;
                case '2': r = 2;break;
                case '3': r = 3;break;
                case '4': r = 4;break;
                case '5': r = 5;break;
                case '6': r = 6;break;
                case '7': r = 7;break;
                case '8': r = 8;break;
                case '9': r = 9;break;
                case 'A': r = 10;break;
                case 'B': r = 11;break;
                case 'C': r = 12;break;
                case 'D': r = 13;break;
                case 'E': r = 14;break;
                case 'F': r = 15;break;
                case 'G': r = 16;break;
                case 'H': r = 17;break;
                case 'I': r = 18;break;
                case 'J': r = 19;break;
                case 'K': r = 20;break;
                case 'L': r = 21;break;
                case 'M': r = 22;break;
                case 'N': r = 23;break;
                case 'O': r = 24;break;
                case 'P': r = 25;break;
                case 'Q': r = 26;break;
                case 'R': r = 27;break;
                case 'S': r = 28;break;
                case 'T': r = 29;break;
                case 'U': r = 30;break;
                case 'V': r = 31;break;
                case 'W': r = 32;break;
                case 'X': r = 33;break;
                case 'Y': r = 34;break;
                case 'Z': r = 35;break;
            }
        } catch ( ExceptionArgumento erro ) {
            erro.printStackTrace("Valor inválido no número de documento.");
            r = 99;
        } finally { return r; }
    }
}
