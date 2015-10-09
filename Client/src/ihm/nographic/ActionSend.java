package ihm.nographic;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ihm.graphic.MainView;
import network.Connexion;
import network.Message;
import network.Message.TypeMessage;

public class ActionSend extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainView currentFrame;
	
	public ActionSend(MainView _currentFrame) {
		super("Send");
		this.currentFrame = _currentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Connexion myConnexion = new Connexion();
		myConnexion.sendMessage(new Message(this.currentFrame.getSpeak().getText(), TypeMessage.MESSAGE));
	}
}
