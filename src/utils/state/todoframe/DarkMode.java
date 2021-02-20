package utils.state.todoframe;

import javax.swing.JPanel;

import main.Main;
import ui.TodoFrame;
import utils.decorator.DarkJPanel;
import utils.decorator.LightJPanel;

public class DarkMode implements AppState {

	private Main main;
	
	public DarkMode (Main main) {
		this.main = main;
	}

	@Override
	public void toggleMode() {
		
		if(this.main.getAppState() == this.main.getDarkMode()) {
			this.main.setAppState(this.main.getLightMode());
			this.main.startApp(new LightJPanel());
		}
	}

	@Override
	public void setMode() {
		this.main.startApp(new DarkJPanel());
		
	}

}
