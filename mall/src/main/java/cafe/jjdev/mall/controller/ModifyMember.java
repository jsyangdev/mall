package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyMember")
public class ModifyMember extends HttpServlet {
	// 회원정보 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  로그인 확인
		if(request.getSession().getAttribute("loginMember") == null) {
			System.out.println("-------로그인 상태가 아닙니다(login.jsp로 forward)-------");
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			System.out.println("-------로그인 중입니다-------");
			
		
		// MemberDao.selectMember()
		
		// forward
			
		}
	}
	// 수정액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		// MemberDao.updateMember()
		// 로그아웃  redirect
	}

}