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
@Table(name = "examenlaboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examenlaboratorio.findAll", query = "SELECT e FROM Examenlaboratorio e")
    , @NamedQuery(name = "Examenlaboratorio.findByIdexame", query = "SELECT e FROM Examenlaboratorio e WHERE e.idexame = :idexame")
    , @NamedQuery(name = "Examenlaboratorio.findByTp", query = "SELECT e FROM Examenlaboratorio e WHERE e.tp = :tp")
    , @NamedQuery(name = "Examenlaboratorio.findByTpt", query = "SELECT e FROM Examenlaboratorio e WHERE e.tpt = :tpt")
    , @NamedQuery(name = "Examenlaboratorio.findByHemograma", query = "SELECT e FROM Examenlaboratorio e WHERE e.hemograma = :hemograma")
    , @NamedQuery(name = "Examenlaboratorio.findByGlucosa", query = "SELECT e FROM Examenlaboratorio e WHERE e.glucosa = :glucosa")
    , @NamedQuery(name = "Examenlaboratorio.findByOtros", query = "SELECT e FROM Examenlaboratorio e WHERE e.otros = :otros")})
public class Examenlaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexame", nullable = false)
    private Integer idexame;
    @Column(name = "tp")
    private Integer tp;
    @Column(name = "tpt")
    private Integer tpt;
    @Column(name = "hemograma")
    private Integer hemograma;
    @Column(name = "glucosa")
    private Integer glucosa;
    @Column(name = "otros", length = 100)
    private String otros;
    @Column(name="plaquetas")
    private Integer plaquetas;
    public Integer getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(Integer plaquetas) {
		this.plaquetas = plaquetas;
	}

	@JoinColumn(name = "ficha_admision_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaAdmision fichaadmisionidFicha;

    public Examenlaboratorio() {
    }

    public Examenlaboratorio(Integer idexame) {
        this.idexame = idexame;
    }

    public Integer getIdexame() {
        return idexame;
    }

    public void setIdexame(Integer idexame) {
        this.idexame = idexame;
    }

    public Integer getTp() {
        return tp;
    }

    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public Integer getTpt() {
        return tpt;
    }

    public void setTpt(Integer tpt) {
        this.tpt = tpt;
    }

    public Integer getHemograma() {
        return hemograma;
    }

    public void setHemograma(Integer hemograma) {
        this.hemograma = hemograma;
    }

    public Integer getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(Integer glucosa) {
        this.glucosa = glucosa;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
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
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examenlaboratorio)) {
            return false;
        }
        Examenlaboratorio other = (Examenlaboratorio) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Examenlaboratorio[ idexame=" + idexame + " ]";
    }
    
}
