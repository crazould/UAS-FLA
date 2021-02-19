package utils.state;

import javax.swing.JPanel;

import ui.Actions;

public class NoChecked implements ActionsState{

	private Actions actions;
	
	public NoChecked(Actions actions) {
		this.actions = actions;
	}

	@Override
	public void doneTodos() {
		return;
	}

	@Override
	public void removeTodos() {
		return;
	}


}
