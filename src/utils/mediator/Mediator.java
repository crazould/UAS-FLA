package utils.mediator;

import java.util.HashMap;

public class Mediator {

	HashMap<String, IMediator> components;
	
	public Mediator() {
		components = new HashMap<String, IMediator>();
	}
	
	public void notifyComponent(String msg, String senderName, String receiverName) {
		
		IMediator receiverComponent = getComponent(receiverName);
		
		if(receiverComponent == null) {
			System.out.println("Receiver name is not exist");
		}
		else {
			receiverComponent.react(msg, senderName);
		}
		
	}
	
	public void addComponent(String componentName ,IMediator component) {
		components.put(componentName, component);
	}
	
	public IMediator getComponent(String receiverName) {
		return components.get(receiverName);
	}

}
