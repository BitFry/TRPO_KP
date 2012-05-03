/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import trpo_kp.control.OrganisationControl;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "AGENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agency.findAll", query = "SELECT a FROM Agency a"),
    @NamedQuery(name = "Agency.findById", query = "SELECT a FROM Agency a WHERE a.id = :id"),
    @NamedQuery(name = "Agency.findByName", query = "SELECT a FROM Agency a WHERE a.name = :name"),
    @NamedQuery(name = "Agency.findByInn", query = "SELECT a FROM Agency a WHERE a.inn = :inn"),
    @NamedQuery(name = "Agency.findByKpp", query = "SELECT a FROM Agency a WHERE a.kpp = :kpp"),
    @NamedQuery(name = "Agency.findByAdress", query = "SELECT a FROM Agency a WHERE a.adress = :adress"),
    @NamedQuery(name = "Agency.findByRs", query = "SELECT a FROM Agency a WHERE a.rs = :rs"),
    @NamedQuery(name = "Agency.findByKs", query = "SELECT a FROM Agency a WHERE a.ks = :ks"),
    @NamedQuery(name = "Agency.findByBank", query = "SELECT a FROM Agency a WHERE a.bank = :bank"),
    @NamedQuery(name = "Agency.findByBik", query = "SELECT a FROM Agency a WHERE a.bik = :bik"),
    @NamedQuery(name = "Agency.findByPhone", query = "SELECT a FROM Agency a WHERE a.phone = :phone"),
    @NamedQuery(name = "Agency.findByEmail", query = "SELECT a FROM Agency a WHERE a.email = :email"),
    @NamedQuery(name = "Agency.findByWebsite", query = "SELECT a FROM Agency a WHERE a.website = :website"),
    @NamedQuery(name = "Agency.findByDirector", query = "SELECT a FROM Agency a WHERE a.director = :director"),
    @NamedQuery(name = "Agency.findByChiefAccountant", query = "SELECT a FROM Agency a WHERE a.chiefAccountant = :chiefAccountant")})
@SequenceGenerator(name="AgencySeq", sequenceName="AGENCY_SEQ", initialValue=1000, allocationSize=1)
public class Agency implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="AgencySeq")
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "INN")
    private String inn;
    @Basic(optional = false)
    @Column(name = "KPP")
    private String kpp;
    @Basic(optional = false)
    @Column(name = "ADRESS")
    private String adress;
    @Basic(optional = false)
    @Column(name = "RS")
    private String rs;
    @Basic(optional = false)
    @Column(name = "KS")
    private String ks;
    @Basic(optional = false)
    @Column(name = "BANK")
    private String bank;
    @Basic(optional = false)
    @Column(name = "BIK")
    private String bik;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEBSITE")
    private String website;
    @Basic(optional = false)
    @Column(name = "DIRECTOR")
    private String director;
    @Basic(optional = false)
    @Column(name = "CHIEF_ACCOUNTANT")
    private String chiefAccountant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supId", fetch = FetchType.LAZY)
    private List<Bill> billList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<Bill> billList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId", fetch = FetchType.LAZY)
    private List<Paymentorder> paymentorderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supId", fetch = FetchType.LAZY)
    private List<Product> productList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId", fetch = FetchType.LAZY)
    private List<Department> departmentList;

    public Agency() {
    }

    public Agency(BigDecimal id) {
        this.id = id;
    }

    public Agency(BigDecimal id, String name, String inn, String kpp, String adress, String rs, String ks, String bank, String bik, String phone, String email, String director, String chiefAccountant) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
        this.adress = adress;
        this.rs = rs;
        this.ks = ks;
        this.bank = bank;
        this.bik = bik;
        this.phone = phone;
        this.email = email;
        this.director = director;
        this.chiefAccountant = chiefAccountant;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        BigDecimal oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        String oldInn = this.inn;
        this.inn = inn;
        changeSupport.firePropertyChange("inn", oldInn, inn);
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        String oldKpp = this.kpp;
        this.kpp = kpp;
        changeSupport.firePropertyChange("kpp", oldKpp, kpp);
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        String oldAdress = this.adress;
        this.adress = adress;
        changeSupport.firePropertyChange("adress", oldAdress, adress);
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        String oldRs = this.rs;
        this.rs = rs;
        changeSupport.firePropertyChange("rs", oldRs, rs);
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        String oldKs = this.ks;
        this.ks = ks;
        changeSupport.firePropertyChange("ks", oldKs, ks);
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        String oldBank = this.bank;
        this.bank = bank;
        changeSupport.firePropertyChange("bank", oldBank, bank);
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        String oldBik = this.bik;
        this.bik = bik;
        changeSupport.firePropertyChange("bik", oldBik, bik);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        String oldWebsite = this.website;
        this.website = website;
        changeSupport.firePropertyChange("website", oldWebsite, website);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        String oldDirector = this.director;
        this.director = director;
        changeSupport.firePropertyChange("director", oldDirector, director);
    }

    public String getChiefAccountant() {
        return chiefAccountant;
    }

    public void setChiefAccountant(String chiefAccountant) {
        String oldChiefAccountant = this.chiefAccountant;
        this.chiefAccountant = chiefAccountant;
        changeSupport.firePropertyChange("chiefAccountant", oldChiefAccountant, chiefAccountant);
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @XmlTransient
    public List<Bill> getBillList1() {
        return billList1;
    }

    public void setBillList1(List<Bill> billList1) {
        this.billList1 = billList1;
    }

    @XmlTransient
    public List<Paymentorder> getPaymentorderList() {
        return paymentorderList;
    }

    public void setPaymentorderList(List<Paymentorder> paymentorderList) {
        this.paymentorderList = paymentorderList;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
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
        if (!(object instanceof Agency)) {
            return false;
        }
        Agency other = (Agency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Agency[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public Department findDepartment(String DepName){
        /*EntityManager em = OrganisationControl.getEntityManager();
        em.refresh(this);*/
        List<Department> lst = departmentList;
        for (Department department : lst) {
            if(department.getName().equals(DepName)){
                //em.close();
                return department;
            }
        }
        //em.close();
        return null;
    }
    public Paymentorder findPaymentOrder(BigDecimal Id){
        /*EntityManager em = OrganisationControl.getEntityManager();
        em.refresh(this);*/
        List<Paymentorder> lst = paymentorderList;
        for (Paymentorder paymentorder : lst) {
            if (paymentorder.getId().compareTo(Id) == 0) {
                return paymentorder;
            }
        }
        //em.close();
        return null;
    }
}
