import java.util.*;
 class Sweets 
{
	private int wt;
	private String name;
	public Sweets(){
	}

 // Parameterized Constructor
	public Sweets(int wt,String name) 
	{
 		this.wt = wt;
		this.name = name;
 		//this.cost = cost;
  	}

// Getter  methods
	public int getWeight()
	{
		return this.wt; 
	}

 
 	public String getName()
 	{
 		return this.name;
 	}
 	
	
}

class Chocolates extends Sweets
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int totalWeight=0;
		
		List<String> Choclate = new ArrayList<String>();
		Sweets s1 = new Sweets(35, "Cadbury");
		Sweets s2 = new Sweets(25, "Ferrero Rocher");
		Sweets s3 = new Sweets(65, "Nestle");
		Sweets s4 = new Sweets(105, "Toblerone");
		Sweets s5 = new Sweets(45, "Patchi") ;
		
  	    HashMap<String,Integer> map = new HashMap<String,Integer>(); 
        map.put(s1.getName(),s1.getWeight()); 
 		map.put(s2.getName(),s2.getWeight());
 		map.put(s3.getName(),s3.getWeight());
 		map.put(s4.getName(),s4.getWeight());
		map.put(s5.getName(),s5.getWeight());
		
		//System.out.print(map);
		
		Map<String,Integer> sortedMap = sortByValue(map);
		//System.out.print(sortedMap);
		for(Map.Entry entry: sortedMap.entrySet())
		{
			System.out.print(entry.getKey().toString() +" : " + entry.getValue().toString() );
			System.out.println();
		}
		System.out.println();
		
		for(Integer i :sortedMap.values())
			totalWeight+=i;
			
		System.out.println("TotalWeight : "+totalWeight);	

		while(true)
		{
			System.out.println("Enter the range");
			System.out.println("Start");
			int start = sc.nextInt();
			System.out.println("End");
			int end = sc.nextInt();
			
			for(Map.Entry entry: sortedMap.entrySet())
			{
				if (start<=(int)(entry.getValue()) && (int)(entry.getValue())<=end)
				{
					System.out.print(entry.getKey().toString() +" : " + entry.getValue().toString() );
					System.out.println();
				}
			
			}
			
			
			System.out.println("Do you want find another item(y/n)");
			String choice = sc.next();
			if( choice.equals("n") || choice.equals("N"))
				break;
		}
	}
	//end main
	
	
    public static Map<String, Integer> sortByValue(Map<String,Integer> unsortMap) 
    {
 		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
    		public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
    		{
        		return (o1.getValue()).compareTo(o2.getValue());
    		}
    	});
    	
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
    	for (Map.Entry<String, Integer> entry : list) 
    	{
        		sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
		
	
}