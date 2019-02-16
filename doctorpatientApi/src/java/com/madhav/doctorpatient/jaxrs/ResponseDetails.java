/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhav.doctorpatient.jaxrs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Madhav
 */
@Entity
@Table(name = "response_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponseDetails.findAll", query = "SELECT r FROM ResponseDetails r"),
    @NamedQuery(name = "ResponseDetails.findById", query = "SELECT r FROM ResponseDetails r WHERE r.id = :id"),
    @NamedQuery(name = "ResponseDetails.findByResponseText", query = "SELECT r FROM ResponseDetails r WHERE r.responseText = :responseText")})
public class ResponseDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "response_text")
    private String responseText;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PrescriptionDetails prescriptionDetails;
    @JoinColumn(name = "response_id", referencedColumnName = "response_id")
    @ManyToOne(optional = false)
    private ResponseMaster responseId;

    public ResponseDetails() {
    }

    public ResponseDetails(Integer id) {
        this.id = id;
    }

    public ResponseDetails(Integer id, String responseText) {
        this.id = id;
        this.responseText = responseText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public PrescriptionDetails getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(PrescriptionDetails prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public ResponseMaster getResponseId() {
        return responseId;
    }

    public void setResponseId(ResponseMaster responseId) {
        this.responseId = responseId;
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
        if (!(object instanceof ResponseDetails)) {
            return false;
        }
        ResponseDetails other = (ResponseDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.madhav.doctorpatient.jaxrs.ResponseDetails[ id=" + id + " ]";
    }
    
}
