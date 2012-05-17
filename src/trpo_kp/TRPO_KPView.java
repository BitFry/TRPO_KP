/*
 * TRPO_KPView.java
 */

package trpo_kp;

import javax.swing.event.MenuEvent;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuListener;
import trpo_kp.dialogs.CreateBill;
import trpo_kp.dialogs.CreatePP;
import trpo_kp.dialogs.WarrantRegister;
import trpo_kp.dialogs.WarrantSumInclTaxes;

/**
 * The application's main frame.
 */
public class TRPO_KPView extends FrameView {

    public TRPO_KPView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TRPO_KPApp.getApplication().getMainFrame();
            aboutBox = new TRPO_KPAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TRPO_KPApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getResourceMap(TRPO_KPView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getActionMap(TRPO_KPView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
        });
        menuBar.add(jMenu3);

        jMenu4.setText(resourceMap.getString("jMenu4.text")); // NOI18N
        jMenu4.setName("jMenu4"); // NOI18N
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenu4.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu4MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        menuBar.add(jMenu4);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
this.getFrame().setJMenuBar(Accountant);
this.getFrame().getJMenuBar().revalidate();
}//GEN-LAST:event_jMenu3MenuSelected

private void jMenu4MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu4MenuKeyPressed

}//GEN-LAST:event_jMenu4MenuKeyPressed

private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
this.getFrame().setJMenuBar(chiefAccountant);
this.getFrame().getJMenuBar().revalidate();
}//GEN-LAST:event_jMenu4MenuSelected

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private JMenuBar chiefAccountant = createChiefAccountantMenuBar();;
    private JMenuBar Accountant = createAccountantMenuBar();
    
    private JMenuBar createChiefAccountantMenuBar(){
        JMenu fileMenu1 = new JMenu("Файл");
        JMenuItem exitMenuItem1 = new JMenuItem();
        JMenuItem jMenuItem4 = new JMenuItem(new ChangeRoleAction("Смена роли"));
        
        ActionMap actionMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getActionMap(TRPO_KPView.class, this);
        exitMenuItem1.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem1.setName("exitMenuItem"); // NOI18N
        fileMenu1.add(jMenuItem4);
        fileMenu1.add(exitMenuItem1);
        
        JMenu jMenu = new JMenu("Регистрация доверенности");
        jMenu.addMenuListener(new MenuListener() {

            public void menuSelected(MenuEvent e) {
                warRegMenuSelected(e);
            }

            public void menuDeselected(MenuEvent e) {
            }

            public void menuCanceled(MenuEvent e) {
            }
        });
        JMenu jMenu1 = new JMenu("Поиск");
        JMenuItem jMenuItem = new JMenuItem("Подразделение с максимальной суммой доверенностей");
        JMenuItem jMenuItem2 = new JMenuItem("Подразделение с максимальной суммой счетов, оплаченных полностью");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem);
        JMenu jMenu2 = new JMenu("Вычисление");
        JMenuItem jMenuItem1 = new JMenuItem("Сумма НДС для ставки и продавца");
        JMenuItem jMenuItem3 = new JMenuItem("Сумма НДС для ставки с детализацией продавцов");
        jMenu2.add(jMenuItem1);
        jMenu2.add(jMenuItem3);
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(fileMenu1);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        return jMenuBar;
    }
    
    private JMenuBar createAccountantMenuBar() {
        JMenu fileMenu1 = new JMenu("Файл");
        JMenuItem exitMenuItem1 = new JMenuItem();
        JMenuItem jMenuItem6 = new JMenuItem(new ChangeRoleAction("Смена роли"));

        ActionMap actionMap = org.jdesktop.application.Application.getInstance(trpo_kp.TRPO_KPApp.class).getContext().getActionMap(TRPO_KPView.class, this);
        exitMenuItem1.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem1.setName("exitMenuItem"); // NOI18N
        fileMenu1.add(jMenuItem6);
        fileMenu1.add(exitMenuItem1);

        JMenu jMenu = new JMenu("Регистрация счёта");
	  jMenu.addMenuListener(new MenuListener() {

		public void menuSelected(MenuEvent e) {
		    createBill();
		    //throw new UnsupportedOperationException("Not supported yet.");
		}

		public void menuDeselected(MenuEvent e) {
		    //throw new UnsupportedOperationException("Not supported yet.");
		}

		public void menuCanceled(MenuEvent e) {
		    //throw new UnsupportedOperationException("Not supported yet.");
		}
	  });
        JMenu jMenu3 = new JMenu("Регистрация п/п");
	  jMenu3.addMenuListener(new MenuListener() {

		public void menuSelected(MenuEvent e) {
		    createPP();
		}

		public void menuDeselected(MenuEvent e) {
		    //throw new UnsupportedOperationException("Not supported yet.");
		}

		public void menuCanceled(MenuEvent e) {
		    //throw new UnsupportedOperationException("Not supported yet.");
		}
	  });
        JMenu jMenu2 = new JMenu("Вычисление");
        JMenuItem jMenuItem1 = new JMenuItem("Сумма счетов с учётом налогов для продавца");
        JMenuItem jMenuItem3 = new JMenuItem("Общая сумма счетов с учётом налогов с детализацией по продавцам");
        JMenuItem jMenuItem4 = new JMenuItem("Сумма доверенностей с учётом налогов для подразделения");
        jMenuItem4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                WarrantSumInclTaxesSelected(e);
            }
        });
        JMenuItem jMenuItem5 = new JMenuItem("Общая сумма доверенностей с учётом налогов с детализацией по подразделениям");
        jMenu2.add(jMenuItem1);
        jMenu2.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(fileMenu1);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu2);
        return jMenuBar;
    }
    
    class ChangeRoleAction extends AbstractAction{

        public ChangeRoleAction(String name) {
            super(name);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control D"));
        }

        public void actionPerformed(ActionEvent e) {
            getFrame().setJMenuBar(menuBar);
        }
    }

    private void warRegMenuSelected(javax.swing.event.MenuEvent evt) {
        trpo_kp.dialogs.WarrantRegister dialog = new WarrantRegister(null, true);
        dialog.setVisible(true);
    }
    private void WarrantSumInclTaxesSelected(ActionEvent e) {
        trpo_kp.dialogs.WarrantSumInclTaxes dialog = new WarrantSumInclTaxes(null, true);
        dialog.setVisible(true);
    }
    private void createBill() {
        //trpo_kp.dialogs.WarrantSumInclTaxes dialog = new WarrantSumInclTaxes(null, true);
	  trpo_kp.dialogs.CreateBill dialog = new CreateBill(null, true);
        dialog.setVisible(true);
    }
    private void createPP() {
        //trpo_kp.dialogs.WarrantSumInclTaxes dialog = new WarrantSumInclTaxes(null, true);
	  trpo_kp.dialogs.CreatePP dialog = new CreatePP(null, true);
        dialog.setVisible(true);
    }
}
