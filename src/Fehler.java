import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fehler {

	private JFrame f;
	private JPanel p;
	private JLabel text;
	private JButton ok;
	
	public Fehler(String pfad){
		f = new JFrame("Fehler!");
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		
		
		p = new JPanel();
		p.setLayout(new BorderLayout(5, 5));
		f.add(p);
		
		text = new JLabel("<html><center><b>Achtung!</b><br>" +
				"in Ihrem ausgewählten Ordner<br><br>" +
				"<tt>"+pfad+"</tt><br><br>befinden sich nicht die richtigen Unterordner!</center></html>");
		p.add(text, BorderLayout.CENTER);
		
		ok = new JButton("OK");
		p.add(ok, BorderLayout.SOUTH);
		
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				
			}
		
		};
		
		ok.addActionListener(al);
		
		
		f.setVisible(true);
	}
	
	
}
