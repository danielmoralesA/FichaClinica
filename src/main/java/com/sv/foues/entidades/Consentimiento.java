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
@Table(name = "consentimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consentimiento.findAll", query = "SELECT c FROM Consentimiento c")
    , @NamedQuery(name = "Consentimiento.findByIdconsentimiento", query = "SELECT c FROM Consentimiento c WHERE c.idconsentimiento = :idconsentimiento")
    , @NamedQuery(name = "Consentimiento.findByFirma", query = "SELECT c FROM Consentimiento c WHERE c.firma = :firma")
    , @NamedQuery(name = "Consentimiento.findByCostoficha", query = "SELECT c FROM Consentimiento c WHERE c.costoficha = :costoficha")})
public class Consentimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsentimiento", nullable = false)
    private Integer idconsentimiento;
    @Column(name = "firma", length = 250)
    private String firma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoficha", precision = 22)
    private Double costoficha;
    @JoinColumn(name = "necesidadtratamiento_idnecesidadtratamiento", referencedColumnName = "idnecesidadtratamiento", nullable = false)
    @ManyToOne(optional = false)
    private Necesidadtratamiento necesidadtratamientoIdnecesidadtratamiento;

    public Consentimiento() {
    }

    public Consentimiento(Integer idconsentimiento) {
        this.idconsentimiento = idconsentimiento;
    }

    public Integer getIdconsentimiento() {
        return idconsentimiento;
    }

    public void setIdconsentimiento(Integer idconsentimiento) {
        this.idconsentimiento = idconsentimiento;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Double getCostoficha() {
        return costoficha;
    }

    public void setCostoficha(Double costoficha) {
        this.costoficha = costoficha;
    }

    public Necesidadtratamiento getNecesidadtratamientoIdnecesidadtratamiento() {
        return necesidadtratamientoIdnecesidadtratamiento;
    }

    public void setNecesidadtratamientoIdnecesidadtratamiento(Necesidadtratamiento necesidadtratamientoIdnecesidadtratamiento) {
        this.necesidadtratamientoIdnecesidadtratamiento = necesidadtratamientoIdnecesidadtratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsentimiento != null ? idconsentimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consentimiento)) {
            return false;
        }
        Consentimiento other = (Consentimiento) object;
        if ((this.idconsentimiento == null && other.idconsentimiento != null) || (this.idconsentimiento != null && !this.idconsentimiento.equals(other.idconsentimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Consentimiento[ idconsentimiento=" + idconsentimiento + " ]";
    }
    
}
