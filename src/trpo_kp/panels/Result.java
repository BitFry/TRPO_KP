/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Result.java
 *
 * Created on 30.04.2012, 14:43:27
 */
package trpo_kp.panels;

import java.awt.Container;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import trpo_kp.control.OrganisationControl;
import trpo_kp.tables.Docrow;
import trpo_kp.tables.Warrant;
import trpo_kp.tables.Warrownumber;

/**
 *
 * @author Администратор
 */
public class Result extends javax.swing.JPanel {

    /** Creates new form Result */
    public Result() {
        initComponents();
    }

    public Result(javax.swing.JDialog root) {
        initComponents();
        this.root = root;
    }
    
    public void updateInformation() {
        if (info == null) {
            return;
        }
        if (info.getOrg() == null
                || info.getEmployee() == null
                || info.getPaymentorder() == null
                || info.getRowData() == null) {
            return;
        }
        orgDesc.setText(info.getOrg().getName());
        INN.setText(info.getOrg().getInn());
        KPP.setText(info.getOrg().getKpp());
        adress.setText(info.getOrg().getAdress());
        this.setCurrDate(java.util.Calendar.getInstance().getTime());
        issueDate.setText(currDate.getDate() + "/"
                + currDate.getMonth() + "/"
                + (currDate.getYear() + 1900));
        Date dvalidUntil = (Date) currDate.clone();
        dvalidUntil.setDate(dvalidUntil.getDate() + 10);
        
        validUntil.setText(dvalidUntil.getDate() + "/"
                + dvalidUntil.getMonth() + "/"
                + (dvalidUntil.getYear() + 1900));
        
        po.setText("№: " + info.getPaymentorder().getId()
                + ", Дата:" + info.getPaymentorder().getPodate().getDate() + "/"
                + info.getPaymentorder().getPodate().getMonth() + "/"
                + (info.getPaymentorder().getPodate().getYear() + 1900)
                + ", Сумма:" + info.getPaymentorder().getAmount());
        DefaultTableModel dtm = (DefaultTableModel) products.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        Vector rowData = info.getRowData();
        for (Object object : rowData) {
            dtm.addRow((Vector) object);
        }
        empl.setText("Фамилия, и.о.: " + info.getEmployee().getName()
                + ", должность:" + info.getEmployee().getPost()
                + ", подразделение:" + info.getEmployee().getDepId().getName());
        passport.setText("серия: " + info.getEmployee().getSeries()
                + ", номер:" + info.getEmployee().getPnumber()
                + ", дата выдачи:"
                + info.getEmployee().getIssueDate().getDate() + "/"
                + info.getEmployee().getIssueDate().getMonth() + "/"
                + (info.getEmployee().getIssueDate().getYear() + 1900)
                + ", кем выдан:" + info.getEmployee().getIssuedBy());
        sup.setText(info.getPaymentorder().getBillId().getSupId().getName());
        chief.setText(info.getOrg().getDirector());
        accauntant.setText(info.getOrg().getChiefAccountant());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        products = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        orgDesc = new javax.swing.JTextField();
        INN = new javax.swing.JTextField();
        KPP = new javax.swing.JTextField();
        adress = new javax.swing.JTextField();
        issueDate = new javax.swing.JTextField();
        validUntil = new javax.swing.JTextField();
        po = new javax.swing.JTextField();
        empl = new javax.swing.JTextField();
        passport = new javax.swing.JTextField();
        sup = new javax.swing.JTextField();
        chief = new javax.swing.JTextField();
        accauntant = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getResourceMap(Result.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Название", "Ед.Изм.", "Цена", "НДС", "Акциз", "Кол-во", "Стоимость", "НДС", "Акциз", "с налогами", "Статус"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        products.setName("products"); // NOI18N
        products.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(products);
        products.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("products.columnModel.title0")); // NOI18N
        products.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("products.columnModel.title1")); // NOI18N
        products.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("products.columnModel.title2")); // NOI18N
        products.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("products.columnModel.title3")); // NOI18N
        products.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("products.columnModel.title4")); // NOI18N
        products.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("products.columnModel.title5")); // NOI18N
        products.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("products.columnModel.title6")); // NOI18N
        products.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("products.columnModel.title7")); // NOI18N
        products.getColumnModel().getColumn(8).setHeaderValue(resourceMap.getString("products.columnModel.title8")); // NOI18N
        products.getColumnModel().getColumn(9).setHeaderValue(resourceMap.getString("products.columnModel.title9")); // NOI18N
        products.getColumnModel().getColumn(10).setHeaderValue(resourceMap.getString("products.columnModel.title10")); // NOI18N
        products.getColumnModel().getColumn(11).setHeaderValue(resourceMap.getString("products.columnModel.title11")); // NOI18N

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        orgDesc.setEditable(false);
        orgDesc.setText(resourceMap.getString("orgDesc.text")); // NOI18N
        orgDesc.setName("orgDesc"); // NOI18N

        INN.setEditable(false);
        INN.setText(resourceMap.getString("INN.text")); // NOI18N
        INN.setName("INN"); // NOI18N

        KPP.setEditable(false);
        KPP.setText(resourceMap.getString("KPP.text")); // NOI18N
        KPP.setName("KPP"); // NOI18N

        adress.setEditable(false);
        adress.setText(resourceMap.getString("adress.text")); // NOI18N
        adress.setName("adress"); // NOI18N

        issueDate.setEditable(false);
        issueDate.setText(resourceMap.getString("issueDate.text")); // NOI18N
        issueDate.setName("issueDate"); // NOI18N

        validUntil.setEditable(false);
        validUntil.setText(resourceMap.getString("validUntil.text")); // NOI18N
        validUntil.setName("validUntil"); // NOI18N

        po.setEditable(false);
        po.setText(resourceMap.getString("po.text")); // NOI18N
        po.setName("po"); // NOI18N

        empl.setEditable(false);
        empl.setText(resourceMap.getString("empl.text")); // NOI18N
        empl.setName("empl"); // NOI18N

        passport.setEditable(false);
        passport.setText(resourceMap.getString("passport.text")); // NOI18N
        passport.setName("passport"); // NOI18N

        sup.setEditable(false);
        sup.setText(resourceMap.getString("sup.text")); // NOI18N
        sup.setName("sup"); // NOI18N

        chief.setEditable(false);
        chief.setText(resourceMap.getString("chief.text")); // NOI18N
        chief.setName("chief"); // NOI18N

        accauntant.setEditable(false);
        accauntant.setText(resourceMap.getString("accauntant.text")); // NOI18N
        accauntant.setName("accauntant"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(issueDate, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(validUntil, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(po, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(empl, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(passport, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(sup, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(INN, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(KPP, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(adress, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(orgDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(309, 309, 309))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(chief, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(accauntant, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(82, 82, 82)
                .addComponent(jButton2)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(orgDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(INN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(KPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(validUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(empl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(passport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(chief, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(accauntant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    root.dispose();
}//GEN-LAST:event_jButton2ActionPerformed
    
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (info.getOrg() == null
            || info.getEmployee() == null
            || info.getPaymentorder() == null
            || info.getRowData() == null) {
        return;
    }
    Warrant warrant = new Warrant();
    warrant.setEmplId(info.getEmployee());
    warrant.setOrderId(info.getPaymentorder());
    warrant.setIssueDate(currDate);
    warrant.setDocrowList(info.getPaymentorder().getDocrowList());
    List<Docrow> docrowList = warrant.getDocrowList();
    int n = 0;
    for (Docrow docrow : docrowList) {
        Warrownumber wrnmbr = new Warrownumber();
        wrnmbr.setRowId(docrow);
        wrnmbr.setRownumber(new BigInteger("" + n++));
        docrow.setWarrownumber(wrnmbr);
        docrow.setWarId(warrant);
        docrow.setStatus(BigInteger.TEN);
    }
    EntityManager entityManager = OrganisationControl.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(warrant);
    for (Docrow docrow : docrowList) {
        entityManager.merge(docrow);
    }
    entityManager.getTransaction().commit();
    entityManager.close();
    root.dispose();
    JDialog parent = (JDialog)root.getParent();
    parent.dispose();
}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField INN;
    private javax.swing.JTextField KPP;
    private javax.swing.JTextField accauntant;
    private javax.swing.JTextField adress;
    private javax.swing.JTextField chief;
    private javax.swing.JTextField empl;
    private javax.swing.JTextField issueDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField orgDesc;
    private javax.swing.JTextField passport;
    private javax.swing.JTextField po;
    private javax.swing.JTable products;
    private javax.swing.JTextField sup;
    private javax.swing.JTextField validUntil;
    // End of variables declaration//GEN-END:variables
    private resultInfo info;

    /**
     * Get the value of info
     *
     * @return the value of info
     */
    public resultInfo getInfo() {
        return info;
    }

    /**
     * Set the value of info
     *
     * @param info new value of info
     */
    public void setInfo(resultInfo info) {
        this.info = info;
    }
    private JDialog root;
    private Date currDate;

    /**
     * Get the value of currDate
     *
     * @return the value of currDate
     */
    public Date getCurrDate() {
        return currDate;
    }

    /**
     * Set the value of currDate
     *
     * @param currDate new value of currDate
     */
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }
}
