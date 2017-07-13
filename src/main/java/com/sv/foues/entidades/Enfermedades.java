/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "enfermedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedades.findAll", query = "SELECT e FROM Enfermedades e")
    , @NamedQuery(name = "Enfermedades.findByIdenfermedad", query = "SELECT e FROM Enfermedades e WHERE e.idenfermedad = :idenfermedad")
    , @NamedQuery(name = "Enfermedades.findByIdsistema", query = "SELECT e FROM Enfermedades e WHERE e.idsistema = :idsistema")
    , @NamedQuery(name = "Enfermedades.findByIdtipo", query = "SELECT e FROM Enfermedades e WHERE e.idtipo = :idtipo")})
public class Enfermedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenfermedad", nullable = false)
    private Integer idenfermedad;
    @Column(name = "idsistema")
    private Integer idsistema;
    @Column(name = "idtipo")
    private Integer idtipo;
    @JoinColumn(name = "EvaluacionSistematica_idEva", referencedColumnName = "idEva", nullable = false)
    @ManyToOne(optional = false)
    private EvaluacionSistematica evaluacionSistematicaidEva;

    public Enfermedades() {
    }

    public Enfermedades(Integer idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    public Integer getIdenfermedad() {
        return idenfermedad;
    }

    public void setIdenfermedad(Integer idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    public Integer getIdsistema() {
        return idsistema;
    }

    public void setIdsistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public EvaluacionSistematica getEvaluacionSistematicaidEva() {
        return evaluacionSistematicaidEva;
    }

    public void setEvaluacionSistematicaidEva(EvaluacionSistematica evaluacionSistematicaidEva) {
        this.evaluacionSistematicaidEva = evaluacionSistematicaidEva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenfermedad != null ? idenfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.idenfermedad == null && other.idenfermedad != null) || (this.idenfermedad != null && !this.idenfermedad.equals(other.idenfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Enfermedades[ idenfermedad=" + idenfermedad + " ]";
    }
    
}
