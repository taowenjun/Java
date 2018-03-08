package pachong;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.HashSet;  
import java.util.List;  
import java.util.Set;  
  
public class LinkQueue {  
  
    // 已访问的 url 集合  
    private static Set<String> visitedUrl = Collections.synchronizedSet(new HashSet<String>());  
  
    // 未访问的url  
    private static List<String> unVisitedUrl = Collections.synchronizedList(new ArrayList<String>());  
      
    // 未访问的URL出队列  
    public static String unVisitedUrlDeQueue() {  
        if (unVisitedUrl.size() > 0) {  
            String url = unVisitedUrl.remove(0); 
            
            visitedUrl.add(url);  
            return url;  
        }  
        return null;  
    }  
      
      
      
    // 新的url添加进来的时候进行验证，保证只是添加一次  
    public static void addUnvisitedUrl(String url) {  
        if (url != null && !url.trim().equals("") && !visitedUrl.contains(url)  
                && !unVisitedUrl.contains(url))  
            unVisitedUrl.add(url);  
    }  
      
    // 判断未访问的URL队列中是否为空  
    public static boolean unVisitedUrlsEmpty() {  
        return unVisitedUrl.isEmpty();  
    }  
      
}  

