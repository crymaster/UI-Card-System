/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Form;

import Client.Controller.BaseController;
import Client.Controller.LoggingController;
import Client.Controller.MainController;
import Client.Entity.Draft;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Son
 */
public class MainMenu extends javax.swing.JFrame {

    private LoggingController logController;
    private MainController mainController;
    private EntryProcess entryProcess;
    private UIProcess uiProcess;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        btnDelete.setEnabled(false);
        btnLoad.setEnabled(false);
        setLocationRelativeTo(this);
    }

    public LoggingController getLogController() {
        return logController;
    }

    public void setLogController(LoggingController logController) {
        this.logController = logController;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    void showMessage(String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, "Message", messageType);
    }

    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) draftTable.getModel();
        //remove all rows from table
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        /*Load data to table model*/
        this.mainController.load();
        if (draftTable.getSelectedRow() == -1) {
            btnDelete.setEnabled(false);
            btnLoad.setEnabled(false);
        }
        //Set label according to current employee
        HashMap data = BaseController.getSession().getCurrentEmployee();
        lbName.setText((String) data.get("empName"));
        lbCentreName.setText((String) data.get("centreName") + " Centre");
        lbEmail.setText((String) data.get("email"));
    }

    public void renderDraft(ArrayList<Draft> drafts) {
        /*Add information to table model*/
        DefaultTableModel model = (DefaultTableModel) draftTable.getModel();
        Vector row;
        for (int i = 0; i < drafts.size(); i++) {
            row = new Vector();
            row.add(drafts.get(i).getDraftId());
            row.add(drafts.get(i).getFirstName());
            row.add(drafts.get(i).getMiddleName());
            row.add(drafts.get(i).getLastName());
            model.addRow(row);
        }
        draftTable.setModel(model);
    }

    public void toUIProcess(HashMap data) {
        entryProcess.dispose();
        uiProcess = new UIProcess(this, true);
        uiProcess.setData(data);
        new Thread(new Runnable() {
            @Override
            public void run() {
                uiProcess.setVisible(true);
            }
        }).start();
    }

    public void finishUIProcess() {
        uiProcess.dispose();
        DefaultTableModel model = (DefaultTableModel) custTable.getModel();
        Vector row = new Vector();
        HashMap data = uiProcess.getCustomer();
        row.add(data.get("uiCode"));
        row.add(data.get("firstName"));
        row.add(data.get("midName"));
        row.add(data.get("lastName"));
        Date dob = (Date) data.get("dob");
        String dobString = "" + dob.getDate() + "/" + (dob.getMonth() + 1) + "/" + (dob.getYear() + 1900);
        row.add(dobString);
        model.addRow(row);
        custTable.setModel(model);
    }

    void updateProfile() {
        if (!(boolean) BaseController.getSession().getCurrentEmployee().get("state")) {
            //init and load data to UpdateProfile
            UpdateProfile updateProfile = new UpdateProfile(this, true);
            updateProfile.setData(BaseController.getSession().getCurrentEmployee());
            updateProfile.refresh();
            updateProfile.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        lbCentreName = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        draftTable = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("UICS Client Menu");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnProfile.setText("Profile");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lbCentreName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCentreName.setText("Centre Name");

        lbName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbName.setText("User Name");

        lbEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbEmail.setText("Email");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/image/employee.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCentreName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCentreName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEmail)
                .addGap(18, 18, 18)
                .addComponent(btnProfile)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addContainerGap())
        );

        jTabbedPane1.setName(""); // NOI18N

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 219));

        btnRegister.setText("Register New Card");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UICode", "First Name", "Middle Name", "Last Name", "DOB"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(custTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnRegister)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Main", jPanel3);

        draftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Middle Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        draftTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(draftTable);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(109, 109, 109)
                .addComponent(btnReload)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnLoad)
                    .addComponent(btnReload))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Draft", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.getLogController().logOut();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        entryProcess = new EntryProcess(this, true);
        entryProcess.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void draftTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftTableMouseClicked
        // TODO add your handling code here:
        btnDelete.setEnabled(true);
        btnLoad.setEnabled(true);
    }//GEN-LAST:event_draftTableMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this?", "Confirm Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        //choose "Yes" = 0
        if (result == 0) {
            //Get draftID from table to delete
            DefaultTableModel model = (DefaultTableModel) draftTable.getModel();
            int draftID = (Integer) model.getValueAt(draftTable.getSelectedRow(), 0);
            this.getMainController().delete(draftID);
            this.refresh();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // get selected row on table and load a new entry process with saved info
        entryProcess = new EntryProcess(this, true);
        int id = Integer.parseInt(draftTable.getValueAt(draftTable.getSelectedRow(), 0).toString());
        entryProcess.setData(mainController.getServiceManager().getDraftManagerService().get(id));
        entryProcess.refresh();
        entryProcess.setVisible(true);
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // init anad load data to UpdateProfile
        UpdateProfile updateProfile = new UpdateProfile(this, true);
        updateProfile.setData(BaseController.getSession().getCurrentEmployee());
        updateProfile.refresh();
        updateProfile.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReload;
    private javax.swing.JTable custTable;
    private javax.swing.JTable draftTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbCentreName;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
