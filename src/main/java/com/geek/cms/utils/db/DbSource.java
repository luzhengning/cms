package com.geek.cms.utils.db;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbSource {
	private static DataSource ds;  
    //声明ThreadLocal容器对象  
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();  
    static {  
        ds = // 默认的读取c3p0-config.xml中默认配置   
        new ComboPooledDataSource();   
    }  
    public static DataSource getDatasSource() {  
        return ds;   
    }     
    //提供一个返回Connection的方法  
    public static Connection getConnection(){  
        Connection con = null;  
        //先从tl中获取数据  
        con = threadLocal.get();  
        if(con==null){  
            try{  
                con = getDatasSource().getConnection();  
                //放到tl  
                threadLocal.set(con);   
            }catch(Exception e){
                e.printStackTrace();  
            }  
        }  
        return con;
    }  
    public static void remove() {  
    	threadLocal.remove();  
    }  
    /**
     * @Method: startTransaction
     * @Description: 开启事务
     * @Anthor:路正宁
     *
     */ 
     public static void startTransaction(){
         try{
             Connection conn =  threadLocal.get();
             if(conn==null){
                 conn = getConnection();
                  //把 conn绑定到当前线程上
                 threadLocal.set(conn);
             }
             //开启事务
             conn.setAutoCommit(false);
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     
     /**
     * @Method: rollback
     * @Description:回滚事务
     * @Anthor:路正宁
     *
     */ 
     public static void rollback(){
         try{
             //从当前线程中获取Connection
             Connection conn = threadLocal.get();
             if(conn!=null){
                 //回滚事务
                 conn.rollback();
             }
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     
     /**
     * @Method: commit
     * @Description:提交事务
     * @Anthor:路正宁
     *
     */ 
     public static void commit(){
         try{
             //从当前线程中获取Connection
             Connection conn = threadLocal.get();
             if(conn!=null){
                 //提交事务
                 conn.commit();
             }
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     
     /**
     * @Method: close
     * @Description:关闭数据库连接(注意，并不是真的关闭，而是把连接还给数据库连接池)
     * @Anthor:路正宁
     *
     */ 
     public static void close(){
         try{
             //从当前线程中获取Connection
             Connection conn = threadLocal.get();
             if(conn!=null){
                 conn.close();
                  //解除当前线程上绑定conn
                 threadLocal.remove();
             }
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     
     /**
     * @Method: getDataSource
     * @Description: 获取数据源
     * @Anthor:路正宁
     * @return DataSource
     */ 
     public static DataSource getDataSource(){
         //从数据源中获取数据库连接
         return ds;
     }
    
}
