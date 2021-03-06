import java.io.*;
import java.util.*;
// Written By: Quentin Dunbar
// Dr. Henry Ledgard
// 5/3/15
// This program is a phonebook that takes a contact and integrates it into a GUI 
// where the contact can be stored, found and listed within a txt document.

class Entry {
	public String name, number, notes;
}

public class Phonebook {
	public static Entry[] contactList = new Entry[200];
	public static int num_entries;
	public static Scanner stdin = new Scanner(System.in);
	public static Object entryList;

	public static void readPhoneBook(String Phonebook) throws Exception {
		File phonebook;
		phonebook = new File(Phonebook);
		Scanner S = new Scanner(phonebook);

		while (S.hasNext()) {
			contactList[num_entries] = new Entry();
			contactList[num_entries].name = S.nextLine();
			contactList[num_entries].number = S.nextLine();
			contactList[num_entries].notes = S.nextLine();
			num_entries++;
		}
		S.close();
	}

	public static void addContact() {
		String name = GUIPBOOK.txtName.getText();
		String number = GUIPBOOK.txtNumber.getText();
		String notes = GUIPBOOK.txtNotes.getText();
		contactList[num_entries] = new Entry();
		contactList[num_entries].name = name;
		contactList[num_entries].number = number;
		contactList[num_entries].notes = notes;
		num_entries++;
	}

	public static int find(String Name) {

		for (int i = 0; i < num_entries; i++) {
			if (contactList[i].name.equalsIgnoreCase(Name))
				return i;
		}
		return -1;
	}

	public static void displayContact() {
		String name = GUIPBOOK.txtName.getText();
		int x = find(name);
		String name1 = contactList[x].name;
		String number = contactList[x].number;
		String notes = contactList[x].notes;
		GUIPBOOK.txtName.setText(name1);
		GUIPBOOK.txtNumber.setText(number);
		GUIPBOOK.txtNotes.setText(notes);
	}

	public static void listAllContacts() {
		String all = "";
		int i = 0;
		while (i < num_entries) {
			all = all
					+ (contactList[i].name + "\n" + contactList[i].number
							+ "\n" + contactList[i].notes + "\n" + "\n");
			i++;
		}
		GUIPBOOK.txtAll.setText(all);
	}

	public static void sortList() {
		int i;
		Entry temp;
		temp = new Entry();

		for (int j = 0; j < num_entries; j++) {
			for (i = j + 1; i < num_entries; i++) {
				if (contactList[j].name.compareToIgnoreCase(contactList[i].name) > 0) {
					temp = contactList[j];
					contactList[j] = contactList[i];
					contactList[i] = temp;
				}
			}
		}
	}

	public static void CopyPhoneBookToFile(String FileName) throws Exception {
		FileOutputStream out = new FileOutputStream(FileName);
		PrintStream P = new PrintStream(out);

		for (int i = 0; i < num_entries; i++) {
			P.println(contactList[i].name);
			P.println(contactList[i].number);
			P.println(contactList[i].notes);
		}
	}
}