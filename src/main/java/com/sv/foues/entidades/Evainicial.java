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
@Table(name = "evainicial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evainicial.findAll", query = "SELECT e FROM Evainicial e")
    , @NamedQuery(name = "Evainicial.findByIdeva", query = "SELECT e FROM Evainicial e WHERE e.ideva = :ideva")
    , @NamedQuery(name = "Evainicial.findByMov", query = "SELECT e FROM Evainicial e WHERE e.mov = :mov")
    , @NamedQuery(name = "Evainicial.findByLcv", query = "SELECT e FROM Evainicial e WHERE e.lcv = :lcv")
    , @NamedQuery(name = "Evainicial.findByFis", query = "SELECT e FROM Evainicial e WHERE e.fis = :fis")
    , @NamedQuery(name = "Evainicial.findByTcr", query = "SELECT e FROM Evainicial e WHERE e.tcr = :tcr")})
public class Evainicial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ideva", nullable = false)
    private Integer ideva;
    @Column(name = "mov")
    private Integer mov;
    @Column(name = "lcv")
    private Integer lcv;
    @Column(name = "fis")
    private Integer fis;
    @Column(name = "tcr")
    private Integer tcr;
    @JoinColumn(name = "pieza_idpieza", referencedColumnName = "idpieza", nullable = false)
    @ManyToOne(optional = false)
    private Pieza piezaIdpieza;

    public Evainicial() {
    }

    public Evainicial(Integer ideva) {
        this.ideva = ideva;
    }

    public Integer getIdeva() {
        return ideva;
    }

    public void setIdeva(Integer ideva) {
        this.ideva = ideva;
    }

    public Integer getMov() {
        return mov;
    }

    public void setMov(Integer mov) {
        this.mov = mov;
    }

    public Integer getLcv() {
        return lcv;
    }

    public void setLcv(Integer lcv) {
        this.lcv = lcv;
    }

    public Integer getFis() {
        return fis;
    }

    public void setFis(Integer fis) {
        this.fis = fis;
    }

    public Integer getTcr() {
        return tcr;
    }

    public void setTcr(Integer tcr) {
        this.tcr = tcr;
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
        hash += (ideva != null ? ideva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evainicial)) {
            return false;
        }
        Evainicial other = (Evainicial) object;
        if ((this.ideva == null && other.ideva != null) || (this.ideva != null && !this.ideva.equals(other.ideva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Evainicial[ ideva=" + ideva + " ]";
    }
    
}
