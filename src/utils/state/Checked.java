package utils.state;

import javax.swing.JPanel;

public class Checked implements ActionsState{

	private JPanel actions;
	
	public Checked(JPanel actions) {
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
