/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhav.doctorpatient.jaxrs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Madhav
 */
@Entity
@Table(name = "prescription_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionMaster.findAll", query = "SELECT p FROM PrescriptionMaster p"),
    @NamedQuery(name = "PrescriptionMaster.findByPatientId", query = "SELECT p FROM PrescriptionMaster p WHERE p.patientId = :patientId"),
    @NamedQuery(name = "PrescriptionMaster.findByPatientName", query = "SELECT p FROM PrescriptionMaster p WHERE p.patientName = :patientName"),
    @NamedQuery(name = "PrescriptionMaster.findByPatientContact", query = "SELECT p FROM PrescriptionMaster p WHERE p.patientContact = :patientContact")})
public class PrescriptionMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 85)
    @Column(name = "patient_name")
    private String patientName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_contact")
    private long patientContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<ResponseMaster> responseMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<PrescriptionDetails> prescriptionDetailsCollection;

    public PrescriptionMaster() {
    }

    public PrescriptionMaster(Integer patientId) {
        this.patientId = patientId;
    }

    public PrescriptionMaster(Integer patientId, String patientName, long patientContact) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientContact = patientContact;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public long getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(long patientContact) {
        this.patientContact = patientContact;
    }

    @XmlTransient
    public Collection<ResponseMaster> getResponseMasterCollection() {
        return responseMasterCollection;
    }

    public void setResponseMasterCollection(Collection<ResponseMaster> responseMasterCollection) {
        this.responseMasterCollection = responseMasterCollection;
    }

    @XmlTransient
    public Collection<PrescriptionDetails> getPrescriptionDetailsCollection() {
        return prescriptionDetailsCollection;
    }

    public void setPrescriptionDetailsCollection(Collection<PrescriptionDetails> prescriptionDetailsCollection) {
        this.prescriptionDetailsCollection = prescriptionDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionMaster)) {
            return false;
        }
        PrescriptionMaster other = (PrescriptionMaster) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madhav.doctorpatient.jaxrs.PrescriptionMaster[ patientId=" + patientId + " ]";
    }
    
}
