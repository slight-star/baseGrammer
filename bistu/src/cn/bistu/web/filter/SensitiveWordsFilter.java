package cn.bistu.web.filter;

import sun.awt.SunHints;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author dfx
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<String>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是该方法
                if (method.getName().equals("getParameter")) {
                    System.out.println("进入过滤器");
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    System.out.println(value);
                    return value;
                }

                if (method.getName().equals("getParameterMap")){
                    //获取原来的返回值
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    HashMap<String, String[]> newMap = new HashMap<>(map);
                    if (newMap != null){
                        Set<String> keySet = newMap.keySet();
                        for (String key : keySet){
                            String[] values = newMap.get(key);
                            for (int i = 0; i < values.length; i++){
                                //遍历每一个值
                                System.out.println("过滤前"+values[i]);
                                for (String str : list){
                                    //遍历每一个敏感词
                                    if (values[i].contains(str)){
                                        values[i] = values[i].replaceAll(str, "***");
                                    }
                                }
                                System.out.println("过滤后"+values[i]);
                            }
                            newMap.put(key, values);
                        }
                        return newMap;
                    }
                }

                if (method.getName().equals("getParameterValues")){
                    //获取原来的返回值
                    String[] values = (String[])method.invoke(req, resp);
                    for (int i = 0; i < values.length; i++){
                        for(String str : list){
                            if(values[i].contains(str)){
                                values[i].replaceAll(str, "***");
                            }
                        }
                    }
                    return values;
                }
                return method.invoke(req, args);
            }
        });
        //放行
        chain.doFilter(proxy_req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println(Charset.defaultCharset());
        //加载敏感词汇文件
        //1.获取路径，读取文件
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        BufferedReader br = null;
        try {
//        乱码的需要用这个new BufferedReader(new InputStreamReader(new FileInputStream(realPath),"GBK"))
            br = new BufferedReader(new FileReader(realPath));
            String line = null;
            //2.存入list
            while ((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //3.关闭文件
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
