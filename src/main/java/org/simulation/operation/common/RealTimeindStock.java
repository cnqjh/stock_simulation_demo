package org.simulation.operation.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simulation.operation.domain.RealTimeStock;

public class RealTimeindStock {

    public static final String SINA_URL_TODAY = "http://hq.sinajs.cn/list=";
    public static final String DAY_K = "http://image.sinajs.cn/newchart/min/n/";
    public static final String WEEK_K = "http://image.sinajs.cn/newchart/weekly/n/";
    public static final String MIN_K = "http://image.sinajs.cn/newchart/min/n/";
    public static final String MONTH_K ="http://image.sinajs.cn/newchart/monthly/n/";
	public List<RealTimeStock> getRealTimeindStock(String stockCode) {
		List<RealTimeStock> list = new ArrayList<RealTimeStock>();      
        String httpUrl = SINA_URL_TODAY  + stockCode;
        BufferedReader reader = null;

        try {
        	URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "GBK"));
            String strRead = null;
    	    /**0：”大秦铁路”，股票名字； 1：”27.55″，今日开盘价； 2：”27.25″，昨日收盘价； 
    	     * 3：”26.91″，当前价格；4：”27.55″，今日最高价； 5：”26.20″，今日最低价； 
    	     * 6：”26.91″，竞买价，即“买一”报价；7：”26.92″，竞卖价，即“卖一”报价； 
    	     * 8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百； 
    	     * 9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万； 
    	     * 10：”4695″，“买一”申请4695股，即47手；11：”26.91″，“买一”报价；12：”57590″，“买二” 
    	     * 13：”26.90″，“买二” 14：”14700″，“买三”15：”26.89″，“买三” 16：”14300″，“买四” 
    	     * 17：”26.88″，“买四” 18：”15100″，“买五” 19：”26.87″，“买五” 
    	     * 20：”3100″，“卖一”申报3100股，即31手； 
    	     * 21：”26.92″，“卖一”报价(22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况” 
    	     * 30：”2008-01-11″，日期； 31：”15:05:32″，时间；*/
            while ((strRead = reader.readLine()) != null) {
                String stockInfo[] = strRead.trim().split(",");
                RealTimeStock sd = new RealTimeStock();
               sd.setId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+stockCode);
                sd.setCode(stockCode);
                String dayK= DAY_K+stockCode+".gif";
                sd.setDayK(dayK);
                String monthK=MONTH_K+stockCode+".gif";
                sd.setMonthK(monthK);
                String minK=MIN_K+stockCode+".gif";
                sd.setMinK(minK);
                String weekK=WEEK_K+stockCode+".gif";
                sd.setWeekK(weekK);
                String StockName[] = stockInfo[0].split("\"");
                sd.setName(StockName[1]);
                sd.setOpen(stockInfo[1]);
                sd.setLastClose(stockInfo[2]);
                sd.setPrice(stockInfo[3]);
                sd.setTodayHigh(stockInfo[4]);
                sd.setTodayLow(stockInfo[5]);
                sd.setCompetitiveBuyPrice(stockInfo[6]);
                sd.setCompetitiveSellPrice(stockInfo[7]);
                sd.setCount(stockInfo[8]);
                sd.setTotal(stockInfo[9]);
                sd.setBuyOneNum(stockInfo[10]);
                sd.setBuyOnePrice(stockInfo[11]);
                sd.setBuyTwoNum(stockInfo[12]);
                sd.setBuyTowPrice(stockInfo[13]);
                sd.setBuyThreeNum(stockInfo[14]);
                sd.setBuyThreePrice(stockInfo[15]);
                sd.setBuyFourNum(stockInfo[16]);
                sd.setBuyFourPrice(stockInfo[17]);
                sd.setBuyFiveNum(stockInfo[18]);
                sd.setBuyFivePrice(stockInfo[19]);
                sd.setSellOneNum(stockInfo[20]);
                sd.setSellOnePrice(stockInfo[21]);
                sd.setSellTwoNum(stockInfo[22]);
                sd.setSellTowPrice(stockInfo[23]);
                sd.setSellThreeNum(stockInfo[24]);
                sd.setSellThreePrice(stockInfo[25]);
                sd.setSellFourNum(stockInfo[26]);
                sd.setSellFourPrice(stockInfo[27]);
                sd.setSellFiveNum(stockInfo[28]);
                sd.setSellFivePrice(stockInfo[29]);
                sd.setDate(stockInfo[30]);
                sd.setTime(stockInfo[31]);
                list.add(sd);
            }
            reader.close();

        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;

	}
}
