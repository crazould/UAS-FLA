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

import utils.Observable;
import utils.Observer;

public class Todo extends JPanel implements Observable, ActionListener {
	
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;
	private ArrayList<Observer> observerList;


	public Todo(String text) {
		this.setPreferredSize(new Dimension(350, 30));

		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		this.checkbox.addActionListener(this);
		this.add(checkbox, BorderLayout.WEST);
		
		this.observerList = new ArrayList<Observer>();

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);

	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observerList) {
			observer.update(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.isChecked()) {
			System.out.println(this.label.getText());
		this.notifyObserver();
			
		}
		
	}
}
