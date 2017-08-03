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
@Table(name = "pieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pieza.findAll", query = "SELECT p FROM Pieza p")
    , @NamedQuery(name = "Pieza.findByIdpieza", query = "SELECT p FROM Pieza p WHERE p.idpieza = :idpieza")
    , @NamedQuery(name = "Pieza.findByNombrepieza", query = "SELECT p FROM Pieza p WHERE p.nombrepieza = :nombrepieza")})
public class Pieza implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpieza", nullable = false)
    private Integer idpieza;
    @Column(name = "nombrepieza", length = 5)
    private String nombrepieza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezaIdpieza")
    private Collection<Evaluacionperio> evaluacionperioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezaIdpieza")
    private Collection<Superficie> superficieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezaIdpieza")
    private Collection<Partepieza> partepiezaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezaIdpieza")
    private Collection<Traumadentro> traumadentroCollection;

    public Pieza() {
    }

    public Pieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public Integer getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public String getNombrepieza() {
        return nombrepieza;
    }

    public void setNombrepieza(String nombrepieza) {
        this.nombrepieza = nombrepieza;
    }

    @XmlTransient
    public Collection<Evaluacionperio> getEvaluacionperioCollection() {
        return evaluacionperioCollection;
    }

    public void setEvaluacionperioCollection(Collection<Evaluacionperio> evaluacionperioCollection) {
        this.evaluacionperioCollection = evaluacionperioCollection;
    }

    @XmlTransient
    public Collection<Superficie> getSuperficieCollection() {
        return superficieCollection;
    }

    public void setSuperficieCollection(Collection<Superficie> superficieCollection) {
        this.superficieCollection = superficieCollection;
    }

    @XmlTransient
    public Collection<Partepieza> getPartepiezaCollection() {
        return partepiezaCollection;
    }

    public void setPartepiezaCollection(Collection<Partepieza> partepiezaCollection) {
        this.partepiezaCollection = partepiezaCollection;
    }

    @XmlTransient
    public Collection<Traumadentro> getTraumadentroCollection() {
        return traumadentroCollection;
    }

    public void setTraumadentroCollection(Collection<Traumadentro> traumadentroCollection) {
        this.traumadentroCollection = traumadentroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpieza != null ? idpieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Pieza other = (Pieza) object;
        if ((this.idpieza == null && other.idpieza != null) || (this.idpieza != null && !this.idpieza.equals(other.idpieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Pieza[ idpieza=" + idpieza + " ]";
    }
    
}
