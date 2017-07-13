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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "enfermedad_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnfermedadSistema.findAll", query = "SELECT e FROM EnfermedadSistema e")
    , @NamedQuery(name = "EnfermedadSistema.findByIdsistema", query = "SELECT e FROM EnfermedadSistema e WHERE e.idsistema = :idsistema")
    , @NamedQuery(name = "EnfermedadSistema.findByNombresistema", query = "SELECT e FROM EnfermedadSistema e WHERE e.nombresistema = :nombresistema")})
public class EnfermedadSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsistema", nullable = false)
    private Integer idsistema;
    @Column(name = "nombresistema", length = 65)
    private String nombresistema;
    @JoinTable(name = "sistema_tiene_enfermedades", joinColumns = {
        @JoinColumn(name = "enfermedad_sistema_idsistema", referencedColumnName = "idsistema", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tiposenfermedades_idtipo", referencedColumnName = "idtipo", nullable = false)})
    @ManyToMany
    private Collection<Tiposenfermedades> tiposenfermedadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enfermedadSistemaIdsistema")
    private Collection<Tiposenfermedades> tiposenfermedadesCollection1;

    public EnfermedadSistema() {
    }

    public EnfermedadSistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public Integer getIdsistema() {
        return idsistema;
    }

    public void setIdsistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public String getNombresistema() {
        return nombresistema;
    }

    public void setNombresistema(String nombresistema) {
        this.nombresistema = nombresistema;
    }

    @XmlTransient
    public Collection<Tiposenfermedades> getTiposenfermedadesCollection() {
        return tiposenfermedadesCollection;
    }

    public void setTiposenfermedadesCollection(Collection<Tiposenfermedades> tiposenfermedadesCollection) {
        this.tiposenfermedadesCollection = tiposenfermedadesCollection;
    }

    @XmlTransient
    public Collection<Tiposenfermedades> getTiposenfermedadesCollection1() {
        return tiposenfermedadesCollection1;
    }

    public void setTiposenfermedadesCollection1(Collection<Tiposenfermedades> tiposenfermedadesCollection1) {
        this.tiposenfermedadesCollection1 = tiposenfermedadesCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsistema != null ? idsistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfermedadSistema)) {
            return false;
        }
        EnfermedadSistema other = (EnfermedadSistema) object;
        if ((this.idsistema == null && other.idsistema != null) || (this.idsistema != null && !this.idsistema.equals(other.idsistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.EnfermedadSistema[ idsistema=" + idsistema + " ]";
    }
    
}
