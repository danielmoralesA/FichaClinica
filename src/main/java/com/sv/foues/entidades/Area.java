/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByIdarea", query = "SELECT a FROM Area a WHERE a.idarea = :idarea")
    , @NamedQuery(name = "Area.findByNombre", query = "SELECT a FROM Area a WHERE a.nombre = :nombre")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idarea", nullable = false)
    private Integer idarea;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIdarea")
    private Collection<Necesidadtratamiento> necesidadtratamientoCollection;

    public Area() {
    }

    public Area(Integer idarea) {
        this.idarea = idarea;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Necesidadtratamiento> getNecesidadtratamientoCollection() {
        return necesidadtratamientoCollection;
    }

    public void setNecesidadtratamientoCollection(Collection<Necesidadtratamiento> necesidadtratamientoCollection) {
        this.necesidadtratamientoCollection = necesidadtratamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarea != null ? idarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idarea == null && other.idarea != null) || (this.idarea != null && !this.idarea.equals(other.idarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Area[ idarea=" + idarea + " ]";
    }
    
}
