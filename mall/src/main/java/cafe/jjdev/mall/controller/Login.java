package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private MemberDao memberDao;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginMember") == null) {
			System.out.println("login.jsp forward(로그인 상태X)");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("======== 로그인 중입니다 ========");
			response.sendRedirect(request.getContextPath()+"/index");
		}
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogin = false;
		Member member = new Member();
		MemberDao memberDao = new MemberDao();
		// 화면에서 입력데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id+" <--id Login.java");
		System.out.println(pw+" <--pw Login.java");
		// DTO에 셋팅
		member.setId(id);
		member.setPw(pw);
		// boolean MemberDao.login(Member) 호출
		isLogin = memberDao.login(member);
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member.getId());
			response.sendRedirect(request.getContextPath()+"/index");
		} else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
}