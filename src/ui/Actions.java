package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Actions extends JPanel implements ActionListener {
	private TodoFrame frame;
	private JButton done;
	private JButton remove;

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
}
