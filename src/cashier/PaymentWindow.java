package cashier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.ImageAvatar;
import sharaz.StartWindow;

public class PaymentWindow {
	public PaymentWindow() {
		JFrame frame = new JFrame();
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
    	IconFontSwing.register(FontAwesome.getIconFont());
    	
        ImageIcon icon = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        ImageIcon adminIcon = new ImageIcon(new ImageIcon("avatar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
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
        JPanel adminAvatarPanel = new JPanel();
        adminAvatarPanel.setBackground(new Color(46, 134, 171));
        adminAvatarPanel.setLayout(new BorderLayout());
        JLabel adminaAvatarLabel = new JLabel();
        ImageAvatar imageAvatar = new ImageAvatar();
        imageAvatar.setImage(adminIcon);
        imageAvatar.setBorderColor(new Color(132, 220, 198));
        adminaAvatarLabel.setText("Welcome Zaks");
        adminaAvatarLabel.setForeground(Color.WHITE);
        adminaAvatarLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		adminaAvatarLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel navbarTopPanel = new JPanel();
		navbarTopPanel.setBackground(new Color(46, 134, 171));
		JPanel navbarTopLeftPanel = new JPanel();
		navbarTopLeftPanel.setPreferredSize(new Dimension(66, 0));
		navbarTopLeftPanel.setBackground(new Color(46, 134, 171));
		JPanel navbarTopRightPanel = new JPanel();
		navbarTopRightPanel.setBackground(new Color(46, 134, 171));
		
		adminAvatarPanel.add(navbarTopPanel, BorderLayout.NORTH);
		adminAvatarPanel.add(navbarTopLeftPanel, BorderLayout.WEST);
		adminAvatarPanel.add(imageAvatar, BorderLayout.CENTER);
		adminAvatarPanel.add(navbarTopRightPanel, BorderLayout.EAST);
		adminAvatarPanel.add(adminaAvatarLabel, BorderLayout.SOUTH);
		
        leftNavbarPanel.add(adminAvatarPanel, BorderLayout.CENTER);
        leftNavbarPanel.add(leftNavbarSeparator, BorderLayout.SOUTH);
        
        
        JPanel rightNavBarPanel = new JPanel();
        rightNavBarPanel.setLayout(new BorderLayout());
        rightNavBarPanel.setBackground(new Color(132, 220, 198));
        
        JLabel sharazTitle = new JLabel("Sharaz Cuizine Management System");
        sharazTitle.setIcon(icon);
        sharazTitle.setIconTextGap(10);
        sharazTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sharazTitle.setForeground(Color.WHITE);
        JLabel sharazUserType = new JLabel("[CASHIER]");
        sharazUserType.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sharazUserType.setForeground(new Color(214, 64, 69));
        
        JPanel bottomRightNavbar = new JPanel();
        bottomRightNavbar.setBorder(new EmptyBorder(0, 0, 0, 10));
        bottomRightNavbar.setLayout(new BorderLayout());
        bottomRightNavbar.setBackground(new Color(132, 220, 198));
        JLabel cartLabel = new JLabel("CART: (0)");
        cartLabel.setFont(new Font("Comic Sans", Font.ITALIC, 18));
        cartLabel.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_CART, 25, new Color(46, 134, 171)));
        
        JPanel dataTimePanel = new JPanel();
        dataTimePanel.setBorder(new EmptyBorder(0, 10, 20, 10));
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
        
        bottomRightNavbar.add(sharazUserType, BorderLayout.WEST);
        bottomRightNavbar.add(cartLabel, BorderLayout.EAST);
        
        rightNavBarPanel.add(sharazTitle, BorderLayout.CENTER);
        rightNavBarPanel.add(bottomRightNavbar, BorderLayout.SOUTH);
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
        // Payment and Cart
        JButton PaymentAndCartButton = new JButton("Payment");
        PaymentAndCartButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CART_PLUS, 25, new Color(46, 134, 171)));
        PaymentAndCartButton.setIconTextGap(30);
        PaymentAndCartButton.setBackground(new Color(132, 220, 198));
        PaymentAndCartButton.setForeground(Color.WHITE);
        PaymentAndCartButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        PaymentAndCartButton.setFocusable(false);
        // my sales
        JButton mySalesButton = new JButton("My Sales");
        mySalesButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 25, new Color(132, 220, 198)));
        mySalesButton.setIconTextGap(15);
        mySalesButton.setBackground(new Color(46, 134, 171));
        mySalesButton.setForeground(Color.WHITE);
        mySalesButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mySalesButton.setFocusable(false);
        // sharaz meals
        JButton SharazMealsButton = new JButton("Sharaz Meals");
        SharazMealsButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 25, new Color(132, 220, 198)));
        SharazMealsButton.setIconTextGap(30);
        SharazMealsButton.setBackground(new Color(46, 134, 171));
        SharazMealsButton.setForeground(Color.WHITE);
        SharazMealsButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        SharazMealsButton.setFocusable(false);
        // change password
        JButton ChangePasswordButton = new JButton("Change Password");
        ChangePasswordButton.setIcon(IconFontSwing.buildIcon(FontAwesome.LOCK, 25, new Color(132, 220, 198)));
        ChangePasswordButton.setBackground(new Color(46, 134, 171));
        ChangePasswordButton.setForeground(Color.WHITE);
        ChangePasswordButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        ChangePasswordButton.setFocusable(false);
        
        sidebarItemsButtonsPanel.add(dashboardButton);
        sidebarItemsButtonsPanel.add(PaymentAndCartButton);
        sidebarItemsButtonsPanel.add(mySalesButton);
        sidebarItemsButtonsPanel.add(SharazMealsButton);
        sidebarItemsButtonsPanel.add(ChangePasswordButton);
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
        contentPanel.setLayout(new GridLayout(1, 2));
        
        // payment content
        
        // cart container
        JPanel cartPanel = new JPanel();
        cartPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        cartPanel.setLayout(new BorderLayout());
        
        JPanel cartTablePanel = new JPanel();
        cartTablePanel.setLayout(new BorderLayout());
        
        String columnNames[] = {"Product", "Quantity", "Sub-Total"};
        Object[][] data = {
        		{"Chips", "X2", "N1400"},
        		{"Lacaser Drink", "X2", "N1400"},
        		{"White rice", "X2", "N1400"}
        };
        JTable cartTable = new JTable(data, columnNames);
        cartTable.setShowGrid(false);
        
        JScrollPane scrollPane = new JScrollPane(cartTable);
        
        JPanel totalAmountPanel = new JPanel();
        totalAmountPanel.setPreferredSize(new Dimension(0, 30));
        totalAmountPanel.setBackground(new Color(46, 134, 171));
        
        JLabel totalAmountCartLabel = new JLabel("TOTAL = ");
        totalAmountCartLabel.setForeground(Color.WHITE);
        JLabel totalAmountCartValue = new JLabel("N4200");
        totalAmountCartValue.setForeground(Color.WHITE);
        
        totalAmountPanel.add(totalAmountCartLabel);
        totalAmountPanel.add(totalAmountCartValue);
        
        JPanel cartButtonsPanel = new JPanel();
        JButton makePaymentButton = new JButton("Make Payment");
        makePaymentButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CREDIT_CARD, 20, Color.BLACK));
        makePaymentButton.setForeground(Color.BLACK);
        makePaymentButton.setFocusable(false);
        makePaymentButton.setBackground(new Color(128, 255, 114));
        
        JButton clearCartButton = new JButton("Clear Cart");
        clearCartButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CANCEL, 20, Color.WHITE));
        clearCartButton.setBackground(new Color(214, 64, 69));
        clearCartButton.setForeground(Color.WHITE);
        clearCartButton.setFocusable(false);
        cartButtonsPanel.add(clearCartButton);
        cartButtonsPanel.add(makePaymentButton);
        
        cartTablePanel.add(scrollPane, BorderLayout.CENTER);
        cartTablePanel.add(totalAmountPanel, BorderLayout.SOUTH);
        
        cartPanel.add(cartTablePanel, BorderLayout.CENTER);
        cartPanel.add(cartButtonsPanel, BorderLayout.SOUTH);
        
        // form container
        JPanel formContentPanel = new JPanel();
        formContentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formContentPanel.setLayout(new BorderLayout());
        
        JPanel topContentPanel = new JPanel();
        topContentPanel.setBackground(new Color(46, 134, 171));
        topContentPanel.setPreferredSize(new Dimension(0, 40));
        
        // page content
        JLabel dashboardContentTitle = new JLabel("Make Payment");
        dashboardContentTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dashboardContentTitle.setForeground(Color.WHITE);
        dashboardContentTitle.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PAYMENT, 25, Color.WHITE));  
        topContentPanel.add(dashboardContentTitle);
        
        // form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(46, 134, 171)));
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // row 1
        JLabel availableMealsLabel = new JLabel("Available Meals");

        String meals[] = {"Chips", "Fried Rice", "White Rice", "Chicken Pepper"};
        
        JComboBox<String> availableMealsOption = new JComboBox<String>(meals);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 3;
        JPanel mealsFormPanel = new JPanel();
        mealsFormPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mealsFormPanel.setLayout(new BoxLayout(mealsFormPanel, BoxLayout.Y_AXIS));
        mealsFormPanel.add(availableMealsLabel);
        mealsFormPanel.add(availableMealsOption);
        
        formPanel.add(mealsFormPanel, gridBagConstraints);
        
        // row 2
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        
        JLabel totalAmountLabel = new JLabel("Total Amount");
        JTextField totalAmountInput = new JTextField();
        JPanel totalItemAmountPanel = new JPanel();
        totalItemAmountPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        totalItemAmountPanel.setLayout(new BoxLayout(totalItemAmountPanel, BoxLayout.Y_AXIS));
        totalItemAmountPanel.add(totalAmountLabel);
        totalItemAmountPanel.add(totalAmountInput);
        formPanel.add(totalItemAmountPanel, gridBagConstraints);
        
        // row 3
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setHorizontalAlignment(JLabel.CENTER);
        JButton addButton = new JButton();
        addButton.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS_SQUARE, 20, Color.BLACK));
        JTextField quantityInput = new JTextField(5);
        JButton minusButton = new JButton();
        minusButton.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS_SQUARE, 20, Color.BLACK));
        JPanel quanityPanel = new JPanel();
        JPanel quantityBoxPanel = new JPanel();
        quantityBoxPanel.add(minusButton);
        quantityBoxPanel.add(quantityInput);
        quantityBoxPanel.add(addButton);
        quanityPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        quanityPanel.setLayout(new GridLayout(2, 1));
        quanityPanel.add(quantityLabel);
        quanityPanel.add(quantityBoxPanel);
        formPanel.add(quanityPanel, gridBagConstraints);
        
        // row 4
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        JPanel bottomButtons = new JPanel();
        bottomButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomButtons.setLayout(new BorderLayout());
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CART_PLUS, 20, Color.BLACK));
        addToCartButton.setBackground(new Color(128, 255, 114));
        
        JButton clearButton = new JButton("Clear Order");
        clearButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CANCEL, 20, Color.BLACK));
        clearButton.setBackground(new Color(233, 180, 76));
        bottomButtons.add(clearButton, BorderLayout.WEST);
        bottomButtons.add(addToCartButton, BorderLayout.EAST);
        
        formPanel.add(bottomButtons, gridBagConstraints);
        
        formContentPanel.add(topContentPanel, BorderLayout.NORTH);
        formContentPanel.add(formPanel, BorderLayout.CENTER);
        
        contentPanel.add(formContentPanel);
        contentPanel.add(cartPanel);
        // end of page content
        
        // LOGIC
        
        // sidebar logic
        // dashboard button
        dashboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CashierDashBoardWindow();
			}
		});
        // payment and cart button
        PaymentAndCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// it is the current screen
			}
		});
        // my sales button
        mySalesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CashierSalesWindow();
			}
		});
        // sharaz meals button
        SharazMealsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SharazMealsWindow();
			}
		});
        // change password button
        ChangePasswordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ChangePasswordWindow();
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
        frame.setTitle("Sharaz Management System [CASHIER]");
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
