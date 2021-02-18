package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TodoInput extends JPanel implements ActionListener {
	private TodoFrame frame;
	private JTextField text;
	private JButton add;

	public TodoInput(TodoFrame frame) {
		this.frame = frame;

		text = new JTextField(20);
		add = new JButton("Add");

		this.add(text);
		this.add(add);

		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		frame.addTodo(todoText);

		this.text.setText("");
	}
}
