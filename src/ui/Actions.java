package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.ActionsState;
import utils.state.Checked;
import utils.state.NoChecked;

public class Actions extends JPanel implements ActionListener, IMediator {
	
	private TodoFrame frame;
	private JButton done;
	private JButton remove;
	
	private Mediator mediator;
	
	private ActionsState checked;
	private ActionsState noChecked;
	private ActionsState actionsState;

	public Actions(TodoFrame frame, Mediator mediator) {
		this.frame = frame;
		this.mediator = mediator;
		this.mediator.addComponent("actions", this);
		
		done = new JButton("Done");
		remove = new JButton("Remove");

		this.checked = new Checked(this);
		this.noChecked = new NoChecked(this);
		
		this.actionsState = noChecked;
		
		this.done.setEnabled(false);
		this.remove.setEnabled(false);
		
		this.add(done);
		this.add(remove);
		
		done.addActionListener(this);
		remove.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			actionsState.doneTodos();
		}
		if (e.getSource().equals(remove)) {
			actionsState.removeTodos();
		}
	}
	
	public void setActionsState(ActionsState state) {
		this.actionsState = state;
	}

	@Override
	public void notifyComponent(boolean signal, String receiverName) {
		mediator.notifyComponent(signal, receiverName);
	}
	
	@Override
	public void react(boolean signal) {
		setActionsState(signal ? checked : noChecked);
	}

}
