package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	/**
	 * ����̹� �ε�, DB���� ���� �޼���
	 * @return
	 */
	private Connection getConnection() {
        Connection connection = null;
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPass = "java0000";                     
        try {                                            
            // ����̹� �ε�                              
            Class.forName("com.mysql.jdbc.Driver");
            // DB����
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
	 * ��� ��ȸ �޼���
	 * @param id
	 * @return
	 */
	public Member selectMember(String id) {
		
		return null;
	}
	/**
	 * ������ �Ѿ�� �Էµ����Ϳ� DB�� ����� �����͸� ���Ͽ� ��ġ�ϴ��� �ƴ��� �Ҹ��� Ÿ������ �����ϴ� �޼���
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
	 * ����� ���Խ�Ű�� �޼���
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
			pstmt.setInt(3, member.getLevel());		// 0: ��, 1: ������
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace(); 
		}
		
		return member.getLevel();	// 0;
	}
}