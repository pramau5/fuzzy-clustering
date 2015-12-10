

package fuzzyclustering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class third extends javax.swing.JFrame {
javax.swing.table.DefaultTableModel t1=new javax.swing.table.DefaultTableModel();
javax.swing.table.DefaultTableModel t2=new javax.swing.table.DefaultTableModel();
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
    public third() {
        initComponents();
        try
        {
            //System.out.println("minus:"+(0.57-0.5));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuzzy","root","password");
            stmt=conn.createStatement();
            stmt1=conn.createStatement();
            stmt.executeUpdate("DROP TABLE `document`");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel2.setBounds(10, 10, 730, 50);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 460, 560, 220);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 51));
        jLabel3.setText("Occurance of Features");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(500, 140, 200, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 190, 270, 200);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(450, 190, 270, 200);

        jPanel1.setBackground(new java.awt.Color(96, 187, 232));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jButton2.setText("Word Pattern Set");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Feature Matrix");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Feature Occurance");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Word Pattern");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 190, 140, 210);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 51));
        jLabel4.setText("Feature Matrix");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 410, 200, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 51));
        jLabel5.setText("Word Pattern Set");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(200, 130, 200, 40);

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Feature Clustering");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 90, 260, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gback1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 760, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            System.out.println("Selecting the dataset pramod!");
            String qry="CREATE TABLE `fuzzy`.`document` (`fname` VARCHAR( 100 ) NULL ";
            String qry1 = "";
        table1.setModel(t1);
        t1.addColumn("Word Set");
        //create Columns
        for(int i=0;i<25;i++)
        {
            t1.addColumn(second.wset[i]);
            qry1=qry1+",`"+second.wset[i]+"` int( 5 ) NULL";
        }
        qry1=qry+qry1+",`cls` VARCHAR( 100 ) NULL)";
        System.out.println("qry1:"+qry1);
        stmt.executeUpdate(qry1);
        
        t1.addColumn("Class");
        //create rows
//for(int i=0;i<500;i++)
               
            String files1,str,str1,str2,cname;
           String path=first.path;//"/Volumes/D/fuzzy/fuzzy-dataset/data1/";

            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0,r=0,c=1;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();
                    t1.insertRow(rco, new Object[]{""});
                    t1.setValueAt(files1, rco, 0);
                }
                rco++;
            }
            path="/Volumes/D/fuzzy/freq/";

            folder1 = new File(path);
            listOfFiles1 = folder1.listFiles();
            
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();
                    for(int i=1;i<t1.getColumnCount()-1;i++)
                    {
                        count=0;
                    cname=t1.getColumnName(i);
                    System.out.println("clm name:"+cname+"co:"+i);
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str=br.readLine())!=null)
                    {
                               // System.out.println("str:"+str);
                        str1=str.substring(0, str.indexOf(":"));

                       // for(int i=0;i<10;i++)
                        //{
                            if(str1.equalsIgnoreCase(cname))
                            {
                                str2=str.substring(str.indexOf(":")+1);
                                t1.setValueAt(str2, r,i);
                                count++;
                               // System.out.println("str1:"+str1+"---str2:"+str2);
                            }
//                            else
//                            {
//                                t1.setValueAt("0", r,c);
//                            }
                            //c++;
                       // }

                    }
                    if(count==0)
                        t1.setValueAt("0", r,i);
                    }
                    //count++;
                    //c=0;
                    r++;
                    //rco++;
                    //jTextArea1.append("\nFILE"+(lf1+1)+"\n\n");
                }
            }
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            t1.setValueAt("c1", 0, t1.getColumnCount()-1);
            t1.setValueAt("c1", 1, t1.getColumnCount()-1);
            t1.setValueAt("c1", 2, t1.getColumnCount()-1);
            t1.setValueAt("c2", 3, t1.getColumnCount()-1);
            t1.setValueAt("c2", 4, t1.getColumnCount()-1);

            //insert into DB
            qry="INSERT INTO `fuzzy`.`document`VALUES(";
            for(int i=0;i<r;i++)
            {
            for(int j=0;j<t1.getColumnCount();j++)
            {
                System.out.println("val:"+t1.getValueAt(i, j));
                if(j==0)
                    qry1="'"+t1.getValueAt(i, j)+"'";
                else
                    qry1=qry1+",'"+t1.getValueAt(i, j)+"'";
            }
            qry1=qry+qry1+")";
            System.out.println("qry:"+qry1);
            stmt.executeUpdate(qry1);
            //qry="";
            qry1="";
            }
            
            //INSERT INTO `fuzzy`.`document` (`fname`, `class`, `commiss`, `approxim`, `house`, `reinforc`, `countries`, `reute`, `kei`, `trucks`, `mln`, `jones`, `stock`, `futures`, `pct`, `cars`, `subsidiaries`) VALUES (';l;', 'l;l;', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
            
            

        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         for(int i=0;i<25;i++)
        {
            jTextArea1.append(second.wset[i]+"\n");
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<25;i++)
        {
            try 
            {
                String s = second.wset[i];
                String qry1 = "SELECT SUM(`" + s + "`) FROM `document` ";
                System.out.println("qry1:" + qry1);
                rs = stmt.executeQuery(qry1);
                while (rs.next()) 
                {
                    int c=rs.getInt(1);
                    jTextArea2.append(s + ": "+c+"\n");
                }
                
            }
            catch (Exception ex)
            {
               System.out.println("Excep:" +ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        fourth fth=new fourth();
        fth.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed
//void mean()
//    {
//     try
//        {
//            for(int i=0;i<co;i++)
//            {
//                mean=mean+x1[i];
//                mean1=mean1+x2[i];
//                System.out.println("x1:"+x1[i]+"-----------x2:"+x2[i]);
//            }
//            m11=mean/co;
//            String ff=df.format(m11);
//            mean=Float.parseFloat(ff);
//            m[mco]=mean;
//            mco++;
//            m12=mean1/co;
//            ff=df.format(m12);
//            mean1=Float.parseFloat(ff);
//            m[mco]=mean1;
//            System.out.println("m:"+mean+"-----------m1:"+mean1);
//            System.out.println("m:"+m[0]+"-----------m1:"+m[1]);
//            jTextArea1.append("Mean : <"+m[0]+","+m[1]+">");
//
//
//        }
//        catch(Exception e)
//        {
//
//        }
//}
//    void deviation ()
//    {
//         try
//        {
//            float v1,v2,v3,v4;
//            //System.out.println("m1:"+m[0]+"-----m2:"+m[1]);
//            for(int i=0;i<co;i++)
//            {
//               // System.out.println("x1:"+x1[i]+"-----x2:"+x2[i]+"m1:"+m[0]+"-----m2:"+m[1]);
//                v1=x1[i]-m[0];
//                v2=x2[i]-m[1];
//                v3=v1*v1;
//                v4=v2*v2;
//                //System.out.println("v1:"+v1+"-----v2:"+v2);
//                System.out.println("v3:"+v3+"-----v4:"+v4);
//                dv=dv+v3;
//                dv1=dv1+v4;
//                //System.out.println("dv1:"+dv+"-----dv2:"+dv1);
//
//            }
//            System.out.println("dv:"+dv+"-----------dv1:"+dv1);
//            fdv=(float) Math.sqrt((dv/co));
//            fdv1=(float) Math.sqrt((dv1/co));
//
//            String ff=df.format(fdv);
//            fdv=Float.parseFloat(ff);
//            ff=df.format(fdv1);
//            fdv1=Float.parseFloat(ff);
//            d[0]=fdv;
//            d[1]=fdv1;
//            //System.out.println("dv:"+fdv+"-----------dv1:"+fdv1);
//            jTextArea1.append("\n\nDeviation : <"+fdv+","+fdv1+">");
//            }
//        catch(Exception e)
//        {
//
//        }
//    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new third().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables

}
