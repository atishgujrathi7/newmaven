package Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ALMSDao.Farmer;
import ALMSDao.FarmerDao;
import ALMSDao.Labor;
import ALMSDao.LaborDao;

public class LaborController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		
		String lname = request.getParameter("lname");
		String lpass = request.getParameter("lpass");
		String lpass_confirm = request.getParameter("lpass_confirm");
		String lgender = request.getParameter("lgender");
		String ldob = request.getParameter("ldob");
		String lloc = request.getParameter("lloc");
		double lwages = Double.parseDouble(request.getParameter("lwages"));
		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
		LaborDao ldao = (LaborDao)factory.getBean("labor");
		
		
		List<Labor> llist = new ArrayList<Labor>();
		llist = ldao.getLabors();
		
		
		Iterator it = llist.iterator();
		int i = 0;
		while(it.hasNext())
		{		
			i++;
			it.next();
			
		}
		
		
		int id;
		id=i+1;
		Labor l = new Labor(id,lname,lpass,lgender,ldob,lloc,lwages);
		
		ldao.saveLabor(l);
		
		response.sendRedirect("Labour_Login_Reg.jsp");
		/*
		String fname = request.getParameter("lname");
		String fpass = request.getParameter("lpass");
		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
		LaborDao ldao = (LaborDao)factory.getBean("labor");
		
		List<Labor> llist = new ArrayList<Labor>();
		llist = ldao.getLabors();
		
		
		Iterator it = llist.iterator();
		int i = 0;
		while(it.hasNext())
		{
			//System.out.println(lname+" "+lpass);
			if(fname.equals(llist.get(i).getName()) && fpass.equals(llist.get(i).getPassword()))
			{
				//System.out.println(llist.get(i).getName());
				//System.out.println(llist.get(i).getPassword());
				response.sendRedirect("index.html");
			}
			
			i++;
			it.next();
			
		}
		
		//response.sendRedirect("Farmer_Login_Reg.jsp");		
		*/
		return null;

	}

}
