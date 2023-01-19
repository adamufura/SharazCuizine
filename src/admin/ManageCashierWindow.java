package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.SharazDatabase;
import sharaz.StartWindow;

public class ManageCashierWindow {
	static private String currentSelectedCashier = null;
	static JFileChooser chooser;
	static private SharazDatabase sharazDatabase = new SharazDatabase();

	public ManageCashierWindow() {
	    JFrame frame = new JFrame();        
		
    	IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
    	IconFontSwing.register(FontAwesome.getIconFont());
    	
        ImageIcon icon = new ImageIcon("logo.png");
        ImageIcon adminIcon = new ImageIcon(new ImageIcon("admin.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        // navbar panel
        JPanel navbarPanel = new JPanel();
        navbarPanel.setLayout(new BorderLayout());
        navbarPanel.setBackground(new Color(132, 220, 198));
        navbarPanel.setPreferredSize(new Dimension(0, 100));
        
        JPanel leftNavbarPanel = new JPanel();
        leftNavbarPanel.setLayout(new BorderLayout());
        JSeparator leftNavbarSeparator = new JSeparator();
        leftNavbarPanel.setBackground(new Color(46, 134, 171));
        leftNavbarPanel.setPreferredSize(new Dimension(200, 0));
        JLabel adminaAvatarLabel = new JLabel();
        adminaAvatarLabel.setText("Welcome ADMIN");
        adminaAvatarLabel.setForeground(Color.WHITE);
        adminaAvatarLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        adminaAvatarLabel.setIcon(adminIcon);
		adminaAvatarLabel.setHorizontalTextPosition(JLabel.CENTER);
		adminaAvatarLabel.setVerticalTextPosition(JLabel.BOTTOM);
		adminaAvatarLabel.setVerticalAlignment(JLabel.CENTER);
		adminaAvatarLabel.setHorizontalAlignment(JLabel.CENTER);
        leftNavbarPanel.add(adminaAvatarLabel, BorderLayout.CENTER);
        leftNavbarPanel.add(leftNavbarSeparator, BorderLayout.SOUTH);
        
        
        JPanel rightNavBarPanel = new JPanel();
        rightNavBarPanel.setLayout(new BorderLayout());
        rightNavBarPanel.setBackground(new Color(132, 220, 198));
        JLabel sharazTitle = new JLabel("Sharaz Cuizine Management System");
        sharazTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        sharazTitle.setForeground(Color.WHITE);
        JLabel sharazUserType = new JLabel("[ADMIN]");
        sharazUserType.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sharazUserType.setForeground(new Color(214, 64, 69));
        JPanel dataTimePanel = new JPanel();
        dataTimePanel.setLayout(new  BorderLayout());
        dataTimePanel.setBackground(new Color(132, 220, 198));
        Date time = new java.util.Date(System.currentTimeMillis());
        JLabel sharazTimeLabel = new JLabel(new SimpleDateFormat("hh:mm:ss a").format(time));
        sharazTimeLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOCK_O, 25, new Color(46, 134, 171)));
        JLabel sharazDateLabel = new JLabel(new Date().toString().substring(0, 10));
        sharazDateLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 20, new Color(46, 134, 171)));
        sharazDateLabel.setFont(new Font("Comic Sans", Font.ITALIC, 14));
        sharazTimeLabel.setFont(new Font("Comic Sans", Font.ITALIC, 14));
        dataTimePanel.add(sharazTimeLabel, BorderLayout.NORTH);
        dataTimePanel.add(sharazDateLabel, BorderLayout.SOUTH);
        
        rightNavBarPanel.add(sharazTitle, BorderLayout.CENTER);
        rightNavBarPanel.add(sharazUserType, BorderLayout.SOUTH);
        rightNavBarPanel.add(dataTimePanel, BorderLayout.EAST);
        
        
        navbarPanel.add(leftNavbarPanel, BorderLayout.WEST);
        navbarPanel.add(rightNavBarPanel, BorderLayout.CENTER);
        
        // sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        
        JPanel sidebarItemsPanel = new JPanel();
        JPanel sidebarItemsButtonsPanel = new JPanel();
        sidebarItemsButtonsPanel.setBackground(new Color(46, 134, 171));
        sidebarItemsButtonsPanel.setLayout(new GridLayout(6, 1, 5, 5));
        sidebarItemsButtonsPanel.setPreferredSize(new Dimension(200, 250));
        JPanel logoutButtonPanel = new JPanel();
        logoutButtonPanel.setLayout(new BorderLayout());
        sidebarItemsPanel.setBackground(new Color(46, 134, 171));
        logoutButtonPanel.setPreferredSize(new Dimension(0, 40));
        logoutButtonPanel.setBackground(new Color(46, 134, 171));
        // sidebar items
        JButton dashboardButton = new JButton("DashBoard");
        dashboardButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DASHBOARD, 25, new Color(132, 220, 198)));
        dashboardButton.setIconTextGap(15);
        dashboardButton.setBackground(new Color(46, 134, 171));
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        dashboardButton.setFocusable(false);
        // manage sales
        JButton manageSalesButton = new JButton("Manage Sales");
        manageSalesButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 25, new Color(132, 220, 198)));
        manageSalesButton.setIconTextGap(5);
        manageSalesButton.setBackground(new Color(46, 134, 171));
        manageSalesButton.setForeground(Color.WHITE);
        manageSalesButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        manageSalesButton.setFocusable(false);
        // Add meals
        JButton AddMealButton = new JButton("Add Meal");
        AddMealButton.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS, 25, new Color(132, 220, 198)));
        AddMealButton.setIconTextGap(30);
        AddMealButton.setBackground(new Color(46, 134, 171));
        AddMealButton.setForeground(Color.WHITE);
        AddMealButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        AddMealButton.setFocusable(false);
        // manage meals
        JButton manageMealsButton = new JButton("Manage Meals");
        manageMealsButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 25, new Color(132, 220, 198)));
        manageMealsButton.setBackground(new Color(46, 134, 171));
        manageMealsButton.setForeground(Color.WHITE);
        manageMealsButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        manageMealsButton.setFocusable(false);
        // Add cashier
        JButton AddCashierButton = new JButton("Add Cashier");
        AddCashierButton.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_PLUS, 25, new Color(132, 220, 198)));
        AddCashierButton.setIconTextGap(24);
        AddCashierButton.setBackground(new Color(46, 134, 171));
        AddCashierButton.setForeground(Color.WHITE);
        AddCashierButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        AddCashierButton.setFocusable(false);
        // manage cashier
        JButton manageCashierButton = new JButton("Manage Cashiers");
        manageCashierButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 25,  new Color(46, 134, 171)));
        manageCashierButton.setBackground(new Color(132, 220, 198));
        manageCashierButton.setForeground(Color.WHITE);
        manageCashierButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        manageCashierButton.setFocusable(false);
        
        sidebarItemsButtonsPanel.add(dashboardButton);
        sidebarItemsButtonsPanel.add(manageSalesButton);
        sidebarItemsButtonsPanel.add(AddMealButton);
        sidebarItemsButtonsPanel.add(manageMealsButton);
        sidebarItemsButtonsPanel.add(AddCashierButton);
        sidebarItemsButtonsPanel.add(manageCashierButton);
        sidebarItemsPanel.add(sidebarItemsButtonsPanel);
        
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBackground(new Color(214, 64, 69));
        logoutButton.setFocusable(false);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EXIT_TO_APP, 25, Color.WHITE));
        logoutButton.setIconTextGap(-80);
        logoutButtonPanel.add(logoutButton);
        
        sidebarPanel.add(sidebarItemsPanel, BorderLayout.CENTER);
        sidebarPanel.add(logoutButtonPanel, BorderLayout.SOUTH);
        
    
        //content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));

        // panels
        // action panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(1, 3));
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel cashierIdLabel = new JLabel("Cashier Id");
        JTextField cashierIdInput = new JTextField();
        cashierIdInput.setEditable(false);
        
        JLabel cashierFirstNameLabel = new JLabel("First Name");
        JTextField cashierFirstNameInput = new JTextField();
        
        JLabel cashierLastNameLabel = new JLabel("Last Name");
        JTextField cashierLastNameInput = new JTextField();
        
        JLabel cashierPhoneNumberLabel = new JLabel("Phone Number");
        JTextField cashierPhoneNumberInput = new JTextField();
        
        JLabel cashieDateJoinedLabel = new JLabel("Date Joined");
        JTextField cashierDateJoinedInput = new JTextField();
        
        formPanel.add(cashierIdLabel);
        formPanel.add(cashierIdInput);
        formPanel.add(cashierFirstNameLabel);
        formPanel.add(cashierFirstNameInput); 
        formPanel.add(cashierLastNameLabel);
        formPanel.add(cashierLastNameInput);
        formPanel.add(cashierPhoneNumberLabel);
        formPanel.add(cashierPhoneNumberInput);
        formPanel.add(cashieDateJoinedLabel);
        formPanel.add(cashierDateJoinedInput);
        
        JPanel addressPanel = new JPanel();
        addressPanel.setBorder(new  EmptyBorder(15, 10, 15, 10));
        addressPanel.setLayout(new BorderLayout());
        JPanel addressTopPanel = new JPanel();
        JLabel cashierAddressLabel = new JLabel("Cashier Address:");
        addressTopPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
        addressTopPanel.setLayout(new BorderLayout());
        JTextArea addressInput = new JTextArea();
        
        addressTopPanel.add(cashierAddressLabel, BorderLayout.NORTH);
        addressTopPanel.add(addressInput, BorderLayout.CENTER);
        
        JPanel addressBottomPanel = new JPanel();
        addressBottomPanel.setLayout(new BorderLayout());
        addressBottomPanel.setPreferredSize(new Dimension(0, 60));
        JButton uploadImageButton = new JButton("Upload Image");
        JLabel imagePathLabel = new JLabel("Image Path");
        JTextField imagePath = new JTextField();
        addressBottomPanel.add(uploadImageButton, BorderLayout.NORTH);
        addressBottomPanel.add(imagePathLabel, BorderLayout.CENTER);
        addressBottomPanel.add(imagePath, BorderLayout.SOUTH);

        
        addressPanel.add(addressTopPanel, BorderLayout.CENTER);
        addressPanel.add(addressBottomPanel, BorderLayout.SOUTH);
        
        /// image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setBorder(new  EmptyBorder(10, 10, 10, 10));
        JPanel imagePanelBody = new JPanel();
        imagePanelBody.setPreferredSize(new Dimension(160, 160));
        imagePanelBody.setBackground(new Color(46, 134, 171));
        JLabel imageAvatar = new JLabel();
        
        imageAvatar.setIcon(new ImageIcon(new ImageIcon("avatar.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        imagePanelBody.add(imageAvatar);
        
        imagePanel.add(imagePanelBody);
       
        
        displayPanel.add(formPanel);
        displayPanel.add(addressPanel);
        displayPanel.add(imagePanel);
        
        JPanel actionButtonsPanel = new JPanel();
        actionButtonsPanel.setPreferredSize(new Dimension(0, 40));
        actionButtonsPanel.setBackground(new Color(132, 220, 198));
        
        JButton updateButton = new JButton("Update");
        updateButton.setFocusable(false);
        updateButton.setBackground(new Color(233, 180, 76));
        updateButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EDIT, 18, Color.BLACK));
        JButton DeleteButton = new JButton("Delete");
        DeleteButton.setFocusable(false);
        DeleteButton.setBackground(new Color(214, 64, 69));
        DeleteButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DELETE, 18, Color.BLACK));
        JButton clearButton = new JButton("Clear");
        clearButton.setFocusable(false);
        clearButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLEAR, 18, Color.BLACK));
        clearButton.setBackground(new Color(128, 255, 114));
        
        actionButtonsPanel.add(updateButton);
        actionButtonsPanel.add(DeleteButton);
        actionButtonsPanel.add(clearButton);
        
        actionPanel.add(displayPanel, BorderLayout.CENTER);
        actionPanel.add(actionButtonsPanel, BorderLayout.SOUTH);
        
        // table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        
        String[] columnNames = {
        		"S/N",
                "Cashier ID",
                "First Name",
                "Last Name",
                "Phone Number",
                "Date Joined",
                "Address",
                "Avatar"
                };
        
        int cashierRowCount = sharazDatabase.countTableRows("cashier");
        
        Object[][] data = new Object[cashierRowCount][8];
        
       
        
        try {
        	
        	 PreparedStatement getCashiersStatement;
     		 ResultSet resultSet;
             String getCashiersQuery = "SELECT * FROM cashier";
             
             getCashiersStatement = sharazDatabase.CreateConnection().prepareStatement(getCashiersQuery);
			resultSet = getCashiersStatement.executeQuery();
			
	        int i = 0;
	        while (resultSet.next() && i < cashierRowCount) {
				BufferedImage bufferedImage = null;
				ImageIcon cashierImage = null;
				try {
					 bufferedImage = ImageIO.read(resultSet.getBinaryStream("avatar"));
					 cashierImage = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
	        	int j = i + 1;
				data[i][0] =  j;
				data[i][1] = resultSet.getString("cashier_id");
				data[i][2] = resultSet.getString("first_name");
				data[i][3] = resultSet.getString("last_name");
				data[i][4] = resultSet.getString("phone_number");
				data[i][5] = resultSet.getString("date_joined");
				data[i][6] = resultSet.getString("address");
				data[i][7] = cashierImage;
				i++;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
		 DefaultTableModel model = new DefaultTableModel(data, columnNames)
	        {
	            public Class getColumnClass(int column)
	            {
	                return getValueAt(0, column).getClass();
	            }
	       };
	       
	     JTable table = new JTable(model);
	     table.setRowHeight(100);
        
        table.removeColumn(table.getColumnModel().getColumn(6));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Manage Cashiers",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        scrollPane.setSize(300, 300);
        table.setFillsViewportHeight(true);

        tablePanel.add(scrollPane);

        contentPanel.add(actionPanel);
        contentPanel.add(tablePanel);

        
        
        // LOGIC
        table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				currentSelectedCashier = table.getValueAt(table.getSelectedRow(), 1).toString();
				cashierIdInput.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				cashierFirstNameInput.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				cashierLastNameInput.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				cashierPhoneNumberInput.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				cashierDateJoinedInput.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				addressInput.setText(table.getModel().getValueAt(table.getSelectedRow(), 6).toString());
				
				// get Selected image
				  try {
			        	
			        	 PreparedStatement getCashiersStatement;
			     		 ResultSet resultSet;
			             String getCashiersQuery = "SELECT * FROM cashier WHERE cashier_id = ?";
			             
			             getCashiersStatement = sharazDatabase.CreateConnection().prepareStatement(getCashiersQuery);
			             getCashiersStatement.setString(1, currentSelectedCashier);
						resultSet = getCashiersStatement.executeQuery();
						
				        while (resultSet.next()) {
							BufferedImage bufferedImage = null;
							ImageIcon cashierImage = null;
							try {
								 bufferedImage = ImageIO.read(resultSet.getBinaryStream("avatar"));
								 cashierImage = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
								 imageAvatar.setIcon(cashierImage);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
				        }
				        
				  }catch (Exception e1){
					  e1.printStackTrace();
				  }
				        
				
			}
		});
        
        // image select
        uploadImageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter fileNameExtensionFilter;
				
				 if (currentSelectedCashier != null) {
					chooser = new JFileChooser();
					File file = new java.io.File("C:\\Users\\Adamu Fura Suleiman\\Pictures");
					chooser.setCurrentDirectory(file);
					fileNameExtensionFilter = new FileNameExtensionFilter("only jpg and png are allowed", "jpg", "png");
					chooser.addChoosableFileFilter(fileNameExtensionFilter);
					
					chooser.showOpenDialog(frame);
					
					imagePath.setText(chooser.getSelectedFile().toString());
									
				 }
			}
		});
        
        // Update action
        updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// check if a row is selected
				 if (currentSelectedCashier != null) {
					 int updateResponse = JOptionPane.showConfirmDialog(contentPanel, "Are you sure you want to update this cashier?");
					 
						File imageFile = null;
					    FileInputStream fileInputStream = null;
						
						imageFile = new File(chooser.getSelectedFile().toString());						

					    
						try {
							fileInputStream = new FileInputStream(imageFile);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					 
					 // confirm box
					 if (updateResponse == 0) {
						 PreparedStatement UpdateCashiersStatement;
			             String DeleteCashierQuery = "UPDATE cashier SET first_name = ?, last_name = ?, phone_number = ?,"
			             		+ "address = ?, date_joined = ?, avatar = ? WHERE cashier_id = ?";
			             
			             
			             
			             try {
			            	 UpdateCashiersStatement = sharazDatabase.CreateConnection().prepareStatement(DeleteCashierQuery);
			            	 UpdateCashiersStatement.setString(1, cashierFirstNameInput.getText());
			            	 UpdateCashiersStatement.setString(2, cashierLastNameInput.getText());
			            	 UpdateCashiersStatement.setString(3, cashierPhoneNumberInput.getText());
			            	 UpdateCashiersStatement.setString(4, addressInput.getText());
			            	 UpdateCashiersStatement.setString(5, cashierDateJoinedInput.getText());
			            	 UpdateCashiersStatement.setBinaryStream(6, (InputStream)fileInputStream, (int)imageFile.length());
			            	 UpdateCashiersStatement.setString(7, currentSelectedCashier);
			            	 
			            	 
				             int response = UpdateCashiersStatement.executeUpdate();
				             
				             if (response == 1) {
								JOptionPane.showMessageDialog(contentPanel, "Cashier Has been updated");
								currentSelectedCashier = null;
								model.fireTableDataChanged();
								table.repaint();
								frame.dispose();
								new ManageCashierWindow();
							}
				             
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}else {
					// show dialogue box
					JOptionPane.showMessageDialog(contentPanel, "No Cashier Is Selected");
				}
			}
			
		});
         
        // Delete action
        DeleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// check if a row is selected
				 if (currentSelectedCashier != null) {
					 int deleteResponse = JOptionPane.showConfirmDialog(contentPanel, "Are you sure you want to delete this cashier?");
					 
					 // confirm box
					 if (deleteResponse == 0) {
						 PreparedStatement DeleteCashiersStatement;
			             String DeleteCashierQuery = "DELETE FROM cashier WHERE cashier_id = ?";
			             
			             try {
			            	 DeleteCashiersStatement = sharazDatabase.CreateConnection().prepareStatement(DeleteCashierQuery);
			            	 DeleteCashiersStatement.setString(1, currentSelectedCashier);
				             int response = DeleteCashiersStatement.executeUpdate();
				             
				             if (response == 1) {
								JOptionPane.showMessageDialog(contentPanel, "Cashier Has been deleted");
								currentSelectedCashier = null;
								frame.dispose();
								new ManageCashierWindow();
							}
				             
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}else {
					// show dialogue box
					JOptionPane.showMessageDialog(contentPanel, "No Cashier Is Selected");
				}
			}
		});
        
        // Clear action
        clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentSelectedCashier = null;
				cashierIdInput.setText("");
				cashierFirstNameInput.setText("");
				cashierLastNameInput.setText("");
				cashierPhoneNumberInput.setText("");
				cashierDateJoinedInput.setText("");
				addressInput.setText("");
			}
		});
        
        // sidebar logic
        // dashboard button
        dashboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new DashboardWindow();
			}
		});
        // manage sales button
        manageSalesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ManageSalesWindow();
				
			}
		});
        // add meal button
        AddMealButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AddMealWindow();
			}
		});
        // manage meals button
        manageMealsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ManageMealsWindow();
			}
		});
        // add cashier button
        AddCashierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AddCashierWindow();
			}
		});
        // manage cashiers button
        manageCashierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// it is the current screen
			}
		});
        
        //logout logic
        logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int logoutOption = JOptionPane.showConfirmDialog(frame, "Do you want to Log Out?", "Log Out", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				System.out.println(logoutOption);
				if (logoutOption == 0) {
					frame.dispose();
					new StartWindow();
				}
			}
		});
                
        // window configuration
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sharaz Management System [ADMIN]");
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());
        frame.add(navbarPanel, BorderLayout.NORTH);
        frame.add(sidebarPanel, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	

}
