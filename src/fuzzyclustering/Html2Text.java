

package fuzzyclustering;

import java.io.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class Html2Text extends HTMLEditorKit.ParserCallback {
 StringBuffer s;

 public Html2Text() {}

 public void parse(Reader in) throws IOException {
   s = new StringBuffer();
   ParserDelegator delegator = new ParserDelegator();
   // the third parameter is TRUE to ignore charset directive
   delegator.parse(in, this, Boolean.TRUE);
 }

 public void handleText(char[] text, int pos) {
   s.append(text);
 }

 public String getText() {
   return s.toString();
 }

 public String main (String fname)
 {
     Html2Text parser = null;
   try {
     // the HTML to convert
     FileReader in = new FileReader(fname);
     parser = new Html2Text();
     parser.parse(in);
     in.close();
     System.out.println(parser.getText());

   }
   catch (Exception e) {
     e.printStackTrace();
   }
       return parser.getText();
 }
}

