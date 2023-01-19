package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.SharazDatabase;
import sharaz.StartWindow;

public class AddCashierWindow {
	public AddCashierWindow() {
    JFrame frame = new JFrame();        
	SharazDatabase sharazDatabase = new SharazDatabase();
	
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
        AddCashierButton.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_PLUS, 25, new Color(46, 134, 171)));
        AddCashierButton.setIconTextGap(24);
        AddCashierButton.setBackground(new Color(132, 220, 198));
        AddCashierButton.setForeground(Color.WHITE);
        AddCashierButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        AddCashierButton.setFocusable(false);
        // manage cashier
        JButton manageCashierButton = new JButton("Manage Cashiers");
        manageCashierButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 25, new Color(132, 220, 198)));
        manageCashierButton.setBackground(new Color(46, 134, 171));
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
        
     // content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());     
       
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(46, 134, 171));
        topPanel.setPreferredSize(new Dimension(0, 40));
        
        JLabel addMealTitleLabel = new JLabel("Add a Cashier");
        addMealTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        addMealTitleLabel.setForeground(Color.WHITE);
        addMealTitleLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_PLUS, 25, Color.WHITE));  
        topPanel.add(addMealTitleLabel);
        
        // form setup
         JPanel formPanelBase = new JPanel();
         formPanelBase.setLayout(new BorderLayout());
         formPanelBase.setBorder(new EmptyBorder(25, 0, 25, 0));
         JPanel formPanel = new JPanel();
         JPanel formCenter = new JPanel();
         formCenter.setBackground(new Color(132, 220, 198));
         JPanel formBottom = new JPanel();
         formBottom.setBackground( new Color(46, 134, 171));
         formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
         formPanel.setBackground(new Color(132, 220, 198));
         formPanel.setPreferredSize(new Dimension(300, 350));
         formPanel.setBorder(new EmptyBorder(50, 20, 50, 20));
         
         // ID Logic
         ResultSet resultSet;
         String currentID = "SHA/CSH/";
         int cashierIntegerId = 0;
         String lastMealID = "SELECT * FROM cashier ORDER BY cashier_id DESC LIMIT 1";
         try {
			PreparedStatement getIdStatement = sharazDatabase.CreateConnection().prepareStatement(lastMealID);
			
			resultSet = getIdStatement.executeQuery();
			
			if (resultSet.next()) {
				cashierIntegerId = (Integer.parseInt(resultSet.getString(2).substring(8))) + 1;
			}
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
         
         JLabel cashierIdLabel = new JLabel("Cashier Id");
         JTextField cashierIdInput = new JTextField(currentID + String.valueOf(cashierIntegerId));
         
         JLabel cashierFirstNameLabel = new JLabel("First Name");
         JTextField cashierFirstNameInput = new JTextField();
         
         JLabel cashierLastNameLabel = new JLabel("Last Name");
         JTextField cashierLastNameInput = new JTextField();
         
         JLabel cashierPhoneNumberLabel = new JLabel("Phone Number");
         JTextField cashierPhoneNumberInput = new JTextField();
         
         JLabel cashierAddressLabel = new JLabel("Address");
         JTextField cashierAddressInput = new JTextField();
         
         JButton AddCashierBtn = new JButton("Add Cashier");
         AddCashierBtn.setFocusable(false);
         AddCashierBtn.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_PLUS, 18, Color.BLACK));
         AddCashierBtn.setIconTextGap(-100);
       
        formPanel.add(cashierIdLabel);
        formPanel.add(cashierIdInput);
        formPanel.add(cashierFirstNameLabel);
        formPanel.add(cashierFirstNameInput); 
        formPanel.add(cashierLastNameLabel);
        formPanel.add(cashierLastNameInput);
        formPanel.add(cashierPhoneNumberLabel);
        formPanel.add(cashierPhoneNumberInput);
        formPanel.add(cashierAddressLabel);
        formPanel.add(cashierAddressInput);
        formBottom.add(AddCashierBtn);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(180,0));
        JPanel leftPanel = new JPanel();    
        leftPanel.setPreferredSize(new Dimension(180, 0));
        
        formCenter.add(formPanel);
        formPanelBase.add(formCenter, BorderLayout.CENTER);
        formPanelBase.add(formBottom, BorderLayout.SOUTH);
        
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(formPanelBase, BorderLayout.CENTER); 
        contentPanel.add(rightPanel, BorderLayout.WEST );
        contentPanel.add(leftPanel, BorderLayout.EAST);
        
        
        // LOGIC
        AddCashierBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cashier_id = cashierIdInput.getText();
				String first_name  = cashierFirstNameInput.getText();
				String last_name = cashierLastNameInput.getText();
				String phonenumber = cashierPhoneNumberInput.getText();
				String address = cashierAddressInput.getText();
				
				java.util.Date date=new java.util.Date();
				java.sql.Date sqlDateJoined =new java.sql.Date(date.getTime());
				
				// empty inputs validation
				if (cashier_id.isEmpty() || first_name.isEmpty() || last_name.isEmpty() || phonenumber.isEmpty() || address.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "Inputs cannot be empty", "Fill the Inputs!",JOptionPane.WARNING_MESSAGE, null);
					return;
				}

			    try {
					PreparedStatement preparedStatement;
					File imageFile;
				    FileInputStream fileInputStream = null;
					imageFile = new File("admin.png");
					
					try {
						fileInputStream = new FileInputStream(imageFile);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
					String addCashierQuery = "INSERT INTO cashier(cashier_id, first_name, last_name, phone_number, address, date_joined, avatar)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
					
					preparedStatement =	sharazDatabase.CreateConnection().prepareStatement(addCashierQuery);
					preparedStatement.setString(1, cashier_id);
					preparedStatement.setString(2, first_name);
					preparedStatement.setString(3, last_name);
					preparedStatement.setString(4, phonenumber);
					preparedStatement.setString(5, address);
					preparedStatement.setDate(6, sqlDateJoined);
					preparedStatement.setBinaryStream(7, (InputStream)fileInputStream, (int)imageFile.length());
					
					int response = preparedStatement.executeUpdate();
					
					if (response == 1) {
						String msg = "Cashier was successfully added";
						JOptionPane.showMessageDialog(contentPanel, msg, "Casheir Added!", JOptionPane.INFORMATION_MESSAGE, null);
						frame.dispose();
						new AddCashierWindow();
					}else {
						JOptionPane.showMessageDialog(contentPanel, "Can't add cashier try again", "Error!", JOptionPane.ERROR_MESSAGE, null);
					}
					
					// reset inputs to empty
				     cashierIdInput.setText("");
					 cashierFirstNameInput.setText("");
					cashierLastNameInput.setText("");
					 cashierPhoneNumberInput.setText("");
					cashierAddressInput.setText("");
					

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
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
				// it is the current screen
			}
		});
        // manage cashiers button
        manageCashierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ManageCashierWindow();
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
