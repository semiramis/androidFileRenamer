import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class NameDialog {
	
	private JFrame f;
	private JPanel p1;
	private JPanel p2;
	private JLabel text;
	private JTextField name;
	private JButton change;
	private String str;
	private int hoehe;
	
	public NameDialog(File[] doubles){
		
		hoehe = doubles.length*10+50;
		if(hoehe > 400){
			hoehe = 400;
		}
		
		f = new JFrame("Datei existiert bereits");
		f.setSize(400,hoehe);
		f.add(new JScrollBar());
		f.setLocationRelativeTo(null);
		
		p1 = new JPanel(new BorderLayout());
		f.add(p1);
		
		p2 = new JPanel(new GridLayout(doubles.length, 2));
		p1.add(p2, BorderLayout.CENTER);
		
		for(File f : doubles){
			p2.add(new JLabel(f.getName() + ":"));
			p2.add(new JTextField());
		}
		
		text = new JLabel("<html><center>Folgende Dateien existieren bereits. " +
				"Bitte geben Sie einen neuen Namen ein</center></html>");
		p1.add(text, BorderLayout.NORTH);
		
		
		
		change = new JButton("Ändern");
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		};
		change.addActionListener(al);
		p1.add(change, BorderLayout.SOUTH);
		
		f.setVisible(true);
		
	}

	
	public String getStr(){
		return str;
	}
}
