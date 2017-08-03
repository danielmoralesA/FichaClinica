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
@Table(name = "evaluacionperio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacionperio.findAll", query = "SELECT e FROM Evaluacionperio e")
    , @NamedQuery(name = "Evaluacionperio.findByIdperio", query = "SELECT e FROM Evaluacionperio e WHERE e.idperio = :idperio")
    , @NamedQuery(name = "Evaluacionperio.findByRec", query = "SELECT e FROM Evaluacionperio e WHERE e.rec = :rec")
    , @NamedQuery(name = "Evaluacionperio.findBySon", query = "SELECT e FROM Evaluacionperio e WHERE e.son = :son")
    , @NamedQuery(name = "Evaluacionperio.findByNi", query = "SELECT e FROM Evaluacionperio e WHERE e.ni = :ni")
    , @NamedQuery(name = "Evaluacionperio.findByIc", query = "SELECT e FROM Evaluacionperio e WHERE e.ic = :ic")
    , @NamedQuery(name = "Evaluacionperio.findByFis", query = "SELECT e FROM Evaluacionperio e WHERE e.fis = :fis")
    , @NamedQuery(name = "Evaluacionperio.findByMov", query = "SELECT e FROM Evaluacionperio e WHERE e.mov = :mov")
    , @NamedQuery(name = "Evaluacionperio.findByLcv", query = "SELECT e FROM Evaluacionperio e WHERE e.lcv = :lcv")
    , @NamedQuery(name = "Evaluacionperio.findByTcr", query = "SELECT e FROM Evaluacionperio e WHERE e.tcr = :tcr")
    , @NamedQuery(name = "Evaluacionperio.findByIsd", query = "SELECT e FROM Evaluacionperio e WHERE e.isd = :isd")})
public class Evaluacionperio implements Serializable {

	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Basic(optional = false)
	    @Column(name = "idperio", nullable = false)
	    private Integer idperio;
	    @Column(name = "rec")
	    private Integer rec;
	    @Column(name = "son")
	    private Integer son;
	    @Column(name = "ni")
	    private Integer ni;
	    @Column(name = "ic")
	    private Integer ic;
	    @Column(name = "fis", length = 2)
	    private String fis;
	    @Column(name = "mov", length = 2)
	    private String mov;
	    @Column(name = "lcv", length = 2)
	    private String lcv;
	    @Column(name = "tcr", length = 2)
	    private String tcr;
	    @Column(name = "isd")
	    private Integer isd;
	    @JoinColumn(name = "odontograma_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Odontograma odontogramaId;
	    @JoinColumn(name = "pieza_idpieza", referencedColumnName = "idpieza", nullable = false)
	    @ManyToOne(optional = false)
	    private Pieza piezaIdpieza;

	    public Evaluacionperio() {
	    }

	    public Evaluacionperio(Integer idperio) {
	        this.idperio = idperio;
	    }

	    public Integer getIdperio() {
	        return idperio;
	    }

	    public void setIdperio(Integer idperio) {
	        this.idperio = idperio;
	    }

	    public Integer getRec() {
	        return rec;
	    }

	    public void setRec(Integer rec) {
	        this.rec = rec;
	    }

	    public Integer getSon() {
	        return son;
	    }

	    public void setSon(Integer son) {
	        this.son = son;
	    }

	    public Integer getNi() {
	        return ni;
	    }

	    public void setNi(Integer ni) {
	        this.ni = ni;
	    }

	    public Integer getIc() {
	        return ic;
	    }

	    public void setIc(Integer ic) {
	        this.ic = ic;
	    }

	    public String getFis() {
	        return fis;
	    }

	    public void setFis(String fis) {
	        this.fis = fis;
	    }

	    public String getMov() {
	        return mov;
	    }

	    public void setMov(String mov) {
	        this.mov = mov;
	    }

	    public String getLcv() {
	        return lcv;
	    }

	    public void setLcv(String lcv) {
	        this.lcv = lcv;
	    }

	    public String getTcr() {
	        return tcr;
	    }

	    public void setTcr(String tcr) {
	        this.tcr = tcr;
	    }

	    public Integer getIsd() {
	        return isd;
	    }

	    public void setIsd(Integer isd) {
	        this.isd = isd;
	    }

	    public Odontograma getOdontogramaId() {
	        return odontogramaId;
	    }

	    public void setOdontogramaId(Odontograma odontogramaId) {
	        this.odontogramaId = odontogramaId;
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
	        hash += (idperio != null ? idperio.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Evaluacionperio)) {
	            return false;
	        }
	        Evaluacionperio other = (Evaluacionperio) object;
	        if ((this.idperio == null && other.idperio != null) || (this.idperio != null && !this.idperio.equals(other.idperio))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.sv.foues.entidades.Evaluacionperio[ idperio=" + idperio + " ]";
	    }
    
}
