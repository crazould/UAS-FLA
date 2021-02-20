package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;
import utils.decorator.DarkJPanel;
import utils.decorator.IModeDecorator;
import utils.decorator.LightJPanel;
import utils.mediator.IMediator;
import utils.mediator.Mediator;
import utils.state.todoframe.DarkMode;
import utils.state.todoframe.LightMode;
import utils.state.todoframe.AppState;

public class TodoFrame extends JFrame implements IMediator, KeyListener{
	
	
	
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private Integer doneCounter;
	
	private Mediator mediator;
	private IModeDecorator mode;
	
	public TodoFrame(IModeDecorator mode, Mediator mediator) {
		this.mode = mode;
		this.doneCounter = 0;
		this.setTitle("Done: " + doneCounter);
		
		this.mediator = mediator;
		this.mediator.addComponent("TodoFrame", this);
		
		todoInput = new TodoInput(mode, mediator);
		todoInput.assamble();
		todos = new Todos(mode, mediator);
		todos.assamble();
		actions = new Actions(mode, mediator);
		actions.assamble();
		
		this.add( todos, BorderLayout.CENTER);
		this.add( todoInput, BorderLayout.NORTH);
		this.add( actions, BorderLayout.SOUTH);
		
		addKeyListener(this);
		setFocusable(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
		
	}

	
	public void addTodo(String text) {
		todos.addTodo(text, mode);
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
	public void notifyComponent(String msg, String receiverName) {
		this.mediator.notifyComponent(msg, "TodoFrame", receiverName);
	}

	@Override
	public void react(String msg, String senderName) {
		
		if(senderName.equals("Actions")) {
			if(msg.equals("true")) doneTodos();
			else removeTodos();
		}
		else if(senderName.equals("Todos")) {
			if(msg.equals("true")) addDoneCounter();
		}
		else if(senderName.equals("TodoInput")) {
			addTodo(msg);
		}
		
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
