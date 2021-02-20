package utils.state.actions;


import ui.Actions;

public class NoChecked implements IActionsState{

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
