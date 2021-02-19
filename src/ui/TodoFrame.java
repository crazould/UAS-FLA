package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.mediator.IMediator;
import utils.mediator.Mediator;

public class TodoFrame extends JFrame implements IMediator, KeyListener{
	
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private Integer doneCounter;
	
	private Mediator mediator;
	
	public TodoFrame() {
		doneCounter = 0;
		
		this.setTitle("Done: " + doneCounter);

		mediator = new Mediator();
		mediator.addComponent("TodoFrame", this);
		
		todoInput = new TodoInput(this);
		this.add(todoInput, BorderLayout.NORTH);
		
		todos = new Todos(mediator);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(mediator);
		this.add(actions, BorderLayout.SOUTH);
		
		todos.addKeyListener(this);
		todoInput.addKeyListener(this);
		actions.addKeyListener(this);
		this.addKeyListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	public void addTodo(String text) {
		todos.addTodo(text);
		this.pack();
	}
	
	public void doneTodos() {
		todos.done();
		this.pack();
	}

	public void removeTodos() {
		todos.remove();
		this.pack();
	}
	
	private void addDoneCounter() {
		this.doneCounter++;
		this.setTitle("Done: "+ doneCounter);
	}

	@Override
	public void notifyComponent(boolean signal, String receiverName) {
		
	}

	@Override
	public void react(boolean signal, String senderName) {
		
		if(senderName.equals("Actions")) {
			if(signal) doneTodos();
			else removeTodos();
		}
		else if(senderName.equals("Todos")) {
			if(signal) addDoneCounter();
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
