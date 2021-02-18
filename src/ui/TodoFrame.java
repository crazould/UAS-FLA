package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TodoFrame extends JFrame {
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;

	public TodoFrame() {
		this.setTitle("Done: 0");

		todoInput = new TodoInput(this);
		this.add(todoInput, BorderLayout.NORTH);

		todos = new Todos(this);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(this);
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
