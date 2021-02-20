package utils.mediator;

public interface IMediator {
	public void notifyComponent(String msg, String receiverName);
	public void react(String msg, String senderName);
}
