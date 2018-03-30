package cms;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.geek.cms.core.database.AssemblySql;
import com.geek.cms.modules.cms.dao.CmsProductDao;
import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.utils.StringUtil;

public class test {

	public static void main(String[] args) {
		List<SysMenu> sysMenu=new ArrayList();
		System.out.println(StringUtil.isBlank(sysMenu));
	}
}