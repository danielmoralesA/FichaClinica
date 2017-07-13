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
@Table(name = "ficha_admision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaAdmision.findAll", query = "SELECT f FROM FichaAdmision f")
    , @NamedQuery(name = "FichaAdmision.findByIdFicha", query = "SELECT f FROM FichaAdmision f WHERE f.idFicha = :idFicha")
    , @NamedQuery(name = "FichaAdmision.findByMotivoConsulta", query = "SELECT f FROM FichaAdmision f WHERE f.motivoConsulta = :motivoConsulta")
    , @NamedQuery(name = "FichaAdmision.findByHistoriaPEnfermedad", query = "SELECT f FROM FichaAdmision f WHERE f.historiaPEnfermedad = :historiaPEnfermedad")})
public class FichaAdmision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFicha", nullable = false)
    private Integer idFicha;
    @Column(name = "motivoConsulta", length = 100)
    private String motivoConsulta;
    @Column(name = "HistoriaPEnfermedad", length = 100)
    private String historiaPEnfermedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaAdmisionidFichaAdmision")
    private Collection<EvaluacionSistematica> evaluacionSistematicaCollection;
    @JoinColumn(name = "Ficha_idFicha", referencedColumnName = "idFicha", nullable = false,updatable= false)
    @ManyToOne(optional = false)
    private FichaClinica fichaidFicha;
    @JoinColumn(name = "referencias_idreferencias", referencedColumnName = "idreferencias", nullable = false)
    @ManyToOne(optional = false)
    private Referencias referenciasIdreferencias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<Examenlaboratorio> examenlaboratorioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<HallazgosRadio> hallazgosRadioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<Necesidadtratamiento> necesidadtratamientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<ApreciacioPerio> apreciacioPerioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<Odontograma> odontogramaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaadmisionidFicha")
    private Collection<Traumadentro> traumadentroCollection;
    
    
    public FichaAdmision() {
    }

    public FichaAdmision(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getHistoriaPEnfermedad() {
        return historiaPEnfermedad;
    }

    public void setHistoriaPEnfermedad(String historiaPEnfermedad) {
        this.historiaPEnfermedad = historiaPEnfermedad;
    }

    @XmlTransient
    public Collection<EvaluacionSistematica> getEvaluacionSistematicaCollection() {
        return evaluacionSistematicaCollection;
    }

    public void setEvaluacionSistematicaCollection(Collection<EvaluacionSistematica> evaluacionSistematicaCollection) {
        this.evaluacionSistematicaCollection = evaluacionSistematicaCollection;
    }

    public FichaClinica getFichaidFicha() {
        return fichaidFicha;
    }

    public void setFichaidFicha(FichaClinica fichaidFicha) {
        this.fichaidFicha = fichaidFicha;
    }

    public Referencias getReferenciasIdreferencias() {
        return referenciasIdreferencias;
    }

    public void setReferenciasIdreferencias(Referencias referenciasIdreferencias) {
        this.referenciasIdreferencias = referenciasIdreferencias;
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
        if (!(object instanceof FichaAdmision)) {
            return false;
        }
        FichaAdmision other = (FichaAdmision) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @XmlTransient
    public Collection<Examenlaboratorio> getExamenlaboratorioCollection() {
        return examenlaboratorioCollection;
    }

    public void setExamenlaboratorioCollection(Collection<Examenlaboratorio> examenlaboratorioCollection) {
        this.examenlaboratorioCollection = examenlaboratorioCollection;
    }

    @XmlTransient
    public Collection<HallazgosRadio> getHallazgosRadioCollection() {
        return hallazgosRadioCollection;
    }

    public void setHallazgosRadioCollection(Collection<HallazgosRadio> hallazgosRadioCollection) {
        this.hallazgosRadioCollection = hallazgosRadioCollection;
    }

    @XmlTransient
    public Collection<Necesidadtratamiento> getNecesidadtratamientoCollection() {
        return necesidadtratamientoCollection;
    }

    public void setNecesidadtratamientoCollection(Collection<Necesidadtratamiento> necesidadtratamientoCollection) {
        this.necesidadtratamientoCollection = necesidadtratamientoCollection;
    }

    @XmlTransient
    public Collection<ApreciacioPerio> getApreciacioPerioCollection() {
        return apreciacioPerioCollection;
    }

    public void setApreciacioPerioCollection(Collection<ApreciacioPerio> apreciacioPerioCollection) {
        this.apreciacioPerioCollection = apreciacioPerioCollection;
    }

    @XmlTransient
    public Collection<Odontograma> getOdontogramaCollection() {
        return odontogramaCollection;
    }

    public void setOdontogramaCollection(Collection<Odontograma> odontogramaCollection) {
        this.odontogramaCollection = odontogramaCollection;
    }

    @XmlTransient
    public Collection<Traumadentro> getTraumadentroCollection() {
        return traumadentroCollection;
    }

    public void setTraumadentroCollection(Collection<Traumadentro> traumadentroCollection) {
        this.traumadentroCollection = traumadentroCollection;
    }

    
    @Override
    public String toString() {
        return "com.sv.foues.entidades.FichaAdmision[ idFicha=" + idFicha + " ]";
    }
    
}
