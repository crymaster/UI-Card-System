/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Form.Employee;

import Server.Entity.Employee;
import Server.Form.MainMenu;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author QUANGHUY
 */
public class UpdateEmp extends javax.swing.JDialog {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Employee emp;
    private Vector<Vector> centres;

    /**
     * Creates new form UpdateEmp
     */
    public UpdateEmp(java.awt.Frame parent, boolean modal, Vector centres) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setCentres(centres);
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void setCentres(Vector<Vector> centres) {
        this.centres = centres;
    }

    public void refresh() {
        loadCentres();
        txtEmpName.setText(emp.getEmpName());
        txtEmail.setText(emp.getEmail());
    }

    void loadCentres() {
        //load centre name to combobox
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < centres.size(); i++) {
            if (emp.getCentreCode().equals(centres.get(i).get(0).toString())) {
                model.setSelectedItem(centres.get(i).get(1) + "-" + centres.get(i).get(2));
            } else {
                model.addElement(centres.get(i).get(1) + "-" + centres.get(i).get(2));
            }
        }
        cbCentre.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmpName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        cbCentre = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Employee");
        setResizable(false);

        jLabel4.setText("Employee Name:");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/image/check.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Update Employee");

        jLabel6.setText("Password Confirmation:");

        jLabel3.setText("Email:");

        jLabel2.setText("Password:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/image/No.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel7.setText("Centre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnUpdate))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCentre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnCancel)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCentre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Get text form textfield
        String tempEmpName = txtEmpName.getText();
        String tempPassword = new String(txtPassword.getPassword());
        String tempPasswordConfirm = new String(txtPasswordConfirm.getPassword());
        String tempEmail = txtEmail.getText();

        //Check for empty fields
        if (tempEmpName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee Name cannot be empty !", "Message", JOptionPane.ERROR_MESSAGE);
            txtEmpName.requestFocus();
            return;
        }
        //Check email format
        if (!tempEmail.isEmpty()) {
            Pattern pattern = Pattern.compile(UpdateEmp.EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(tempEmail);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Email is not in valid form (Eg: abc@gmail.com)", "Message", JOptionPane.ERROR_MESSAGE);
                txtEmail.requestFocus();
                return;
            }
        }

        // Check that pw and pw confirmation match
        if (!tempPassword.equals(tempPasswordConfirm)) {
            JOptionPane.showMessageDialog(this, "Password and Password Confirmation do not match", "Message", JOptionPane.ERROR_MESSAGE);
            txtPasswordConfirm.requestFocus();
            return;
        }
        for(int i=0; i<centres.size(); i++){
            if(cbCentre.getSelectedItem().toString().equals(centres.get(i).get(1) + "-" + centres.get(i).get(2))){
                emp.setCentreCode(centres.get(i).get(0).toString());
            }
        }
        /*Update Employee*/
        if(!tempPassword.isEmpty()){
            emp.setPassword(tempPassword);
        }
        emp.setEmpName(tempEmpName);
        emp.setEmail(tempEmail);
        MainMenu mainMenu = (MainMenu) this.getParent();
        mainMenu.getEmpController().update(emp);
        /*Reload main menu*/
        mainMenu.refresh();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbCentre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    // End of variables declaration//GEN-END:variables
}
