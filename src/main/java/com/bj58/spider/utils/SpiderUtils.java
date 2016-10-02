package com.bj58.spider.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bj58.spider.controllers.Image;

/**
 * 抓取网络图片
 * @author 58
 *
 */
public class SpiderUtils {
	
	private static Map<String, String > urls=new HashMap<String, String>();
	static{
		urls.put("all", "1");//所有的
		urls.put("xiong", "2");//所有的
		urls.put("tun", "6");//小清新
		urls.put("silk", "7");//文艺
		urls.put("leg", "3");//文艺
		urls.put("beatiful", "4");//文艺
		urls.put("other", "5");//文艺
	}
	private static final String URL="http://www.dbmeinv.com/dbgroup/show.htm";
	/**
	 * 根据页码和分类来查询图片的数据
	 * @param category 分类
	 * @param pageNum 页码
	 * @throws IOException 
	 */
	public static List<Image> queryImageList(String category,String pageNum) throws IOException{
		List<Image> images=new ArrayList<Image>();
		Document doc=Jsoup.connect(URL).
				data("cid",urls.get(category)).
				data("pager_offset", pageNum).//请求参数
				timeout(5000).  //超时设置，5s
				get();//get请求
		
		//Elements imgs=doc.getElementsByTag("img");
		Elements divs=doc.getElementsByClass("img_single");
		Image image=null;
		for (Element div : divs) {
			Element a=div.getElementsByTag("a").first();
			Element img=div.getElementsByTag("img").first();
			String ourl=a.attr("href");//大图
			String surl=img.attr("src");//缩略图
			String title=img.attr("title");//标题
		
			//System.out.println(surl +" "+ title+" " +ourl);
			if (surl!=null && !"".equals(surl)) {
				image=new Image();
				image.setUrl(surl);
				image.setTitle(title);
				image.setOurl(ourl);
				images.add(image);
			}
			
		}
		return images;
	}
	public static void main(String[] args) throws Exception {
		List<Image> images= queryImageList("leg", "2");
		System.out.println(images.size());
	}

}
