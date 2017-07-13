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
@Table(name = "Expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
    , @NamedQuery(name = "Expediente.findByNumExpediente", query = "SELECT e FROM Expediente e WHERE e.numExpediente = :numExpediente")
    , @NamedQuery(name = "Expediente.findByActivo", query = "SELECT e FROM Expediente e WHERE e.activo = :activo")
   })
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_Expediente", nullable = false, length = 10)
    private String numExpediente;
    @Column(name = "activo")
    private Boolean activo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numExpediente")
    private Collection<FichaClinica> fichaClinicaCollection;
    @JoinColumn(name = "paciente_idpac", referencedColumnName = "idpac", nullable = false)
    @ManyToOne(optional = false)
    private Paciente pacienteIdpac;

    public Expediente() {
    }

    public Expediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

   

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

   

  
    @XmlTransient
    public Collection<FichaClinica> getFichaClinicaCollection() {
        return fichaClinicaCollection;
    }

    public void setFichaClinicaCollection(Collection<FichaClinica> fichaClinicaCollection) {
        this.fichaClinicaCollection = fichaClinicaCollection;
    }

    public Paciente getPacienteIdpac() {
        return pacienteIdpac;
    }

    public void setPacienteIdpac(Paciente pacienteIdpac) {
        this.pacienteIdpac = pacienteIdpac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numExpediente != null ? numExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.numExpediente == null && other.numExpediente != null) || (this.numExpediente != null && !this.numExpediente.equals(other.numExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Expediente[ numExpediente=" + numExpediente + " ]";
    }
    
}
