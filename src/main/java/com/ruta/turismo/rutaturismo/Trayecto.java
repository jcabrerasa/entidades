/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruta.turismo.rutaturismo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuer
 */
@Entity
@Table(name = "trayecto", catalog = "rutas", schema = "")

@XmlRootElement
public class Trayecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrayecto")
    private Integer idTrayecto;
    @Size(max = 345)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tiempotrayectoria")
    private Integer tiempotrayectoria;
    @Size(max = 60)
    @Column(name = "cordenadas")
    private String cordenadas;
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "tiempovisita")
    private Integer tiempovisita;
    @Size(max = 1)
    @Column(name = "tipotrayecto")
    private String tipotrayecto;
    @JoinColumn(name = "idRuta", referencedColumnName = "idRuta")
    @ManyToOne(optional = false)
    private Ruta idRuta;
   
    @JoinColumn(name = "idRutaUsuario", referencedColumnName = "idRutaUsuario")
    @ManyToOne(optional = true)
    private Rutausuario idRutaUsuario;
    
     @Column(name = "horarioatencion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioatencion;
     
     @Size(max = 345)
    @Column(name = "direccion")
    private String direccion;
     
     
     @Column(name = "costovisita")
    private Double costovisita;
     
      @Column(name = "orden")
    private Integer orden;
      
        @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imgtrayecto")
    private byte[] imgtrayecto;
      
     
     

    public Trayecto() {
    }

    public Trayecto(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public Integer getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempotrayectoria() {
        return tiempotrayectoria;
    }

    public void setTiempotrayectoria(Integer tiempotrayectoria) {
        this.tiempotrayectoria = tiempotrayectoria;
    }

    public String getCordenadas() {
        return cordenadas;
    }

    public void setCordenadas(String cordenadas) {
        this.cordenadas = cordenadas;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    

    public Integer getTiempovisita() {
        return tiempovisita;
    }

    public void setTiempovisita(Integer tiempovisita) {
        this.tiempovisita = tiempovisita;
    }

    public String getTipotrayecto() {
        return tipotrayecto;
    }

    public void setTipotrayecto(String tipotrayecto) {
        this.tipotrayecto = tipotrayecto;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }

    public Rutausuario getIdRutaUsuario() {
        return idRutaUsuario;
    }

    public void setIdRutaUsuario(Rutausuario idRutaUsuario) {
        this.idRutaUsuario = idRutaUsuario;
    }

    public Date getHorarioatencion() {
        return horarioatencion;
    }

    public void setHorarioatencion(Date horarioatencion) {
        this.horarioatencion = horarioatencion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getCostovisita() {
        return costovisita;
    }

    public void setCostovisita(Double costovisita) {
        this.costovisita = costovisita;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public byte[] getImgtrayecto() {
        return imgtrayecto;
    }

    public void setImgtrayecto(byte[] imgtrayecto) {
        this.imgtrayecto = imgtrayecto;
    }
    

   
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrayecto != null ? idTrayecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trayecto)) {
            return false;
        }
        Trayecto other = (Trayecto) object;
        if ((this.idTrayecto == null && other.idTrayecto != null) || (this.idTrayecto != null && !this.idTrayecto.equals(other.idTrayecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ruta.turismo.rutaturismo.Trayecto[ idTrayecto=" + idTrayecto + " ]";
    }
    
}
