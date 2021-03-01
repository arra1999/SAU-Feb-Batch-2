

public class CountWords   { 
	public static void main(String[] args) 
		throws InterruptedException 
	{ 
		
		final PC pc = new PC(); 
		 String s="Whoever does not value his own life will lose it. Now you must live.\r\n"
				+ "\r\n"
				+ "Others ought to look after themselves and do not stand where your knife stabs. You\r\n"
				+ "\r\n"
				+ "shouldn’t become a monkey and fool to others- for the sake of tomfoolery. ~Jung’s Soul, The Black Books, Vol. V, Page 205\r\n"
				+ "\r\n"
				+ "In 1912 Jung cited the following lines from the Bhagavad Gita, chapter 4, verse 24 (in English in Edwin Arnold’s 1885 translation) :";
		

		
				// creating five threads
				Thread t1 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					pc.check_length("Whoever does not value his own life will lose it. Now you must live.\r\n"
							+ "\r\n"
							+ "Others ought to look after themselves and do not stand where your knife stabs. You\r\n"
							+ "\r\n"); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 

		
		Thread t2 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					pc.check_length("shouldn’t become a monkey and fool to others- for the sake of tomfoolery. ~Jung’s Soul, The Black Books, Vol. V, Page 205\r\n"
							+ "\r\n"
							+ "In 1912 Jung cited the following lines from the Bhagavad Gita, chapter 4, verse 24 (in English in Edwin Arnold’s 1885 translation) :"
					); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 
		Thread t3 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					pc.check_length("Whoever does not value his own life will lose it. Now you must live.\r\n"
							+ "\r\n"); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 
		Thread t4 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					pc.check_length("Others ought to look after themselves and do not stand where your knife stabs. You\r\n"
							+ "\r\n"
							+ "shouldn’t become a monkey and fool to others- for the sake of tomfoolery. ~Jung’s Soul, The Black Books, Vol. V, Page 205\r\n"
							+ "\r\n"); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 
		Thread t5 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					pc.check_length("In 1912 Jung cited the following lines from the Bhagavad Gita, chapter 4, verse 24 (in English in Edwin Arnold’s 1885 translation) :"
							
); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 

		//checking for two threads
		long st1=System.nanoTime();
		t1.start(); 
		t2.start();
		t1.join(); 
		t2.join();
		 long end1=System.nanoTime();
		//checking for three threads
		long st2=System.nanoTime();
		t3.start(); 
		t4.start();
		t5.start();
        t3.join(); 
		t4.join();
		t5.join();
		 long end2=System.nanoTime();
		//checking without threads
		long st3=System.nanoTime();
		pc.check_length(s);
		 long end3=System.nanoTime();
		System.out.println("Two threads, time taken:"+(end1-st1));
		System.out.println("Three threads, time taken:"+(end2-st2));
		System.out.println("No thread, time taken:"+(end3-st3));
		
		
		
	} 

	
	public static class PC { 

		static int length=0;
		
		
		public void check_length(String str) throws InterruptedException 
		{ 
			 int state = 0; 
		        int wc = 0;  
		        int i = 0; 
		          
		        
		        while (i < str.length()) 
		        { 
		             
		            if (str.charAt(i) == ' ' || str.charAt(i) == '\n' 
		                    || str.charAt(i) == '\t') 
		                state = 0; 
		                  
		       
		           
		            else if (state == 0) 
		            { 
		                state = 1; 
		                ++wc; 
		            } 
		       
		           
		            ++i; 
		        } 
		        length+=wc; 

					
					

					
					
				} 
			 
		} 

		
		
	
} 
