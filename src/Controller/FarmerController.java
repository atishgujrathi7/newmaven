package Controller;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ALMSDao.Farmer;
import ALMSDao.FarmerDao;

public class FarmerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
	
		
		String fname = request.getParameter("fname");
		String fpass = request.getParameter("fpass");
		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
		FarmerDao fdao = (FarmerDao)factory.getBean("farmer");
		
		List<Farmer> flist = new ArrayList<Farmer>();
		flist = fdao.getFarmers();
		
		
		Iterator it = flist.iterator();
		int i = 0;
		while(it.hasNext())
		{
			
			//System.out.println(fname+" "+fpass);
			if(fname.equals(flist.get(i).getName()) && fpass.equals(flist.get(i).getPassword()))
			{
				
				//request.setAttribute("farmerSess", flist.get(i).getName());
				
				HttpSession session = request.getSession();
				session.setAttribute("farmerSess", flist.get(i).getName());
				String url = "/index2.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
				
				
				
				//System.out.println(flist.get(i).getPassword());
				//response.sendRedirect("index2.jsp");
			}
			
			i++;
			it.next();
			
		}
		
		//response.sendRedirect("Farmer_Login_Reg.jsp");		
		Farmer f  = new Farmer();
		ModelAndView model = new ModelAndView();
		
		model.setViewName("Farmer_Login_Reg");
		
		return model;
	}

}
