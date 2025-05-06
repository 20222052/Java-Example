package baitap;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class bai23 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private double soThuNhat = 0;
	private String phepToan = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				bai23 frame = new bai23();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public bai23() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 5;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		ActionListener soListener = e -> textField.setText(textField.getText() + ((JButton)e.getSource()).getText());

		ActionListener toanTuListener = e -> {
			soThuNhat = Double.parseDouble(textField.getText());
			phepToan = ((JButton)e.getSource()).getText();
			textField.setText("");
		};

		ActionListener ketQuaListener = e -> {
			double soThuHai = Double.parseDouble(textField.getText());
			double ketQua = 0;
			switch (phepToan) {
				case "+": ketQua = soThuNhat + soThuHai; break;
				case "-": ketQua = soThuNhat - soThuHai; break;
				case "*": ketQua = soThuNhat * soThuHai; break;
				case "/":
					if (soThuHai != 0) ketQua = soThuNhat / soThuHai;
					else textField.setText("Loi chia 0");
					return;
				default: return;
			}
			textField.setText(String.valueOf(ketQua));
		};

		ActionListener clearListener = e -> {
			textField.setText("");
			soThuNhat = 0;
			phepToan = "";
		};

		String[][] nut = {
			{"AC", ",", "%", "/"},
			{"7", "8", "9", "*"},
			{"4", "5", "6", "-"},
			{"1", "2", "3", "+"},
			{"", "0", "", "="}
		};

		for (int i = 0; i < nut.length; i++) {
			for (int j = 0; j < nut[i].length; j++) {
				if (nut[i][j].equals("")) continue;
				JButton btn = new JButton(nut[i][j]);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, (i < nut.length - 1) ? 5 : 0, (j < nut[i].length - 1) ? 5 : 0);
				gbc.gridx = j;
				gbc.gridy = i + 3;
				contentPane.add(btn, gbc);

				if (nut[i][j].matches("\\d")) {
					btn.addActionListener(soListener);
				} else if (nut[i][j].matches("[\\+\\-\\*/]")) {
					btn.addActionListener(toanTuListener);
				} else if (nut[i][j].equals("=")) {
					btn.addActionListener(ketQuaListener);
				} else if (nut[i][j].equals("AC")) {
					btn.addActionListener(clearListener);
				} else if (nut[i][j].equals(",")) {
					btn.addActionListener(e -> textField.setText(textField.getText() + "."));
				} else if (nut[i][j].equals("%")) {
					btn.addActionListener(e -> {
						double so = Double.parseDouble(textField.getText());
						textField.setText(String.valueOf(so / 100));
					});
				}
			}
		}
	}
}
