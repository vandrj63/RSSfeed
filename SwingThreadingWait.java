import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SwingThreadingWait extends JFrame implements ActionListener{ 
ExecutorService ex;
JTextArea first, second, third, fourth, fifth;
private long start = 0;
int m1=0;
int m2=1;
int m3=2;
int m4=3;
int m5=4;
String feedname[]={"http://weather.yahooapis.com/forecastrss?w=2502265","http://rss.news.yahoo.com/rss/entertainment","http://www.npr.org/rss/rss.php?id=1014","http://rss.cnn.com/rss/cnn_topstories.rss", "http://www.economist.com/blogs/gametheory/index.xml"};
RSSReader a1, b1, c1, d1, e1;
RSSReader a2, b2, c2, d2, e2;
RSSReader a3, b3, c3, d3, e3;
RSSReader a4, b4, c4, d4, e4;
RSSReader a5, b5, c5, d5, e5;
public SwingThreadingWait() {
super("Homework 3");
first = new JTextArea(20, 25);
second = new JTextArea(20, 25);
third = new JTextArea(20, 25);
fourth = new JTextArea(20, 25);
fifth = new JTextArea(20, 25);
//start of stuff changed ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
String feedtype[]={"Yahoo weather","Yahoo news","NPR","CNN","Economist"};
try {
a1 = new RSSReader(feedname[m1], first);
b1 = new RSSReader(feedname[m1], second);
c1 = new RSSReader(feedname[m1], third);
d1 = new RSSReader(feedname[m1], fourth);
e1 = new RSSReader(feedname[m1], fifth);

a2 = new RSSReader(feedname[m2], first);
b2 = new RSSReader(feedname[m2], second);
c2 = new RSSReader(feedname[m2], third);
d2 = new RSSReader(feedname[m2], fourth);
e2 = new RSSReader(feedname[m2], fifth);

a3 = new RSSReader(feedname[m3], first);
b3 = new RSSReader(feedname[m3], second);
c3 = new RSSReader(feedname[m3], third);
d3 = new RSSReader(feedname[m3], fourth);
e3 = new RSSReader(feedname[m3], fifth);

a4 = new RSSReader(feedname[m4], first);
b4 = new RSSReader(feedname[m4], second);
c4 = new RSSReader(feedname[m4], third);
d4 = new RSSReader(feedname[m4], fourth);
e4 = new RSSReader(feedname[m4], fifth);

a5 = new RSSReader(feedname[m5], first);
b5 = new RSSReader(feedname[m5], second);
c5 = new RSSReader(feedname[m5], third);
d5 = new RSSReader(feedname[m5], fourth);
e5 = new RSSReader(feedname[m5], fifth);

}
catch (Exception exc) {
System.out.println(exc.toString());
first.setText(exc.toString());
}
JPanel West =new JPanel();
JPanel East =new JPanel();
West.setLayout(new GridLayout(5,1));
East.setLayout(new GridLayout(5,1));
JButton clients[]=new JButton[5];
JButton feeds[]=new JButton[5];
for(int k=0;k<5;k++) {
clients[k]=new JButton("Viewer "+(k+1));
feeds[k]=new JButton("Feed "+(k+1)+": "+feedtype[k]+"");
East.add(clients[k]);
West.add(feeds[k]);
feeds[k].addActionListener(this);
clients[k].addActionListener(this);
feeds[k].setActionCommand("f"+(k+1)); 
clients[k].setActionCommand("c"+(k+1));
}
add(East, BorderLayout.EAST);
add(West, BorderLayout.WEST);
pack();
// end of stuff changed ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
JPanel Center =new JPanel();
Center.setLayout(
new GridLayout(1, 2));
Center.add(first);
first.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
Center.add(second);
second.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.RED));
Center.add(third);
third.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
Center.add(fourth);
fourth.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.RED));
Center.add(fifth);
fifth.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
add(Center, BorderLayout.CENTER);
pack();
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public static void main(String args[]) {
SwingThreadingWait edt = new SwingThreadingWait();
edt.setVisible(true);
}
int client=0;
int feed=0;
@Override
public void actionPerformed(ActionEvent z) {
// TODO Auto-generated method stub

// get last client clicked
if ("c1".equals(z.getActionCommand())){
System.out.println("c1");
client=1;
}	
if ("c2".equals(z.getActionCommand())){
System.out.println("c2");
client=2;
}
if ("c3".equals(z.getActionCommand())){
System.out.println("c3");
client=3;
}
if ("c4".equals(z.getActionCommand())){
System.out.println("c4");
client=4;
}
if ("c5".equals(z.getActionCommand())){
System.out.println("c5");
client=5;
}

// get last feed clicked
if ("f1".equals(z.getActionCommand())){
System.out.println("f1");
feed=1;
}	
if ("f2".equals(z.getActionCommand())){
System.out.println("f2");
feed=2;
}
if ("f3".equals(z.getActionCommand())){
System.out.println("f3");
feed=3;
}
if ("f4".equals(z.getActionCommand())){
System.out.println("f4");
feed=4;
}
if ("f5".equals(z.getActionCommand())){
System.out.println("f5");
feed=5;
}

// if client and feed clicked
if(client!=0 && feed!=0){
System.out.println("print feed " + feed + " for client " + client);
// set client and feed values, print to screen
ex = Executors.newFixedThreadPool(1);

if(client==1){
if(feed==1)
ex.execute(a1);
if(feed==2)
ex.execute(a2);
if(feed==3)
ex.execute(a3);
if(feed==4)
ex.execute(a4);
if(feed==5)
ex.execute(a5);
}
if(client==2){
if(feed==1)
ex.execute(b1);
if(feed==2)
ex.execute(b2);
if(feed==3)
ex.execute(b3);
if(feed==4)
ex.execute(b4);
if(feed==5)
ex.execute(b5);
}
if(client==3){
if(feed==1)
ex.execute(c1);
if(feed==2)
ex.execute(c2);
if(feed==3)
ex.execute(c3);
if(feed==4)
ex.execute(c4);
if(feed==5)
ex.execute(c5);
}
if(client==4){
if(feed==1)
ex.execute(d1);
if(feed==2)
ex.execute(d2);
if(feed==3)
ex.execute(d3);
if(feed==4)
ex.execute(d4);
if(feed==5)
ex.execute(d5);
}
if(client==5){
if(feed==1)
ex.execute(e1);
if(feed==2)
ex.execute(e2);
if(feed==3)
ex.execute(e3);
if(feed==4)
ex.execute(e4);
if(feed==5)
ex.execute(e5);
}

client=0;feed=0;
}
}
}