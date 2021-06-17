import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{ 
	
	JFrame window; 
	JTextArea textArea;
	JScrollPane scrollPane; 
	boolean wordWrapON = false;
	JMenuBar menuBar; 
	JMenu menuFile, menuEdit, menuFormat, menuColor; 
	JMenuItem Inew, Iopen, Isave, Isaveas, Iexit;
	JMenuItem iUndo, iRedo;
	JMenuItem Iwrap,IFontArial, IFontCSMS, IFontTMR, IFontsize8, IFontsize12, IFontsize16, IFontsize20, IFontsize24, IFontsize28;
	JMenu menuFont, menuFontSize;
	JMenuItem iColor1, iColor2, iColor3;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this); 
	Function_Edit edit = new Function_Edit(this); 
	
	KeyHandler kHandler = new KeyHandler(this);
	
	UndoManager um = new UndoManager();

	public static void main(String[] args) {
		
		new GUI();

	} 
	
	public GUI() { 
		
		createWindow(); 
		createTextArea();
		createMenuBar(); 
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu(); 
		
		format.selectFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White"); 
		window.setVisible(true);
		
	} 
	
	public void createWindow() { 
		
		window = new JFrame("Notepad"); 
		window.setSize(800, 600); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	} 
	public void createTextArea() { 
		
		textArea = new JTextArea();
		textArea.setFont(format.arial); 
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
				(UndoableEditListener) new UndoableEditListener() { 
					public void undoableEditHappened(UndoableEditEvent e) { 
						um.addEdit(e.getEdit());
					}
				});
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		
		
	} 
	
	public void createMenuBar() { 
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar); 
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile); 
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
	} 
	
	public void createFileMenu() { 
		
		Inew = new JMenuItem("New"); 
		Inew.addActionListener(this);
		Inew.setActionCommand("New");
		menuFile.add(Inew); 
		
		Iopen = new JMenuItem("Open"); 
		Iopen.addActionListener(this);
		Iopen.setActionCommand("Open");
		menuFile.add(Iopen); 
		
		Isave = new JMenuItem("Save"); 
		Isave.addActionListener(this);
		Isave.setActionCommand("Save");
		menuFile.add(Isave); 
		
		Isaveas = new JMenuItem("Save As");
		Isaveas.addActionListener(this);
		Isaveas.setActionCommand("Save As");
		menuFile.add(Isaveas); 
		
		Iexit = new JMenuItem("Exit"); 
		Iexit.addActionListener(this);
		Iexit.setActionCommand("Exit");
		menuFile.add(Iexit);
	}  
	
	public void createEditMenu() { 
		
		iUndo = new JMenuItem("Undo"); 
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo"); 
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo); 
		
		
	}
	
	public void createFormatMenu() { 
		
		Iwrap = new JMenuItem("Word Wrap: OFF");
		Iwrap.addActionListener(this);
		Iwrap.setActionCommand("Word Wrap");
		menuFormat.add(Iwrap);
		
		menuFont = new JMenu("Font"); 
		menuFormat.add(menuFont);
		
		IFontArial = new JMenuItem("Arial");
		IFontArial.addActionListener(this);
		IFontArial.setActionCommand("Arial");
		menuFont.add(IFontArial);
		
		IFontCSMS = new JMenuItem("Comic Sams MS");
		IFontCSMS.addActionListener(this);
		IFontCSMS.setActionCommand("Comic Sams MS");
		menuFont.add(IFontCSMS);
		
		IFontTMR = new JMenuItem("Times New Roman");
		IFontTMR.addActionListener(this);
		IFontTMR.setActionCommand("Times New Roman");
		menuFont.add(IFontTMR);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		IFontsize8 = new JMenuItem("8");
		IFontsize8.addActionListener(this);
		IFontsize8.setActionCommand("8");
		menuFontSize.add(IFontsize8); 
		
		IFontsize12 = new JMenuItem("12");
		IFontsize12.addActionListener(this);
		IFontsize12.setActionCommand("12");
		menuFontSize.add(IFontsize12);
		
		IFontsize16 = new JMenuItem("16");
		IFontsize16.addActionListener(this);
		IFontsize16.setActionCommand("16");
		menuFontSize.add(IFontsize16);
		
		IFontsize20 = new JMenuItem("20");
		IFontsize20.addActionListener(this);
		IFontsize20.setActionCommand("20");
		menuFontSize.add(IFontsize20);
		
		IFontsize24 = new JMenuItem("24");
		IFontsize24.addActionListener(this);
		IFontsize24.setActionCommand("24");
		menuFontSize.add(IFontsize24);
		
		IFontsize28 = new JMenuItem("28");
		IFontsize28.addActionListener(this);
		IFontsize28.setActionCommand("28");
		menuFontSize.add(IFontsize28);
	} 
	
	public void createColorMenu() { 
		
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		switch(command) { 
		case "New": file.newFile(); 
		break; 
		case "Open": file.open(); 
		break; 
		case "Save As": file.saveAs(); 
		break;
		case "Save": file.saved(); 
		break; 
		case "Exit": file.exit(); 
		break; 
		case "Undo": edit.undo(); 
		break;  
		case "Redo": edit.redo(); 
		break;
		case "Word Wrap": format.wordWrap(); 
		break;
		case "Arial": format.setFont(command); 
		break;
		case "Comic Sams MS": format.setFont(command); 
		break;
		case "Times New Roman": format.setFont(command); 
		break;
		case "size8": format.createFont(8); 
		break;
		case "size12": format.createFont(12); 
		break;
		case "size16": format.createFont(16); 
		break;
		case "size20": format.createFont(20); 
		break;
		case "size24": format.createFont(24); 
		break;
		case "size28": format.createFont(28); 
		break;
		case "White": color.changeColor(command);
		break;
		case "Black": color.changeColor(command);
		break;
		case "Blue": color.changeColor(command);
		break;
		
		}
		
	}

}
