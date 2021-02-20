package main;

import java.time.LocalDateTime;
import java.time.LocalTime;

import ui.TodoFrame;
import utils.decorator.IModeDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.todoframe.AppState;
import utils.state.todoframe.DarkMode;
import utils.state.todoframe.LightMode;

public class Main implements IMediator {
	
	public static int N_KEYCODE = 78; 
	private TodoFrame todoFrame;
	private AppState appState;
	private AppState lightMode;
	private AppState darkMode;
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
	
	public void setAppState(AppState state) {
		this.appState = state;
	}
	
	public AppState getAppState() {
		return this.appState;
	}
	
	public AppState getLightMode() {
		return this.lightMode;
	}
	
	public AppState getDarkMode() {
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
