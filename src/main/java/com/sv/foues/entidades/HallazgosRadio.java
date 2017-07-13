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
@Table(name = "hallazgos_radio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HallazgosRadio.findAll", query = "SELECT h FROM HallazgosRadio h")
    , @NamedQuery(name = "HallazgosRadio.findByIdhalla", query = "SELECT h FROM HallazgosRadio h WHERE h.idhalla = :idhalla")
    , @NamedQuery(name = "HallazgosRadio.findByObservaciones", query = "SELECT h FROM HallazgosRadio h WHERE h.observaciones = :observaciones")})
public class HallazgosRadio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhalla", nullable = false)
    private Integer idhalla;
    @Column(name = "observaciones", length = 150)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hallazgosRadioIdhalla")
    private Collection<Radio> radioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hallazgosRadioIdhalla")
    private Collection<Dificultad> dificultadCollection;
    @JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;

    public HallazgosRadio() {
    }

    public HallazgosRadio(Integer idhalla) {
        this.idhalla = idhalla;
    }

    public Integer getIdhalla() {
        return idhalla;
    }

    public void setIdhalla(Integer idhalla) {
        this.idhalla = idhalla;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Radio> getRadioCollection() {
        return radioCollection;
    }

    public void setRadioCollection(Collection<Radio> radioCollection) {
        this.radioCollection = radioCollection;
    }

    @XmlTransient
    public Collection<Dificultad> getDificultadCollection() {
        return dificultadCollection;
    }

    public void setDificultadCollection(Collection<Dificultad> dificultadCollection) {
        this.dificultadCollection = dificultadCollection;
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
        hash += (idhalla != null ? idhalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HallazgosRadio)) {
            return false;
        }
        HallazgosRadio other = (HallazgosRadio) object;
        if ((this.idhalla == null && other.idhalla != null) || (this.idhalla != null && !this.idhalla.equals(other.idhalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.HallazgosRadio[ idhalla=" + idhalla + " ]";
    }
    
}
