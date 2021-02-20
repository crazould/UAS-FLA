package utils.decorator;

import java.awt.Component;

import javax.swing.JPanel;

public class JPanelDecorator extends JPanel implements IModeDecorator {
	
	protected IModeDecorator mode; 
	
	public JPanelDecorator(IModeDecorator mode) {
		this.mode = mode;
	}
	
	@Override
	public void assamble(Component c) {
		this.mode.assamble(c);
		
	}

}
