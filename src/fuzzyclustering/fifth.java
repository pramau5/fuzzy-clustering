
package fuzzyclustering;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JTable;


public class fifth extends javax.swing.JFrame {

//float w1[]={0.50f,0.00f,0.44f,1.00f,1.00f,0.67f,0.67f,1.00f,0.67f,0.75f,0.33f,0.00f,0.00f,0.50f,1.00f};
//float w2[]={0.50f,0.10f,0.56f,0.00f,0.00f,0.33f,0.33f,0.00f,0.33f,0.25f,0.77f,1.00f,1.00f,0.50f,0.00f};
int count,csize,cls,tco,cno;
public static int co=0;
float m1,m2,vl;
float v1,v2,v3,v4,v,wi1,wi2;
float d1,d2;
Statement stmt,stmt1,stmt2;
ResultSet rs,rs1;
String str,str1,str2,str3,str4,m,d,wd="";
DecimalFormat df=new DecimalFormat("##.##");
float w1[]=new float[100];
float w2[]=new float[100];
String sim[]=new String[100];
float mt1,dt1,A1,B1,mt2,dt2,A2,B2,a1,a2;
javax.swing.table.DefaultTableModel t1=new javax.swing.table.DefaultTableModel();

int r=0,c=0;
float val,va;
javax.swing.table.DefaultTableModel t4=new javax.swing.table.DefaultTableModel();
javax.swing.table.DefaultTableModel t2=new javax.swing.table.DefaultTableModel();
javax.swing.table.DefaultTableModel t3=new javax.swing.table.DefaultTableModel();

    public fifth() {
        initComponents();
        try
        {
            System.out.println("minus:"+Math.exp(-25.0));
            //System.out.println("minus:"+Math.exp(-6.9));
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuzzy","root","password");
            stmt=conn.createStatement();
            stmt1=conn.createStatement();
            stmt2=conn.createStatement();
            stmt.executeUpdate("TRUNCATE TABLE `sim`");
            stmt.executeUpdate("TRUNCATE TABLE `sim1`");
            stmt.executeUpdate("TRUNCATE TABLE `simpat`");
            stmt.executeUpdate("TRUNCATE TABLE `cluster`");
            stmt.executeUpdate("DROP TABLE `similarity1`");

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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 750));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Periodic Outlier Pattern Mining Algorithm");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 0, 730, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 240, 700, 170);

        jPanel1.setBackground(new java.awt.Color(152, 213, 244));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Similarity");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Weighting Metrices");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Cluster");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(160, 100, 440, 80);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 470, 220, 210);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(table2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(260, 470, 220, 210);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(table3);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(500, 470, 220, 210);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Hard Weight");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 430, 110, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Soft Weight");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 430, 110, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Mixed Weight");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(550, 430, 120, 30);

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Fuzzy Similarity & weighting Metrices");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 180, 490, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gback1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-60, -30, 860, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jTable1.setModel(t1);


                // TODO add your handling code here:
        try
        {
           w1=fourth.x1;
           w2=fourth.x2;
           co=fourth.co;
            count=0;
            rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
            while(rs.next())
            {
                tco=rs.getInt(1);
            }
            if(tco>0)
            {
                //cluster modification
                for(int i=0;i<co;i++)
                {
                  wi1=w1[i];
                        wi2=w2[i];
                        rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
                        while(rs.next())
                        {
                        tco=rs.getInt(1);
                        }
                        if(tco==1)
               {
                          //  System.out.println("1 clus:"+tco);
                rs=stmt.executeQuery("SELECT * FROM `cluster`");
                while(rs.next())
                {
                    count=rs.getInt(1);
                    csize=rs.getInt(2);
                    str1=rs.getString(3);
                    str2=rs.getString(4);
                    str3=rs.getString(5);
                    str4=rs.getString(6);
                    wd="x"+(i+1);
                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                   // System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);


                    //System.out.println("w1:"+wi1+"---w2:"+wi2);
               v1=((wi1-m1)/d1);
               v2=((wi2-m2)/d2);
               v3=(float) Math.exp(-(v1*v1));
               v4=(float) Math.exp(-(v2*v2));
               v=v3*v4;
              // System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
               String ff=df.format(v);
               v=Float.parseFloat(ff);
               System.out.println("v:"+v);
              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");

               // cal. similarity
              // System.out.println("count:"+tco);
              // System.out.println("v==========:"+v);
                if(v>0.5)
                {
                    mt1=((csize*m1)+wi1)/(csize+1);
                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
                    B1=((csize+1)/csize)*(mt1*mt1);
                    if(A1>=B1)
                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
                    else
                        dt1=(float) Math.sqrt(B1-A1)+0.1f;

                    mt2=((csize*m2)+wi2)/(csize+1);
                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
                    B2=((csize+1)/csize)*(mt2*mt2);

                    if(A2>=B2)
                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
                    else
                        dt2=(float) Math.sqrt(B2-A2)+0.1f;

                    csize=csize+1;
                    m="<"+mt1+","+mt2+">";
                    d="<"+dt1+","+dt2+">";

                   // System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
                   // System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
                   // jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
                   // jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);

                   str2=str2+" , w"+(i+1);
                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `words`='"+str2+"',`mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
                    stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+vl+"', '"+wd+"');");

                }
                else
                {
                    wi1=w1[i];
                    wi2=w2[i];
                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
                    count=count+1;
                    csize=1;
                    str1=wi1+","+wi2;
                    str2="w"+(i+1);
                    wd="x"+(i+1);
                    m1=wi1;
                    m2=wi2;
                    d1=0.1f;
                    d2=0.1f;

                    m="<"+m1+","+m2+">";
                    d="<"+d1+","+d2+">";
                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
                    stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '1.0', '"+wd+"');");
                }
               }
                        }
                else
               {
                            //compare similarity
                         //   System.out.println("more clus:"+tco);
                rs=stmt.executeQuery("SELECT * FROM `cluster`");
                while(rs.next())
                {
                    count=rs.getInt(1);
                    csize=rs.getInt(2);
                    str1=rs.getString(3);
                    str2=rs.getString(4);
                    str3=rs.getString(5);
                    str4=rs.getString(6);
                   wd="x"+(i+1);
                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                  // System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);


                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
               v1=((wi1-m1)/d1);
               v2=((wi2-m2)/d2);
               v3=(float) Math.exp(-(v1*v1));
               v4=(float) Math.exp(-(v2*v2));
               v=v3*v4;
             //   System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
               String ff=df.format(v);
               v=Float.parseFloat(ff);
               System.out.println("v:"+v);
               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+v+"', '"+wd+"');");
               //String sim1=count+","+v;
               //sim[co]=sim1;
               //co++;
              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
                   }
                rs=stmt.executeQuery("SELECT * FROM `sim` ORDER BY `val` ASC");
                while(rs.next())
                {
                    cno=rs.getInt(1);
                    vl=rs.getFloat(2);

               }
                System.out.println("cno:"+cno+"--vl:"+vl);
                    if(vl<0.5)
                    {
                        System.out.println("Create New Cluster");

                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
                    count=count+1;
                    csize=1;
                    str1=wi1+","+wi2;
                    str2="w"+(i+1);

                    m1=wi1;
                    m2=wi2;
                    d1=0.1f;
                    d2=0.1f;

                    m="<"+m1+","+m2+">";
                    d="<"+d1+","+d2+">";
                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
                    //stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '1.0', '"+wd+"');");
                    }
                    else
                    {
                        System.out.println("Modify Cluster");
                        rs=stmt.executeQuery("SELECT * FROM `cluster`WHERE `no`='"+cno+"'");
                        while(rs.next())
                        {
                        count=rs.getInt(1);
                        csize=rs.getInt(2);
                        str1=rs.getString(3);
                        str2=rs.getString(4);
                        str3=rs.getString(5);
                        str4=rs.getString(6);
                        wd="x"+(i+1);
                        m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                        m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                        d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                        d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                       // System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);

                        }
                        mt1=((csize*m1)+wi1)/(csize+1);
                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
                    a1=((csize*mt1)+wi1)/(csize+1);
                    B1=((csize+1)/csize)*((a1*a1));
                    if(A1>=B1)
                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
                    else
                        dt1=(float) Math.sqrt(B1-A1)+0.1f;

                    mt2=((csize*m2)+wi2)/(csize+1);
                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
                    a2=((csize*mt2)+wi2)/(csize+1);
                    B2=((csize+1)/csize)*(a2*a2);

                    if(A2>=B2)
                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
                    else
                        dt2=(float) Math.sqrt(B2-A2)+0.1f;

                    csize=csize+1;
                    String mt=df.format(mt1);
                    mt1=Float.parseFloat(mt);
                     mt=df.format(mt2);
                    mt2=Float.parseFloat(mt);
                     mt=df.format(dt1);
                    dt1=Float.parseFloat(mt);
                     mt=df.format(dt2);
                    dt2=Float.parseFloat(mt);
                    m="<"+mt1+","+mt2+">";
                    d="<"+dt1+","+dt2+">";
                   // System.out.println("m1=:"+mt1+"--m2="+mt2);
                   // System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
                   // System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
                   // jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
                   // jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);

                    //csize=csize+1;
                    str2=str2+" , w"+(i+1);
                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `words`='"+str2+"',`mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
                   // stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+vl+"', '"+wd+"');");
                    }

                }
                        stmt2.executeUpdate("TRUNCATE TABLE `fuzzy`.`sim`");

                }
            }
            else
            {
                System.out.println("No Existing Clusters");
                for(int i=0;i<co;i++)
                {
                    System.out.println("i=="+i);
                    if(i==0)
                    {
                          System.out.println("no clus==="+i);
                    wi1=w1[i];
                    wi2=w2[i];
                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
                    m1=wi1;
                    m2=wi2;
                    d1=0.1f;
                    d2=0.1f;
                    csize=1;
                    cls=1;
                    str1=wi1+","+wi2;
                    str2="w"+(i+1);
                    wd="x"+(i+1);
                    m="<"+m1+","+m2+">";
                    d="<"+d1+","+d2+">";
                    stmt.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+cls+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
                    stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+cls+"', '1.0', '"+wd+"');");
                    }
                    else
                    {
                        wi1=w1[i];
                        wi2=w2[i];
                        rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
                        while(rs.next())
                        {
                        tco=rs.getInt(1);
                        }
                        System.out.println("======tco============"+tco);
                        if(tco==1)
               {
                          //  System.out.println("1 clus:");
                rs=stmt.executeQuery("SELECT * FROM `cluster`");
                while(rs.next())
                {
                    count=rs.getInt(1);
                    csize=rs.getInt(2);
                    str1=rs.getString(3);
                    str2=rs.getString(4);
                    str3=rs.getString(5);
                    str4=rs.getString(6);
                    wd="x"+(i+1);
                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                  //  System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);


                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
               v1=((wi1-m1)/d1);
               v2=((wi2-m2)/d2);
               v3=(float) Math.exp(-(v1*v1));
               v4=(float) Math.exp(-(v2*v2));
               v=v3*v4;
             //  System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
               String ff=df.format(v);
               v=Float.parseFloat(ff);
               System.out.println("v:"+v);
              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");

               // cal. similarity
              // System.out.println("count:"+tco);

                if(v>0.5)
                {
                     System.out.println("1 clus cluster modification======="+i);
                    mt1=((csize*m1)+wi1)/(csize+1);
                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
                    B1=((csize+1)/csize)*(mt1*mt1);
                    if(A1>=B1)
                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
                    else
                        dt1=(float) Math.sqrt(B1-A1)+0.1f;

                    mt2=((csize*m2)+wi2)/(csize+1);
                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
                    B2=((csize+1)/csize)*(mt2*mt2);

                    if(A2>=B2)
                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
                    else
                        dt2=(float) Math.sqrt(B2-A2)+0.1f;


                    String mt=df.format(mt1);
                    mt1=Float.parseFloat(mt);
                     mt=df.format(mt2);
                    mt2=Float.parseFloat(mt);
                     mt=df.format(dt1);
                    dt1=Float.parseFloat(mt);
                     mt=df.format(dt2);
                    dt2=Float.parseFloat(mt);

                    csize=csize+1;
                    m="<"+mt1+","+mt2+">";
                    d="<"+dt1+","+dt2+">";

                //    System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
                 //   System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
                    //jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
                    //jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);

                    str2=str2+" , w"+(i+1);
                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"',`words`='"+str2+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
                    stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+v+"', '"+wd+"');");

                }
                else
                {
                   System.out.println("1 clus ====new cluster========"+i);
                    wi1=w1[i];
                    wi2=w2[i];
                 //   System.out.println("w1:"+wi1+"---w2:"+wi2);
                    count=count+1;
                    csize=1;
                    str1=wi1+","+wi2;
                    str2="w"+(i+1);
                    wd="x"+(i+1);
                    m1=wi1;
                    m2=wi2;
                    d1=0.1f;
                    d2=0.1f;

                    m="<"+m1+","+m2+">";
                    d="<"+d1+","+d2+">";
                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
                    stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '1.0', '"+wd+"');");
                }
               }
                        }
                else
               {
                            //compare similarity
                          //  System.out.println("more clus:"+i);
                rs=stmt.executeQuery("SELECT * FROM `cluster`");
                while(rs.next())
                {
                    count=rs.getInt(1);
                    csize=rs.getInt(2);
                    str1=rs.getString(3);
                    str2=rs.getString(4);
                    str3=rs.getString(5);
                    str4=rs.getString(6);
                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                  //  System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
                    wd="x"+(i+1);

                   // System.out.println("w1:"+wi1+"---w2:"+wi2);
               v1=((wi1-m1)/d1);
               v2=((wi2-m2)/d2);
               v3=(float) Math.exp(-(v1*v1));
               v4=(float) Math.exp(-(v2*v2));
               v=v3*v4;
              //  System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
               String ff=df.format(v);
               v=Float.parseFloat(ff);
            //   System.out.println("v:"+v);
               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+v+"', '"+wd+"');");
              // stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
               //String sim1=count+","+v;
               //sim[co]=sim1;
               //co++;
              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
                   }
                rs=stmt.executeQuery("SELECT * FROM `sim` ORDER BY `val` ASC");
                while(rs.next())
                {
                    cno=rs.getInt(1);
                    vl=rs.getFloat(2);

               }
                System.out.println("cno:"+cno+"--vl:"+vl);
                    if(vl<0.5)
                    {
                        System.out.println("Create New Cluster====="+i+"===v1=="+vl);

                  //  System.out.println("w1:"+wi1+"---w2:"+wi2);
                    count=count+1;
                    csize=1;
                    str1=wi1+","+wi2;
                    str2="w"+(i+1);

                    m1=wi1;
                    m2=wi2;
                    d1=0.1f;
                    d2=0.1f;
                    wd="x"+(i+1);
                    m="<"+m1+","+m2+">";
                    d="<"+d1+","+d2+">";
                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
                    //stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+vl+"', '"+wd+"');");
                    }
                    else
                    {
                        System.out.println("Modify Cluster====="+i+"===v1=="+vl);
                        rs=stmt.executeQuery("SELECT * FROM `cluster`WHERE `no`='"+cno+"'");
                        while(rs.next())
                        {
                        count=rs.getInt(1);
                        csize=rs.getInt(2);
                        str1=rs.getString(3);
                        str2=rs.getString(4);
                        str3=rs.getString(5);
                        str4=rs.getString(6);
                        wd="x"+(i+1);
                        m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
                        m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
                        d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
                        d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
                    //    System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);

                        }
                        mt1=((csize*m1)+wi1)/(csize+1);
                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
                    a1=((csize*mt1)+wi1)/(csize+1);
                    B1=((csize+1)/csize)*((a1*a1));
                    if(A1>=B1)
                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
                    else
                        dt1=(float) Math.sqrt(B1-A1)+0.1f;

                    mt2=((csize*m2)+wi2)/(csize+1);
                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
                    a2=((csize*mt2)+wi2)/(csize+1);
                    B2=((csize+1)/csize)*(a2*a2);

                    if(A2>=B2)
                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
                    else
                        dt2=(float) Math.sqrt(B2-A2)+0.1f;

                    csize=csize+1;
                    String mt=df.format(mt1);
                    mt1=Float.parseFloat(mt);
                     mt=df.format(mt2);
                    mt2=Float.parseFloat(mt);
                     mt=df.format(dt1);
                    dt1=Float.parseFloat(mt);
                     mt=df.format(dt2);
                    dt2=Float.parseFloat(mt);
                    m="<"+mt1+","+mt2+">";
                    d="<"+dt1+","+dt2+">";
                  //  System.out.println("m1=:"+mt1+"--m2="+mt2);
                   // System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
                  //  System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
                    //jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
                    //jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);

                    //csize=csize+1;
                    str2=str2+" , w"+(i+1);
                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"',`words`='"+str2+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
                   // stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`clus`, `sval`, `word`) VALUES ('"+count+"', '"+vl+"', '"+wd+"');");
                    }

                }
                        stmt2.executeUpdate("TRUNCATE TABLE `fuzzy`.`sim`");




                    }
                }
            }

//            t1.addColumn("Similarity");
//            for(int i=0;i<co;i++)
//                {
//                t1.addColumn("x"+(i+1));
//                }
//            rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
//                        while(rs.next())
//                        {
//                        tco=rs.getInt(1);
//                        }
//            for(int i=0;i<tco;i++)
//            {
//                t1.insertRow(i, new Object[]{""});
//                t1.setValueAt("C"+(i+1), i, 0);
//            }
//            for(int i=0;i<tco;i++)
//            {
//                for(int j=0;j<co;j++)
//                {
//
//                }
//            }



            float sval = 0;
            jTable1.setModel(t1);
             jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

             //create similarity table
           String qry="CREATE TABLE `fuzzy`.`similarity1` (`cno` INT( 100 ) NULL ";

           String qry1="",qry2="",qry3="";
           //stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
           qry2="INSERT INTO `fuzzy`.`similarity1` (`cno`";
           for(int i=0;i<co;i++)
           {
                qry1=qry1+",`x"+(i+1)+"` FLOAT NULL";
                qry2=qry2+" , `x"+(i+1)+"`";
           }
           qry=qry+qry1+")";
           qry2=qry2+") VALUES (";
           System.out.println("qry1:"+qry);
           stmt.executeUpdate(qry);

            t1.addColumn("Similarity");
            for(int i=0;i<co;i++)
                {
                t1.addColumn("x"+(i+1));
                }
            rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
                        while(rs.next())
                        {
                        tco=rs.getInt(1);
                        }
            for(int i=0;i<tco;i++)
            {
                t1.insertRow(i, new Object[]{""});
                t1.setValueAt("C"+(i+1), i, 0);
            }
        for(int i=0;i<tco;i++)
            {
            qry3=(i+1)+"";
                for(int j=0;j<co;j++)
                {
                    qry="SELECT `sval` FROM `sim1` WHERE `clus`='"+(i+1)+"' AND `word`='x"+(j+1)+"'";
                  //  System.out.println("qry========="+qry);
                    rs=stmt.executeQuery(qry);
                    while(rs.next())
                    {
                      sval=rs.getFloat(1)  ;



                    }
                    t1.setValueAt(sval, i, (j+1));
                    qry3=qry3+","+sval+"";

                }
            qry3=qry2+qry3+")";
            stmt.executeUpdate(qry3);
            System.out.println("qry3========="+qry3);
            }

        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        // TODO add your handling code here:
//        try
//        {
//            int r=0;
//        rs=stmt.executeQuery("SELECT * FROM `cluster` ORDER BY `cluster`.`no` ASC");
//        while(rs.next())
//          {
//            table1.setValueAt("G"+rs.getString(1), r,0);
//            table1.setValueAt(rs.getString(2), r,1);
//            table1.setValueAt(rs.getString(5), r,2);
//            table1.setValueAt(rs.getString(6), r,3);
//            r++;
//          }
//        }
//        catch(Exception e)
//        {
//            System.out.println("Excep:"+e.getMessage());
//        }

         cluster cs=new cluster();
        cs.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        sixth sx=new sixth();
//        sx.setVisible(true);
        int va1=0,va2=0;
        c=0;
          try
        {
            table1.setModel(t4);
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            rs=stmt.executeQuery("SELECT COUNT(*) FROM `similarity1`");
            while(rs.next())
            {
               tco=rs.getInt(1);
              // System.out.println("co:"+rs.getString(1));

            }
            System.out.println("co:"+tco);
            for(int i=0;i<tco;i++)
            {
                t4.addColumn("Sim(G"+(i+1)+")");

            }
            for(int i=0;i<co;i++)
            {
            t4.insertRow(i, new Object[]{""});
            }

            rs=stmt.executeQuery("SELECT * FROM `similarity1`");
            while(rs.next())
            {

                //co=rs.getInt(1)   ;

             //t1.setValueAt(co, 0, c);
                for(int i=2;i<=(co+1);i++)
               {

                    val=rs.getFloat(i);

                   if(val>0.9)
                       va1=1;
                   else
                       va1=0;
                   t4.setValueAt(va1, (i-2), c);

               }
             c++;

            }



            //soft

             c=0;
            table2.setModel(t2);
            table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            System.out.println("co:"+tco);
            for(int i=0;i<tco;i++)
            {
                t2.addColumn("Sim(G"+(i+1)+")");

            }
            for(int i=0;i<co;i++)
            {
            t2.insertRow(i, new Object[]{""});
            }

            rs=stmt.executeQuery("SELECT * FROM `similarity1`");
            while(rs.next())
            {

               // co=rs.getInt(1)   ;

             //t1.setValueAt(co, 0, c);
                for(int i=2;i<=(co+1);i++)
               {

                    val=rs.getFloat(i);
                    t2.setValueAt(val, (i-2), c);

               }
             c++;

            }
//
//            //mixed
//
            table3.setModel(t3);
            table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            System.out.println("co:"+tco);
            for(int i=0;i<tco;i++)
            {
                t3.addColumn("Sim(G"+(i+1)+")");

            }
            for(int i=0;i<co;i++)
            {
            t3.insertRow(i, new Object[]{""});
            }
            for(int i=0;i<tco;i++)
            {
                for(int j=0;j<co;j++)
                {
                     System.out.println("i:"+i+"---j="+j);
                     //System.out.println("val:"+table2.getValueAt(0, 0));
                    v1=Float.parseFloat(table1.getValueAt(j, i).toString());
                    v2=Float.parseFloat(table2.getValueAt(j, i).toString());
                    va=(float) (((0.5) * v1) + ((1 - 0.5)*v2));
                    String st=df.format(va);
                    va=Float.parseFloat(st);
                    System.out.println("v1:"+v1+"---v2="+v2+"--v3:"+va);
                    t3.setValueAt(va, j, i);
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fifth().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables

}


// old coding

//        // TODO add your handling code here:
//        try
//        {
//           w1=fourth.x1;
//           w2=fourth.x2;
//           co=fourth.co;
//           System.out.println("w1="+w1+"==w2="+w2+"==co="+co);
//
//           //create similarity table
////           String qry="CREATE TABLE `fuzzy`.`similarity` (`cno` INT( 100 ) NULL ";
////
////           String qry1="";
////           for(int i=0;i<co;i++)
////           {
////                qry1=qry1+",`x"+i+"` FLOAT NULL";
////           }
////           qry=qry+qry1+")";
////           System.out.println("qry1:"+qry);
////           stmt.executeUpdate(qry);
//            count=0;
//            rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
//            while(rs.next())
//            {
//                tco=rs.getInt(1);
//            }
//            if(tco>0)
//            {
//                //cluster modification
//                for(int i=0;i<co;i++)
//                {
//                  wi1=w1[i];
//                        wi2=w2[i];
//                        rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
//                        while(rs.next())
//                        {
//                        tco=rs.getInt(1);
//                        }
//                        if(tco==1)
//               {
//                            System.out.println("1 clus:"+tco);
//                rs=stmt.executeQuery("SELECT * FROM `cluster`");
//                while(rs.next())
//                {
//                    count=rs.getInt(1);
//                    csize=rs.getInt(2);
//                    str1=rs.getString(3);
//                    str2=rs.getString(4);
//                    str3=rs.getString(5);
//                    str4=rs.getString(6);
//                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                    System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//               v1=((wi1-m1)/d1);
//               v2=((wi2-m2)/d2);
//               v3=(float) Math.exp(-(v1*v1));
//               v4=(float) Math.exp(-(v2*v2));
//               v=v3*v4;
//               System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
//               String ff=df.format(v);
//               v=Float.parseFloat(ff);
//               System.out.println("v:"+v);
//              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
//
//               // cal. similarity
//               System.out.println("count:"+tco);
//
//                if(v>0.7)
//                {
//                    mt1=((csize*m1)+wi1)/(csize+1);
//                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
//                    B1=((csize+1)/csize)*(mt1*mt1);
//                    if(A1>=B1)
//                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
//                    else
//                        dt1=(float) Math.sqrt(B1-A1)+0.1f;
//
//                    mt2=((csize*m2)+wi2)/(csize+1);
//                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
//                    B2=((csize+1)/csize)*(mt2*mt2);
//
//                    if(A2>=B2)
//                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
//                    else
//                        dt2=(float) Math.sqrt(B2-A2)+0.1f;
//
//                    csize=csize+1;
//                    m="<"+mt1+","+mt2+">";
//                    d="<"+dt1+","+dt2+">";
//
//                    System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
//                    System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
//                   // jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
//                   // jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);
//
//
//                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
//
//
//                }
//                else
//                {
//                    wi1=w1[i];
//                    wi2=w2[i];
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//                    count=count+1;
//                    csize=1;
//                    str1=wi1+","+wi2;
//                    str2="word2";
//
//                    m1=wi1;
//                    m2=wi2;
//                    d1=0.1f;
//                    d2=0.1f;
//
//                    m="<"+m1+","+m2+">";
//                    d="<"+d1+","+d2+">";
//                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
//                }
//               }
//                        }
//                else
//               {
//                            //compare similarity
//                            System.out.println("more clus:"+tco);
//                rs=stmt.executeQuery("SELECT * FROM `cluster`");
//                while(rs.next())
//                {
//                    count=rs.getInt(1);
//                    csize=rs.getInt(2);
//                    str1=rs.getString(3);
//                    str2=rs.getString(4);
//                    str3=rs.getString(5);
//                    str4=rs.getString(6);
//                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                    System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//               v1=((wi1-m1)/d1);
//               v2=((wi2-m2)/d2);
//               v3=(float) Math.exp(-(v1*v1));
//               v4=(float) Math.exp(-(v2*v2));
//               v=v3*v4;
//                System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
//               String ff=df.format(v);
//               v=Float.parseFloat(ff);
//               System.out.println("v:"+v);
//               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
//               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
//               //String sim1=count+","+v;
//               //sim[co]=sim1;
//               //co++;
//              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
//                   }
//                rs=stmt.executeQuery("SELECT * FROM `sim` ORDER BY `val` ASC");
//                while(rs.next())
//                {
//                    cno=rs.getInt(1);
//                    vl=rs.getFloat(2);
//
//               }
//                System.out.println("cno:"+cno+"--vl:"+vl);
//                    if(v1>0.7)
//                    {
//                        System.out.println("Create New Cluster");
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//                    count=count+1;
//                    csize=1;
//                    str1=wi1+","+wi2;
//                    str2="word3";
//
//                    m1=wi1;
//                    m2=wi2;
//                    d1=0.1f;
//                    d2=0.1f;
//
//                    m="<"+m1+","+m2+">";
//                    d="<"+d1+","+d2+">";
//                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
//
//                    }
//                    else
//                    {
//                        System.out.println("Modify Cluster");
//                        rs=stmt.executeQuery("SELECT * FROM `cluster`WHERE `no`='"+cno+"'");
//                        while(rs.next())
//                        {
//                        count=rs.getInt(1);
//                        csize=rs.getInt(2);
//                        str1=rs.getString(3);
//                        str2=rs.getString(4);
//                        str3=rs.getString(5);
//                        str4=rs.getString(6);
//                        m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                        m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                        d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                        d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                        System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//                        }
//                        mt1=((csize*m1)+wi1)/(csize+1);
//                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
//                    a1=((csize*mt1)+wi1)/(csize+1);
//                    B1=((csize+1)/csize)*((a1*a1));
//                    if(A1>=B1)
//                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
//                    else
//                        dt1=(float) Math.sqrt(B1-A1)+0.1f;
//
//                    mt2=((csize*m2)+wi2)/(csize+1);
//                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
//                    a2=((csize*mt2)+wi2)/(csize+1);
//                    B2=((csize+1)/csize)*(a2*a2);
//
//                    if(A2>=B2)
//                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
//                    else
//                        dt2=(float) Math.sqrt(B2-A2)+0.1f;
//
//                    csize=csize+1;
//                    String mt=df.format(mt1);
//                    mt1=Float.parseFloat(mt);
//                     mt=df.format(mt2);
//                    mt2=Float.parseFloat(mt);
//                     mt=df.format(dt1);
//                    dt1=Float.parseFloat(mt);
//                     mt=df.format(dt2);
//                    dt2=Float.parseFloat(mt);
//                    m="<"+mt1+","+mt2+">";
//                    d="<"+dt1+","+dt2+">";
//                    System.out.println("m1=:"+mt1+"--m2="+mt2);
//                    System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
//                    System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
//                   // jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
//                   // jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);
//
//                    //csize=csize+1;
//                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
//
//                    }
//
//                }
//                        stmt2.executeUpdate("TRUNCATE TABLE `fuzzy`.`sim`");
//
//                }
//            }
//            else
//            {
//                System.out.println("No Existing Clusters");
//                for(int i=0;i<co;i++)
//                {
//                    System.out.println("i=="+i);
//                    if(i==0)
//                    {
//                          System.out.println("no clus");
//                    wi1=w1[i];
//                    wi2=w2[i];
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//                    m1=wi1;
//                    m2=wi2;
//                    d1=0.1f;
//                    d2=0.1f;
//                    csize=1;
//                    cls=1;
//                    str1=wi1+","+wi2;
//                    str2="word1";
//                    m="<"+m1+","+m2+">";
//                    d="<"+d1+","+d2+">";
//                    stmt.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+cls+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
//
//                    }
//                    else
//                    {
//                        wi1=w1[i];
//                        wi2=w2[i];
//                        rs=stmt.executeQuery("SELECT COUNT(*) FROM `cluster`");
//                        while(rs.next())
//                        {
//                        tco=rs.getInt(1);
//                        }
//                        if(tco==1)
//               {
//                            System.out.println("1 clus:"+tco);
//                rs=stmt.executeQuery("SELECT * FROM `cluster`");
//                while(rs.next())
//                {
//                    count=rs.getInt(1);
//                    csize=rs.getInt(2);
//                    str1=rs.getString(3);
//                    str2=rs.getString(4);
//                    str3=rs.getString(5);
//                    str4=rs.getString(6);
//                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                    System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//               v1=((wi1-m1)/d1);
//               v2=((wi2-m2)/d2);
//               v3=(float) Math.exp(-(v1*v1));
//               v4=(float) Math.exp(-(v2*v2));
//               v=v3*v4;
//               System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
//               String ff=df.format(v);
//               v=Float.parseFloat(ff);
//               System.out.println("v:"+v);
//              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
//
//               // cal. similarity
//               System.out.println("count:"+tco);
//
//                if(v>0.7)
//                {
//                    mt1=((csize*m1)+wi1)/(csize+1);
//                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
//                    B1=((csize+1)/csize)*(mt1*mt1);
//                    if(A1>=B1)
//                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
//                    else
//                        dt1=(float) Math.sqrt(B1-A1)+0.1f;
//
//                    mt2=((csize*m2)+wi2)/(csize+1);
//                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
//                    B2=((csize+1)/csize)*(mt2*mt2);
//
//                    if(A2>=B2)
//                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
//                    else
//                        dt2=(float) Math.sqrt(B2-A2)+0.1f;
//
//
//                    String mt=df.format(mt1);
//                    mt1=Float.parseFloat(mt);
//                     mt=df.format(mt2);
//                    mt2=Float.parseFloat(mt);
//                     mt=df.format(dt1);
//                    dt1=Float.parseFloat(mt);
//                     mt=df.format(dt2);
//                    dt2=Float.parseFloat(mt);
//
//                    csize=csize+1;
//                    m="<"+mt1+","+mt2+">";
//                    d="<"+dt1+","+dt2+">";
//
//                    System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
//                    System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
//                    //jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
//                    //jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);
//
//
//                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
//
//
//                }
//                else
//                {
//                    wi1=w1[i];
//                    wi2=w2[i];
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//                    count=count+1;
//                    csize=1;
//                    str1=wi1+","+wi2;
//                    str2="word2";
//
//                    m1=wi1;
//                    m2=wi2;
//                    d1=0.1f;
//                    d2=0.1f;
//
//                    m="<"+m1+","+m2+">";
//                    d="<"+d1+","+d2+">";
//                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
//                }
//               }
//                        }
//                else
//               {
//                            //compare similarity
//                            System.out.println("more clus:"+tco);
//                rs=stmt.executeQuery("SELECT * FROM `cluster`");
//                while(rs.next())
//                {
//                    count=rs.getInt(1);
//                    csize=rs.getInt(2);
//                    str1=rs.getString(3);
//                    str2=rs.getString(4);
//                    str3=rs.getString(5);
//                    str4=rs.getString(6);
//                    m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                    m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                    d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                    d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                    System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//               v1=((wi1-m1)/d1);
//               v2=((wi2-m2)/d2);
//               v3=(float) Math.exp(-(v1*v1));
//               v4=(float) Math.exp(-(v2*v2));
//               v=v3*v4;
//                System.out.println("v1:"+v1+"--v2:"+v2+"--v3:"+v3+"v4:"+v4+"v:"+v);
//               String ff=df.format(v);
//               v=Float.parseFloat(ff);
//               System.out.println("v:"+v);
//               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
//               stmt2.executeUpdate("INSERT INTO `fuzzy`.`sim1` (`no`, `val`) VALUES ('"+count+"', '"+v+"');");
//               //String sim1=count+","+v;
//               //sim[co]=sim1;
//               //co++;
//              // jTextArea1.append("val---"+wi1+","+wi2+" : "+v+"\n");
//                   }
//                rs=stmt.executeQuery("SELECT * FROM `sim` ORDER BY `val` ASC");
//                while(rs.next())
//                {
//                    cno=rs.getInt(1);
//                    vl=rs.getFloat(2);
//
//               }
//                System.out.println("cno:"+cno+"--vl:"+vl);
//                    if(v1>0.7)
//                    {
//                        System.out.println("Create New Cluster");
//
//                    System.out.println("w1:"+wi1+"---w2:"+wi2);
//                    count=count+1;
//                    csize=1;
//                    str1=wi1+","+wi2;
//                    str2="word3";
//
//                    m1=wi1;
//                    m2=wi2;
//                    d1=0.1f;
//                    d2=0.1f;
//
//                    m="<"+m1+","+m2+">";
//                    d="<"+d1+","+d2+">";
//                    stmt1.executeUpdate("INSERT INTO `fuzzy`.`cluster` (`no`, `csize`, `value`, `words`, `mean`, `dev`) VALUES ('"+count+"', '"+csize+"', '"+str1+"', '"+str2+"', '"+m+"', '"+d+"');");
//
//                    }
//                    else
//                    {
//                        System.out.println("Modify Cluster");
//                        rs=stmt.executeQuery("SELECT * FROM `cluster`WHERE `no`='"+cno+"'");
//                        while(rs.next())
//                        {
//                        count=rs.getInt(1);
//                        csize=rs.getInt(2);
//                        str1=rs.getString(3);
//                        str2=rs.getString(4);
//                        str3=rs.getString(5);
//                        str4=rs.getString(6);
//                        m1=Float.parseFloat(str3.substring(1, str3.indexOf(",")));
//                        m2=Float.parseFloat(str3.substring(str3.indexOf(",")+1,str3.indexOf(">")));
//                        d1=Float.parseFloat(str4.substring(1, str4.indexOf(",")));
//                        d2=Float.parseFloat(str4.substring(str4.indexOf(",")+1,str4.indexOf(">")));
//                        System.out.println("m1:"+m1+"--m2:"+m2+"--d1:"+d1+"--d2:"+d2);
//
//                        }
//                        mt1=((csize*m1)+wi1)/(csize+1);
//                    A1=(csize-1)*((d1-1.0f)*(d1-0.1f))+(csize*(mt1*mt1)+(wi1*wi1))/csize;
//                    a1=((csize*mt1)+wi1)/(csize+1);
//                    B1=((csize+1)/csize)*((a1*a1));
//                    if(A1>=B1)
//                        dt1=(float) Math.sqrt(A1-B1)+0.1f;
//                    else
//                        dt1=(float) Math.sqrt(B1-A1)+0.1f;
//
//                    mt2=((csize*m2)+wi2)/(csize+1);
//                    A2=(csize-1)*((d2-0.1f)*(d2-0.1f))+(csize*(mt2*mt2)+(wi2*wi2))/csize;
//                    a2=((csize*mt2)+wi2)/(csize+1);
//                    B2=((csize+1)/csize)*(a2*a2);
//
//                    if(A2>=B2)
//                        dt2=(float) Math.sqrt(A2-B2)+0.1f;
//                    else
//                        dt2=(float) Math.sqrt(B2-A2)+0.1f;
//
//                    csize=csize+1;
//                    String mt=df.format(mt1);
//                    mt1=Float.parseFloat(mt);
//                     mt=df.format(mt2);
//                    mt2=Float.parseFloat(mt);
//                     mt=df.format(dt1);
//                    dt1=Float.parseFloat(mt);
//                     mt=df.format(dt2);
//                    dt2=Float.parseFloat(mt);
//                    m="<"+mt1+","+mt2+">";
//                    d="<"+dt1+","+dt2+">";
//                    System.out.println("m1=:"+mt1+"--m2="+mt2);
//                    System.out.println("A1:"+A1+"--B1:"+B1+"--dt1:"+dt1);
//                    System.out.println("A2:"+A2+"--B2:"+B2+"--dt2:"+dt2);
//                    //jTextArea2.append("\nmt1:"+mt1+"--mt2:"+mt2);
//                    //jTextArea2.append("\ndt1:"+dt1+"--dt2:"+dt2);
//
//                    //csize=csize+1;
//                    stmt1.executeUpdate("UPDATE `fuzzy`.`cluster` SET `csize`='"+csize+"', `mean`='"+m+"', `dev`='"+d+"' WHERE `no`='"+count+"'" );
//
//                    }
//
//                }
//                        stmt2.executeUpdate("TRUNCATE TABLE `fuzzy`.`sim`");
//
//
//
//
//                    }
//                }
//            }
//
//        }
//        catch(Exception e)
//        {
//            System.out.println("Excep:"+e.getMessage());
//        }