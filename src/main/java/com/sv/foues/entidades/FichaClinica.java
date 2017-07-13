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
@Table(name = "FichaClinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaClinica.findAll", query = "SELECT f FROM FichaClinica f")
    , @NamedQuery(name = "FichaClinica.findByIdFicha", query = "SELECT f FROM FichaClinica f WHERE f.idFicha = :idFicha")})
public class FichaClinica implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFicha", nullable = false)
    private Integer idFicha;
    @JoinColumn(name = "num_Expediente", referencedColumnName = "num_Expediente", nullable = false)
    @ManyToOne(optional = false)
    private Expediente numExpediente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaidFicha")
    private Collection<FichaAdmision> fichaAdmisionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaClinicaidFicha")
    private Collection<Horarios> horariosCollection;

    public FichaClinica() {
    }

    public FichaClinica(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Expediente getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Expediente numExpediente) {
        this.numExpediente = numExpediente;
    }

    @XmlTransient
    public Collection<FichaAdmision> getFichaAdmisionCollection() {
        return fichaAdmisionCollection;
    }

    public void setFichaAdmisionCollection(Collection<FichaAdmision> fichaAdmisionCollection) {
        this.fichaAdmisionCollection = fichaAdmisionCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicha != null ? idFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaClinica)) {
            return false;
        }
        FichaClinica other = (FichaClinica) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.FichaClinica[ idFicha=" + idFicha + " ]";
    }
    
}
