package Order;

import Manipulate.Manipulator_Pizza;
import SQLServer.SQLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class pizza extends javax.swing.JFrame {

    private Connection connection;
    private Model model;
    private Controller controller;

    public int var_Id;

    public pizza() {
        initComponents();
  
       

    }

    Test we = new Test(this);

    public pizza(String msg, String msg2, String msg3, int msg4) {
         initComponents();
        //jLabel26.setText(msg);
        this.name = msg;
        this.contact = msg2;
        this.address = msg3;
        this.emp_id = msg4;

        System.out.println(msg);
        System.out.println("Pizza ID" + var_Id);
        
         try {
            SQLConnection conn = new SQLConnection();
            connection = conn.getConnection();
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public void displayData(String Size, String Flavour, String Extra, String Price, String Quantity, String Drink, String Total) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        Object[] row = {Size, Flavour, Extra, Price, Quantity, Drink, Total};
        tableModel.addRow(row);
    }

    private void getData() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);
            String query = "select * from PRODUCT_SALES;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("" + result.getString(3));
                model = retriveFromDatabase(result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));
                controller = new Controller(model, this);
                controller.updateView();
            }
        } catch (SQLException ex) {

        }
    }

    int emp_id;
    int eidemp_id;
    String name = "";
    String contact = "";
    String address = "";

//    DefaultTableModel model;
    String item;
    int price;
    String fla;

    int ex_price;
    String ex_name;
    int qty;
    int total;
    String drink_name;
    int drink_price;
    int salesid;
    //for counting rows
    int rows;
    int row1;
    //for calculating
    int calculating;

    int removing;
    //for removing
    int rem;

    int hello;

    //for generate bill button
    int total1;
    int pay1;
    //for holding values of rows
    int res1;

    // for connection
    //Connection con;
    //PreparedStatement pst;
    //PreparedStatement pst1;    
    int Cusid; //CUSTOMER ID

    int i;
//    
//      //for intializing LOGIN
//     public pizza(int a){
//        initComponents();
//        this.lo =a;
//     
//     }
    int lo;

    public void Add(Object[] datarow) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.addRow(datarow);

    }

    public void Add1() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getSelectedRow();
        int datarow = a;
        model.removeRow(datarow);

    }

    public void Rem() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();
        System.out.println("hello: " + i);
        model.removeRow(jTable1.getSelectedRow());

    }

    /*
    //esfasdasd
    public  void Rem4(int res){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
         
         int a=(jTable1.getSelectedRow());
         System.out.println(a);
         res =0;
        
        for(int i=0 ; i<jTable1.getRowCount();i++){
            
            res = res + Integer.parseInt(jTable1.getValueAt(i, 6).toString());
        
        }
        
        txttot.setText(Integer.toString(res));
       
        
    }
    
    
    public  void Rem1(int res){
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
         mod*el.removeRow(jTable1.getSelectedRow());
         
        
        
       
        
    }
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ex_both = new javax.swing.JRadioButton();
        blmedium = new javax.swing.JRadioButton();
        bllarge = new javax.swing.JRadioButton();
        blexlarge = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        extra_toppings = new javax.swing.JRadioButton();
        extra_cheese = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        blsmall = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtqty = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Invoice = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txttot = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        chic_t = new javax.swing.JRadioButton();
        creamy_t = new javax.swing.JRadioButton();
        pepperoni = new javax.swing.JRadioButton();
        jalepeno_s = new javax.swing.JRadioButton();
        fajita = new javax.swing.JRadioButton();
        marg = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtpay = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        coke1 = new javax.swing.JRadioButton();
        coke2 = new javax.swing.JRadioButton();
        coke3 = new javax.swing.JRadioButton();
        fanta1 = new javax.swing.JRadioButton();
        fanta2 = new javax.swing.JRadioButton();
        fanta3 = new javax.swing.JRadioButton();
        up1 = new javax.swing.JRadioButton();
        up2 = new javax.swing.JRadioButton();
        up3 = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        jButton_Search2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Size");

        ex_both.setBackground(new java.awt.Color(255, 51, 51));
        ex_both.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        ex_both.setForeground(new java.awt.Color(255, 255, 255));
        ex_both.setText("Both");

        blmedium.setBackground(new java.awt.Color(255, 51, 51));
        blmedium.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        blmedium.setForeground(new java.awt.Color(255, 255, 255));
        blmedium.setText("Medium");

        bllarge.setBackground(new java.awt.Color(255, 51, 51));
        bllarge.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        bllarge.setForeground(new java.awt.Color(255, 255, 255));
        bllarge.setText("Large");
        bllarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bllargeActionPerformed(evt);
            }
        });

        blexlarge.setBackground(new java.awt.Color(255, 51, 51));
        blexlarge.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        blexlarge.setForeground(new java.awt.Color(255, 255, 255));
        blexlarge.setText("Extra Large");
        blexlarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blexlargeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PIZZA ODERING SYS BY");

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ZAWwAR Asif-250");

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("FARAZ GUL-275");

        jLabel16.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MAHNOOR EJAZ-244");

        jLabel17.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SYED TALHA-281");

        extra_toppings.setBackground(new java.awt.Color(255, 51, 51));
        extra_toppings.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        extra_toppings.setForeground(new java.awt.Color(255, 255, 255));
        extra_toppings.setText("Extra Toppings/-Rs 50");
        extra_toppings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extra_toppingsActionPerformed(evt);
            }
        });

        extra_cheese.setBackground(new java.awt.Color(255, 51, 51));
        extra_cheese.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        extra_cheese.setForeground(new java.awt.Color(255, 255, 255));
        extra_cheese.setText("Extra Cheese/-Rs 50");

        jLabel26.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Extra !");

        blsmall.setBackground(new java.awt.Color(255, 51, 51));
        blsmall.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        blsmall.setForeground(new java.awt.Color(255, 255, 255));
        blsmall.setText("Small");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(blsmall)
                    .addComponent(bllarge)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)))))
                    .addComponent(ex_both)
                    .addComponent(extra_cheese)
                    .addComponent(blmedium)
                    .addComponent(blexlarge)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extra_toppings))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(blsmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blmedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bllarge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blexlarge)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(extra_toppings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(extra_cheese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ex_both)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 28)); // NOI18N
        jLabel4.setText("Pizza Town");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 0, 12)); // NOI18N
        jLabel5.setText("\"A PIZZA SLICE A DAY KEEPS SADNESS AWAY\"");

        jLabel29.setIcon(new javax.swing.ImageIcon("D:\\images for project\\delivery2.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(55, 51, 51));

        jTable1.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Size ", "Flavours", "Extra", "Price", "Qty", "Drink", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        txtqty.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        txtqty.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payment");

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Balance");

        txtbal.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Invoice.setBackground(new java.awt.Color(255, 51, 51));
        Invoice.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        Invoice.setForeground(new java.awt.Color(255, 255, 255));
        Invoice.setText("Gen.. Bill");
        Invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoiceActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tot");

        txttot.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(55, 51, 51));

        chic_t.setBackground(new java.awt.Color(55, 51, 51));
        chic_t.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        chic_t.setForeground(new java.awt.Color(255, 255, 255));
        chic_t.setText("Chicken Tikka");
        chic_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chic_tActionPerformed(evt);
            }
        });

        creamy_t.setBackground(new java.awt.Color(55, 51, 51));
        creamy_t.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        creamy_t.setForeground(new java.awt.Color(255, 255, 255));
        creamy_t.setText("Creamy Tikka");

        pepperoni.setBackground(new java.awt.Color(55, 51, 51));
        pepperoni.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        pepperoni.setForeground(new java.awt.Color(255, 255, 255));
        pepperoni.setText("Pepperoni");

        jalepeno_s.setBackground(new java.awt.Color(55, 51, 51));
        jalepeno_s.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jalepeno_s.setForeground(new java.awt.Color(255, 255, 255));
        jalepeno_s.setText("Jalapeno Special");
        jalepeno_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jalepeno_sActionPerformed(evt);
            }
        });

        fajita.setBackground(new java.awt.Color(55, 51, 51));
        fajita.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        fajita.setForeground(new java.awt.Color(255, 255, 255));
        fajita.setText("Fajita");

        marg.setBackground(new java.awt.Color(55, 51, 51));
        marg.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        marg.setForeground(new java.awt.Color(255, 255, 255));
        marg.setText("Margherita");
        marg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                margActionPerformed(evt);
            }
        });

        jLabel37.setIcon(new javax.swing.ImageIcon("D:\\images for project\\chicken tikka.jpg")); // NOI18N

        jLabel38.setIcon(new javax.swing.ImageIcon("D:\\images for project\\creamy tikka1.jpg")); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon("D:\\images for project\\peperoni.jpg")); // NOI18N

        jLabel40.setIcon(new javax.swing.ImageIcon("D:\\images for project\\jalopeno.jpg")); // NOI18N

        jLabel41.setIcon(new javax.swing.ImageIcon("D:\\images for project\\fajita.jpg")); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon("D:\\images for project\\margherita.jpg")); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Flavours !");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jalepeno_s))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fajita))
                            .addComponent(jLabel21)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(creamy_t))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marg))
                            .addComponent(jLabel22)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chic_t))
                            .addComponent(pepperoni))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel19)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(chic_t))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(creamy_t))))
                .addGap(38, 38, 38)
                .addComponent(jLabel21)
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pepperoni)
                    .addComponent(jLabel39))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jalepeno_s)
                    .addComponent(jLabel40))
                .addGap(28, 28, 28)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(fajita)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(marg)
                        .addGap(114, 114, 114))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel42))
                        .addContainerGap())))
        );

        jScrollPane2.setViewportView(jPanel4);

        jScrollPane3.setViewportView(jScrollPane2);

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtpay.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(55, 51, 51));

        jLabel27.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("      Drinks !");

        coke1.setBackground(new java.awt.Color(55, 51, 51));
        coke1.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        coke1.setForeground(new java.awt.Color(255, 255, 255));
        coke1.setText("500 ml Coke");
        coke1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coke1ActionPerformed(evt);
            }
        });

        coke2.setBackground(new java.awt.Color(55, 51, 51));
        coke2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        coke2.setForeground(new java.awt.Color(255, 255, 255));
        coke2.setText("1.5 Ltr Coke");
        coke2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coke2ActionPerformed(evt);
            }
        });

        coke3.setBackground(new java.awt.Color(55, 51, 51));
        coke3.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        coke3.setForeground(new java.awt.Color(255, 255, 255));
        coke3.setText("2.25 Ltr Coke");
        coke3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coke3ActionPerformed(evt);
            }
        });

        fanta1.setBackground(new java.awt.Color(55, 51, 51));
        fanta1.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        fanta1.setForeground(new java.awt.Color(255, 255, 255));
        fanta1.setText("500 ml Fanta");
        fanta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fanta1ActionPerformed(evt);
            }
        });

        fanta2.setBackground(new java.awt.Color(55, 51, 51));
        fanta2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        fanta2.setForeground(new java.awt.Color(255, 255, 255));
        fanta2.setText("1.5 Ltr Fanta");
        fanta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fanta2ActionPerformed(evt);
            }
        });

        fanta3.setBackground(new java.awt.Color(55, 51, 51));
        fanta3.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        fanta3.setForeground(new java.awt.Color(255, 255, 255));
        fanta3.setText("2.25 Ltr Fanta");
        fanta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fanta3ActionPerformed(evt);
            }
        });

        up1.setBackground(new java.awt.Color(55, 51, 51));
        up1.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        up1.setForeground(new java.awt.Color(255, 255, 255));
        up1.setText("500 ml 7up");
        up1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up1ActionPerformed(evt);
            }
        });

        up2.setBackground(new java.awt.Color(55, 51, 51));
        up2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        up2.setForeground(new java.awt.Color(255, 255, 255));
        up2.setText("1.5 Ltr 7up");
        up2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up2ActionPerformed(evt);
            }
        });

        up3.setBackground(new java.awt.Color(55, 51, 51));
        up3.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        up3.setForeground(new java.awt.Color(255, 255, 255));
        up3.setText("2.25 Ltr 7up");
        up3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up3ActionPerformed(evt);
            }
        });

        jLabel51.setIcon(new javax.swing.ImageIcon("D:\\images for project\\coke1.png")); // NOI18N

        jLabel52.setIcon(new javax.swing.ImageIcon("D:\\images for project\\7up.png")); // NOI18N

        jLabel53.setIcon(new javax.swing.ImageIcon("D:\\images for project\\coke1.png")); // NOI18N

        jLabel54.setIcon(new javax.swing.ImageIcon("D:\\images for project\\coke1.png")); // NOI18N

        jLabel55.setIcon(new javax.swing.ImageIcon("D:\\images for project\\fanta.png")); // NOI18N

        jLabel56.setIcon(new javax.swing.ImageIcon("D:\\images for project\\fanta.png")); // NOI18N

        jLabel57.setIcon(new javax.swing.ImageIcon("D:\\images for project\\fanta.png")); // NOI18N

        jLabel58.setIcon(new javax.swing.ImageIcon("D:\\images for project\\7up.png")); // NOI18N

        jLabel59.setIcon(new javax.swing.ImageIcon("D:\\images for project\\7up.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel53)
                                        .addComponent(jLabel54))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(49, 49, 49)
                                            .addComponent(coke3))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(coke2)
                                        .addComponent(coke1)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel57)
                                        .addComponent(jLabel55)
                                        .addComponent(jLabel56)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel58)
                                            .addComponent(jLabel52)
                                            .addComponent(jLabel59)))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(41, 41, 41)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fanta2)
                                                        .addComponent(fanta3))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(up1)
                                                        .addComponent(up2)
                                                        .addComponent(up3))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fanta1))))
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(coke1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coke2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coke3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel54)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(fanta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel36)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(fanta2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(fanta3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel58)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel59))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(up1)
                                .addGap(60, 60, 60)
                                .addComponent(up2)
                                .addGap(44, 44, 44)
                                .addComponent(up3)))
                        .addContainerGap())))
        );

        jScrollPane4.setViewportView(jPanel5);

        next.setBackground(new java.awt.Color(255, 51, 51));
        next.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jButton_Search2.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Search2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton_Search2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Search2.setText("CLEAR");
        jButton_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Search2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Search2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Search2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void blexlargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blexlargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blexlargeActionPerformed

    private void bllargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bllargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bllargeActionPerformed

    public void sales() throws ClassNotFoundException {

        try {

            String hostname = "localhost";
            String sqlInstanceName = "DESKTOP-R1FN2EL"; //computer name 
            String sqlDatabase = "PizzaDB";  //sql server database name
            String sqlUser = "sa";
            String sqlPassword = "1234"; //passwrod sa account

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectURL = "jdbc:sqlserver://" + hostname + ":1433;instance=DESKTOP-R1FN2EL;databaseName=PizzaDB";

            Connection con = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
            Statement stat = con.createStatement();

            String query = "insert into CUSTOMER(CUSTOMER_NAME,ADRESS,CONTACT,EMP_ID)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            final int a = emp_id;
            setid(a);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, contact);
            pst.setInt(4, a);
            System.out.println("id = " + emp_id);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            System.out.println(Integer.parseInt(txtbal.getText()));
            if (rs.next()) {
                Cusid = rs.getInt(1);
            }

            int sal_tot = Integer.parseInt(txttot.getText());
            int balance = Integer.parseInt(txtbal.getText());
            int payment = Integer.parseInt(txtpay.getText());

            String query1 = "insert into SALES(TOTAL,PAY,BALANCE,CUSTOMER_ID)values(?,?,?,?)";
            PreparedStatement pst1 = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            pst1.setInt(1, sal_tot);
            pst1.setInt(2, payment);
            pst1.setInt(3, balance);
            pst1.setInt(4, Cusid);
            pst1.executeUpdate();
            ResultSet rs1 = pst1.getGeneratedKeys();
            //was here
            if (rs1.next()) {
                salesid = rs1.getInt(1);
            }

            String query2 = "insert into PRODUCT_SALES(SALES_ID,SIZE,FLAVOUR,EXTRA,PRICE,QUANTITY,DRINK,TOTAL)values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst2 = con.prepareStatement(query2);

            String size;
            String flavour;
            String extra;
            int PRICE;
            int QUANTITY;
            String drink;
            int tot = 0;

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                ///STORING DATA OF TABEL IN DATABASE

                size = (String) jTable1.getValueAt(i, 0);
                flavour = (String) jTable1.getValueAt(i, 1);
                extra = (String) jTable1.getValueAt(i, 2);
                //prodname =name;//(String)jTable1.getValueAt(i, 0);
                PRICE = (int) jTable1.getValueAt(i, 3);
                QUANTITY = (int) jTable1.getValueAt(i, 4);
                drink = (String) jTable1.getValueAt(i, 5);
                tot = (int) jTable1.getValueAt(i, 6);

                pst2.setInt(1, salesid);
                pst2.setString(2, size);
                pst2.setString(3, flavour);
                pst2.setString(4, extra);
                pst2.setInt(5, PRICE);
                pst2.setInt(6, QUANTITY);
                pst2.setString(7, drink);
                pst2.setInt(8, tot);
                pst2.executeUpdate();

            }

            JOptionPane.showMessageDialog(this, "sales completed");

            //Map<String, Object> params = new HashMap<String, Object>();
            // a.put("invo",salesid);
            //params.put("info",salesid);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ERROR OCCURED");
            e.printStackTrace();

        }

    }

    private Model retriveFromDatabase(String Size, String Flavour, String Extra, String Price, String Quantity, String Drink, String Total) {
        Model model = new Model();
        model.setSize(Size);
        model.setFlavours(Flavour);
        model.setExtra(Extra);
        model.setPrice(Price);
        model.setQty(Quantity);
        model.setDrink(Drink);
        model.setTotal(Total);
        return model;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Test test = new Test(this);

        //FOR SIZE SELECTION;
        if (blsmall.isSelected() == true) {
            item = "Small";
            price = 200;
        } else if (blmedium.isSelected() == true) {
            item = "Medium";
            price = 300;
        } else if (bllarge.isSelected() == true) {
            item = "Large";
            price = 400;
        } else if (blexlarge.isSelected() == true) {
            item = "Ex Large";
            price = 700;
        } else {
            item = "Not Selected";
            price = 0;

        };

        //FOR DRINK SELECTION...
        if (coke1.isSelected() == true) {
            drink_name = "500 ml Coke";
            drink_price = 50;
        } else if (coke2.isSelected() == true) {
            drink_name = "1.5 Ltr Coke";
            drink_price = 100;
        } else if (coke3.isSelected() == true) {
            drink_name = "2.25 Ltr Coke";
            drink_price = 150;
        } else if (fanta1.isSelected() == true) {
            drink_name = "500 ml Fanta";
            drink_price = 50;
        } else if (fanta2.isSelected() == true) {
            drink_name = "1.5 Ltr Fanta";
            drink_price = 100;
        } else if (fanta3.isSelected() == true) {
            drink_name = "2.25 Ltr Fanta";
            drink_price = 150;
        } else if (up1.isSelected() == true) {
            drink_name = "500 ml 7up";
            drink_price = 50;
        } else if (up2.isSelected() == true) {
            drink_name = "1.5 Ltr 7up";
            drink_price = 100;
        } else if (up3.isSelected() == true) {
            drink_name = "2.25 Ltr 7up";
            drink_price = 150;
        } else {
            drink_name = "Not selected";
            drink_price = 0;

        };

        //FOR FLAVOURS SELECTION;
        if (chic_t.isSelected() == true) {
            fla = "Chiken Tikka";
        } else if (creamy_t.isSelected() == true) {
            fla = "Creamy Tikka";
        } else if (pepperoni.isSelected() == true) {
            fla = "Pepperoni";
        } else if (jalepeno_s.isSelected() == true) {
            fla = "Jalapeno Special";
        } else if (fajita.isSelected() == true) {
            fla = "Fajita";
        } else if (marg.isSelected() == true) {
            fla = "Margherita";
        } else {
            fla = "Not Selected";
        };

        if (extra_cheese.isSelected() == true) {
            ex_price = 50;
            ex_name = "Ex Cheese";
        } else if (extra_toppings.isSelected() == true) {
            ex_price = 50;
            ex_name = "Ex Toppings";
        } else if (ex_both.isSelected() == true) {
            ex_price = 100;
            ex_name = "Both";

        } else {
            ex_price = 0;
            ex_name = "Not selected";
        };

        qty = Integer.parseInt(txtqty.getValue().toString());
        if (qty <= 0) {
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(this, "INVALID QUANTITY");

                //System.exit(1);
            }
        }

        total = ex_price + (qty * price) + drink_price;
        //System.out.println("working"+total);

        test.Addrow();

        // calculating =Integer.parseInt(jTable1.getValueAt(i, 6).toString());
        rows = jTable1.getRowCount();

        calculating = Integer.parseInt(jTable1.getValueAt((rows - 1), 6).toString());
        System.out.println("row count" + rows + " cal: " + calculating);//Working
        /*model = (DefaultTableModel)jTable1.getModel();
        
        model.addRow(new Object[]
                
        {
            item,
            fla,
            ex_name,
            price,
            qty,
            drink_name,
            total
        
        
        });
         */
        int res = 0;

        res1 += test.Addtot();

        /*
        for(int i=0 ; i<jTable1.getRowCount();i++){
            
            res = res + Integer.parseInt(jTable1.getValueAt(i, 6).toString());
        
        }
         */
        txttot.setText(Integer.toString(res1));
        rem = jTable1.getSelectedRow();
        //System.out.println(+rem);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // model.removeRow(jTable1.getSelectedRow());
        Test test = new Test(this);
        //test.hello1();
        int i = jTable1.getSelectedRow();
        removing = Integer.parseInt(jTable1.getValueAt((i), 6).toString());

        System.out.println("hello: " + i + " " + removing);

        res1 = test.remtot();

        //res1 -=res;
        /*
        for(int i=0 ; i<jTable1.getRowCount();i++){
            
            res = res + Integer.parseInt(jTable1.getValueAt(i, 6).toString());
        
        }
         */
        txttot.setText(Integer.toString(res1));

        Rem();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //t.hello();
        this.setVisible(false);
        new Reg().setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void InvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoiceActionPerformed

        total1 = Integer.parseInt(txttot.getText().toString());
        pay1 = Integer.parseInt(txtpay.getText().toString());

        Test test = new Test(this);

        int bal = test.getbal();

        System.out.println("helloaa" + emp_id);

        txtbal.setText(String.valueOf(bal));
        //sales(); impoertant
        try {
            sales();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_InvoiceActionPerformed

    private void extra_toppingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extra_toppingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extra_toppingsActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        this.setVisible(false);
        Manipulator_Pizza man = new Manipulator_Pizza();

        man.setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    private void chic_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chic_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chic_tActionPerformed

    private void jalepeno_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jalepeno_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jalepeno_sActionPerformed

    private void margActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_margActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_margActionPerformed

    private void coke1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coke1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coke1ActionPerformed

    private void coke2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coke2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coke2ActionPerformed

    private void coke3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coke3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coke3ActionPerformed

    private void fanta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fanta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fanta1ActionPerformed

    private void fanta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fanta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fanta2ActionPerformed

    private void fanta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fanta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fanta3ActionPerformed

    private void up1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up1ActionPerformed

    private void up2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up2ActionPerformed

    private void up3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up3ActionPerformed

    private void jButton_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Search2ActionPerformed
        // TODO add your handling code here:
         int i =0;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for( i= jTable1.getRowCount() -1 ; i >=0; i-- ){
            System.out.println("seq"+i+" "+jTable1.getRowCount());
            model.removeRow(i);
            
        }
    }//GEN-LAST:event_jButton_Search2ActionPerformed

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
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Invoice;
    private javax.swing.JRadioButton blexlarge;
    private javax.swing.JRadioButton bllarge;
    private javax.swing.JRadioButton blmedium;
    private javax.swing.JRadioButton blsmall;
    private javax.swing.JRadioButton chic_t;
    private javax.swing.JRadioButton coke1;
    private javax.swing.JRadioButton coke2;
    private javax.swing.JRadioButton coke3;
    private javax.swing.JRadioButton creamy_t;
    private javax.swing.JRadioButton ex_both;
    private javax.swing.JRadioButton extra_cheese;
    private javax.swing.JRadioButton extra_toppings;
    private javax.swing.JRadioButton fajita;
    private javax.swing.JRadioButton fanta1;
    private javax.swing.JRadioButton fanta2;
    private javax.swing.JRadioButton fanta3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Search2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton jalepeno_s;
    private javax.swing.JRadioButton marg;
    private javax.swing.JButton next;
    private javax.swing.JRadioButton pepperoni;
    private javax.swing.JTextField txtbal;
    private javax.swing.JTextField txtpay;
    private javax.swing.JSpinner txtqty;
    private javax.swing.JTextField txttot;
    private javax.swing.JRadioButton up1;
    private javax.swing.JRadioButton up2;
    private javax.swing.JRadioButton up3;
    // End of variables declaration//GEN-END:variables

    void setid(int Emp_id) {
        this.lo = Emp_id; //To change body of generated methods, choose Tools | Templates.
    }

    public int getid() {
        return lo;

    }
}
