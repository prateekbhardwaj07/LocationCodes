import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {
	
	public Integer parallelSum()
	{
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<Integer>> list = new ArrayList<>();
		int count=1,prev=0;
		for(int i=0;i<100;i++)
		{
			if(count%2==0)
			{
				System.out.println("Prev :"+prev+"Current :"+i);
				Future<Integer> future = service.submit(new CallableAdder(prev,i));
				list.add(future);
				count=1;
				continue;
			}
			prev=i;
			count++;
		}
		int totalSum = 0;
		for(Future<Integer> fut:list)
		{
			try
			{
				totalSum+=fut.get();
			}
			catch(Exception exception)
			{
				
			}
		}
		return totalSum;

	}
	public static void main(String[] ar)
	{
		FutureEx f1 = new FutureEx();
		System.out.println(f1.parallelSum());
	}
}
class CallableAdder implements Callable<Integer> {
    Integer operand1;
    Integer operand2;
    CallableAdder(Integer operand1,Integer operand2)
    {
          this.operand1=operand1;
          this.operand2=operand2;             
    }          
    public Integer call() throws Exception {
           // TODO Auto-generated method stub
           System.out.println(Thread.currentThread().getName()+" says : partial Sum for " + operand1 + " and "+ operand2+ " is "  +(operand1+operand2));
           return operand1+operand2;
    }
}