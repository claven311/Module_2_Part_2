package contactBookCreator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ContactCreator extends JFrame 
{
  private JPanel masterPanel;
  private JPanel infoPanel;
  private JPanel buttonPanel;
  private JLabel labelFirst;
  private JLabel labelLast;
  private JLabel labelAddress;
  private JLabel labelPhone;
  private JTextField textFirst;
  private JTextField textLast;
  private JTextField textAddress;
  private JTextField textPhone;
  private JButton submitButton;
  private JTextArea contactDisplay;
  private JScrollPane displayScroll;
  private final int WINDOW_WIDTH = 800;
  private final int WINDOW_HEIGHT = 200;
  private ArrayList<Contact> contactList = new ArrayList<Contact>();
  
  // Constructor
  public ContactCreator()
  {
    // Set title, size, and close operation for the JFrame
    setTitle("Contact Creator");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Build the master panel and add it to the JFrame
    buildMasterPanel();
    add(masterPanel);
    
    setVisible(true);
    
  }
  
  /*
   * Method buildMasterPanel creates a JPanel object, then
   * calls three other JPanel building methods and adds them
   * to the masterPanel
   */
  private void buildMasterPanel()
  {
	  masterPanel = new JPanel();
	  masterPanel.setLayout(new GridLayout(0, 2));
	  
	  buildInfoPanel();
	  masterPanel.add(infoPanel);
	  
	  buildScrollArea();
	  masterPanel.add(displayScroll);
	  
	  buildButtonPanel();
	  masterPanel.add(buttonPanel);
  }

  /*
   * Method buildInfoPanel creates a JPanel infoPanel and creates
   * three JLabels and three corresponding JTextFields and
   * adds them to the infoPanel
   */
  private void buildInfoPanel()
  {
	  labelFirst = new JLabel("First Name:");
	  textFirst = new JTextField(20);
	  
	  labelLast = new JLabel("Last Name:");
	  textLast = new JTextField(20);
	  
	  labelAddress = new JLabel("Address:");
	  textAddress = new JTextField(20);
	  
	  labelPhone = new JLabel("Phone Number:");
	  textPhone = new JTextField(20);
	  
	  infoPanel = new JPanel(new GridLayout(4, 2));
	  infoPanel.add(labelFirst);
	  infoPanel.add(textFirst);
	  infoPanel.add(labelLast);
	  infoPanel.add(textLast);
	  infoPanel.add(labelAddress);
	  infoPanel.add(textAddress);
	  infoPanel.add(labelPhone);
	  infoPanel.add(textPhone);
  }
  
  /*
   * Method buildScrollArea creates a new JScrollPane and 
   * adds a new JTextArea to it.
   */
  private void buildScrollArea()
  {
	  contactDisplay = new JTextArea(0, 2);
	  displayScroll = new JScrollPane(contactDisplay);
  }
  
  /*
   * Method buildButtonPanel creates a new JPanel and adds
   * a new JButton to it.  Also registers a new buttonListener
   * to the JButton.
   */
  private void buildButtonPanel()
  {
	  buttonPanel = new JPanel();
	  submitButton = new JButton("Submit");
	  
	  submitButton.addActionListener(new submitButtonListener());
	  
	  buttonPanel.add(submitButton);
  }
  
  /*
   * Class submitButtonListener defines actions to execute if the JButton Submit is clicked.
   * Creates a new Contact object and determines if it already exists in the contact book.
   * If it already exists, shows a message dialog box to the user.
   * If the new Contact is unique, it will add the Contact to the address book and
   * clear the JTextFields so new entries can be made
   */
  private class submitButtonListener implements ActionListener
  {
	  public void actionPerformed(ActionEvent e)
	  {
		  boolean duplicate = false;			// 
		  
		  // Instantiate new Contact object and add it to an ArrayList
		  Contact newContact = new Contact();
		  newContact.setFirstName(textFirst.getText());
		  newContact.setLastName(textLast.getText());
		  newContact.setAddress(textAddress.getText());
		  newContact.setPhoneNumber(textPhone.getText());
		  
		  
		  // Determine if newContact is unique
		  for (int i = 0; i <contactList.size(); i++)
		  {
			  if (newContact.compareTo(contactList.get(i)) == 0)
			  {
				  duplicate = true;
				  JOptionPane.showMessageDialog(null, "This is a repeat contact.  It will not be added to your contact list.  Edit your new entry.");
				  break;
			  }
		  }
		  
		  // Code that executes if newContact is unique
		  if (duplicate == false)
		  {
			  // Reset text fields to empty strings
			  textFirst.setText("");
			  textLast.setText("");
			  textAddress.setText("");
			  textPhone.setText("");
		  
		  		  
			  contactList.add(newContact);
			  Collections.sort(contactList);
			  
			  //contactDisplay.setText(contactList.toString());  // Commented out. Included brackets and commas in output
			  
			  String bookToText = "";
			  for (int i = 0; i < contactList.size(); i++)
			  {
				  bookToText = bookToText + contactList.get(i).toString();
			  }
			  contactDisplay.setText(bookToText);
				  
			  
		  }
		  
	  }
  }
  
}