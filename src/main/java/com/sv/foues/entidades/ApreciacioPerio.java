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
@Table(name = "apreciacio_perio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApreciacioPerio.findAll", query = "SELECT a FROM ApreciacioPerio a")
    , @NamedQuery(name = "ApreciacioPerio.findByIdperio", query = "SELECT a FROM ApreciacioPerio a WHERE a.idperio = :idperio")
    , @NamedQuery(name = "ApreciacioPerio.findByGingivitis", query = "SELECT a FROM ApreciacioPerio a WHERE a.gingivitis = :gingivitis")
    , @NamedQuery(name = "ApreciacioPerio.findByPeriodonto", query = "SELECT a FROM ApreciacioPerio a WHERE a.periodonto = :periodonto")})
public class ApreciacioPerio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperio", nullable = false)
    private Integer idperio;
    @Column(name = "gingivitis")
    private Integer gingivitis;
    @Column(name = "periodonto")
    private Integer periodonto;
    @JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;

    public ApreciacioPerio() {
    }

    public ApreciacioPerio(Integer idperio) {
        this.idperio = idperio;
    }

    public Integer getIdperio() {
        return idperio;
    }

    public void setIdperio(Integer idperio) {
        this.idperio = idperio;
    }

    public Integer getGingivitis() {
        return gingivitis;
    }

    public void setGingivitis(Integer gingivitis) {
        this.gingivitis = gingivitis;
    }

    public Integer getPeriodonto() {
        return periodonto;
    }

    public void setPeriodonto(Integer periodonto) {
        this.periodonto = periodonto;
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
        hash += (idperio != null ? idperio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApreciacioPerio)) {
            return false;
        }
        ApreciacioPerio other = (ApreciacioPerio) object;
        if ((this.idperio == null && other.idperio != null) || (this.idperio != null && !this.idperio.equals(other.idperio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.ApreciacioPerio[ idperio=" + idperio + " ]";
    }
    
}
