/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruta.turismo.rutaturismo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuer
 */
@Entity
@Table(name = "turista", catalog = "rutas", schema = "")
@XmlRootElement
public class Turista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTurista")
    private Integer idTurista;
    @Size(max = 150)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    
    @Size(max = 100)
    @Column(name = "ciudadpais")
    private String ciudadpais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurista")
    private List<Rutaturista> rutaturistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurista")
    private List<Rutausuario> rutausuarioList;

    public Turista() {
    }

    public Turista(Integer idTurista) {
        this.idTurista = idTurista;
    }

    public Integer getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(Integer idTurista) {
        this.idTurista = idTurista;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @XmlTransient
    public List<Rutaturista> getRutaturistaList() {
        return rutaturistaList;
    }

    public void setRutaturistaList(List<Rutaturista> rutaturistaList) {
        this.rutaturistaList = rutaturistaList;
    }

    public String getCiudadpais() {
        return ciudadpais;
    }

    public void setCiudadpais(String ciudadpais) {
        this.ciudadpais = ciudadpais;
    }
    

    @XmlTransient
    public List<Rutausuario> getRutausuarioList() {
        return rutausuarioList;
    }

    public void setRutausuarioList(List<Rutausuario> rutausuarioList) {
        this.rutausuarioList = rutausuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurista != null ? idTurista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turista)) {
            return false;
        }
        Turista other = (Turista) object;
        if ((this.idTurista == null && other.idTurista != null) || (this.idTurista != null && !this.idTurista.equals(other.idTurista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ruta.turismo.rutaturismo.Turista[ idTurista=" + idTurista + " ]";
    }
    
}
