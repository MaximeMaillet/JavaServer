package ihm.graphic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMessage extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollpane;
	private JList<String> text_panel;
	private DefaultListModel<String> listModel;
	
	public PanelMessage() {
		listModel = new DefaultListModel<String>();
		text_panel = new JList(listModel);
		scrollpane = new JScrollPane(text_panel);
		this.scrollpane.setPreferredSize(new Dimension(500,400));
		this.add(scrollpane);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		String m = (String) arg1;
		this.listModel.addElement("> "+m);
		this.text_panel.repaint();
		this.scrollpane.scrollRectToVisible(new Rectangle(0, 100, 400, 70));
	}

	public JList<String> getPanel() {
		return text_panel;
	}

}
