/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreatePP.java
 *
 * Created on 18.05.2012, 0:27:04
 */
package trpo_kp.dialogs;

/**
 *
 * @author Mort
 */
public class CreatePP extends javax.swing.JDialog {

    /** Creates new form CreatePP */
    public CreatePP(java.awt.Frame parent, boolean modal) {
	  super(parent,"Создание платежного поручения", modal);
	  initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createPP1 = new trpo_kp.panels.CreatePP();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        createPP1.setName("createPP1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createPP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(createPP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	  /* Set the Nimbus look and feel */
	  //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	   * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	   */
	  try {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		    if ("Nimbus".equals(info.getName())) {
			  javax.swing.UIManager.setLookAndFeel(info.getClassName());
			  break;
		    }
		}
	  } catch (ClassNotFoundException ex) {
		java.util.logging.Logger.getLogger(CreatePP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (InstantiationException ex) {
		java.util.logging.Logger.getLogger(CreatePP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (IllegalAccessException ex) {
		java.util.logging.Logger.getLogger(CreatePP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(CreatePP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  }
	  //</editor-fold>

	  /* Create and display the dialog */
	  java.awt.EventQueue.invokeLater(new Runnable() {

		public void run() {
		    CreatePP dialog = new CreatePP(new javax.swing.JFrame(), true);
		    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

			  @Override
			  public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			  }
		    });
		    dialog.setVisible(true);
		}
	  });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private trpo_kp.panels.CreatePP createPP1;
    // End of variables declaration//GEN-END:variables
}