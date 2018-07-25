/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruta.turismo.rutaturismo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuer
 */
@Entity
@Table(name = "ruta", catalog = "rutas", schema = "")
@SequenceGenerator(name = "ruta_SQ", initialValue = 1, allocationSize = 1, catalog = "", schema = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByIdRuta", query = "SELECT r FROM Ruta r WHERE r.idRuta = :idRuta")
    , @NamedQuery(name = "Ruta.findByTempoEstimado", query = "SELECT r FROM Ruta r WHERE r.tempoEstimado = :tempoEstimado")
    , @NamedQuery(name = "Ruta.findByDescripcion", query = "SELECT r FROM Ruta r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Ruta.findByHoraInicial", query = "SELECT r FROM Ruta r WHERE r.horaInicial = :horaInicial")
    , @NamedQuery(name = "Ruta.findByHorafinal", query = "SELECT r FROM Ruta r WHERE r.horafinal = :horafinal")
    , @NamedQuery(name = "Ruta.findByFechahorario", query = "SELECT r FROM Ruta r WHERE r.fechahorario = :fechahorario")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ruta_SQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRuta")
    private Integer idRuta;
    @Column(name = "TempoEstimado")
    private Integer tempoEstimado;
    @Size(max = 150)
    @Column(name = "titulo")
    private String titulo;
    
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "horaInicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicial;
    @Column(name = "horafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafinal;
    @Column(name = "fechahorario")
    @Temporal(TemporalType.DATE)
    private Date fechahorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<Trayecto> trayectoList;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<Rutaturista> rutaturistaList;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imgruta")
    private byte[] imgruta;
    
    @Column(name = "estado")
    private String estado;
    
      @Column(name = "color")
    private String color;

    public Ruta() {
    }

    public Ruta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Integer tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Date horafinal) {
        this.horafinal = horafinal;
    }

    public Date getFechahorario() {
        return fechahorario;
    }

    public void setFechahorario(Date fechahorario) {
        this.fechahorario = fechahorario;
    }

    @XmlTransient
    public List<Trayecto> getTrayectoList() {
        return trayectoList;
    }

    public void setTrayectoList(List<Trayecto> trayectoList) {
        this.trayectoList = trayectoList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

    @XmlTransient
    public List<Rutaturista> getRutaturistaList() {
        return rutaturistaList;
    }

    public void setRutaturistaList(List<Rutaturista> rutaturistaList) {
        this.rutaturistaList = rutaturistaList;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getImgruta() {
        return imgruta;
    }

    public void setImgruta(byte[] imgruta) {
        this.imgruta = imgruta;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return titulo;
    return String.format("Ruta[%d, %s]", idRuta, titulo);
    }
    
}
