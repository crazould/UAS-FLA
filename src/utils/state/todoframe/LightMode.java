package utils.state.todoframe;

import main.Main;
import ui.TodoFrame;
import utils.decorator.DarkJPanel;
import utils.decorator.LightJPanel;

public class LightMode implements AppState{

	private Main main;
	
	public LightMode(Main main) {
		this.main = main;
	}

	@Override
	public void toggleMode() {
		
		if(this.main.getAppState() == this.main.getLightMode()) {
			this.main.setAppState(this.main.getDarkMode());
			this.main.startApp(new DarkJPanel());
		}
		
	}

	@Override
	public void setMode() {
		this.main.startApp(new LightJPanel());
	}

}
