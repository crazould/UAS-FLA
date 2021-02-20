package ui;

import java.util.Vector;

import javax.swing.BoxLayout;

import utils.decorator.IModeDecorator;
import utils.decorator.JPanelDecorator;
import utils.mediator.IMediator;
import utils.mediator.Mediator;

@SuppressWarnings("serial")
public class Todos extends JPanelDecorator implements IMediator{
	
	private Vector<Todo> todos;
	
	private Mediator mediator;

	public Todos(IModeDecorator mode, Mediator mediator) {
		super(mode);
		this.todos = new Vector<>();
		this.mediator = mediator;
		this.mediator.addComponent("Todos", this);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		displayTodos();
	}

	public void addTodo(String text, IModeDecorator mode) {
		int id = todos.size();
		Todo todo = new Todo(mode, id, text, mediator);
		todo.assamble();
		todos.add(todo);
		displayTodos();
	}

	public void done() {
		
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				notifyComponent("true", "TodoFrame");
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
	public void notifyComponent(String msg, String receiverName) {
		mediator.notifyComponent(msg, "Todos", receiverName);
	}

	@Override
	public void react(String msg, String senderName) {
		
		if(senderName.equals("Todo")) {
			boolean isCheckedExist = false;
			if(msg.equals("true")) isCheckedExist = true;
			for (Todo todo : todos) {
				if(isCheckedExist) break;
				if(todo.isChecked()) isCheckedExist = true;
			}
			if(isCheckedExist) notifyComponent("true", "Actions");
			else notifyComponent("false", "Actions");
		}
		
	}
	
	public void assamble() {
		super.assamble(this);
	}
	
	
}
