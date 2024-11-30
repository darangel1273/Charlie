package rui.pereira.classesauxiliares;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringTokenizer;

public class Address {
    private String Locality;
    private String AdminArea;
    private String PostalCode;
    private String CountryName;

    public static @NotNull Address from(String morada, String delimitador ) throws ExceptionArgumento{
        Address endereco = new Address("0", "0", "0", "0");
        try {
            // Com o Tokenizer
            StringTokenizer token = new StringTokenizer(morada, delimitador);
            if (token.countTokens() != 3) {throw new ExceptionArgumento("\n Morada não tem 3 args!!: Tem " + token.countTokens());}
            endereco.setLocality( token.nextToken(delimitador ) );
            endereco.setAdminArea( token.nextToken(delimitador ) );
            endereco.setPostalCode( token.nextToken(delimitador ) );
            endereco.setCountryName( token.nextToken(delimitador ) );
        }
        catch (ExceptionArgumento e) {
            throw new RuntimeException(e);
        }
        finally {
            return endereco;
        }
    }
    public Address(String morada){
        // Com o split
        String[] moradaS = morada.split(",");
        if ( moradaS.length != 4 ) {
            throw new ExceptionArgumento("\n Morada não tem 3 args!!: Tem " + moradaS.length);
        }
        setLocality( moradaS[0] );
        setAdminArea( moradaS[1] );
        setPostalCode( moradaS[2] );
        setCountryName( moradaS[3] );
    }
    public Address(String locality, String adminArea, String postalCode, String countryName) {
        setLocality ( locality) ;
        setAdminArea ( adminArea) ;
        setPostalCode ( postalCode) ;
        setCountryName ( countryName) ;
    }
    public void setLocality(String locality) {
        Locality = locality;
    }
    public void setAdminArea(String adminArea) {
        AdminArea = adminArea;
    }
    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }
    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
    public String getLocality() {
        return Locality;
    }
    public String getAdminArea() {
        return AdminArea;
    }
    public String getPostalCode() {
        return PostalCode;
    }
    public String getCountryName() {
        return CountryName;
    }
    @Override
    public String toString() {
        return "Address{"+"Locality='" + getLocality() +", AdminArea='" + getAdminArea() +", PostalCode='" + getPostalCode() +", CountryName='" + getCountryName() +'}';
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getLocality(), address.getLocality()) && Objects.equals(getAdminArea(), address.getAdminArea()) && Objects.equals(getPostalCode(), address.getPostalCode()) && Objects.equals(getCountryName(), address.getCountryName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getLocality(), getAdminArea(), getPostalCode(), getCountryName());
    }
    /**
     * Constructs a new object.
     */
    public Address() {
        super();
    }
}
