/**
 *
 */
package com.pinokiwo.statistics;

/**
 * @author koba
 *
 */
public class HistogramBeans {

	private Double bin_width;
	private Double bin_max;
	private Double bins;
	private Double bin_min;


	public Double getBin_min() {
		return bin_min;
	}
	public void setBin_min(Double bin_min) {

		this.bin_min = bin_min;
		if(bin_min!=null && bin_min<0)
			throw new AssertionError("must be bin_min>=0");

	}
	public Double getBin_width() {
		return bin_width;
	}
	public void setBin_width(Double binWidth) {

		if(binWidth!=null && binWidth<0)
			throw new AssertionError("must be bin_width>=0");

		bin_width = binWidth;
	}
	public Double getBin_max() {
		return bin_max;
	}
	public void setBin_max(Double binMax) {

		if(binMax!=null && binMax<0)
			throw new AssertionError("must be bin_max>=0");

		bin_max = binMax;
	}
	public Double getBins() {
		return bins;
	}
	public void setBins(Double bins) {

		if(bins!=null && bins<0)
			throw new AssertionError("must be bins>=0");

		this.bins = bins;
	}


}
