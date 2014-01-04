/**
 *
 */
package com.pinokiwo.statistics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

/**
 * @authsor koba
 *
 */
public class HistogramUtil {


	private static final double default_width = 5.0d;  //binのデフォルト幅
	private static final double default_bins = 10.0d;    //binのデフォルトの数
	private static final double default_min = 0d;	//ヒストグラムの最小値

	/**
	 * @param hist
	 * @return
	 */
	public static String createHistgramCSV(Map<Double, Map<String,Object>> hist) {

		Iterator<Double> it = hist.keySet().iterator();

		StringBuffer sb = new StringBuffer();
		sb.append("\"階級\",\"階級値\",\"度数\",\"相対度数\",\"累積度数\",\"累積相対度数\"\r\n");
		while(it.hasNext()){
			Double key = it.next();
			Map<String,Object> value = hist.get(key);
			sb.append(
					value.get("interval")+","+key+","+
					value.get("heights")+","+value.get("density")+","+
					value.get("sumHeights")+","+value.get("sumDensity")+"\r\n");
		}
		return sb.toString();
	}

	/**
	 * 統計量のCSV表記
	 * @param list
	 * @return
	 */
	public static String createStatisticsCSV(List<Double> list){

		DescriptiveStatistics ds = createStat(list);

		StringBuffer sb = new StringBuffer();
		sb.append("\"最大値\",\"最小値\",\"合計\",\"平均値\",\"標準偏差\",\"歪度\",\"尖度\"\r\n");
		sb.append(ds.getMax()+",");
		sb.append(ds.getMin()+",");
		sb.append(ds.getSum()+",");
		sb.append(ds.getMean()+",");
		sb.append(ds.getStandardDeviation()+",");
		sb.append(ds.getSkewness()+",");
		sb.append(ds.getKurtosis()+"\r\n");

		return sb.toString();
	}

	/**
	 * 階級値の算出
	 * @param bin_width
	 * @param bin
	 * @return
	 */
	public static double getClassValue(double bin_width, double bin){

		return Math.ceil( bin_width/2.0d + bin);

	}

	/**
	 * 統計量の算出
	 * @param list
	 * @return
	 */
	public static DescriptiveStatistics createStat(List<Double> list){
		DescriptiveStatistics ds = new DescriptiveStatistics();

		for(Double obj: list){
			ds.addValue(obj);
		}
		return ds;
	}

	/**
	 * ヒストグラム作図に必要な基礎データを生成
	 * @param list
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static HistogramBeans createHistogramBeans(List<Double> list)
	throws InvalidHistogramException{

		DescriptiveStatistics ds = createStat(list);

		HistogramBeans hb = new HistogramBeans();


		//棒の幅
		double bin_width = (ds.getMax()-default_min)/default_bins;

		//ヒストグラムの最大値
		double bin_max =( default_bins * bin_width > ds.getMax()) ? (default_bins * bin_width) : ds.getMax();

		//ヒストグラムの最小値
		double bin_min = ds.getMin();

		bin_width = Math.ceil(bin_width);
		bin_max = Math.ceil(bin_max);
		bin_min = Math.floor(bin_min);

		hb.setBin_width(bin_width);
		hb.setBins(default_bins);
		hb.setBin_max(bin_max);
		hb.setBin_min(default_min);

		//境界値補正
		hb = boundaryCorrect(hb);

		return hb;

	}

	/**
	 * ヒストグラムの基礎データの境界値補正をする
	 * @param hb
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static HistogramBeans boundaryCorrect(HistogramBeans hb)
	throws InvalidHistogramException {


		if( ! (hb.getBin_width() > 0d && hb.getBin_max() > 0d
				&& hb.getBins() != java.lang.Double.NaN ) ) {

			if( hb.getBin_width() == 0d ){
				if( hb.getBin_max() > 0d) {
					//全データが同一数値のとき

					hb.setBin_width(default_width);
					hb.setBins(Math.ceil(hb.getBin_max()/default_width));

				} else if ( hb.getBin_max() == 0d ) {
					//全データの数値が0のとき

					hb.setBin_width(default_width);
					hb.setBin_max(default_width*default_bins);
					hb.setBins(default_bins);

				}
			} else if (hb.getBin_width() > 0d){
				if ( hb.getBin_max() == 0d )
				//全データの数値が0のとき

					throw new InvalidHistogramException(
							"不整合データ:"+hb.getBin_width()+","+hb.getBin_max()+","+hb.getBins());
			}

		}
		return hb;

	}
	/**
	 * ヒストグラムデータを作成
	 * @param list
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static Map<Double,Map<String,Object>> createHistgramMap(List<Double> list)
	throws InvalidHistogramException{


		TreeMap<Double,Map<String,Object>> hist = new TreeMap<Double,Map<String,Object>>();

		if(list==null||list.isEmpty())
			return hist;

		HistogramBeans hb =  createHistogramBeans(list);

		//initialize
		for(double bin = hb.getBin_min(); bin <= hb.getBin_max(); bin = bin+hb.getBin_width()){

			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("interval", bin+" 以上～"+(bin+hb.getBin_width()+" 未満"));
			map.put("heights", new Double(0d));
			map.put("sumHeights", new Double(0d));
			map.put("density", new Double(0.0d));
			map.put("sumDensity", new Double(0.0d));

			hist.put(getClassValue(hb.getBin_width(), bin),map);

		}

		//make histogram data
		for(double bin = hb.getBin_min(); bin <= hb.getBin_max(); bin = bin+hb.getBin_width()){

			for(Double obj: list){

				if(bin<=obj && obj<bin+hb.getBin_width()){
					Map<String,Object> map = hist.get(getClassValue(hb.getBin_width(), bin));
					double heights=(Double)map.get("heights");
					double density = (Double)map.get("density");

					heights=heights+1d;
					density = heights/(double)list.size();

					map.put("heights", heights);
					map.put("density", density);

					hist.put(getClassValue(hb.getBin_width(), bin), map);

				}
			}
		}


		Iterator<Double> it = hist.keySet().iterator();

		Double preHeights = 0d;
		Double preDensity = 0d;

		while(it.hasNext()){
			Double key = it.next();
			Map<String,Object> value = hist.get(key);

			preHeights = preHeights+(Double)value.get("heights");
			value.put("sumHeights", preHeights);

			preDensity = preDensity+(Double)value.get("density");
			value.put("sumDensity",preDensity);

			hist.put(key, value);

		}

		return hist;
	}

	public static Map<Double,Map<String,Object>> createHistgramLogMap(List<Double> list)
	throws InvalidHistogramException{


		TreeMap<Double,Map<String,Object>> hist = new TreeMap<Double,Map<String,Object>>();

		if(list==null||list.isEmpty())
			return hist;

		HistogramLogBeans hb =  createHistogramLogBeans(list);
		List<Double> hb_list = hb.getBin_width_list();
		//initialize
		for(int i=0;i<hb_list.size();i++){
			if(i==hb_list.size()-1){
				break;
			}
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("interval", hb_list.get(i)+" 以上～"+(hb_list.get(i+1)+" 未満"));
			map.put("heights", new Double(0d));
			map.put("sumHeights", new Double(0d));
			map.put("density", new Double(0.0d));
			map.put("sumDensity", new Double(0.0d));

			hist.put(Math.floor((hb_list.get(i)+hb_list.get(i+1))/2.0d),map);

		}

		//make histogram data
		for(int i=0;i<hb_list.size();i++){
			if(i==hb_list.size()-1){
				break;
			}
			for(Double obj: list){

				if(hb_list.get(i)<=obj && obj<hb_list.get(i+1)){
					Map<String,Object> map = hist.get(Math.floor((hb_list.get(i)+hb_list.get(i+1))/2.0d));
					double heights=(Double)map.get("heights");
					double density = (Double)map.get("density");

					heights=heights+1d;
					density = heights/(double)list.size();

					map.put("heights", heights);
					map.put("density", density);

					hist.put(Math.floor((hb_list.get(i)+hb_list.get(i+1))/2.0d), map);

				}
			}
		}


		Iterator<Double> it = hist.keySet().iterator();

		Double preHeights = 0d;
		Double preDensity = 0d;

		while(it.hasNext()){
			Double key = it.next();
			Map<String,Object> value = hist.get(key);

			preHeights = preHeights+(Double)value.get("heights");
			value.put("sumHeights", preHeights);

			preDensity = preDensity+(Double)value.get("density");
			value.put("sumDensity",preDensity);

			hist.put(key, value);

		}

		return hist;
	}
	/**
	 * ヒストグラム作図に必要な基礎データを生成
	 * @param list
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static HistogramLogBeans createHistogramLogBeans(List<Double> list)
	throws InvalidHistogramException{

		DescriptiveStatistics ds = createStat(list);

		HistogramLogBeans hb = new HistogramLogBeans();

		hb.setBin_max(ds.getMax());
		hb.setBin_min(ds.getMin());

		return hb;

	}

}
