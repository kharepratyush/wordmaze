import java.io.*;
import java.util.*;
class wordwr
{

	public static int count;

	public static void make(int i_en,int j_en, int let,int i_ex, int j_ex, char a[][],int visited[][],String w)
	{
		if((i_en<0)||(j_en<0))
			return;
		if((i_en>i_ex)||(j_en>j_ex))
			return;
		if(visited[i_en][j_en]==1)
			return;
		if(let>=w.length())
			return;
		a[i_en][j_en]=w.charAt(let);
		visited[i_en][j_en]=1;
		if((i_en==i_ex)&&(j_en==j_ex)&&(let==w.length()-1))
		{	
			print_array(a);
			visited[i_en][j_en]=0;
			count--;
			if(count==0)
				System.exit(0);
			return;
		}
		
		make(i_en+1,j_en-1,let+1,i_ex,j_ex,a,visited,w);
		make(i_en-1,j_en+1,let+1,i_ex,j_ex,a,visited,w);
		make(i_en+1,j_en+1,let+1,i_ex,j_ex,a,visited,w);
		make(i_en-1,j_en-1,let+1,i_ex,j_ex,a,visited,w);

		make(i_en,j_en-1,let+1,i_ex,j_ex,a,visited,w);
		make(i_en,j_en+1,let+1,i_ex,j_ex,a,visited,w);

		make(i_en-1,j_en,let+1,i_ex,j_ex,a,visited,w);		
		make(i_en+1,j_en,let+1,i_ex,j_ex,a,visited,w);		

		visited[i_en][j_en]=0;
		a[i_en][j_en]='#';
		//System.out.println("Fail");
	}
	public String join_Str(String[] words)
	{
		String w="";

		for(int i=0;i<10;i++)
			w+=words[i];
		return w;
	}
	public static void print_array(char a[][])
	{
		Random rand=new Random();
		int r;
		char c;
		for(int i=0;i<12;i++)
		{	for(int j=0;j<12;j++)
			{	
				if(a[i][j]=='#')
				{
					r=rand.nextInt(26);
					c=(char)(r+'a');
					System.out.print((char)c+" ");

				}
				else
					System.out.print(a[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
class wordwrap
{
	public static void main(String args[])throws IOException
	{
		wordwr word_ob=new wordwr();
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader d1 = new BufferedReader(in);

		int[][] visited = new int[12][12];
		int i_ex=11;
		int j_ex=11;
		char[][] a = new char[12][12];
		String[] words = new String[10];
		System.out.println("Enter words :");
		for(int i=0;i<10;i++)
			words[i]=d1.readLine();

		String w=word_ob.join_Str(words);

		for(int i=0;i<12;i++)
			for(int j=0;j<12;j++)
			{
				a[i][j]='#';
				visited[i][j]=0;
			}
		System.out.println("Enter count of solutions : ");
		word_ob.count=Integer.parseInt(d1.readLine());
		//word_ob.join_Str();
		//System.out.println(word_ob.w);
		word_ob.make(0,0,0,i_ex,j_ex,a,visited,w);
	}
}