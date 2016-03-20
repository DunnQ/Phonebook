import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class GUIPBOOK {

	public static JFrame frmPhonebook;
	public static JTextField txtName;
	public static JTextField txtNumber;
	public static JTextField txtNotes;
	public static JTextPane txtAll;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPBOOK window = new GUIPBOOK();
					window.frmPhonebook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIPBOOK() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		Phonebook.readPhoneBook("Phonebook.txt");
		Phonebook.sortList();
		frmPhonebook = new JFrame();
		frmPhonebook.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		frmPhonebook.setType(Type.UTILITY);
		frmPhonebook.setTitle("PHONEBOOK");
		frmPhonebook.setBounds(100, 100, 461, 503);
		frmPhonebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainP = new JPanel();
		mainP.setBackground(Color.GRAY);
		frmPhonebook.getContentPane().add(mainP, BorderLayout.CENTER);
		mainP.setLayout(null);

		JButton btnNewButton = new JButton("Find Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Phonebook.displayContact();
			}
		});
		btnNewButton.setBounds(-6, 5, 130, 29);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		mainP.add(btnNewButton);

		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Phonebook.addContact();
				txtName.setText("Name");
				txtNumber.setText("Number");
				txtNotes.setText("Notes");
				Phonebook.sortList();
				try {
					Phonebook.CopyPhoneBookToFile("Phonebook.txt");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAddContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddContact.setBounds(139, 5, 140, 29);
		mainP.add(btnAddContact);

		JButton btnListContacts = new JButton("List Contacts");
		btnListContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Phonebook.listAllContacts();
			}
		});
		btnListContacts.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListContacts.setBounds(284, 5, 140, 29);
		mainP.add(btnListContacts);

		txtName = new JTextField();
		txtName.setFont(UIManager.getFont("Button.font"));
		txtName.setBounds(139, 81, 146, 26);
		txtName.setText("Name");
		mainP.add(txtName);
		txtName.setColumns(10);

		txtNumber = new JTextField();
		txtNumber.setFont(UIManager.getFont("Button.font"));
		txtNumber.setBounds(139, 141, 146, 26);
		txtNumber.setText("Number");
		mainP.add(txtNumber);
		txtNumber.setColumns(10);

		txtNotes = new JTextField();
		txtNotes.setFont(UIManager.getFont("Button.font"));
		txtNotes.setBounds(139, 193, 146, 26);
		txtNotes.setText("Notes");
		mainP.add(txtNotes);
		txtNotes.setColumns(10);

		txtAll = new JTextPane();

		final JScrollPane Window = new JScrollPane(txtAll);
		Window.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Window.setLocation(101, 260);
		Window.setSize(221, 129);
		mainP.add(Window);

	}
}