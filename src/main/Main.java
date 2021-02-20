package main;

import java.time.LocalTime;

import ui.TodoFrame;
import utils.decorator.IModeDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.todoframe.IAppState;
import utils.state.todoframe.DarkMode;
import utils.state.todoframe.LightMode;

// NIM: 2201829035
// Name: Muhammad At Thariq Filardi
public class Main implements IMediator {
	
	public static int N_KEYCODE = 78; 
	private TodoFrame todoFrame;
	private IAppState appState;
	private IAppState lightMode;
	private IAppState darkMode;
	private Mediator mediator;
	
	public Main() {
		
		Thread r = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						
						int hour = LocalTime.now().getHour();
						int minute = LocalTime.now().getMinute();
						
						if(hour == 18 && minute > 0 && getAppState() == getLightMode()) {
							setAppState(darkMode);
							appState.setMode();
						}
						else if(hour == 6 && minute > 0 &&getAppState() == getDarkMode()) {
							setAppState(lightMode);
							appState.setMode();
						}
						
					} catch (Exception e) {
					}
				}
				
			}
		});
		
		r.start();
		
		
		this.mediator = new Mediator();
		this.mediator.addComponent("Main", this);
		this.lightMode = new LightMode(this);
		this.darkMode = new DarkMode(this);
		
		setAppState(lightMode);
		appState.setMode();
		
	}
	
	public void startApp(IModeDecorator mode) {
		
		if(todoFrame != null) todoFrame.dispose();
		todoFrame = new TodoFrame(mode, mediator);
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void setAppState(IAppState state) {
		this.appState = state;
	}
	
	public IAppState getAppState() {
		return this.appState;
	}
	
	public IAppState getLightMode() {
		return this.lightMode;
	}
	
	public IAppState getDarkMode() {
		return this.darkMode;
	}

	@Override
	public void notifyComponent(String msg, String receiverName) {
		
	}

	@Override
	public void react(String msg, String senderName) {
		if(msg.equals("toggle")) {
			this.appState.toggleMode();
		}
	}
	
	
}
