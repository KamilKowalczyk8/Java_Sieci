package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.w3c.dom.html.HTMLElement;

public class HtmlUnitExample {
    public static void main(String[] args) throws Exception{

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);

        HtmlPage page = webClient.getPage("https://mvnrepository.com/");
        System.out.println("page title: "+page.getTitleText());
        System.out.println("page xml: "+ page.asXml().substring(0,50));
        System.out.println("page text: "+ page.asNormalizedText().substring(0,50));

        HtmlElement body = (HtmlElement) page.getElementById("page");
        System.out.println( body.asNormalizedText().substring(0,50));

        System.out.println("num inputs: "+ page.getElementsByTagName("input").size());

        HtmlForm form = page.getForms().get(0);
        HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input","type","submit");

        HtmlTextInput input = (HtmlTextInput) page.getHtmlElementById("query");
        input.setValueAttribute("htmlunit");

        HtmlPage result = submit.click();
        System.out.println("result text title: "+result.getTitleText());
        DomNodeList<DomNode> data = result.querySelectorAll(".im-header");
        System.out.println("number of query result: "+data.size());

        System.out.println(data.get(0).asNormalizedText());
    }
}
