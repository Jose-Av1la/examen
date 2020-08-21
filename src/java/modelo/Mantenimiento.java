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
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIde", query = "SELECT m FROM Mantenimiento m WHERE m.ide = :ide")
    , @NamedQuery(name = "Mantenimiento.findByCliente", query = "SELECT m FROM Mantenimiento m WHERE m.cliente = :cliente")
    , @NamedQuery(name = "Mantenimiento.findByTipoveh\u00edculo", query = "SELECT m FROM Mantenimiento m WHERE m.tipoveh\u00edculo = :tipoveh\u00edculo")
    , @NamedQuery(name = "Mantenimiento.findByFechadecripcion", query = "SELECT m FROM Mantenimiento m WHERE m.fechadecripcion = :fechadecripcion")
    , @NamedQuery(name = "Mantenimiento.findByKilometrage", query = "SELECT m FROM Mantenimiento m WHERE m.kilometrage = :kilometrage")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ide")
    private String ide;
    @Size(max = 100)
    @Column(name = "cliente")
    private String cliente;
    @Size(max = 50)
    @Column(name = "tipoveh\u00edculo")
    private String tipovehículo;
    @Size(max = 100)
    @Column(name = "fechadecripcion")
    private String fechadecripcion;
    @Size(max = 20)
    @Column(name = "kilometrage")
    private String kilometrage;

    public Mantenimiento() {
    }

    public Mantenimiento(String ide) {
        this.ide = ide;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipovehículo() {
        return tipovehículo;
    }

    public void setTipovehículo(String tipovehículo) {
        this.tipovehículo = tipovehículo;
    }

    public String getFechadecripcion() {
        return fechadecripcion;
    }

    public void setFechadecripcion(String fechadecripcion) {
        this.fechadecripcion = fechadecripcion;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
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
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.ide == null && other.ide != null) || (this.ide != null && !this.ide.equals(other.ide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mantenimiento[ ide=" + ide + " ]";
    }
    
}
