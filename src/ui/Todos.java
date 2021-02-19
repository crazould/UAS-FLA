package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Todos extends JPanel {
	
	private TodoFrame frame;
	private Vector<Todo> todos;

	public Todos(TodoFrame frame) {
		this.frame = frame;
		this.todos = new Vector<>();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		displayTodos();
	}

	public Todo addTodo(String text) {
		Todo todo = new Todo(text);
		todos.add(todo);
		displayTodos();
		return todo;
	}

	public void done() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		displayTodos();
	}

	public void remove() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		displayTodos();
	}

	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo);
		}
	}
}
