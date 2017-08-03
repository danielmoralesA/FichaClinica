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
@Table(name = "odontograma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odontograma.findAll", query = "SELECT o FROM Odontograma o")
    , @NamedQuery(name = "Odontograma.findById", query = "SELECT o FROM Odontograma o WHERE o.id = :id")
    , @NamedQuery(name = "Odontograma.findByNombre", query = "SELECT o FROM Odontograma o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Odontograma.findByObservaciones", query = "SELECT o FROM Odontograma o WHERE o.observaciones = :observaciones")})
public class Odontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombre", length = 250)
    private String nombre;
    @Column(name = "observaciones", length = 100)
    private String observaciones;
    @OneToMany(mappedBy = "odontogramaId")
    private Collection<Caracteristica> caracteristicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odontogramaId")
    private Collection<Evaluacionperio> evaluacionperioCollection;
    @JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;

    public Odontograma() {
    }

    public Odontograma(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Caracteristica> getCaracteristicaCollection() {
        return caracteristicaCollection;
    }

    public void setCaracteristicaCollection(Collection<Caracteristica> caracteristicaCollection) {
        this.caracteristicaCollection = caracteristicaCollection;
    }

    @XmlTransient
    public Collection<Evaluacionperio> getEvaluacionperioCollection() {
        return evaluacionperioCollection;
    }

    public void setEvaluacionperioCollection(Collection<Evaluacionperio> evaluacionperioCollection) {
        this.evaluacionperioCollection = evaluacionperioCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odontograma)) {
            return false;
        }
        Odontograma other = (Odontograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Odontograma[ id=" + id + " ]";
    }
    
}
