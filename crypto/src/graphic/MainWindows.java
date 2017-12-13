package graphic;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;

public class MainWindows extends JFrame {
 public MainWindows(){
	 super("titre de l'application");
	 
	 WindowListener l = new WindowAdapter() {
		 public void windowClosing(WindowEvent e){
			 System.exit(0);
		 }
	 };
	 
	 // à utiliser pour la fenetre qui apparait lors du parcours de fichier
	 // JFileChooser chooser = new JFileChooser();
	 JButton button = new JButton("Parcourir");
	 String[] elements = { "Element 1", "Element 2", "Element 3", "Element  4"};
	 JComboBox jCombo = new JComboBox(elements);
	 JTextField  textField1 = new JTextField ();
	 JButton buttonEx = new JButton("Executer");
	 JPanel panneau = new JPanel();
	
	 textField1.setPreferredSize(new Dimension(500,30));
	
	 panneau.add(textField1);
	 panneau.add(button);
	 panneau.add(jCombo);
	 panneau.add(buttonEx);
	 setContentPane(panneau);
	 panneau.setLayout(null);
	 textField1.setBounds(250,70, 500, 30);
	 button.setBounds(780, 70, 100, 30);
	 jCombo.setBounds(250,150,200,30);
	 buttonEx.setBounds(780, 150, 100, 30);
	 setSize(1000,500);
	 setVisible(true);
	 
	 button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			jfc.setAcceptAllFileFilterUsed(true);
			if(jfc.showOpenDialog(panneau)==JFileChooser.APPROVE_OPTION) {
				textField1.setText(jfc.getSelectedFile().getAbsolutePath());
			}
			
		}
		 
	 });
	 
 }
	 


 	public static void main(String [] args){
 		JFrame frame = new MainWindows();
 	}

}