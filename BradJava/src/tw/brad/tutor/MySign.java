package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.apis.MyDrwaer;

public class MySign extends JFrame{
	private MyDrwaer myDrwaer;
	private JButton clear, undo, redo, chColor, saveObj, loadObj;
	
	public MySign() {
		super("Sign App");
		setLayout(new BorderLayout());
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		chColor = new JButton("Color");
		saveObj = new JButton("Save Object");
		loadObj = new JButton("Load Object");
		
		myDrwaer = new MyDrwaer();
		add(myDrwaer, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		top.add(chColor);top.add(saveObj);top.add(loadObj); 
		
		add(top, BorderLayout.NORTH);
		
		
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrwaer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrwaer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrwaer.redo();
			}
		});
		chColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
			}
		});
		
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, 
				"Change Color", myDrwaer.getDefaultColor());
		if (newColor != null) {
			myDrwaer.setDefaultColor(newColor);
		}
	}
	
	private void saveObj() {
		JFileChooser jfc = new JFileChooser(new File("."));
		int ret = jfc.showSaveDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				myDrwaer.saveObj(saveFile);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Save Failure:" + e.toString());
			}
		}
		
	}
	private void loadObj() {
		JFileChooser jfc = new JFileChooser(new File("."));
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File loadFile = jfc.getSelectedFile();
			try {
				myDrwaer.loadObj(loadFile);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failure:" + e.toString());
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
