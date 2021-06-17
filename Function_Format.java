import java.awt.Font;

public class Function_Format {
	
	GUI gui; 
	Font arial, comicSamsMS, timesNewRoman;
	String selectFont;
	
	public Function_Format(GUI gui) { 
		
		this.gui = gui; 
		
		
	} 
	
	public void wordWrap() { 
		
		if(gui.wordWrapON == false) { 
			gui.wordWrapON = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.Iwrap.setText("Word Wrap: ON");
		}
		else if(gui.wordWrapON==true) { 
			gui.wordWrapON = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.Iwrap.setText("Word Wrap: OFF");
		}
	}
	
	public void createFont( int fontSize) { 
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSamsMS = new Font("Comic Sams MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		
		setFont(selectFont);
		
	} 
	
	public void setFont(String font) { 
		selectFont = font;
		
		switch(selectFont) {
		case "Arial" : 
			gui.textArea.setFont(arial);
		break;
		case "Comic Sams MS" : 
			gui.textArea.setFont(comicSamsMS);
		break;
		case "Times New Roman" : 
			gui.textArea.setFont(timesNewRoman);
		break;
		
		
		
		}
	}

}
