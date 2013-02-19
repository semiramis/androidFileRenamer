import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class RenamerGUI extends JFrame implements ActionListener {

	private JFrame f;
	private JPanel p1;
	private JPanel p2;
	
	private JTextField pfad;
	private JButton suche;
	private JButton ausfuehren;
	private Rename rn;
	private OrdnerAuswahl oa;
	private File[] list;
	
	public RenamerGUI() {
		f = new JFrame();
		f.setTitle("Android File Renamer");
		f.setSize(400, 90);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		
		p1 = new JPanel();
		p1.setLayout(new BorderLayout(5,5));
		f.add(p1);
		
		
		pfad = new JTextField(); //manuelle Eingabe des Pfads zur ProjectRoot
		p1.add(pfad, BorderLayout.CENTER);
		
		suche = new JButton("Suche"); //auswaehlen des ProjectRoot-Pfads
		suche.addActionListener(this);
		p1.add(suche, BorderLayout.EAST);
		
		ausfuehren = new JButton("Ausführen"); //aus allen Dateinamen Sonderzeichen, Großbuchstaben und Zahlen entfernen
		ausfuehren.addActionListener(this);
		//ausfuehren.setEnabled(false);
		p1.add(ausfuehren, BorderLayout.SOUTH);
		
		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Suche"){
			oa = new OrdnerAuswahl();
			pfad.setText(oa.getDir());
		}
		if(e.getActionCommand()=="Ausführen"){
			Rename rn = new Rename();

			//String pfad1 = "/home/maria/testroot";
			String pfad0 = pfad.getText();
			String sep = rn.getSep();// "/" für UNIX, "\\" für den restlichen dreck
			String pfad1 = pfad0+sep+"res"+sep+"drawable-hdpi";
			String pfad2 = pfad0+sep+"res"+sep+"drawable-mdpi";
			String pfad3 = pfad0+sep+"res"+sep+"drawable-ldpi";
			File test1 = new File(pfad1);
			File test2 = new File(pfad2);
			File test3 = new File(pfad3);
			if(test1.isDirectory() && test2.isDirectory() && test3.isDirectory()){
				File[] list = rn.getEntries(pfad1);
				rn.clearStrings(list,pfad1);
				

				list = rn.getEntries(pfad2);
				rn.clearStrings(list, pfad2);
				
				
				list = rn.getEntries(pfad3);
				rn.clearStrings(list,pfad3);
				
			}else{
				Fehler f = new Fehler(pfad0);
			}
			
		}
	}
	
}
