/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Form;

import java.util.HashMap;

/**
 *
 * @author Son
 */
public class UIProcess extends javax.swing.JDialog {

    private HashMap customer;

    /**
     * Creates new form UIProcess
     */
    public UIProcess(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    public void setData(HashMap data) {
        customer = data;
        lbCode.setText((String) customer.get("uiCode"));
    }

    public HashMap getCustomer() {
        return customer;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        thumbGroup = new javax.swing.ButtonGroup();
        fingerGroup = new javax.swing.ButtonGroup();
        retinaGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCode = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ckThumbYes = new javax.swing.JRadioButton();
        ckThumbNo = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPersonal = new javax.swing.JTextArea();
        txtThumb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ckFingerYes = new javax.swing.JRadioButton();
        ckFingerNo = new javax.swing.JRadioButton();
        txtFinger = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ckRetinaYes = new javax.swing.JRadioButton();
        ckRetinaNo = new javax.swing.JRadioButton();
        txtRetina = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("UI Process");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("UI Process");

        jLabel2.setText("Unique Code");

        lbCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCode.setText("Code in here");

        jLabel3.setText("Personal Detail");

        jLabel4.setText("Thumb Impression");

        thumbGroup.add(ckThumbYes);
        ckThumbYes.setSelected(true);
        ckThumbYes.setText("Yes");
        ckThumbYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckThumbYesActionPerformed(evt);
            }
        });

        thumbGroup.add(ckThumbNo);
        ckThumbNo.setText("No");
        ckThumbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckThumbNoActionPerformed(evt);
            }
        });

        txtPersonal.setColumns(20);
        txtPersonal.setRows(3);
        jScrollPane2.setViewportView(txtPersonal);

        txtThumb.setText("Reason");
        txtThumb.setEnabled(false);

        jLabel5.setText("Finger Prints");

        fingerGroup.add(ckFingerYes);
        ckFingerYes.setSelected(true);
        ckFingerYes.setText("Yes");
        ckFingerYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckFingerYesActionPerformed(evt);
            }
        });

        fingerGroup.add(ckFingerNo);
        ckFingerNo.setText("No");
        ckFingerNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckFingerNoActionPerformed(evt);
            }
        });

        txtFinger.setText("Reason");
        txtFinger.setEnabled(false);

        jLabel6.setText("Retina Scans");

        retinaGroup.add(ckRetinaYes);
        ckRetinaYes.setSelected(true);
        ckRetinaYes.setText("Yes");
        ckRetinaYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckRetinaYesActionPerformed(evt);
            }
        });

        retinaGroup.add(ckRetinaNo);
        ckRetinaNo.setText("No");
        ckRetinaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckRetinaNoActionPerformed(evt);
            }
        });

        txtRetina.setText("Reason");
        txtRetina.setEnabled(false);

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/image/Update.png"))); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(btnSend))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFinger)
                            .addComponent(lbCode)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ckThumbYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckThumbNo))
                            .addComponent(jScrollPane2)
                            .addComponent(txtThumb)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ckFingerYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckFingerNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ckRetinaYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckRetinaNo))
                            .addComponent(txtRetina))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbCode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ckThumbYes)
                    .addComponent(ckThumbNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ckFingerYes)
                    .addComponent(ckFingerNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFinger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ckRetinaYes)
                    .addComponent(ckRetinaNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRetina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSend)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckThumbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckThumbNoActionPerformed
        // TODO add your handling code here:
        if (ckThumbNo.isSelected()) {
            txtThumb.setEnabled(true);
        }
    }//GEN-LAST:event_ckThumbNoActionPerformed

    private void ckFingerNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckFingerNoActionPerformed
        // TODO add your handling code here:
        if (ckFingerNo.isSelected()) {
            txtFinger.setEnabled(true);
        }
    }//GEN-LAST:event_ckFingerNoActionPerformed

    private void ckRetinaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckRetinaNoActionPerformed
        // TODO add your handling code here:
        if (ckRetinaNo.isSelected()) {
            txtRetina.setEnabled(true);
        }
    }//GEN-LAST:event_ckRetinaNoActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        //Take all information in the form
        customer.put("personal", txtPersonal.getText());
        String health = (String)customer.get("health");
        boolean thumb;
        if (ckThumbYes.isSelected()) {
            thumb = true;
        } else {
            health += txtThumb.getText();
            thumb = false;
        }
        customer.put("thumb", thumb);
        boolean finger;
        if (ckFingerYes.isSelected()) {
            finger = true;
        } else {
            health += txtFinger.getText();
            finger = false;
        }
        customer.put("finger", finger);
        boolean retina;
        if (ckRetinaYes.isSelected()) {
            retina = true;
        } else {
            health += txtRetina.getText();
            retina = false;
        }
        customer.put("retina", retina);
        customer.put("health", health);
        //Send to server
        MainMenu menu = (MainMenu)this.getParent();
        menu.getMainController().send(customer);
    }//GEN-LAST:event_btnSendActionPerformed

    private void ckThumbYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckThumbYesActionPerformed
        // TODO add your handling code here:
        if (ckThumbYes.isSelected()) {
            txtThumb.setEnabled(false);
        }
    }//GEN-LAST:event_ckThumbYesActionPerformed

    private void ckFingerYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckFingerYesActionPerformed
        // TODO add your handling code here:
        if (ckFingerYes.isSelected()) {
            txtFinger.setEnabled(false);
        }
    }//GEN-LAST:event_ckFingerYesActionPerformed

    private void ckRetinaYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckRetinaYesActionPerformed
        // TODO add your handling code here:
        if (ckRetinaYes.isSelected()) {
            txtRetina.setEnabled(false);
        }
    }//GEN-LAST:event_ckRetinaYesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JRadioButton ckFingerNo;
    private javax.swing.JRadioButton ckFingerYes;
    private javax.swing.JRadioButton ckRetinaNo;
    private javax.swing.JRadioButton ckRetinaYes;
    private javax.swing.JRadioButton ckThumbNo;
    private javax.swing.JRadioButton ckThumbYes;
    private javax.swing.ButtonGroup fingerGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCode;
    private javax.swing.ButtonGroup retinaGroup;
    private javax.swing.ButtonGroup thumbGroup;
    private javax.swing.JTextField txtFinger;
    private javax.swing.JTextArea txtPersonal;
    private javax.swing.JTextField txtRetina;
    private javax.swing.JTextField txtThumb;
    // End of variables declaration//GEN-END:variables
}
