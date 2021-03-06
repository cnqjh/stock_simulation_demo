package org.simulation.operation.common;

import java.util.ArrayList;
import java.util.List;

/*
 * 由于java没有现成的包可以直接得出某只股票的波动率指标、短期和长期均线指标等指标，
 * 由于一些指标在网上没有找到，例如动量和反转指标：REVS5，就用了动量指标MTM。
 * 因此在百度百科等资料中搜集了一些公式， 分别对这些公式编写代码，就能观测到的数据来说，是准确的。
 */
public class Methods {
    //搜狗百科：A=（今日最高+今日最低）/2;B=（前日最高+前日最低）/2;C=今日最高-今日最低;2.EM=（A-B）*C/今日成交额;3.EMV=N日内EM的累和;4.MAEMV=EMV的M日简单移动平均.参数N为14，参数M为9
    public List<Double> EMV(List<Double> highPrice, List<Double> lowPrice, List<Double> vol) {
        List<Double> EM = new ArrayList<Double>();
        for (int i = 2; i < highPrice.size(); i++) {
            double A = (highPrice.get(i) + lowPrice.get(i)) / 2;
            double B = (highPrice.get(i - 2) + lowPrice.get(i - 2)) / 2;
            double C = highPrice.get(i) - lowPrice.get(i);
            EM.add(((A - B) * C) / vol.get(i));
        }

        List<Double> EMV = new ArrayList<Double>();
        //取N为14，即14日的EM值之和；M为9，即9日的移动平均
        int N = 14;
        int M = 9;
        for (int i = N; i < EM.size() + 1; i++) {
            //14日累和
            double sum = 0;
            for (int j = i - N; j < i; j++) {
                sum += EM.get(j);
            }
            EMV.add(sum);
        }

        List<Double> MAEMV = new ArrayList<Double>();
        for (int i = M; i < EMV.size() + 1; i++) {
            //9日移动平均
            double sum = 0;
            for (int j = i - M; j < i; j++) {
                sum += EMV.get(j);
            }
            sum = sum / M;
            MAEMV.add(sum);
        }
        return MAEMV;
    }

    //EMA＝（当日或当期收盘价－上一日或上期EXPMA）／Ｎ＋上一日或上期EXPMA，其中，首次上期EXPMA值为上一期收盘价，Ｎ为天数。 
    public List<Double> EMA5(List<Double> overPrice) {
        //取20121118年收盘价为初始EXPMA
        List<Double> EMA5 = new ArrayList<Double>();
        for (int i = 0; i < 5; i++) {
            EMA5.add(overPrice.get(i));
        }
        for (int i = 5; i < overPrice.size(); i++) {
            EMA5.add((overPrice.get(i) - EMA5.get(i - 5)) / 5 + EMA5.get(i - 5));

        }
        return EMA5;
    }


    public List<Double> EMA60(List<Double> overPrice) {
        //取20121118年收盘价为初始EXPMA
        List<Double> EMA60 = new ArrayList<Double>();
        for (int i = 0; i < overPrice.size(); i++) {
            EMA60.add(overPrice.get(i));
        }
        for (int i = 60; i < overPrice.size(); i++) {
            EMA60.add((overPrice.get(i) - EMA60.get(i - 60)) / 60 + EMA60.get(i - 60));
        }
        return EMA60;
    }

    //5日均线
    public List<Double> MA5(List<Double> overPrice) {
        List<Double> MA5 = new ArrayList<Double>();
        for (int i = 5; i < overPrice.size() + 1; i++) {
            double sum = 0;
            for (int j = i - 1; j >= i - 5; j--) {
                sum += overPrice.get(j);
            }
            sum = sum / 5;
            MA5.add(sum);
        }
        return MA5;
    }


    //60日均线
    public List<Double> MA60(List<Double> overPrice) {
        List<Double> MA60 = new ArrayList<Double>();
        for (int i = 60; i < overPrice.size() + 1; i++) {
            double sum = 0;
            for (int j = i - 1; j >= i - 60; j--) {
                sum += overPrice.get(j);
            }
            sum = sum / 60;
            MA60.add(sum);
        }
        return MA60;
    }

    //动量指标MTM，1.MTM=当日收盘价-N日前收盘价；2.MTMMA=MTM的M日移动平均；3.参数N一般设置为12日参数M一般设置为6，表中当动量值减低或反转增加时，应为买进或卖出时机
    public List<Double> MTM(List<Double> overPrice) {
        List<Double> MTM = new ArrayList<Double>();
        List<Double> MTMlist = new ArrayList<Double>();
        int N = 12;
        int M = 6;
        for (int i = 12; i < overPrice.size(); i++) {
            MTM.add(overPrice.get(i) - overPrice.get(i - 12));
        }

        //移动平均参数为6
        for (int i = 6; i < MTM.size() + 1; i++) {
            double sum = 0;
            for (int j = i - 1; j >= i - 6; j--) {
                sum += MTM.get(j);
            }
            sum = sum / 6;
            MTMlist.add(sum);
        }
        return MTMlist;
    }


    //百度百科：http://baike.baidu.com/link?url=XQf2I-JIyNR1AEM_EnMnuU90U1vmJDoXukUe1fQVsBA1Y_fqAA8dj7DoxLCoh5U-YysBkVT5aIZLXeG2g1snoK：量能指标就是通过动态分析成交量的变化,
    public List<Double> MACD(List<Double> vol) {
        int shortN = 12;
        List<Double> Short = new ArrayList<Double>();
        for (int i = shortN; i < vol.size() + 1; i++) {
            Short.add(2 * vol.get(i - 1) + (shortN - 1) * vol.get(i - shortN));
        }
        int longN = 26;
        List<Double> Long = new ArrayList<Double>();
        for (int i = longN; i < vol.size() + 1; i++) {
            Long.add(2 * vol.get(i - 1) + (longN - 1) * vol.get(i - longN));
        }

        //    取两个序列中较短序列的长度
        int length = 0;
        if (Short.size() > Long.size()) {
            length = Long.size();
        } else {
            length = Short.size();
        }

        List<Double> DIFF1 = new ArrayList<Double>();
        for (int i = length - 1; i >= 0; i--) {
            DIFF1.add(Short.get(i) - Long.get(i));
        }
        List<Double> DIFF = new ArrayList<Double>();
        for (int i = 0; i < DIFF1.size(); i++) {
            DIFF.add(DIFF1.get(DIFF1.size() - i - 1));
        }
        List<Double> DEA = new ArrayList<Double>();
        for (int i = 0; i < DIFF.size() - 1; i++) {
            DEA.add(2 * DIFF.get(i + 1) + (9 - 1) * DIFF.get(i));
        }

        List<Double> MACD = new ArrayList<Double>();
        for (int i = 1; i < DIFF.size(); i++) {
            MACD.add(DIFF.get(i) - DEA.get(i - 1));
        }
        return MACD;
    }


    //能量指标：CR，见百度百科：http://baike.baidu.com/link?url=v5yYFep6wZioav0P-LOruuhkzjho6PqzQqfEBj5TYQLfaadLSADSQVl0njP7k1zY78KJMoBFrE4OO4wYolZXbMnRRQi7U66R0X2jeSV3ZoXKeuG2zEbqEqP4CnyiF7j6
    public List<Double> CR5(List<Double> overPrice, List<Double> highPrice, List<Double> lowPrice, List<Double> openPrice) {
        List<Double> YM = new ArrayList<Double>();
        List<Double> HYM = new ArrayList<Double>();
        List<Double> YML = new ArrayList<Double>();
        List<Double> CR = new ArrayList<Double>();
        for (int i = 0; i < overPrice.size(); i++) {
            YM.add((highPrice.get(i) + overPrice.get(i) + lowPrice.get(i) + openPrice.get(i)) / 4);
        }
        //p1表示5日以来多方力量总和，p2表示5日以来空方力量总和
        for (int i = 6; i < highPrice.size() + 1; i++) {
            double sum = 0;
            for (int j = i - 1; j >= i - 5; j--) {
                sum += highPrice.get(j) - YM.get(j - 1);
            }
            HYM.add(sum);
        }
        //p2表示5日以来空方力量总和，p2表示5日以来空方力量总和
        for (int i = 6; i < lowPrice.size() + 1; i++) {
            double sum = 0;
            for (int j = i - 1; j >= i - 5; j--) {
                sum += YM.get(j - 1) - lowPrice.get(j);
            }
            YML.add(sum);
        }
        for (int i = 0; i < YML.size(); i++) {
            double temp = (double) HYM.get(i) / YML.get(i);
            if (temp < 0) {
                CR.add((double) 0);
            } else {
                CR.add(temp);
            }

        }
        return CR;


    }

    public double[][] bpTrain(List<Double> overPrice, List<Double> highPrice, List<Double> lowPrice, List<Double> openPrice, List<Double> vol) {
        List<Double> EMV = EMV(highPrice, lowPrice, vol);
        List<Double> EMA5 = EMA5(overPrice);
        List<Double> EMA60 = EMA60(overPrice);
        List<Double> MA5 = MA5(overPrice);
        List<Double> MA60 = MA60(overPrice);
        List<Double> MTM = MTM(overPrice);
        List<Double> MACD = MACD(vol);
        List<Double> CR5 = CR5(overPrice, highPrice, lowPrice, openPrice);

        int length = 0;
        if (EMA60.size() > MA60.size()) {
            length = MA60.size();
        } else {
            length = EMA60.size();
        }
        List<ArrayList<Double>> datalist = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < length; i++) {
            ArrayList<Double> list = new ArrayList<Double>();
            //list.add(EMV.get(EMV.size()-length+i));
            list.add(EMA5.get(EMA5.size() - length + i));
            list.add(EMA60.get(EMA60.size() - length + i));
            list.add(MA5.get(MA5.size() - length + i));
            list.add(MA60.get(MA60.size() - length + i));
            list.add(MTM.get(MTM.size() - length + i));
            //        list.add(MACD.get(MACD.size()-length+i));
            list.add(CR5.get(CR5.size() - length + i));
            datalist.add(list);
        }
        double[][] data = new double[datalist.size()][6];
        for (int i = 0; i < datalist.size(); i++) {
            for (int j = 0; j < 6; j++) {
                data[i][j] = datalist.get(i).get(j);
                System.out.print(data[i][j] + "  ");
            }
            System.out.println();
        }
        return data;
    }

}
