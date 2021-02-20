package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import utils.decorator.DarkJPanel;
import utils.decorator.IModeDecorator;
import utils.decorator.JPanelDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.todoframe.DarkMode;

public class TodoInput extends JPanelDecorator implements ActionListener, IMediator, KeyListener {

	private JTextField text;
	private JButton add;
	private Mediator mediator;

	public TodoInput(IModeDecorator mode, Mediator mediator) {
		super(mode);
		this.mediator = mediator;
		this.mediator.addComponent("TodoInput", this);
		
		text = new JTextField(20);
		add = new JButton("Add");
		
		add.addKeyListener(this);

		this.add(text);
		this.add(add);

		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		notifyComponent(todoText, "TodoFrame");
		

		this.text.setText("");
	}

	@Override
	public void notifyComponent(String msg, String receiverName) {
		this.mediator.notifyComponent(msg, "TodoInput", receiverName);
	}

	@Override
	public void react(String msg, String senderName) {
	}
	
	public void assamble() {
		super.assamble(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == Main.N_KEYCODE) {
			notifyComponent("toggle", "Main");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
