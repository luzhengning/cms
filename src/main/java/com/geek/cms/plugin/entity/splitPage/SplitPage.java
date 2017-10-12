package com.geek.cms.plugin.entity.splitPage;
/**
 *  分页对象,进行一系列分页操作 
 *  MYSQL数据库
 * @author Administrator
 *
 */
public class SplitPage {
	// 声明一些常量  
    final public static String FIRSTPAGE = "first";// 请求的是首页  
    final public static String PREVIOUSPAGE = "previous";// 请求上一页  
    final public static String NEXTPAGE = "next";// 请求下一页  
    final public static String LASTPAGE = "last";// 请求最后一页  
    
    private int totalPage=1;	//总页数
    private int totalRow=0;		//总行数
    private int pageRow=1;		//每页显示记录数
    private int currentNum=0;	//当前页码
    private int statrNum=0;
    
    public String limit="";
    
    private String pageNo;
    
    
    public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/**
     * 跳转到指定的页面
     * @param flag
     * @return
     */
    public String toNewPage(String flag) {  
        int newPage = this.currentNum;  
        if (flag != null && !"".equals(flag)) {  
            if (SplitPage.FIRSTPAGE.equals(flag)) {
            	//首页
                newPage = 1;  
                this.setStatrNum(0);
            } else if (SplitPage.LASTPAGE.equals(flag)) {  
            	//最后一页
                newPage = this.totalPage;  
                this.setStatrNum((this.totalPage*this.pageRow)-this.pageRow);
            } else if (SplitPage.NEXTPAGE.equals(flag)) {
            	//下一页
                newPage = this.currentNum+ ((this.currentNum == this.totalPage) ? 0 : 1);// 如果当前页面与总的页面数相等则不再向后（+1） 
                this.setStatrNum(newPage*this.pageRow-this.pageRow);
            } else if (SplitPage.PREVIOUSPAGE.equals(flag)) {  
            	//上一页
                newPage = this.currentNum - ((this.currentNum == 1) ? 0 : 1);// 如果当前页面与首页相等则不再向前（-1）  
                this.setStatrNum(newPage*this.pageRow-this.pageRow);
            } else {  
                // 传入的是个数字字符串参数  
                newPage = Integer.parseInt(flag.trim()); 
                if(newPage<=0)newPage=1;
                if(newPage>=this.totalPage){
                	this.setStatrNum((this.totalPage*this.pageRow)-this.pageRow);
                	newPage=this.totalPage;
                }
                else
                	this.setStatrNum((newPage*this.pageRow)-this.pageRow);
            }  
        } else {// 请求的参数为空，则当前页码不变  
            newPage = this.currentNum;  
            this.setStatrNum(newPage*this.pageRow-this.pageRow);
        }  
        this.setCurrentNum(newPage);// 记得重新设置当期页面  
        System.out.println("当前页码："+newPage+" LIMIT "+this.statrNum+","+this.pageRow);
        limit=" LIMIT "+this.statrNum+","+this.pageRow;
        return " LIMIT "+this.statrNum+","+this.pageRow;  
    } 
    
	public int getStatrNum() {
		return statrNum;
	}
	public void setStatrNum(int statrNum) {
		if(statrNum<0)statrNum=0;
		this.statrNum = statrNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalRow() {
		return totalRow;
	}
	/**
	 * 总共多少行
	 * @param totalRow
	 */
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		this.totalPage=(this.totalRow/this.pageRow)+(((this.totalRow % this.pageRow)==0)?0:1);
	}

	public int getPageRow() {
		return pageRow;
	}
	/**
	 * 每页显示多少行
	 * @param pageRow
	 */
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
		this.totalPage=(this.totalRow/this.pageRow)+(((this.totalRow % this.pageRow)==0)?0:1);
	}
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
  
}
