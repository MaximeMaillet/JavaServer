package main;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import metier.Engine;
import ihm.graphic.MainView;

/**
 * Class where launch application
 * @author Maxime
 *
 */
public class Main {

	public static void main(String[] args)
	{
		setBestLookAndFeelAvailable();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainView main = new MainView();
				main.display();
				Engine.getInstance().start(main);
			}
		});
	}
	
	public static void setBestLookAndFeelAvailable(){
		String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
		
		if(system_lf.contains("metal")){
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}catch (Exception e) {}
		}else{
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch (Exception e) {}
		}
	}
}
