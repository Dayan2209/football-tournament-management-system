import java.util.*;
class football_scoreboard
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of teams");
        int n=sc.nextInt();
        sc.nextLine();
        String teams[]=new String[n];
        System.out.println("enter team names");
        for(int i=0;i<n;i++)
            teams[i]=sc.nextLine();
        System.out.println("choose tournament format");
        System.out.println("enter 1 for round robin format and 2 for knockout format");
        int choice=sc.nextInt();
        System.out.println();
        int points[]=new int[n];
        int matches[]=new int[n];
        int goalsf[]=new int[n];
        int goalsa[]=new int[n];
        int wins[]=new int[n];
        int losses[]=new int[n];
        int draws[]=new int[n];
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
        switch(choice)
        {
            case 1:
                {
                    if(n%2!=0)
                    {
                        String newTeams[]=new String[n+1];
                        for(int i=0;i<n;i++)
                            newTeams[i]=teams[i];
                        newTeams[n]="DUMMY";
                        teams=newTeams;
                        n=n+1;
                    }
                    points=new int[n];
                    matches=new int[n];
                    goalsf=new int[n];
                    goalsa=new int[n];
                    wins=new int[n];
                    losses=new int[n];
                    draws=new int[n];
                    int maxMatches=(n*(n-1))/2;
                    String team1[]=new String[maxMatches];
                    String team2[]=new String[maxMatches];
                    String arr[]=teams.clone();
                    int k=0;
                    int rounds=n-1;
                    k=0;
                    System.out.println();
                    System.out.println("======== FIXTURES ========");
                    for(int r=0;r<rounds;r++)
                    {
                        for(int i=0;i<n/2;i++)
                        {
                            String t1=arr[i];
                            String t2=arr[n-1-i];
                            if(!(t1.equals("DUMMY") || t2.equals("DUMMY")))
                            {
                                System.out.println(t1+" vs "+t2);
                                team1[k]=t1;
                                team2[k]=t2;
                                k++;
                            }
                        }
                        String last=arr[n-1];
                        for(int i=n-1;i>1;i--)
                            arr[i]=arr[i-1];
                        arr[1]=last;
                    }
                    System.out.println();
                    System.out.println("======== ENTER MATCH RESULTS ========");
                    for(int z=0;z<k;z++)
                    {
                        String t1=team1[z];
                        String t2=team2[z];
                        int i=-1,j=-1;
                        for(int x=0;x<n;x++)
                        {
                            if(teams[x].equals(t1))
                                i=x;
                            if(teams[x].equals(t2))
                                j=x;
                        }
                        System.out.println("Match : "+t1+" vs "+t2);
                        System.out.println("enter goals scored by team "+t1);
                        int score1=sc.nextInt();
                        System.out.println("enter goals scored by team "+t2);
                        int score2=sc.nextInt();
                        matches[i]++;
                        matches[j]++;
                        goalsf[i]+=score1;
                        goalsa[i]+=score2;
                        goalsf[j]+=score2;
                        goalsa[j]+=score1;
                        if(score1>score2)
                        {
                            System.out.println("winner of the match is team "+t1);
                            points[i]+=3;
                            wins[i]++;
                            losses[j]++;
                            System.out.println();
                        }
                        else if(score2>score1)
                        {
                            System.out.println("winner of the match is team "+t2);
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
                        System.out.println();
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

                                int d=draws[j];
                                draws[j]=draws[j+1];
                                draws[j+1]=d;
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("                                        SCOREBOARD");
                    for(int i=0;i<n;i++)
                    {
                        if(teams[i].equals("DUMMY"))
                        continue;
                        String name=teams[i];
                        int space=15-name.length();
                        int gd=goalsf[i]-goalsa[i];
                        System.out.print((i+1)+". Team "+name);
                        for(int p=0;p<space;p++)
                            System.out.print(" ");
                        System.out.println("Matches : "+matches[i]+"  Wins : "+wins[i]+"  Losses : "+losses[i]+"  Draws : "+draws[i]+"  G/F : "+goalsf[i]+"  G/A : "+goalsa[i]+"  G/D : "+gd+"  Points : "+points[i]);
                    }
                    break;
                }
            case 2:
                {
                    if(n%2!=0) 
                    {
                        System.out.println("knockout requires even number of teams");
                        return;
                    }
                    int round=1;
                    while(n>1) 
                    {
                        System.out.println("======== ROUND "+round+" FIXTURES ========");
                        String m1[]=new String[n/2];
                        String m2[]=new String[n/2];
                        int idx=0;
                        for(int i=0;i<n;i+=2)
                        {
                            m1[idx]=teams[i];
                            m2[idx]=teams[i+1];
                            System.out.println(m1[idx]+" vs "+m2[idx]);
                            idx++;
                        }
                        System.out.println("======== ENTER MATCH RESULTS ========");
                        String winners[]=new String[idx];
                        int k=0;
                        for(int i=0;i<idx;i++)
                        {
                            String t1=m1[i];
                            String t2=m2[i];
                            System.out.println("Match : "+t1+ " vs " +t2);
                            System.out.println("enter goals scored by "+t1);
                            int s1=sc.nextInt();
                            System.out.println("enter goals scored by "+t2);
                            int s2=sc.nextInt();
                            while(s1==s2) 
                            {
                                System.out.println("the match went to penalties.enter penalty scores");
                                System.out.println("enter goals scored by "+t1);
                                s1=sc.nextInt();
                                System.out.println("enter goals scored by "+t2);
                                s2=sc.nextInt();
                            }
                            if(s1 > s2) 
                            {
                                winners[k]=t1;
                                if(n==2)
                                System.out.println(t1+" won the tournament");
                                else if(n==4)
                                System.out.println(t1+" qualified for the final round and "+t2+" got disqualified");
                                else if(n==8)
                                System.out.println(t1+" qualified for the semi final round and "+t2+" got disqualified");
                                else if(n==16)
                                System.out.println(t1+" qualified for the quarter final round and "+t2+" got disqualified");
                                else if(n==32)
                                System.out.println(t1+" qualified for the round of 16 and "+t2+" got disqualified");
                                else
                                System.out.println(t1+" qualified for the next round and "+t2+" got disqualified");
                                System.out.println();
                            } 
                            else 
                            {
                                winners[k]=t2;
                                if(n==2)
                                System.out.println(t2+" won the tournament");
                                else if(n==4)
                                System.out.println(t2+" qualified for the final round and "+t1+" got disqualified");
                                else if(n==8)
                                System.out.println(t2+" qualified for the semi final round and "+t1+" got disqualified");
                                else if(n==16)
                                System.out.println(t2+" qualified for the quarter final round and "+t1+" got disqualified");
                                else if(n==32)
                                System.out.println(t2+" qualified for the round of 16 and "+t1+" got disqualified");
                                else
                                System.out.println(t2+" qualified for the next round and "+t1+" got disqualified");
                                System.out.println();
                            }
                            k++;
                        }
                        teams=winners;
                        n=teams.length;
                        round++;
                    }
                    System.out.println();
                    System.out.println("WINNERS OF THE TOURNAMENT : team " + teams[0]);
                    break;
                }
            default:
                System.out.println("invalid choice");
        }
    }
}
