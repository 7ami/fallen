package pingPong;



import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame obj= new JFrame();
          GameThings fine = new GameThings();
		obj.setBounds(10,10,800, 450);
	   obj.setVisible(true);
	   obj.setTitle("Table Tennis");
       obj.setResizable(false);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       obj.add(fine);
	}

}
