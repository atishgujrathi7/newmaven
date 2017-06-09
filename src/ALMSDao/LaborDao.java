package ALMSDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.*;

public class LaborDao {
HibernateTemplate template;
public void setTemplate(HibernateTemplate template) {
	this.template = template;
}

public void saveLabor(Labor l){
	template.save(l);
}

public void updateLabor(Labor l){
	template.update(l);
}

public void deleteLabor(Labor l){
	template.delete(l);
}

public Labor getById(int id){  
	Labor l=(Labor)template.get(Labor.class,id);  
    return l;  
}  
  
@SuppressWarnings("unchecked")
public List<Labor> getLabors(){  
    List<Labor> list=new ArrayList<Labor>();  
    list=template.loadAll(Labor.class);  
    return list;  
}  

}
