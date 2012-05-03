/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "BILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByIssueDate", query = "SELECT b FROM Bill b WHERE b.issueDate = :issueDate")})
@SequenceGenerator(name="BillSeq", sequenceName="BILL_SEQ", initialValue=1000, allocationSize=1)
public class Bill implements Serializable {
    @Basic(optional = false)
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="BillSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SUP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency supId;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billId", fetch = FetchType.LAZY)
    private List<Docrow> docrowList;
    @OneToMany(mappedBy = "billId", fetch = FetchType.LAZY)
    private List<Paymentorder> paymentorderList;

    public Bill() {
    }

    public Bill(BigDecimal id) {
        this.id = id;
    }

    public Bill(BigDecimal id, Date issueDate) {
        this.id = id;
        this.issueDate = issueDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Agency getSupId() {
        return supId;
    }

    public void setSupId(Agency supId) {
        this.supId = supId;
    }

    public Agency getClientId() {
        return clientId;
    }

    public void setClientId(Agency clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<Docrow> getDocrowList() {
        return docrowList;
    }

    public void setDocrowList(List<Docrow> docrowList) {
        this.docrowList = docrowList;
    }

    @XmlTransient
    public List<Paymentorder> getPaymentorderList() {
        return paymentorderList;
    }

    public void setPaymentorderList(List<Paymentorder> paymentorderList) {
        this.paymentorderList = paymentorderList;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Bill[ id=" + id + " ]";
    }
    
}
