package ALMSDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.*;

public class FarmerDao {
HibernateTemplate template;
public void setTemplate(HibernateTemplate template) {
	this.template = template;
}

public void saveFarmer(Farmer f){
	template.save(f);
}

public void updateFarmer(Farmer f){
	template.update(f);
}

public void deleteFarmer(Farmer f){
	template.delete(f);
}

public Farmer getById(int id){  
	Farmer f=(Farmer)template.get(Farmer.class,id);  
    return f;  
}  
  
@SuppressWarnings("unchecked")
public List<Farmer> getFarmers(){  
    List<Farmer> list=new ArrayList<Farmer>();  
    list=template.loadAll(Farmer.class);  
    return list;  
}  

}
