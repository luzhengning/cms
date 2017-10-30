package cms;

import com.geek.cms.common.util.SqlUtils;
import com.geek.cms.modules.cms.dao.CmsProductDao;
import com.geek.cms.modules.cms.service.CmsFactory;
import com.geek.cms.modules.cms.service.CmsProduct;
import com.geek.cms.modules.faramwer.dpatterns.factoryMethod.ServiceFactory;
import com.geek.cms.modules.faramwer.dpatterns.factoryMethod.ServiceProduct;

public class test {

	public static void main(String[] args) {
		ServiceFactory factory=new CmsFactory();
		CmsProduct product=(CmsProduct) factory.create();
		product.insert();
		product.delete();
		product.update();
		product.query();
	}
}