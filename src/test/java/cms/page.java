package cms;

import com.geek.cms.plugin.grid.Page.SplitPage;
import com.geek.cms.plugin.grid.gridReq.GridRequest;

public class page {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		GridRequest model=new GridRequest();
		model.setParams(new Object[] {null,null,"1"});
		model.setCondition(new String[] {"=","=","="});
		model.setOrWith("or");
		model.setParamsName(new String[] {"create_time","update_time","is_enable"});
		model.setSplitPage(new SplitPage());
		//总记录数
		model.getSplitPage().setTotalRow(100);
		//一页显示多少行
		model.getSplitPage().setPageRow(3);
		System.out.println(model.getSplitPage().limit);
		model.getSplitPage().toNewPage("1");
		System.out.println(model.getSplitPage().limit);
		model.getSplitPage().toNewPage("2");
		System.out.println(model.getSplitPage().limit);
		model.getSplitPage().toNewPage("3");
		System.out.println(model.getSplitPage().limit);
		model.getSplitPage().toNewPage("4");
		System.out.println(model.getSplitPage().limit);
		model.getSplitPage().toNewPage("5");
	}

}
