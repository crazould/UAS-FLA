package utils.decorator;

import java.awt.Color;
import java.awt.Component;

public class DarkJPanel implements IModeDecorator{

	@Override
	public void assamble(Component c) {
		
		c.setBackground(Color.black);
		c.setForeground(Color.white);
		
	}
	
}
