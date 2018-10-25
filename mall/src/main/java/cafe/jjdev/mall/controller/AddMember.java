package cafe.jjdev.mall.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/addMember")
public class AddMember extends HttpServlet{
	MemberDao memberDao;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addMember.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// 화면에서 입력데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String level2 = request.getParameter("level");
		int level = Integer.parseInt(level2);
		System.out.println(id+"<--id AddMember.java");
		System.out.println(pw+"<--pw AddMember.java");
		System.out.println(level+"<--level AddMember.java");
		// DTO 생성 후, 입력데이터 셋팅
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		//	DAO 생성
		memberDao = new MemberDao();
		try {
			int row = memberDao.insertMember(member);
			System.out.println(row+"<--row");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}