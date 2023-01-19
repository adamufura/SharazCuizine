package cashier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.ImageAvatar;
import sharaz.SharazDatabase;
import sharaz.StartWindow;

public class CashierSalesWindow {

	private String loggedInCashierId;

	public CashierSalesWindow(String cashierId) {
		this.loggedInCashierId = cashierId;

		SharazDatabase sharazDatabase = new SharazDatabase();
		BufferedImage bufferedImage = (BufferedImage) sharazDatabase.getCashier(loggedInCashierId)[2];
		int ItemsInCart = 0;
		ItemsInCart = sharazDatabase.countTableRowsWithQuery("SELECT COUNT(1) FROM cart WHERE cashier_id = ?", loggedInCashierId);
		
		JFrame frame = new JFrame();
		
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
    	IconFontSwing.register(FontAwesome.getIconFont());
    	
        ImageIcon icon = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        ImageIcon adminIcon = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
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
        adminaAvatarLabel.setText("Welcome " + sharazDatabase.getCashier(loggedInCashierId)[0].toString());
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
        JLabel cartLabel = new JLabel("CART: (" + ItemsInCart + ")");
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
        PaymentAndCartButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CART_PLUS, 25, new Color(132, 220, 198)));
        PaymentAndCartButton.setIconTextGap(30);
        PaymentAndCartButton.setBackground(new Color(46, 134, 171));
        PaymentAndCartButton.setForeground(Color.WHITE);
        PaymentAndCartButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        PaymentAndCartButton.setFocusable(false);
        // my sales
        JButton mySalesButton = new JButton("My Sales");
        mySalesButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 25, new Color(46, 134, 171)));
        mySalesButton.setIconTextGap(15);
        mySalesButton.setBackground(new Color(132, 220, 198));
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
        
        /// Manage sales content

        //content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // sales
        JPanel SalesPanel = new JPanel();
        SalesPanel.setBorder(new EmptyBorder(30, 10, 30, 10));
        SalesPanel.setLayout(new BorderLayout());

        String[] columnNames = {
        		"S/N",
                "Meal ID",
                "Meal Title",
                "Amount",
                "Quantity",
                "Date/Time"
                };

        
       int cashierSalesRows = sharazDatabase.countTableRowsWithQuery("SELECT COUNT(1) FROM sales WHERE cashier_id = ?", loggedInCashierId);
        Object[][] data = new Object[cashierSalesRows][6];
                
        try {
        	
        	 PreparedStatement getSalesStatement;
     		 ResultSet resultSet;
             String getMealsQuery = "SELECT * FROM sales WHERE cashier_id = ?";
             
             getSalesStatement = sharazDatabase.CreateConnection().prepareStatement(getMealsQuery);
             getSalesStatement.setString(1, loggedInCashierId);
             resultSet = getSalesStatement.executeQuery();
             
             
	        int i = 0;
	        while (resultSet.next()) {
	        	int j = i + 1;
	        	        	
				data[i][0] =  j;
				data[i][1] = resultSet.getString("meal_id");
				data[i][2] = sharazDatabase.getMealTitle(resultSet.getString("meal_id"));
				data[i][3] = resultSet.getString("quantity");
				data[i][4] = resultSet.getString("amount");
				data[i][5] = resultSet.getString("date_time");
				i++;
			}
	        
	        resultSet.close();
	        getSalesStatement.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "My Sales",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        scrollPane.setSize(300, 300);
        table.setFillsViewportHeight(true);

        SalesPanel.add(scrollPane);

        contentPanel.add(SalesPanel, BorderLayout.CENTER);

          // end of manage sales content
        // sidebar logic
        // dashboard button
        dashboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CashierDashBoardWindow(loggedInCashierId);
			}
		});
        // payment and cart button
        PaymentAndCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PaymentWindow(loggedInCashierId);
			}
		});
        // my sales button
        mySalesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// it is the current screen
			}
		});
        // sharaz meals button
        SharazMealsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SharazMealsWindow(loggedInCashierId);
			}
		});
        // change password button
        ChangePasswordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ChangePasswordWindow(loggedInCashierId);
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

