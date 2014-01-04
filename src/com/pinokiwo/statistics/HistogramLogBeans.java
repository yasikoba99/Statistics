/**
 *
 */
package com.pinokiwo.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koba
 *
 */
public class HistogramLogBeans {

	private Double bin_width;
	private Double bin_max;
	private Double bin_min;
	private List<Double> bin_list=new ArrayList<Double>();

	public Double getBin_min() {
		return bin_min;
	}
	public void setBin_min(Double bin_min) {

		this.bin_min = bin_min;
		if(bin_min!=null && bin_min<0)
			throw new AssertionError("must be bin_min>=0");

	}
	public List<Double> getBin_width_list() {
		return bin_list;
	}
	public Double getBin_max() {
		return bin_max;
	}
	public void setBin_max(Double binMax) {

		if(binMax!=null && binMax<0)
			throw new AssertionError("must be bin_max>=0");

		bin_list.clear();
		bin_list.add(0.0d);
		
		Double sqrt=Math.sqrt(2.0d);
		bin_width=1d;
		while(bin_width<binMax){
			if(!bin_list.contains(Math.ceil(bin_width))){
				bin_list.add(Math.ceil(bin_width));
			}
			bin_width=bin_width*sqrt;
		}
		if(!bin_list.contains(Math.ceil(bin_width))){
			bin_list.add(Math.ceil(bin_width));
		}
		bin_max = binMax;
	}

}
