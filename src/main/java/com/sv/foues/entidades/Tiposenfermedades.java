/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "tiposenfermedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposenfermedades.findAll", query = "SELECT t FROM Tiposenfermedades t")
    , @NamedQuery(name = "Tiposenfermedades.findByIdtipo", query = "SELECT t FROM Tiposenfermedades t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tiposenfermedades.findByNombreenfermedad", query = "SELECT t FROM Tiposenfermedades t WHERE t.nombreenfermedad = :nombreenfermedad")})
public class Tiposenfermedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo", nullable = false)
    private Integer idtipo;
    @Column(name = "nombreenfermedad", length = 45)
    private String nombreenfermedad;
    @ManyToMany(mappedBy = "tiposenfermedadesCollection")
    private Collection<EnfermedadSistema> enfermedadSistemaCollection;
    @JoinColumn(name = "enfermedad_sistema_idsistema", referencedColumnName = "idsistema", nullable = false)
    @ManyToOne(optional = false)
    private EnfermedadSistema enfermedadSistemaIdsistema;

    public Tiposenfermedades() {
    }

    public Tiposenfermedades(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombreenfermedad() {
        return nombreenfermedad;
    }

    public void setNombreenfermedad(String nombreenfermedad) {
        this.nombreenfermedad = nombreenfermedad;
    }

    @XmlTransient
    public Collection<EnfermedadSistema> getEnfermedadSistemaCollection() {
        return enfermedadSistemaCollection;
    }

    public void setEnfermedadSistemaCollection(Collection<EnfermedadSistema> enfermedadSistemaCollection) {
        this.enfermedadSistemaCollection = enfermedadSistemaCollection;
    }

    public EnfermedadSistema getEnfermedadSistemaIdsistema() {
        return enfermedadSistemaIdsistema;
    }

    public void setEnfermedadSistemaIdsistema(EnfermedadSistema enfermedadSistemaIdsistema) {
        this.enfermedadSistemaIdsistema = enfermedadSistemaIdsistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposenfermedades)) {
            return false;
        }
        Tiposenfermedades other = (Tiposenfermedades) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Tiposenfermedades[ idtipo=" + idtipo + " ]";
    }
    
}
