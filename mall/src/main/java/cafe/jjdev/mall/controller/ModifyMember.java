package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyMember")
public class ModifyMember extends HttpServlet {
	// ȸ������ ���� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  �α��� Ȯ��
		if(request.getSession().getAttribute("loginMember") == null) {
			System.out.println("-------�α��� ���°� �ƴմϴ�(login.jsp�� forward)-------");
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			System.out.println("-------�α��� ���Դϴ�-------");
			
		
		// MemberDao.selectMember()
		
		// forward
			
		}
	}
	// �����׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α��� Ȯ��
		// MemberDao.updateMember()
		// �α׾ƿ�  redirect
	}

}