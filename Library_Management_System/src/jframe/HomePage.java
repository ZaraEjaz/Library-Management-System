package jframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


public class HomePage extends javax.swing.JFrame {
    
    Color mouseEnterColor=new Color(56,156,98);
    Color mouseExiteColor=new Color(140,214,167);
    Color mousePressedColor=new Color(56,156,98);
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToCards();
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
   public void showPieChart(){
        
         DefaultPieDataset pieDataset = new DefaultPieDataset();
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT book_name, COUNT(*) AS issue_count FROM issue_book_details GROUP BY book_id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String bookName = rs.getString("book_name");
            double issueCount = rs.getDouble("issue_count");
            pieDataset.setValue(bookName, issueCount);
        }
    } 
        catch(Exception e){
        }
    JFreeChart pieChart = ChartFactory.createPieChart("Book Distribution", pieDataset, true, true, false);
    PiePlot piePlot = (PiePlot) pieChart.getPlot();
    piePlot.setBackgroundPaint(Color.WHITE);
    PanelPieChart.removeAll();
    ChartPanel pieChartPanel = new ChartPanel(pieChart);
    PanelPieChart.add(pieChartPanel, BorderLayout.CENTER);
    PanelPieChart.validate();
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
     
      public void setBookDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM book_details");
            ResultSet rs = pst.executeQuery();

            model = (DefaultTableModel) tbl_bookDetails.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");

                Object[] obj = { bookId, bookName, author, quantity };
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDataToCards() {
    Statement st = null;
    ResultSet rs = null;
    try {
        Connection con = DBConnection.getConnection();
        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        rs = st.executeQuery("SELECT * FROM book_details");
        if (rs.last()) 
        {
            lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
        }
        
        rs = st.executeQuery("SELECT * FROM student_details");
           if (rs.last()) 
        {
            lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
        }
           
        rs = st.executeQuery("SELECT COUNT(*) FROM issue_book_details WHERE status = 'Pending'");
        if (rs.next())
        {
        int pendingBooksCount = rs.getInt(1);
        lbl_issueBooks.setText(Integer.toString(pendingBooksCount));
        }
        
        else
        {
        lbl_issueBooks.setText("0");
        }

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    } 
    finally 
    {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        timelabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        datelabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_issueBooks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PanelPieChart = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();

        jLabel1.setText("Welcome to Home Page");

        jPanel14.setBackground(new java.awt.Color(140, 214, 167));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Home page");
        jPanel14.add(jLabel3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 156, 98));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jLabel2.setText("Menu");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 60, 70));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.png"))); // NOI18N
        jLabel10.setText("Hello Admin!");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(0, 102, 0));

        timelabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        timelabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                timelabelComponentShown(evt);
            }
        });
        jPanel10.add(timelabel);

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 140, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        datelabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel11.add(datelabel);

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 140, 30));
        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 2, 45));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 70));

        jPanel2.setBackground(new java.awt.Color(140, 214, 167));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Welcome Admin");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, 30));

        jPanel8.setBackground(new java.awt.Color(255, 204, 51));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("LMS Dashboard");
        jPanel8.add(jLabel21);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 50));

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

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 180, 50));

        jLabel24.setText("LMS Dashboard");
        jPanel15.add(jLabel24);

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 50));

        jPanel16.setBackground(new java.awt.Color(140, 214, 167));
        jPanel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel16MouseMoved(evt);
            }
        });
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/issued books.png"))); // NOI18N
        jLabel4.setText("Issue Book");
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel16.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 50));

        jPanel17.setBackground(new java.awt.Color(140, 214, 167));
        jPanel17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel17MouseDragged(evt);
            }
        });
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

        jPanel2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 50));

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

        jPanel2.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 50));

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

        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 50));

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

        jPanel2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 180, 50));

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

        jPanel2.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/features.png"))); // NOI18N
        jLabel11.setText("Features");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 760));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfStudents.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbl_noOfStudents.setForeground(new java.awt.Color(0, 102, 51));
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/no.of.students.png"))); // NOI18N
        lbl_noOfStudents.setText(" ");
        jPanel4.add(lbl_noOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 110, 100));

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfBooks.setBackground(new java.awt.Color(0, 102, 204));
        lbl_noOfBooks.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(0, 102, 51));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/books.png"))); // NOI18N
        lbl_noOfBooks.setText("  ");
        jPanel6.add(lbl_noOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 110, 100));

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issueBooks.setBackground(new java.awt.Color(255, 204, 102));
        lbl_issueBooks.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbl_issueBooks.setForeground(new java.awt.Color(0, 102, 51));
        lbl_issueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/issued books.png"))); // NOI18N
        lbl_issueBooks.setText(" ");
        jPanel7.add(lbl_issueBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 150, 110, 100));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setText("No Of Students");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("No Of Books");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Issued Books");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, -1, -1));

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student.png"))); // NOI18N
        jLabel15.setText("Student Details");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 60));

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel16.setText("Book Details");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        PanelPieChart.setLayout(new java.awt.BorderLayout());
        PanelPieChart.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(PanelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 590, 380));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book ID", "Author Name", "Book Name", "Genre"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(140, 214, 167));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(169, 238, 158));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tbl_bookDetails.setRowHeight(30);
        jScrollPane4.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 510, 230));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
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
        jScrollPane3.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 510, 230));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 1390, 760));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        ManageBooks books=new ManageBooks();
        books.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        ManageStudents students=new ManageStudents();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

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

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked

    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        SignupPage signUpPage = new SignupPage();
        signUpPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jLabel4.setBackground(mousePressedColor);
        IssueBook book=new IssueBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void timelabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_timelabelComponentShown
        
    }//GEN-LAST:event_timelabelComponentShown

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void jPanel16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseMoved

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
      
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
     
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        
    }//GEN-LAST:event_jPanel16MousePressed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
       
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
       
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
       
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jPanel17MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseDragged
     
    }//GEN-LAST:event_jPanel17MouseDragged
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Home;
    private javax.swing.JPanel PanelPieChart;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_issueBooks;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private javax.swing.JLabel timelabel;
    // End of variables declaration//GEN-END:variables
}
