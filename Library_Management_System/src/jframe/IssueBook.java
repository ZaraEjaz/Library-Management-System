package jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.Timer;
public class IssueBook extends javax.swing.JFrame {
    public IssueBook() {
        initComponents();
        updateTimeLabel();
    
    }
    private void updateTimeLabel() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                String formattedDate = dateFormat.format(currentTime);
                String formattedTime = timeFormat.format(currentTime);

                datelabel.setText(formattedDate);
                timelabel.setText(formattedTime);
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    public void getBookDetails() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT book_id, book_name, author, quantity FROM book_details WHERE book_id=?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            } else {
                lbl_bookError.setText("Invalid book id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentDetails() {
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT student_id, name, course, branch FROM student_details WHERE student_id=?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
            } else {
                lbl_studentError.setText("Invalid student id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean issueBook() {
        boolean isIssued = false;
        
        int bookId = Integer.parseInt(txt_studentId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();

        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();

        long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO issue_book_details(book_id, book_name, student_id, student_name, issue_date, due_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;
    }
     
    public void updateBookCount(){
        int bookId=Integer.parseInt(txt_studentId.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_details SET quantity = quantity - 1 WHERE book_id = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
                int initialCount=Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount-1));
              
            } else {
                JOptionPane.showMessageDialog(this,"can't update book");
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
public boolean isAlreadyIssued() {
    boolean alreadyIssued = false;
    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement("SELECT * FROM issue_book_details WHERE book_id = ? AND student_id = ? AND status = ?"))
    {
        int bookId = Integer.parseInt(txt_studentId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());

        pst.setInt(1, bookId);
        pst.setInt(2, studentId);
        pst.setString(3, "pending");

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                alreadyIssued = true;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return alreadyIssued;
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_bookId = new app.bolivia.swing.JCTextField();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        issuebookbutton = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        timelabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        datelabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setText("Issue Date:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setText("Due Date:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setText("Student Id:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setText("Book Id:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bookName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(51, 51, 0));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 200, 20));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Book Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Author:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 0));
        jLabel14.setText("Book Id:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_author.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(51, 51, 0));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 240, 20));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 200, 20));

        lbl_quantity.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(51, 51, 0));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 220, 20));

        lbl_bookId.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(51, 51, 0));
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 220, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 0));
        jLabel10.setText("Quantity:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 150, 20));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managesbooks.png"))); // NOI18N
        jLabel28.setText("   Book");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 260, 100));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel29.setText("Details");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 770));

        txt_studentId.setPlaceholder("Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanel3.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 260, -1));

        txt_bookId.setPlaceholder("Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        jPanel3.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 260, -1));

        date_dueDate.setColorBackground(new java.awt.Color(51, 153, 0));
        date_dueDate.setColorButtonHover(new java.awt.Color(255, 204, 0));
        date_dueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_dueDate.setFuente(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        date_dueDate.setPlaceholder("chooose the date");
        jPanel3.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 260, -1));

        date_issueDate.setColorBackground(new java.awt.Color(51, 153, 0));
        date_issueDate.setColorButtonHover(new java.awt.Color(255, 204, 0));
        date_issueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_issueDate.setFuente(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        date_issueDate.setPlaceholder("chooose the date");
        jPanel3.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 260, -1));

        issuebookbutton.setBackground(new java.awt.Color(51, 153, 0));
        issuebookbutton.setBorder(null);
        issuebookbutton.setText("issue book");
        issuebookbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuebookbuttonMouseClicked(evt);
            }
        });
        jPanel3.add(issuebookbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 170, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 980, 770));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("Student Id:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 0));
        jLabel6.setText("Student Name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 0));
        jLabel7.setText("Course Name:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 0));
        jLabel8.setText("Branch:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(51, 51, 0));
        jPanel2.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 200, 20));

        lbl_studentName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(51, 51, 0));
        jPanel2.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 200, 20));

        lbl_course.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(51, 51, 0));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 210, 20));

        lbl_branch.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(51, 51, 0));
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 210, 20));
        jPanel2.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 140, 20));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managestudent.png"))); // NOI18N
        jLabel1.setText("Student ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 120));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setText("Details");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 380, 760));

        jPanel4.setBackground(new java.awt.Color(56, 156, 98));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jLabel4.setText("Menu");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        jLabel13.setText("X");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 60, 70));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.png"))); // NOI18N
        jLabel18.setText("Hello Admin!");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(0, 102, 0));

        timelabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        timelabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                timelabelComponentShown(evt);
            }
        });
        jPanel10.add(timelabel);

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 140, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        datelabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel11.add(datelabel);

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 140, 30));
        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 2, 45));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 70));

        jPanel6.setBackground(new java.awt.Color(140, 214, 167));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setText("Welcome Admin");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, 30));

        jPanel8.setBackground(new java.awt.Color(255, 204, 51));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("LMS Dashboard");
        jPanel8.add(jLabel21);

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 50));

        jPanel13.setBackground(new java.awt.Color(255, 204, 102));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jLabel26.setText("Logout");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel26);

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 180, 50));

        jLabel24.setText("LMS Dashboard");
        jPanel15.add(jLabel24);

        jPanel6.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 50));

        jPanel16.setBackground(new java.awt.Color(140, 214, 167));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/issued books.png"))); // NOI18N
        jLabel27.setText("Issue Book");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 50));

        jPanel17.setBackground(new java.awt.Color(140, 214, 167));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/no.of.students.png"))); // NOI18N
        jLabel20.setText("Manage Students");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 50));

        jPanel18.setBackground(new java.awt.Color(140, 214, 167));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/books.png"))); // NOI18N
        jLabel19.setText("Manage Books");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 50));

        jPanel19.setBackground(new java.awt.Color(140, 214, 167));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/return.png"))); // NOI18N
        jLabel22.setText("Return Book");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 50));

        jPanel20.setBackground(new java.awt.Color(140, 214, 167));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewrecords.png"))); // NOI18N
        jLabel23.setText("View Records");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 180, 50));

        jPanel21.setBackground(new java.awt.Color(140, 214, 167));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Home.setForeground(new java.awt.Color(0, 51, 51));
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        Home.setText("Home page");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        jPanel21.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel6.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 0));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/features.png"))); // NOI18N
        jLabel32.setText("Features");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked

    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if (isAlreadyIssued()) {
    JOptionPane.showMessageDialog(this, "Student has already issued the same book");
} else {
    if (issueBook()) {
        JOptionPane.showMessageDialog(this, "Book issued successfully");
        updateBookCount();
    } else {
        JOptionPane.showMessageDialog(this, "Can't issue book");
    }
}

    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        if(!txt_studentId.getText().equals("")){
        
        getStudentDetails();
        
       }
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void timelabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_timelabelComponentShown

    }//GEN-LAST:event_timelabelComponentShown

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        SignupPage signUpPage = new SignupPage();
        signUpPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        IssueBook book=new IssueBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        ManageStudents students=new ManageStudents();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        ManageBooks books=new ManageBooks();
        books.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        ReturnBook book=new ReturnBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        ViewAllRecord record = new ViewAllRecord();
        record.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
        
        getStudentDetails();
        
       }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
            
        getBookDetails();
        
       }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void issuebookbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuebookbuttonMouseClicked
        if (isAlreadyIssued()) {
    JOptionPane.showMessageDialog(this, "Student has already issued the same book");
} else {
    if (issueBook()) {
        JOptionPane.showMessageDialog(this, "Book issued successfully");
        updateBookCount();
    } else {
        JOptionPane.showMessageDialog(this, "Can't issue book");
    }
}
    }//GEN-LAST:event_issuebookbuttonMouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Home;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel datelabel;
    private rojerusan.RSMaterialButtonCircle issuebookbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JLabel timelabel;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
