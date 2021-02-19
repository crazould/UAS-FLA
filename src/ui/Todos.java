package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import utils.mediator.IMediator;
import utils.mediator.Mediator;

public class Todos extends JPanel implements IMediator{
	
	private TodoFrame frame;
	private Vector<Todo> todos;
	
	private Mediator mediator;

	public Todos(TodoFrame frame, Mediator mediator) {
		this.frame = frame;
		this.todos = new Vector<>();
		this.mediator = mediator;
		this.mediator.addComponent("todos", this);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		displayTodos();
	}

	public void addTodo(String text) {
		int id = todos.size();
		todos.add(new Todo(id, text, mediator));
		displayTodos();
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

	@Override
	public void notifyComponent(boolean signal, String receiverName) {
		mediator.notifyComponent(signal, receiverName);
	}

	@Override
	public void react(boolean signal) {
		
		boolean isCheckedExist = false;
		
		if(signal) isCheckedExist = true;
		
		for (Todo todo : todos) {
			if(isCheckedExist) break;
			if(todo.isChecked()) isCheckedExist = true;
		}
		
		notifyComponent(isCheckedExist, "actions");
		
	}
	
	
}
