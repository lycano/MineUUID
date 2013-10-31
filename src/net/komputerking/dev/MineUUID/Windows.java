package net.komputerking.dev.MineUUID;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Windows extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3624047165499519177L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMinecraftUsername;
	private JTextField txtCreatedByThekomputerking;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Windows dialog = new Windows();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Windows() {
		setBackground(new Color(0, 204, 204));
		setTitle("MineUUID Checker");
		setBounds(100, 100, 560, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtMinecraftUsername = new JTextField();
			txtMinecraftUsername.setText("Minecraft Username");
			contentPanel.add(txtMinecraftUsername);
			txtMinecraftUsername.setColumns(48);
			txtMinecraftUsername.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					if (txtMinecraftUsername.getText() == "Minecraft Username"){
						txtMinecraftUsername.setText("");
					}
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Get UUID");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtCreatedByThekomputerking.setText("Fetching UUID...");
						txtCreatedByThekomputerking.setText(Main.getUUID(txtMinecraftUsername.getText()));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				{
					txtCreatedByThekomputerking = new JTextField();
					txtCreatedByThekomputerking.setText("Created By TheKomputerKing");
					txtCreatedByThekomputerking.setEditable(false);
					txtCreatedByThekomputerking.setBackground(Color.LIGHT_GRAY);
					buttonPane.add(txtCreatedByThekomputerking);
					txtCreatedByThekomputerking.setColumns(40);
				}
			}
		}
	}

}
