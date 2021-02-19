package utils.mediator;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class Mediator {

	HashMap<String, JPanel> components;
	
	public Mediator() {
		components = new HashMap<String, JPanel>();
	}
	
	public void notifyComponent(boolean signal, String receiverName) {
		
		IMediator receiverComponent = (IMediator) getComponent(receiverName);
		
		if(receiverComponent == null) {
			System.out.println("Receiver name is not exist");
		}
		else {
			receiverComponent.react(signal);
		}
		
	}
	
	public void addComponent(String componentName ,JPanel component) {
		components.put(componentName, component);
	}
	
	public JPanel getComponent(String receiverName) {
		return components.get(receiverName);
	}

}
