/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * documentAdd.java
 *
 * Created on 29.04.2012, 16:07:35
 */
package trpo_kp.panels;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import trpo_kp.control.OrganisationControl;
import trpo_kp.tables.Agency;
import trpo_kp.tables.Department;
import trpo_kp.tables.Docrow;
import trpo_kp.tables.Employee;
import trpo_kp.tables.Paymentorder;

/**
 *
 * @author Администратор
 */
public class WarrantRegister extends javax.swing.JPanel {

    /** Creates new form documentAdd */
    public WarrantRegister() {
        initComponents();
        initComboBoxes();
    }
    
    /** Creates new form documentAdd */
    public WarrantRegister(JDialog root) {
        this.root = root;
        initComponents();
        initComboBoxes();
    }

    private void initComboBoxes(){
        organisation = OrganisationControl.getOrganisation();
        List<Department> departments = OrganisationControl.getDepartments();
        List<Paymentorder> paymentOrders = OrganisationControl.getFreePaymentOrders();
        if (departments != null) {
            for (Department department1 : departments) {
                depList.addItem(department1.getName());
            }
        }
        if (paymentOrders != null) {
            for (Paymentorder paymentorderl : paymentOrders) {
                paymentOrderList.addItem(/*"№ " + */paymentorderl.getId()/* + " сумма " + paymentorder.getAmount()*/);
            }
        }
        /*
         * @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PaymentorderSeq")
         * @SequenceGenerator(name="PaymentorderSeq", sequenceName="PAYMENTORDER_SEQ", initialValue=1000, allocationSize=1)
         */
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        employeeList = new javax.swing.JComboBox();
        paymentOrderList = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        depList = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getResourceMap(WarrantRegister.class);
        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        employeeList.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        employeeList.setName("employeeList"); // NOI18N
        employeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeListActionPerformed(evt);
            }
        });

        paymentOrderList.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        paymentOrderList.setName("paymentOrderList"); // NOI18N
        paymentOrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentOrderListActionPerformed(evt);
            }
        });

        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setName("jLabel4"); // NOI18N

        depList.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        depList.setName("depList"); // NOI18N
        depList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depListActionPerformed(evt);
            }
        });

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Название", "Ед.изм.", "Цена", "НДС", "Акциз", "Кол-во", "Стоимость", "НДС", "Акциз", "с налогами", "Статус"
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
        jTable1.setName("jTable1"); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
        jTable1.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
        jTable1.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
        jTable1.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1.columnModel.title6")); // NOI18N
        jTable1.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTable1.columnModel.title7")); // NOI18N
        jTable1.getColumnModel().getColumn(8).setHeaderValue(resourceMap.getString("jTable1.columnModel.title8")); // NOI18N
        jTable1.getColumnModel().getColumn(9).setHeaderValue(resourceMap.getString("jTable1.columnModel.title9")); // NOI18N
        jTable1.getColumnModel().getColumn(10).setHeaderValue(resourceMap.getString("jTable1.columnModel.title10")); // NOI18N
        jTable1.getColumnModel().getColumn(11).setHeaderValue(resourceMap.getString("jTable1.columnModel.title11")); // NOI18N

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel8.setFont(resourceMap.getFont("jLabel8.font")); // NOI18N
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        confirm.setText(resourceMap.getString("confirm.text")); // NOI18N
        confirm.setName("confirm"); // NOI18N
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(employeeList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(paymentOrderList, 0, 134, Short.MAX_VALUE)
                                    .addComponent(depList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(520, Short.MAX_VALUE)
                        .addComponent(confirm)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(depList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(employeeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(paymentOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(jButton2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void paymentOrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentOrderListActionPerformed
    if (((JComboBox) evt.getSource()).getSelectedItem() == null) {
        return;
    }
    String text = ((JComboBox) evt.getSource()).getSelectedItem().toString();
    //System.out.println(((JComboBox) evt.getSource()).getSelectedItem().toString());
    Paymentorder po = OrganisationControl.findPaymentOrder(new BigDecimal(text));
    this.setPaymentorder(po);
    fillProductTable(po.getDocrowList(), jTable1.getModel());
}//GEN-LAST:event_paymentOrderListActionPerformed

private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
    trpo_kp.dialogs.Result res = new trpo_kp.dialogs.Result(null, true);
    resultInfo info = new resultInfo(organisation, 
            paymentorder, 
            employee, 
            ((DefaultTableModel)jTable1.getModel()).
            getDataVector());
    res.setInfo(info);
    res.updateInformation();
    res.setVisible(true);
}//GEN-LAST:event_confirmActionPerformed

private void depListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depListActionPerformed
    if (((JComboBox) evt.getSource()).getSelectedItem() == null) {
        return;
    }
    String text = ((JComboBox) evt.getSource()).getSelectedItem().toString();
    //System.out.println(((JComboBox) evt.getSource()).getSelectedItem().toString());
    Department findDepartment = OrganisationControl.findDepartment(text);
    this.setDepartment(findDepartment);
    List<Employee> employeeList1 = findDepartment.getEmployeeList();
    employeeList.removeAllItems();
    for (Employee employee1 : employeeList1) {
        employeeList.addItem(employee1.getName());
    }
}//GEN-LAST:event_depListActionPerformed

private void employeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeListActionPerformed
    if (((JComboBox) evt.getSource()).getSelectedItem() == null) {
        return;
    }
    String text = ((JComboBox) evt.getSource()).getSelectedItem().toString();
    setEmployee(getDepartment().findEmployee(text));
    //System.out.println(((JComboBox) evt.getSource()).getSelectedItem().toString());
}//GEN-LAST:event_employeeListActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    root.dispose();
}//GEN-LAST:event_jButton2ActionPerformed
private void fillProductTable(List<Docrow> docrowList, TableModel tm){
    DefaultTableModel dtm = (DefaultTableModel) tm;
    while (dtm.getRowCount() > 0) {
        dtm.removeRow(0);
    }
    Vector rowVec;
    int n = 1, totalCount = 0;
    double pPrice = 0, pnds = 0, pexcise = 0, pt = 0;
    for (Docrow docrow : docrowList) {
        rowVec = new Vector();
        String name = docrow.getProductId().getName();
        String uint = docrow.getProductId().getUint();
        double price = docrow.getProductId().getPrice();
        double nds = docrow.getProductId().getNds();
        double excise = docrow.getProductId().getExcise();
        long count = docrow.getCount().longValue();
        double tmp = price*count;
        rowVec.add(n++);
        rowVec.add(name);
        rowVec.add(uint);
        rowVec.add(price);
        rowVec.add(nds);
        rowVec.add(excise);
        rowVec.add(count);
        rowVec.add(tmp);
        rowVec.add(tmp*nds);
        rowVec.add(tmp*excise);
        rowVec.add(tmp + tmp*nds + tmp*excise);
        switch(docrow.getStatus().intValue()){
            case 0:
                rowVec.add("Не оплачено");
                break;
            case 1:
                rowVec.add("Оплачено");
                break;
            case 10:
                rowVec.add("Получено");
                break;
        }
        dtm.addRow(rowVec);
        totalCount += count;
        pPrice += tmp;
        pnds += tmp*nds;
        pexcise += tmp*excise;
        pt += (tmp + tmp*nds + tmp*excise);
    }
    rowVec = new Vector();
    rowVec.add(n++);
    rowVec.add("Всего:");
    rowVec.add(null);
    rowVec.add(null);
    rowVec.add(null);
    rowVec.add(null);
    rowVec.add(totalCount);
    rowVec.add(pPrice);
    rowVec.add(pnds);
    rowVec.add(pexcise);
    rowVec.add(pt);
    dtm.addRow(rowVec);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirm;
    private javax.swing.JComboBox depList;
    private javax.swing.JComboBox employeeList;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox paymentOrderList;
    // End of variables declaration//GEN-END:variables

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setOrg(Agency org) {
        this.organisation = org;
    }

    public void setPaymentorder(Paymentorder paymentorder) {
        this.paymentorder = paymentorder;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Agency getOrg() {
        return organisation;
    }

    public Paymentorder getPaymentorder() {
        return paymentorder;
    }
    private Agency organisation = null;
    private Paymentorder paymentorder = null;
    private Employee employee = null;
    private Department department = null;
    private JDialog root;

    /**
     * Get the value of root
     *
     * @return the value of root
     */
    public JDialog getRoot() {
        return root;
    }

    /**
     * Set the value of root
     *
     * @param root new value of root
     */
    public void setRoot(JDialog root) {
        this.root = root;
    }

}
