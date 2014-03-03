import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.*;
public class RSSReader implements Runnable {
int counter;
private URL rssURL;
private JTextArea text;
public RSSReader(String rssURL, JTextArea text) throws Exception {
this.rssURL = new URL(rssURL);
this.text = text;
text.setText("");
counter = 0;
}

public void setURL(String url) throws Exception {
rssURL = new URL(url);
}

public void run() {
while (true) {
counter++;


try {
String tmp = "\n";
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

Document doc = builder.parse(rssURL.openStream());
NodeList items = doc.getElementsByTagName("item");
for (int i = 0; i < items.getLength(); i++) {
Element item = (Element) items.item(i);

tmp += getValue(item,"title");
tmp += getValue(item,"description");
tmp += getValue(item,"link");
tmp +="\n";
}

text.setText(tmp);

try {
	Thread.sleep(1000000);
	}

	catch (InterruptedException e) {
	}
}

catch (Exception e) {e.printStackTrace();
}
}
}

public String getValue(Element parent, String nodeName) {
return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
}
}