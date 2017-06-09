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

public class FarmerRegController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//System.out.println("Welcome");
		
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname1");
		String fpass = request.getParameter("fpass1");
		String fpass_confirm = request.getParameter("fpass_confirm1");
		String floc = request.getParameter("floc1");
		double famt = Double.parseDouble(request.getParameter("famt1"));
		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
		FarmerDao fdao = (FarmerDao)factory.getBean("farmer");
		
		
		List<Farmer> flist1 = new ArrayList<Farmer>();
		flist1 = fdao.getFarmers();
		
		
		Iterator it = flist1.iterator();
		int i = 0;
		while(it.hasNext())
		{		
			i++;
			it.next();
			
		}
		
		
		int id;
		id=i+1;
		Farmer f = new Farmer(id,fname,fpass,floc,famt);
		
		fdao.saveFarmer(f);
		
		response.sendRedirect("Farmer_Login_Reg.jsp");
		
		
		
		return null;
	}

}
