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
@Table(name = "referencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencias.findAll", query = "SELECT r FROM Referencias r")
    , @NamedQuery(name = "Referencias.findByIdreferencias", query = "SELECT r FROM Referencias r WHERE r.idreferencias = :idreferencias")
    , @NamedQuery(name = "Referencias.findByNombres", query = "SELECT r FROM Referencias r WHERE r.nombres = :nombres")})
public class Referencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreferencias", nullable = false)
    private Integer idreferencias;
    @Column(name = "nombres", length = 45)
    private String nombres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenciasIdreferencias")
    private Collection<FichaAdmision> fichaAdmisionCollection;

    public Referencias() {
    }

    public Referencias(Integer idreferencias) {
        this.idreferencias = idreferencias;
    }

    public Integer getIdreferencias() {
        return idreferencias;
    }

    public void setIdreferencias(Integer idreferencias) {
        this.idreferencias = idreferencias;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlTransient
    public Collection<FichaAdmision> getFichaAdmisionCollection() {
        return fichaAdmisionCollection;
    }

    public void setFichaAdmisionCollection(Collection<FichaAdmision> fichaAdmisionCollection) {
        this.fichaAdmisionCollection = fichaAdmisionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreferencias != null ? idreferencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencias)) {
            return false;
        }
        Referencias other = (Referencias) object;
        if ((this.idreferencias == null && other.idreferencias != null) || (this.idreferencias != null && !this.idreferencias.equals(other.idreferencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Referencias[ idreferencias=" + idreferencias + " ]";
    }
    
}
