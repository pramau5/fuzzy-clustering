

package fuzzyclustering;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JTable;
public class fourth extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel t2=new javax.swing.table.DefaultTableModel();
    javax.swing.table.DefaultTableModel t1=new javax.swing.table.DefaultTableModel();
    Statement stmt,stmt1;
ResultSet rs,rs1;
DecimalFormat df=new DecimalFormat("##.##");
public static float x1[]=new float[30];
public static float x2[]=new float[30];
public static float m[]=new float[30];
public static float d[]=new float[30];
  public static int c=0,co=0,w1,w2 = 0,r=0,mco=0,dco=0;
            float w = 0,fw,mean,dv,mean1,dv1,m11,m12,fdv,fdv1;
            String cls,cls1;
    public fourth() {
        initComponents();
        try
        {
            //System.out.println("minus:"+(0.57-0.5));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuzzy","root","");
            stmt=conn.createStatement();
            stmt1=conn.createStatement();
            stmt.executeUpdate("DROP TABLE `fuzzy`.`simpattern`");
        }
        catch(Exception e)
        {
            System.out.println("Excep1:"+e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 750));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Periodic Outlier Pattern Mining Algorithm");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 730, 36);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 520, 550, 150);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 230, 310, 210);

        jPanel1.setBackground(new java.awt.Color(152, 213, 244));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Pattern Similarity");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Construct Word Pattern");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Cluster");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(520, 250, 200, 180);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 51));
        jLabel3.setText("Word Pattern Construction");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 460, 210, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 51));
        jLabel5.setText("Similarity of Each Pattern");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 170, 210, 30);

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("FUZZY Feature Clustering");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 100, 370, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gback1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println("===========WORD PATTEN============");
        String qry="";
        qry="CREATE TABLE `fuzzy`.`sim` (";
        System.out.println("Pramod query"+qry);
        try {
            table2.setModel(t2);
            for(int i=0;i<25;i++) {
                t2.addColumn("x"+(i+1));
                if(i==0)
                    qry=qry+"`"+second.wset[i]+"` FLOAT NULL ";
                else
                    qry=qry+" , `"+second.wset[i]+"` FLOAT NULL ";
            }
            qry=qry+")";
            for(int i=0;i<5;i++) {
                t2.insertRow(i, new Object[]{""});
            }

            rs=stmt.executeQuery("SELECT DISTINCT `cls` FROM `document`");
            while(rs.next()) {
                cls=rs.getString(1);
                co=0;
                System.out.println("cls==="+cls);
                for(int i=2;i<=26;i++) {
                    rs1=stmt1.executeQuery("SELECT * FROM `document`");
                    while(rs1.next()) {
                        System.out.println("in while");
                        cls1=rs1.getString(27);
                        w1=rs1.getInt(i);
                        w2=w2+w1;
                        System.out.println("i="+i+"==w1:"+w1);
                        if(cls.equalsIgnoreCase(cls1)) {
                            c=1;

                        } else {
                            c=0;
                        }
                        w=w+w1*c;
                    }
                    fw=w / w2;
                    String fx=df.format(fw);
                    fw=Float.parseFloat(fx);
                    if(cls.equalsIgnoreCase("c1")) {
                        x1[co]=fw;
                        co++;
                    } else if(cls.equalsIgnoreCase("c2")) {
                        x2[co]=fw;
                        co++;
                    }
                    System.out.println("fw:"+fw+"\n----w:"+w+"----w2:"+w2);
                    w=0;w2=0;fw=0;
                }

            }
System.out.println("co:"+co);
            for(int i=0;i<co;i++) {
               // t2.setValueAt("x"+(i+1), r++, i);
                t2.setValueAt(x1[i], r++, i);
                t2.setValueAt(x2[i], r++, i);
                r=0;
                System.out.println("x1:"+x1[i]+"-----------x2:"+x2[i]);
            }
            table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            stmt.executeUpdate(qry);
            System.out.println("query======"+qry);
        } catch(Exception e) {
            System.out.println("Excep:"+e.getMessage());
        }
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fifth ft=new fifth();
        ft.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         System.out.println("===========WORD PATTEN============");
        String qry="";
        
        try {
            table1.setModel(t1);
           
            t1.addColumn("word pattern");
            t1.addColumn("similarity1");
            t1.addColumn("similarity2");
            t1.addColumn("Represent");
                 for(int i=0;i<25;i++)
                 {
                     t1.insertRow(i, new Object[]{""});
                     t1.setValueAt(second.wset[i], i, 0);
                     t1.setValueAt("x"+(i+1), i, 3);
                 }
           
//            for(int i=0;i<5;i++) {
//                t2.insertRow(i, new Object[]{""});
//            }

            rs=stmt.executeQuery("SELECT DISTINCT `cls` FROM `document`");
            while(rs.next()) {
                cls=rs.getString(1);
                co=0;
                System.out.println("cls==="+cls);
                for(int i=2;i<=26;i++) {
                    rs1=stmt1.executeQuery("SELECT * FROM `document`");
                    while(rs1.next()) {
                        System.out.println("in while");
                        cls1=rs1.getString(27);
                        w1=rs1.getInt(i);
                        w2=w2+w1;
                        System.out.println("i="+i+"==w1:"+w1);
                        if(cls.equalsIgnoreCase(cls1)) {
                            c=1;

                        } else {
                            c=0;
                        }
                        w=w+w1*c;
                    }
                    fw=w / w2;
                    String fx=df.format(fw);
                    fw=Float.parseFloat(fx);
                    if(cls.equalsIgnoreCase("c1")) {
                        x1[co]=fw;
                        co++;
                    } else if(cls.equalsIgnoreCase("c2")) {
                        x2[co]=fw;
                        co++;
                    }
                    System.out.println("fw:"+fw+"\n----w:"+w+"----w2:"+w2);
                    w=0;w2=0;fw=0;
                }

            }
System.out.println("co:"+co);
            for(int i=0;i<co;i++) {
                //t2.setValueAt("x"+(i+1), r++, i);
                t1.setValueAt(x1[i], i, 1);
                t1.setValueAt(x2[i], i, 2);
                r=0;
                System.out.println("x1:"+x1[i]+"-----------x2:"+x2[i]);
            }
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            stmt.executeUpdate(qry);
            System.out.println("query======"+qry);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fourth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

}
