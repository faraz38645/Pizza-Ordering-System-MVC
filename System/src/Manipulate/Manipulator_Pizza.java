/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manipulate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Order.pizza;
import SQLServer.SQLConnection;

/**
 *
 * @author AAUM
 */
public class Manipulator_Pizza extends javax.swing.JFrame {

    /**
     * Creates new form Manipulator_Pizza
     */
    private Model mod;
    private Connection connection;
    private Controller controller;
    
    
    public Manipulator_Pizza() {
        initComponents();
        
        try {
            SQLConnection conn = new SQLConnection();
            connection = conn.getConnection();
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    DefaultTableModel model;
    
    
    
     public void displayData(String CUSTOMER_ID,String CUSTOMER_NAME,String ADDRESS,String CONTACT, String SALES_ID,String PAY,String BALANCE,String NO_OF_PRODUCTS,String TOTAL) {
        DefaultTableModel tableModel = (DefaultTableModel) jTableS.getModel();
        Object[] row = { CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, CONTACT,  SALES_ID, PAY, BALANCE, NO_OF_PRODUCTS, TOTAL};
        tableModel.addRow(row);
    }
     
    
      private void getData() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableS.getModel();
            tableModel.setRowCount(0);
            String query = "EXECUTE ALL_RECORDS";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("" + result.getString(3));
                mod = RetriveFromDatabase(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));
                        
                controller = new Controller(mod, this);
                controller.updateView();
            }
        } catch (SQLException ex) {

        }
    }
    
    private Model RetriveFromDatabase(String CUSTOMER_ID,String CUSTOMER_NAME,String ADDRESS,String CONTACT, String SALES_ID,String PAY,String BALANCE,String NO_OF_PRODUCTS,String TOTAL) {
        Model model = new Model();
        model.setCUSTOMER_ID(CUSTOMER_ID);
        model.setCUSTOMER_NAME(CUSTOMER_NAME);
        model.setADDRESS(ADDRESS);
        model.setCONTACT(CONTACT);
        model.setSALES_ID(SALES_ID);
        model.setPAY(PAY);
        model.setBALANCE(BALANCE);
        model.setNO_OF_PRODUCTS(NO_OF_PRODUCTS);
        model.setTOTAL(TOTAL);
        return model;
    }
    
    
    
    
    

    public void Search() throws ClassNotFoundException, SQLException{
            String hostname = "localhost";
            String sqlInstanceName = "DESKTOP-R1FN2EL"; //computer name 
            String sqlDatabase = "PizzaDB";  //sql server database name
            String sqlUser = "sa";
            String sqlPassword = "1234"; //passwrod sa account
            String search="EXECUTE SEARCH_ID";
            String search1="EXECUTE SEARCH_NAME";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
            String connectURL = "jdbc:sqlserver://" + hostname + ":1433" 
                    + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase;
            Connection conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
            System.out.println("Connect to database successful!!"); 
            
            Statement stat= conn.createStatement();
            
            if (bt_ID.isSelected() == true)
            {   
                int id=Integer.parseInt(txtdata.getText());
                String id1=txtdata.getText().toString();
                String qu=search+" "+id1;
                System.out.println(qu);
                ResultSet rs=stat.executeQuery(qu);
                while(rs.next()){
                    model = (DefaultTableModel)jTableS.getModel();

                    model.addRow(new Object[]

                    {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),


                    });

                }
            }    
                if (bt_NAME.isSelected() == true)
            {   
                
                String name=txtdata.getText().toString();
                String qu1=search1+" "+name;
                System.out.println(qu1);
                ResultSet rs1=stat.executeQuery(qu1);
                while(rs1.next()){
                    model = (DefaultTableModel)jTableS.getModel();
                    System.out.println(rs1.getString(1));
                    model.addRow(new Object[]

                    {
                        rs1.getString(1),
                        rs1.getString(2),
                        rs1.getString(3),
                        rs1.getString(4),
                        rs1.getString(5),
                        rs1.getString(6),
                        rs1.getString(7),
                        rs1.getString(8),
                        rs1.getString(9),


                    });

                }
            
            
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
            }
            
            
            
            
    
    }
    
     public void Delete() throws ClassNotFoundException, SQLException{
            String hostname = "localhost";
            String sqlInstanceName = "DESKTOP-R1FN2EL"; //computer name 
            String sqlDatabase = "PizzaDB";  //sql server database name
            String sqlUser = "sa";
            String sqlPassword = "1234"; //passwrod sa account
            String search="DEL_ID";
            //String search1="EXECUTE SEARCH_NAME";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
            String connectURL = "jdbc:sqlserver://" + hostname + ":1433" 
                    + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase;
            Connection conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
            System.out.println("Connect to database successful!!"); 
            
            
            
              //int id=Integer.parseInt(txtdata.getText());
            int id1=Integer.parseInt(txt_del_data.getText());
            String qu=search+" "+id1;
            PreparedStatement pst = conn.prepareStatement(qu);
            pst.execute();
            System.out.println(qu);
            JOptionPane.showMessageDialog(this, "GIVEN ID HAS BEEM DELETED (PRESS OK)");
            
            
        
        

    }              
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableS = new javax.swing.JTable();
        bt_NAME = new javax.swing.JRadioButton();
        bt_ID = new javax.swing.JRadioButton();
        txtdata = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton_Delete = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        txt_del_data = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton_Search2 = new javax.swing.JButton();
        jButton_Search1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PIZZA ODERING SYS BY");

        jLabel21.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("FARAZ GUL-275");

        jLabel22.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ZAWwAR Asif-250");

        jLabel23.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("SYED TALHA-281");

        jLabel24.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("MAHNOOR EJAZ-244");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(55, 51, 51));

        jTableS.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jTableS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUSTOMER_ID", "CUSTOMER_NAME", "ADDRESS", "CONTACT", "SALES_ID", "PAY", "BALANCE", "NO OF PRODUCTS", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableS.setGridColor(new java.awt.Color(204, 204, 204));
        jTableS.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(jTableS);

        bt_NAME.setBackground(new java.awt.Color(55, 51, 51));
        bt_NAME.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        bt_NAME.setForeground(new java.awt.Color(255, 255, 255));
        bt_NAME.setText("Search By Name");
        bt_NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_NAMEActionPerformed(evt);
            }
        });

        bt_ID.setBackground(new java.awt.Color(55, 51, 51));
        bt_ID.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        bt_ID.setForeground(new java.awt.Color(255, 255, 255));
        bt_ID.setText("Search By ID");

        txtdata.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DELETE RECORDS");

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ENTER");

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 19)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SEARCH RECORDS");

        jButton_Delete.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Delete.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.setText("DELETE");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        BACK.setBackground(new java.awt.Color(255, 51, 51));
        BACK.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        BACK.setForeground(new java.awt.Color(255, 255, 255));
        BACK.setText("BACK");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });

        txt_del_data.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ENTER");

        jButton_Search2.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Search2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton_Search2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Search2.setText("CLEAR");
        jButton_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Search2ActionPerformed(evt);
            }
        });

        jButton_Search1.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Search1.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jButton_Search1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Search1.setText("SEARCH");
        jButton_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Search1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BACK)
                        .addGap(228, 228, 228))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_NAME)
                            .addComponent(bt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Search2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Search1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_del_data, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(706, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Search1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Search2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_del_data, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144)
                .addComponent(BACK)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(529, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
    }// </editor-fold>//GEN-END:initComponents

    private void bt_NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_NAMEActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        try {
            Delete();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "ERROR OCCURED (PRESS OK)");
            Logger.getLogger(Manipulator_Pizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR OCCURED (PRESS OK)");
            Logger.getLogger(Manipulator_Pizza.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        

    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        pizza piz = new pizza();
        
        piz.setVisible(true);
    }//GEN-LAST:event_BACKActionPerformed

    private void jButton_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Search1ActionPerformed
        try {
            // TODO add your handling code here:
            Search();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manipulator_Pizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Manipulator_Pizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_Search1ActionPerformed

    private void jButton_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Search2ActionPerformed
        // TODO add your handling code here:
        int i =0;
        model = (DefaultTableModel)jTableS.getModel();
        for( i= jTableS.getRowCount() -1 ; i >=0; i-- ){
            System.out.println("seq"+i+" "+jTableS.getRowCount());
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
            java.util.logging.Logger.getLogger(Manipulator_Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulator_Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulator_Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulator_Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manipulator_Pizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JRadioButton bt_ID;
    private javax.swing.JRadioButton bt_NAME;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Search1;
    private javax.swing.JButton jButton_Search2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableS;
    private javax.swing.JTextField txt_del_data;
    private javax.swing.JTextField txtdata;
    // End of variables declaration//GEN-END:variables
}
