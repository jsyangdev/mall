package cafe.jjdev.mall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IndexController doGet");
		// 01 router ���� : @WebServlet("/index")
		// (model���� : DAO���� model�� model�� ����)
		// 02 modelȣ�� : DAO �𵨻���
		String model = "jjdev";
		// view rendering(template�ʿ� -> jspȰ��)
		
		// 03
		 request.setAttribute("model", model);
		// 04 forward(request, response) to WEB-INF/jsp/index.jsp	
		
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);		//""����� ������ ��ų ��
		
		
	}


}