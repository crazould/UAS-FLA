package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import utils.mediator.IMediator;
import utils.mediator.Mediator;

public class Todo extends JPanel implements ActionListener, IMediator {
	
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;

	private int id;
	private Mediator mediator;

	public Todo(int id, String text, Mediator mediator) {
		this.setPreferredSize(new Dimension(350, 30));
		this.mediator = mediator;
		this.id = id;
		this.mediator.addComponent( id + "_" +text, this);
			
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		checkbox.addActionListener(this);
		this.add(checkbox, BorderLayout.WEST);
		
		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);

	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		notifyComponent(this.isChecked(), "todos");
	}

	@Override
	public void notifyComponent(boolean signal, String receiverName) {
		mediator.notifyComponent(signal, receiverName);
	}

	@Override
	public void react(boolean signal) {
		
	}

}
