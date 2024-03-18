package wordcount;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private JLabel wordCountLabel;

    public WordCount() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        initComponents();
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });

        wordCountLabel = new JLabel("Word Count: 0");

        JPanel panel = new JPanel(new BorderLayout());//space
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(wordCountLabel, BorderLayout.SOUTH);
    }

    private int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCount().setVisible(true);
            }
        });
    }
}


