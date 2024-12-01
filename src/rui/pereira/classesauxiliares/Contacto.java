package rui.pereira.classesauxiliares;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa um contacto.
 * Classe para usar directamente no ArrayList<? extends Contacto>
 *
 * @author Rui Pereira
 * @version 2.0
 * @since 1.0
 * @
 */
public class Contacto extends Pessoa {
    private List<Address> Morada;
    //private String Morada;
    private String Telefone;
    private String Email;
    private URL Perfil;


    /**
     * Default constructor
     *
     * @param morada
     * @param telefone
     * @param email
     */
    public Contacto(String cc, String nif, String nome, String apelido, String nascimento, String sexo,String morada, String telefone, String email) throws IOException {
        super(cc, nif, nome, apelido, nascimento, sexo);
        setMorada(morada);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Getter method for the Morada attribute.
     *
     * @return address.locality
     * address.adminArea
     * address.postalCode
     * address.countryName
     */
    public List<Address> getMorada() {
        return Morada;
    }

    /**
     * Morada to String method.
     * @author Ruin Mantel Die Oliver Prier
     * @return moradaString String
     * @see <a href="https://developer.android.com/reference/android/location/Address">Address</a>
     * @see <a href="https://developer.android.com/reference/android/location/Geocoder">Geocoder</a>
     */
    public String moradaToString() {
        //return Morada.get(0).getLocality() + ", " + Morada.get(0).getAdminArea() + ", " + Morada.get(0).getPostalCode() + ", " + Morada.get(0).getCountryName();
        // return String.format( Locale.getDefault() , " Locale:%s Locality:%s AdminArea:%s PostalCode:%s CountryName:%s ",
        //        this.Morada.get(0).getLocale(),this.Morada.get(0).getLocality(),this.Morada.get(0).getAdminArea(),
        //        this.Morada.get(0).getPostalCode() , this.Morada.get(0).getCountryName() ) ;
        StringBuilder s = new StringBuilder();
        for ( Address a : Morada ){ s.append(" , " ) ; s.append(a );  }
        return s.toString() ;
    }

    /**
     * Getter method for the Telefone attribute.
     * @return
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * Getter method for the Email attribute.
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Getter method for the Perfil attribute.
     * @return
     */
    public URL getPerfil() {
        return Perfil;
    }

    /**
     * Setter method for the Perfil attribute.
     * @param perfil
     */
    @Deprecated public void setPerfil( String perfil ) {
        URI uri = null;
        try {
            uri = new URI(perfil);
            this.Perfil = new URL(perfil);
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
        finally{
            System.out.println( uri.getScheme() + " " + uri.getAuthority() + " " + uri.getPath() + " " + uri.getQuery() + " " + uri.getFragment() );
        }
    }

    /**
     * Getter method for the Perfil attribute.
     *
     * @return perfil
     */

    /**
     * Setter method for the Morada attribute.
     *
     * @param morada address.locality
     *               address.adminArea
     *               address.postalCode
     *               address.countryName
     */
    public void setMorada(String morada) throws IOException {
//        Context context = new Application().getApplicationContext();
//        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
//        this.Morada = geocoder.getFromLocationName(morada, 10);
       this.Morada = new LinkedList<>() ;
       this.Morada.add( new Address( morada  ) );
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    /**
     * Setter method for the Email attribute.
     * @param email
     */
    public void setEmail(String email) {
        Email = email;
    }
    /**
     * @param lista
     * @return
     */

    @Deprecated public static @NotNull Contacto fromArrayList(ArrayList<String> lista) {
        try {
            return new Contacto(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), lista.get(6), lista.get(7), lista.get(8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * To ArrayList method.
     * @return
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> r = super.toArrayList();
        r.add( moradaToString() ); // Morada
        r.add( getTelefone() ); // Telefone
        r.add( getEmail() ); // Email
        return r;
    }
    /**
     * To String method.
     *
     * @return
     */

    @Override
    public String toString() {
        return super.toString() + " Contacto{" + "Morada=" + Morada + ", Telefone='" + Telefone + ", Email='" + Email + '}';
    }
    /**
     * Equals method.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if (! ( o instanceof Contacto ) ) return false;
        if ( !super.equals( o )) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(getMorada(), contacto.getMorada()) && Objects.equals(getTelefone(), contacto.getTelefone()) && Objects.equals(getEmail(), contacto.getEmail());
    }
    /**
     * HashCode method.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMorada(), getTelefone(), getEmail());
    }
    /**
     * Método toXML
     * @return
     */
    public String toXML(){
        return super.toXML() + this.toXML();
    }
    /**
     *
     * Método toJSON
     * @return
     */
    public String toJSON() {
        return super.toJSON() + this.toJSON();
    }
}