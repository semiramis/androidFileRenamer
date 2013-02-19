import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author Maria Lindemann
 * 
 * "Rename" wird von der Klasse "RenamerGui" aufgerufen.
 * Es wird eine Liste mit File-Objekten der Dateien im Verzeichnis angelegt,
 * diese werden dann nacheinander durchgegangen und alle Sonderzeichen, Zahlen und
 * Grossbuchstaben werden entfern.
 * 
 *
 */

public class Rename {

	private File[] entries;
	private File[] doubles = {};
	
	private Pattern regex;
	private Matcher m;
	private String sep;
	
	private int i = 0;
	
	public Rename(){
		
	}
	
	public File[] getEntries(String pfad){
		entries = new File(pfad).listFiles();
		System.out.println("Übernehme Dateien aus "+pfad);
		return entries;
	}
	
	/**
	 * @param entries Liste der File-Objekte (ermittelt aus den Dateien im Verzeichnis)
	 * @param pfad der Pfad zu dem Verzeichnis, wird hier nochmal gebraucht um die Dateien am richtigen Ort zu Speichern
	 * 
	 * Befreit die armen Dateinamen von den bösen Sonderzeichen, Zahlen und Grossbuchstaben, die sich immer wieder einschleichen
	 * @throws InterruptedException 
	 */
	
	public void clearStrings(File[] in, String pfad){
		
		
		for(File f: in){
			sep = getSep();
			String oldName = f.getName();
			String path = pfad;
			System.out.print("Alter Name: "+ oldName);
			regex = Pattern.compile("[^a-z.]");
			m = regex.matcher(oldName);
			StringBuffer sb = new StringBuffer();
			while(m.find()){
				m.appendReplacement(sb, "");
			}
			m.appendTail(sb);
			String newName = sb.toString();
			if(new File(path +sep+ newName).exists()){
				
				doubles[i] = f;
				i++;
			}else{
				f.renameTo(new File(path +sep+ newName));
				System.out.println(" - Neuer Name: "+newName);
			}
		}
		NameDialog nd = new NameDialog(doubles);
		
		
	}
	

	
	public String getSep(){
		return sep = System.getProperty("file.separator");
	}
}
