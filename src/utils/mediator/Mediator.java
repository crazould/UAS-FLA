package utils.mediator;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class Mediator {

	HashMap<String, IMediator> components;
	
	public Mediator() {
		components = new HashMap<String, IMediator>();
	}
	
	public void notifyComponent(boolean signal, String senderName, String receiverName) {
		
		IMediator receiverComponent = getComponent(receiverName);
		
		if(receiverComponent == null) {
			System.out.println("Receiver name is not exist");
		}
		else {
			receiverComponent.react(signal, senderName);
		}
		
	}
	
	public void addComponent(String componentName ,IMediator component) {
		components.put(componentName, component);
	}
	
	public IMediator getComponent(String receiverName) {
		return components.get(receiverName);
	}

}
