package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Observable;
import utils.Observer;
import utils.state.ButtonState;

public class Actions extends JPanel implements ActionListener, Observer {
	private TodoFrame frame;
	private JButton done;
	private JButton remove;
	
	private ButtonState checked;
	private ButtonState noChecked;
	
	private ButtonState buttonState;

	public Actions(TodoFrame frame) {
		this.frame = frame;

		done = new JButton("Done");
		remove = new JButton("Remove");

		this.add(done);
		this.add(remove);
		
		done.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			frame.doneTodos();
		}

		if (e.getSource().equals(remove)) {
			frame.removeTodos();
		}
	}

	@Override
	public void update(Observable observable) {
		
		Todo todo = (Todo) observable;
		System.out.println("masuk");
		
		if(todo.isChecked()) {
			
			this.done.setEnabled(true);
			this.remove.setEnabled(true);
			
		}
		else {
			
			this.done.setEnabled(false);
			this.remove.setEnabled(false);
			
		}
	
	}

	@Override
	public void subscribe(Observable observable) {
		observable.addObserver(this);
	}
}
