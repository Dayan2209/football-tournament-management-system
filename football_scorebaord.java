import java.util.*;
class football_scorebaord
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of teams");
        int n=sc.nextInt();
        sc.nextLine();
        String teams[]=new String[n];
        int points[]=new int[n];
        int matches[]=new int[n];
        int goalsf[]=new int[n];
        int goalsa[]=new int[n];
        int wins[]=new int[n];
        int losses[]=new int[n];
        int draws[]=new int[n];
        System.out.println("enter team names");
        for(int i=0;i<n;i++)
            teams[i]=sc.nextLine();
        for(int i=0;i<n;i++)         
            points[i]=0;
        for(int i=0;i<n;i++)
            matches[i]=0;
        for(int i=0;i<n;i++)
            wins[i]=0;
        for(int i=0;i<n;i++)
            losses[i]=0;
        for(int i=0;i<n;i++)
            draws[i]=0;
        for(int i=0;i<n;i++)
            goalsa[i]=0;
        for(int i=0;i<n;i++)
            goalsf[i]=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                System.out.println(teams[i] +" vs "+ teams[j]);
                System.out.println("enter goals scored by team "+teams[i]);
                int score1=sc.nextInt();
                System.out.println("enter goals scored by team "+teams[j]);
                int score2=sc.nextInt();
                matches[i]++;
                matches[j]++;
                goalsf[i]+=score1;
                goalsa[i]+=score2;
                goalsf[j]+=score2;
                goalsa[j]+=score1;
                if(score1>score2)
                {
                    System.out.println("winner of the match is team "+teams[i]);
                    points[i]+=3;
                    wins[i]++;
                    losses[j]++;
                    System.out.println();
                }
                else if(score2>score1)
                {
                    System.out.println("winner of the match is team "+teams[j]);
                    points[j]+=3;
                    wins[j]++;
                    losses[i]++;
                    System.out.println();
                }
                else
                {
                    System.out.println("the match ended in a draw");
                    points[j]+=1;
                    points[i]+=1;
                    draws[i]++;
                    draws[j]++;
                    System.out.println();
                }
            }
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                int gd1=goalsf[j]-goalsa[j];
                int gd2=goalsf[j+1]-goalsa[j+1];
                if(points[j]<points[j+1] || (points[j]==points[j+1] && gd1<gd2))
                {
                    int temp=points[j];
                    points[j]=points[j+1];
                    points[j+1]=temp;

                    String t=teams[j];
                    teams[j]=teams[j+1];
                    teams[j+1]=t;

                    int m=matches[j];
                    matches[j]=matches[j+1];
                    matches[j+1]=m;

                    int gf=goalsf[j];
                    goalsf[j]=goalsf[j+1];
                    goalsf[j+1]=gf;

                    int ga=goalsa[j];
                    goalsa[j]=goalsa[j+1];
                    goalsa[j+1]=ga;

                    int w=wins[j];
                    wins[j]=wins[j+1];
                    wins[j+1]=w;

                    int l=losses[j];
                    losses[j]=losses[j+1];
                    losses[j+1]=l;
                }
            }
        }
        System.out.println();
        System.out.println("                                        SCOREBOARD");
        for(int i=0;i<n;i++)
        {
            String name=teams[i];
            int space=15-name.length();
            int gd=goalsf[i]-goalsa[i];
            System.out.print((i+1)+". Team "+name);
            for(int k=0;k<space;k++)
                System.out.print(" ");
            System.out.println("Matches : "+matches[i]+"  Wins : "+wins[i]+"  Losses : "+losses[i]+"  Draws : "+draws[i]+"  G/F : "+goalsf[i]+"  G/A : "+goalsa[i]+"  G/D : "+gd+"  Points : "+points[i]);
        }
    }
}
