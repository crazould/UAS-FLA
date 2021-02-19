package utils.mediator;

public interface IMediator {
	public void notifyComponent(boolean signal, String receiverName);
	public void react(boolean signal, String senderName);
}
