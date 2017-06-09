package ALMSDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.*;

public class RequestDao {
HibernateTemplate template;
public void setTemplate(HibernateTemplate template) {
	this.template = template;
}

public void saveRequest(Request r){
	template.save(r);
}

public void updateRequest(Request r){
	template.update(r);
}

public void deleteRequest(Request r){
	template.delete(r);
}

public Request getById(int id){  
	Request r=(Request)template.get(Request.class,id);  
    return r;  
}  
  
@SuppressWarnings("unchecked")
public List<Request> getRequest(){  
    List<Request> list=new ArrayList<Request>();  
    list=template.loadAll(Request.class);  
    return list;  
}  

}

