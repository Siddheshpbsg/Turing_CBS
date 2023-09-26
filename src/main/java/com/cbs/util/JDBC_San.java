package com.cbs.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

public class JDBC_San 
{
	    private static Connection con;
	    public static Connection getConnection() {
	        try {
	            if (con == null || con.isClosed()) {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                con = DriverManager.getConnection
	                		("jdbc:sqlserver://10.10.10.137:1433;databaseName=BSGCRM","sa","pass@word1");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }

	    public static void updateTransactionStatus(String q,String txnRefNo) {
	        Connection con = null;
	        PreparedStatement statement = null;

 

	        try {
	            con = getConnection();
	          //  String updateQuery = "UPDATE BSGACCOUNTING..transaction_status SET post_date = txn_date WHERE is_active = 1 AND txn_ref_no = ?";
	            statement = con.prepareStatement(q);
	            statement.setString(1, txnRefNo);

 

	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Update successful. Rows updated: " + rowsUpdated);
	            } else {
	                System.out.println("No rows updated for txn_ref_no: " + txnRefNo);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(null, statement, con);
	        }
	    }

	    private static void closeResources(ResultSet result, PreparedStatement statement, Connection con) {
	        try {
	            if (result != null) {
	                result.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

















 

//		public static List<String> getMigratedIndividualCustomers() {
//	    	List<String> customerIds = new ArrayList<String>();
//	        String id = null;
//	        Connection con = null;
//	        PreparedStatement statement = null;
//	        ResultSet result = null;
//
//	     //   List<String> customerIds = null;
//			try {
//	            con = getConnection();
//	            String q = "SELECT customer_id FROM BSGACCOUNTING..customer_view WHERE classification_id=2 AND account_status_id=1";
//	            statement = con.prepareStatement(q);
//	            result = statement.executeQuery();
//
//	            while (result.next()) {
//	                id = result.getString("customer_id");
//	                customerIds.add(id);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            closeResources(result, statement, con);
//	        }
//
//	        return customerIds;
//	    }
//
//	    public static String getMigratedCorpCustomer() {
//	        String id = null;
//	        Connection con = null;
//	        PreparedStatement statement = null;
//	        ResultSet result = null;
//
//	        try {
//	            con = getConnection();
//	            String q = "SELECT customer_id FROM BSGACCOUNTING..customer_view WHERE classification_id=1 AND account_status_id=1";
//	            statement = con.prepareStatement(q);
//	            result = statement.executeQuery();
//
//	            while (result.next()) {
//	                id = result.getString("customer_id");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            closeResources(result, statement, con);
//	        }
//
//	        return id;
//	    }
//
//	    public static String getMigratedCurrentAccount() {
//	        String currentAccount = null;
//	        Connection con = null;
//	        PreparedStatement statement = null;
//	        ResultSet result = null;
//
//	        try {
//	            con = getConnection();
//	            String q = "SELECT account_no FROM BSGACCOUNTING..customer_view WHERE classification_id=1 AND account_status_id=1 AND branch_code=1004 AND account_id='428140'";
//	            statement = con.prepareStatement(q);
//	            result = statement.executeQuery();
//
//	            while (result.next()) {
//	                currentAccount = result.getString("account_no");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            closeResources(result, statement, con);
//	        }
//
//	        return currentAccount;
//	    }
//
//	    public static String getMigratedSavingAccount() {
//	        String savingAccount = null;
//	        Connection con = null;
//	        PreparedStatement statement = null;
//	        ResultSet result = null;
//
//	        try {
//	            con = getConnection();
//	            String q = "SELECT account_no FROM BSGACCOUNTING..customer_view WHERE classification_id=2 AND account_status_id=1 AND branch_code=1004 AND account_id='428453'";
//	            statement = con.prepareStatement(q);
//	            result = statement.executeQuery();
//
//	            while (result.next()) {
//	                savingAccount = result.getString("account_no");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            closeResources(result, statement, con);
//	        }
//
//	        return savingAccount;
//	    }
//




 

 

//	    public static void main(String[] args) throws Exception {
//	        getConnection();
//	        System.out.println(getMigratedIndividualCustomers());
//	        System.out.println(getMigratedCorpCustomer());
//	        System.out.println(getMigratedCurrentAccount());
//	        System.out.println(getMigratedSavingAccount());
//	        
//	        updateTransactionStatus("13153087193");
//	    }
	}