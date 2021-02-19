package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.mediator.Mediator;

public class TodoFrame extends JFrame {
	
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private Mediator mediator;
	
	public TodoFrame() {
		this.setTitle("Done: 0");

		mediator = new Mediator();
		
		todoInput = new TodoInput(this);
		this.add(todoInput, BorderLayout.NORTH);
		
		todos = new Todos(this, mediator);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(this, mediator);
		this.add(actions, BorderLayout.SOUTH);
		
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

	
}
