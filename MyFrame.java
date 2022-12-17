import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String message = "";
	private String letter = "";
	JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Guess_Word", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addContainerGap())
		);

		textField = new JTextField();
		textField.setBackground(new Color(119, 136, 153));
		textField.setColumns(10);
		textField.setEditable(false);
		
		String string = wordInTextField();

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setEditable(false);

		JButton btnNewButton = new JButton("Next");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnNewButton) {
					String string = wordInTextField();
					textField.setText(string);
					textField_1.setText("");
					textField_2.setText("");
					textField_2.setBackground(Color.WHITE);
				}

			}
		});
		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					textField.setText(string);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
				} else {
					textField.setText("");
					textField_1.setEditable(false);
					textField_2.setEditable(false);
				}
			}
		});
		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_2.setEditable(false);

		textField_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					message = textField_1.getText();
					isCorrect(message, letter);
				}

			}

		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void isGame() {

	}

	private String wordInTextField() {
		Word word = new Word();
		Random random = new Random();

		int index = random.nextInt(word.wordList.size());

		letter = word.wordList.get(index);
		StringBuilder string = new StringBuilder(letter);

		for (int i = 0; i < letter.length()/2; i++) {
			string.setCharAt(random.nextInt(letter.length()), '_');
		}

		return string.toString();
	}

	private void isCorrect(String message, String letter) {
		if (message.equals(letter)) {
			textField_2.setText("Correct");
			textField_2.setBackground(Color.GREEN);
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			Font oldFont = textField_2.getFont();
			Font newFont = new Font(oldFont.getName(),Font.BOLD + Font.ITALIC,oldFont.getSize());
			textField_2.setFont(newFont);
			
		} else {
			textField_2.setText("Wrong");
			textField_2.setBackground(Color.RED);
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			Font oldFont = textField_2.getFont();
			Font newFont = new Font(oldFont.getName(),Font.BOLD + Font.ITALIC,oldFont.getSize());
			textField_2.setFont(newFont);
			
		}
	}
}
