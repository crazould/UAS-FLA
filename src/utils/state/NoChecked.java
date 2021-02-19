package utils.state;

import javax.swing.JPanel;

public class NoChecked implements ActionsState{

	private JPanel actions;
	
	public NoChecked(JPanel actions) {
		this.actions = actions;
		this.actions
	}

	@Override
	public void doneTodos() {
		
	}

	@Override
	public void removeTodos() {
		
	}

}
