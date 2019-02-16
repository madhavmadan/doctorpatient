/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhav.doctorpatient.jaxrs;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Madhav
 */
@Entity
@Table(name = "prescription_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionDetails.findAll", query = "SELECT p FROM PrescriptionDetails p"),
    @NamedQuery(name = "PrescriptionDetails.findById", query = "SELECT p FROM PrescriptionDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PrescriptionDetails.findByPrescriptionDate", query = "SELECT p FROM PrescriptionDetails p WHERE p.prescriptionDate = :prescriptionDate")})
public class PrescriptionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescription_date")
    @Temporal(TemporalType.DATE)
    private Date prescriptionDate;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private PrescriptionMaster patientId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prescriptionDetails")
    private ResponseDetails responseDetails;

    public PrescriptionDetails() {
    }

    public PrescriptionDetails(Integer id) {
        this.id = id;
    }

    public PrescriptionDetails(Integer id, Date prescriptionDate) {
        this.id = id;
        this.prescriptionDate = prescriptionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public PrescriptionMaster getPatientId() {
        return patientId;
    }

    public void setPatientId(PrescriptionMaster patientId) {
        this.patientId = patientId;
    }

    public ResponseDetails getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(ResponseDetails responseDetails) {
        this.responseDetails = responseDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionDetails)) {
            return false;
        }
        PrescriptionDetails other = (PrescriptionDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madhav.doctorpatient.jaxrs.PrescriptionDetails[ id=" + id + " ]";
    }
    
}
