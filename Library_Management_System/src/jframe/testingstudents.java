package jframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class testingstudents extends javax.swing.JFrame {
    int studentId;
    String studentName,course,branch;
    DefaultTableModel model;

    public testingstudents() {
        initComponents();
        setStudentDetailsToTable();
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

    public void setStudentDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student_details");
            ResultSet rs = pst.executeQuery();

            model = (DefaultTableModel) tbl_studentDetails.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                Object[] obj = {studentId, studentName, course, branch};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent() {
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        branch = combo_branch.getSelectedItem().toString();
        course = combo_CourseName.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student_details VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    public boolean updateStudent() {
        boolean isUpdated = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        branch = combo_branch.getSelectedItem().toString();
        course = combo_CourseName.getSelectedItem().toString();

    try {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE student_details SET name=?, course=?, branch=? WHERE student_id=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, studentName);
        pst.setString(2, course);
        pst.setString(3, branch);
        pst.setInt(4, studentId);

        int rowCount = pst.executeUpdate();
        if (rowCount > 0) {
            isUpdated = true;
        } else {
            isUpdated = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isUpdated;
}

    
//    public void clearTable(){
//        DefaultTableModel model=(DefaultTableModel) tbl_bookDetails.getModel();
//        model.setRowCount(0);
//    }
        

     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        combo_CourseName = new javax.swing.JComboBox<>();
        combo_branch = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        timelabel = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        timelabel1 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Enter Student Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Enter Course :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 0));
        jLabel4.setText("Enter Student Id:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("Enter Branch:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigbook.png"))); // NOI18N
        jLabel1.setText("Manage Books");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 490, 140));

        txt_studentId.setPlaceholder("Book id");
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 220, -1));

        txt_studentName.setPlaceholder("Book name");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, 220, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 204, 0));
        rSMaterialButtonCircle1.setText("update");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 590, 130, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle2.setText("Delete");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 590, 130, 50));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(102, 204, 0));
        rSMaterialButtonCircle3.setText("Add");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 590, 130, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(140, 214, 167));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(169, 238, 158));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(102, 204, 0));
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_studentDetails);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 660, 770));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 760));

        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Computer Science",
            "Mechanical Engineering",
            "Electrical Engineering",
            "Civil Engineering",
            "Biotechnology",
            "Physics",
            "Chemistry",
            "Mathematics",
            "Environmental Science",
            "Biology",
            "Psychology",
            "Sociology",
            "History",
            "Political Science",
            "English Literature",
            "Economics",
            "Accountancy",
            "Business Administration",
            "Marketing",
            "Finance",
            "Law",
            "Criminal Justice",
            "International Relations",
            "Information Technology",
            "Software Engineering" }));
combo_CourseName.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_CourseNameActionPerformed(evt);
    }
    });
    jPanel1.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 220, 30));

    combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {     "Engineering",
        "Science",
        "Arts",
        "Commerce",
        "Law"  }));
jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, 220, 30));

getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 1350, 760));

jPanel4.setBackground(new java.awt.Color(56, 156, 98));
jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jLabel8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
jLabel8.setForeground(new java.awt.Color(255, 255, 255));
jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
jLabel8.setText("Menu");
jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

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

    jPanel14.setBackground(new java.awt.Color(255, 255, 255));
    jPanel14.setForeground(new java.awt.Color(0, 102, 0));

    timelabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
    timelabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
            timelabel1ComponentShown(evt);
        }
    });
    jPanel14.add(timelabel1);

    jPanel10.add(jPanel14);

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

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if(updateStudent()==true){
           JOptionPane.showMessageDialog(this, "Student record updated");
           setStudentDetailsToTable();
//           clearTable();
       }
       else{
           JOptionPane.showMessageDialog(this,"failed to update");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
     int bookId = Integer.parseInt(txt_studentId.getText());

    try {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM student_details WHERE student_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bookId);

        int rowCount = pst.executeUpdate();
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(this, "Student record deleted");
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete student record");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if(addStudent()==true){
           JOptionPane.showMessageDialog(this, "student record added");
           setStudentDetailsToTable();
//           clearTable();
           
       }
       else{
           JOptionPane.showMessageDialog(this,"failed to add student record");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo=tbl_studentDetails.getSelectedRow();
        TableModel model=tbl_studentDetails.getModel();
        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo,2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo,2).toString());
        
        
        
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
       
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

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
        testingstudents books=new testingstudents();
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

    private void timelabel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_timelabel1ComponentShown

    }//GEN-LAST:event_timelabel1ComponentShown

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void combo_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseNameActionPerformed

    }//GEN-LAST:event_combo_CourseNameActionPerformed

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
            java.util.logging.Logger.getLogger(testingstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testingstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testingstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testingstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testingstudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Home;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private javax.swing.JLabel timelabel;
    private javax.swing.JLabel timelabel1;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
