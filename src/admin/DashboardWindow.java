package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.SharazDatabase;
import sharaz.StartWindow;

public class DashboardWindow {
    JFrame frame = new JFrame();        
    
    

    public DashboardWindow() {
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
        sharazTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
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
        dashboardButton.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.DASHBOARD, 25, new Color(46, 134, 171)));
        dashboardButton.setIconTextGap(15);
        dashboardButton.setBackground(new Color(132, 220, 198));
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
        JPanel cardsPanel = new JPanel();
        cardsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        cardsPanel.setLayout(new GridLayout(1, 3, 10, 10));
        cardsPanel.setPreferredSize(new Dimension(0, 150));
        
        // cards
        
        // sales
        JPanel salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());
        salesPanel.setBackground(new Color(128, 255, 114));
        JLabel salesLabelIcon = new JLabel();
        salesLabelIcon.setIcon(IconFontSwing.buildIcon(FontAwesome.LINE_CHART, 60, new Color(46, 134, 171)));
        salesLabelIcon.setText("N" + String.valueOf(sharazDatabase.getTotalSales()));
        salesLabelIcon.setFont(new Font("Times New Roman", Font.BOLD, 20));
        salesLabelIcon.setHorizontalAlignment(JLabel.CENTER);
        salesLabelIcon.setVerticalAlignment(JLabel.CENTER);
        JLabel salesPanelTitle = new JLabel("SALES");
        salesPanelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        salesPanelTitle.setForeground(new Color(46, 134, 171));
        salesPanelTitle.setHorizontalAlignment(JLabel.CENTER);
        salesPanelTitle.setVerticalAlignment(JLabel.CENTER);
        salesPanel.add(salesLabelIcon, BorderLayout.CENTER);
        salesPanel.add(salesPanelTitle, BorderLayout.SOUTH);
        
        
        // cashier
        JPanel cashierPanel = new JPanel();
        cashierPanel.setLayout(new BorderLayout());
        cashierPanel.setBackground(new Color(214, 64, 69));
        JLabel cashierLabelIcon = new JLabel();
        cashierLabelIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(46, 134, 171)));
        cashierLabelIcon.setText(String.valueOf(sharazDatabase.countTableRows("cashier")));
        cashierLabelIcon.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cashierLabelIcon.setHorizontalAlignment(JLabel.CENTER);
        cashierLabelIcon.setVerticalAlignment(JLabel.CENTER);
        JLabel cashierPanelTitle = new JLabel("CASHIERS");
        cashierPanelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        cashierPanelTitle.setForeground(new Color(46, 134, 171));
        cashierPanelTitle.setHorizontalAlignment(JLabel.CENTER);
        cashierPanelTitle.setVerticalAlignment(JLabel.CENTER);
        cashierPanel.add(cashierLabelIcon, BorderLayout.CENTER);
        cashierPanel.add(cashierPanelTitle, BorderLayout.SOUTH);
        
        // meals
        JPanel mealsPanel = new JPanel();
        mealsPanel.setLayout(new BorderLayout());
        mealsPanel.setBackground(new Color(233, 180, 76));
        JLabel mealsLabelIcon = new JLabel();
        mealsLabelIcon.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 60, new Color(46, 134, 171)));
        mealsLabelIcon.setText(String.valueOf(sharazDatabase.countTableRows("meals")));
        mealsLabelIcon.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mealsLabelIcon.setHorizontalAlignment(JLabel.CENTER);
        mealsLabelIcon.setVerticalAlignment(JLabel.CENTER);
        JLabel mealsPanelTitle = new JLabel("MEALS");
        mealsPanelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        mealsPanelTitle.setForeground(new Color(46, 134, 171));
        mealsPanelTitle.setHorizontalAlignment(JLabel.CENTER);
        mealsPanelTitle.setVerticalAlignment(JLabel.CENTER);
        mealsPanel.add(mealsLabelIcon, BorderLayout.CENTER);
        mealsPanel.add(mealsPanelTitle, BorderLayout.SOUTH);
        
        
        JButton showCCTV = new JButton("Open CCTV Camera");

        
        cardsPanel.add(salesPanel);
        cardsPanel.add(cashierPanel);
        cardsPanel.add(mealsPanel);
        cardsPanel.add(showCCTV);
        
        // todays sales
        JPanel todaysSalesPanel = new JPanel();
        todaysSalesPanel.setBorder(new EmptyBorder(30, 10, 30, 10));
        todaysSalesPanel.setLayout(new BorderLayout());
        
        String[] columnNames = {
          		"S/N",
                  "Meal ID",
                  "Meal Title",
                  "Amount",
                  "Quantity",
                  "Date/Time"
                  };

          
          int SalesRows = sharazDatabase.countTableRows("sales");
           Object[][] data = new Object[SalesRows][6];
                   
           try {
		        java.util.Date date=new java.util.Date();
				java.sql.Date sqlOrderDate =new java.sql.Date(date.getTime());
				
           	 PreparedStatement getSalesStatement;
        	 ResultSet resultSet;
             String getMealsQuery = "SELECT * FROM sales WHERE date_time = ?";
                
                getSalesStatement = sharazDatabase.CreateConnection().prepareStatement(getMealsQuery);
                getSalesStatement.setDate(1, sqlOrderDate);
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
                "Today's Sales",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        scrollPane.setSize(300, 300);
        table.setFillsViewportHeight(true);
     
        todaysSalesPanel.add(scrollPane);
        
        contentPanel.add(cardsPanel, BorderLayout.NORTH);

        contentPanel.add(todaysSalesPanel, BorderLayout.CENTER);
        
        // LOGIC
                
        showCCTV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Webcam webcam = Webcam.getDefault();
				webcam.setViewSize(WebcamResolution.VGA.getSize());
				
				WebcamPanel webcamPanel = new WebcamPanel(webcam);
				webcamPanel.setFPSDisplayed(true);
				webcamPanel.setDisplayDebugInfo(true);
				webcamPanel.setImageSizeDisplayed(true);
				webcamPanel.setMirrored(true);
				
				JFrame window = new JFrame();
				
				
				window.add(webcamPanel);
				window.setResizable(true);
				window.pack();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
				
			    window.addWindowListener(new java.awt.event.WindowAdapter() {
		            @Override
		            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		                if (JOptionPane.showConfirmDialog(frame, 
		                    "Are you sure you want to close CCTV Camera?", "Close Window?", 
		                    JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		                	webcam.close();
		                    window.dispose();
		                }
		            }
		        });
			}
			
			
		});
        
    


        
        // sidebar logic
        // dashboard button
        dashboardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// it is the current screen
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
