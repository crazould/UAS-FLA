package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.Border;

import main.Main;
import utils.decorator.IModeDecorator;
import utils.decorator.JPanelDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;

@SuppressWarnings("serial")
public class Todo extends JPanelDecorator implements ActionListener, IMediator, KeyListener {
	
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;

	private Mediator mediator;

	public Todo(IModeDecorator mode, int id, String text, Mediator mediator) {
		super(mode);
		this.setPreferredSize(new Dimension(350, 30));
		this.mediator = mediator;
		this.mediator.addComponent("Todo", this);
			
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		checkbox.addActionListener(this);
		this.add(checkbox, BorderLayout.WEST);
		
		addKeyListener(this);
		checkbox.addKeyListener(this);
		
		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);
		
	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.isChecked()) notifyComponent("true", "Todos");
		else notifyComponent("false", "Todos");
	}

	@Override
	public void notifyComponent(String msg, String receiverName) {
		mediator.notifyComponent(msg, "Todo", receiverName);
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
