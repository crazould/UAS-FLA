package utils.state;

import javax.swing.JPanel;

import ui.Actions;

public class Checked implements ActionsState{

	private Actions actions;
	
	public Checked(Actions actions) {
		this.actions = actions;
	}

	@Override
	public void doneTodos() {
		this.actions.notifyComponent(true, "TodoFrame");
		this.actions.setActionsState(this.actions.getNoCheckedState());
		
	}

	@Override
	public void removeTodos() {
		this.actions.notifyComponent(false, "TodoFrame");
		this.actions.setActionsState(this.actions.getNoCheckedState());
	}

}
