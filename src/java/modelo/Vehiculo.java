/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgasd
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIde", query = "SELECT v FROM Vehiculo v WHERE v.ide = :ide")
    , @NamedQuery(name = "Vehiculo.findByA\u00f1o", query = "SELECT v FROM Vehiculo v WHERE v.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Vehiculo.findByNunpasajeros", query = "SELECT v FROM Vehiculo v WHERE v.nunpasajeros = :nunpasajeros")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByCilindrage", query = "SELECT v FROM Vehiculo v WHERE v.cilindrage = :cilindrage")
    , @NamedQuery(name = "Vehiculo.findByPaisfabrica", query = "SELECT v FROM Vehiculo v WHERE v.paisfabrica = :paisfabrica")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculo.findByConsecionario", query = "SELECT v FROM Vehiculo v WHERE v.consecionario = :consecionario")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ide")
    private String ide;
    @Size(max = 4)
    @Column(name = "a\u00f1o")
    private String año;
    @Size(max = 10)
    @Column(name = "nunpasajeros")
    private String nunpasajeros;
    @Size(max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 50)
    @Column(name = "marca")
    private String marca;
    @Size(max = 10)
    @Column(name = "cilindrage")
    private String cilindrage;
    @Size(max = 50)
    @Column(name = "paisfabrica")
    private String paisfabrica;
    @Size(max = 20)
    @Column(name = "placa")
    private String placa;
    @Size(max = 100)
    @Column(name = "consecionario")
    private String consecionario;

    public Vehiculo(String ide, String año, String nunpasajeros, String modelo, String marca, String cilindrage, String paisfabrica, String placa, String consecionario) {
        this.ide = ide;
        this.año = año;
        this.nunpasajeros = nunpasajeros;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindrage = cilindrage;
        this.paisfabrica = paisfabrica;
        this.placa = placa;
        this.consecionario = consecionario;
    }

    public Vehiculo() {
    }

    public Vehiculo(String ide) {
        this.ide = ide;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNunpasajeros() {
        return nunpasajeros;
    }

    public void setNunpasajeros(String nunpasajeros) {
        this.nunpasajeros = nunpasajeros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindrage() {
        return cilindrage;
    }

    public void setCilindrage(String cilindrage) {
        this.cilindrage = cilindrage;
    }

    public String getPaisfabrica() {
        return paisfabrica;
    }

    public void setPaisfabrica(String paisfabrica) {
        this.paisfabrica = paisfabrica;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConsecionario() {
        return consecionario;
    }

    public void setConsecionario(String consecionario) {
        this.consecionario = consecionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ide != null ? ide.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.ide == null && other.ide != null) || (this.ide != null && !this.ide.equals(other.ide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vehiculo[ ide=" + ide + " ]";
    }
    
}
