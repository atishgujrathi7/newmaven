package Controller;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ALMSDao.Farmer;
import ALMSDao.Labor;
import ALMSDao.LaborDao;
import ALMSDao.Request;
import ALMSDao.RequestDao;

public class RequestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
	
		LaborDao ldao = (LaborDao)factory.getBean("labor");
		
		
		List<Labor> llist = new ArrayList<Labor>();
		llist = ldao.getLabors();
		
		Iterator it = llist.iterator();
		int cnt = 1, id=0;
		String i, farmerName=null,laborName=null;
	
		while(it.hasNext())
		{
			i = ""+cnt;
	
			if(request.getParameter(i)!=null){
				
				id = Integer.parseInt(i);
				HttpSession session = request.getSession();
				laborName = (String)session.getAttribute("laborsess");
				farmerName = (String)session.getAttribute("sess");
				break;
			}
			it.next();
			cnt++;
		}
		
		RequestDao rdao = (RequestDao)factory.getBean("request");
		
		Request r1 = new Request(id, farmerName,laborName);
		
		rdao.saveRequest(r1);
		
		
	
		ModelAndView model = new ModelAndView();
		
		model.setViewName("index2");
		
		return model;
		
		
		//return null;
	}
	
}
