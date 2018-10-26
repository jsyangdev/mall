package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	/**
	 * 드라이버 로딩, DB연결 공통 메서드
	 * @return
	 */
	private Connection getConnection() {
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";                     
        try {                                            
            // 드라이버 로딩                              
            Class.forName("com.mysql.jdbc.Driver");
            // DB연결
            connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        } catch (ClassNotFoundException e) {            
            e.printStackTrace();                      
        }                                                
        catch (SQLException e) {                      
            e.printStackTrace();                 
        }    
		return connection;
	}
	/**
	 * 멤버 조회 메서드
	 * @param id
	 * @return
	 */
	public Member selectMember(String id) {
		
		return null;
	}
	/**
	 * 폼에서 넘어온 입력데이터와 DB에 저장된 데이터를 비교하여 일치하는지 아닌지 불리언 타입으로 리턴하는 메서드
	 * @param member
	 * @return
	 */
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
	/**
	 * 멤버를 가입시키는 메서드
	 * @param member
	 * @return
	 * @throws SQLException
	 */
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