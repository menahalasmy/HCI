package hcipackage;

//import java.awt.AWTException;
//import java.awt.*;

//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
//import java.awt.Robot;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;



import com.smardec.mousegestures.MouseGestures;
import com.smardec.mousegestures.MouseGesturesListener;


 
public class Desktop2  implements MouseListener,MouseGesturesListener,MouseMotionListener, ActionListener{
	 private MouseGestures mouseGestures = new MouseGestures();
	 int clickedIcon ;
	 String iconRegion ;
	  //  private JLabel statusLabel = new JLabel("Mouse gesture: ");
	    StringBuffer stringBuffer;
	    boolean finished = false;
	    int index;
		int mx,my;
		boolean mouseDragged;
		Image dbImage;
		Graphics dpg;
		Boolean press =true;
		Boolean iconDrag = false;
		//int mx,my;
		JButton p;
		Region rclicked;
		JButton xx ;
		boolean clicked =false;
		Region cloud = new Region("cloud",State.Hidden);
		Region pond = new Region("pond",State.default_state);
		Region box = new Region("box",State.Hidden);
		Region bin = new Region("bin",State.Hidden);
		Region tree = new Region("tree",State.default_state);
		Region path = new Region("path",State.default_state);
		Region others = new Region("others",State.default_state);
		JButton iconPressed;
		//definePositions();
		// to check navigation mode in all regions
	 Boolean nav = false;
	 Boolean newDisplay=false;
	 Boolean drag  = false;
	private ArrayList<JButton> temp_collapse;
	 String dragOnRegion="";
	 int x, y;
	 BufferedImage img ;
	 JLabel label;
	 JFrame frame;
	 private ArrayList<JButton> icons;
	 private ArrayList<Point> cloudPoints;
	 private ArrayList<Point> treePoints;
	 private ArrayList<Point> pathPoints;

	 private ArrayList<Point> pondPoints;
		int zipflag;
		JButton zipped;
		boolean zipping ,unzipping;
		ArrayList<JButton> filesTozip;
		ArrayList<ArrayList<JButton>> zippedfiles;
		ArrayList<ArrayList<JButton>> collapsedfiles;
		ArrayList<String> collapsedfilesr;
		ArrayList<Region> zippedfilesr;
		Region  zippedregion;

	 static String iconsPath = "/icons/";
	 
	
	   public static void main(String[] args) {
	    	
	    	new Desktop2();
	    
	    }
	 
	 public Desktop2(){
		 definePositions();
	    	try {
	    		
	    	    img = ImageIO.read(Desktop2.class.getResource("/colorsResizedF.png"));
	    	
	    	}
	    	    catch (IOException e) {
	    	}
	    	
	    	frame = new JFrame("FrameDemo");
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setTitle("Mouse Gestures Test Frame");
	    	
	    	label = new JLabel();
	    	frame.getContentPane().add(label);
	    	
	        
	    	label.setLayout(null);//desktopSized
	    	URL url = Desktop2.class.getResource("/desktopresized.png");
	    	label.setIcon(new ImageIcon(url));
	    	
	    	frame.setSize(1366,768);
	    	label.setSize(1366,768);
	    	
	    	frame.setVisible(true);
	    	label.setVisible(true);
	    	label.addMouseListener(this);
			label.addMouseMotionListener(this);
			//label.addActionListener(this);
	         
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         zippedfiles = new ArrayList<ArrayList<JButton>>();
	         collapsedfiles = new ArrayList<ArrayList<JButton>>();
	         collapsedfilesr  =new ArrayList<String>();
	         zippedfilesr  =new ArrayList<Region>();
	         // frame.addMouseListener(this);
	         initStatusBar();
	         initMouseGestures();
	         if (newDisplay ==false){
	        	 create3();
	         }
	    	frame.pack();
	 }

 
    public void definePositions(){

		cloudPoints = new ArrayList<Point>();
		cloudPoints.add(new Point(330, 20));
		cloudPoints.add(new Point(400, 20));
		cloudPoints.add(new Point(470, 20));
		cloudPoints.add(new Point(750, 20));
		cloudPoints.add(new Point(820, 20));
		cloudPoints.add(new Point(890, 20));
		cloudPoints.add(new Point(960, 20));
		cloudPoints.add(new Point(290, 100));
		cloudPoints.add(new Point(400, 100));
		cloudPoints.add(new Point(500, 100));
		cloudPoints.add(new Point(600, 100));
		cloudPoints.add(new Point(700, 100));
		cloudPoints.add(new Point(800, 100));
		cloudPoints.add(new Point(900, 100));
		cloudPoints.add(new Point(1000, 100));




		cloud.setPositions(cloudPoints);
		//System.out.println(cloud.getPositions());
		treePoints = new ArrayList<Point>();
		//treePoints.add(new Point(760, 680));

		//treePoints.add(new Point(960, 680));
		treePoints.add(new Point(1060, 290));

		treePoints.add(new Point(1115, 250));
		treePoints.add(new Point(1115, 350));
		treePoints.add(new Point(1190, 170));
		treePoints.add(new Point(1190, 270));
		treePoints.add(new Point(1190, 370));

		treePoints.add(new Point(1266, 170));
		treePoints.add(new Point(1266, 270));
		treePoints.add(new Point(1266, 370));
		treePoints.add(new Point(1266, 470));
		treePoints.add(new Point(1266, 570));
		//treePoints.add(new Point(1190, 470));

		treePoints.add(new Point(1190, 530));
		treePoints.add(new Point(1110, 550));

		treePoints.add(new Point(1040, 560));

		treePoints.add(new Point(830, 640));
		treePoints.add(new Point(900, 640));
		treePoints.add(new Point(960, 640));
		treePoints.add(new Point(1030, 640));
		treePoints.add(new Point(1110, 640));
		treePoints.add(new Point(1190, 640));

		treePoints.add(new Point(1266, 640));
		tree.setPositions(treePoints);
		// Original path points (37)
		pathPoints = new ArrayList<Point>();
		pathPoints.add(new Point(0, 440));
		pathPoints.add(new Point(0, 500));
		pathPoints.add(new Point(0, 560));
		pathPoints.add(new Point(80, 460));
		pathPoints.add(new Point(80, 530));
		pathPoints.add(new Point(80, 600));
		pathPoints.add(new Point(160, 480));
		pathPoints.add(new Point(160, 540));
		pathPoints.add(new Point(160, 610));
		pathPoints.add(new Point(230, 500));
		pathPoints.add(new Point(230, 570));
		pathPoints.add(new Point(230, 640));
		pathPoints.add(new Point(300, 500));
		pathPoints.add(new Point(300, 570));
		pathPoints.add(new Point(300, 640));
		pathPoints.add(new Point(370, 520));
		pathPoints.add(new Point(450, 530));
		pathPoints.add(new Point(540, 530));
		pathPoints.add(new Point(540, 580));
		pathPoints.add(new Point(540, 640));
		pathPoints.add(new Point(610, 500));
		pathPoints.add(new Point(610, 560));
		pathPoints.add(new Point(610, 620));
		pathPoints.add(new Point(680, 490));
		pathPoints.add(new Point(680, 550));
		pathPoints.add(new Point(680, 610));
		pathPoints.add(new Point(750, 480));
		pathPoints.add(new Point(750, 540));
		pathPoints.add(new Point(750, 600));
		pathPoints.add(new Point(820, 480));
		pathPoints.add(new Point(820, 550));
		pathPoints.add(new Point(890, 460));
		pathPoints.add(new Point(890, 530));
		pathPoints.add(new Point(960, 460));
		pathPoints.add(new Point(960, 520));
		pathPoints.add(new Point(1020, 430));
		pathPoints.add(new Point(1020, 480));
		//pathPoints.add(new Point(1080, 480));
		//pathPoints.add(new Point(1080, 470));
		path.setPositions(pathPoints);
		// Original pond points (7)
		pondPoints = new ArrayList<Point>();
		//pondPoints.add(new Point(530, 460));
		//pondPoints.add(new Point(70, 400));
		pondPoints.add(new Point(170, 400));
		pondPoints.add(new Point(240, 400));
		pondPoints.add(new Point(310, 400));
		pondPoints.add(new Point(380, 400));
		pondPoints.add(new Point(450, 400));
		pondPoints.add(new Point(510, 400));
		pondPoints.add(new Point(580, 400));
		//pondPoints.add(new Point(610, 400));
		pond.setPositions(pondPoints);
		
    }
    public Region getRegion(int x,int y){
    	 int[] xx = getPixelData(img, x, y);
    	 System.out.print(xx);
    	 if(Arrays.equals(xx,new int[]{237, 28, 36}))
    		 return path; 
    	 if(Arrays.equals(xx, new int[] {63, 72, 204}))
    		 return pond; 
    	 if(Arrays.equals(xx,new int[] {34, 177,76}))
    			 return cloud; 
    	 if(Arrays.equals(xx,new int[] {255, 255, 255})) 
    		 return tree; 
    	 if(Arrays.equals(xx,new int[] {0,0,0})) 
    		return box;
    	 if(Arrays.equals(xx,new int[] {185, 122 ,87}))
    		 return bin;
    	 if(Arrays.equals(xx,new int[] {255, 209, 24}))
    		 return others; //otherwise el ba2y ya3ny return others ;//otherwise el ba2y ya3ny
    	 return others;
    }
    	
    	//return others ;//otherwise el ba2y ya3ny
 
	
    public void paint(Graphics g){
    	dbImage = frame.createImage(frame.getWidth(), frame.getHeight());
    	dpg = dbImage.getGraphics();
    	paintComponent(dpg);
    	g.drawImage(dbImage,0,0,(ImageObserver) this);
    }
    public void paintComponent(Graphics g){
    	if(mouseDragged && press){
    		System.out.print("mouseDragged");
    		g.setColor(Color.DARK_GRAY);
    		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    		g.setColor(Color.LIGHT_GRAY);
    		g.fillRect(mx, my, 20, 20);
    		p.setLocation(mx,my);
    	}
    	frame.repaint();
    }	
private  int[] getPixelData(BufferedImage img, int i, int j) {
			int argb = img.getRGB(i, j);

			int rgb[] = new int[] {
			    (argb >> 16) & 0xff, //red
			    (argb >>  8) & 0xff, //green
			    (argb      ) & 0xff  //blue
			};
			System.out.println("rgb: " + rgb[0] + " " + rgb[1] + " " + rgb[2]);
			return rgb;
	}
		// TODO Auto-generated method stub
	
	
	private void initStatusBar() {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.setBorder(BorderFactory.createLoweredBevelBorder());
     //   jPanel.add(statusLabel);
    //    frame.add(jPanel, BorderLayout.SOUTH);
    }

    private void initMouseGestures() {
        mouseGestures = new MouseGestures();
        mouseGestures.setMouseButton(MouseEvent.BUTTON1_MASK);
        mouseGestures.addMouseGesturesListener(this);
        mouseGestures.start();
    }

    public void gestureMovementRecognized(String currentGesture) {
       // setGestureString(addCommas(currentGesture));

    }

    public void processGesture(String gesture) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        setGestureString(addCommas(gesture));
        setGestureString("");
    }

    private String addCommas(String gesture) {
    	stringBuffer = new StringBuffer();
        for (int i = 0; i < gesture.length(); i++) {
            stringBuffer.append(gesture.charAt(i));
            if (i != gesture.length() - 1)
                stringBuffer.append(",");
        }
      //  if (finished){
        //System.out.println("moves: " + stringBuffer.toString());
        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {}
        desktopOperation(gesture);
        //}
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }
    
    private void setGestureString(String gesture) {
      //  statusLabel.setText("Mouse gesture: " + gesture);
    }
    
    private void desktopOperation(String gesture) {
    	System.out.println("inside the function:"+ gesture);
    	finished = false;
    	//Collapse and un-collapse gesture
    	String p1= "DRULD";
    	String p2= "LDRULD";
    	String p3= "DRUD";
    	String p4= "LDRUD";
    	
    	//Drag and drop
    	String d1= "DU";
    	//Delete
    	String m1= "LUR";
    	String m2= "LURD";
    	String m3= "LUD";
    	//String m4= "DUR";
    	String m5= "DLURD";
    	//Hide and un-hide
    	String h1= "LRLR";
    	
    	//Navigate
    	String l1= "R";

    	//Zip and un-zip
    	String z1="LRL";
    	
    	//System.out.println( gesture.compareToIgnoreCase(m1));
    	if(gesture.compareToIgnoreCase(p1)==0 || gesture.compareToIgnoreCase(p2)==0 || 
    			gesture.compareToIgnoreCase(p3)==0 || gesture.compareToIgnoreCase(p4)==0) {
    		System.out.println("collapse and un-collapse");  
    	//	System.out.println("state: " + rclicked.getCurrent_state());
    		if(rclicked.getCurrent_state().equals(State.Collapsed))
				uncollapse();
    		else {
    			collapse();	    			
    		}
    	}
    	else if(gesture.compareToIgnoreCase(m1)==0 || gesture.compareToIgnoreCase(m2)==0 ||
    			gesture.compareToIgnoreCase(m3)==0 || gesture.compareToIgnoreCase(m5)==0){
    		System.out.println("delete");
    		delete();
    	}
    	else if(gesture.compareToIgnoreCase(h1)==0 ){
    		System.out.println("hide and unhide");
    		if(rclicked.getCurrent_state().equals(State.Unhidden)||rclicked.getCurrent_state().equals(State.default_state)){
    			hide();
    		}
    		else{
    			unhide();
    		}
    	}
    	else if(gesture.compareToIgnoreCase(l1)==0){
    		
    		System.out.println("navigate");
    		navigate();
    	}
    	else if(gesture.compareToIgnoreCase(z1)==0){
    		System.out.println("zip and un-zip");
 		if(rclicked.getName().equals("box") ){
    			
	    		if(!zipping){
	    			zipping=true;
	    			filesTozip =  new ArrayList<JButton>();
	    			System.out.println("zipping: " + zipping);
	    		} 
	    		else {
	    			System.out.print("zipping: " + zipping);
	    			System.out.println("  unzipping: " + unzipping);
	    			
	    			if(unzipping){
	    				unzip();
	    				System.out.println("unzipping in" + unzipping);	 
	    				
	    			}
	    			else{
	    				zip();
	        			System.out.println(" calling zip");
	    			}
	    			
	    			zipping = false;
	    		}
    		
    		}
    	}
    	else if(gesture.compareToIgnoreCase(d1)==0){
    		System.out.println("drag and drop");
    		dragDrop();
    	}
     	
    }

    
    @Override
	public void mouseClicked(MouseEvent e) {  // press and release
       // if (e.getSource()) {
            //System.out.println("Third Button Click");
            
      //  }
    	//System.out.print("yarab");
    	//System.out.print( ((Object) e.getSource()).isButton());
		if(drag){ //need remove the icon from region 
			if ((!getRegion(x, y).getName().equals(iconRegion)) &&(!getRegion(x, y).getName().equals("others"))){
				if(getRegion(x, y).getAvaliablepositions().size() < getRegion(x, y).getPositions().size()){
				
				iconPressed.setVisible(false);
				if(iconRegion.equals("cloud")){
					cloud.getAvaliablepositions().remove(iconPressed);
				}
				else if (iconRegion.equals("path")){
					path.getAvaliablepositions().remove(iconPressed);
				}
				else if (iconRegion.equals("tree")){
					tree.getAvaliablepositions().remove(iconPressed);
				}
				System.out.println("siiiiiiiiiiiiiize");
				System.out.println(getRegion(x, y).getAvaliablepositions().size());
				index= getRegion(x, y).getAvaliablepositions().size();
				iconPressed.setLocation(getRegion(x, y).getPositions().get(index));
				iconPressed.setVisible(true);
				getRegion(x, y).getAvaliablepositions().add(iconPressed);
				System.out.println("beeeb");

				System.out.println(getRegion(x, y).getName());
				System.out.println(getRegion(x, y).getAvaliablepositions().size());
				getRegion(x, y).getAvaliablepositions().get(index).setLocation(getRegion(x, y).getPositions().get(index));
				drag = false;
				// hena 
				URL url = Desktop2.class.getResource("/desktopresized.png"");
				
			//	ImageIcon iicon = new ImageIcon(url);
				label.setIcon(new ImageIcon(url)); 
				if(getRegion(x, y).getName().equals("tree")){
		/*			ArrayList<JButton> treeIcons = new ArrayList<JButton>();
				for (int i = 0; i < treeIcons.size(); i++) {
					treeIcons.get(i).setLocation(treePoints.get(i));
				}*/
				}
				frame.add(label);
				//getRegion(x, y).getAvaliablepositions().setLocation();
				frame.getContentPane().validate(); 
				frame.getContentPane().repaint();
			}
			}
		}
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		x=(int) point.getX();
		y=(int) point.getY(); 
		System.out.println(" "+x);
		System.out.println(" "+y);
		System.out.println(getRegion(x, y).getName());
    //	System.out.println("clicked");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	//	System.out.print("exit");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) { //once mouse pressed 
		
		//System.out.println("Pressed");
		// TODO Auto-generated method stub
		//System.out.println(((JButton) e.getSource()).getName());
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		x=(int) point.getX();
		y=(int) point.getY();
		rclicked =	getRegion(x, y);

		System.out.println(" "+x);
		System.out.println(" "+y);
		System.out.println(getRegion(x, y).getName());

	}
	void collapse() {
		System.out.println("region: " +rclicked.getName());
		temp_collapse = new ArrayList<JButton>();
		if(rclicked.getName().compareToIgnoreCase("cloud")==0 || rclicked.getName().compareToIgnoreCase("bin")==0
				|| rclicked.getName().compareToIgnoreCase("box")==0 || rclicked.getName().compareToIgnoreCase("others")==0 ){
			//can not perform a collapse on these regions 
    		return;
    	} 	
		else {
			if(rclicked.getCurrent_state().equals(State.default_state) ) {
				System.out.println("region: " +rclicked.getName());
					/*if(rclicked.getAvaliablepositions().isEmpty()) //already empty region
						return;
					else {*/
						System.out.println("Inside else");
						
						while(!rclicked.getAvaliablepositions().isEmpty())
						for(int i=0; i <rclicked.getAvaliablepositions().size(); i++) {
							temp_collapse.add(rclicked.getAvaliablepositions().get(i));
							label.remove(rclicked.getAvaliablepositions().get(i));
							rclicked.getAvaliablepositions().remove(i);
						}				
						URL url = Desktop2.class.getResource("/p.png");
						//label.setIcon(new ImageIcon(url));
						ImageIcon iicon = new ImageIcon(url);
						JButton x = new JButton(iicon);
						rclicked.getAvaliablepositions().add(x);
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setLocation(rclicked.getPositions().get(rclicked.getAvaliablepositions().size()-1));
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setSize(100, 100);
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setVisible(true);
						
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setOpaque(false);
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setFocusPainted(false);
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setBorder(BorderFactory.createEmptyBorder());
						rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1).setBackground(new Color(0,0,0,0));
						
						label.add(rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1));
					
						rclicked.setCurrent_state(State.Collapsed);
						
						collapsedfiles.add(temp_collapse);
						collapsedfilesr.add(rclicked.getName());
						
						label.updateUI();
						
					}
			}
			
	//	}

	}
    
    void uncollapse(){
		// assumption that only one icon shown that is not in any array and all the icons are in the Icons array in the region 
    	// and all icons are hidden sort of 
    	if(rclicked.getName().equals("others") ||rclicked.getName().equals("cloud")||rclicked.getName().equals("bin")||rclicked.getName().equals("box")){
    		return;
    	}
  
    	if(rclicked.getCurrent_state().equals(State.Collapsed)){
    		
    	/*	if(rclicked.getAvaliablepositions().isEmpty()) //already empty region
				return;
		*/
    			
    		int in = collapsedfilesr.indexOf(rclicked.getName());
    		temp_collapse= collapsedfiles.get(in);
    		label.remove(rclicked.getAvaliablepositions().get(rclicked.getAvaliablepositions().size()-1));
			rclicked.getAvaliablepositions().remove(rclicked.getAvaliablepositions().size()-1);
			
			
				for(int i=0; i < temp_collapse.size(); i++) {
					
					rclicked.getAvaliablepositions().add(temp_collapse.get(i));
					label.add(rclicked.getAvaliablepositions().get(i));
				}		
		
				temp_collapse = new ArrayList<JButton>();
				label.updateUI();
				
    	rclicked.setCurrent_state(State.default_state);
    	
    	}
    	else System.out.println("no overlapping gestures");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	//	System.out.println("released");
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		x=(int) point.getX();
		y=(int) point.getY();
		rclicked =	getRegion(x, y);
		finished = true;
		// TODO Auto-generated method stub
		
	}
    public void dragDrop(){
    	if (drag == false){
    	if(getRegion(x,y).getName()=="cloud"){
    		URL url = Desktop2.class.getResource("/desktopresizedCloud.jpg");
			label.setIcon(new ImageIcon(url));
		//	label.setIcon(new ImageIcon("desktopresizedCloud.jpg")); 
			frame.add(label); // re-add the label
			drag = true;
			dragOnRegion = "cloud";
			if (iconRegion.equals("cloud")){
				
			}
		
    	}
    	else if(getRegion(x,y).getName()=="path"){
    		URL url = Desktop2.class.getResource("/desktopresizedPath.jpg");
			label.setIcon(new ImageIcon(url));
			//label.setIcon(new ImageIcon("desktopresizedPath.jpg")); 
			frame.add(label); // re-add the label
			drag = true;
			dragOnRegion = "path";
			if (iconRegion.equals("path")){
				
			}

		
    	}
/*    	else if(getRegion(x,y).getName()=="pond"){
			label.setIcon(new ImageIcon("Drag Images/Drag from Pond/desktopresizedPond.png")); 
			frame.add(label); // re-add the label
			drag = true;
			dragOnRegion = "pond";

		
    	}*/
    	else if(getRegion(x,y).getName()=="tree"){
    		URL url = Desktop2.class.getResource("/desktopresizedTree.jpg");
			label.setIcon(new ImageIcon(url));
			//label.setIcon(new ImageIcon("desktopresizedTree.jpg")); 
			frame.add(label); // re-add the label
			drag = true;
			dragOnRegion = "tree";
			if (iconRegion.equals("tree")){
				
			}

		
    	}

    	}
    	else {
    		drag = false;
    		URL url = Desktop2.class.getResource("/desktopresized.png");
			label.setIcon(new ImageIcon(url));
			//label.setIcon(new ImageIcon("desktopresized.png")); 
			frame.add(label);
    	}
		frame.getContentPane().validate(); 
		frame.getContentPane().repaint(); // those 2 lines to update the frame content
    }
	public void delete(){
		if (clickedIcon!=-1){
			URL url = Desktop2.class.getResource("/desktopresized.png");
			label.setIcon(new ImageIcon(url));
		//	label.setIcon(new ImageIcon("desktopresized.png")); // change the background picture
			frame.add(label);
		if (iconRegion.equals("path")){

		//	System.out.print(path.getAvaliablepositions().size());
			//frame.getContentPane().remove(path.getAvaliablepositions().get(clickedIcon));
			path.getAvaliablepositions().get(clickedIcon).setVisible(false);
			//ArrayList<JButton> x = path.getAvaliablepositions();
			//x.remove(clickedIcon);
			
			path.getAvaliablepositions().remove(clickedIcon);
			path.setAvaliablepositions(path.getAvaliablepositions());

			//System.out.print(path.getAvaliablepositions().size());
		}
		else if (iconRegion.equals("pond")){
			//frame.getContentPane().remove(pond.getAvaliablepositions().get(clickedIcon));
			pond.getAvaliablepositions().get(clickedIcon).setVisible(false);
			pond.getAvaliablepositions().remove(clickedIcon);
		//	System.out.print(pond.getAvaliablepositions().get(clickedIcon));
		/*	for (int i = 0; i < pond.getAvaliablepositions().size(); i++)
			{
				
			}*/
			pond.setAvaliablepositions(pond.getAvaliablepositions());
		}
		else if (iconRegion.equals("tree")){
			//frame.getContentPane().remove(tree.getAvaliablepositions().get(clickedIcon));
			//pond.getAvaliablepositions().get(clickedIcon).setVisible(false);
			tree.getAvaliablepositions().get(clickedIcon).setVisible(false);
			tree.getAvaliablepositions().remove(clickedIcon);
			tree.setAvaliablepositions(tree.getAvaliablepositions());

		}
		else if (iconRegion.equals("cloud")){
		//	frame.getContentPane().remove(cloud.getAvaliablepositions().get(clickedIcon));
			cloud.getAvaliablepositions().get(clickedIcon).setVisible(false);

			cloud.getAvaliablepositions().remove(clickedIcon);
			//cloud.setAvaliablepositions(cloud.getAvaliablepositions());

		}
		}
	//	if (clickedIcon!=-1){
			System.out.println("d5lt");

			newDisplay = true;
			ArrayList <JButton> cloudIcons = cloud.getAvaliablepositions();
			ArrayList <JButton> treeIcons = tree.getAvaliablepositions();
			ArrayList <JButton> pondIcons = pond.getAvaliablepositions();
			ArrayList <JButton> pathIcons = path.getAvaliablepositions();
			System.out.print(pond.getAvaliablepositions().size());
			System.out.print(pond.getPositions().size());


			for (int i = 0; i < treeIcons.size(); i++) {
				treeIcons.get(i).setLocation(treePoints.get(i));
			}
			for (int i = 0; i < cloudIcons.size(); i++) {
				cloudIcons.get(i).setLocation(cloudPoints.get(i));
			}
			for (int i = 0; i < pondIcons.size(); i++) {
				pondIcons.get(i).setLocation(pondPoints.get(i));
				System.out.print(pond.getAvaliablepositions().get(i));

			}
			for (int i = 0; i < pathIcons.size(); i++) {
				pathIcons.get(i).setLocation(pathPoints.get(i));
			}
			
		frame.getContentPane().validate(); 
		frame.getContentPane().repaint(); // those 2 lines to update the frame content
	//	}
		iconRegion ="";
		clickedIcon=-1;
			
		
		
	}
	public void navigate(){
		
		// Original cloud points (15)
		
		
		// Navigation cloud points (20) - more points in case of adding more icons
		ArrayList<Point> cloudNavPoints = new ArrayList<Point>();
		cloudNavPoints.add(new Point(100, 250));
		cloudNavPoints.add(new Point(170, 250));
		cloudNavPoints.add(new Point(240, 250));
		cloudNavPoints.add(new Point(310, 250));
		cloudNavPoints.add(new Point(380, 250));
		cloudNavPoints.add(new Point(450, 250));
		cloudNavPoints.add(new Point(520, 250));
		cloudNavPoints.add(new Point(590, 250));
		cloudNavPoints.add(new Point(660, 250));
		cloudNavPoints.add(new Point(730, 250));
		cloudNavPoints.add(new Point(100, 340));
		cloudNavPoints.add(new Point(170, 340));
		cloudNavPoints.add(new Point(240, 340));
		cloudNavPoints.add(new Point(310, 340));
		cloudNavPoints.add(new Point(380, 340));
		cloudNavPoints.add(new Point(450, 340));
		cloudNavPoints.add(new Point(520, 340));
		cloudNavPoints.add(new Point(590, 340));
		cloudNavPoints.add(new Point(660, 340));
		cloudNavPoints.add(new Point(730, 340));
		
		
		// Original tree points (21)
		
		// Navigation tree points (30)
		ArrayList<Point> treeNavPoints = new ArrayList<Point>();
		treeNavPoints.add(new Point(100, 230));
		treeNavPoints.add(new Point(170, 230));
		treeNavPoints.add(new Point(240, 230));
		treeNavPoints.add(new Point(310, 230));
		treeNavPoints.add(new Point(380, 230));
		treeNavPoints.add(new Point(450, 230));
		treeNavPoints.add(new Point(520, 230));
		treeNavPoints.add(new Point(590, 230));
		treeNavPoints.add(new Point(660, 230));
		treeNavPoints.add(new Point(730, 230));
		treeNavPoints.add(new Point(800, 230));
		treeNavPoints.add(new Point(870, 230));
		treeNavPoints.add(new Point(940, 230));
		treeNavPoints.add(new Point(100, 320));
		treeNavPoints.add(new Point(170, 320));
		treeNavPoints.add(new Point(240, 320));
		treeNavPoints.add(new Point(310, 320));
		treeNavPoints.add(new Point(380, 320));
		treeNavPoints.add(new Point(450, 320));
		treeNavPoints.add(new Point(520, 320));
		treeNavPoints.add(new Point(590, 320));
		treeNavPoints.add(new Point(660, 320));
		treeNavPoints.add(new Point(730, 320));
		treeNavPoints.add(new Point(800, 320));
		treeNavPoints.add(new Point(870, 320));
		treeNavPoints.add(new Point(940, 320));
		treeNavPoints.add(new Point(100, 410));
		treeNavPoints.add(new Point(170, 410));
		treeNavPoints.add(new Point(240, 410));
		treeNavPoints.add(new Point(310, 410));
		
		
		// Original pond points (7)
		
		// Navigation pond points (15)
		ArrayList<Point> pondNavPoints = new ArrayList<Point>();
		pondNavPoints.add(new Point(100, 250));
		pondNavPoints.add(new Point(170, 250));
		pondNavPoints.add(new Point(240, 250));
		pondNavPoints.add(new Point(310, 250));
		pondNavPoints.add(new Point(380, 250));
		pondNavPoints.add(new Point(450, 250));
		pondNavPoints.add(new Point(520, 250));
		pondNavPoints.add(new Point(590, 250));
		pondNavPoints.add(new Point(660, 250));
		pondNavPoints.add(new Point(730, 250));
		pondNavPoints.add(new Point(100, 340));
		pondNavPoints.add(new Point(170, 340));
		pondNavPoints.add(new Point(240, 340));
		pondNavPoints.add(new Point(310, 340));
		pondNavPoints.add(new Point(380, 340));
		
		
		// Original path points (37)
		
		// Navigation path points (45)
		ArrayList<Point> pathNavPoints = new ArrayList<Point>();
		pathNavPoints.add(new Point(100, 100));
		pathNavPoints.add(new Point(170, 100));
		pathNavPoints.add(new Point(240, 100));
		pathNavPoints.add(new Point(310, 100));
		pathNavPoints.add(new Point(380, 100));
		pathNavPoints.add(new Point(450, 100));
		pathNavPoints.add(new Point(520, 100));
		pathNavPoints.add(new Point(590, 100));
		pathNavPoints.add(new Point(660, 100));
		pathNavPoints.add(new Point(730, 100));
		pathNavPoints.add(new Point(800, 100));
		pathNavPoints.add(new Point(870, 100));
		pathNavPoints.add(new Point(940, 100));
		pathNavPoints.add(new Point(100, 190));
		pathNavPoints.add(new Point(170, 190));
		pathNavPoints.add(new Point(240, 190));
		pathNavPoints.add(new Point(310, 190));
		pathNavPoints.add(new Point(380, 190));
		pathNavPoints.add(new Point(450, 190));
		pathNavPoints.add(new Point(520, 190));
		pathNavPoints.add(new Point(590, 190));
		pathNavPoints.add(new Point(660, 190));
		pathNavPoints.add(new Point(730, 190));
		pathNavPoints.add(new Point(800, 190));
		pathNavPoints.add(new Point(870, 190));
		pathNavPoints.add(new Point(940, 190));
		pathNavPoints.add(new Point(100, 280));
		pathNavPoints.add(new Point(170, 280));
		pathNavPoints.add(new Point(240, 280));
		pathNavPoints.add(new Point(310, 280));
		pathNavPoints.add(new Point(380, 280));
		pathNavPoints.add(new Point(450, 280));
		pathNavPoints.add(new Point(520, 280));
		pathNavPoints.add(new Point(590, 280));
		pathNavPoints.add(new Point(660, 280));
		pathNavPoints.add(new Point(730, 280));
		pathNavPoints.add(new Point(800, 280));
		pathNavPoints.add(new Point(870, 280));
		pathNavPoints.add(new Point(940, 280));
		pathNavPoints.add(new Point(100, 370));
		pathNavPoints.add(new Point(170, 370));
		pathNavPoints.add(new Point(240, 370));
		pathNavPoints.add(new Point(310, 370));
		pathNavPoints.add(new Point(380, 370));
		pathNavPoints.add(new Point(450, 370));
		
		// Icons in each region
		ArrayList <JButton> cloudIcons = cloud.getAvaliablepositions();
		ArrayList <JButton> treeIcons = tree.getAvaliablepositions();
		ArrayList <JButton> pondIcons = pond.getAvaliablepositions();
		ArrayList <JButton> pathIcons = path.getAvaliablepositions();
		
			
			if (getRegion(x, y).getName().equals("tree"))
			{
				if (!(nav) && !getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
				
					nav = true;
					tree.setCurrent_state(State.Navigate);
					URL url = Desktop2.class.getResource("/desktopresized-tree.png");
					label.setIcon(new ImageIcon(url)); // change the background picture
					frame.add(label); // re-add the label
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setLocation(treeNavPoints.get(i));
					}
					frame.getContentPane().validate(); 
					frame.getContentPane().repaint(); // those 2 lines to update the frame content
				
				} else if (nav && getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = false;
					tree.setCurrent_state(State.default_state);
					URL url = Desktop2.class.getResource("/desktopresized.png");
					label.setIcon(new ImageIcon(url)); 
					//label.setIcon(new ImageIcon("desktopresized.png")); // put back the original background
					frame.add(label);
					
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setLocation(treePoints.get(i));
					}
					
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				}
			}
			if (getRegion(x, y).getName().equals ("cloud")) {
				
				if (!(nav) && !getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = true;
					cloud.setCurrent_state(State.Navigate);
					URL url = Desktop2.class.getResource("/desktopresized-cloud.png");
					label.setIcon(new ImageIcon(url)); 
					//label.setIcon(new ImageIcon("desktopresized-cloud.png"));
					frame.add(label);
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setLocation(cloudNavPoints.get(i));
						

					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				} else if (nav && getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = false;
					cloud.setCurrent_state(State.Hidden);
					URL url = Desktop2.class.getResource("/desktopresized.png");
					label.setIcon(new ImageIcon(url));
					//label.setIcon(new ImageIcon("desktopresized.png"));
					frame.add(label);
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setLocation(cloudPoints.get(i));
					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				}
			}
			if (getRegion(x, y).getName().equals( "pond")) {
				
				if (!(nav) && !getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = true;
					pond.setCurrent_state(State.Navigate);
					URL url = Desktop2.class.getResource("/desktopresized-pond.png");
					label.setIcon(new ImageIcon(url));
					//label.setIcon(new ImageIcon("desktopresized-pond.png"));
					frame.add(label);
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setLocation(pondNavPoints.get(i));
					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				} else if (nav && getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = false;
					pond.setCurrent_state(State.default_state);
					URL url = Desktop2.class.getResource("/desktopresized.png");
					label.setIcon(new ImageIcon(url));
					//label.setIcon(new ImageIcon("desktopresized.png"));
					frame.add(label);
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setLocation(pondNavPoints.get(i));
					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				}
			}
			if (getRegion(x, y).getName().equals("path")) {
				
				if (!(nav) && !getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = true;
					path.setCurrent_state(State.Navigate);
					URL url = Desktop2.class.getResource("/desktopresized-path.png");
					label.setIcon(new ImageIcon(url));
				//	label.setIcon(new ImageIcon("desktopresized-path.png"));
					frame.add(label);
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(false);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setLocation(pathNavPoints.get(i));
					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				} else if (nav && getRegion(x, y).getCurrent_state().equals(State.Navigate)) {
					
					nav = false;
					path.setCurrent_state(State.default_state);
					URL url = Desktop2.class.getResource("/desktopresized.png");
					label.setIcon(new ImageIcon(url));
					//label.setIcon(new ImageIcon("desktopresized.png"));
					frame.add(label);
					for (int i = 0; i < pondIcons.size(); i++) {
						pondIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < treeIcons.size(); i++) {
						treeIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < cloudIcons.size(); i++) {
						cloudIcons.get(i).setVisible(true);
					}
					for (int i = 0; i < pathIcons.size(); i++) {
						pathIcons.get(i).setLocation(pathPoints.get(i));
					}
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					
				}
			}
	    
	}
	public void autohide(){
		ArrayList<JButton> arr = cloud.getAvaliablepositions();
		if(rclicked.getName().equals("cloud")){
			for (int i=0; i<arr.size(); i++){
				arr.get(i).setVisible(false);
			}
			rclicked.setCurrent_state(State.Hidden);
			return;
		}
	}
	
	public void hide ()
	{	
		ArrayList<JButton> arr = rclicked.getAvaliablepositions();

		if(!rclicked.getName().equals("others") || rclicked.getName().equals("bin")||rclicked.getName().equals("box")){
			
			if(rclicked.getName().equals("cloud")){
				for (int i=0; i<arr.size(); i++){
					arr.get(i).setVisible(false);
				}
				rclicked.setCurrent_state(State.Hidden);
				return;
			}
			
			if (rclicked.getCurrent_state().equals(State.default_state)){
				
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Enter a password:");
				JPasswordField pass = new JPasswordField(10);
				String str = "hci";
				char [] given_pass = str.toCharArray();
				//char [] given_pass = new char[] { 'a', 'b', 'c', 'd' };
				//boolean right = false;
				Boolean correct= false;
				while(!correct){
				panel.add(label);
				panel.add(pass);
				String[] options = new String[]{"OK", "Cancel"};
				int option = JOptionPane.showOptionDialog(null, panel, "The title", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
				
				if(option == 0) // pressing OK button
				{
				    char[] password = pass.getPassword();
				    
				    System.out.println("Your password is: " + new String(password));
				    boolean retval=Arrays.equals(given_pass, password);
				    System.out.println("arr1 and arr2 equal: " + retval);
				    
					if (retval){
						correct = true;
					    System.out.println("Your pas" );

						if(rclicked == path){
							for (int i=0; i<arr.size(); i++){
								arr.get(i).setVisible(false);
							}
							path.setCurrent_state(State.Hidden);
						}
						
                       if(rclicked == pond){
                    	   for (int i=0; i<arr.size(); i++){
               				arr.get(i).setVisible(false);
               			}
							pond.setCurrent_state(State.Hidden);
						}
                       
                       if(rclicked == tree){
                    	   for (int i=0; i<arr.size(); i++){
               				arr.get(i).setVisible(false);
               			}
							tree.setCurrent_state(State.Hidden);
						}		
					}
					else{
						System.out.println("hennna");
						JOptionPane.showMessageDialog(null, " Wrong Password !!");
							correct = false;
					}
				}
				else {
					return;
				}
				}
				
				
			}
		}
	}
	
	public void unhide(){
		
        ArrayList<JButton> arr = rclicked.getAvaliablepositions();
		

		if(!rclicked.getName().equals("others") || rclicked.getName().equals("bin")||rclicked.getName().equals("box")){
			
			if(rclicked.getName().equals("cloud")){
				for (int i=0; i<arr.size(); i++){
					arr.get(i).setVisible(true);
				}
				rclicked.setCurrent_state(State.Unhidden);
				return;
			}
			
			if (rclicked.getCurrent_state().equals(State.Hidden)){
				
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Enter a password:");
				JPasswordField pass = new JPasswordField(10);
				String str = "hci";
				char [] given_pass = str.toCharArray();
				//char [] given_pass = new char[] { 'a', 'b', 'c', 'd' };
				//boolean right = false;
				Boolean correct= false;
				while(!correct){
				panel.add(label);
				panel.add(pass);
				String[] options = new String[]{"OK", "Cancel"};
				int option = JOptionPane.showOptionDialog(null, panel, "The title", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
				
				if(option == 0) // pressing OK button
				{
				    char[] password = pass.getPassword();
				    
				    System.out.println("Your password is: " + new String(password));
				    boolean retval=Arrays.equals(given_pass, password);
				    System.out.println("arr1 and arr2 equal: " + retval);
				    
					if (retval){
						correct = true;
					    System.out.println("Your pas" );

					    if (rclicked == path && path.getCurrent_state().equals(State.Hidden)){
							for (int i=0; i<arr.size(); i++){
								arr.get(i).setVisible(true);
							}
							path.setCurrent_state(State.default_state);
						}
						
					    else if (rclicked == pond && pond.getCurrent_state().equals(State.Hidden)){
							for (int i=0; i<arr.size(); i++){
								arr.get(i).setVisible(true);
							}
							pond.setCurrent_state(State.default_state);
						}
						else if (rclicked == tree && tree.getCurrent_state().equals(State.Hidden)){
							for (int i=0; i<arr.size(); i++){
								arr.get(i).setVisible(true);
							}
							tree.setCurrent_state(State.default_state);
						}		
					}
					else{
						JOptionPane.showMessageDialog(null, " Wrong Password !!");
							correct = false;
					}
				}
				else {
					return;
				}
				}	
			}
		}
	}
	
	public void zip() {
		if(!filesTozip.isEmpty()){
		URL url = Desktop2.class.getResource(iconsPath+37+".png");  ImageIcon iicon = new ImageIcon(url);
		//ImageIcon iicon = new ImageIcon(iconsPath+37+".png");
		zipped= new JButton(iicon);
		
		pond.getAvaliablepositions().add(zipped);
		zippedfiles.add(filesTozip);
		zippedfilesr.add(zippedregion);
		label.add(zipped);
		zipped.addActionListener(this);
		zipped.setLocation(pond.getPositions().get(pond.getAvaliablepositions().size()-1));
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setSize(100, 100);
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setVisible(true);
		
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setOpaque(false);
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setFocusPainted(false);
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setBorder(BorderFactory.createEmptyBorder());
		pond.getAvaliablepositions().get(pond.getAvaliablepositions().size()-1).setBackground(new Color(0,0,0,0));
		
		
		// delete icons in zipped array
		for(int i=0; i<filesTozip.size(); i++){
			filesTozip.get(i).setVisible(false);
			
		}

		label.updateUI();
		frame.pack();
		filesTozip =  new ArrayList<JButton>();
		}
	}

    public void unzip() {
    	//int in = pond.getAvaliablepositions().indexOf(zipped);
  
    	filesTozip =  zippedfiles.get(pond.getAvaliablepositions().indexOf(zipped));
    	for(int i=0; i<filesTozip.size(); i++){
			filesTozip.get(i).setVisible(true);
		}
    	//zipped.setVisible(false);
    	
    	label.remove(zipped);
    	zippedfiles.remove(filesTozip);
    	pond.getAvaliablepositions().remove(zipped);
    	
    	frame.pack();
    	rclicked.setCurrent_state(State.default_state);
		unzipping = false;
		label.updateUI();
	}
	public void create3() {
	
		URL url;
			icons = new ArrayList<JButton>(); //path
			for(int i=0; i < 23;i++)
			{
				//Path Region
				if (i == 0) //here
				{
					url = Desktop2.class.getResource(iconsPath+i+".png");
					ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(0 ,440);
				}
				else if (i == 1) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(0 ,500);
				}
				else if (i == 2) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(0 ,560);
				}else if (i == 3) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(80 ,460);
				}else if (i == 4) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(80 ,530);
				}
				else if (i == 5) 
				{
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(80 ,600);
				}
				else if (i == 6) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(160 ,480);
				}
				else if (i == 7) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(160 ,540);
				}else if (i == 8) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(160 ,610);
				}else if (i == 9) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(230 ,500);
				}
				else if (i == 10) 
				{
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(230 ,570);
				}
				else if (i == 11) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(230 ,640);
				}
				else if (i == 12) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(300 ,500);
				}else if (i == 13) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(300 ,570);
				}else if (i == 14) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(300 ,640);
				}else if (i == 15) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(370 ,520);
				}else if (i == 16) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(450 ,530);
				}else if (i == 17) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(540 ,530);
				}
					else if (i == 18) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(540 ,580);
				}else if (i == 19) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(540 ,640);
				}else if (i == 20) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(610 ,500);
				}else if (i == 21) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(610 ,560);
				}
				else if (i == 22) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(610 ,620);
				}
				//else if (i == 23) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(680 ,490);
//				}else if (i == 24) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(680 ,550);
//				}else if (i == 25) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(680 ,610);
//				}else if (i == 26) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(750 ,480);
//				}else if (i == 27) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(750 ,540);
//				}else if (i == 28) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(750 ,600);
//				}else if (i == 29) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(820 ,480);
//				}else if (i == 30) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(820 ,550);
//				}else if (i == 31) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(890 ,460);
//				}else if (i == 32) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(890 ,530);
//				}else if (i == 33) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(960 ,460);
//				}else if (i == 34) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(960 ,520);
//				}else if (i == 35) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(1020 ,430);
//				}else if (i == 36) {
//					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
//					icons.add(new JButton(iicon));
//					icons.get(i).addMouseMotionListener(this);
//					icons.get(i).setLocation(1020 ,480);
//				}
				/*else if (i == 37) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).setLocation(1080 ,420);
					
				}*/
			/*	else if (i == 37) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(1080 ,470);
				}*/
				if(icons.get(i)!= null){
					  //System.out.println("icon in "+i);
						icons.get(i).setSize(100, 100);
						icons.get(i).setOpaque(false);
						icons.get(i).setFocusPainted(false);
						icons.get(i).setBorder(BorderFactory.createEmptyBorder());
						icons.get(i).setBackground(new Color(0,0,0,0));
						
						 
						label.add(icons.get(i));
						icons.get(i).addActionListener(this);

				}
				
			} 
			
			path.setAvaliablepositions(icons);
			
			
			icons = new ArrayList<JButton>();  
			/*for(int i=0; i < 7;i++)
			{
				 //pond icons
		/*		  if (i == 0) //here
				{
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).setLocation(530 ,460);//
				} */
			/*	if (i == 0) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).setLocation(70 ,400);//
				}*/
			/*	 if (i == 0) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(170 ,400);//
				}else if (i == 1) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(240 ,400);//
				}else if (i == 2) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(310 ,400);//
					
				}
				else if (i == 3) 
				{
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(380 ,400);//
				}
				else if (i == 4) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(450 ,400);//
				}
				else if (i == 5) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(510 ,400);//
				}else if (i == 6) {
					url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
					icons.add(new JButton(iicon));
					icons.get(i).addMouseMotionListener(this);
					icons.get(i).setLocation(580 ,400);//
				}
				  if(icons.get(i)!= null){
					  //System.out.println("icon in "+i);
						icons.get(i).setSize(100, 100);
						icons.get(i).setOpaque(false);
						icons.get(i).setFocusPainted(false);
						icons.get(i).setBorder(BorderFactory.createEmptyBorder());
						icons.get(i).setBackground(new Color(0,0,0,0));
						
						 
						label.add(icons.get(i));
						icons.get(i).addActionListener(this);

				}
			}*/
			
				pond.setAvaliablepositions(icons);
				
				icons = new ArrayList<JButton>();  
				for(int i=0; i < 10;i++)
				{
				//cloud icons
					  if (i == 0) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(330 ,20);

						}
						else if (i == 1) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(400 , 20);
						}
						else if (i == 2) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(470 ,20);
						}
						else if (i == 3) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(750 ,20);
						}
						else if (i == 4) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(820 ,20);
						}

						else if (i == 5) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(890 ,20);
						}
						else if (i == 6) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
						    icons.get(i).setLocation(960 ,20);

						}else if (i == 7) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(290 ,100);
						}else if (i == 8) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(400 ,100);
						}else if (i == 9) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(500 ,100);
						}
/*						else if (i == 10) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(600 ,100);
						}
						else if (i == 11) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(700 , 100);
						}else if (i == 12) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(800 ,100);
						}
						else if (i == 13) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(900 ,100);
						}
					else if (i == 14) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
						    icons.get(i).setLocation(1000 ,100);

						}*/
						
				
				  if(icons.get(i)!= null){
					  //System.out.println("icon in "+i);
						icons.get(i).setSize(100, 100);
						icons.get(i).setOpaque(false);
						icons.get(i).setFocusPainted(false);
						icons.get(i).setBorder(BorderFactory.createEmptyBorder());
						icons.get(i).setBackground(new Color(0,0,0,0));
						icons.get(i).setVisible(false);
						 
						label.add(icons.get(i));
						icons.get(i).addActionListener(this);

				}
				  
				}
				cloud.setAvaliablepositions(icons);
				
				icons = new ArrayList<JButton>();  
				for(int i=0; i < 10 ;i++)
				{
						
					 if (i == 0) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1060 ,290);
						}else if (i == 1) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1115 ,250);
						}
						
					if (i == 2) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1115 ,350);
						}
						else if (i ==3) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1190 ,170);
						}
						else if (i == 4) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1190 ,270);
						}
					else if (i == 5) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1190 ,370);
						}else if (i == 6) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 ,170); //t
						}else if (i == 7) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 ,270);
						}
						else if (i == 8) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 ,370);
						}
						else if (i == 9) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 ,470);
						}
/*						else if (i == 10) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 ,570);
						}else if (i == 11) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
		
							icons.get(i).setLocation(1190 ,530); //t
						}else if (i == 12) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1110 ,550);
						}
						else if (i == 13) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1040 ,560);
						}
						else if (i == 14) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(830 ,640);
						}else 
							if (i == 15) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(900 ,640); //t
						}else
							if (i == 16) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(960 ,640);//t
						}

						if (i == 17) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1030 , 640); //t		
						}
						else if (i == 18) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1110 , 640); //t
						}
						else if (i == 19) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1190 ,640); //t
						}
						else if (i == 20) {
							url = Desktop2.class.getResource(iconsPath+i+".png");  ImageIcon iicon = new ImageIcon(url);
							icons.add(new JButton(iicon));
							icons.get(i).addMouseMotionListener(this);
							icons.get(i).setLocation(1266 , 640); //t
						}*/
	
						if(icons.get(i)!= null){
							  //System.out.println("icon in "+i);
								icons.get(i).setSize(100, 100);
								icons.get(i).setOpaque(false);
								icons.get(i).setFocusPainted(false);
								icons.get(i).setBorder(BorderFactory.createEmptyBorder());
								icons.get(i).setBackground(new Color(0,0,0,0));
								
								 
								label.add(icons.get(i));
								icons.get(i).addActionListener(this);

						}
			
				} 

				
				tree.setAvaliablepositions(icons);
					
		}

	@Override
	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	//	System.out.print("dragged");
	//	mouseDragged = true;
	//	if(clicked){
		//	xx.setVisible(false);
		//	xx.setLocation(mx+20,my+20);
		//	cloud.getAvaliablepositions().get(0).setLocation(mx,my);
			//xx.setVisible(true);
	//	}
		e.consume();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(drag && iconDrag){
		System.out.print(getRegion(e.getX(),e.getY()).getName());
		if(dragOnRegion.equals("path")){
		if(getRegion(e.getX(),e.getY()).getName().equals("cloud")){
			URL url = Desktop2.class.getResource("/desktopresizedPath2.jpg");  
			label.setIcon(new ImageIcon(url));
			frame.add(label);
		}
		else if(getRegion(e.getX(),e.getY()).getName().equals("tree")){
			URL url = Desktop2.class.getResource("/desktopresizedPath1.jpg");  
			label.setIcon(new ImageIcon(url));
			frame.add(label);
		}
		else {
			URL url = Desktop2.class.getResource("/desktopresizedPath.jpg");  
			label.setIcon(new ImageIcon(url));
		
			frame.add(label);
		}

		}
		if(dragOnRegion.equals("tree")){
			if(getRegion(e.getX(),e.getY()).getName().equals("cloud")){
				URL url = Desktop2.class.getResource("/desktopresizedTree2.jpg");  
				label.setIcon(new ImageIcon(url));
			
				frame.add(label);
			}
			else if(getRegion(e.getX(),e.getY()).getName().equals("path")){
				URL url = Desktop2.class.getResource("/desktopresizedTree3.jpg");  
				label.setIcon(new ImageIcon(url));
			
				//label.setIcon(new ImageIcon("desktopresizedTree3.jpg"));
				frame.add(label);
			}
			else {
				URL url = Desktop2.class.getResource("/desktopresizedTree.jpg");  
				label.setIcon(new ImageIcon(url));
				//label.setIcon(new ImageIcon("desktopresizedTree.jpg"));
				frame.add(label);
			}
		}
		if(dragOnRegion.equals("cloud")){
			if(getRegion(e.getX(),e.getY()).getName().equals("path")){
				URL url = Desktop2.class.getResource("/desktopresizedCloud1.jpg");  
				label.setIcon(new ImageIcon(url));
			//	label.setIcon(new ImageIcon("desktopresizedCloud1.jpg")); 
				frame.add(label);
			}
			else if(getRegion(e.getX(),e.getY()).getName().equals("tree")){
				URL url = Desktop2.class.getResource("/desktopresizedCloud2.jpg");  
				label.setIcon(new ImageIcon(url));
				//label.setIcon(new ImageIcon("desktopresizedCloud2.jpg")); 
				frame.add(label);
			}
			else{
				//else if(getRegion(e.getX(),e.getY()).getName().equals("tree")){
				URL url = Desktop2.class.getResource("/desktopresizedCloud.jpg");  
				label.setIcon(new ImageIcon(url));
				//	label.setIcon(new ImageIcon("desktopresizedCloud.jpg")); 
					
					frame.add(label);
				//}
			}
		}
		}
		frame.getContentPane().validate(); 
		frame.getContentPane().repaint();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(arg0.getActionCommand());
		xx = (JButton) arg0.getSource();
		clicked = true;
        //Point button = ((JButton) arg0.getSource()).getLocation();
//        String label = button.getLabel(); //Deprecated 
        
        if ((path.getAvaliablepositions()).indexOf(arg0.getSource()) !=-1 )
        {	rclicked = getRegion(x,y);
        	clickedIcon =(path.getAvaliablepositions()).indexOf(arg0.getSource());
        	iconRegion = "path";
        	iconPressed = (JButton) arg0.getSource();
        	if(drag){
        		iconDrag  =true;
        	}
        }
        else if ((pond.getAvaliablepositions()).indexOf(arg0.getSource()) !=-1 )
        {	
        	clickedIcon = pond.getAvaliablepositions().indexOf(arg0.getSource());
        	iconRegion = "pond";
        	rclicked = getRegion(x,y);
        	iconPressed = (JButton) arg0.getSource();
        }
        else if ((tree.getAvaliablepositions()).indexOf(arg0.getSource()) !=-1 )
        {	 rclicked = getRegion(x,y);
        	clickedIcon = tree.getAvaliablepositions().indexOf(arg0.getSource());
        	iconRegion = "tree";
        	iconPressed = (JButton) arg0.getSource();
        	if(drag){
        		iconDrag  =true;
        	}
        }
        else if ((cloud.getAvaliablepositions()).indexOf(arg0.getSource()) !=-1 ){
        	clickedIcon = cloud.getAvaliablepositions().indexOf(arg0.getSource());
        	iconRegion = "cloud";
        	rclicked = getRegion(x,y);

        	iconPressed = (JButton) arg0.getSource();
        	if(drag){
        		iconDrag  =true;
        	}
        }
    	rclicked = getRegion(x,y);

       // String label2 = button.getText();
        System.out.print(clickedIcon);
        System.out.print(iconRegion);
		// TODO Auto-generated method stub
        JButton Rawan = (JButton) arg0.getSource();
  		if(zipping){
  			if(iconRegion.equals("pond")){
  				zipped = Rawan;
  				unzipping = true;
  				zippedregion = rclicked;
  				System.out.println("setted unzipping");
  	       }
  			else filesTozip.add(Rawan);
  		}
	}
	}
