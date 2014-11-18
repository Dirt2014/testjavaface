/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frame;

import static com.googlecode.javacv.cpp.opencv_contrib.*;
import com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.core.Core;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author SONY
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Face");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jButton1.setText("Capture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Start");
        jButton4.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        jMenuItem3.setText("jMenuItem3");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    String File_path="";
    class DaemonThread implements Runnable
    {
    protected volatile boolean runnable = false;

    @Override
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                if(webSource.grab())
                {
		    	try
                        {
                            webSource.retrieve(frame);
			    Highgui.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=jPanel1.getGraphics();

			    if (g.drawImage(buff, 0, 0, getWidth(), getHeight() -150 , 0, 0, buff.getWidth(), buff.getHeight(), null))
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
			    }
			 }
			 catch(Exception ex)
                         {
			    
                         }
                }
            }
        }
     }
   }
 
    class WebCamFaceDetect {
        int a=0,b=0,c=0,d=0;
     public void run() throws Exception{
		    System.out.println("\nRunning DetectFaceDemo");

  //CascadeClassifier faceDetectorClassifier = new CascadeClassifier("C:/opencv/data/lbpcascades/lbpcascade_frontalface.xml");
  //CascadeClassifier faceDetectorClassifier = new CascadeClassifier("../cascades/lbpcascade_frontalface.xml");
    CascadeClassifier faceDetectorClassifier = 
                new CascadeClassifier("E:\\opencv-2.4.10\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_default.xml");
		  

      Mat frame = new Mat();
      VideoCapture webcam = new VideoCapture(0); //Assuming that webcam will be device '0'
            
    //Pause
      Thread.sleep(500);   // 0.5 -> 1 sec of a delay. This is not obvious but its necessary
	                   // as the camera simply needs time to initialize itself
	          
     if(!webcam.isOpened()){
              System.out.println("Did not connect to camera");
        }else 
              System.out.println("found webcam: "+ webcam.toString());
	         
    //grab a frame  from the web-cam        
     webcam.retrieve(frame);  
     System.out.println("Captured image with "+ frame.width()+ " pixels wide by " + frame.height() + " pixels tall.");
     Highgui.imwrite("webcam_face.jpg", frame);	         
    //Now I'm finished with the webcam
	          
		    
    // Now detect the face in the image.
    // MatOfRect is a special container class for Rect.
	MatOfRect faceDetections = new MatOfRect();
       faceDetectorClassifier.detectMultiScale(frame, faceDetections); //detectMultiScale will perform the detection
       System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

     // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
		   Core.rectangle(frame,  //where to draw the box
		    new Point(rect.x, rect.y),   //bottom left
		    new Point(rect.x + rect.width, rect.y + rect.height), //top right 
		    new Scalar(255, 0, 0)); //RGB colour
                    a=rect.x;b=rect.y;c=rect.width;d=rect.height;
         }
	 System.out.println("Bounding boxes drawn");

	// Save the visualized detection.
	   String filename = "E:\\TestImage\\test.jpg";
	   Highgui.imwrite(filename, frame);
	   System.out.println("Writing: " + filename);
	   webcam.release();
	   }
  }
   public class Imagecut {

    private String srcpath ;
    private String subpath ;
    private int x ;
    
    private int y ;    
    private int width ;
     
    private int height ;
    
    public Imagecut(){
            
    }  
    public Imagecut(int x,int y,int width,int height){
         this.x = x ;
         this.y = y ;
         this.width = width ;   
         this.height = height ;
    }
    
    public void cut() throws IOException{ 
         
        FileInputStream is = null ;
        ImageInputStream iis =null ;
     
        try{   
        
            is = new FileInputStream(srcpath); 
            
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");  
            ImageReader reader = it.next(); 
            iis = ImageIO.createImageInputStream(is);
            reader.setInput(iis,true) ;
            ImageReadParam param = reader.getDefaultReadParam(); 
            Rectangle rect = new Rectangle(x, y, width, height); 
            param.setSourceRegion(rect); 

            BufferedImage bi = reader.read(0,param);                
            ImageIO.write(bi, "jpg", new File(subpath));     
        }
        
        finally{
            if(is!=null)
               is.close() ;       
            if(iis!=null)
               iis.close();  
        } 
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSrcpath() {
        return srcpath;
    }

    public void setSrcpath(String srcpath) {
        this.srcpath = srcpath;
    }

    public String getSubpath(){
        return subpath;
    }

    public void setSubpath(String subpath){
        this.subpath = subpath;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }  
   }
   
   public class Imagechange {  
    String fromFileStr;  
    String saveToFileStr;  
    String sysimgfile;  
    int width;  
    int height;  
    String suffix;  
    /** 
     * @param fromFileStr 
     * @param saveToFileStr 
     * @param sysimgfilenNow 
     */  
    public Imagechange(String fromFileStr, String saveToFileStr, String sysimgfile,String suffix,int width,int height) {  
        this.fromFileStr = fromFileStr;  
        this.saveToFileStr = saveToFileStr;  
        this.sysimgfile = sysimgfile;  
        this.width=width;  
        this.height=height;  
        this.suffix=suffix;  
    }  
    public boolean createThumbnail() throws Exception {  
   
        double Ratio = 0.0;  
        File F = new File(fromFileStr);  
        if (!F.isFile())  
            throw new Exception(F  
                    + " is not image file error in CreateThumbnail!");  
        File ThF = new File(saveToFileStr, sysimgfile +"."+suffix);  
        BufferedImage Bi = ImageIO.read(F);  
        Image Itemp = Bi.getScaledInstance(width, height, Bi.SCALE_SMOOTH);  
        if ((Bi.getHeight() > width) || (Bi.getWidth() > height)) {  
            if (Bi.getHeight() > Bi.getWidth())  
                Ratio = (double)width / Bi.getHeight();  
            else  
                Ratio = (double)height / Bi.getWidth();  
        }  
        AffineTransformOp op = new AffineTransformOp(AffineTransform  
                .getScaleInstance(Ratio, Ratio), null);  
        Itemp = op.filter(Bi, null);  
        try {  
            ImageIO.write((BufferedImage) Itemp, suffix, ThF);  
        } catch (Exception ex) {  
            throw new Exception(" ImageIo.write error in CreatThum.: "  
                    + ex.getMessage());  
        }  
        return (true);  
    }
   }

    public class FaceRecognize {
   
        String trainingDir = "E:\\TrainImage";// store original photo
        IplImage testImage = cvLoadImage("E:\\TestImage\\test.jpg");// store snap photo
        FilenameFilter jpgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        };
        File root = new File(trainingDir);
        File[] imageFiles = root.listFiles(jpgFilter);
        MatVector images = new MatVector(imageFiles.length);
        int[] labels = new int[imageFiles.length];
        int counter = 0;
        int label;
        IplImage img;
        IplImage grayImg;
        void face(){
        for (File image : imageFiles) {
            img = cvLoadImage(image.getAbsolutePath());
            label = Integer.parseInt(image.getName().split("\\-")[0]);
            grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
            cvCvtColor(img, grayImg, CV_BGR2GRAY);
            images.put(counter, grayImg);
            labels[counter] = label;
            counter++;
        }
        }
            IplImage greyTestImage = IplImage.create(testImage.width(), testImage.height(), IPL_DEPTH_8U, 1);
    }
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Imagechange UI;  
        boolean ss = false;
            try{
            System.out.println("Web Cam Face Detection with OpenCV and Harr classifier ");
	    // Load the native library.
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    WebCamFaceDetect one=new WebCamFaceDetect();
            one.run();
            int a=one.a;
            int b=one.b;
            int c=one.c;
            int d=one.d;
            String name = "E:\\TestImage\\test.jpg"; 
            Imagecut o = new Imagecut(a,b,c,d);
            o.setSrcpath(name);  
            o.setSubpath("E:\\2.jpg"); // store cut photo
            o.cut() ;
            UI = new Imagechange("E://2.jpg", "E://", "ps_low1","jpg",10,250); //  store inlarge photo  height determines scale
            ss = UI.createThumbnail();
            
            //FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
            //FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
            FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();
            FaceRecognize two=new FaceRecognize();
            two.face();
            faceRecognizer.train(two.images, two.labels);

            cvCvtColor(two.testImage, two.greyTestImage, CV_BGR2GRAY);

            int predictedLabel = faceRecognizer.predict(two.greyTestImage);

            System.out.println("Predicted label: " + predictedLabel);
            
  
            myThread.runnable = false;
            jButton1.setEnabled(false);
            jButton4.setEnabled(true);
            webSource.release();
            
            }
            catch(Exception ex){
                
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            webSource =new VideoCapture(0);
            myThread = new DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
            jButton4.setEnabled(false);
            jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                        
                }
                catch (Exception ex)
                {
                        System.out.println("Failed loading L&F: ");
                        System.out.println(ex);
                        System.out.println("Loading default Look & Feel Manager!");
                }
                new NewJFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
