
import javax.swing.ImageIcon;

import javax.swing.JButton;



	public class SpeedJButton extends JButton {





	/**

	* 

	*/

	private static final long serialVersionUID = 1L;

	public int x=0;//¦C

	public int y=0;//¦æ

	public int color=Role.Red;
	

	public int speed=5;

	 int dir=0; //¶¶®ÉÄÁ¨¤«×



	public SpeedJButton() {

	// TODO Auto-generated constructor stub

	super();

	}

	public SpeedJButton(String string) {

	// TODO Auto-generated constructor stub

	super(string);

	}



	public void setColor(int c, ImageIcon imgs[]) {

	color = c;

	setIcon(imgs[c]);

	}



	public void setData(int px, int py, int pspeed, int pdir) {

	x = px;

	y = py;

	speed = pspeed;

	dir = pdir;

	setBounds(x, y, 20, 20);

	}

	public boolean Move() {

	//new x,y

	int x2 = (int) (x + Math.cos(Math.toRadians(dir))*speed);

	int y2 = (int) (y + Math.sin(Math.toRadians(dir))*speed);

	if(x2>=0 && y2>=0 && x2 <= 300 && y2<=300) {

	x = x2;

	y = y2;

	setLocation(x,y);

	return true;

	}

	return false;

	}





	}

