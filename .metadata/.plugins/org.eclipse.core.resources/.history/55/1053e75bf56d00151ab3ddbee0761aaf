package ihm.graphic;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ihm.nographic.ActionConnect;
import ihm.nographic.ActionDisconnect;
import ihm.nographic.ActionSend;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton butt_connect = new JButton(new ActionConnect());
	private JButton butt_disconnect = new JButton(new ActionDisconnect());
	private JButton butt_send = new JButton(new ActionSend(this));
	private JTextField text_speak = new JTextField();
	private JTextPane text_panel = new JTextPane();

	public MainView()
	{
		super("Mon appli");		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		topPanel.add(this.drawLeftPanel());
		topPanel.add(this.drawMainPanel());
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(this.drawTextPanel());
		
		this.add(topPanel);
		this.add(bottomPanel);
	}
	
	public JTextField getSpeak() {
		return text_speak;
	}

	public JTextPane getPanel() {
		return text_panel;
	}

	public JPanel drawLeftPanel()
	{
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		result.add(butt_connect);
		result.add(butt_disconnect);
		return result;
	}
	
	public JPanel drawMainPanel()
	{
		JPanel result = new JPanel();
		text_panel.setPreferredSize(new Dimension(500, 250));
		result.add(text_panel);
		return result;
	}
	
	public JPanel drawTextPanel()
	{
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.X_AXIS));
		text_speak.setPreferredSize(new Dimension(500, 30));
		result.add(text_speak);
		result.add(butt_send);
		return result;
	}
	
	public void display()
	{
		this.pack();
		this.setLocation(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
