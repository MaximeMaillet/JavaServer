package ihm.graphic;

import ihm.nographic.ActionConnect;
import ihm.nographic.ActionDisconnect;
import ihm.nographic.ActionSend;
import metier.Engine;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import network.Message;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton butt_connect = new JButton(new ActionConnect());
	private JButton butt_disconnect = new JButton(new ActionDisconnect());
	private JButton butt_send = new JButton(new ActionSend(this));
	private JTextField text_speak = new JTextField();
	private PanelMessage text_panel = new PanelMessage();

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
		Engine.getInstance().addObserver(this.text_panel);
		return this.text_panel;
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
