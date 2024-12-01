package rui.pereira.classesauxiliares;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Pessoa {
    private String CC;
    private Long BI;
    private Double NIF;
    private String Nome;
    private String Apelido;
    private LocalDate Nascimento;
    private char Sexo;
    private Period Idade;

    /**
     * Construtor padrão
     *
     * @param cc         String
     * @param nif        String
     * @param nome       String
     * @param apelido    String
     * @param nascimento String
     */
    protected Pessoa(String cc, String nif, String nome, String apelido, String nascimento, String sexo) {
        setCC( cc );
        setNIF( nif );
        setNome( nome );
        setApelido( apelido );
        setNascimento( nascimento );
        setSexo( sexo );
    }

    @Deprecated protected Pessoa(TextField cc, TextField nif, TextField nome, TextField apelido, TextField nascimento, TextField sexo) {
        setCC(cc.getText() );
        setNIF(nif.getText() );
        setNome(nome.getText() );
        setApelido(apelido.getText() );
        setNascimento(nascimento.getText() );
        setSexo(sexo.getText() );
    }


    @Deprecated protected Pessoa( ArrayList<String> lista)  {
        setCC( lista.get(0) );
        setNIF( lista.get(1) );
        setNome( lista.get(2) );
        setApelido( lista.get(3) );
        setNascimento( lista.get(4) );
        setSexo( lista.get(5) );
    }
    /**
     * setter
     *
     * @param   cc    Cartão de Cidadão
     */
    protected void setCC(String cc) {
        if (Cidadao.validarCC(cc))
            this.BI = Long.parseLong( cc.substring(0, 7) );
        this.CC = cc;
    }
    protected void setNIF( String nif ) throws NumberFormatException, ExceptionArgumento {
        if( Contribuinte.validarNIF( nif ) )
            this.NIF = Double.parseDouble( nif );
    }

    protected void setNome( String nome ) {
        this.Nome = nome;
    }

    protected void setApelido( String apelido ) {
        Apelido = apelido;
    }

    protected void setNascimento( String nascimento ) {
        try {
                Nascimento = LocalDate.parse( nascimento );
        } catch (Exception erro) {
            erro.printStackTrace();
                Nascimento = LocalDate.now();
        }
        finally{
            setIdade();
        }
    }
    protected void setSexo( String sexo) {
        this.Sexo = sexo.charAt(0);
    }
    private void setIdade() {
            Idade = Period.between( this.Nascimento, LocalDate.now());
    }
    /**
     * getter
     *
     * @return  CC  Cartão de Cidadão
     */
    protected String getCC() {
        return CC;
    }
    protected long getBI() {
        return BI;
    }
    protected Double getNIF() {
        return NIF;
    }
    protected String getNome() {
        return Nome;
    }
    protected String getApelido() {
        return Apelido;
    }
    protected LocalDate getNascimento() {
        return Nascimento;
    }
    protected String getSexo() {
        return String.format(Locale.getDefault(), "%c", Sexo);
    }
    /**
     * Método getIdade
     *
     * @return  Idade   Idade
     */
    protected Integer getIdade() {
        int i = 0;
        try {
            i = Idade.getYears();

        } catch (Exception erro) {
            erro.printStackTrace();
            i = -1;
        } finally {
            return i;
        }
    }

    /**
     * Método toArrayList
     *
     * @param lista
     * @return Pessoa
     * @throws IOException
     * @deprecated
     */
    @Deprecated public static Pessoa fromArrayList(@NotNull ArrayList<String> lista) {
        return new Pessoa(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5)) ;
    }

    /**
     * Método toArrayList
     *
     * @return lista
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add( String.valueOf(getCC() ) );
        lista.add( getNIF().toString() );
        lista.add( getNome() );
        lista.add( getApelido() );
        lista.add( getNascimento().toString() );
        lista.add( getIdade().toString() );
        lista.add( getSexo() );
        return lista;
    }

    /**
     * Método equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o; //Cast
        return Objects.equals(getSexo(), pessoa.getSexo()) && Objects.equals(getCC(), pessoa.getCC()) && Objects.equals(getNIF(), pessoa.getNIF()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getApelido(), pessoa.getApelido()) && Objects.equals(getNascimento(), pessoa.getNascimento()) && Objects.equals(getIdade(), pessoa.getIdade()) && Objects.equals(getSexo(), pessoa.getSexo());
    }

    /**
     * Método hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCC(), getNIF(), getNome(), getApelido(), getNascimento(), getSexo(), getIdade());
    }

    /**
     * Método toString
     *
     * @return
     */

    @Override
    public String toString() {
        //return "Pessoa{" + "CC=" + getCC() + ", NIF=" + getNIF() + ", Nome='" + getNome() + ", Apelido='" + getApelido() + ", Nascimento=" + getNascimento() + ", Sexo=" + getSexo() + ", Idade=" + getIdade() + '}';
        return String.format(Locale.getDefault(), "CC=%s NIF=%s Nome=%s Apelido=%s Nascimento=%s Sexo=%s Idade=%d", getCC(), getNIF(), getNome(), getApelido(), getNascimento(), getSexo(), getIdade());
        //return new StringBuilder().append(getCC()).append(" ").append(getNIF()).append(" ").append(getNome()).append(" ").append(getApelido()).append(" ").append(getNascimento()).append(" ").append(getSexo()).append(" ").append(getIdade()).toString() ;
    }

    /**
     * Método toXML
     *
     * @return
     */
    public String toXML() {
        return this.toXML();
    }

    /**
     * Método toJSON
     *
     * @return
     */
    public String toJSON() {
        return this.toJSON();
    }

}
