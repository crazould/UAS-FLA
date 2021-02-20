package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.decorator.IModeDecorator;
import utils.decorator.JPanelDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.actions.ActionsState;
import utils.state.actions.Checked;
import utils.state.actions.NoChecked;

public class Actions extends JPanelDecorator implements ActionListener, IMediator{
	
	private JButton done;
	private JButton remove;
	
	private Mediator mediator;
	
	private ActionsState checked;
	private ActionsState noChecked;
	private ActionsState actionsState;

	public Actions(IModeDecorator mode, Mediator mediator) {
		super(mode);
		
		this.mediator = mediator;
		this.mediator.addComponent("Actions", this);
		
		done = new JButton("Done");
		remove = new JButton("Remove");

		this.checked = new Checked(this);
		this.noChecked = new NoChecked(this);
		
		this.setActionsState(noChecked);
		
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
		
		if(this.actionsState instanceof Checked) {
			this.done.setEnabled(true);
			this.remove.setEnabled(true);
		}
		else if(this.actionsState instanceof NoChecked) {
			this.done.setEnabled(false);
			this.remove.setEnabled(false);
		}
		
	}
	
	public ActionsState getCheckedState() {
		return this.checked;
	}
	
	public ActionsState getNoCheckedState() {
		return this.noChecked;
	}
	
	@Override
	public void notifyComponent(String msg, String receiverName) {
		mediator.notifyComponent(msg, "Actions", receiverName);
	}
	
	@Override
	public void react(String msg, String senderName) {
		if(senderName.equals("Todos")) {
			if(msg.equals("true")) setActionsState(checked);
			else setActionsState(noChecked);
		}
		
	}

	public void assamble() {
		super.assamble(this);
	}

}
