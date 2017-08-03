/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdpac", query = "SELECT p FROM Paciente p WHERE p.idpac = :idpac")
    , @NamedQuery(name = "Paciente.findByNumExpediente", query = "SELECT p FROM Paciente p WHERE p.numExpediente = :numExpediente")
    , @NamedQuery(name = "Paciente.findByFechaIngreso", query = "SELECT p FROM Paciente p WHERE p.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Paciente.findByLugarNacimiento", query = "SELECT p FROM Paciente p WHERE p.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Paciente.findByDomicilio", query = "SELECT p FROM Paciente p WHERE p.domicilio = :domicilio")
    , @NamedQuery(name = "Paciente.findByTelefonoMovil", query = "SELECT p FROM Paciente p WHERE p.telefonoMovil = :telefonoMovil")
    , @NamedQuery(name = "Paciente.findByTelefonoDom", query = "SELECT p FROM Paciente p WHERE p.telefonoDom = :telefonoDom")
    , @NamedQuery(name = "Paciente.findByEmail", query = "SELECT p FROM Paciente p WHERE p.email = :email")
    , @NamedQuery(name = "Paciente.findByOcupacion", query = "SELECT p FROM Paciente p WHERE p.ocupacion = :ocupacion")
    , @NamedQuery(name = "Paciente.findByDepartamento", query = "SELECT p FROM Paciente p WHERE p.departamento = :departamento")
    , @NamedQuery(name = "Paciente.findByMunicipio", query = "SELECT p FROM Paciente p WHERE p.municipio = :municipio")
    , @NamedQuery(name = "Paciente.findByActivo", query = "SELECT p FROM Paciente p WHERE p.activo = :activo")
    , @NamedQuery(name = "Paciente.findByEmbarazo", query = "SELECT p FROM Paciente p WHERE p.embarazo = :embarazo")
    , @NamedQuery(name = "Paciente.findByTiempoembarazo", query = "SELECT p FROM Paciente p WHERE p.tiempoembarazo = :tiempoembarazo")
    , @NamedQuery(name = "Paciente.findByResponsable", query = "SELECT p FROM Paciente p WHERE p.responsable = :responsable")
    , @NamedQuery(name = "Paciente.findByNiveleducativo", query = "SELECT p FROM Paciente p WHERE p.niveleducativo = :niveleducativo")
    , @NamedQuery(name = "Paciente.findByAsistio", query = "SELECT p FROM Paciente p WHERE p.asistio = :asistio")
    , @NamedQuery(name = "Paciente.findByTratamientos", query = "SELECT p FROM Paciente p WHERE p.tratamientos = :tratamientos")
    , @NamedQuery(name = "Paciente.findByDepaDomicilio", query = "SELECT p FROM Paciente p WHERE p.depaDomicilio = :depaDomicilio")
    , @NamedQuery(name = "Paciente.findByMunDomicilio", query = "SELECT p FROM Paciente p WHERE p.munDomicilio = :munDomicilio")
    , @NamedQuery(name = "Paciente.findByNombre1", query = "SELECT p FROM Paciente p WHERE p.nombre1 = :nombre1")
    , @NamedQuery(name = "Paciente.findByNombre2", query = "SELECT p FROM Paciente p WHERE p.nombre2 = :nombre2")

})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "idpac", nullable = false)
    private Integer idpac;
    @Column(name = "num_expediente", length = 10,updatable= false)
    private String numExpediente;
    @Column(name = "fecha_ingreso",updatable= false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "lugarNacimiento", length = 75)
    private String lugarNacimiento;
    @Column(name = "dui", length = 10)
    private String dui;
    public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	@Column(name = "domicilio", length = 100)
    private String domicilio;
    @Column(name = "telefonoMovil", length = 9)
    private String telefonoMovil;
    @Column(name = "TelefonoDom", length = 9)
    private String telefonoDom;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "ocupacion", length = 45)
    private String ocupacion;
    @Column(name = "departamento")
    private Integer departamento;
    @Column(name = "municipio")
    private Integer municipio;
    @Column(name = "activo",updatable= false)
    private Integer activo;
    @Column(name = "embarazo")
    private Boolean embarazo;
    @Column(name = "tiempoembarazo", length = 45)
    private String tiempoembarazo;
    @Column(name = "responsable", length = 100)
    private String responsable;
    @Column(name = "niveleducativo", length = 50)
    private String niveleducativo;
    @Column(name = "asistio")
    private Integer asistio;
    @Column(name = "tratamientos", length = 45)
    private String tratamientos;
    @Column(name = "depa_domicilio")
    private Integer depaDomicilio;
    @Column(name = "mun_domicilio", length = 45)
    private Integer munDomicilio;
    //espacio para agregar los nombres y apellidos
    @Column(name = "nombre1", length = 50)
    private String nombre1;
    @Column(name = "nombre2", length = 50, nullable = true)
    private String nombre2;
    @Column(name = "apellido1", length = 50)
    private String apellido1;
    @Column(name="semanas",nullable=true)
    private int semanas;
    public int getSemanas() {
		return semanas;
	}

	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "apellido2", length = 50, nullable = true)
    private String apellido2;
    //fin
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdpac")
    private Collection<Cita> citaCollection;
    @JoinColumn(name = "idestadocivil", referencedColumnName = "idEstadoCivil", nullable = true)
    @ManyToOne(optional = false)
    private EstadoCivil idestadocivil;
    @JoinColumn(name = "profecion_idprofecion", referencedColumnName = "idprofecion", nullable = true)
    @ManyToOne(optional = false)
    private Profecion profecionIdprofecion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdpac")
    private Collection<Expediente> expedienteCollection;

    public Paciente() {
    }

    public Paciente(Integer idpac) {
        this.idpac = idpac;
    }

    public Integer getIdpac() {
        return idpac;
    }

    public void setIdpac(Integer idpac) {
        this.idpac = idpac;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoDom() {
        return telefonoDom;
    }

    public void setTelefonoDom(String telefonoDom) {
        this.telefonoDom = telefonoDom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Boolean getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Boolean embarazo) {
        this.embarazo = embarazo;
    }

    public String getTiempoembarazo() {
        return tiempoembarazo;
    }

    public void setTiempoembarazo(String tiempoembarazo) {
        this.tiempoembarazo = tiempoembarazo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getNiveleducativo() {
        return niveleducativo;
    }

    public void setNiveleducativo(String niveleducativo) {
        this.niveleducativo = niveleducativo;
    }

    public Integer getAsistio() {
        return asistio;
    }

    public void setAsistio(Integer asistio) {
        this.asistio = asistio;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Integer getDepaDomicilio() {
        return depaDomicilio;
    }

    public void setDepaDomicilio(Integer depaDomicilio) {
        this.depaDomicilio = depaDomicilio;
    }

    public Integer getMunDomicilio() {
        return munDomicilio;
    }

    public void setMunDomicilio(Integer munDomicilio) {
        this.munDomicilio = munDomicilio;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    public EstadoCivil getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(EstadoCivil idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public Profecion getProfecionIdprofecion() {
        return profecionIdprofecion;
    }

    public void setProfecionIdprofecion(Profecion profecionIdprofecion) {
        this.profecionIdprofecion = profecionIdprofecion;
    }

    @XmlTransient
    public Collection<Expediente> getExpedienteCollection() {
        return expedienteCollection;
    }

    public void setExpedienteCollection(Collection<Expediente> expedienteCollection) {
        this.expedienteCollection = expedienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpac != null ? idpac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpac == null && other.idpac != null) || (this.idpac != null && !this.idpac.equals(other.idpac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Paciente[ idpac=" + idpac + " ]";
    }
    
}
