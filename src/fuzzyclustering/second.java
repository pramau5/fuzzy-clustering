

package fuzzyclustering;

import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class second extends javax.swing.JFrame {

public static String wset[]=new String[100];
public static String fname="",str="",path="",str1="",name;
int co=0,c=0;
private static Map<String, Word> wordsMap = new HashMap<String, Word>();
HashMap hm=new HashMap();
    public second() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 750));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Periodic Outlier Pattern Mining Algorithm");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 730, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 280, 270, 380);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(460, 280, 270, 390);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 51));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 200, 200, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 51));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 200, 200, 30);

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Feature Reduction");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 140, 240, 32);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("WordSet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 360, 120, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Redundant");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 400, 120, 40);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("New Word Set");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 440, 120, 40);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Feature Clustering");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 475, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gback1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jLabel5.setText("WordSet");

         try {
            String files1;
            path="/Volumes/D/fuzzy/stem1/";
            
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile()) {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea1.append("\nFILE"+(lf1+1)+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str=br.readLine())!=null) {
                        if(!str.equalsIgnoreCase("\n")) {
                            jTextArea1.append(str+"\n");

                        }
                    }
                }
            }



        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jLabel5.setText("Reduntant Value");
         try {
            String files1;
            path="/Volumes/D/fuzzy/stem1/";
            jTextArea1.setText("");
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea1.append("\nFILE"+(lf1+1)+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str=br.readLine())!=null)
                    {
                        
                    StringTokenizer st = new StringTokenizer(str);
                while(st.hasMoreTokens())
                {
                    addWord(st.nextToken());
                }
            }
            br.close();
            Set tset=wordsMap.entrySet();
            Iterator i=tset.iterator();
            while(i.hasNext())
            {
                Map.Entry me = (Map.Entry)i.next();
                //jTextArea1.append(me.getValue()+"\n");
            }

            //write frequency into text file

            FileOutputStream fileout = new FileOutputStream("/Volumes/D/fuzzy/freq/frq"+lf1+".txt");
            FileWriter fwr=new FileWriter("/Volumes/D/fuzzy/freq/frq"+lf1+".txt",true);
            BufferedWriter buwr=new BufferedWriter(fwr);
            //System.out.println("wordsmap:"+wordsMap);
            tset=new TreeSet<Word>(wordsMap.values());
            i=tset.iterator();
            while (i.hasNext())
            {
                name=i.next().toString();
                fname=name.substring(0, name.indexOf(":"));
                buwr.write(name.trim());
                buwr.newLine();
                jTextArea1.append(name.trim()+"\n");

                //System.out.println("name:"+name.substring(0, name.indexOf(":")));
            }
            wordsMap.clear();
            buwr.close();
            fwr.close();
            fileout.close();

                }
            }



        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jLabel6.setText("Final WordSet");
        try {
            String files1;
            path="/Volumes/D/fuzzy/freq/";
            jTextArea2.setText("");
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea2.append("\nFILE"+(lf1+1)+"\n\n");
                   // hm.put(files1, 11);
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str=br.readLine())!=null)
                    {
                        fname=str.substring(0, str.indexOf(":"));
                        if(fname.length()>=4)
                        {
                        if(co<=25)
                        {
                            
                            if(!(fname.contains("<")||(fname.contains(">"))))
                            {
                            jTextArea2.append(fname + "\n");
                            if(co<=5)
                                hm.put(fname, 1);
                            co++;
                            }
                        }
                        
                        
                        }
                    }
                    co=0;
                }
            }

            Set set = hm.entrySet();
// Get an iterator
Iterator i = set.iterator();
// Display elements
while(i.hasNext()) {
Map.Entry me = (Map.Entry)i.next();
wset[c]=me.getKey().toString();
c++;
System.out.print(me.getKey() + ": ");
System.out.println(me.getValue());
}
        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        third th=new third();
        th.setVisible(true);
}//GEN-LAST:event_jButton4ActionPerformed
private static void addWord(String str)
   {
       Word word=wordsMap.get(str);
       if(word==null)
       {
           wordsMap.put(str, word=new Word(str));
       }
       word.increment();
   }

   static class Word implements Comparable<Word>
   {
       private String word;
       private int count = 0;
       public Word(String word)
       {
           this.word = word;
       }
       public void increment()
       {
           this.count++;
       }
       @Override
       public int compareTo(Word o)
       {
           return count-o.count>0?-1:(count==o.count?word.compareTo(o.word):1);
       }
       public String toString()
       {
           return word+":"+count;
       }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new second().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

}
