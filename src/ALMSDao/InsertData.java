package ALMSDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class InsertData {
public static void main(String[] args) {
	
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	
	FarmerDao fdao = (FarmerDao)factory.getBean("farmer");
	
	//LaborDao ldao = (LaborDao)factory.getBean("labor");
	
	Farmer f1= new Farmer(1,"manoj","1111","Jalgaon",3500);
	
	fdao.saveFarmer(f1);
	
	/*List<Farmer> list = new ArrayList<Farmer>();
	list = fdao.getFarmers();
	
	System.out.println(list.get(1).location);
	
	Iterator<Farmer> it = list.iterator();
	
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	*/
	
	//Labor l1 = new Labor(1,"patil","2222","male","12/12/1912","Pune",150);
	
	//ldao.saveLabor(l1);
	
}


public void setData(String fname,String fpass,String floc,double famt)
{
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	int fid = 3;
	
	Farmer f1= new Farmer(fid,fname,fpass,floc,famt);
	
    FarmerDao fdao = (FarmerDao)factory.getBean("farmer");
	
	fid++;
	
	fdao.saveFarmer(f1);
	
}

public BeanFactory getBeanObject()
{		
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		
		return factory;

}

}
