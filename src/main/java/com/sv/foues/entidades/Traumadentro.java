/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "traumadentro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traumadentro.findAll", query = "SELECT t FROM Traumadentro t")
    , @NamedQuery(name = "Traumadentro.findByIdtrauma", query = "SELECT t FROM Traumadentro t WHERE t.idtrauma = :idtrauma")
    , @NamedQuery(name = "Traumadentro.findByObservaciones", query = "SELECT t FROM Traumadentro t WHERE t.observaciones = :observaciones")
    , @NamedQuery(name = "Traumadentro.findByFecha", query = "SELECT t FROM Traumadentro t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Traumadentro.findByPresente", query = "SELECT t FROM Traumadentro t WHERE t.presente = :presente")})
public class Traumadentro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrauma", nullable = false)
    private Integer idtrauma;
    @Column(name = "observaciones", length = 250)
    private String observaciones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "presente")
    private Boolean presente;
    @JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;
    @JoinColumn(name = "pieza_idpieza", referencedColumnName = "idpieza", nullable = false)
    @ManyToOne(optional = false)
    private Pieza piezaIdpieza;

    public Traumadentro() {
    }

    public Traumadentro(Integer idtrauma) {
        this.idtrauma = idtrauma;
    }

    public Integer getIdtrauma() {
        return idtrauma;
    }

    public void setIdtrauma(Integer idtrauma) {
        this.idtrauma = idtrauma;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public FichaAdmision getFichaadmisionidFicha() {
        return fichaadmisionidFicha;
    }

    public void setFichaadmisionidFicha(FichaAdmision fichaadmisionidFicha) {
        this.fichaadmisionidFicha = fichaadmisionidFicha;
    }

    public Pieza getPiezaIdpieza() {
        return piezaIdpieza;
    }

    public void setPiezaIdpieza(Pieza piezaIdpieza) {
        this.piezaIdpieza = piezaIdpieza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrauma != null ? idtrauma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traumadentro)) {
            return false;
        }
        Traumadentro other = (Traumadentro) object;
        if ((this.idtrauma == null && other.idtrauma != null) || (this.idtrauma != null && !this.idtrauma.equals(other.idtrauma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Traumadentro[ idtrauma=" + idtrauma + " ]";
    }
    
}
