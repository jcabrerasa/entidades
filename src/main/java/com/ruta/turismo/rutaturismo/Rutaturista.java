/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruta.turismo.rutaturismo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuer
 */
@Entity
@Table(name = "rutaturista", catalog = "rutas", schema = "")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutaturista.findAll", query = "SELECT r FROM Rutaturista r")
    , @NamedQuery(name = "Rutaturista.findByIdRutaTurista", query = "SELECT r FROM Rutaturista r WHERE r.idRutaTurista = :idRutaTurista")
    , @NamedQuery(name = "Rutaturista.findByEstado", query = "SELECT r FROM Rutaturista r WHERE r.estado = :estado")})
public class Rutaturista implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRutaTurista")
    private Integer idRutaTurista;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idRuta", referencedColumnName = "idRuta")
    @ManyToOne(optional = false)
    private Ruta idRuta;
    @JoinColumn(name = "idTurista", referencedColumnName = "idTurista")
    @ManyToOne(optional = false)
    private Turista idTurista;
    @JoinColumn(name = "idOperador", referencedColumnName = "idOperador")
    @ManyToOne(optional = false)
    private Operador idOperador;

    public Rutaturista() {
    }

    public Rutaturista(Integer idRutaTurista) {
        this.idRutaTurista = idRutaTurista;
    }

    public Integer getIdRutaTurista() {
        return idRutaTurista;
    }

    public void setIdRutaTurista(Integer idRutaTurista) {
        this.idRutaTurista = idRutaTurista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
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
        hash += (idRutaTurista != null ? idRutaTurista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutaturista)) {
            return false;
        }
        Rutaturista other = (Rutaturista) object;
        if ((this.idRutaTurista == null && other.idRutaTurista != null) || (this.idRutaTurista != null && !this.idRutaTurista.equals(other.idRutaTurista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ruta.turismo.rutaturismo.Rutaturista[ idRutaTurista=" + idRutaTurista + " ]";
    }
    
}
