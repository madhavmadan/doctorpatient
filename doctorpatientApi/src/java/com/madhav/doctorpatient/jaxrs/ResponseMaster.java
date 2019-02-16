/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhav.doctorpatient.jaxrs;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Madhav
 */
@Entity
@Table(name = "response_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponseMaster.findAll", query = "SELECT r FROM ResponseMaster r"),
    @NamedQuery(name = "ResponseMaster.findByResponseId", query = "SELECT r FROM ResponseMaster r WHERE r.responseId = :responseId"),
    @NamedQuery(name = "ResponseMaster.findByCreatedOn", query = "SELECT r FROM ResponseMaster r WHERE r.createdOn = :createdOn")})
public class ResponseMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "response_id")
    private Integer responseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private PrescriptionMaster patientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responseId")
    private Collection<ResponseDetails> responseDetailsCollection;

    public ResponseMaster() {
    }

    public ResponseMaster(Integer responseId) {
        this.responseId = responseId;
    }

    public ResponseMaster(Integer responseId, Date createdOn) {
        this.responseId = responseId;
        this.createdOn = createdOn;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public PrescriptionMaster getPatientId() {
        return patientId;
    }

    public void setPatientId(PrescriptionMaster patientId) {
        this.patientId = patientId;
    }

    @XmlTransient
    public Collection<ResponseDetails> getResponseDetailsCollection() {
        return responseDetailsCollection;
    }

    public void setResponseDetailsCollection(Collection<ResponseDetails> responseDetailsCollection) {
        this.responseDetailsCollection = responseDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responseId != null ? responseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponseMaster)) {
            return false;
        }
        ResponseMaster other = (ResponseMaster) object;
        if ((this.responseId == null && other.responseId != null) || (this.responseId != null && !this.responseId.equals(other.responseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madhav.doctorpatient.jaxrs.ResponseMaster[ responseId=" + responseId + " ]";
    }
    
}
