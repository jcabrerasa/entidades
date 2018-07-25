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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuer
 */
@Entity
@Table(name = "rutausuario", catalog = "rutas", schema = "")
@XmlRootElement
public class Rutausuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRutaUsuario")
    private Integer idRutaUsuario;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Size(max = 250)
    @Column(name = "descripci\u00f3n")
    private String descripción;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRutaUsuario")
    private List<Trayecto> trayectoList;
    @JoinColumn(name = "idTurista", referencedColumnName = "idTurista")
    @ManyToOne(optional = false)
    private Turista idTurista;
    @JoinColumn(name = "idOperador", referencedColumnName = "idOperador")
    @ManyToOne(optional = false)
    private Operador idOperador;

    public Rutausuario() {
    }

    public Rutausuario(Integer idRutaUsuario) {
        this.idRutaUsuario = idRutaUsuario;
    }

    public Integer getIdRutaUsuario() {
        return idRutaUsuario;
    }

    public void setIdRutaUsuario(Integer idRutaUsuario) {
        this.idRutaUsuario = idRutaUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @XmlTransient
    public List<Trayecto> getTrayectoList() {
        return trayectoList;
    }

    public void setTrayectoList(List<Trayecto> trayectoList) {
        this.trayectoList = trayectoList;
    }

    public Turista getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(Turista idTurista) {
        this.idTurista = idTurista;
    }

    public Operador getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Operador idOperador) {
        this.idOperador = idOperador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRutaUsuario != null ? idRutaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutausuario)) {
            return false;
        }
        Rutausuario other = (Rutausuario) object;
        if ((this.idRutaUsuario == null && other.idRutaUsuario != null) || (this.idRutaUsuario != null && !this.idRutaUsuario.equals(other.idRutaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ruta.turismo.rutaturismo.Rutausuario[ idRutaUsuario=" + idRutaUsuario + " ]";
    }
    
}
