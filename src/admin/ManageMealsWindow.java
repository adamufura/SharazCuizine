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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sharaz.SharazDatabase;
import sharaz.StartWindow;

public class ManageMealsWindow {
	static private String currentSelectedMeal = null;
	
	public ManageMealsWindow() {
		SharazDatabase sharazDatabase = new SharazDatabase();
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
        manageMealsButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CUTLERY, 25, new Color(46, 134, 171)));
        manageMealsButton.setBackground(new Color(132, 220, 198));
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
      
        
        JPanel editTablePanel = new JPanel();
        editTablePanel.setLayout(new BorderLayout());
        JPanel editTableInputsPanel = new JPanel();
        editTableInputsPanel.setLayout(new BoxLayout(editTableInputsPanel, BoxLayout.Y_AXIS));
        editTableInputsPanel.setBorder(new EmptyBorder(5, 30, 5, 30));
        JPanel editTableButtonsPanel = new JPanel();
        
        
        JLabel mealTitleLabel = new JLabel("Meal Title");
        JTextField mealTitleInput = new JTextField();
        
        JLabel mealDescriptionLabel = new JLabel("Meal Description");
        JTextField mealDescriptionInput = new JTextField();
        
        JLabel mealPriceLabel = new JLabel("Meal Price");
        JTextField mealPriceInput = new JTextField();
        
        editTableInputsPanel.add(mealTitleLabel);
        editTableInputsPanel.add(mealTitleInput);
        
        editTableInputsPanel.add(mealDescriptionLabel);
        editTableInputsPanel.add(mealDescriptionInput);
        
        editTableInputsPanel.add(mealPriceLabel);
        editTableInputsPanel.add(mealPriceInput);
        
        JButton updateMealButton = new JButton("Update Meal");
        updateMealButton.setFocusable(false);
        JButton deleteMealButton = new JButton("Delete Meal");
        deleteMealButton.setFocusable(false);
        
        editTableButtonsPanel.add(updateMealButton);
        editTableButtonsPanel.add(deleteMealButton);

        
        editTablePanel.add(editTableInputsPanel, BorderLayout.CENTER);
        editTablePanel.add(editTableButtonsPanel, BorderLayout.SOUTH);
        
        editTablePanel.setPreferredSize(new Dimension(0,150));
        editTablePanel.setBackground(Color.red);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
                
        
         // manage meals
        
        String[] columnNames = {
        		"S/N",
                "Meal ID",
                "Meal Title",
                "Description",
                "Price",
                };
        
        int mealRowCount = sharazDatabase.countTableRows("meals");
        
        Object[][] data = new Object[mealRowCount][6];
        
       
        
        try {
        	
        	 PreparedStatement getMealsStatement;
     		 ResultSet resultSet;
             String getMealsQuery = "SELECT * FROM meals";
             
             
			getMealsStatement = sharazDatabase.CreateConnection().prepareStatement(getMealsQuery);
			resultSet = getMealsStatement.executeQuery();
			
	        int i = 0;
	        while (resultSet.next() && i < mealRowCount) {
	        	int j = i + 1;
				data[i][0] =  j;
				data[i][1] = resultSet.getString("meal_id");
				data[i][2] = resultSet.getString("meal_title");
				data[i][3] = resultSet.getString("meal_description");
				data[i][4] = resultSet.getString("meal_price");
				i++;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
      JPanel manageMealPanel = new JPanel();
      manageMealPanel.setBorder(new EmptyBorder(30, 10, 30, 10));
      manageMealPanel.setLayout(new BorderLayout());
        
        contentPanel.add(new JLabel("Manage Meals Window"));
        
      JTable table = new JTable(data, columnNames);
      
        table.setDefaultEditor(Object.class, null);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
              "Manage Meals",
              TitledBorder.CENTER,
              TitledBorder.TOP));

      scrollPane.setSize(300, 300);
      table.setFillsViewportHeight(true);
   
      manageMealPanel.add(scrollPane);
      
      contentPanel.add(editTablePanel, BorderLayout.NORTH);
      contentPanel.add(manageMealPanel,  BorderLayout.CENTER);
        	
        
        // LOGIC
      table.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			currentSelectedMeal = table.getValueAt(table.getSelectedRow(), 1).toString();
			mealTitleInput.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			mealDescriptionInput.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			mealPriceInput.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
		}
	});
      
      updateMealButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String mealTitle = mealTitleInput.getText();
			String mealDescription = mealDescriptionInput.getText();
			String mealPrice = mealPriceInput.getText();
			
			// empty inputs validation
//			if (currentSelectedMeal != null || mealTitle.isEmpty() || mealDescription.isEmpty() || mealPrice.isEmpty()) {
//				JOptionPane.showMessageDialog(contentPanel, "Inputs cannot be empty", "Fill the Inputs!",JOptionPane.WARNING_MESSAGE, null);
//				return;
//			}
			
			// convert price to double
			double newMealPrice = Double.parseDouble(mealPrice);
			
			try {
				PreparedStatement preparedStatement = null;
				
				String updateMealQuery = "UPDATE meals SET meal_title = ?, meal_description = ?, meal_price = ? "
						+ " WHERE meal_id = ?";
				preparedStatement = sharazDatabase.CreateConnection().prepareStatement(updateMealQuery);
				
				preparedStatement.setString(1, mealTitle);
				preparedStatement.setString(2, mealDescription);
				preparedStatement.setDouble(3, newMealPrice);
				preparedStatement.setString(4, currentSelectedMeal);
				
				int response = (int) preparedStatement.executeUpdate();
				
				if (response == 1) {
					String msg = "Meal " + mealTitle + " was updated";
					JOptionPane.showMessageDialog(contentPanel, msg, "Meal Updated!", JOptionPane.INFORMATION_MESSAGE, null);
					
					frame.dispose();
					new ManageMealsWindow();
				}else {
					JOptionPane.showMessageDialog(contentPanel, "Can't update Meal try again", "Error!", JOptionPane.ERROR_MESSAGE, null);
				}
				
				// reset inputs to empty
				mealTitleInput.setText("");
				mealDescriptionInput.setText("");
				mealPriceInput.setText("");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
      
      deleteMealButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// check if a row is selected
			 if (currentSelectedMeal != null) {
				 int deleteResponse = JOptionPane.showConfirmDialog(contentPanel, "Are you sure you want to delete this meal?");
				 
				 // confirm box
				 if (deleteResponse == 0) {
					 PreparedStatement DeleteMealStatement;
		             String DeleteCashierQuery = "DELETE FROM meals WHERE meal_id = ?";
		             
		             try {
		            	 DeleteMealStatement = sharazDatabase.CreateConnection().prepareStatement(DeleteCashierQuery);
		            	 DeleteMealStatement.setString(1, currentSelectedMeal);
			             int response = DeleteMealStatement.executeUpdate();
			             
			             if (response == 1) {
							JOptionPane.showMessageDialog(contentPanel, "Meal Has been deleted");
							currentSelectedMeal = null;
							frame.dispose();
							new ManageMealsWindow();
						}
			             
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}else {
				// show dialogue box
				JOptionPane.showMessageDialog(contentPanel, "No Meal Is Selected");
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
				// it is the current screen
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
	
	void updateMealsTable(){
		
	}

}
