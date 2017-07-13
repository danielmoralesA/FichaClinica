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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "necesidadtratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Necesidadtratamiento.findAll", query = "SELECT n FROM Necesidadtratamiento n")
    , @NamedQuery(name = "Necesidadtratamiento.findByIdnecesidadtratamiento", query = "SELECT n FROM Necesidadtratamiento n WHERE n.idnecesidadtratamiento = :idnecesidadtratamiento")
    , @NamedQuery(name = "Necesidadtratamiento.findByPioridad", query = "SELECT n FROM Necesidadtratamiento n WHERE n.pioridad = :pioridad")
    , @NamedQuery(name = "Necesidadtratamiento.findByContinuidad", query = "SELECT n FROM Necesidadtratamiento n WHERE n.continuidad = :continuidad")})
public class Necesidadtratamiento implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnecesidadtratamiento", nullable = false)
    private Integer idnecesidadtratamiento;
    @Column(name = "pioridad", length = 45)
    private String pioridad;
    @Column(name = "continuidad")
    private Integer continuidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "necesidadtratamientoIdnecesidadtratamiento")
    private Collection<Consentimiento> consentimientoCollection;
    @JoinColumn(name = "area_idarea", referencedColumnName = "idarea", nullable = false)
    @ManyToOne(optional = false)
    private Area areaIdarea;
    @JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;

    public Necesidadtratamiento() {
    }

    public Necesidadtratamiento(Integer idnecesidadtratamiento) {
        this.idnecesidadtratamiento = idnecesidadtratamiento;
    }

    public Integer getIdnecesidadtratamiento() {
        return idnecesidadtratamiento;
    }

    public void setIdnecesidadtratamiento(Integer idnecesidadtratamiento) {
        this.idnecesidadtratamiento = idnecesidadtratamiento;
    }

    public String getPioridad() {
        return pioridad;
    }

    public void setPioridad(String pioridad) {
        this.pioridad = pioridad;
    }

    public Integer getContinuidad() {
        return continuidad;
    }

    public void setContinuidad(Integer continuidad) {
        this.continuidad = continuidad;
    }

    @XmlTransient
    public Collection<Consentimiento> getConsentimientoCollection() {
        return consentimientoCollection;
    }

    public void setConsentimientoCollection(Collection<Consentimiento> consentimientoCollection) {
        this.consentimientoCollection = consentimientoCollection;
    }

    public Area getAreaIdarea() {
        return areaIdarea;
    }

    public void setAreaIdarea(Area areaIdarea) {
        this.areaIdarea = areaIdarea;
    }

    public FichaAdmision getFichaadmisionidFicha() {
        return fichaadmisionidFicha;
    }

    public void setFichaadmisionidFicha(FichaAdmision fichaadmisionidFicha) {
        this.fichaadmisionidFicha = fichaadmisionidFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnecesidadtratamiento != null ? idnecesidadtratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Necesidadtratamiento)) {
            return false;
        }
        Necesidadtratamiento other = (Necesidadtratamiento) object;
        if ((this.idnecesidadtratamiento == null && other.idnecesidadtratamiento != null) || (this.idnecesidadtratamiento != null && !this.idnecesidadtratamiento.equals(other.idnecesidadtratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Necesidadtratamiento[ idnecesidadtratamiento=" + idnecesidadtratamiento + " ]";
    }
    
}
