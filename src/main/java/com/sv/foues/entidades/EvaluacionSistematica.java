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
@Table(name = "EvaluacionSistematica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionSistematica.findAll", query = "SELECT e FROM EvaluacionSistematica e")
    , @NamedQuery(name = "EvaluacionSistematica.findByIdEva", query = "SELECT e FROM EvaluacionSistematica e WHERE e.idEva = :idEva")
    , @NamedQuery(name = "EvaluacionSistematica.findByEvaluacionSistematica", query = "SELECT e FROM EvaluacionSistematica e WHERE e.evaluacionSistematica = :evaluacionSistematica")
    , @NamedQuery(name = "EvaluacionSistematica.findByHospitalizacion", query = "SELECT e FROM EvaluacionSistematica e WHERE e.hospitalizacion = :hospitalizacion")
    , @NamedQuery(name = "EvaluacionSistematica.findByComplicaciones", query = "SELECT e FROM EvaluacionSistematica e WHERE e.complicaciones = :complicaciones")})
public class EvaluacionSistematica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEva", nullable = false)
    private Integer idEva;
    @Column(name = "evaluacionSistematica", length = 100)
    private String evaluacionSistematica;
    @Column(name = "hospitalizacion", length = 100)
    private String hospitalizacion;
    @Column(name = "complicaciones", length = 100)
    private String complicaciones;
    @JoinColumn(name = "FichaAdmision_idFichaAdmision", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaAdmisionidFichaAdmision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacionSistematicaidEva")
    private Collection<Enfermedades> enfermedadesCollection;

    public EvaluacionSistematica() {
    }

    public EvaluacionSistematica(Integer idEva) {
        this.idEva = idEva;
    }

    public Integer getIdEva() {
        return idEva;
    }

    public void setIdEva(Integer idEva) {
        this.idEva = idEva;
    }

    public String getEvaluacionSistematica() {
        return evaluacionSistematica;
    }

    public void setEvaluacionSistematica(String evaluacionSistematica) {
        this.evaluacionSistematica = evaluacionSistematica;
    }

    public String getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(String hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    public String getComplicaciones() {
        return complicaciones;
    }

    public void setComplicaciones(String complicaciones) {
        this.complicaciones = complicaciones;
    }

    public FichaAdmision getFichaAdmisionidFichaAdmision() {
        return fichaAdmisionidFichaAdmision;
    }

    public void setFichaAdmisionidFichaAdmision(FichaAdmision fichaAdmisionidFichaAdmision) {
        this.fichaAdmisionidFichaAdmision = fichaAdmisionidFichaAdmision;
    }

    @XmlTransient
    public Collection<Enfermedades> getEnfermedadesCollection() {
        return enfermedadesCollection;
    }

    public void setEnfermedadesCollection(Collection<Enfermedades> enfermedadesCollection) {
        this.enfermedadesCollection = enfermedadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEva != null ? idEva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionSistematica)) {
            return false;
        }
        EvaluacionSistematica other = (EvaluacionSistematica) object;
        if ((this.idEva == null && other.idEva != null) || (this.idEva != null && !this.idEva.equals(other.idEva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.EvaluacionSistematica[ idEva=" + idEva + " ]";
    }
    
}
