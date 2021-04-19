package com.springbootwebscrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SpringbootWebscrapApplication {

	public static void main(String[] args) throws IOException {

		Document doc=(Document) Jsoup.connect("https://arxiv.org/list/cs.SI/recent").timeout(6000).get();
		Elements divs = doc.select("dl");
		int i=0;
		for (Element div : divs.select("dd")) {

			String title=div.select("div.list-title").text();
			System.out.println("Document Name:"+title);
			String authorList=div.select("div.list-authors").text();
			System.out.println("Authors Name"+authorList);
		}
		i++;

	}
}
