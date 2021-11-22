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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.ImageAvatar;
import sharaz.StartWindow;

public class CashierDashBoardWindow {
	public CashierDashBoardWindow() {
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
        dashboardButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DASHBOARD, 25, new Color(46, 134, 171)));
        dashboardButton.setIconTextGap(15);
        dashboardButton.setBackground(new Color(132, 220, 198));
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        dashboardButton.setFocusable(false);
        // Payment and Cart
        JButton PaymentAndCartButton = new JButton("Payment");
        PaymentAndCartButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CART_PLUS, 25, new Color(132, 220, 198)));
        PaymentAndCartButton.setIconTextGap(30);
        PaymentAndCartButton.setBackground(new Color(46, 134, 171));
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
        contentPanel.setLayout(new BorderLayout());
        JPanel cardsPanel = new JPanel();
        cardsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        cardsPanel.setLayout(new GridLayout(1, 2, 10, 10));
        cardsPanel.setPreferredSize(new Dimension(0, 150));
        
        // cards
        
        // sales
        JPanel salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());
        salesPanel.setBackground(new Color(128, 255, 114));
        JLabel salesLabelIcon = new JLabel();
        salesLabelIcon.setIcon(IconFontSwing.buildIcon(FontAwesome.LINE_CHART, 60, new Color(46, 134, 171)));
        salesLabelIcon.setText("N12K");
        salesLabelIcon.setFont(new Font("Times New Roman", Font.BOLD, 30));
        salesLabelIcon.setHorizontalAlignment(JLabel.CENTER);
        salesLabelIcon.setVerticalAlignment(JLabel.CENTER);
        JLabel salesPanelTitle = new JLabel("MY SALES");
        salesPanelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        salesPanelTitle.setForeground(new Color(46, 134, 171));
        salesPanelTitle.setHorizontalAlignment(JLabel.CENTER);
        salesPanelTitle.setVerticalAlignment(JLabel.CENTER);
        salesPanel.add(salesLabelIcon, BorderLayout.CENTER);
        salesPanel.add(salesPanelTitle, BorderLayout.SOUTH);
        
        // meals
        JPanel mealsPanel = new JPanel();
        mealsPanel.setLayout(new BorderLayout());
        mealsPanel.setBackground(new Color(233, 180, 76));
        JLabel mealsLabelIcon = new JLabel();
        mealsLabelIcon.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 60, new Color(46, 134, 171)));
        mealsLabelIcon.setText("28");
        mealsLabelIcon.setFont(new Font("Times New Roman", Font.BOLD, 30));
        mealsLabelIcon.setHorizontalAlignment(JLabel.CENTER);
        mealsLabelIcon.setVerticalAlignment(JLabel.CENTER);
        JLabel mealsPanelTitle = new JLabel("SHARAZ MEALS");
        mealsPanelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        mealsPanelTitle.setForeground(new Color(46, 134, 171));
        mealsPanelTitle.setHorizontalAlignment(JLabel.CENTER);
        mealsPanelTitle.setVerticalAlignment(JLabel.CENTER);
        mealsPanel.add(mealsLabelIcon, BorderLayout.CENTER);
        mealsPanel.add(mealsPanelTitle, BorderLayout.SOUTH);
        
        cardsPanel.add(salesPanel);
        cardsPanel.add(mealsPanel);
        

        JPanel formContentPanel = new JPanel();
        formContentPanel.setBorder(new EmptyBorder(20, 60, 20, 60));
        formContentPanel.setLayout(new BorderLayout());
        
        JPanel topContentPanel = new JPanel();
        topContentPanel.setBackground(new Color(46, 134, 171));
        topContentPanel.setPreferredSize(new Dimension(0, 40));
        
        // page content
        JLabel dashboardContentTitle = new JLabel("Make Quick Payment");
        dashboardContentTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dashboardContentTitle.setForeground(Color.WHITE);
        dashboardContentTitle.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PAYMENT, 25, Color.WHITE));  
        topContentPanel.add(dashboardContentTitle);
        
        // form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(46, 134, 171)));
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        JLabel availableMealsLabel = new JLabel("Available Meals");

        String meals[] = {"Chips", "Fried Rice", "White Rice", "Chicken Pepper"};
        
        JComboBox<String> availableMealsOption = new JComboBox<String>(meals);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 3;
        JPanel mealsFormPanel = new JPanel();
        mealsFormPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mealsFormPanel.setLayout(new BoxLayout(mealsFormPanel, BoxLayout.Y_AXIS));
        mealsFormPanel.add(availableMealsLabel);
        mealsFormPanel.add(availableMealsOption);
        
        formPanel.add(mealsFormPanel, gridBagConstraints);
        
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JPanel centerInputs = new  JPanel();
        formPanel.add(centerInputs, gridBagConstraints);
      	
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JPanel centerInputPanel = new JPanel();
        centerInputPanel.setLayout(new BorderLayout());
        centerInputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel leftCenterPanel = new JPanel();
        leftCenterPanel.setLayout(new BoxLayout(leftCenterPanel, BoxLayout.Y_AXIS));
        JLabel totalAmountLabel = new JLabel("Total Amount");
        JTextField totalAmountInput = new JTextField(20);
        totalAmountInput.setText("N700");
        totalAmountInput.setEnabled(false);
        
        leftCenterPanel.add(totalAmountLabel);
        leftCenterPanel.add(totalAmountInput);
        JPanel rightCenterPanel = new JPanel();
        JLabel quantityLabel = new JLabel("Meal Quantity");
        JButton addBtn = new JButton();
        addBtn.setIcon(IconFontSwing.buildIcon(FontAwesome.PLUS_SQUARE, 18, Color.BLACK));
        JTextField quantityInput = new JTextField(3);
        quantityInput.setText("1");
        quantityInput.setEnabled(false);
        quantityInput.setHorizontalAlignment(JLabel.CENTER);
        quantityInput.setPreferredSize(new Dimension(0, 20));
        JButton minusBtn = new JButton();
        minusBtn.setIcon(IconFontSwing.buildIcon(FontAwesome.MINUS_SQUARE, 18, Color.BLACK));
        
        rightCenterPanel.add(quantityLabel);
        rightCenterPanel.add(minusBtn);
        rightCenterPanel.add(quantityInput);
        rightCenterPanel.add(addBtn);
        
        centerInputPanel.add(leftCenterPanel, BorderLayout.WEST);
        centerInputPanel.add(rightCenterPanel, BorderLayout.EAST);
        formPanel.add(centerInputPanel, gridBagConstraints);

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        JPanel bottomButtons = new JPanel();
        bottomButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomButtons.setLayout(new BorderLayout());
        JButton orderButton = new JButton("Make Order");
        orderButton.setBackground(new Color(128, 255, 114));
        JButton clearButton = new JButton("Clear Order");
        clearButton.setBackground(new Color(233, 180, 76));
        bottomButtons.add(clearButton, BorderLayout.WEST);
        bottomButtons.add(orderButton, BorderLayout.EAST);
        
        formPanel.add(bottomButtons, gridBagConstraints);
        
        formContentPanel.add(topContentPanel, BorderLayout.NORTH);
        formContentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.add(cardsPanel, BorderLayout.NORTH);
        contentPanel.add(formContentPanel,  BorderLayout.CENTER);
        // end of page content
        
        // LOGIC
        
        // sidebar logic
        // dashboard button
        dashboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// it is the current screen
			}
		});
        // payment and cart button
        PaymentAndCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PaymentWindow();
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
