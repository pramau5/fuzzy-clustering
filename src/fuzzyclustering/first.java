

package fuzzyclustering;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class first extends javax.swing.JFrame {
public static File fn;
public static String fname="",str="",path="",str1="";
int co=0;
public static int line=0,word=0,line1=0;
public static long stime;
public static float t;
    private char[] b;
   private int i,     /* offset into b */
               i_end, /* offset to end of stemmed word */
               j, k;
   private static final int INC = 50;
    public first()
    {
        initComponents();
         b = new char[INC];
      i = 0;
      i_end = 0;

    }
@SuppressWarnings("ManualArrayToCollectionCopy")
    public void add(char ch)
   {  if (i == b.length)
      {  char[] new_b = new char[i+INC];
         for (int c = 0; c < i; c++) new_b[c] = b[c];
         b = new_b;
      }
      b[i++] = ch;
   }
   public void add(char[] w, int wLen)
   {  if (i+wLen >= b.length)
      {  char[] new_b = new char[i+wLen+INC];
         for (int c = 0; c < i; c++) new_b[c] = b[c];
         b = new_b;
      }
      for (int c = 0; c < wLen; c++) b[i++] = w[c];
   }


   public String toString() { 
       System.out.println("sss toString()");
       return new String(b,0,i_end); }


   public int getResultLength() { return i_end; }


   public char[] getResultBuffer() { return b; }

   /* cons(i) is true <=> b[i] is a consonant. */

   private final boolean cons(int i)
   {  switch (b[i])
      {  case 'a': case 'e': case 'i': case 'o': case 'u': return false;
         case 'y': return (i==0) ? true : !cons(i-1);
         default: return true;
      }
   }



   private final int m()
   {  int n = 0;
      int i = 0;
      while(true)
      {  if (i > j) return n;
         if (! cons(i)) break; i++;
      }
      i++;
      while(true)
      {  while(true)
         {  if (i > j) return n;
               if (cons(i)) break;
               i++;
         }
         i++;
         n++;
         while(true)
         {  if (i > j) return n;
            if (! cons(i)) break;
            i++;
         }
         i++;
       }
   }



   private final boolean vowelinstem()
   {  int i; for (i = 0; i <= j; i++) if (! cons(i)) return true;
      return false;
   }



   private final boolean doublec(int j)
   {  if (j < 1) return false;
      if (b[j] != b[j-1]) return false;
      return cons(j);
   }



   private final boolean cvc(int i)
   {  if (i < 2 || !cons(i) || cons(i-1) || !cons(i-2)) return false;
      {  int ch = b[i];
         if (ch == 'w' || ch == 'x' || ch == 'y') return false;
      }
      return true;
   }

   private final boolean ends(String s)
   {  int l = s.length();
      int o = k-l+1;
      if (o < 0) return false;
      for (int i = 0; i < l; i++) if (b[o+i] != s.charAt(i)) return false;
      j = k-l;
      return true;
   }



   private final void setto(String s)
   {  int l = s.length();
      int o = j+1;
      for (int i = 0; i < l; i++) b[o+i] = s.charAt(i);
      k = j+l;
   }

   /* r(s) is used further down. */

   private final void r(String s) { if (m() > 0) setto(s); }



   private final void step1()
   {  if (b[k] == ' ')
      {  if (ends("sses")) k -= 2; else
         if (ends("ies")) setto("i"); else
         if (b[k-1] != 's') k--;
      }
      if (ends("eed")) { if (m() > 0) k--; } else
      if ((ends("ed") || ends("ing")) && vowelinstem())
      {  k = j;
         if (ends("at")) setto("ate"); else
         if (ends("bl")) setto("ble"); else
         if (ends("iz")) setto("ize"); else
         if (doublec(k))
         {  k--;
            {  int ch = b[k];
               if (ch == 'l' || ch == 's' || ch == 'z') k++;
            }
         }
         else if (m() == 1 && cvc(k)) setto("e");
     }
   }



   private final void step2() { if (ends("y") && vowelinstem()) b[k] = 'i'; }


   private final void step3() { if (k == 0) return; /* For Bug 1 */ switch (b[k-1])
   {
       case 'a': if (ends("ational")) { r("ate"); break; }
                 if (ends("tional")) { r("tion"); break; }
                 break;
       case 'c': if (ends("enci")) { r("ence"); break; }
                 if (ends("anci")) { r("ance"); break; }
                 break;
       case 'e': if (ends("izer")) { r("ize"); break; }
                 break;
       case 'l': if (ends("bli")) { r("ble"); break; }
                 if (ends("alli")) { r("al"); break; }
                 if (ends("entli")) { r("ent"); break; }
                 if (ends("eli")) { r("e"); break; }
                 if (ends("ousli")) { r("ous"); break; }
                 break;
       case 'o': if (ends("ization")) { r("ize"); break; }
                 if (ends("ation")) { r("ate"); break; }
                 if (ends("ator")) { r("ate"); break; }
                 break;
       case 's': if (ends("alism")) { r("al"); break; }
                 if (ends("iveness")) { r("ive"); break; }
                 if (ends("fulness")) { r("ful"); break; }
                 if (ends("ousness")) { r("ous"); break; }
                 break;
       case 't': if (ends("aliti")) { r("al"); break; }
                 if (ends("iviti")) { r("ive"); break; }
                 if (ends("biliti")) { r("ble"); break; }
                 break;
       case 'g': if (ends("logi")) { r("log"); break; }
   } }



   private final void step4() 
   {
   switch (b[k])
   {
       case 'e': if (ends("icate")) { r("ic"); break; }
                 if (ends("ative")) { r(""); break; }
                 if (ends("alize")) { r("al"); break; }
                 break;
       case 'i': if (ends("iciti")) { r("ic"); break; }
                 break;
       case 'l': if (ends("ical")) { r("ic"); break; }
                 if (ends("ful")) { r(""); break; }
                 break;
       case 's': if (ends("ness")) { r(""); break; }
                 break;
   }
   }



   private final void step5()
   {   if (k == 0) return; /* for Bug 1 */ switch (b[k-1])
       {  case 'a': if (ends("al")) break; return;
          case 'c': if (ends("ance")) break;
                    if (ends("ence")) break; return;
          case 'e': if (ends("er")) break; return;
          case 'i': if (ends("ic")) break; return;
          case 'l': if (ends("able")) break;
                    if (ends("ible")) break; return;
          case 'n': if (ends("ant")) break;
                    if (ends("ement")) break;
                    if (ends("ment")) break;
                    /* element etc. not stripped before the m */
                    if (ends("ent")) break; return;
          case 'o': if (ends("ion") && j >= 0 && (b[j] == 's' || b[j] == 't')) break;
                                    /* j >= 0 fixes Bug 2 */
                    if (ends("ou")) break; return;
                    /* takes care of -ous */
          case 's': if (ends("ism")) break; return;
          case 't': if (ends("ate")) break;
                    if (ends("iti")) break; return;
          case 'u': if (ends("ous")) break; return;
          case 'v': if (ends("ive")) break; return;
          case 'z': if (ends("ize")) break; return;
          default: return;
       }
       if (m() > 1) k = j;
   }



   private final void step6()
   {  j = k;
      if (b[k] == ' ')
      {  int a = m();
         if (a > 1 || a == 1 && !cvc(k-1)) k--;
      }
      if (b[k] == 'l' && doublec(k) && m() > 1) k--;
   }
 public void stem()//To perform stemming algorithm
   {  k = i - 1;
      if (k > 1) { step1(); step2(); step3(); step4(); step5(); step6(); }
      i_end = k+1; i = 0;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 750));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Periodic Outlier Pattern Mining Algorithm");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 730, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Select DataSet");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 190, 120, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 310, 280, 350);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(470, 310, 260, 350);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(560, 180, 70, 40);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(370, 190, 180, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 51));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 250, 250, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 51));
        jLabel5.setText("File Contents");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(220, 250, 110, 30);

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Dataset & Pre-processing");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 120, 350, 40);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Tag Elimination");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 370, 130, 40);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Split");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 410, 130, 40);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Stopword");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 450, 130, 40);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Stemming");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(10, 490, 130, 40);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Frequency");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(10, 530, 130, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gback1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String files1;

            JFileChooser fc = new JFileChooser();
            int rVal = fc.showOpenDialog(first.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fn=fc.getSelectedFile();


            }

            String fn1=fn.toString();
            System.out.println("filepath is "+fn1);
            path=fn1.substring(0,fn1.lastIndexOf("F"));



            jTextField1.setText(path);
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile()) {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea1.append("\n"+files1.toUpperCase()+"\n\n");
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
            e.printStackTrace();
            System.out.println("Excep:"+e.getMessage());
            
        }
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jLabel4.setText("Tag Elimination");
        System.out.println("Tag elimination  path:"+path);
        if(path.equalsIgnoreCase(""))
        {
JOptionPane.showMessageDialog(this,"Must Select File Path");
        }
 else
        {
        try
        {
            String files1;
            FileWriter fw,fw1;
        File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();
                    fw=new FileWriter("/Volumes/D/fuzzy/input/input"+lf1+".txt");
                    fw1=new FileWriter("/Volumes/D/fuzzy/eliminate/eli"+lf1+".txt");
                    jTextArea1.append("\n"+files1.toUpperCase()+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str=br.readLine())!=null)
                    {
                        if(!str.equalsIgnoreCase("\n"))
                        {
                            jTextArea1.append(str+"\n");
                            if(co>=13)
                            fw.write(str+"\n");
                            co++;

                        }
                    }
                    fw.close();
                    co=0;
                    //remove html tags
                     Html2Text ht=new Html2Text();
            str1=ht.main("/Volumes/D/fuzzy/input/input"+lf1+".txt");
           // FileWriter fw=new FileWriter("/Volumes/D/fuzzy\\stop.txt");
            //fw.write(str1);
            //fw.close();
            StringTokenizer st=new StringTokenizer(str1," ");
            jTextArea2.append("\n\nFILE"+(lf1+1)+"\n\n");
            while(st.hasMoreTokens())
            {
             str=st.nextToken();
             jTextArea2.append(str+" ");
             fw1.write(str+"\n");
             co++;
             if(co>7)
             {
                 jTextArea2.append("\n");
                 co=0;
             }
            }
            fw1.close();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jLabel4.setText("Split Sentences");
        System.out.println("path:"+path);
        if(path.equalsIgnoreCase(""))
        {
JOptionPane.showMessageDialog(this,"Must Select File Path");
        }
 else
        {
        try
        {
            jTextArea2.setText("");
            String files1;
            FileWriter fw;
            path="/Volumes/D/fuzzy/eliminate/";
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {
                fw=new FileWriter("/Volumes/D/fuzzy/stop/stop"+lf1+".txt");
                if (listOfFiles1[lf1].isFile()) {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea2.append("\n"+files1.toUpperCase()+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while((str1=br.readLine())!=null)
                    {
                        StringTokenizer st=new StringTokenizer(str1," ,\"-.{}1234567890\n");
                        while(st.hasMoreTokens())
                        {
                            str=st.nextToken();
                            if(str.length()>=2)
                            {
                                jTextArea2.append(str+"\n");
                                fw.write(str+"\n");
                            }
                        }
                    
                    }
                    fw.close();
                }
            }
        }
        catch(Exception e)
        {
System.out.println("Excep:"+e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabel4.setText("Stopword Removal");
        System.out.println("path:"+path);
        if(path.equalsIgnoreCase(""))
        {
JOptionPane.showMessageDialog(this,"Must Select File Path");
        }
 else
        {
        try
        {
            //int count = 0, co=0;
            jTextArea2.setText("");
        String li = null , fstr = null;
        String nli = null;
        String f[]={"the","in","since","and","for","have","not","been","said","its","will","be","this","of","that","it","there","still",
        "is","some","as","how","much","were","at","against","on","was","to","has","an","with","are","now"
                ,"there","which","after","by","went","only","their","almost","par","but","had","he","she","just","asked","up","or",
                "would","see","through","than","told","her","our","shall","more","than","when","under","become","then","able","take","do",
        "soon","yet","we","where","other","well"};

                StringTokenizer st1;
        int pos,co1=0;
        int len;


            String files1;
            path="/Volumes/D/fuzzy/stop/";
            FileWriter fw;
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {
            fw=new FileWriter("/Volumes/D/fuzzy/stem/stem"+lf1+".txt");
                if (listOfFiles1[lf1].isFile())
                {

                    files1 = listOfFiles1[lf1].getName();
                    System.out.println("fname:"+files1.toUpperCase());
                    jTextArea2.append("\n"+files1.toUpperCase()+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                    while (( li = br.readLine()) != null)
            {

                //stm=li.substring(0, li.indexOf(":"));
                //jTextArea2.append(stm+" ");
                //bwr.write(stm+" ");

               // stmt=li.substring(li.indexOf(":")+1);

                st1=new StringTokenizer(li,", \"[].-!()?1234567890:+\n/");
                while(st1.hasMoreTokens())
                {
                    nli=st1.nextToken();
                   // System.out.println("nli:"+nli);
                    for(int i=0;i<f.length;i++)
                    {
                    if(f[i].equalsIgnoreCase(nli))
                    {
                    co++;

                    }
                    else
                    {
                    for(int l=0;l<f.length;l++)
                    {
                    if(!f[l].equalsIgnoreCase(nli))
                    count++;
                    }
                    if(count==f.length)
                    {

                    //bwr.write(nli+" ");

                    fstr = fstr + " " +nli;
                    jTextArea2.append(nli+"\n");
                    fw.write(nli+"\n");
                    //System.out.println("nli1:"+nli);
                    }
                    }

                    }
                    count=0;


               // jTextArea2.append("\n");
                //bwr.write("\n");
            }
            co1++;
            }
            //bwr.close();
           // fileout.close();



           fw.close();
           //javax.swing.JOptionPane.showMessageDialog(null,"StopWords are Removed");

                }
            }
        }
        catch(Exception e)
        {
System.out.println("Excep:"+e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jLabel4.setText("Word Stemming");
        System.out.println("path:"+path);
        if(path.equalsIgnoreCase(""))
        {
JOptionPane.showMessageDialog(this,"Must Select File Path");
        }
 else
        {
        try
        {
           jTextArea2.setText("");
            String files1;
            StringTokenizer st,st1;
FileInputStream in,in1 ;
             FileWriter fw;
             FileOutputStream fileout;
             char[] w = new char[501];
      first s = new first();
            path="/Volumes/D/fuzzy/stem/";
            File folder1 = new File(path);
            File[] listOfFiles1 = folder1.listFiles();
            int rco=0,big=0,count=0;
            for (int lf1 = 0; lf1 <listOfFiles1.length; lf1++)
            {

                if (listOfFiles1[lf1].isFile()) {

                    files1 = listOfFiles1[lf1].getName();

                    jTextArea2.append("\n"+files1.toUpperCase()+"\n\n");
                    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path+files1)));
                     in = new FileInputStream(path+files1);
      fw=new FileWriter("/Volumes/D/fuzzy/stem1/stem"+lf1+".txt");
      try
         { while(true)

           {  int ch = in.read();
              if (Character.isLetter((char) ch))
              {
                 int j = 0;
                 while(true)
                 {  ch = Character.toLowerCase((char) ch);
                    w[j] = (char) ch;
                    if (j < 500) j++;
                    ch = in.read();
                    if (!Character.isLetter((char) ch))
                    {

                       for (int c = 0; c < j; c++) s.add(w[c]);

                       s.stem();
                       {  String u;

                          /* and now, to test toString() : */
                          u = s.toString();

                       }
                       break;
                    }
                 }
              }
              if (ch < 0) break;
           }
         }
         catch (Exception e)
         {


         }
      in1 = new FileInputStream(path+files1);

         try
         { while(true)

           {  int ch = in1.read();
              if (Character.isLetter((char) ch))
              {
                 int j = 0;
                 while(true)
                 {  ch = Character.toLowerCase((char) ch);
                    w[j] = (char) ch;
                    if (j < 500) j++;
                    ch = in1.read();
                    if (!Character.isLetter((char) ch))
                    {
                       /* to test add(char ch) */
                       for (int c = 0; c < j; c++) s.add(w[c]);

                       s.stem();
                       {  String u;


                          u = s.toString();


                          jTextArea2.append(u);
                          fw.write(u);
                       }
                       break;
                    }
                 }
              }
              if (ch < 0) break;

              jTextArea2.append((""+(char)ch));
              fw.write((""+(char)ch));
           }
           fw.close();
         }
         catch (IOException e)
         {


         }
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Excep:"+e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        System.out.println("path:"+path);
        if(path.equalsIgnoreCase(""))
        {
JOptionPane.showMessageDialog(this,"Must Select File Path");
        }
 else
        {
        second sc=new second();
        sc.setVisible(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new first().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
