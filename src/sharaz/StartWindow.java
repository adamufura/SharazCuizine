package sharaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import admin.DashboardWindow;
import cashier.CashierDashBoardWindow;
import icon.FontAwesome;
import icon.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

public class StartWindow {
    JFrame frame =  new JFrame();
    
    public StartWindow() {
    	
		SharazDatabase sharazDatabase = new SharazDatabase();
						
    	IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
    	IconFontSwing.register(FontAwesome.getIconFont());
        ImageIcon icon = new ImageIcon("logo.png");
      
        // left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(132, 220, 198));
        
        JLabel sharaztitle = new JLabel("Sharaz Cuizine Management System");
        sharaztitle.setIcon(icon);
        sharaztitle.setHorizontalTextPosition(JLabel.CENTER);	
        sharaztitle.setVerticalTextPosition(JLabel.TOP);
        sharaztitle.setForeground(Color.WHITE);
        sharaztitle.setFont(new Font("Times New Roman",Font.BOLD,27));
        sharaztitle.setIconTextGap(90);
        sharaztitle.setVerticalAlignment(JLabel.BOTTOM);
        sharaztitle.setHorizontalAlignment(JLabel.CENTER);
        
        
        leftPanel.add(sharaztitle);
        
        // right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(new Color(46, 134, 171));
        
        JPanel loginLabelPanel = new JPanel();
        JLabel currentLoginLabel = new JLabel("Sharaz Login");
        currentLoginLabel.setForeground(Color.WHITE);
        currentLoginLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        currentLoginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabelPanel.add(currentLoginLabel);
        
        // login form
        JPanel loginFormPanelBase = new JPanel();
        ImageIcon imageLogo = new ImageIcon("admin.png");
        
        
        loginFormPanelBase.setBackground(new Color(46, 134, 171));
        loginFormPanelBase.setBorder(new EmptyBorder(50, 10, 30, 10));
        JPanel loginFormPanel = new JPanel();
        loginFormPanel.setPreferredSize(new Dimension(300, 400));
        loginFormPanel.setLayout(new BoxLayout(loginFormPanel, BoxLayout.PAGE_AXIS));
        loginFormPanel.setBackground(new Color(46, 134, 171));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageLogo);
        JLabel idLabel = new JLabel("User ID");
        idLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        idLabel.setForeground(Color.WHITE);
        JTextField idInput = new JTextField();
        JLabel passwordLabel = new JLabel("User Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passswordInput = new JPasswordField();
        JLabel selectUserTypeLabel = new JLabel("Select User Type");
        selectUserTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        selectUserTypeLabel.setForeground(Color.WHITE);
        String userType[] = {"Admin", "Cashier"};
        JComboBox<String> userTypeBox = new JComboBox<String>(userType);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(132, 220, 198));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        loginButton.setIcon(IconFontSwing.buildIcon(FontAwesome.SIGN_IN, 18, Color.WHITE));
        loginButton.setIconTextGap(10);
        
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passswordInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectUserTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userTypeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        loginFormPanel.add(Box.createVerticalGlue());
        loginFormPanel.add(imageLabel);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(idLabel);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(idInput);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(passwordLabel);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(passswordInput);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(selectUserTypeLabel);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(userTypeBox);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(loginButton);
        loginFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginFormPanel.add(Box.createVerticalGlue());
        
        loginFormPanelBase.add(loginFormPanel);
        
        // switch button
        JPanel loginSwitchPanel = new JPanel();
        loginSwitchPanel.setBackground(new Color(46, 134, 171));
        JButton loginSwitchButton = new JButton("V1.0");
        loginSwitchButton.setFocusable(false);
        loginSwitchButton.setBackground(new Color(214, 64, 69));
        loginSwitchButton.setForeground(Color.WHITE);
        loginSwitchButton.setBorderPainted(false);
        loginSwitchPanel.add(loginSwitchButton);
        
        rightPanel.add(currentLoginLabel, BorderLayout.NORTH);
        rightPanel.add(loginFormPanelBase, BorderLayout.CENTER);
        rightPanel.add(loginSwitchPanel, BorderLayout.SOUTH);
        
        // LOGIC
        loginButton.addActionListener(new ActionListener() {
     	
			@Override
			public void actionPerformed(ActionEvent e) {		
				// Get input values
	        	String userID = idInput.getText();
	        	@SuppressWarnings("deprecation")
				String userPassword = passswordInput.getText();
	        	
	        	//check if inputs are empty
				
				if (userID.isEmpty() || userPassword.isEmpty()) {
					JOptionPane.showMessageDialog(rightPanel, "Inputs cannot be empty");
					return;
				}
	        	
				int selectedUser = userTypeBox.getSelectedIndex();
				// admin selected
				if (selectedUser == 0) {
					// compare user info from database
					PreparedStatement preparedStatement;
					ResultSet resultSet = null;
					try {
						String getAdminInfo = "SELECT * FROM admin WHERE admin_id = ? AND admin_password = ?";
						preparedStatement = sharazDatabase.CreateConnection().prepareStatement(getAdminInfo);
						preparedStatement.setString(1, userID);
						preparedStatement.setString(2,  userPassword);
												
						resultSet = preparedStatement.executeQuery();
						
						if (resultSet.next()) {
							// Admin dashboard
							frame.dispose();
							new DashboardWindow();
						}else {
							JOptionPane.showMessageDialog(rightPanel, "Incorrect ID or password");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}else {
					// compare user info from database
					PreparedStatement preparedStatement;
					ResultSet resultSet = null;
					try {
						String getCashierInfo = "SELECT * FROM cashier WHERE cashier_id = ? AND password = ?";
						preparedStatement = sharazDatabase.CreateConnection().prepareStatement(getCashierInfo);
						preparedStatement.setString(1, userID);
						preparedStatement.setString(2,  userPassword);
												
						resultSet = preparedStatement.executeQuery();
						
						if (resultSet.next()) {
							frame.dispose();
							// cashier dashboard
							new CashierDashBoardWindow(userID);
						}else {
							JOptionPane.showMessageDialog(frame, "Incorrect ID or password");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

        // window configuration
        frame.getRootPane().setDefaultButton(loginButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sharaz Management System");
        frame.setIconImage(icon.getImage());
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setLayout(new GridLayout(1, 2));
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
