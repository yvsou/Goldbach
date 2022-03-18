/*    
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 * [JFreeChart : a free chart library for the Java(tm) platform 
 *  Project Info:  * http://www.jfree.org/jfreechart/index.html.]
 *
 * ---------
 *goldbachmappingcurve.java
 * ---------
 * (C) Copyright 2022-2022, by Hangzhou Domain Zones Technology Co., Ltd. and Contributors.
 *
 * Original Author:  Lican Huang (Hangzhou Domain Zones Technology Co., Ltd.);
 * Contributor(s):    
 *
 */

package goldbachmapping;
 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
public class goldbachmappingcurve extends ApplicationFrame{ 
   static int batch =100;	 
   public static goldbachlinearmapping  gdmapping = null; 
   public goldbachmappingcurve(String title,int i) { 
   super(title);   
   JFreeChart chart = this.getChart(i);  
} 
  
public static void main(String[] args) { 
   // TODO Auto-generated method stub 
   gdmapping = new goldbachlinearmapping();
   gdmapping.goldbachmappingmain(args);
	  
   int n = gdmapping.primegap.length /batch;
	 
   for (int i =0; i<=n;i++) {
      goldbachmappingcurve demo = new goldbachmappingcurve("XYFittingCurve",i); 
      demo.pack(); 
      RefineryUtilities.centerFrameOnScreen(demo); 
      //demo.setVisible(true); 
      demo.setVisible(false); 
	}
	System.out.print("finished!" );
	 
	System.exit(0);
} 
  
 
public JFreeChart getChart(int n){ 
  
  XYDataset xydataset = this.getXYDataset(n); 
 
  JFreeChart xyChart = ChartFactory.createXYLineChart( 
  " ", " ", " ", xydataset, PlotOrientation.VERTICAL, true, true, false); 
  
  try {
	 OutputStream os_png;
	 String pngfilename = gdmapping.wbfilenameprex+"_"+n+".png";
	 os_png = new FileOutputStream(pngfilename);
	 ChartUtilities.writeChartAsPNG(os_png, xyChart, 500, 270);
  } catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	 e.printStackTrace();
  } catch (IOException e) {
	// TODO Auto-generated catch block
	 e.printStackTrace();
 }
   
 return xyChart; 
} 
  
 
public XYDataset getXYDataset(int n) { 
	 
   	 
 int begin = n*batch;
 int end =  n*batch+batch-1;
 if (end > gdmapping.primegap.length)
	 end = gdmapping.primegap.length;
 
 XYSeries s1 = new XYSeries("prime gap curve"); 
 for(int i=begin; i<end; i++){ 
    s1.add(i,gdmapping.primegap[i]); 
 } 
 
 
 XYSeries s2 = new XYSeries("Zerocounts"); 
 
 for(int i=begin; i<end ; i++){ 
	 s2.add(i,gdmapping.zerocountsarr[i]); 
 } 
  
 
 XYSeries s3 = new XYSeries("preprimezerocounts"); 
 for(int i=begin; i<end; i++){ 
	 s3.add(i,gdmapping.preprimezerocountsarr[i]); 
 } 
 
 XYSeries s4 = new XYSeries("pre2primezerocounts"); 
 for(int i=begin; i<end; i++){ 
	 s4.add(i,gdmapping.pre2primezerocountsarr[i]); 
 } 
 
 XYSeries s5 = new XYSeries("pre3primezerocounts"); 
 for(int i=begin; i<end; i++){ 
	 s5.add(i,gdmapping.pre3primezerocountsarr[i]); 
 } 
 
 XYSeriesCollection dataset = new XYSeriesCollection(); 
 dataset.addSeries(s1); 
 dataset.addSeries(s2); 
 dataset.addSeries(s3); 
 dataset.addSeries(s4); 
 dataset.addSeries(s5);
 return dataset; 
  
 } 
    
}
