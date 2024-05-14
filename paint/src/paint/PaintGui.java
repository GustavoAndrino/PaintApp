package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PaintGui extends JFrame {
	public PaintGui() {
		super("Paint Gui");
		setPreferredSize(new Dimension(1280, 720));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addGuiComponents();
	}
	
	public void addGuiComponents() {
		//JPanel configs
		
		JPanel canvasPanel = new JPanel();
		SpringLayout springLayout = new SpringLayout();
		canvasPanel.setLayout(springLayout);
		
		//1.Canvas
		Canvas canvas = new Canvas (1280, 650);
		canvasPanel.add(canvas);
		springLayout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, canvasPanel);
		springLayout.putConstraint(SpringLayout.WEST, canvas, 50, SpringLayout.WEST, canvasPanel);
		
		//2.Color Chooser
		JButton chooseColorButton = new JButton("Chose color");
		//Maybe this below wont work..
		chooseColorButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(null, "Select a color", Color.BLACK);
				chooseColorButton.setBackground(c);
				canvas.setColor(c);
			}
		});
		canvasPanel.add(chooseColorButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, chooseColorButton, 10, SpringLayout.NORTH, canvasPanel);
		springLayout.putConstraint(SpringLayout.WEST, chooseColorButton, 25, SpringLayout.WEST, canvasPanel);
		
		// 3. Reset Button
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.resetCanvas();
			}
		});
		canvasPanel.add(resetButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.NORTH, canvasPanel);
		springLayout.putConstraint(SpringLayout.WEST, resetButton, 150, SpringLayout.WEST, canvasPanel);
		
		this.getContentPane().add(canvasPanel);
	}

}
