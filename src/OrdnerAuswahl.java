import javax.swing.JFileChooser;


public class OrdnerAuswahl {

	private JFileChooser fc;
	
	private String dir = "";
	
	public OrdnerAuswahl() {
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setLocation(null);
		int r = fc.showOpenDialog(null);
		if(r == JFileChooser.APPROVE_OPTION){
			setDir(fc.getSelectedFile().getAbsolutePath());
			//TODO Abbrechen implementieren
		}
		if(r == JFileChooser.CANCEL_OPTION){
			fc.setVisible(false);
		}
	}
	
	public void setDir(String d){
		dir = d;
	}
	
	public String getDir(){
		return dir;
	}
	
}
