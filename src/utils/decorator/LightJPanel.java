package utils.decorator;

import java.awt.Color;
import java.awt.Component;

public class LightJPanel implements IModeDecorator {


	@Override
	public void assamble(Component c) {
		
		c.setBackground(Color.white);
		c.setForeground(Color.black);
		
	}
	

}
