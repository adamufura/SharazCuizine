package sharaz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class SharazDatabase {
	Connection connection;
	public SharazDatabase()  {
		
	}
	
	public Connection CreateConnection(){
		String url = "jdbc:mysql://localhost:3306/sharaz";
		try {
			connection = DriverManager.getConnection(url, "root", "abba2326");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public double getTotalSales() {
		double totalSales = 0;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String totalSalesQuery = "SELECT * FROM sales";
		
		try {
			preparedStatement = this.CreateConnection().prepareStatement(totalSalesQuery);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				totalSales = totalSales + resultSet.getInt(5);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalSales;
	}
	
	public int countTableRows(String tableName) {
		int rowCount = 0;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String tableRowsQuery = "SELECT COUNT(1) FROM " + tableName;
		
		try {
			preparedStatement = this.CreateConnection().prepareStatement(tableRowsQuery);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				rowCount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int countTableRowsWithQuery(String query, String id) {
		int rowCount = 0;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String tableRowsQuery = query;
		
		try {
			preparedStatement = this.CreateConnection().prepareStatement(tableRowsQuery);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				rowCount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public String getMealTitle(String meal_id) {
		PreparedStatement getSalesStatement;
    	ResultSet resultSet;
        String getMealsQuery = "SELECT * FROM meals WHERE meal_id = ?";
        
        String data = "No Title";
            
         try {
        	 
        	 getSalesStatement = this.CreateConnection().prepareStatement(getMealsQuery);
             getSalesStatement.setString(1, meal_id.trim());
             resultSet = getSalesStatement.executeQuery();
             
             if (resultSet.next()) {
    			 return resultSet.getString(3);
			}else {
				System.out.println("No data");
			}

				
				resultSet.close();
				getSalesStatement.close();
             
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public double getTotalCashierSales(String cashier_id) {
		double totalSales = 0;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String totalSalesQuery = "SELECT * FROM sales WHERE cashier_id = ?";
		
		try {
			preparedStatement = this.CreateConnection().prepareStatement(totalSalesQuery);
			preparedStatement.setString(1, cashier_id.trim());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				totalSales = totalSales + resultSet.getInt(5);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalSales;
	}
	
	public Object[] getCashier(String cashier_id) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String getCashierQuery = "SELECT * FROM cashier WHERE cashier_id = ?";
		Object data[] = new Object[3];
		
		try {
			preparedStatement = this.CreateConnection().prepareStatement(getCashierQuery);
			preparedStatement.setString(1, cashier_id.trim());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				BufferedImage bufferedImage = null;
				try {
					 bufferedImage = ImageIO.read(resultSet.getBinaryStream("avatar"));
//				     studentIcon = new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				data[0] = resultSet.getString("first_name");
				data[1] = resultSet.getString("last_name");
				data[2] = bufferedImage;
			}
			
			return data;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
}
