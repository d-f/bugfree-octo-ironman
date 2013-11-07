import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.aliasi.util.Files;

public class SortTweets extends JFrame {

	private String srcDirectory;
	private JPanel[] panels;
	private JButton[] buttons;
	private JTextArea text;
	private JLabel fileName;
	private static final long serialVersionUID = 1L;
	private int messageID;
	private List<File> files;
	private List<File> dirs;

	public SortTweets() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			init();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new SortTweets();

	}

	private void init() throws FileNotFoundException {
		buttons = null;
		dirs = new ArrayList<File>();
		files = new ArrayList<File>();

		while (files == null || files.size() <= 0) {
			chooseDirectory();
			buttons = initButtons();
		}

		panels = new JPanel[2];
		panels[0] = new JPanel();
		panels[0].setLayout(new BoxLayout(panels[0], BoxLayout.PAGE_AXIS));
		panels[0].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panels[1] = new JPanel();
		panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.LINE_AXIS));
		panels[1].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		Scanner scanner = new Scanner(files.get(messageID));
		StringBuffer buf = new StringBuffer();

		while (scanner.hasNextLine()) {
			buf.append(scanner.nextLine());
		}

		scanner.close();

		text = new JTextArea(buf.toString());
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.setSize(200, 40);

		fileName = new JLabel(files.get(messageID).getName());
		fileName.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panels[0].add(text);
		panels[1].add(Box.createHorizontalGlue());

		if (buttons != null) {
			for (JButton jButton : buttons) {
				panels[1].add(jButton);
				panels[1].add(Box.createRigidArea(new Dimension(10, 0)));
			}			
		}

		this.setLayout(new BorderLayout());
		this.getContentPane().add(fileName, BorderLayout.NORTH);
		this.getContentPane().add(panels[0], BorderLayout.CENTER);
		this.getContentPane().add(panels[1], BorderLayout.SOUTH);
	}

	private JButton[] initButtons() {
		JButton[] buttons = null;

		if (dirs.size() > 0 && dirs.size() <= 5) {
			buttons = new JButton[dirs.size()];

			for (int i = 0; i < buttons.length; i++) {
				buttons[i] = new JButton(dirs.get(i).getName());
				buttons[i].addActionListener(new ButtonListener(dirs.get(i).getAbsolutePath()));
			}
		}

		return buttons;

	}

	private void chooseDirectory() {
		JFileChooser chooser = new JFileChooser("Verzeichnis wählen");
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setVisible(true);
		chooser.showOpenDialog(this);
		srcDirectory = chooser.getSelectedFile().toString();

		File dir = new File(srcDirectory);
		File[] data = dir.listFiles();

		messageID = 0;

		for (File e : data) {
			if (e.isDirectory()) {
				dirs.add(e);
			} else if (e.isFile()) {
				if (e.getName().toLowerCase().endsWith(".txt")) {
					files.add(e);
				}
			}
		}
	}

	private boolean nextFile() {
		boolean success = false;
		Scanner scanner;

		if (++messageID < files.size()) {
			try {
				scanner = new Scanner(files.get(messageID));
				StringBuffer buf = new StringBuffer();

				while (scanner.hasNextLine()) {
					buf.append(scanner.nextLine());
				}

				scanner.close();
				fileName.setText(files.get(messageID).getName());
				text.setText(buf.toString());
				success = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			messageID--;
		}

		return success;
	}

	private void exit(boolean exit) {
		if (exit) {
			text.setText("No more Message!");
			for (JButton button : buttons) {
				button.setEnabled(false);
			}
		}
	}

	class ButtonListener implements ActionListener {

		private String dirPath;

		public ButtonListener(String dirPath) {
			this.dirPath = dirPath;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Files.copyFile(files.get(messageID), new File(dirPath + "/"
						+ files.get(messageID).getName()));
				files.get(messageID).delete();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			exit(!nextFile());
		}

	}

}