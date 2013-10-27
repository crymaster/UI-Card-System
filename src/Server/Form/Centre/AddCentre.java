/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Form.Centre;

import Server.Entity.Centre;
import Server.Form.MainMenu;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author QUANGHUY
 */
public class AddCentre extends javax.swing.JDialog {

    Vector<Vector> zone;

    /**
     * Creates new form AddCentre
     */
    public AddCentre(java.awt.Frame parent, boolean modal, Vector zone) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setZone(zone);
        loadZone();
    }

    public void setZone(Vector<Vector> zone) {
        this.zone = zone;
    }

    private void loadZone() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < zone.size(); i++) {
            model.addElement(zone.get(i).get(1));
        }
        cbZone.setModel(model);
        pinCode.setText((String) zone.get(0).get(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIP1 = new javax.swing.JTextField();
        txtCentreName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbZone = new javax.swing.JComboBox();
        pinCode = new javax.swing.JLabel();
        txtIP2 = new javax.swing.JTextField();
        txtIP3 = new javax.swing.JTextField();
        txtIP4 = new javax.swing.JTextField();
        spCode1 = new javax.swing.JSpinner();
        spCode2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Centre");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Location:");

        jLabel2.setText("Centre Name:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setText("Centre Code:");

        jLabel4.setText("IP Address:");

        jLabel7.setText("Zone");

        cbZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZoneActionPerformed(evt);
            }
        });

        pinCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pinCode.setText("01");

        spCode1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));

        spCode2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));

        jLabel1.setText("+");

        jLabel8.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIP1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIP2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIP3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIP4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pinCode)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbZone, javax.swing.GroupLayout.Alignment.LEADING, 0, 144, Short.MAX_VALUE)
                        .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCentreName, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pinCode)
                    .addComponent(spCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCentreName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get text form textfield
        String tempCentreName = txtCentreName.getText();
        String tempLocation = txtLocation.getText();
        String tempIP1 = txtIP1.getText();
        String tempIP2 = txtIP2.getText();
        String tempIP3 = txtIP3.getText();
        String tempIP4 = txtIP4.getText();
        String centreCode = pinCode.getText() + (int) spCode1.getValue() + (int) spCode2.getValue();

        if (tempCentreName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Centre Name cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtCentreName.requestFocus();
            return;
        }
        if (tempLocation.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The location of Centre cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtLocation.requestFocus();
            return;
        }
        if (tempIP1.isEmpty() || tempIP2.isEmpty() || tempIP3.isEmpty() || tempIP4.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The IP address of Centre cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtIP1.requestFocus();
            return;
        }
        String tempIP = "";
        try {
            int ip1 = Integer.parseInt(tempIP1);
            int ip2 = Integer.parseInt(tempIP2);
            int ip3 = Integer.parseInt(tempIP3);
            int ip4 = Integer.parseInt(tempIP4);
            if (ip1 < 0 || ip2 < 0 || ip3 < 0 || ip4 < 0
                    || ip1 > 255 || ip2 > 255 || ip3 > 255 || ip4 > 255) {
                JOptionPane.showMessageDialog(this, "The IP must be between 0 and 255", "Message", JOptionPane.ERROR_MESSAGE);
                txtIP1.requestFocus();
                return;
            }
            tempIP = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "The IP address of Centre must be sequence of numbers", "Message", JOptionPane.ERROR_MESSAGE);
            txtIP1.requestFocus();
            return;
        }

        /*Add new Centre*/
        Centre centre = new Centre();
        centre.setCentreName(tempCentreName);
        centre.setCentreCode(centreCode);
        centre.setPin_Code(pinCode.getText());
        centre.setLocation(tempLocation);
        centre.setIp(tempIP);
        MainMenu mainMenu = (MainMenu) this.getParent();
        mainMenu.getCentreController().add(centre);
        /*Reload main menu*/
        mainMenu.refresh();
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZoneActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < zone.size(); i++) {
            if ((cbZone.getSelectedItem()).toString().equals(zone.get(i).get(1).toString())) {
                pinCode.setText(zone.get(i).get(0).toString());
                break;
            }
        }
    }//GEN-LAST:event_cbZoneActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cbZone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel pinCode;
    private javax.swing.JSpinner spCode1;
    private javax.swing.JSpinner spCode2;
    private javax.swing.JTextField txtCentreName;
    private javax.swing.JTextField txtIP1;
    private javax.swing.JTextField txtIP2;
    private javax.swing.JTextField txtIP3;
    private javax.swing.JTextField txtIP4;
    private javax.swing.JTextField txtLocation;
    // End of variables declaration//GEN-END:variables
}
