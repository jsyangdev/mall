package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private Connection getConnection() {
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";                     
        try {                                            
            //드라이버로딩                                    
            Class.forName("com.mysql.jdbc.Driver");
            //DB연결
            connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        } catch (ClassNotFoundException e) {            //forName 클래스를 찾을 수 없는 ClassNotFoundException예외가 발생할 수 있다.
            e.printStackTrace();                        //예외 발생할 경우, e객체 내 printStackTrace메서드를 호출하여 에러 프린트    
        }                                                
        catch (SQLException e) {                        //SQLException예외가 발생할 수 있다.
            e.printStackTrace();                        //예외 발생할 경우, e객체 내 printStackTrace메서드를 호출하여 에러 프린트
        }    
		return connection;
	}
	
	public boolean login(Member member) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean returnValue = false;
		try {
			pstmt = conn.prepareStatement("SELECT id FROM member WHERE id=? AND pw=?");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				returnValue = true;
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace(); 
		}
		
		return returnValue;
		
	}
	
	public int insertMember(Member member) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO member(id, pw, level) VALUES(?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setInt(3, member.getLevel());		// 0: 고객, 1: 관리자
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace(); 
		}
		
		return member.getLevel();	// 0;
	}
}