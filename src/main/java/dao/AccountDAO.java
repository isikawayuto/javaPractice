package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AccountDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerAccount(Account account) {
		String sql = "INSERT INTO GitPractice VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPw(), salt);
		
		System.out.println("ハッシュに使うソルトは"+salt);
		System.out.println("登録されるハッシュ済みのPWは"+hashedPw);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getAge());
			pstmt.setString(3, account.getGender());
			pstmt.setString(4, account.getBirthday());
			pstmt.setString(5, account.getAddress());
			pstmt.setString(6, account.getTel());
			pstmt.setString(7, account.getMail());
			pstmt.setString(8, salt);
			pstmt.setString(9, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM GitPractice WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
	public static Account login(String mail, String hashedPw) {
		String sql = "SELECT * FROM GitPractice WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("id");
					String name  =rs.getString("name");
					String age =rs.getString("age");
					String gender =rs.getString("gender");
					String birthday =rs.getString("birthday");
					String address =rs.getString("address");
					String tel =rs.getString("tel");
					String salt = rs.getString("salt");
					
					return new Account(id, name, age, gender, birthday, address, tel, mail, salt, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<Account> selectAllHuman() {
		// 返却用変数
		List<Account> result = new ArrayList<>();

		String sql = "SELECT * FROM gitpractice";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
		

			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String age = rs.getString("age");
					String gender = rs.getString("gender");
					String birthday = rs.getString("birthday");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					String mail = rs.getString("mail");

					Account account = new Account(id, name, age, gender, birthday, address, tel, mail, null, null);
					
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
}
