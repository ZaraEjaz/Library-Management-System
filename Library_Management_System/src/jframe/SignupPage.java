package jframe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.DriverManager;
import static jframe.DBConnection.con;
public class SignupPage extends javax.swing.JFrame {
    public SignupPage() {
        initComponents();
    }
    
    public void insertSignupDetails(){
        String name=txt_username.getText();
        String pwd =txt_password.getText();
        String email = txt_email.getText();
        
        try{
            Connection con=DBConnection.getConnection();
            String sql = "INSERT INTO users (name, password, email) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1,name);
            pst.setString(2,pwd);
            pst.setString(3,email);
            
            
            int updatedRowCount=pst.executeUpdate();
            
            if(updatedRowCount>0){
                JOptionPane.showMessageDialog(this, "Sign in Successfully");
                LoginPage page = new LoginPage();
                page.setVisible(true);
                dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Sign in Failed");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean validateSignup(){
        String name=txt_username.getText();
        String pwd =txt_password.getText();
        String email = txt_email.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter username");
            return false;
        }
         if(email.equals("")|| !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this,"Email not valid");
            return false;
        }
          if(pwd.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter Passworrd");
            return false;
        }
        return true;
        
    }
    public boolean checkDuplicateUser() {
    String name = txt_username.getText();
    boolean isExists = false;
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = ?");
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            isExists = true;
        } else {
            isExists = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isExists;
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        txt_username = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signuppage.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 800, 780));

        jPanel2.setBackground(new java.awt.Color(140, 214, 167));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 30, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmail.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 40, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 60, 60));

        jLabel3.setBackground(new java.awt.Color(0, 51, 0));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 0));
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 100, -1));

        jLabel1.setBackground(new java.awt.Color(0, 51, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setText("Email:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 70, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 0));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("Password:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 110, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 40, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 50)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sign-up.png"))); // NOI18N
        jLabel9.setText("Sign up");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        txt_password.setBorder(null);
        txt_password.setPlaceholder("password");
        txt_password.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 270, -1));

        txt_username.setBorder(null);
        txt_username.setPlaceholder("Username");
        txt_username.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 270, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 204, 0));
        rSMaterialButtonCircle1.setBorder(null);
        rSMaterialButtonCircle1.setText("Login");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 170, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setBorder(null);
        rSMaterialButtonCircle2.setText("Signup");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 170, 60));

        txt_email.setBorder(null);
        txt_email.setPlaceholder("Email");
        txt_email.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 270, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 570, 830));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 55)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 0));
        jLabel10.setText("Library Management System");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(validateSignup()==true ){
            if ( checkDuplicateUser()== false) {
                insertSignupDetails();
            }
            else{
                JOptionPane.showMessageDialog(this,"Username already exists");
            }
            
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if (checkDuplicateUser()==true) 
        {
            JOptionPane.showMessageDialog(this,"Username already exists");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
    LoginPage page = new LoginPage();
                page.setVisible(true);
                dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
