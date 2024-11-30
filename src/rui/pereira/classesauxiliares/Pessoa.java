package rui.pereira.classesauxiliares;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public abstract class Pessoa extends Object{
    private Double CC;
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
/*
    @Deprecated protected Pessoa(@NonNull Editable cc, @NonNull Editable nif, @NonNull Editable nome, @NonNull Editable apelido, @NonNull Editable nascimento, @NonNull Editable sexo) {
        setCC(cc.toString() );
        setNIF(nif.toString() );
        setNome(nome.toString() );
        setApelido(apelido.toString() );
        setNascimento(nascimento.toString() );
        setSexo(sexo.toString() );
    }
    */

    @Deprecated protected Pessoa( ArrayList<String> lista)  {
        setCC( lista.get(0).toString() );
        setNIF( lista.get(1).toString() );
        setNome( lista.get(2).toString() );
        setApelido( lista.get(3).toString() );
        setNascimento( lista.get(4).toString() );
        setSexo( lista.get(5).toString() );
    }

    /**
     * setter
     *
     * @param cc
     */
    protected void setCC(String cc) {
        if( Cidadao.validarCC(cc) )
            this.CC = Double.parseDouble(cc);
    }

    protected void setNIF(String nif) throws NumberFormatException, ExceptionArgumento {
        if( Boolean.TRUE.equals(Contribuinte.validarNIF(nif) ) )
            this.NIF = Double.parseDouble(nif);
    }

    protected void setNome(String nome) {
        this.Nome = nome;
    }

    protected void setApelido(String apelido) {
        Apelido = apelido;
    }

    protected void setNascimento(String nascimento) {
        try {
                Nascimento = LocalDate.parse(nascimento);
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
            Idade = Period.between(Nascimento, LocalDate.now());
    }

    /**
     * getter
     *
     * @return
     */
    protected Double getCC() {
        return CC;
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
     * @return
     */
    protected Integer getIdade() {
        Integer i = 0;
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
    /*@NonNull
    @Deprecated public static Pessoa fromArrayList(@NonNull ArrayList<String> lista) throws Exception {
        return new Pessoa(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5)) ;
    }*/

    /**
     * Método toArrayList
     *
     * @return lista
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add( getCC().toString() );
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
