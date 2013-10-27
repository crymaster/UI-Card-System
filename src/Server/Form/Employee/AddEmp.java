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
public class AddEmp extends javax.swing.JDialog {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Vector<Vector> centres;

    /**
     * Creates new form AddEmp
     */
    public AddEmp(java.awt.Frame parent, boolean modal, Vector centres) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setCentres(centres);
        loadCentres();
    }

    public void setCentres(Vector centres) {
        this.centres = centres;
    }

    void loadCentres() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < centres.size(); i++) {
            model.addElement(centres.get(i).get(1) + "-" + centres.get(i).get(2));
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

        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtEmpName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cbCentre = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Employee");

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

        jLabel3.setText("Email:");

        jLabel1.setText("Employee Name:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setText("Password:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setText("Password Confirmation:");

        jLabel7.setText("Centre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmpName)
                                    .addComponent(txtEmail)
                                    .addComponent(txtPasswordConfirm)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(cbCentre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCentre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get text form textfield
        String tempEmpName = txtEmpName.getText();
        String tempPassword = new String(txtPassword.getPassword());
        String tempPasswordConfirm = new String(txtPasswordConfirm.getPassword());
        String tempEmail = txtEmail.getText();

        // Check that name and password are not empty
        if (tempEmpName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee Name cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtEmpName.requestFocus();
            return;
        }
        if (tempPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtPassword.requestFocus();
            return;
        }
        if (tempPasswordConfirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password Confirmation cannot be empty", "Message", JOptionPane.ERROR_MESSAGE);
            txtPasswordConfirm.requestFocus();
            return;
        }
        // Check that pw and pw confirmation match
        if (!tempPassword.equals(tempPasswordConfirm)) {
            JOptionPane.showMessageDialog(this, "Password and Password Confirmation do not match", "Message", JOptionPane.ERROR_MESSAGE);
            txtPasswordConfirm.requestFocus();
            return;
        }
        if (!tempEmail.isEmpty()) {
            Pattern pattern = Pattern.compile(AddEmp.EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(tempEmail);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Email is not in valid form (Eg: abc@gmail.com)", "Message", JOptionPane.ERROR_MESSAGE);
                txtEmail.requestFocus();
                return;
            }
        }
        
        
        /*Add new Employee*/
        Employee emp = new Employee();
        emp.setEmpName(tempEmpName);
        emp.setPassword(tempPassword);
        emp.setEmail(tempEmail);
        emp.setState(false);
        for (int i = 0; i < centres.size(); i++) {
            if(cbCentre.getSelectedItem().toString().equals(centres.get(i).get(1)+"-"+centres.get(i).get(2))){
                emp.setCentreCode(centres.get(i).get(0).toString());
                break;
            }
        }
        MainMenu mainMenu = (MainMenu) this.getParent();
        mainMenu.getEmpController().add(emp);
        /*Reload main menu*/
        mainMenu.refresh();
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cbCentre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    // End of variables declaration//GEN-END:variables
}
