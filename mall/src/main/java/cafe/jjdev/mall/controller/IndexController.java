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
		// 01 router 역할 : @WebServlet("/index")
		// (model생성 : DAO같음 model이 model을 생성)
		// 02 model호출 : DAO 모델생성
		String model = "jjdev";
		// view rendering(template필요 -> jsp활용)
		
		// 03
		 request.setAttribute("model", model);
		// 04 forward(request, response) to WEB-INF/jsp/index.jsp	
		
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);		//""여기로 포워딩 시킬 거
		
		
	}


}
